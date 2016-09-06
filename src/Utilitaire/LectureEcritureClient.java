/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;
import Classe.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author mhaynez
 */
public class LectureEcritureClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //try {
        //ecriture();
        lecture();

    }

    public void ecriture() {
        Client client1 = new Client("Igena", "001", "0555555555555", "18", "Lacombe", "Bernard", "163, rue de clés","complement", "59000", "Lille","cedex", "France", "0379663253", "0609882912", "08888888888", "bouya@bouya.com");
        String chaineInfoclient = client1.toString();
        try {
            FileWriter fw = new FileWriter("Client.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            PrintWriter pw = new PrintWriter(bw);
            //new FileWriter(new File("Client.txt")).close();       //<----- permet d'ecraser completement le fichier!
            pw.print(chaineInfoclient);
            pw.close();
        } catch (IOException e) {
            System.out.println(" Problème à l’écriture du fichier ");
            System.exit(0);
        }

        showMessageDialog(null, "Sauvegarde effectuée", "Backup", JOptionPane.INFORMATION_MESSAGE);

    }
    
    
    public static void lecture() throws IOException {
        BufferedReader lecteurAvecBuffer = null;
        String ligne;

        try {
            lecteurAvecBuffer = new BufferedReader(new FileReader("Client.txt"));
        } catch (FileNotFoundException exc) {
            System.out.println("Erreur d'ouverture");
        }
        while ((ligne = lecteurAvecBuffer.readLine()) != null) {
            System.out.println(ligne);
        }
        lecteurAvecBuffer.close();

    }
    
    
    
    public static void modifier()
    {
    //Construction
    
    }

    
}
