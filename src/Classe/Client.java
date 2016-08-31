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
public class Client extends Societe {
    
    private String enseigneClient;
    private String idClient;
    private String siret;
    private String nombreCommandePassees;

    public Client(String enseigneClient, String idClient, String siret, String nombreCommandePassees, String nom, String prenom, String numRueAdresse, String cp, String ville, String pays, String telephone, String telephonePortable, String fax, String email) {
        super(nom, prenom, numRueAdresse, cp, ville, pays, telephone, telephonePortable, fax, email);
        this.enseigneClient = enseigneClient;
        this.idClient = idClient;
        this.siret = siret;
        this.nombreCommandePassees = nombreCommandePassees;
    }

    public Client() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEnseigneClient() {
        return enseigneClient;
    }

    public void setEnseigneClient(String enseigneClient) {
        this.enseigneClient = enseigneClient;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getNombreCommandePassees() {
        return nombreCommandePassees;
    }

    public void setNombreCommandePassees(String nombreCommandePassees) {
        this.nombreCommandePassees = nombreCommandePassees;
    }

    @Override
    public String toString() {
        return super.toString()+"Client{" + "enseigneClient=" + enseigneClient + ", idClient=" + idClient + ", siret=" + siret + ", nombreCommandePassees=" + nombreCommandePassees + '}';
    }
    

    
}
