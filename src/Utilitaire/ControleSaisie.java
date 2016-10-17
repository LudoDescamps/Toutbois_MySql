/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author ldescamps
 */
public class ControleSaisie {
    
    private int longueur;
    private boolean validationLongueur;
    private boolean validationNonVide;
    private boolean validationCP;
    private String cp;
    private String eMail;
    private boolean validationEMail;
    private String telephone;
    boolean validationTelephoneFrance;
    private String valeurATesterFloat;
    private boolean validationValeurFloat;
    private String valeurATesterInt;
    private boolean validationValeurInt;
    private String siret;
    private boolean validationSiret;
    private String[] date;
    private boolean validationDate;
        
    
    //Méthode controle longueur d'un champ
    public void ctrlLongueur() {
        try {
            if ((longueur > 2) && (longueur < 30)) {
                validationLongueur = true;
                System.out.println("validationLongueur vrai");
            } else {
                validationLongueur = false;
                System.out.println("validationLongueur fausse");
            }
        } catch (Exception e) {

        }
    }
    
    //Méthode controle champ vide
    public void ctrlNonVide() {
        try {
            if (longueur > 0) {
                validationNonVide = true;
                System.out.println("validationNonVide vrai");
            } else {
                validationNonVide = false;
                System.out.println("validationNonVide fausse");
            }
        } catch (Exception e) {

        }
    }
    
    public void ctrlCodePostal() {
        try {
            validationCP = Pattern.matches("((^(([0-8][0-9])|(9[0-5]))[0-9]{3}$))", cp);
        } catch (Exception e) {
        }
    }
    
    public void ctrlEMail() {
        try {
            validationEMail = Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", eMail);
        } catch (Exception e) {
        }
    }
    
    public void ctrlTelephoneFrance(){
        try {
            validationTelephoneFrance = Pattern.matches("^(0|(00|\\+)33)[0-9]{9}$", telephone);
        }catch (Exception e) {            
        }
    }
    
    public void ctrlValeurFloat(){
        try {
            float valeurATesterFloat = Float.parseFloat(this.valeurATesterFloat) ;
            validationValeurFloat = true;
        }catch (Exception e){
            validationValeurFloat = false;
        }
    }
    
        public void ctrlValeurInt(){
        try {
            int valeurATesterInt = Integer.parseInt(this.valeurATesterInt);
            validationValeurInt = true;
        }catch (Exception e){
            validationValeurInt = false;
        }
    }
    
    public boolean ctrlDate(String dateAVerifier) {
        
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        String date1 = dateAVerifier;
        try {
            date = sdf.parse(date1);
            System.out.println(date);
            //date = simpleDateFormat.parse(date2);
            //System.out.println(date);
            } 
        catch (ParseException e) 
            {
            System.out.println("La date est fausse : "+ date);    
            return false ;
            }
    return true ;
    // Fermeture de la fonction sidatebonne
    }
    
    public void ctrlSiret(){
        try {
            validationSiret = Pattern.matches("^[0-9]{14}$", siret);
        }catch (Exception e) {            
        }
    }
    
    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public boolean isValidationLongueur() {
        return validationLongueur;
    }

    public boolean isValidationNonVide() {
        return validationNonVide;
    }

    public boolean isValidationCP() {
        return validationCP;
    }

    
    public void setCp(String cp) {
        this.cp = cp;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public boolean isValidationEMail() {
        return validationEMail;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isValidationTelephoneFrance() {
        return validationTelephoneFrance;
    }

    public void setValeurATester(String valeurATester) {
        this.valeurATesterFloat = valeurATester;
    }

    public boolean isValidationValeurFloat() {
        return validationValeurFloat;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public boolean isValidationSiret() {
        return validationSiret;
    }

      public void setValeurATesterFloat(String valeurATesterFloat) {
        this.valeurATesterFloat = valeurATesterFloat;
    }

    public String getValeurATesterInt() {
        return valeurATesterInt;
    }

    public void setValeurATesterInt(String valeurATesterInt) {
        this.valeurATesterInt = valeurATesterInt;
    }

    public boolean isValidationValeurInt() {
        return validationValeurInt;
    }

    public void setValidationValeurInt(boolean validationValeurInt) {
        this.validationValeurInt = validationValeurInt;
    }

    public String[] getDate() {
        return date;
    }

    public void setDate(String[] args) {
        this.date = args;
    }

    public boolean isValidationDate() {
        return validationDate;
    }

    public void setValidationDate(boolean validationDate) {
        this.validationDate = validationDate;
    }

     
    
    
}
