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
public class Prospect extends Societe {
    
    private String enseigneProspect;
    private String idProspect;
    private String representant;
    private String derniereProspectionDate;

    public Prospect(String enseigneProspect, String idProspect, String representant, String derniereProspectionDate, String nom, String prenom, String numRueAdresse, String complementAdresse, String cp, String ville, String cedex, String pays, String telephone1, String telephone2, String fax, String email) {
        super(nom, prenom, numRueAdresse, complementAdresse, cp, ville, cedex, pays, telephone1, telephone2, fax, email);
        this.enseigneProspect = enseigneProspect;
        this.idProspect = idProspect;
        this.representant = representant;
        this.derniereProspectionDate = derniereProspectionDate;
    }

    public String getEnseigneProspect() {
        return enseigneProspect;
    }

    public void setEnseigneProspect(String enseigneProspect) {
        this.enseigneProspect = enseigneProspect;
    }

    public String getIdProspect() {
        return idProspect;
    }

    public void setIdProspect(String idProspect) {
        this.idProspect = idProspect;
    }

    public String getRepresentant() {
        return representant;
    }

    public void setRepresentant(String representant) {
        this.representant = representant;
    }

    public String getDerniereProspectionDate() {
        return derniereProspectionDate;
    }

    public void setDerniereProspectionDate(String derniereProspectionDate) {
        this.derniereProspectionDate = derniereProspectionDate;
    }

    @Override
    public String toString() {
        return enseigneProspect + "|" + idProspect + "|" + representant + "|" + derniereProspectionDate + "|"+super.toString();
    }
    
}
