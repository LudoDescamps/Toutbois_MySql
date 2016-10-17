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
    
    private static int cptProspect = 0;
    private String enseigneProspect;
    private int idProspect;
    private String representant;
    private String derniereProspectionDate;
        private String siret;

    public Prospect(String enseigneProspect, int idProspect, String representant, String derniereProspectionDate,String siret, String nom, String prenom, String numRueAdresse, String cp, String ville, String pays, String telephone, String telephonePortable, String fax, String email, String cedex, String complementAdresse) {
        super(nom, prenom, numRueAdresse, cp, ville, pays, telephone, telephonePortable, fax, email, cedex, complementAdresse);
        this.enseigneProspect = enseigneProspect;
        this.representant = representant;
        this.derniereProspectionDate = derniereProspectionDate;
        this.siret = siret;
        Prospect.cptProspect ++;
        this.idProspect=Prospect.cptProspect;
        
    }
    public Prospect (){
        
    }
    public String getEnseigneProspect() {
        return enseigneProspect;
    }

    public void setEnseigneProspect(String enseigneProspect) {
        this.enseigneProspect = enseigneProspect;
    }

    public int getIdProspect() {
        return idProspect;
    }

    public void setIdProspect(int idProspect) {
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

    public static int getCptProspect() {
        return cptProspect;
    }

    public static void setCptProspect(int cptProspect) {
        Prospect.cptProspect = cptProspect;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    @Override
    public String toString() {
        return "Prospect{" + "enseigneProspect=" + enseigneProspect + ", idProspect=" + idProspect + ", representant=" + representant + ", derniereProspectionDate=" + derniereProspectionDate + ", siret=" + siret + '}';
    }
    

    
}