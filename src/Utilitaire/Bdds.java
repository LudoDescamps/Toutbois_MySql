/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

import Classe.Client;
import Classe.Prospect;
import Classe.Representant;
import Classe.Societe;
import static IHM.RepCliProsp.client;
import static IHM.RepCliProsp.pro;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static IHM.RepCliProsp.r;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author jpaul
 */
public class Bdds {

    public static void lireBdd(char typetable, String nomtable) throws SQLException {
        //MySQLCli mysqlCli = new MySQLCli("//localhost/toutbois", "root", "");         //Connection locale
        MySQLCli mysqlCli = new MySQLCli("//clustermysql07.hosteur.com/toutbois", "ludo_bdd", "LudoToutBois01234");           //Connection serveur distant

        if (mysqlCli.connect()) {
            switch (typetable) {
                case 'r':
                    try {
                        ResultSet rs = mysqlCli.exec("SELECT * "
                                + "FROM representant,societe "
                                + "WHERE representant.idSociete = societe.idSociete ");
                        if (rs != null) {
                            while (rs.next()) {
                                System.out.println("numRep: " + rs.getInt(1) + " nom = " + rs.getString(3) + " salaire fixe = " + rs.getString(4)
                                        + " taux de commission = " + rs.getString(5));
                                System.out.println("position: " + rs.getInt(2) + " nom = " + rs.getString(3) + " prenom = " + rs.getString(4)
                                        + " adresse = " + rs.getString(5));
                                Representant rep = new Representant();
                                rep.setIdRepresentant(rs.getInt(1));
                                rep.setNomRepresentant(rs.getString(3));
                                rep.setSalaireFixe(rs.getString(4));
                                rep.setTauxCommission(rs.getString(5));
                                rep.setNom(rs.getString(7));
                                rep.setPrenom(rs.getString(8));
                                rep.setNumRueAdresse(rs.getString(9));
                                rep.setComplementAdresse(rs.getString(10));
                                rep.setCp(rs.getString(11));
                                rep.setVille(rs.getString(12));
                                rep.setCedex(rs.getString(13));
                                rep.setPays(rs.getString(14));
                                rep.setTelephone(rs.getString(15));
                                rep.setTelephonePortable(rs.getString(16));
                                rep.setFax(rs.getString(17));
                                rep.setEmail(rs.getString(18));
                                r.add(rep);
                                System.out.println(rep);
                            }
                            rs = mysqlCli.exec("SELECT max(idSociete) FROM societe");
                            rs.next();
                            System.out.println(rs.getInt(1) + " -->rs.getInt(1) lecture representant");
                            Societe.setCptSociete(rs.getInt(1));
                            System.out.println(Societe.getCptSociete() + " -->Societe.getCptSociete()lecture representant");
                            rs = mysqlCli.exec("SELECT max(idRepresentant) FROM representant");
                            rs.next();
                            System.out.println(rs.getInt(1) + " -->rs.getInt(1) cpt rep lecture representant");
                            Representant.setCptRep(rs.getInt(1));
                            System.out.println(Representant.getCptRep() + " -->Representant.getCptRep()cpt rep lecture representant");

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(MySQLCli.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    for (int i = 0; i < r.size(); i++) {
                        Representant monRep = r.get(i);
                        System.out.println("Numero = " + monRep.getIdRepresentant() + " Nom = " + monRep.getNomRepresentant() + " salaire fixe = " + monRep.getSalaireFixe()
                                + " taux de commission = " + monRep.getTauxCommission());
                        System.out.println("array list représentant "+r.get(i).toString());
                    }
                    
                    break;

                case 'c':
                    try {
                        ResultSet rs = mysqlCli.exec("SELECT * "
                                + "FROM client,societe "
                                + "WHERE client.idSociete = societe.idSociete ");
                        System.out.println(rs.toString() + "test");

                        if (rs != null) {
                            while (rs.next()) {
                                System.out.println("numClient: " + rs.getInt(1) + " enseigne = " + rs.getString(3) + " SIRET = " + rs.getString(4)
                                        + " nbr de commandes passees = " + rs.getString(5) + " nom du representant = " + rs.getString(6));
                                System.out.println("position societe bdd client: " + rs.getInt(2) + " position societe bdd societe: " + rs.getInt(7)
                                        + " nom du contact = " + rs.getString(8) + " prenom du contact = " + rs.getString(9) + " adresse = " + rs.getString(10));
                                Client cli = new Client();
                                cli.setIdClient(rs.getInt(1));
                                cli.setEnseigneClient(rs.getString(3));
                                cli.setSiret(rs.getString(4));
                                cli.setNombreCommandePassees(rs.getString(5));
                                cli.setRepresentant(rs.getString(6));
                                cli.setNom(rs.getString(8));
                                cli.setPrenom(rs.getString(9));
                                cli.setNumRueAdresse(rs.getString(10));
                                cli.setComplementAdresse(rs.getString(11));
                                cli.setCp(rs.getString(12));
                                cli.setVille(rs.getString(13));
                                cli.setCedex(rs.getString(14));
                                cli.setPays(rs.getString(15));
                                cli.setTelephone(rs.getString(16));
                                cli.setTelephonePortable(rs.getString(17));
                                cli.setFax(rs.getString(18));
                                cli.setEmail(rs.getString(19));
                                client.add(cli);
                                System.out.println(cli);
                            }
                            rs = mysqlCli.exec("SELECT max(idSociete) FROM societe");
                            rs.next();
                            System.out.println(rs.getInt(1) + " -->rs.getInt(1)lecture client");
                            Societe.setCptSociete(rs.getInt(1));
                            System.out.println(Societe.getCptSociete() + " -->Societe.getCptSociete()lecture client");
                           
                            rs = mysqlCli.exec("SELECT max(idClient) FROM client");
                            rs.next();
                            System.out.println(rs.getInt(1) + " -->rs.getInt(1) cpt client lecture client");
                            Client.setCptClient(rs.getInt(1));
                            System.out.println(Client.getCptClient()+ " -->Client.getCptClient()cpt cli lecture client");
                            
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(MySQLCli.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    for (int i = 0; i < client.size(); i++) {
                        Client monCli = client.get(i);
                        System.out.println("Numero = " + monCli.getIdClient() + " Nom = " + monCli.getEnseigneClient());
                    }
                    break;

                case 'p':
                    try {
                        ResultSet rs = mysqlCli.exec("SELECT * "
                                + "FROM prospect,societe "
                                + "WHERE prospect.idSociete = societe.idSociete ");
                        System.out.println(rs.toString() + "test");

                        if (rs != null) {
                            while (rs.next()) {
                                System.out.println("numProsp: " + rs.getInt(1) + " enseigne = " + rs.getString(3) + " Siret = " + rs.getString(4)
                                        + " nbr de commandes passées = " + rs.getString(5) + " nom du representant = " + rs.getString(6));
                                System.out.println("position societe bdd societe: " + rs.getInt(7) + " position societe bdd prospect: " + rs.getInt(2)
                                        + " nom du contact = " + rs.getString(3) + " prenom du contact = " + rs.getString(4) + " adresse = " + rs.getString(5));
                                Prospect prosp = new Prospect();
                                prosp.setIdProspect(rs.getInt(1));
                                prosp.setEnseigneProspect(rs.getString(3));
                                prosp.setSiret(rs.getString(4));
                                prosp.setRepresentant(rs.getString(5));
                                prosp.setDerniereProspectionDate(rs.getString(6));
                                prosp.setNom(rs.getString(8));
                                prosp.setPrenom(rs.getString(9));
                                prosp.setNumRueAdresse(rs.getString(10));
                                prosp.setComplementAdresse(rs.getString(11));
                                prosp.setCp(rs.getString(12));
                                prosp.setVille(rs.getString(13));
                                prosp.setCedex(rs.getString(14));
                                prosp.setPays(rs.getString(15));
                                prosp.setTelephone(rs.getString(16));
                                prosp.setTelephonePortable(rs.getString(17));
                                prosp.setFax(rs.getString(18));
                                prosp.setEmail(rs.getString(19));
                                pro.add(prosp);
                                System.out.println(prosp);
                            }
                            rs = mysqlCli.exec("SELECT max(idSociete) FROM societe");
                            rs.next();
                            System.out.println(rs.getInt(1) + " -->rs.getInt(1)lecture prospect");
                            Societe.setCptSociete(rs.getInt(1));
                            System.out.println(Societe.getCptSociete() + " -->Societe.getCptSociete()lecture prospect");

                            rs = mysqlCli.exec("SELECT max(idProspect) FROM prospect");
                            rs.next();
                            System.out.println(rs.getInt(1) + " -->rs.getInt(1) cpt prospect lecture prospect");
                            Prospect.setCptProspect(rs.getInt(1));
                            System.out.println(Prospect.getCptProspect()+ " -->Prospect.getCptProspect()cpt prosp lecture prospect");
                            
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(MySQLCli.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    for (int i = 0; i < pro.size(); i++) {
                        Prospect monProsp = pro.get(i);
                       System.out.println("Numero  = " + monProsp.getIdProspect() + " Nom = " + monProsp.getEnseigneProspect());
                   }
                    break;
            }

        } else {
            System.out.println("Mysql connection failed !!!");
        }
        mysqlCli.close();
    }

    public static void ecrireBdd(char typetable) throws IOException {
        //MySQLCli mysqlCli = new MySQLCli("//localhost/toutbois", "root", "");     //Connection locale
        MySQLCli mysqlCli = new MySQLCli("//clustermysql07.hosteur.com/toutbois", "ludo_bdd", "LudoToutBois01234");       //Connection serveur distant
        if (mysqlCli.connect()) {

            switch (typetable) {
                case 'r':
                    int i = r.size();
                    i = i - 1;
                    System.out.println(i + " i de r.size");

                    Representant monRep = r.get(i);
                    System.out.println(monRep.getNomRepresentant());

                    try {
                        // Execution de la requête 

                        System.out.println("Passage dans la boucle ecrireBdd representant");

                        String queryRepresentant = "INSERT INTO `representant` (`idSociete`, `nomRepresentant`, `salaireFixeRepresentant`, `tauxCommissionRepresentant`) "
                                + "VALUES ('" + (Societe.getCptSociete() + 1) + "', '" + monRep.getNomRepresentant() + "', '" + monRep.getSalaireFixe() + "', '" + monRep.getTauxCommission() + "');";
                        System.out.println(queryRepresentant);
                        int nbMaj = mysqlCli.update(queryRepresentant);

                        String querySociete = "INSERT INTO `societe`"
                                + "VALUES ('" + (Societe.getCptSociete() + 1) + "','" + monRep.getNom() + "','" + monRep.getPrenom()
                                + "','" + monRep.getNumRueAdresse() + "','" + monRep.getComplementAdresse() + "','" + monRep.getCp()
                                + "','" + monRep.getVille() + "','" + monRep.getCedex() + "','" + monRep.getPays() + "','" + monRep.getTelephone()
                                + "','" + monRep.getTelephonePortable() + "','" + monRep.getFax() + "','" + monRep.getEmail() + "');";
                        System.out.println(querySociete);
                        int nbMajSociete = mysqlCli.update(querySociete);
                        showMessageDialog(null, "Sauvegarde représentant effectuée", "Backup", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception d) {
                        System.out.println("Probleme de requete dans ecrireBdd representant");
                    }
                    // fermeture de la connexion à la base 

                    break;
                
                case 'c':
                    int j = client.size();
                    j = j - 1;
                    System.out.println(j + " j de client.size");

                    Client monClient = client.get(j);
                    System.out.println(monClient.getEnseigneClient());

                    try {
                        // Execution de la requête 

                        System.out.println("Passage dans la boucle ecrireBdd client");

                        String queryClient = "INSERT INTO `client` (`idSociete`, `enseigneClient`, `siretClient`, `nbrCommandesClient`, `nomRepresentantClient`) "
                                + "VALUES ('" + (Societe.getCptSociete() + 1) + "', '" + monClient.getEnseigneClient()+ "', '" + monClient.getSiret() + "', '" + 
                                monClient.getNombreCommandePassees() + "', '" + monClient.getRepresentant() + "');";
                        System.out.println(queryClient);
                        int nbMaj = mysqlCli.update(queryClient);

                        String querySociete = "INSERT INTO `societe`"
                                + "VALUES ('" + (Societe.getCptSociete() + 1) + "','" + monClient.getNom() + "','" + monClient.getPrenom()
                                + "','" + monClient.getNumRueAdresse() + "','" + monClient.getComplementAdresse() + "','" + monClient.getCp()
                                + "','" + monClient.getVille() + "','" + monClient.getCedex() + "','" + monClient.getPays() + "','" + monClient.getTelephone()
                                + "','" + monClient.getTelephonePortable() + "','" + monClient.getFax() + "','" + monClient.getEmail() + "');";
                        System.out.println(querySociete);
                        int nbMajSociete = mysqlCli.update(querySociete);
                        showMessageDialog(null, "Sauvegarde client effectuée", "Backup", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception d) {
                        System.out.println("Probleme de requete dans ecrireBdd client");
                    }
                    // fermeture de la connexion à la base 

                    break;
                    
                case 'p':
                    int k = pro.size();
                    k = k - 1;
                    System.out.println(k + " k de pro.size");

                    Prospect monProspect = pro.get(k);
                    System.out.println(monProspect.getEnseigneProspect());

                    try {
                        // Execution de la requête 

                        System.out.println("Passage dans la boucle ecrireBdd prospect");

                        String queryProspect = "INSERT INTO `prospect` (`idSociete`, `enseigneProspect`, `siretProspect`, `nomRepresentantProspect`, `dateDerniereVisiteProspect`) "
                                + "VALUES ('" + (Societe.getCptSociete() + 1) + "', '" + monProspect.getEnseigneProspect()+ "', '" + monProspect.getSiret() + "', '" + 
                                monProspect.getRepresentant() + "', '" + monProspect.getDerniereProspectionDate() + "');";
                        System.out.println(queryProspect);
                        int nbMaj = mysqlCli.update(queryProspect);

                        String querySociete = "INSERT INTO `societe`"
                                + "VALUES ('" + (Societe.getCptSociete() + 1) + "','" + monProspect.getNom() + "','" + monProspect.getPrenom()
                                + "','" + monProspect.getNumRueAdresse() + "','" + monProspect.getComplementAdresse() + "','" + monProspect.getCp()
                                + "','" + monProspect.getVille() + "','" + monProspect.getCedex() + "','" + monProspect.getPays() + "','" + monProspect.getTelephone()
                                + "','" + monProspect.getTelephonePortable() + "','" + monProspect.getFax() + "','" + monProspect.getEmail() + "');";
                        System.out.println(querySociete);
                        int nbMajSociete = mysqlCli.update(querySociete);
                        showMessageDialog(null, "Sauvegarde prospect effectuée", "Backup", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception d) {
                        System.out.println("Probleme de requete dans ecrireBdd prospect");
                    }
                    // fermeture de la connexion à la base 

                    break;
            }
            mysqlCli.close();

        } else {
            System.out.println("Mysql connection failed !!!");
        }
    }

    public static void supprimerBdd(char typetable, int idASupprimer) throws SQLException {

        //MySQLCli mysqlCli = new MySQLCli("//localhost/toutbois", "root", "");         //Connection locale
        MySQLCli mysqlCli = new MySQLCli("//clustermysql07.hosteur.com/toutbois", "ludo_bdd", "LudoToutBois01234");           //Connection serveur distant
        if (mysqlCli.connect()) {

            switch (typetable) {
                case 'r':

                    System.out.println("id representant a supprimer classe Bdds = " + idASupprimer);
                    ResultSet rs = mysqlCli.exec("SELECT *  FROM `representant` WHERE `representant`.`idRepresentant` = " + idASupprimer);
                    int idSocieteASupprimer = 0;

                    System.out.println(rs + "ICI TEST");
                    while (rs.next()) {
                        idSocieteASupprimer = rs.getInt(2);         //recuperation de idSociete
                        System.out.println(idSocieteASupprimer);
                    }
                    try {
                        // Execution de la requête 

                        String queryRepresentant = "DELETE FROM `representant` "
                                + "WHERE `representant`.`idRepresentant` = " + idASupprimer + ";";
                        System.out.println(queryRepresentant);
                        int nbMaj = mysqlCli.update(queryRepresentant);

                        String querySociete = "DELETE FROM `societe` "
                                + "WHERE `societe`.`idSociete` = " + idSocieteASupprimer + ";";
                        System.out.println(querySociete);
                        int nbMajSociete = mysqlCli.update(querySociete);
                        showMessageDialog(null, "Représentant supprimé", "Suppression", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception d) {
                        System.out.println("Probleme de requete dans supprimerBdd representant");
                    }
                    break;

                case 'c':

                    System.out.println("id client a supprimer classe Bdds = " + idASupprimer);
                    ResultSet rs1 = mysqlCli.exec("SELECT *  FROM `client` WHERE `client`.`idclient` = " + idASupprimer);

                    idSocieteASupprimer = 0;
                    System.out.println(rs1 + "ICI TEST");
                    while (rs1.next()) {
                        idSocieteASupprimer = rs1.getInt("idSociete");      //recuperation de idSociete
                        System.out.println(idSocieteASupprimer);
                    }
                    try {
                        // Execution de la requête 

                        String queryClient = "DELETE FROM `client` "
                                + "WHERE `client`.`idClient` = " + idASupprimer + ";";
                        System.out.println(queryClient);
                        int nbMaj = mysqlCli.update(queryClient);

                        String querySociete = "DELETE FROM `societe` "
                                + "WHERE `societe`.`idSociete` = " + idSocieteASupprimer + ";";
                        System.out.println(querySociete);
                        int nbMajSociete = mysqlCli.update(querySociete);
                        showMessageDialog(null, "Client supprimé", "Suppression", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception d) {
                        System.out.println("Probleme de requete dans supprimerBdd client");
                    }
                    break;

                case 'p':

                    System.out.println("id prospect a supprimer classe Bdds = " + idASupprimer);
                    ResultSet rs2 = mysqlCli.exec("SELECT *  FROM `prospect` WHERE `prospect`.`idprospect` = " + idASupprimer);

                    idSocieteASupprimer = 0;
                    System.out.println(rs2 + "ICI TEST");
                    while (rs2.next()) {
                        idSocieteASupprimer = rs2.getInt("idSociete");
                        System.out.println(idSocieteASupprimer);
                    }
                    try {
                        // Execution de la requête 

                        String queryProspect = "DELETE FROM `prospect` "
                                + "WHERE `prospect`.`idProspect` = " + idASupprimer + ";";
                        System.out.println(queryProspect);
                        int nbMaj = mysqlCli.update(queryProspect);

                        String querySociete = "DELETE FROM `societe` "
                                + "WHERE `societe`.`idSociete` = " + idSocieteASupprimer + ";";
                        System.out.println(querySociete);
                        int nbMajSociete = mysqlCli.update(querySociete);
                        showMessageDialog(null, "Prospect supprimé", "Suppression", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception d) {
                        System.out.println("Probleme de requete dans supprimerBdd prospect");
                    }
                    break;
            }
            // fermeture de la connexion à la base 
            mysqlCli.close();

        } else {
            System.out.println("Mysql connection failed !!!");
        }
    }
    
    
    public static void modifierBdd(char infoMenu, int idAModifier){
        
        //MySQLCli mysqlCli = new MySQLCli("//localhost/toutbois", "root", "");         //Connection locale
        MySQLCli mysqlCli = new MySQLCli("//clustermysql07.hosteur.com/toutbois", "ludo_bdd", "LudoToutBois01234");           //Connection serveur distant
        if (mysqlCli.connect()) {

            switch (infoMenu) {
                case 'r':
                    int i = r.size();
                    i = i - 1;
                    System.out.println(i + " i de r.size");

                    Representant monRep = r.get(i);
                    System.out.println(monRep.getNomRepresentant());


                    try {
                        // Execution de la requête 
                        ResultSet rs = mysqlCli.exec("SELECT *  FROM `representant` WHERE `representant`.`idRepresentant` = " + idAModifier);
                        int idSocieteAModifier = 0;

                    while (rs.next()) {
                        idSocieteAModifier = rs.getInt(2);         //recuperation de idSociete
                        System.out.println(idSocieteAModifier+" idSociete utilisé pour la jointure");
                        System.out.println("Passage dans la boucle modifierBdd representant");
                    }
                    String queryRepresentant = "UPDATE `representant` "
                                + "SET `nomRepresentant` = '"+monRep.getNomRepresentant()+"', `salaireFixeRepresentant` = '"+monRep.getSalaireFixe()+"', `tauxCommissionRepresentant` = '"+monRep.getTauxCommission()+"' "
                                + "WHERE `representant`.`idRepresentant` = "+idAModifier+";";
                                
                        System.out.println(queryRepresentant);
                        int nbMaj = mysqlCli.update(queryRepresentant);

                        String querySociete = "UPDATE `societe` "
                                + "SET `nomContactSociete` = '"+monRep.getNom()+"', `prenomContactSociete` = '"+monRep.getPrenom()+"', `adresseSociete` = '"+monRep.getNumRueAdresse()+"', "
                                + "`complementAdresseSociete` = '"+monRep.getComplementAdresse()+"', `cpSociete` = '"+monRep.getCp()+"', `villeSociete` = '"+monRep.getVille()+"', "
                                + "`cedexSociete` = '"+monRep.getCedex()+"', `paysSociete` = '"+monRep.getPays()+"', `telephone1Societe` = '"+monRep.getTelephone()+"', "
                                + "`telephone2Societe` = '"+monRep.getTelephonePortable()+"', `faxSociete` = '"+monRep.getFax()+"', `mailSociete` = '"+monRep.getEmail()+"' "
                                + "WHERE `societe`.`idSociete` = "+idSocieteAModifier+";";
                                
                                
                                
                        System.out.println(querySociete);
                        int nbMajSociete = mysqlCli.update(querySociete);
                        showMessageDialog(null, "Modification représentant effectuée", "Modification", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception d) {
                        System.out.println("Probleme de requete dans modifierBdd representant");
                    }
                    // fermeture de la connexion à la base 

                    break;
                
                case 'c':
                    int j = client.size();
                    j = j - 1;
                    System.out.println(j + " j de client.size");

                    Client monClient = client.get(j);
                    System.out.println(monClient.getEnseigneClient());
                    
                    try {
                        System.out.println("Passage dans la boucle modifierBdd client");
                        // Execution de la requête 
                        ResultSet rs = mysqlCli.exec("SELECT *  FROM `client` WHERE `client`.`idClient` = " + idAModifier);
                        int idSocieteAModifier = 0;

                    while (rs.next()) {
                        idSocieteAModifier = rs.getInt(2);         //recuperation de idSociete
                        System.out.println(idSocieteAModifier+" idSociete utilisé pour la jointure");
                        System.out.println("Passage dans la boucle modifierBdd client");
                    }
                    String queryClient = "UPDATE `client` "
                                + "SET `enseigneClient` = '"+monClient.getEnseigneClient()+"', `siretClient` = '"+monClient.getSiret()+"', "
                                + "`nbrCommandesClient` = '"+monClient.getNombreCommandePassees()+"', `nomRepresentantClient` = '"+monClient.getRepresentant()+"' "
                                + "WHERE `client`.`idClient` = "+idAModifier+";";
                                
                        System.out.println(queryClient);
                        int nbMaj = mysqlCli.update(queryClient);

                        String querySociete = "UPDATE `societe` "
                                + "SET `nomContactSociete` = '"+monClient.getNom()+"', `prenomContactSociete` = '"+monClient.getPrenom()+"', `adresseSociete` = '"+monClient.getNumRueAdresse()+"', "
                                + "`complementAdresseSociete` = '"+monClient.getComplementAdresse()+"', `cpSociete` = '"+monClient.getCp()+"', `villeSociete` = '"+monClient.getVille()+"', "
                                + "`cedexSociete` = '"+monClient.getCedex()+"', `paysSociete` = '"+monClient.getPays()+"', `telephone1Societe` = '"+monClient.getTelephone()+"', "
                                + "`telephone2Societe` = '"+monClient.getTelephonePortable()+"', `faxSociete` = '"+monClient.getFax()+"', `mailSociete` = '"+monClient.getEmail()+"' "
                                + "WHERE `societe`.`idSociete` = "+idSocieteAModifier+";";
                                
                                                        
                        System.out.println(querySociete);
                        int nbMajSociete = mysqlCli.update(querySociete);
                        showMessageDialog(null, "Modification client effectuée", "Modification", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception d) {
                        System.out.println("Probleme de requete dans modifierBdd client");
                    }
                    // fermeture de la connexion à la base 

                    break;

                    
                case 'p':
                    
                    int k = pro.size();
                    k = k - 1;
                    System.out.println(k + " k de pro.size");

                    Prospect monProspect = pro.get(k);
                    System.out.println(monProspect.getEnseigneProspect());
                    
                    try {
                        System.out.println("Passage dans la boucle modifierBdd prospect");
                        // Execution de la requête 
                        ResultSet rs = mysqlCli.exec("SELECT *  FROM `prospect` WHERE `prospect`.`idprospect` = " + idAModifier);
                        int idSocieteAModifier = 0;

                    while (rs.next()) {
                        idSocieteAModifier = rs.getInt(2);         //recuperation de idSociete
                        System.out.println(idSocieteAModifier+" idSociete utilisé pour la jointure");
                        System.out.println("Passage dans la boucle modifierBdd client");
                    }
                    String queryClient = "UPDATE `prospect` "
                                + "SET `enseigneProspect` = '"+monProspect.getEnseigneProspect()+"', `siretProspect` = '"+monProspect.getSiret()+"', "
                                + "`nomRepresentantProspect` = '"+monProspect.getRepresentant()+"', `dateDerniereVisiteProspect` = '"+monProspect.getDerniereProspectionDate()+"' "
                                + "WHERE `prospect`.`idProspect` = "+idAModifier+";";
                                
                        System.out.println(queryClient);
                        int nbMaj = mysqlCli.update(queryClient);

                        String querySociete = "UPDATE `societe` "
                                + "SET `nomContactSociete` = '"+monProspect.getNom()+"', `prenomContactSociete` = '"+monProspect.getPrenom()+"', `adresseSociete` = '"+monProspect.getNumRueAdresse()+"', "
                                + "`complementAdresseSociete` = '"+monProspect.getComplementAdresse()+"', `cpSociete` = '"+monProspect.getCp()+"', `villeSociete` = '"+monProspect.getVille()+"', "
                                + "`cedexSociete` = '"+monProspect.getCedex()+"', `paysSociete` = '"+monProspect.getPays()+"', `telephone1Societe` = '"+monProspect.getTelephone()+"', "
                                + "`telephone2Societe` = '"+monProspect.getTelephonePortable()+"', `faxSociete` = '"+monProspect.getFax()+"', `mailSociete` = '"+monProspect.getEmail()+"' "
                                + "WHERE `societe`.`idSociete` = "+idSocieteAModifier+";";
                                
                                                        
                        System.out.println(querySociete);
                        int nbMajSociete = mysqlCli.update(querySociete);
                        showMessageDialog(null, "Modification prospect effectuée", "Modification", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception d) {
                        System.out.println("Probleme de requete dans modifierBdd prospect");
                    }
                    // fermeture de la connexion à la base 

                    break;
            }
            mysqlCli.close();

        } else {
            System.out.println("Mysql connection failed !!!");
        }
        
    
        }
    }
