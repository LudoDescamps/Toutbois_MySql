/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

import IHM.RepCliProsp;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author ldescamps
 */
public class Sauvegarde {
    
    public void sauvegarder() {
        
        
        try {
            FileWriter fw = new FileWriter("Backup.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            PrintWriter pw = new PrintWriter(bw);
            pw.print("texte à imprimer");
            pw.close();
        } catch (IOException e) {
            System.out.println(" Problème à l’écriture du fichier ");
            System.exit(0);
        }
        showMessageDialog(null, "Sauvegarde effectuée", "Backup", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
