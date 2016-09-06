/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

import IHM.RepCliProspOLD;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author ldescamps
 */
public class Sauvegarde {
    
    String [] rep;
    private String nomSociete;
    private String identifiant;
    private String adresseNumeroRue;
    private String adresseComplement;
    private String adresseCP;
    private String adresseVille;
    private String adresseCedex;
    private String adressePays;
    private String contactNom;
    private String contactPrenom;
    private String contactTelephone1;
    private String contactTelephone2;
    private String ContactFax;
    private String contactEmail;
    private String complementTauxCommission;
    private String complementSalaireFixeBrut;
    private String complementSiret;
    private String complementRepresentant;
    private String informationCommercialeCommande;
    private String derniereProspectionDate;
    private String menu;
    
    private String idRepresentant;
    private String enseigneClient;
    private String idClient;
    
    public String[] getRep() {
        return rep;
    }

    public void setRep(String[] rep) {
        this.rep = rep;
    }
    
    public void sauvegarder(String [] rep) {
        
        for (int i=0; i<rep.length; i++) {
           System.out.println (rep[i]+" de la classe sauvegarde");
           
         /*  //On récupere les valeurs du tableau pour instancier les variables
           nomSociete = representant[0];
           identifiant = representant[1];
           adresseNumeroRue = representant[2];
           adresseComplement = representant[3];
           adresseCP = representant[4];
           adresseVille = representant[5];
           adresseCedex = representant[6];
           adressePays = representant[7];
           contactNom = representant[8];
           contactPrenom = representant[9];
           contactTelephone1 = representant[10];
           contactTelephone2 = representant[11];
           ContactFax = representant[12];
           contactEmail = representant[13];
           complementTauxCommission = representant[17];
           complementSalaireFixeBrut = representant[16];
           complementSiret = representant[14];
           complementRepresentant = representant[15];
           informationCommercialeCommande = representant[18];
           derniereProspectionDate = representant[19];
           menu = representant[20];
           
        } 
        
        char infoMenu = menu.charAt(0);
   
        
        
        
        
        try {
            FileWriter fw = new FileWriter("Backup.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            PrintWriter pw = new PrintWriter(bw);
            pw.print(representant.toString());
            for (int i=0; i<getRepresentant().length; i++) {
           System.out.println (getRepresentant()[i]+" de la classe sauvegarde");
            }
            System.out.println(getRepresentant().toString());
            pw.close();
        } catch (IOException e) {
            System.out.println(" Problème à l’écriture du fichier ");
            System.exit(0);*/
        }
        showMessageDialog(null, "Sauvegarde effectuée", "Backup", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
