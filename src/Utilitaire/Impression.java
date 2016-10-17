/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

import java.io.*;



public class Impression{
  public final static String NAV = "rundll32 url.dll,FileProtocolHandler";
  
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
    

    
   
  public void imprimer(String tabChaineSaisie[]) {
      
        for (int i=0; i<tabChaineSaisie.length; i++) {
           System.out.println (tabChaineSaisie[i]+" de la classe impression");
           
           //On récupere les valeurs du tableau pour instancier les variables
           nomSociete = tabChaineSaisie[0];
           identifiant = tabChaineSaisie[1];
           adresseNumeroRue = tabChaineSaisie[2];
           adresseComplement = tabChaineSaisie[3];
           adresseCP = tabChaineSaisie[4];
           adresseVille = tabChaineSaisie[5];
           adresseCedex = tabChaineSaisie[6];
           adressePays = tabChaineSaisie[7];
           contactNom = tabChaineSaisie[8];
           contactPrenom = tabChaineSaisie[9];
           contactTelephone1 = tabChaineSaisie[10];
           contactTelephone2 = tabChaineSaisie[11];
           ContactFax = tabChaineSaisie[12];
           contactEmail = tabChaineSaisie[13];
           complementTauxCommission = tabChaineSaisie[17];
           complementSalaireFixeBrut = tabChaineSaisie[16];
           complementSiret = tabChaineSaisie[14];
           complementRepresentant = tabChaineSaisie[15];
           informationCommercialeCommande = tabChaineSaisie[18];
           derniereProspectionDate = tabChaineSaisie[19];
           menu = tabChaineSaisie[20];
           
        } 
        
        char infoMenu = menu.charAt(0);
        
        
        if (infoMenu == 'c') {          //Impression fiche CLIENT
            try {
                File tmpFile = File.createTempFile("Impression", ".html");
                String filePath = tmpFile.getCanonicalPath();
                FileOutputStream fos = new FileOutputStream(tmpFile);
                PrintStream  doc = new PrintStream(fos);
                doc.println("<HTML><head><title>Fiche client</title></head>");
                doc.println("<body>");
                doc.println("<h1>Société "+ nomSociete +"</h1>");
                doc.println("<p>Identifiant client : "+identifiant);
                doc.println("<p>SIRET : "+complementSiret);
                doc.println("<p><U><b>Adresse :</b></U>");
                doc.println("<p>"+adresseNumeroRue);
                if (adresseComplement.isEmpty()){          //Si Complement adresse n'est pas renseigné
                }else{
                   doc.println("<p>" + adresseComplement); 
                }   
                doc.println("<p>"+adresseCP + " "+adresseVille);
                if (adresseCedex.isEmpty() ){               //Si Cedex n'est pas renseigné
                }else{
                   doc.println("<p>" + adresseCedex); 
                }   
                doc.println("<p><U><b>Contact :</b></U>");
                doc.println("<p>Nom : "+contactNom);
                doc.println("<p>Prénom : "+contactPrenom);
                doc.println("<p>Téléphone : "+contactTelephone1);
                if (contactTelephone2.isEmpty()){           //Si Telephone2 n'est pas renseigné
                }else{
                    doc.println("<p>Téléphone : "+contactTelephone2);
                }
                if (ContactFax.isEmpty()){                  //si Fax n'est pas renseigné
                }else{
                    doc.println("<p>Fax : "+ContactFax);
                }
                doc.println("<p>E-Mail : "+contactEmail);
                doc.println("<p><U><b>Informations commerciales :</b></U>");
                doc.println("<p>Représentant : "+complementRepresentant);
                doc.println("<p>Nb total de commandes : "+informationCommercialeCommande);
                                
                doc.println("</body></Html>");
                doc.flush(); doc.close();
                fos.close();

                Runtime run = Runtime.getRuntime();
                run.exec(NAV + " " + filePath);
                //run.wait(50); // Time to run navigator before removing file.
                tmpFile.deleteOnExit();
            } catch (Exception e) {
                 e.printStackTrace();
              }
        }
        else if (infoMenu == 'r') {          //Impression fiche REPRESENTANT
            try {
                File tmpFile = File.createTempFile("Impression", ".html");
                String filePath = tmpFile.getCanonicalPath();
                FileOutputStream fos = new FileOutputStream(tmpFile);
                PrintStream  doc = new PrintStream(fos);
                doc.println("<HTML><head><title>Fiche représentant</title></head>");
                doc.println("<body>");
                doc.println("<h1>Représentant : "+ nomSociete +"</h1>");
                doc.println("<p>Nom : "+contactNom);
                doc.println("<p>Prénom : "+contactPrenom);
                doc.println("<p>Identifiant représentant : "+identifiant);
                doc.println("<p><U><b>Adresse :</b></U>");
                doc.println("<p>"+adresseNumeroRue);
                if (adresseComplement.isEmpty()){          //Si Complement adresse n'est pas renseigné
                }else{
                   doc.println("<p>" + adresseComplement); 
                }   
                doc.println("<p>"+adresseCP + " "+adresseVille);
                if (adresseCedex.isEmpty() ){               //Si Cedex n'est pas renseigné
                }else{
                   doc.println("<p>" + adresseCedex); 
                }   
                doc.println("<p><U><b>Contact :</b></U>");
                doc.println("<p>Téléphone : "+contactTelephone1);
                if (contactTelephone2.isEmpty()){           //Si Telephone2 n'est pas renseigné
                }else{
                    doc.println("<p>Téléphone : "+contactTelephone2);
                }
                if (ContactFax.isEmpty()){                  //si Fax n'est pas renseigné
                }else{
                    doc.println("<p>Fax : "+ContactFax);
                }
                doc.println("<p>E-Mail : "+contactEmail);
                doc.println("<p><U><b>Complément :</b></U>");
                doc.println("<p>Taux de commission : "+complementTauxCommission+" %");
                doc.println("<p>Salaire fixe brut : "+complementSalaireFixeBrut+" €");
                                
                doc.println("</body></Html>");
                doc.flush(); doc.close();
                fos.close();

                Runtime run = Runtime.getRuntime();
                run.exec(NAV + " " + filePath);
                //run.wait(50); // Time to run navigator before removing file.
                tmpFile.deleteOnExit();
            } catch (Exception e) {
                 e.printStackTrace();
              }
        }
        else if (infoMenu == 'p') {          //Impression fiche PROSPECT
            try {
                File tmpFile = File.createTempFile("Impression", ".html");
                String filePath = tmpFile.getCanonicalPath();
                FileOutputStream fos = new FileOutputStream(tmpFile);
                PrintStream  doc = new PrintStream(fos);
                doc.println("<HTML><head><title>Fiche prospect</title></head>");
                doc.println("<body>");
                doc.println("<h1>Société "+ nomSociete +"</h1>");
                doc.println("<p>Identifiant prospect : "+identifiant);
                doc.println("<p>SIRET : "+complementSiret);
                doc.println("<p><U><b>Adresse :</b></U>");
                doc.println("<p>"+adresseNumeroRue);
                if (adresseComplement.isEmpty()){          //Si Complement adresse n'est pas renseigné
                }else{
                   doc.println("<p>" + adresseComplement); 
                }   
                doc.println("<p>"+adresseCP + " "+adresseVille);
                if (adresseCedex.isEmpty() ){               //Si Cedex n'est pas renseigné
                }else{
                   doc.println("<p>" + adresseCedex); 
                }   
                doc.println("<p><U><b>Contact :</b></U>");
                doc.println("<p>Nom : "+contactNom);
                doc.println("<p>Prénom : "+contactPrenom);
                doc.println("<p>Téléphone : "+contactTelephone1);
                if (contactTelephone2.isEmpty()){           //Si Telephone2 n'est pas renseigné
                }else{
                    doc.println("<p>Téléphone : "+contactTelephone2);
                }
                if (ContactFax.isEmpty()){                  //si Fax n'est pas renseigné
                }else{
                    doc.println("<p>Fax : "+ContactFax);
                }
                doc.println("<p>E-Mail : "+contactEmail);
                doc.println("<p><U><b>Informations commerciales :</b></U>");
                doc.println("<p>Représentant : "+complementRepresentant);
                doc.println("<p>Dernière prospection le : "+derniereProspectionDate);
                                
                doc.println("</body></Html>");
                doc.flush(); doc.close();
                fos.close();

                Runtime run = Runtime.getRuntime();
                run.exec(NAV + " " + filePath);
                //run.wait(50); // Time to run navigator before removing file.
                tmpFile.deleteOnExit();
            } catch (Exception e) {
                 e.printStackTrace();
              }
        }
        else{
            try {
                File tmpFile = File.createTempFile("Impression", ".html");
                String filePath = tmpFile.getCanonicalPath();
                FileOutputStream fos = new FileOutputStream(tmpFile);
                PrintStream  doc = new PrintStream(fos);
                doc.println("<HTML><head><title>Fiche</title></head>");
                doc.println("<body>");
                doc.println("<h1>"+ "Erreur" +"</h1>");
                doc.println("<p><U><b>Aucun menu n'est selectionné</b></U>");
                doc.println("</body></Html>");
                doc.flush(); doc.close();
                fos.close();

                Runtime run = Runtime.getRuntime();
                run.exec(NAV + " " + filePath);
                //run.wait(50); // Time to run navigator before removing file.
                tmpFile.deleteOnExit();
            } catch (Exception e) {
                 e.printStackTrace();
                }
        }
    }
}