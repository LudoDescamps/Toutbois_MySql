/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

/**
 *
 * @author Tsoutsou
 */
public class Societe {
    String nom;
    String prenom;
    String numRueAdresse;
    private String cp;
    private String ville;
    private String pays;
    private String telephone;
    private String telephonePortable;
    private String fax;
    private String email;
    private String cedex;
    private String complementAdresse;

    public Societe(String nom, String prenom, String numRueAdresse, String cp, String ville, String pays, String telephone, String telephonePortable, String fax, String email, String cedex, String complementAdresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.numRueAdresse = numRueAdresse;
        this.cp = cp;
        this.ville = ville;
        this.pays = pays;
        this.telephone = telephone;
        this.telephonePortable = telephonePortable;
        this.fax = fax;
        this.email = email;
        this.cedex = cedex;
        this.complementAdresse = complementAdresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumRueAdresse() {
        return numRueAdresse;
    }

    public void setNumRueAdresse(String numRueAdresse) {
        this.numRueAdresse = numRueAdresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephonePortable() {
        return telephonePortable;
    }

    public void setTelephonePortable(String telephonePortable) {
        this.telephonePortable = telephonePortable;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getCedex() {
        return cedex;
    }

    public void setCedex(String cedex) {
        this.cedex = cedex;
    }

    public String getComplementAdresse() {
        return complementAdresse;
    }

    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }

    

    @Override
    public String toString() {
        return nom + prenom + numRueAdresse + ", cp=" + cp + ", ville=" + ville + ", pays=" + pays + ", telephone=" + telephone + ", telephonePortable=" + telephonePortable + ", fax=" + fax + ", email=" + email + '}';
    }

    
}
