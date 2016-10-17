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

    private static int cptClient;
    private int idClient;
    private String enseigneClient;
    private String siret;
    private String nombreCommandePassees;
    private String representant;

   

    public Client(String enseigneClient, int idClient, String siret, String nombreCommandePassees,String representant, String nom,
            String prenom, String numRueAdresse, String cp, String ville, String pays, String telephone,
            String telephonePortable, String fax, String email, String cedex, String complementAdresse) {
        super(nom, prenom, numRueAdresse, cp, ville, pays, telephone, telephonePortable, fax, email, cedex, complementAdresse);
        this.enseigneClient = enseigneClient;
        this.siret = siret;
        this.nombreCommandePassees = nombreCommandePassees;
        this.representant = representant;
        Client.cptClient ++;
        this.idClient = Client.cptClient;
    }
    public Client (){
    
    }

    public static int getCptClient() {
        return cptClient;
    }

    public static void setCptClient(int cptClient) {
        Client.cptClient = cptClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getEnseigneClient() {
        return enseigneClient;
    }

    public void setEnseigneClient(String enseigneClient) {
        this.enseigneClient = enseigneClient;
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

    public String getRepresentant() {
        return representant;
    }

    public void setRepresentant(String representant) {
        this.representant = representant;
    }
    
    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", enseigneClient=" + enseigneClient + ", siret=" + siret + ", nombreCommandePassees=" + nombreCommandePassees + " représentant "+representant +'}';
    }

    
    
}
