/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Tableau.*;
import Classe.*;
import static IHM.RepCliProsp.r;
import Utilitaire.*;
import java.awt.Font;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author ldescamps
 */
public class RepCliProsp extends javax.swing.JDialog {

    /**
     * Creates new form RepCliProsp01
     */
    //Création d'une variable indiquant dans quel fenetre de menu on travail
        //Par défaut a l'ouverture menu "Représentant"
        public char infoMenu = 'r';          //Variable indiquant le menu dans lequel on travail
        public char fct = 'V';              //Variable indiquant la fonction (Creer, Modifier, Supprimer ou Visualisation)
         private boolean validationSiretPossible; //Boolean indiquant si l'enregistrement de la fiche est possible (champs obligatoires remplis)
        private boolean validationNomContactPossible; //Boolean indiquant si l'enregistrement de la fiche est possible (champs obligatoires remplis)
        private boolean validationVillePossible; //Boolean indiquant si l'enregistrement de la fiche est possible (champs obligatoires remplis)
        private boolean validationSalaireFixePossible; //Boolean indiquant si l'enregistrement de la fiche est possible (champs obligatoires remplis)
        private boolean validationTauxCommissionPossible; //Boolean indiquant si l'enregistrement de la fiche est possible (champs obligatoires remplis)
        private boolean validationMailPossible; //Boolean indiquant si l'enregistrement de la fiche est possible (champs obligatoires remplis)
        private boolean validationCpPossible; //Boolean indiquant si l'enregistrement de la fiche est possible (champs obligatoires remplis)
        private boolean validationAdressePossible; //Boolean indiquant si l'enregistrement de la fiche est possible (champs obligatoires remplis)
        private boolean validationNomEnseignePossible; //Boolean indiquant si l'enregistrement de la fiche est possible (champs obligatoires remplis)
        private boolean validationTelephonePossible; //Boolean indiquant si l'enregistrement de la fiche est possible (champs obligatoires remplis)
        private boolean validationPaysPossible; //Boolean indiquant si l'enregistrement de la fiche est possible (champs obligatoires remplis)
        private boolean validationCommandePossible; //Boolean indiquant si l'enregistrement de la fiche est possible (champs obligatoires remplis)
        private boolean validationPossible; //Boolean indiquant si l'enregistrement de la fiche est possible (champs obligatoires remplis)
        private boolean validationDatePossible;
        
        //Chargement et cration liste et tableau Représentants
        public static List<Representant> r = new ArrayList<>();
        private final ModeleDynamiqueRepresentant model = new ModeleDynamiqueRepresentant();
        
        
        //Chargement et cration liste et tableau Clients
        public static List<Client> client = new ArrayList<>();
        private final ModeleDynamiqueClient tabClient = new ModeleDynamiqueClient();
        
        //Chargement et cration liste et tableau Prospects
        public static List<Prospect> pro = new ArrayList<>();
        private final ModeleDynamiqueProspect tabProspect = new ModeleDynamiqueProspect();
 
        
        
    public RepCliProsp(java.awt.Frame parent, boolean modal) throws FileNotFoundException {
        super(parent, modal);
        initComponents();
        
     
        System.out.println("Menu = "+ infoMenu);
               
        //Affichage en gras du menu affiché 
        //Par défaut à l'ouverture mise en gras du menu "Représentant"
        jMenuRepresentant.setFont(new Font("default", Font.BOLD,12));
       
        //Interdit la modification manuelle des champs à l'ouverture
        JTextField[] tabsaisie = {jTextFieldDenominationNomSociete,jTextFieldDenominationIdentifiant, jTextFieldAdresseNumeroRue,jTextFieldAdresseComplement,
            jTextFieldAdresseCP,jTextFieldAdresseVille, jTextFieldAdresseCedex,jTextFieldContactNom,
                jTextFieldContactPrenom,jTextFieldContactTelephone1,jTextFieldContactTelephone2,jTextFieldContactFax,
                    jTextFieldContactMail, jTextFieldComplementSiret, jTextFieldComplementRepresentant, jTextFieldComplementSalaireFixeBrut, jTextFieldComplementTauxDeCommission,
                        jTextFieldDerniereProspectionDate, jTextFieldInformationCommercialeCommande};
        for (JTextField tabsaisie1 : tabsaisie) {
            tabsaisie1.setEditable(false);
        }
        
        //Cache le panel Complément (SIRET & Représentant)
        jPanelComplementClientProspect.setVisible(false); 
        jPanelDerniereProspection.setVisible(false);
        jPanelInformationCommerciale.setVisible(false);
        
        
        //Cache les boutons Enregister et Modifier
        jButtonEnregister.setVisible(false);
        jButtonAnnuler.setVisible(false);
        
        //Cache les listes Clients et Prospects
        jScrollPaneClient.setVisible(false);        
               
        //On implente la liste des fournisseurs existant dans un combo box
        for (int i = 0; i < r.size(); i++) {
            Representant ligne = (Representant) r.get(i);
            System.out.println("TEST RECUP RepCliProsp " + ligne.getNomRepresentant() + "\n");
            jComboBoxRepresentants.addItem(ligne.getNomRepresentant());
        }
                
        //On cache la comboBoxPays et comboBoxRepresentant
        jComboBoxPays.setVisible(false);
        jComboBoxRepresentants.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFond = new javax.swing.JPanel();
        jPanelDenomination = new javax.swing.JPanel();
        jLabelDenominationNomSociete = new javax.swing.JLabel();
        jTextFieldDenominationNomSociete = new javax.swing.JTextField();
        jTextFieldDenominationIdentifiant = new javax.swing.JTextField();
        jLabelDenominationIdentifiant = new javax.swing.JLabel();
        jPaneAdresse = new javax.swing.JPanel();
        jTextFieldAdresseNumeroRue = new javax.swing.JTextField();
        jLabelAdresseNumeroRue = new javax.swing.JLabel();
        jLabelAdresseComplement = new javax.swing.JLabel();
        jTextFieldAdresseComplement = new javax.swing.JTextField();
        jTextFieldAdresseCedex = new javax.swing.JTextField();
        jTextFieldAdresseVille = new javax.swing.JTextField();
        jTextFieldAdresseCP = new javax.swing.JTextField();
        jLabelAdresseCP = new javax.swing.JLabel();
        jLabelAdressePays = new javax.swing.JLabel();
        jComboBoxPays = new javax.swing.JComboBox<>();
        jLabelAdresseVille = new javax.swing.JLabel();
        jLabelAdresseCedex = new javax.swing.JLabel();
        jTextFieldPays = new javax.swing.JTextField();
        jPanelContact = new javax.swing.JPanel();
        jTextFieldContactNom = new javax.swing.JTextField();
        jLabelContactNom = new javax.swing.JLabel();
        jLabelContactPrenom = new javax.swing.JLabel();
        jLabeContactTelephone = new javax.swing.JLabel();
        jLabelContactFax = new javax.swing.JLabel();
        jLabelContactMail = new javax.swing.JLabel();
        jTextFieldContactMail = new javax.swing.JTextField();
        jTextFieldContactFax = new javax.swing.JTextField();
        jTextFieldContactTelephone1 = new javax.swing.JTextField();
        jTextFieldContactTelephone2 = new javax.swing.JTextField();
        jTextFieldContactPrenom = new javax.swing.JTextField();
        jPanelComplementClientProspect = new javax.swing.JPanel();
        jLabelComplementSiret = new javax.swing.JLabel();
        jTextFieldComplementSiret = new javax.swing.JTextField();
        jTextFieldComplementRepresentant = new javax.swing.JTextField();
        jLabelComplementRepresentant = new javax.swing.JLabel();
        jComboBoxRepresentants = new javax.swing.JComboBox<>();
        jPanelComplementRepresentant = new javax.swing.JPanel();
        jLabelComplementTauxDeCommission = new javax.swing.JLabel();
        jLabelComplementSalaireFixeBrut = new javax.swing.JLabel();
        jTextFieldComplementTauxDeCommission = new javax.swing.JTextField();
        jTextFieldComplementSalaireFixeBrut = new javax.swing.JTextField();
        jLabelComplementTauxDeCommissionPourcent = new javax.swing.JLabel();
        jLabelComplementSalaireFixeBrutEuro = new javax.swing.JLabel();
        jPanelDerniereProspection = new javax.swing.JPanel();
        jLabelDerniereProspectionDate = new javax.swing.JLabel();
        jTextFieldDerniereProspectionDate = new javax.swing.JTextField();
        jPanelInformationCommerciale = new javax.swing.JPanel();
        jTextFieldInformationCommercialeCommande = new javax.swing.JTextField();
        jLabelInformationCommercialeCommande = new javax.swing.JLabel();
        jScrollPaneRepresentant = new javax.swing.JScrollPane();
        jTableRepresentant = new javax.swing.JTable();
        jScrollPaneClient = new javax.swing.JScrollPane();
        jTableClient = new javax.swing.JTable();
        jScrollPaneProspect = new javax.swing.JScrollPane();
        jTableProspect = new javax.swing.JTable();
        jButtonModifier = new javax.swing.JButton();
        jButtonAjouter = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();
        jButtonFermer = new javax.swing.JButton();
        jButtonEnregister = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jLabeImage = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuRepresentant = new javax.swing.JMenu();
        jMenuClient = new javax.swing.JMenu();
        jMenuProspect = new javax.swing.JMenu();
        jMenuImprimer = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Toutbois - Représsentants - Clients - Prospects");
        setResizable(false);
        setSize(new java.awt.Dimension(800, 900));

        jPanelFond.setLayout(null);

        jPanelDenomination.setBorder(javax.swing.BorderFactory.createTitledBorder("Dénomination"));
        jPanelDenomination.setOpaque(false);

        jLabelDenominationNomSociete.setText("Nom");

        jTextFieldDenominationNomSociete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDenominationNomSocieteFocusLost(evt);
            }
        });
        jTextFieldDenominationNomSociete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDenominationNomSocieteActionPerformed(evt);
            }
        });

        jTextFieldDenominationIdentifiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDenominationIdentifiantActionPerformed(evt);
            }
        });

        jLabelDenominationIdentifiant.setText("Id. représentant");

        javax.swing.GroupLayout jPanelDenominationLayout = new javax.swing.GroupLayout(jPanelDenomination);
        jPanelDenomination.setLayout(jPanelDenominationLayout);
        jPanelDenominationLayout.setHorizontalGroup(
            jPanelDenominationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDenominationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDenominationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDenominationNomSociete)
                    .addComponent(jLabelDenominationIdentifiant, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanelDenominationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDenominationNomSociete, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDenominationIdentifiant, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelDenominationLayout.setVerticalGroup(
            jPanelDenominationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDenominationLayout.createSequentialGroup()
                .addGroup(jPanelDenominationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDenominationNomSociete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDenominationNomSociete))
                .addGap(18, 18, 18)
                .addGroup(jPanelDenominationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDenominationIdentifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDenominationIdentifiant))
                .addGap(39, 39, 39))
        );

        jPanelFond.add(jPanelDenomination);
        jPanelDenomination.setBounds(10, 20, 385, 120);

        jPaneAdresse.setBorder(javax.swing.BorderFactory.createTitledBorder("Adresse"));

        jTextFieldAdresseNumeroRue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldAdresseNumeroRueFocusLost(evt);
            }
        });
        jTextFieldAdresseNumeroRue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAdresseNumeroRueActionPerformed(evt);
            }
        });

        jLabelAdresseNumeroRue.setText("N° et rue");

        jLabelAdresseComplement.setText("Complément");

        jTextFieldAdresseCedex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAdresseCedexActionPerformed(evt);
            }
        });

        jTextFieldAdresseVille.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldAdresseVilleFocusLost(evt);
            }
        });

        jTextFieldAdresseCP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldAdresseCPFocusLost(evt);
            }
        });
        jTextFieldAdresseCP.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldAdresseCPInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        jLabelAdresseCP.setText("CP");

        jLabelAdressePays.setText("Pays");

        jComboBoxPays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selectionnez votre pays :", "Allemagne", "Autriche", "Belgique", "Bulgarie", "Chypre", "Croatie", "Danemark", "Espagne", "Estonie", "Finlande", "France", "Grèce", "Hongrie", "Irlande", "Italie", "Lettonie", "Lituanie", "Luxembourg", "Malte", "Pays-Bas", "Pologne", "Portugal", "République tchèque", "Roumanie", "Royaume-Uni", "Slovaquie", "Slovénie", "Suède" }));
        jComboBoxPays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPaysActionPerformed(evt);
            }
        });

        jLabelAdresseVille.setText("Ville");

        jLabelAdresseCedex.setText("Cedex");

        javax.swing.GroupLayout jPaneAdresseLayout = new javax.swing.GroupLayout(jPaneAdresse);
        jPaneAdresse.setLayout(jPaneAdresseLayout);
        jPaneAdresseLayout.setHorizontalGroup(
            jPaneAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneAdresseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPaneAdresseLayout.createSequentialGroup()
                        .addGroup(jPaneAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPaneAdresseLayout.createSequentialGroup()
                                .addComponent(jLabelAdresseCP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAdresseVille)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAdresseCedex))
                            .addComponent(jLabelAdressePays))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPaneAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPaneAdresseLayout.createSequentialGroup()
                                .addComponent(jTextFieldAdresseCP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldAdresseVille, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPaneAdresseLayout.createSequentialGroup()
                                .addComponent(jTextFieldPays, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jComboBoxPays, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPaneAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldAdresseCedex, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPaneAdresseLayout.createSequentialGroup()
                            .addGroup(jPaneAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelAdresseComplement)
                                .addComponent(jLabelAdresseNumeroRue))
                            .addGap(27, 27, 27)
                            .addGroup(jPaneAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldAdresseComplement, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldAdresseNumeroRue, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPaneAdresseLayout.setVerticalGroup(
            jPaneAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneAdresseLayout.createSequentialGroup()
                .addGroup(jPaneAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdresseNumeroRue)
                    .addComponent(jTextFieldAdresseNumeroRue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPaneAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdresseComplement)
                    .addComponent(jTextFieldAdresseComplement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPaneAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdresseCP)
                    .addComponent(jTextFieldAdresseCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAdresseVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAdresseCedex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAdresseVille)
                    .addComponent(jLabelAdresseCedex))
                .addGap(18, 18, 18)
                .addGroup(jPaneAdresseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdressePays)
                    .addComponent(jComboBoxPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        jPanelFond.add(jPaneAdresse);
        jPaneAdresse.setBounds(10, 150, 385, 210);

        jPanelContact.setBorder(javax.swing.BorderFactory.createTitledBorder("Contact"));

        jTextFieldContactNom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldContactNomFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldContactNomFocusLost(evt);
            }
        });
        jTextFieldContactNom.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldContactNomInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        jLabelContactNom.setText("Nom");

        jLabelContactPrenom.setText("Prénom");

        jLabeContactTelephone.setText("Téléphone");

        jLabelContactFax.setText("Fax");

        jLabelContactMail.setText("E-Mail");

        jTextFieldContactMail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldContactMailFocusLost(evt);
            }
        });

        jTextFieldContactTelephone1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldContactTelephone1FocusLost(evt);
            }
        });
        jTextFieldContactTelephone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldContactTelephone1ActionPerformed(evt);
            }
        });

        jTextFieldContactTelephone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldContactTelephone2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelContactLayout = new javax.swing.GroupLayout(jPanelContact);
        jPanelContact.setLayout(jPanelContactLayout);
        jPanelContactLayout.setHorizontalGroup(
            jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContactLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelContactLayout.createSequentialGroup()
                            .addComponent(jLabeContactTelephone)
                            .addGap(36, 36, 36)
                            .addComponent(jTextFieldContactTelephone1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldContactTelephone2))
                        .addGroup(jPanelContactLayout.createSequentialGroup()
                            .addGroup(jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelContactFax)
                                .addComponent(jLabelContactMail))
                            .addGap(61, 61, 61)
                            .addGroup(jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldContactFax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldContactMail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelContactLayout.createSequentialGroup()
                        .addGroup(jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelContactPrenom)
                            .addComponent(jLabelContactNom))
                        .addGap(53, 53, 53)
                        .addGroup(jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldContactPrenom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldContactNom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        jPanelContactLayout.setVerticalGroup(
            jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContactLayout.createSequentialGroup()
                .addGroup(jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContactNom)
                    .addComponent(jTextFieldContactNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContactPrenom)
                    .addComponent(jTextFieldContactPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeContactTelephone)
                    .addComponent(jTextFieldContactTelephone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldContactTelephone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContactFax)
                    .addComponent(jTextFieldContactFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContactMail)
                    .addComponent(jTextFieldContactMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelFond.add(jPanelContact);
        jPanelContact.setBounds(10, 370, 385, 260);

        jPanelComplementClientProspect.setBorder(javax.swing.BorderFactory.createTitledBorder("Complément"));

        jLabelComplementSiret.setText("SIRET");
        jLabelComplementSiret.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabelComplementSiretFocusLost(evt);
            }
        });

        jTextFieldComplementSiret.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldComplementSiretFocusLost(evt);
            }
        });

        jTextFieldComplementRepresentant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldComplementRepresentantActionPerformed(evt);
            }
        });

        jLabelComplementRepresentant.setText("Représentant");

        jComboBoxRepresentants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRepresentantsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelComplementClientProspectLayout = new javax.swing.GroupLayout(jPanelComplementClientProspect);
        jPanelComplementClientProspect.setLayout(jPanelComplementClientProspectLayout);
        jPanelComplementClientProspectLayout.setHorizontalGroup(
            jPanelComplementClientProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelComplementClientProspectLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelComplementClientProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelComplementSiret)
                    .addComponent(jLabelComplementRepresentant))
                .addGap(23, 23, 23)
                .addGroup(jPanelComplementClientProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldComplementSiret, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelComplementClientProspectLayout.createSequentialGroup()
                        .addComponent(jTextFieldComplementRepresentant, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxRepresentants, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanelComplementClientProspectLayout.setVerticalGroup(
            jPanelComplementClientProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelComplementClientProspectLayout.createSequentialGroup()
                .addGroup(jPanelComplementClientProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelComplementSiret)
                    .addComponent(jTextFieldComplementSiret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelComplementClientProspectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelComplementRepresentant)
                    .addComponent(jTextFieldComplementRepresentant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRepresentants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jPanelFond.add(jPanelComplementClientProspect);
        jPanelComplementClientProspect.setBounds(405, 20, 385, 120);

        jPanelComplementRepresentant.setBorder(javax.swing.BorderFactory.createTitledBorder("Complément"));

        jLabelComplementTauxDeCommission.setText("Taux de commission");

        jLabelComplementSalaireFixeBrut.setText("Salaire fixe brut");

        jTextFieldComplementTauxDeCommission.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldComplementTauxDeCommissionFocusLost(evt);
            }
        });

        jTextFieldComplementSalaireFixeBrut.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldComplementSalaireFixeBrutFocusLost(evt);
            }
        });

        jLabelComplementTauxDeCommissionPourcent.setText("%");

        jLabelComplementSalaireFixeBrutEuro.setText("€");

        javax.swing.GroupLayout jPanelComplementRepresentantLayout = new javax.swing.GroupLayout(jPanelComplementRepresentant);
        jPanelComplementRepresentant.setLayout(jPanelComplementRepresentantLayout);
        jPanelComplementRepresentantLayout.setHorizontalGroup(
            jPanelComplementRepresentantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelComplementRepresentantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelComplementRepresentantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelComplementSalaireFixeBrut)
                    .addComponent(jLabelComplementTauxDeCommission))
                .addGap(140, 140, 140)
                .addGroup(jPanelComplementRepresentantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldComplementSalaireFixeBrut, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldComplementTauxDeCommission, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelComplementRepresentantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelComplementTauxDeCommissionPourcent)
                    .addComponent(jLabelComplementSalaireFixeBrutEuro))
                .addGap(40, 40, 40))
        );
        jPanelComplementRepresentantLayout.setVerticalGroup(
            jPanelComplementRepresentantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelComplementRepresentantLayout.createSequentialGroup()
                .addGroup(jPanelComplementRepresentantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldComplementTauxDeCommission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelComplementTauxDeCommissionPourcent)
                    .addComponent(jLabelComplementTauxDeCommission))
                .addGap(18, 18, 18)
                .addGroup(jPanelComplementRepresentantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelComplementSalaireFixeBrut)
                    .addComponent(jTextFieldComplementSalaireFixeBrut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelComplementSalaireFixeBrutEuro))
                .addGap(39, 39, 39))
        );

        jPanelFond.add(jPanelComplementRepresentant);
        jPanelComplementRepresentant.setBounds(405, 20, 385, 120);

        jPanelDerniereProspection.setBorder(javax.swing.BorderFactory.createTitledBorder("Dernière prospection"));

        jLabelDerniereProspectionDate.setText("Date");

        jTextFieldDerniereProspectionDate.setToolTipText("aaaa-mm-jj");
        jTextFieldDerniereProspectionDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDerniereProspectionDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDerniereProspectionLayout = new javax.swing.GroupLayout(jPanelDerniereProspection);
        jPanelDerniereProspection.setLayout(jPanelDerniereProspectionLayout);
        jPanelDerniereProspectionLayout.setHorizontalGroup(
            jPanelDerniereProspectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDerniereProspectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDerniereProspectionDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jTextFieldDerniereProspectionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelDerniereProspectionLayout.setVerticalGroup(
            jPanelDerniereProspectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDerniereProspectionLayout.createSequentialGroup()
                .addGroup(jPanelDerniereProspectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDerniereProspectionDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDerniereProspectionDate))
                .addGap(27, 27, 27))
        );

        jPanelFond.add(jPanelDerniereProspection);
        jPanelDerniereProspection.setBounds(405, 150, 385, 75);

        jPanelInformationCommerciale.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations commerciales"));

        jLabelInformationCommercialeCommande.setText("Commandes");

        javax.swing.GroupLayout jPanelInformationCommercialeLayout = new javax.swing.GroupLayout(jPanelInformationCommerciale);
        jPanelInformationCommerciale.setLayout(jPanelInformationCommercialeLayout);
        jPanelInformationCommercialeLayout.setHorizontalGroup(
            jPanelInformationCommercialeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformationCommercialeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInformationCommercialeCommande)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jTextFieldInformationCommercialeCommande, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelInformationCommercialeLayout.setVerticalGroup(
            jPanelInformationCommercialeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformationCommercialeLayout.createSequentialGroup()
                .addGroup(jPanelInformationCommercialeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldInformationCommercialeCommande, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelInformationCommercialeCommande))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        jPanelFond.add(jPanelInformationCommerciale);
        jPanelInformationCommerciale.setBounds(405, 150, 385, 75);

        jTableRepresentant.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTableRepresentant.setModel(model);
        jTableRepresentant.getTableHeader().setReorderingAllowed(false);
        jTableRepresentant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRepresentantMouseClicked(evt);
            }
        });
        jScrollPaneRepresentant.setViewportView(jTableRepresentant);

        jPanelFond.add(jScrollPaneRepresentant);
        jScrollPaneRepresentant.setBounds(10, 640, 780, 130);

        jTableClient.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTableClient.setModel(tabClient);
        jTableClient.getTableHeader().setReorderingAllowed(false);
        jTableClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientMouseClicked(evt);
            }
        });
        jScrollPaneClient.setViewportView(jTableClient);

        jPanelFond.add(jScrollPaneClient);
        jScrollPaneClient.setBounds(10, 640, 780, 130);

        jTableProspect.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTableProspect.setModel(tabProspect);
        jTableProspect.getTableHeader().setReorderingAllowed(false);
        jTableProspect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProspectMouseClicked(evt);
            }
        });
        jScrollPaneProspect.setViewportView(jTableProspect);

        jPanelFond.add(jScrollPaneProspect);
        jScrollPaneProspect.setBounds(10, 640, 780, 130);

        jButtonModifier.setText("Modifier");
        jButtonModifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonModifierMouseClicked(evt);
            }
        });
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });
        jPanelFond.add(jButtonModifier);
        jButtonModifier.setBounds(300, 785, 90, 23);

        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAjouterMouseClicked(evt);
            }
        });
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });
        jPanelFond.add(jButtonAjouter);
        jButtonAjouter.setBounds(200, 785, 90, 23);

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });
        jPanelFond.add(jButtonSupprimer);
        jButtonSupprimer.setBounds(400, 785, 90, 23);

        jButtonFermer.setText("Fermer");
        jButtonFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFermerActionPerformed(evt);
            }
        });
        jPanelFond.add(jButtonFermer);
        jButtonFermer.setBounds(500, 785, 90, 23);

        jButtonEnregister.setText("Enregister");
        jButtonEnregister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEnregisterMouseClicked(evt);
            }
        });
        jButtonEnregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnregisterActionPerformed(evt);
            }
        });
        jButtonEnregister.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jButtonEnregisterPropertyChange(evt);
            }
        });
        jPanelFond.add(jButtonEnregister);
        jButtonEnregister.setBounds(510, 600, 90, 23);

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });
        jPanelFond.add(jButtonAnnuler);
        jButtonAnnuler.setBounds(610, 600, 90, 23);

        jLabeImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LogoTronconeuse.png"))); // NOI18N
        jPanelFond.add(jLabeImage);
        jLabeImage.setBounds(430, 220, 385, 385);

        jMenuRepresentant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/technicalsupportrepresentative_male_dark_32.png"))); // NOI18N
        jMenuRepresentant.setText("Représentant");
        jMenuRepresentant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuRepresentantMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuRepresentant);

        jMenuClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/folder_customer_32.png"))); // NOI18N
        jMenuClient.setText("Client");
        jMenuClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuClientMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuClient);

        jMenuProspect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/telephone_32.png"))); // NOI18N
        jMenuProspect.setText("Prospect");
        jMenuProspect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuProspectMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuProspect);

        jMenuImprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/print_32.png"))); // NOI18N
        jMenuImprimer.setText("Imprimer");
        jMenuImprimer.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jMenuImprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuImprimerMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuImprimer);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFond, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelFond, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldContactTelephone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldContactTelephone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldContactTelephone2ActionPerformed

    private void jMenuRepresentantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuRepresentantMouseClicked
        // TODO add your handling code here:
        infoMenu = 'r';
        System.out.println("Menu = " + infoMenu);

        clearFields();
        init();
        jLabelDenominationNomSociete.setText("Nom");
        jLabelDenominationIdentifiant.setText("Id. représentant");
        jPanelComplementClientProspect.setVisible(false);
        jPanelComplementRepresentant.setVisible(true);
        jPanelDerniereProspection.setVisible(false);
        //Cache les listes Clients et Prospects et affiche la liste Representant
        jScrollPaneClient.setVisible(false);
        jScrollPaneRepresentant.setVisible(true);
        jScrollPaneProspect.setVisible(false);
        jPanelInformationCommerciale.setVisible(false);

        //Affichage en gras du menu affiché "Représentant" et mise en non-gras des 2 autres
        jMenuRepresentant.setFont(new Font("default", Font.BOLD, 12));
        jMenuClient.setFont(new Font("default", Font.PLAIN, 12));
        jMenuProspect.setFont(new Font("default", Font.PLAIN, 12));

    }//GEN-LAST:event_jMenuRepresentantMouseClicked

    private void jMenuClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuClientMouseClicked
        // TODO add your handling code here:
        clearFields();
        init();
        jLabelDenominationNomSociete.setText("Enseigne");
        jLabelDenominationIdentifiant.setText("Id. client");
        jPanelComplementClientProspect.setVisible(true);
        jPanelComplementRepresentant.setVisible(false);
        jPanelDerniereProspection.setVisible(false);
        
        //Affiche la liste des Clients et cache les listes Representant et Prospect
        jScrollPaneClient.setVisible(true);
        jScrollPaneRepresentant.setVisible(false);
        jScrollPaneProspect.setVisible(false);
        jPanelInformationCommerciale.setVisible(true);
        
        //Affichage en gras du menu affiché "Client" et mise en non-gras des 2 autres
        jMenuRepresentant.setFont(new Font("default", Font.PLAIN,12));
        jMenuClient.setFont(new Font("default", Font.BOLD,12));
        jMenuProspect.setFont(new Font("default", Font.PLAIN,12));
        
        infoMenu = 'c';
        System.out.println("Menu = "+ infoMenu);        
    }//GEN-LAST:event_jMenuClientMouseClicked

    private void jMenuProspectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuProspectMouseClicked
        // TODO add your handling code here:
        clearFields();
        init();
        jLabelDenominationNomSociete.setText("Enseigne");
        jLabelDenominationIdentifiant.setText("Id. prospect");
        jPanelComplementClientProspect.setVisible(true);
        jPanelComplementRepresentant.setVisible(false);
        jPanelDerniereProspection.setVisible(true);
        
        //Affiche la liste des Prospect et cache les listes Clients et Représentant
        jScrollPaneClient.setVisible(false);
        jScrollPaneRepresentant.setVisible(false);
        jScrollPaneProspect.setVisible(true);
        jPanelInformationCommerciale.setVisible(false);
        
        
        //Affichage en gras du menu affiché "Prospect" et mise en non-gras des 2 autres
        jMenuRepresentant.setFont(new Font("default", Font.PLAIN,12));
        jMenuClient.setFont(new Font("default", Font.PLAIN,12));
        jMenuProspect.setFont(new Font("default", Font.BOLD,12));
        
        infoMenu = 'p';
        System.out.println("Menu = "+ infoMenu);
    }//GEN-LAST:event_jMenuProspectMouseClicked

    private void jButtonAjouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAjouterMouseClicked

    }//GEN-LAST:event_jButtonAjouterMouseClicked

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        // TODO add your handling code here:
        

       clearFields();
       JTextField[] tabsaisie = {jTextFieldDenominationNomSociete, jTextFieldAdresseNumeroRue,jTextFieldAdresseComplement,
            jTextFieldAdresseCP,jTextFieldAdresseVille, jTextFieldAdresseCedex,jTextFieldContactNom,
                jTextFieldContactPrenom,jTextFieldContactTelephone1,jTextFieldContactTelephone2,jTextFieldContactFax,
                    jTextFieldContactMail, jTextFieldComplementSiret, jTextFieldComplementRepresentant, jTextFieldComplementSalaireFixeBrut, jTextFieldComplementTauxDeCommission,
                        jTextFieldDerniereProspectionDate, jTextFieldInformationCommercialeCommande};
       
        for (JTextField tabsaisie1 : tabsaisie) {
            tabsaisie1.setEditable(true);            
        }
       
        if (infoMenu == 'r'){
            jTextFieldContactNom.setEditable(false);
        }else if ((infoMenu == 'c') || (infoMenu == 'p')){
            jTextFieldContactNom.setEditable(true);
        }
        
        //Affiche les boutons Enregister et Annuler
        fct = 'C';
        jButtonEnregister.setVisible(true);
        jButtonAnnuler.setVisible(true);
        
        //Affiche la comboBox pays et cache le texteField pays
        jComboBoxPays.setVisible(true);
        jTextFieldPays.setVisible(false);
        
        //Affichage du nouvel Identifiant à la création d'une fiche
        switch (infoMenu){
            case 'r':       //fiche représentant
                int nouveauIdRep = Representant.getCptRep()+1;
                String NouveauIdRepTexte = String.valueOf(nouveauIdRep);
                jTextFieldDenominationIdentifiant.setText(NouveauIdRepTexte);
                System.out.println("cpt rep = "+ Representant.getCptRep());
                break;
            
            case 'c':       //fiche client
                jComboBoxRepresentants.setVisible(true);                //affiche la ComboBoxRepresentant
                jTextFieldComplementRepresentant.setVisible(false);     //cache le TextFieldRepresentant
                int nouveauIdClient = Client.getCptClient()+1;
                String NouveauIdClientTexte = String.valueOf(nouveauIdClient);
                jTextFieldDenominationIdentifiant.setText(NouveauIdClientTexte);
                System.out.println("cpt client = "+ Client.getCptClient());
                break;
            
            case 'p':       //fiche prospect
                jComboBoxRepresentants.setVisible(true);                //affiche la ComboBoxRepresentant
                jTextFieldComplementRepresentant.setVisible(false);     //cache le TextFieldRepresentant
                int nouveauIdProsp = Prospect.getCptProspect()+1;
                String NouveauIdProspTexte = String.valueOf(nouveauIdProsp);
                jTextFieldDenominationIdentifiant.setText(NouveauIdProspTexte);
                System.out.println("cpt prosp = "+ Prospect.getCptProspect());
                break;
        }
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jButtonFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFermerActionPerformed
        // TODO add your handling code here:
        //this.setVisible(false);
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous fermer cette fenêtre?", "Fermer?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            //Si "Oui" :
            if (option == JOptionPane.OK_OPTION) {
                //fermer en libérant les ressources
                this.dispose();
            }
    }//GEN-LAST:event_jButtonFermerActionPerformed

    private void jTextFieldAdresseCedexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAdresseCedexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAdresseCedexActionPerformed

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
        // TODO add your handling code here:

        fct = 'M';

        //Lorsque l'on clique sur modifier  on rend les champs modifiable sauf jTextFieldDenominationIdentifiant (Identifiant)
        JTextField[] tabsaisie = {jTextFieldDenominationNomSociete, jTextFieldAdresseNumeroRue, jTextFieldAdresseComplement,
            jTextFieldAdresseCP, jTextFieldAdresseVille, jTextFieldAdresseCedex, jTextFieldContactNom,
            jTextFieldContactPrenom, jTextFieldContactTelephone1, jTextFieldContactTelephone2, jTextFieldContactFax,
            jTextFieldContactMail, jTextFieldComplementSiret, jTextFieldComplementSalaireFixeBrut, jTextFieldComplementTauxDeCommission,
            jTextFieldDerniereProspectionDate, jTextFieldInformationCommercialeCommande};

        for (JTextField tabsaisie1 : tabsaisie) {
            tabsaisie1.setEditable(true);
        }

        //Affiche les boutons Enregister et Annuler
        jButtonEnregister.setVisible(true);
        jButtonAnnuler.setVisible(true);

        //Affiche la comboBox pays et cache le texteField pays
        jComboBoxPays.setVisible(true);
        jTextFieldPays.setVisible(false);

        if (infoMenu == 'r') {
            jTextFieldContactNom.setEditable(false);
        } else if ((infoMenu == 'c') || (infoMenu == 'p')) {
            jTextFieldContactNom.setEditable(true);
        }

        switch (infoMenu) {

            case 'r':

                int ligneSelectionne = jTableRepresentant.getSelectedRow();
                if (ligneSelectionne < 0) {
                    showMessageDialog(null, "Merci de selectionner une fiche représentant à modifier", "Sélectionnez fiche", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //jTableRepresentant.setRowSelectionAllowed(false);
                    // jTableRepresentant.setColumnSelectionAllowed(false);
                    jTableRepresentant.setCellSelectionEnabled(false);

                    System.out.println("ligne representant à modifier classeRepCliProsp = " + ligneSelectionne);
                    rowTofields();
                }
                break;

            case 'c':

                int ligneSelectionne2 = jTableClient.getSelectedRow();
                if (ligneSelectionne2 < 0) {
                    showMessageDialog(null, "Merci de selectionner une fiche client à modifier", "Sélectionnez fiche", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    jComboBoxRepresentants.setVisible(true);                //affiche la ComboBoxRepresentant
                    jTextFieldComplementRepresentant.setVisible(false);     //cache le TextFieldRepresentant

                    System.out.println("ligne client à modifier classeRepCliProsp = " + ligneSelectionne2);
                    rowTofields();
                }
                break;

            case 'p':
                jComboBoxRepresentants.setVisible(true);                //affiche la ComboBoxRepresentant
                jTextFieldComplementRepresentant.setVisible(false);     //cache le TextFieldRepresentant

                int ligneSelectionne3 = jTableProspect.getSelectedRow();
                if (ligneSelectionne3 < 0) {
                    showMessageDialog(null, "Merci de selectionner une fiche prospect à modifier", "Sélectionnez fiche", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    System.out.println("ligne client à modifier classeRepCliProsp = " + ligneSelectionne3);
                    rowTofields();
                }
                break;
        }

    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jButtonModifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModifierMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButtonModifierMouseClicked

    private void jTextFieldDenominationNomSocieteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDenominationNomSocieteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDenominationNomSocieteActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        // TODO add your handling code here:
        
       //Ouverture d'une fenetre de confirmation "Quitter sans sauvegarde"       
        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous quitter sans sauvegarder ?", "Quitter sans sauvegarde?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            //Si "Oui" :
            if (option == JOptionPane.OK_OPTION) {
                jComboBoxRepresentants.setVisible(false);                //cache la ComboBoxRepresentant
                jTextFieldComplementRepresentant.setVisible(true);     //affiche le TextFieldRepresentant
                //Cache la comboBox pays et affiche le texteField pays
                jComboBoxPays.setVisible(false);
                jTextFieldPays.setVisible(true);
                //Rend les champs non modifiable
                JTextField[] tabsaisie = {jTextFieldDenominationNomSociete,jTextFieldDenominationIdentifiant, jTextFieldAdresseNumeroRue,jTextFieldAdresseComplement,
                    jTextFieldAdresseCP,jTextFieldAdresseVille, jTextFieldAdresseCedex,jTextFieldContactNom,
                        jTextFieldContactPrenom,jTextFieldContactTelephone1,jTextFieldContactTelephone2,jTextFieldContactFax,
                            jTextFieldContactMail, jTextFieldComplementSiret, jTextFieldComplementRepresentant, jTextFieldComplementSalaireFixeBrut, jTextFieldComplementTauxDeCommission
                                , jTextFieldInformationCommercialeCommande};
                for (JTextField tabsaisie1 : tabsaisie) {
                    tabsaisie1.setEditable(false);
                }
                //Cache les boutons Enregister et Annuler
                jButtonEnregister.setVisible(false);
                jButtonAnnuler.setVisible(false);
                fct = 'V';
            }

        
        
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jTextFieldDerniereProspectionDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDerniereProspectionDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDerniereProspectionDateActionPerformed

    private void jButtonEnregisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEnregisterMouseClicked
        // TODO add your handling code here:
      
        

        
    }//GEN-LAST:event_jButtonEnregisterMouseClicked

    private void jButtonEnregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnregisterActionPerformed
        
        //Rends mpossible l'enregistrement si les champs necessaires ne sont pas remplis

        controleChamps();
        if (validationPossible != true) {
            showMessageDialog(null, "Merci de compléter les champs dont le libellé est en rouge.", "Complétez les champs.", JOptionPane.INFORMATION_MESSAGE);
        } else {

            //Cache les boutons Enregister et Annuler
            jButtonEnregister.setVisible(false);
            jButtonAnnuler.setVisible(false);
            
            //Cache comboBox et affiche texteField Pays
            jTextFieldPays.setVisible(true);
            jComboBoxPays.setVisible(false);

            System.out.println("Fonction = " + fct);
            switch (fct) {

                case 'C':   //fonction Creer
                    switch (infoMenu) {
                        case 'r':   // Créer Representant
                            Representant representantNew = new Representant(jTextFieldDenominationNomSociete.getText(), 999999, jTextFieldComplementSalaireFixeBrut.getText(),
                                    jTextFieldComplementTauxDeCommission.getText(), jTextFieldContactNom.getText(), jTextFieldContactPrenom.getText(), jTextFieldAdresseNumeroRue.getText(),
                                    jTextFieldAdresseCP.getText(), jTextFieldAdresseVille.getText(), jComboBoxPays.getSelectedItem().toString(), jTextFieldContactTelephone1.getText(), jTextFieldContactTelephone2.getText(),
                                    jTextFieldContactFax.getText(), jTextFieldContactMail.getText(), jTextFieldAdresseCedex.getText(), jTextFieldAdresseComplement.getText());
                            r.add(representantNew);
                            System.out.println(representantNew.toString());
                             {
                                try {
                                    Bdds.ecrireBdd('r');
                                } catch (IOException ex) {
                                    Logger.getLogger(RepCliProsp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                            jComboBoxRepresentants.setVisible(false);                //cache la ComboBoxRepresentant
                            jTextFieldComplementRepresentant.setVisible(true);     //affiche le TextFieldRepresentant
                            //Cache la comboBox pays et affiche le texteField pays
                            jComboBoxPays.setVisible(false);
                            jTextFieldPays.setVisible(true);

                            //On vide le ModeleDynamiqueRepresentant
                            model.removeAllRep(jTableRepresentant);
                            model.fireTableDataChanged();

                            ModeleDynamiqueRepresentant model = new ModeleDynamiqueRepresentant();
                             {
                                try {
                                    Bdds.lireBdd('r', "representant");
                                } catch (SQLException ex) {
                                    Logger.getLogger(RepCliProsp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                            break;

                        case 'c':   // Créer Client
                            Client cli = new Client(jTextFieldDenominationNomSociete.getText(), 88, jTextFieldComplementSiret.getText(), jTextFieldInformationCommercialeCommande.getText(),
                                    jComboBoxRepresentants.getSelectedItem().toString(), jTextFieldContactNom.getText(), jTextFieldContactPrenom.getText(), jTextFieldAdresseNumeroRue.getText(),
                                    jTextFieldAdresseCP.getText(), jTextFieldAdresseVille.getText(), jComboBoxPays.getSelectedItem().toString(), jTextFieldContactTelephone1.getText(),
                                    jTextFieldContactTelephone2.getText(), jTextFieldContactFax.getText(), jTextFieldContactMail.getText(), jTextFieldAdresseCedex.getText(),
                                    jTextFieldAdresseComplement.getText());
                            client.add(cli);
                            System.out.println(cli.toString());
                             {
                                try {
                                    Bdds.ecrireBdd('c');
                                } catch (IOException ex) {
                                    Logger.getLogger(RepCliProsp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            jComboBoxRepresentants.setVisible(false);                //cache la ComboBoxRepresentant
                            jTextFieldComplementRepresentant.setVisible(true);     //affiche le TextFieldRepresentant
                            //Cache la comboBox pays et affiche le texteField pays
                            jComboBoxPays.setVisible(false);
                            jTextFieldPays.setVisible(true);

                            //On vide le ModeleDynamiqueClient
                            tabClient.removeAllCli(jTableClient);
                            tabClient.fireTableDataChanged();

                            ModeleDynamiqueClient tabClient = new ModeleDynamiqueClient();
                             {
                                try {
                                    Bdds.lireBdd('c', "client");
                                    System.out.println("boucle de lecture BDD Client pour mise a jour");
                                } catch (SQLException ex) {
                                    Logger.getLogger(RepCliProsp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                            break;

                        case 'p':   // Créer Prospect
                            Prospect prosp = new Prospect(jTextFieldDenominationNomSociete.getText(), 10, jComboBoxRepresentants.getSelectedItem().toString(), jTextFieldDerniereProspectionDate.getText(),
                                    jTextFieldComplementSiret.getText(), jTextFieldContactNom.getText(), jTextFieldContactPrenom.getText(), jTextFieldAdresseNumeroRue.getText(), jTextFieldAdresseCP.getText(),
                                    jTextFieldAdresseVille.getText(), jComboBoxPays.getSelectedItem().toString(), jTextFieldContactTelephone1.getText(),
                                    jTextFieldContactTelephone2.getText(), jTextFieldContactFax.getText(), jTextFieldContactMail.getText(),
                                    jTextFieldAdresseCedex.getText(), jTextFieldAdresseComplement.getText());
                            pro.add(prosp);
                            System.out.println(prosp.toString());
                             {
                                try {
                                    Bdds.ecrireBdd('p');
                                } catch (IOException ex) {
                                    Logger.getLogger(RepCliProsp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            jComboBoxRepresentants.setVisible(false);                //cache la ComboBoxRepresentant
                            jTextFieldComplementRepresentant.setVisible(true);     //affiche le TextFieldRepresentant
                            //Cache la comboBox pays et affiche le texteField pays
                            jComboBoxPays.setVisible(false);
                            jTextFieldPays.setVisible(true);

                            //On vide le ModeleDynamiqueProspect
                            tabProspect.removeAllPro(jTableProspect);
                            tabProspect.fireTableDataChanged();

                            //On charge le fichier Bdd
                            ModeleDynamiqueProspect tabProspect = new ModeleDynamiqueProspect();
                             {
                                try {
                                    Bdds.lireBdd('p', "prospect");
                                } catch (SQLException ex) {
                                    Logger.getLogger(RepCliProsp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                            break;

                    }
                    break;

                case 'M':   //fonction Modifier
                    switch (infoMenu) {
                        case 'r':   // Modifier Representant
                            int ligneSelectionneRepresentant = jTableRepresentant.getSelectedRow();
                            int idRepresentantAModifier = Integer.parseInt(jTextFieldDenominationIdentifiant.getText());
                            System.out.println("id representant a modifier dans jButtonEnregistrer " + idRepresentantAModifier);

                            Representant representantNew = new Representant(jTextFieldDenominationNomSociete.getText(), idRepresentantAModifier, jTextFieldComplementSalaireFixeBrut.getText(),
                                    jTextFieldComplementTauxDeCommission.getText(), jTextFieldContactNom.getText(), jTextFieldContactPrenom.getText(), jTextFieldAdresseNumeroRue.getText(),
                                    jTextFieldAdresseCP.getText(), jTextFieldAdresseVille.getText(), jComboBoxPays.getSelectedItem().toString(), jTextFieldContactTelephone1.getText(), jTextFieldContactTelephone2.getText(),
                                    jTextFieldContactFax.getText(), jTextFieldContactMail.getText(), jTextFieldAdresseCedex.getText(), jTextFieldAdresseComplement.getText());
                            r.add(representantNew);
                            System.out.println(representantNew.toString());
                             {
                                Bdds.modifierBdd('r', idRepresentantAModifier);
                            }
                            jComboBoxRepresentants.setVisible(false);                //cache la ComboBoxRepresentant
                            jTextFieldComplementRepresentant.setVisible(true);     //affiche le TextFieldRepresentant
                            //Cache la comboBox pays et affiche le texteField pays
                            jComboBoxPays.setVisible(false);
                            jTextFieldPays.setVisible(true);

                            //On vide le ModeleDynamiqueRepresentant
                            model.removeAllRep(jTableRepresentant);
                            model.fireTableDataChanged();

                            ModeleDynamiqueRepresentant model = new ModeleDynamiqueRepresentant();
                             {
                                try {
                                    Bdds.lireBdd('r', "representant");
                                } catch (SQLException ex) {
                                    Logger.getLogger(RepCliProsp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                            break;

                        case 'c':   // Modifier Client
                            int ligneSelectionneClient = jTableClient.getSelectedRow();
                            int idClientAModifier = Integer.parseInt(jTextFieldDenominationIdentifiant.getText());
                            System.out.println("id Client a modifier dans jButtonEnregistrer " + idClientAModifier);

                            Client clientNew = new Client(jTextFieldDenominationNomSociete.getText(), 88, jTextFieldComplementSiret.getText(), jTextFieldInformationCommercialeCommande.getText(),
                                    jComboBoxRepresentants.getSelectedItem().toString(), jTextFieldContactNom.getText(), jTextFieldContactPrenom.getText(), jTextFieldAdresseNumeroRue.getText(),
                                    jTextFieldAdresseCP.getText(), jTextFieldAdresseVille.getText(), jComboBoxPays.getSelectedItem().toString(), jTextFieldContactTelephone1.getText(),
                                    jTextFieldContactTelephone2.getText(), jTextFieldContactFax.getText(), jTextFieldContactMail.getText(), jTextFieldAdresseCedex.getText(),
                                    jTextFieldAdresseComplement.getText());
                            client.add(clientNew);
                            System.out.println(clientNew.toString());
                             {
                                Bdds.modifierBdd('c', idClientAModifier);
                            }
                            jComboBoxRepresentants.setVisible(false);                //cache la ComboBoxRepresentant
                            jTextFieldComplementRepresentant.setVisible(true);     //affiche le TextFieldRepresentant
                            //Cache la comboBox pays et affiche le texteField pays
                            jComboBoxPays.setVisible(false);
                            jTextFieldPays.setVisible(true);

                            //On vide le ModeleDynamiqueRepresentant
                            tabClient.removeAllCli(jTableClient);
                            tabClient.fireTableDataChanged();

                            // ModeleDynamiqueRepresentant model = new ModeleDynamiqueRepresentant();
                             {
                                try {
                                    Bdds.lireBdd('c', "client");
                                } catch (SQLException ex) {
                                    Logger.getLogger(RepCliProsp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                            break;

                        case 'p':   // Modifier Representant
                            int ligneSelectionneProspect = jTableProspect.getSelectedRow();
                            int idProspectAModifier = Integer.parseInt(jTextFieldDenominationIdentifiant.getText());
                            System.out.println("id Prospect a modifier dans jButtonEnregistrer " + idProspectAModifier);

                            Prospect prosp = new Prospect(jTextFieldDenominationNomSociete.getText(), 10, jComboBoxRepresentants.getSelectedItem().toString(), jTextFieldDerniereProspectionDate.getText(),
                                    jTextFieldComplementSiret.getText(), jTextFieldContactNom.getText(), jTextFieldContactPrenom.getText(), jTextFieldAdresseNumeroRue.getText(), jTextFieldAdresseCP.getText(),
                                    jTextFieldAdresseVille.getText(), jComboBoxPays.getSelectedItem().toString(), jTextFieldContactTelephone1.getText(),
                                    jTextFieldContactTelephone2.getText(), jTextFieldContactFax.getText(), jTextFieldContactMail.getText(),
                                    jTextFieldAdresseCedex.getText(), jTextFieldAdresseComplement.getText());
                            pro.add(prosp);
                            System.out.println(prosp.toString());
                             {
                                Bdds.modifierBdd('p', idProspectAModifier);
                            }
                            jComboBoxRepresentants.setVisible(false);                //cache la ComboBoxRepresentant
                            jTextFieldComplementRepresentant.setVisible(true);     //affiche le TextFieldRepresentant
                            //Cache la comboBox pays et affiche le texteField pays
                            jComboBoxPays.setVisible(false);
                            jTextFieldPays.setVisible(true);

                            //On vide le ModeleDynamiqueRepresentant
                            tabProspect.removeAllPro(jTableProspect);
                            tabProspect.fireTableDataChanged();

                            // ModeleDynamiqueRepresentant model = new ModeleDynamiqueRepresentant();
                             {
                                try {
                                    Bdds.lireBdd('p', "prospect");
                                } catch (SQLException ex) {
                                    Logger.getLogger(RepCliProsp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                            break;
                    }
                    break;
            }
            init();
        }
    }//GEN-LAST:event_jButtonEnregisterActionPerformed

    private void jTextFieldDenominationIdentifiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDenominationIdentifiantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDenominationIdentifiantActionPerformed

    private void jTextFieldAdresseNumeroRueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAdresseNumeroRueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAdresseNumeroRueActionPerformed

    private void jComboBoxPaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPaysActionPerformed
        // TODO add your handling code here:
        switch (jComboBoxPays.getSelectedItem().toString()) {
            case "Allemagne":
                jTextFieldContactTelephone1.setText("+49");
                break;
            case "Autriche":
                jTextFieldContactTelephone1.setText("+43");
                break;
            case "Belgique":
                jTextFieldContactTelephone1.setText("+32");
                break;
            case "Bulgarie":
                jTextFieldContactTelephone1.setText("+359");
                break;
            case "Chypre":
                jTextFieldContactTelephone1.setText("+357");
                break;
            case "Croatie":
                jTextFieldContactTelephone1.setText("+385");
                break;
            case "Danemark":
                jTextFieldContactTelephone1.setText("+45");
                break;
            case "Espagne":
                jTextFieldContactTelephone1.setText("+34");
                break;
            case "Estonie":
                jTextFieldContactTelephone1.setText("+372");
                break;
            case "Finlande":
                jTextFieldContactTelephone1.setText("+358");
                break;
            case "France":
                jTextFieldContactTelephone1.setText("+33");
                break;
            case "Grèce":
                jTextFieldContactTelephone1.setText("+30");
                break;
            case "Hongrie":
                jTextFieldContactTelephone1.setText("+36");
                break;
            case "Irlande":
                jTextFieldContactTelephone1.setText("+353");
                break;
            case "Islande":
                jTextFieldContactTelephone1.setText("+354");
                break;
            case "Italie":
                jTextFieldContactTelephone1.setText("+39");
                break;
            case "Lettonie":
                jTextFieldContactTelephone1.setText("+371");
                break;
            case "Lituanie":
                jTextFieldContactTelephone1.setText("+370");
                break;
            case "Luxembourg":
                jTextFieldContactTelephone1.setText("+352");
                break;
            case "Malte":
                jTextFieldContactTelephone1.setText("+356");
                break;
            case "Pays-Bas":
                jTextFieldContactTelephone1.setText("+31");
                break;
            case "Pologne":
                jTextFieldContactTelephone1.setText("+48");
                break;
            case "Portugal":
                jTextFieldContactTelephone1.setText("+351");
                break;
            case "République tchèque":
                jTextFieldContactTelephone1.setText("+420");
                break;
            case "Roumanie":
                jTextFieldContactTelephone1.setText("+40");
                break;
            case "Royaume-Uni":
                jTextFieldContactTelephone1.setText("+44");
                break;
            case "Slovaquie":
                jTextFieldContactTelephone1.setText("+421");
                break;
            case "Slovénie":
                jTextFieldContactTelephone1.setText("+386");
                break;
            case "Suède":
                jTextFieldContactTelephone1.setText("+46");
                break;
                    
        }
            
       
    }//GEN-LAST:event_jComboBoxPaysActionPerformed

    private void jMenuImprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuImprimerMouseClicked
        // TODO add your handling code here:

        String menu = Character.toString(infoMenu);
        jComboBoxRepresentants.setVisible(false);                //cache la ComboBoxRepresentant
        jTextFieldComplementRepresentant.setVisible(true);     //affiche le TextFieldRepresentant
        jComboBoxPays.setVisible(false);                //cache la ComboBoxRepresentant
        jTextFieldPays.setVisible(true);     //affiche le TextFieldRepresentant

        switch (infoMenu) {
            case 'r':
                int ligneSelectionne = jTableRepresentant.getSelectedRow();
                if (ligneSelectionne < 0) {
                    showMessageDialog(null, "Merci de selectionner une fiche représentant à imprimer", "Sélectionnez fiche", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    rowTofields();
                    System.out.println("ligne representant à imprimer classeRepCliProsp = " + ligneSelectionne);
                    String tabChaineSaisieRep[] = {jTextFieldDenominationNomSociete.getText(), jTextFieldDenominationIdentifiant.getText(),
                        jTextFieldAdresseNumeroRue.getText(), jTextFieldAdresseComplement.getText(), jTextFieldAdresseCP.getText(),
                        jTextFieldAdresseVille.getText(), jTextFieldAdresseCedex.getText(), jComboBoxPays.getSelectedItem().toString(),
                        jTextFieldContactNom.getText(), jTextFieldContactPrenom.getText(), jTextFieldContactTelephone1.getText(),
                        jTextFieldContactTelephone2.getText(), jTextFieldContactFax.getText(), jTextFieldContactMail.getText(),
                        jTextFieldComplementSiret.getText(), jComboBoxRepresentants.getSelectedItem().toString(),
                        jTextFieldComplementSalaireFixeBrut.getText(), jTextFieldComplementTauxDeCommission.getText(),
                        jTextFieldInformationCommercialeCommande.getText(), jTextFieldDerniereProspectionDate.getText(), menu};
                    //Méthode imprimer de Impression
                    Impression fiche = new Impression();
                    fiche.imprimer(tabChaineSaisieRep);

                }
                break;

            case 'c':
                int ligneSelectionne2 = jTableClient.getSelectedRow();
                if (ligneSelectionne2 < 0) {
                    showMessageDialog(null, "Merci de selectionner une fiche client à imprimer", "Sélectionnez fiche", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    rowTofields();
                    System.out.println("ligne client à imprimer classeRepCliProsp = " + ligneSelectionne2);
                    String tabChaineSaisieCli[] = {jTextFieldDenominationNomSociete.getText(), jTextFieldDenominationIdentifiant.getText(),
                        jTextFieldAdresseNumeroRue.getText(), jTextFieldAdresseComplement.getText(), jTextFieldAdresseCP.getText(),
                        jTextFieldAdresseVille.getText(), jTextFieldAdresseCedex.getText(), jComboBoxPays.getSelectedItem().toString(),
                        jTextFieldContactNom.getText(), jTextFieldContactPrenom.getText(), jTextFieldContactTelephone1.getText(),
                        jTextFieldContactTelephone2.getText(), jTextFieldContactFax.getText(), jTextFieldContactMail.getText(),
                        jTextFieldComplementSiret.getText(), jComboBoxRepresentants.getSelectedItem().toString(),
                        jTextFieldComplementSalaireFixeBrut.getText(), jTextFieldComplementTauxDeCommission.getText(),
                        jTextFieldInformationCommercialeCommande.getText(), jTextFieldDerniereProspectionDate.getText(), menu};
                    //Méthode imprimer de Impression
                    Impression fiche = new Impression();
                    fiche.imprimer(tabChaineSaisieCli);
                }
                break;

            case 'p':
                int ligneSelectionne3 = jTableProspect.getSelectedRow();
                if (ligneSelectionne3 < 0) {
                    showMessageDialog(null, "Merci de selectionner une fiche prospect à imprimer", "Sélectionnez fiche", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    rowTofields();
                    System.out.println("ligne prospect à imprimer classeRepCliProsp = " + ligneSelectionne3);
                    String tabChaineSaisiePro[] = {jTextFieldDenominationNomSociete.getText(), jTextFieldDenominationIdentifiant.getText(),
                        jTextFieldAdresseNumeroRue.getText(), jTextFieldAdresseComplement.getText(), jTextFieldAdresseCP.getText(),
                        jTextFieldAdresseVille.getText(), jTextFieldAdresseCedex.getText(), jComboBoxPays.getSelectedItem().toString(),
                        jTextFieldContactNom.getText(), jTextFieldContactPrenom.getText(), jTextFieldContactTelephone1.getText(),
                        jTextFieldContactTelephone2.getText(), jTextFieldContactFax.getText(), jTextFieldContactMail.getText(),
                        jTextFieldComplementSiret.getText(), jComboBoxRepresentants.getSelectedItem().toString(),
                        jTextFieldComplementSalaireFixeBrut.getText(), jTextFieldComplementTauxDeCommission.getText(),
                        jTextFieldInformationCommercialeCommande.getText(), jTextFieldDerniereProspectionDate.getText(), menu};
                    //Méthode imprimer de Impression
                    Impression fiche = new Impression();
                    fiche.imprimer(tabChaineSaisiePro);
                }
                break;

        }
    }//GEN-LAST:event_jMenuImprimerMouseClicked

    private void jTextFieldContactTelephone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldContactTelephone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldContactTelephone1ActionPerformed

    private void jTextFieldDenominationNomSocieteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDenominationNomSocieteFocusLost
        // TODO add your handling code here:

            if (infoMenu == 'r') {
                jTextFieldContactNom.setText(jTextFieldDenominationNomSociete.getText());
            }
        
    }//GEN-LAST:event_jTextFieldDenominationNomSocieteFocusLost

    private void jTextFieldAdresseNumeroRueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAdresseNumeroRueFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAdresseNumeroRueFocusLost

    private void jTextFieldContactNomInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldContactNomInputMethodTextChanged
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jTextFieldContactNomInputMethodTextChanged

    private void jTextFieldContactNomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldContactNomFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextFieldContactNomFocusGained

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        // TODO add your handling code here:

        switch (infoMenu) {
            case 'r':
                int ligneSelectionne = jTableRepresentant.getSelectedRow();
                if (ligneSelectionne < 0) {
                    showMessageDialog(null, "Merci de selectionner une fiche représentant à supprimer", "Sélectionnez fiche", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    fct = 'S';

                    //on récupére la valeur de la première colonne de la ligne sélectionné
                    int idRepresentantASupprimer = (int) jTableRepresentant.getValueAt(ligneSelectionne, 0);
                    System.out.println("Id Representant à supprimer : " + idRepresentantASupprimer);

                    //Demandes la confirmation de suppression
                    JOptionPane jop = new JOptionPane();
                    int option = jop.showConfirmDialog(null, "Voulez-vous vraiment supprimer la fiche représentant selectionnée ?", "Supprimer cette fiche?",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    //Si "Oui" :
                    if (option == JOptionPane.OK_OPTION) {
                        r.remove(ligneSelectionne);
                        model.fireTableDataChanged();
                        try {
                            Bdds.supprimerBdd('r', idRepresentantASupprimer);
                        } catch (SQLException ex) {
                            Logger.getLogger(RepCliProsp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                break;

            case 'c':
                int ligneSelectionneClient = jTableClient.getSelectedRow();
                if (ligneSelectionneClient < 0) {
                    showMessageDialog(null, "Merci de selectionner une fiche client à supprimer", "Sélectionnez fiche", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    fct = 'S';

                    //on récupére la valeur de la première colonne de la ligne sélectionné
                    int idClientASupprimer = (int) jTableClient.getValueAt(ligneSelectionneClient, 0);
                    System.out.println("Id client à supprimer : " + idClientASupprimer);

                    //Demandes la confirmation de suppression
                    JOptionPane jop = new JOptionPane();
                    int option = jop.showConfirmDialog(null, "Voulez-vous vraiment supprimer la fiche client selectionnée ?", "Supprimer cette fiche?",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    //Si "Oui" :
                    if (option == JOptionPane.OK_OPTION) {
                        client.remove(ligneSelectionneClient);
                        tabClient.fireTableDataChanged();
                        try {
                            Bdds.supprimerBdd('c', idClientASupprimer);
                        } catch (SQLException ex) {
                            Logger.getLogger(RepCliProsp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                break;

            case 'p':
                int ligneSelectionneProspect = jTableProspect.getSelectedRow();
                if (ligneSelectionneProspect < 0) {
                    showMessageDialog(null, "Merci de selectionner une fiche prospect à supprimer", "Sélectionnez fiche", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    fct = 'S';

                    //on récupére la valeur de la première colonne de la ligne sélectionné
                    int idProspectASupprimer = (int) jTableClient.getValueAt(ligneSelectionneProspect, 0);
                    System.out.println("Id prospect à supprimer : " + idProspectASupprimer);

                    //Demandes la confirmation de suppression
                    JOptionPane jop = new JOptionPane();
                    int option = jop.showConfirmDialog(null, "Voulez-vous vraiment supprimer la fiche prospect selectionnée ?", "Supprimer cette fiche?",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    //Si "Oui" :
                    if (option == JOptionPane.OK_OPTION) {
                        pro.remove(ligneSelectionneProspect);
                        tabProspect.fireTableDataChanged();
                        try {
                            Bdds.supprimerBdd('p', idProspectASupprimer);
                        } catch (SQLException ex) {
                            Logger.getLogger(RepCliProsp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                break;
        }
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void jTextFieldAdresseCPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAdresseCPFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldAdresseCPFocusLost

    private void jTextFieldContactMailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldContactMailFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldContactMailFocusLost

    private void jTextFieldContactTelephone1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldContactTelephone1FocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldContactTelephone1FocusLost

    private void jTextFieldAdresseCPInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldAdresseCPInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAdresseCPInputMethodTextChanged

    private void jTextFieldComplementTauxDeCommissionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldComplementTauxDeCommissionFocusLost
        // TODO add your handling code here:


    }//GEN-LAST:event_jTextFieldComplementTauxDeCommissionFocusLost

    private void jTextFieldComplementSalaireFixeBrutFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldComplementSalaireFixeBrutFocusLost
        // TODO add your handling code here:


    }//GEN-LAST:event_jTextFieldComplementSalaireFixeBrutFocusLost

    private void jButtonEnregisterPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jButtonEnregisterPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEnregisterPropertyChange

    private void jTextFieldAdresseVilleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAdresseVilleFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldAdresseVilleFocusLost

    private void jTextFieldContactNomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldContactNomFocusLost
        // TODO add your handling code here:
                               
    }//GEN-LAST:event_jTextFieldContactNomFocusLost

    private void jLabelComplementSiretFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabelComplementSiretFocusLost
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jLabelComplementSiretFocusLost

    private void jTextFieldComplementSiretFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldComplementSiretFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldComplementSiretFocusLost

    private void jTextFieldComplementRepresentantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldComplementRepresentantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldComplementRepresentantActionPerformed

    private void jComboBoxRepresentantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRepresentantsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxRepresentantsActionPerformed

    private void jTableRepresentantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRepresentantMouseClicked
        // TODO add your handling code here:
        rowTofields();
    }//GEN-LAST:event_jTableRepresentantMouseClicked

    private void jTableClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientMouseClicked
        // TODO add your handling code here:
        rowTofields();
    }//GEN-LAST:event_jTableClientMouseClicked

    private void jTableProspectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProspectMouseClicked
        // TODO add your handling code here:
        rowTofields();
    }//GEN-LAST:event_jTableProspectMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RepCliProsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RepCliProsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RepCliProsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RepCliProsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RepCliProsp dialog = null;
                try {
                    dialog = new RepCliProsp(new javax.swing.JFrame(), true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(RepCliProsp.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

        private void clearFields(){      //Méthode pour vider les champs
        
        JTextField[] tabsaisie = {jTextFieldDenominationNomSociete ,jTextFieldDenominationIdentifiant, jTextFieldAdresseNumeroRue,jTextFieldAdresseComplement,
            jTextFieldAdresseCP,jTextFieldAdresseVille, jTextFieldAdresseCedex,jTextFieldContactNom,
                jTextFieldContactPrenom,jTextFieldContactTelephone1,jTextFieldContactTelephone2,jTextFieldContactFax,
                    jTextFieldContactMail, jTextFieldComplementSiret, jTextFieldComplementSalaireFixeBrut, jTextFieldComplementTauxDeCommission,
                        jTextFieldDerniereProspectionDate, jTextFieldInformationCommercialeCommande, jTextFieldPays, jTextFieldComplementRepresentant};
       
        for (JTextField tabsaisie1 : tabsaisie) {
            tabsaisie1.setText("");
        }
        jComboBoxPays.setSelectedIndex(0);
    }
    
    private void init(){
        jComboBoxRepresentants.setVisible(false);                //cache la ComboBoxRepresentant
        jTextFieldComplementRepresentant.setVisible(true);     //affiche le TextFieldRepresentant
        //Cache la comboBox pays et affiche le texteField pays
        jComboBoxPays.setVisible(false);
        jTextFieldPays.setVisible(true);
        //Cache les boutons Enregister et Annuler
        jButtonEnregister.setVisible(false);
        jButtonAnnuler.setVisible(false);
        fct = 'V';
        
        //Mets la couleur noir pour la police labels
        JLabel[] labels = {jLabeContactTelephone,jLabelAdresseCP,jLabelAdresseCedex,jLabelAdresseNumeroRue,jLabelAdressePays,jLabelAdresseVille,
            jLabelComplementRepresentant,jLabelComplementSalaireFixeBrut,jLabelComplementSalaireFixeBrutEuro,jLabelComplementSiret,jLabelComplementTauxDeCommission,
            jLabelContactMail,jLabelContactNom,jLabelDenominationIdentifiant,jLabelDenominationNomSociete,jLabelDerniereProspectionDate,jLabelInformationCommercialeCommande};
        for (JLabel labels1 : labels){
            labels1.setForeground(Color.black);
        }
        
        //Interdit la modification manuelle des champs à l'ouverture
        JTextField[] tabsaisie = {jTextFieldDenominationNomSociete,jTextFieldDenominationIdentifiant, jTextFieldAdresseNumeroRue,jTextFieldAdresseComplement,
            jTextFieldAdresseCP,jTextFieldAdresseVille, jTextFieldAdresseCedex,jTextFieldContactNom,
                jTextFieldContactPrenom,jTextFieldContactTelephone1,jTextFieldContactTelephone2,jTextFieldContactFax,
                    jTextFieldContactMail, jTextFieldComplementSiret, jTextFieldComplementRepresentant, jTextFieldComplementSalaireFixeBrut, jTextFieldComplementTauxDeCommission,
                        jTextFieldDerniereProspectionDate, jTextFieldInformationCommercialeCommande, jTextFieldPays};
        for (JTextField tabsaisie1 : tabsaisie) {
            tabsaisie1.setEditable(false);
        }
    }
    
    
        private void controleChamps(){
            validationPossible = false;
        //Controle SIRET
        if (((infoMenu =='c')&&((fct == 'C')||(fct == 'M'))) || ((infoMenu == 'p')&&((fct == 'C')||fct == 'M'))) {
            ControleSaisie ctrl = new ControleSaisie();
            ctrl.setSiret(jTextFieldComplementSiret.getText());
            ctrl.ctrlSiret();

            //Mets le texte du label en rouge si condition non remplie
            if (!ctrl.isValidationSiret()) {
                jLabelComplementSiret.setForeground(Color.red);
                validationSiretPossible = false;
            } else {
                jLabelComplementSiret.setForeground(Color.black);
                validationSiretPossible = true;
            }
        }
        
        //Controle nom contact
        if ((fct == 'C' ) || (fct == 'M')) {
            //Méthode de controle saisie (2 < longueur champ < 30)
            ControleSaisie ctrl = new ControleSaisie();
            ctrl.setLongueur(jTextFieldContactNom.getText().length());
            ctrl.ctrlLongueur();

            //Mets le texte du label en rouge si condition non remplie
            if (!ctrl.isValidationLongueur()) {
                jLabelContactNom.setForeground(Color.red);
                validationNomContactPossible = false;
            } else {
                jLabelContactNom.setForeground(Color.black);
                validationNomContactPossible = true;
            }  
        }      
        
        //Controle ville
        if ((fct == 'C' ) || (fct == 'M')) {
            //Méthode de controle saisie (2 < longueur champ < 30)
            ControleSaisie ctrl = new ControleSaisie();
            ctrl.setLongueur(jTextFieldAdresseVille.getText().length());
            ctrl.ctrlLongueur();

            //Mets le texte du label en rouge si condition non remplie
            if (!ctrl.isValidationLongueur()) {
                jLabelAdresseVille.setForeground(Color.red);
                validationVillePossible = false;
            } else {
                jLabelAdresseVille.setForeground(Color.black);
                validationVillePossible = true;
            }  
        }
        
        //Controle salaire fixe
        if ((fct == 'C') || (fct == 'M')) {
            ControleSaisie ctrl = new ControleSaisie();
            ctrl.setValeurATesterFloat(jTextFieldComplementSalaireFixeBrut.getText());
            ctrl.ctrlValeurFloat();

            //Mets le texte du label en rouge si condition non remplie
            if (!ctrl.isValidationValeurFloat()) {
                jLabelComplementSalaireFixeBrut.setForeground(Color.red);
                validationSalaireFixePossible = false;
            } else {
                jLabelComplementSalaireFixeBrut.setForeground(Color.black);
                validationSalaireFixePossible = true;
            }
        }
        
        //Controle taux de commission
        if ((fct == 'C') || (fct == 'M')) {
            ControleSaisie ctrl = new ControleSaisie();
            ctrl.setValeurATesterFloat(jTextFieldComplementTauxDeCommission.getText());
            ctrl.ctrlValeurFloat();

            //Mets le texte du label en rouge si condition non remplie
            if (!ctrl.isValidationValeurFloat()) {
                jLabelComplementTauxDeCommission.setForeground(Color.red);
                validationTauxCommissionPossible = false;
            } else {
                jLabelComplementTauxDeCommission.setForeground(Color.black);
                validationTauxCommissionPossible = true;
            }
        }
        
        //Controle commandes int
        if ((fct == 'C') || (fct == 'M')) {
            ControleSaisie ctrl = new ControleSaisie();
            ctrl.setValeurATesterInt(jTextFieldInformationCommercialeCommande.getText());
            ctrl.ctrlValeurInt();

            //Mets le texte du label en rouge si condition non remplie
            if (!ctrl.isValidationValeurInt()) {
                jLabelInformationCommercialeCommande.setForeground(Color.red);
                validationCommandePossible = false;
            } else {
                jLabelInformationCommercialeCommande.setForeground(Color.black);
                validationCommandePossible = true;
            }
        }
        
        //Controle telephone1
        int numPays = jComboBoxPays.getSelectedIndex();
        if (((fct == 'C') || (fct == 'M'))&&(numPays == 11)) {
            ControleSaisie ctrl = new ControleSaisie();
            ctrl.setTelephone(jTextFieldContactTelephone1.getText());
            ctrl.ctrlTelephoneFrance();

            //Mets le texte du label en rouge si condition non remplie
            if (!ctrl.isValidationTelephoneFrance()) {
                jLabeContactTelephone.setForeground(Color.red);
                validationTelephonePossible = false;
            } else {
                jLabeContactTelephone.setForeground(Color.black);
                validationTelephonePossible = true;
            }
        }
        
        //Controle mail
        if ((fct == 'C') || (fct == 'M')) {
            ControleSaisie ctrl = new ControleSaisie();
            ctrl.seteMail(jTextFieldContactMail.getText());
            ctrl.ctrlEMail();

            //Mets le texte du label en rouge si condition non remplie
            if (!ctrl.isValidationEMail()) {
                jLabelContactMail.setForeground(Color.red);
                validationMailPossible = false;
            } else {
                jLabelContactMail.setForeground(Color.black);
                validationMailPossible = true;
            }
        }
        
        //Controle Code Postal
        numPays = jComboBoxPays.getSelectedIndex();
        if (((fct == 'C') || (fct == 'M'))&&(numPays == 11)) {
            ControleSaisie ctrl = new ControleSaisie();
            ctrl.setCp(jTextFieldAdresseCP.getText());
            ctrl.ctrlCodePostal();

            //Mets le texte du label en rouge si condition non remplie
            if (!ctrl.isValidationCP()) {
                jLabelAdresseCP.setForeground(Color.red);
                validationCpPossible = false;
            } else {
                jLabelAdresseCP.setForeground(Color.black);
                validationCpPossible = true;

            }
        }
        
        //Controle adresse
        if ((fct == 'C') || (fct == 'M')) {
            ControleSaisie ctrl = new ControleSaisie();
            ctrl.setLongueur(jTextFieldAdresseNumeroRue.getText().length());
            ctrl.ctrlNonVide();

            //Mets le texte du label en rouge si condition non remplie
            if (!ctrl.isValidationNonVide()) {
                jLabelAdresseNumeroRue.setForeground(Color.red);
                validationAdressePossible = false;
            } else {
                jLabelAdresseNumeroRue.setForeground(Color.black);
                validationAdressePossible = true;
            }
        }
        
        //Controle Nom ou Enseigne
        if ((fct == 'C' ) || (fct == 'M')) {
            //Méthode de controle saisie (2 < longueur champ < 30)
            ControleSaisie ctrl = new ControleSaisie();
            ctrl.setLongueur(jTextFieldDenominationNomSociete.getText().length());
            ctrl.ctrlLongueur();

            //Mets le texte du label en rouge si condition non remplie
            if (!ctrl.isValidationLongueur()) {
                jLabelDenominationNomSociete.setForeground(Color.red);
                validationNomEnseignePossible = false;
            } else {
                jLabelDenominationNomSociete.setForeground(Color.black);
                validationNomEnseignePossible = true;
            }
            
            //Mets le texte du label en rouge si condition non remplie -> Pays
            numPays = jComboBoxPays.getSelectedIndex();
            if (numPays == 0){
                jLabelAdressePays.setForeground(Color.red);
                validationPaysPossible = false;
            }else{
                jLabelAdressePays.setForeground(Color.black);
                validationPaysPossible = true;
            }
        }
        
        //validation date
        if (infoMenu == 'p'){
            String dateString = jTextFieldDerniereProspectionDate.getText();
            ControleSaisie ctrl = new ControleSaisie();
            ctrl.ctrlDate(jTextFieldDerniereProspectionDate.getText());
            if (ctrl.ctrlDate(dateString)== true){
                jLabelDerniereProspectionDate.setForeground(Color.black);
                validationDatePossible = true;
            }else{
                jLabelDerniereProspectionDate.setForeground(Color.red);
                validationDatePossible = false;
            }
        }
        
        switch (infoMenu){
            case 'r':
                if ((validationNomContactPossible == true) && (validationVillePossible == true) && (validationSalaireFixePossible == true) && 
                        (validationTauxCommissionPossible == true) && (validationMailPossible == true)&& (validationCpPossible == true) && 
                        (validationAdressePossible == true)&& (validationNomEnseignePossible == true)&&(validationPaysPossible == true)&&(validationTelephonePossible == true)){
                    validationPossible = true;
                    System.out.println("Validation representant vraie "+validationPossible);
                }else{
                    validationPossible = false;
                    System.out.println("Validation representant fausse "+validationPossible);
                }
                break;
            
            case 'c':
                if ((validationNomContactPossible == true) && (validationVillePossible == true)  && (validationMailPossible == true)&& (validationCpPossible == true) && 
                        (validationAdressePossible == true)&& (validationNomEnseignePossible == true)&& (validationSiretPossible == true) && 
                        (validationCommandePossible == true)&&(validationPaysPossible == true)&&(validationTelephonePossible == true)){
                    validationPossible = true;
                    System.out.println("Validation client vraie "+validationPossible);
                }else{
                    validationPossible = false;
                    System.out.println("Validation client fausse "+validationPossible);
                }
                break;
                
            case 'p':
                if ((validationNomContactPossible == true) && (validationVillePossible == true)  && (validationMailPossible == true)&& (validationCpPossible == true) && 
                        (validationAdressePossible == true)&& (validationNomEnseignePossible == true)&& (validationSiretPossible == true)
                        &&(validationPaysPossible == true)&&(validationTelephonePossible == true)&&(validationDatePossible == true)){
                    validationPossible = true;
                    System.out.println("Validation prospect vraie "+validationPossible);
                }else{
                    validationPossible = false;
                    System.out.println("Validation prospect fausse "+validationPossible);
                }
                break;
        }
    }
        
    private void modeEdition(){
        
           //Lorsque l'on clique sur modifier  on rend les champs modifiable sauf jTextFieldDenominationIdentifiant (Identifiant)
        JTextField[] tabsaisie = {jTextFieldDenominationNomSociete, jTextFieldAdresseNumeroRue, jTextFieldAdresseComplement,
            jTextFieldAdresseCP, jTextFieldAdresseVille, jTextFieldAdresseCedex, jTextFieldContactNom,
            jTextFieldContactPrenom, jTextFieldContactTelephone1, jTextFieldContactTelephone2, jTextFieldContactFax,
            jTextFieldContactMail, jTextFieldComplementSiret, jTextFieldComplementSalaireFixeBrut, jTextFieldComplementTauxDeCommission,
            jTextFieldDerniereProspectionDate, jTextFieldInformationCommercialeCommande};

        for (JTextField tabsaisie1 : tabsaisie) {
            tabsaisie1.setEditable(true);
        } 
        
        //Cache texteField  et affiche comboBox Pays
        jTextFieldPays.setVisible(false);
        jComboBoxPays.setVisible(true);
        
        //Affiche les boutons Enregister et Annuler
        jButtonEnregister.setVisible(true);
        jButtonAnnuler.setVisible(true);
        
        if (infoMenu == 'r'){
            jTextFieldContactNom.setEditable(false);
        }else if ((infoMenu == 'c') || (infoMenu == 'p')){
            jTextFieldContactNom.setEditable(true);
        }
    }
    
    private void rowTofields(){
        
        if (fct == 'V'){


        switch (infoMenu) {

            case 'r':
                int ligneSelectionne = jTableRepresentant.getSelectedRow();
                if (ligneSelectionne < 0) {
               } else {
               
                    //on récupére la valeur de la première colonne de la ligne sélectionné
                    int identifiant = (int) jTableRepresentant.getValueAt(ligneSelectionne, 0);
                    String ident = Integer.toString(identifiant);
                    
                    jTextFieldDenominationIdentifiant.setText(ident);
                    System.out.println("Représentant dans array list methode rowToFields : "+r.get(ligneSelectionne));                    
                    jTextFieldDenominationNomSociete.setText(r.get(ligneSelectionne).getNomRepresentant());
                    jTextFieldAdresseVille.setText(r.get(ligneSelectionne).getVille());
                    jTextFieldComplementSalaireFixeBrut.setText(r.get(ligneSelectionne).getSalaireFixe());
                    jTextFieldComplementTauxDeCommission.setText(r.get(ligneSelectionne).getTauxCommission());
                    jTextFieldContactNom.setText(r.get(ligneSelectionne).getNomRepresentant());
                    jTextFieldContactPrenom.setText(r.get(ligneSelectionne).getPrenom());
                    jTextFieldAdresseNumeroRue.setText(r.get(ligneSelectionne).getNumRueAdresse());
                    jTextFieldAdresseComplement.setText(r.get(ligneSelectionne).getComplementAdresse());
                    jTextFieldAdresseCP.setText(r.get(ligneSelectionne).getCp());
                    jTextFieldAdresseCedex.setText(r.get(ligneSelectionne).getCedex());
                    jTextFieldPays.setText(r.get(ligneSelectionne).getPays());
                    jComboBoxPays.setSelectedItem(r.get(ligneSelectionne).getPays());
                    jTextFieldContactTelephone1.setText(r.get(ligneSelectionne).getTelephone());
                    jTextFieldContactTelephone2.setText(r.get(ligneSelectionne).getTelephonePortable());
                    jTextFieldContactFax.setText(r.get(ligneSelectionne).getFax());
                    jTextFieldContactMail.setText(r.get(ligneSelectionne).getEmail());
                    /*String ville = (String) jTableRepresentant.getValueAt(ligneSelectionne, 2);
                    jTextFieldAdresseVille.setText(ville);
                    String salaireFixe = (String) jTableRepresentant.getValueAt(ligneSelectionne, 3);
                    jTextFieldComplementSalaireFixeBrut.setText(salaireFixe);
                    String tauxComm = (String) jTableRepresentant.getValueAt(ligneSelectionne, 4);
                    jTextFieldComplementTauxDeCommission.setText(tauxComm);
                    String nom = (String) jTableRepresentant.getValueAt(ligneSelectionne, 5);
                    jTextFieldContactNom.setText(nom);
                    String prenom = (String) jTableRepresentant.getValueAt(ligneSelectionne, 6);
                    jTextFieldContactPrenom.setText(prenom);
                    String adresse = (String) jTableRepresentant.getValueAt(ligneSelectionne, 7);
                    jTextFieldAdresseNumeroRue.setText(adresse);
                    String complement = (String) jTableRepresentant.getValueAt(ligneSelectionne, 8);
                    jTextFieldAdresseComplement.setText(complement);
                    String cp = (String) jTableRepresentant.getValueAt(ligneSelectionne, 9);
                    jTextFieldAdresseCP.setText(cp);
                    String cedex = (String) jTableRepresentant.getValueAt(ligneSelectionne, 10);
                    jTextFieldAdresseCedex.setText(cedex);
                    String pays = (String) jTableRepresentant.getValueAt(ligneSelectionne, 11);
                    jComboBoxPays.setSelectedItem(pays);
                    jTextFieldPays.setText(pays);
                    String tel = (String) jTableRepresentant.getValueAt(ligneSelectionne, 12);
                    jTextFieldContactTelephone1.setText(tel);
                    String tel2 = (String) jTableRepresentant.getValueAt(ligneSelectionne, 13);
                    jTextFieldContactTelephone2.setText(tel2);
                    String fax = (String) jTableRepresentant.getValueAt(ligneSelectionne, 14);
                    jTextFieldContactFax.setText(fax);
                    String mail = (String) jTableRepresentant.getValueAt(ligneSelectionne, 15);
                    jTextFieldContactMail.setText(mail);*/
                }
                break;

            case 'c':
                
                int ligneSelectionne2 = jTableClient.getSelectedRow();
                if (ligneSelectionne2 < 0) {
                //    showMessageDialog(null, "Merci de selectionner une fiche client à modifier", "Sélectionnez fiche", JOptionPane.INFORMATION_MESSAGE);
                } else {
                
                //on récupére la valeur de la première colonne de la ligne sélectionné
                    int identifiant = (int) jTableClient.getValueAt(ligneSelectionne2, 0);
                    String ident = Integer.toString(identifiant);
                    
                    jTextFieldDenominationIdentifiant.setText(ident);
                    System.out.println("Client dans array list methode rowToFields : "+client.get(ligneSelectionne2));                    
                    jTextFieldDenominationNomSociete.setText(client.get(ligneSelectionne2).getEnseigneClient());
                    jTextFieldAdresseVille.setText(client.get(ligneSelectionne2).getVille());
                    jTextFieldComplementSiret.setText(client.get(ligneSelectionne2).getSiret());
                    jTextFieldComplementRepresentant.setText(client.get(ligneSelectionne2).getRepresentant());
                    jComboBoxRepresentants.setSelectedItem(client.get(ligneSelectionne2).getRepresentant());
                    jTextFieldInformationCommercialeCommande.setText(client.get(ligneSelectionne2).getNombreCommandePassees());
                    jTextFieldContactNom.setText(client.get(ligneSelectionne2).getNom());
                    jTextFieldContactPrenom.setText(client.get(ligneSelectionne2).getPrenom());
                    jTextFieldAdresseNumeroRue.setText(client.get(ligneSelectionne2).getNumRueAdresse());
                    jTextFieldAdresseComplement.setText(client.get(ligneSelectionne2).getComplementAdresse());
                    jTextFieldAdresseCP.setText(client.get(ligneSelectionne2).getCp());
                    jTextFieldAdresseCedex.setText(client.get(ligneSelectionne2).getCedex());
                    jTextFieldPays.setText(client.get(ligneSelectionne2).getPays());
                    jComboBoxPays.setSelectedItem(client.get(ligneSelectionne2).getPays());
                    jTextFieldContactTelephone1.setText(client.get(ligneSelectionne2).getTelephone());
                    jTextFieldContactTelephone2.setText(client.get(ligneSelectionne2).getTelephonePortable());
                    jTextFieldContactFax.setText(client.get(ligneSelectionne2).getFax());
                    jTextFieldContactMail.setText(client.get(ligneSelectionne2).getEmail());

              /* 
                
                    System.out.println("ligne client à modifier classeRepCliProsp = " + ligneSelectionne2);

                    int identifiant2 = (int) jTableClient.getValueAt(ligneSelectionne2, 0);
                    String ident2 = Integer.toString(identifiant2);
                    jTextFieldDenominationIdentifiant.setText(ident2);
                    String enseigne = (String) jTableClient.getValueAt(ligneSelectionne2, 1);
                    jTextFieldDenominationNomSociete.setText(enseigne);
                    String siret = (String) jTableClient.getValueAt(ligneSelectionne2, 2);
                    jTextFieldComplementSiret.setText(siret);
                    String nombreCommande = (String) jTableClient.getValueAt(ligneSelectionne2, 3);
                    jTextFieldInformationCommercialeCommande.setText(nombreCommande);
                    String representant = (String) jTableClient.getValueAt(ligneSelectionne2, 4);
                    jComboBoxRepresentants.setSelectedItem(representant);
                    jTextFieldComplementRepresentant.setText(representant);
                    String nom2 = (String) jTableClient.getValueAt(ligneSelectionne2, 5);
                    jTextFieldContactNom.setText(nom2);
                    String prenom2 = (String) jTableClient.getValueAt(ligneSelectionne2, 6);
                    jTextFieldContactPrenom.setText(prenom2);
                    String adresse2 = (String) jTableClient.getValueAt(ligneSelectionne2, 7);
                    jTextFieldAdresseNumeroRue.setText(adresse2);
                    String cp2 = (String) jTableClient.getValueAt(ligneSelectionne2, 8);
                    jTextFieldAdresseCP.setText(cp2);
                    String ville2 = (String) jTableClient.getValueAt(ligneSelectionne2, 9);
                    jTextFieldAdresseVille.setText(ville2);
                    String pays2 = (String) jTableClient.getValueAt(ligneSelectionne2, 10);
                    jComboBoxPays.setSelectedItem(pays2);
                    jTextFieldPays.setText(pays2);
                    String tel3 = (String) jTableClient.getValueAt(ligneSelectionne2, 11);
                    jTextFieldContactTelephone1.setText(tel3);
                    String tel4 = (String) jTableClient.getValueAt(ligneSelectionne2, 12);
                    jTextFieldContactTelephone2.setText(tel4);
                    String fax2 = (String) jTableClient.getValueAt(ligneSelectionne2, 13);
                    jTextFieldContactFax.setText(fax2);
                    String mail2 = (String) jTableClient.getValueAt(ligneSelectionne2, 14);
                    jTextFieldContactMail.setText(mail2);
                    String cedex2 = (String) jTableClient.getValueAt(ligneSelectionne2, 15);
                    jTextFieldAdresseCedex.setText(cedex2);
                    String complement2 = (String) jTableClient.getValueAt(ligneSelectionne2, 16);
                    jTextFieldAdresseComplement.setText(complement2);*/
                }
                break;

            case 'p':
               
                int ligneSelectionne3 = 0;
                ligneSelectionne3 = jTableProspect.getSelectedRow();
                if (ligneSelectionne3 < 0) {
              //      showMessageDialog(null, "Merci de selectionner une fiche prospect à modifier", "Sélectionnez fiche", JOptionPane.INFORMATION_MESSAGE);
                } else {
                  
                    //on récupére la valeur de la première colonne de la ligne sélectionné
                    int identifiant = (int) jTableProspect.getValueAt(ligneSelectionne3, 0);
                    String ident = Integer.toString(identifiant);
                    
                    jTextFieldDenominationIdentifiant.setText(ident);
                    System.out.println("Prospect dans array list methode rowToFields : "+pro.get(ligneSelectionne3));                    
                    jTextFieldDenominationNomSociete.setText(pro.get(ligneSelectionne3).getEnseigneProspect());
                    jTextFieldAdresseVille.setText(pro.get(ligneSelectionne3).getVille());
                    jTextFieldComplementSiret.setText(pro.get(ligneSelectionne3).getSiret());
                    jTextFieldComplementRepresentant.setText(pro.get(ligneSelectionne3).getRepresentant());
                    jComboBoxRepresentants.setSelectedItem(pro.get(ligneSelectionne3).getRepresentant());
                    jTextFieldDerniereProspectionDate.setText(pro.get(ligneSelectionne3).getDerniereProspectionDate());
                    jTextFieldContactNom.setText(pro.get(ligneSelectionne3).getNom());
                    jTextFieldContactPrenom.setText(pro.get(ligneSelectionne3).getPrenom());
                    jTextFieldAdresseNumeroRue.setText(pro.get(ligneSelectionne3).getNumRueAdresse());
                    jTextFieldAdresseComplement.setText(pro.get(ligneSelectionne3).getComplementAdresse());
                    jTextFieldAdresseCP.setText(pro.get(ligneSelectionne3).getCp());
                    jTextFieldAdresseCedex.setText(pro.get(ligneSelectionne3).getCedex());
                    jTextFieldPays.setText(pro.get(ligneSelectionne3).getPays());
                    jComboBoxPays.setSelectedItem(pro.get(ligneSelectionne3).getPays());
                    jTextFieldContactTelephone1.setText(pro.get(ligneSelectionne3).getTelephone());
                    jTextFieldContactTelephone2.setText(pro.get(ligneSelectionne3).getTelephonePortable());
                    jTextFieldContactFax.setText(pro.get(ligneSelectionne3).getFax());
                    jTextFieldContactMail.setText(pro.get(ligneSelectionne3).getEmail());
                    /*
                    System.out.println("ligne client à modifier classeRepCliProsp = " + ligneSelectionne3);

                    int identifiant3 = (int) jTableProspect.getValueAt(ligneSelectionne3, 0);
                    String ident3 = Integer.toString(identifiant3);
                    jTextFieldDenominationIdentifiant.setText(ident3);
                    String nomProspect = (String) jTableProspect.getValueAt(ligneSelectionne3, 1);
                    jTextFieldDenominationNomSociete.setText(nomProspect);
                    String ville3 = (String) jTableProspect.getValueAt(ligneSelectionne3, 2);
                    jTextFieldAdresseVille.setText(ville3);
                    String derniereVisite = (String) jTableProspect.getValueAt(ligneSelectionne3, 3);
                    jTextFieldDerniereProspectionDate.setText(derniereVisite);
                    String siret3 = (String) jTableProspect.getValueAt(ligneSelectionne3, 4);
                    jTextFieldComplementSiret.setText(siret3);
                    String representant3 = (String) jTableProspect.getValueAt(ligneSelectionne3, 5);
                    jTextFieldComplementRepresentant.setText(representant3);
                    String nom3 = (String) jTableProspect.getValueAt(ligneSelectionne3, 6);
                    jTextFieldContactNom.setText(nom3);
                    String prenom3 = (String) jTableProspect.getValueAt(ligneSelectionne3, 7);
                    jTextFieldContactPrenom.setText(prenom3);
                    String adresse3 = (String) jTableProspect.getValueAt(ligneSelectionne3, 8);
                    jTextFieldAdresseNumeroRue.setText(adresse3);
                    String cp3 = (String) jTableProspect.getValueAt(ligneSelectionne3, 9);
                    jTextFieldAdresseCP.setText(cp3);
                    String ville4 = (String) jTableProspect.getValueAt(ligneSelectionne3, 10);
                    jTextFieldAdresseVille.setText(ville3);
                    String pays3 = (String) jTableProspect.getValueAt(ligneSelectionne3, 11);
                    jComboBoxPays.setSelectedItem(pays3);
                    jTextFieldPays.setText(pays3);
                    String telp = (String) jTableProspect.getValueAt(ligneSelectionne3, 12);
                    jTextFieldContactTelephone1.setText(telp);
                    String tel2p = (String) jTableProspect.getValueAt(ligneSelectionne3, 13);
                    jTextFieldContactTelephone2.setText(tel2p);
                    String fax3 = (String) jTableProspect.getValueAt(ligneSelectionne3, 14);
                    jTextFieldContactFax.setText(fax3);
                    String email3 = (String) jTableProspect.getValueAt(ligneSelectionne3, 15);
                    jTextFieldContactMail.setText(email3);
                    String cedex3 = (String) jTableProspect.getValueAt(ligneSelectionne3, 16);
                    jTextFieldAdresseCedex.setText(cedex3);
                    String complement3 = (String) jTableProspect.getValueAt(ligneSelectionne3, 17);
                    jTextFieldAdresseComplement.setText(complement3);*/
                }
                break;
        }
        
    } else {
        }
        }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonEnregister;
    private javax.swing.JButton jButtonFermer;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JComboBox<String> jComboBoxPays;
    private javax.swing.JComboBox<String> jComboBoxRepresentants;
    private javax.swing.JLabel jLabeContactTelephone;
    private javax.swing.JLabel jLabeImage;
    private javax.swing.JLabel jLabelAdresseCP;
    private javax.swing.JLabel jLabelAdresseCedex;
    private javax.swing.JLabel jLabelAdresseComplement;
    private javax.swing.JLabel jLabelAdresseNumeroRue;
    private javax.swing.JLabel jLabelAdressePays;
    private javax.swing.JLabel jLabelAdresseVille;
    private javax.swing.JLabel jLabelComplementRepresentant;
    private javax.swing.JLabel jLabelComplementSalaireFixeBrut;
    private javax.swing.JLabel jLabelComplementSalaireFixeBrutEuro;
    private javax.swing.JLabel jLabelComplementSiret;
    private javax.swing.JLabel jLabelComplementTauxDeCommission;
    private javax.swing.JLabel jLabelComplementTauxDeCommissionPourcent;
    private javax.swing.JLabel jLabelContactFax;
    private javax.swing.JLabel jLabelContactMail;
    private javax.swing.JLabel jLabelContactNom;
    private javax.swing.JLabel jLabelContactPrenom;
    private javax.swing.JLabel jLabelDenominationIdentifiant;
    private javax.swing.JLabel jLabelDenominationNomSociete;
    private javax.swing.JLabel jLabelDerniereProspectionDate;
    private javax.swing.JLabel jLabelInformationCommercialeCommande;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuClient;
    private javax.swing.JMenu jMenuImprimer;
    private javax.swing.JMenu jMenuProspect;
    private javax.swing.JMenu jMenuRepresentant;
    private javax.swing.JPanel jPaneAdresse;
    private javax.swing.JPanel jPanelComplementClientProspect;
    private javax.swing.JPanel jPanelComplementRepresentant;
    private javax.swing.JPanel jPanelContact;
    private javax.swing.JPanel jPanelDenomination;
    private javax.swing.JPanel jPanelDerniereProspection;
    private javax.swing.JPanel jPanelFond;
    private javax.swing.JPanel jPanelInformationCommerciale;
    private javax.swing.JScrollPane jScrollPaneClient;
    private javax.swing.JScrollPane jScrollPaneProspect;
    private javax.swing.JScrollPane jScrollPaneRepresentant;
    private javax.swing.JTable jTableClient;
    private javax.swing.JTable jTableProspect;
    private javax.swing.JTable jTableRepresentant;
    private javax.swing.JTextField jTextFieldAdresseCP;
    private javax.swing.JTextField jTextFieldAdresseCedex;
    private javax.swing.JTextField jTextFieldAdresseComplement;
    private javax.swing.JTextField jTextFieldAdresseNumeroRue;
    private javax.swing.JTextField jTextFieldAdresseVille;
    private javax.swing.JTextField jTextFieldComplementRepresentant;
    private javax.swing.JTextField jTextFieldComplementSalaireFixeBrut;
    private javax.swing.JTextField jTextFieldComplementSiret;
    private javax.swing.JTextField jTextFieldComplementTauxDeCommission;
    private javax.swing.JTextField jTextFieldContactFax;
    private javax.swing.JTextField jTextFieldContactMail;
    private javax.swing.JTextField jTextFieldContactNom;
    private javax.swing.JTextField jTextFieldContactPrenom;
    private javax.swing.JTextField jTextFieldContactTelephone1;
    private javax.swing.JTextField jTextFieldContactTelephone2;
    private javax.swing.JTextField jTextFieldDenominationIdentifiant;
    private javax.swing.JTextField jTextFieldDenominationNomSociete;
    private javax.swing.JTextField jTextFieldDerniereProspectionDate;
    private javax.swing.JTextField jTextFieldInformationCommercialeCommande;
    private javax.swing.JTextField jTextFieldPays;
    // End of variables declaration//GEN-END:variables
    
  
}
