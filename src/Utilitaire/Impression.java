/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

import java.io.*;


public class Impression{
  public final static String NAV = "rundll32 url.dll,FileProtocolHandler";
  
  static String texteAImprimer2;

  public void imprimer() {
    try {
      File tmpFile = File.createTempFile("Impression", ".html");
      String filePath = tmpFile.getCanonicalPath();
      FileOutputStream fos = new FileOutputStream(tmpFile);
      PrintStream  doc = new PrintStream(fos);
      doc.println("<HTML><head><title>Fiche</title></head>");
      doc.println("<body>");
      doc.println("<h1>"+ "Titre de la fiche" +"</h1>");
      doc.println("Voici la fiche à imprimer");
      doc.println("<p>Le fichier généré est <code>"+filePath+"</code>.");
      doc.println("</body></Html>");
      doc.flush(); doc.close();
      fos.close();

      Runtime run = Runtime.getRuntime();
      run.exec(NAV + " " + filePath);
      run.wait(50); // Time to run navigator before removing file.
      tmpFile.deleteOnExit();
    } catch (Exception e) {
       e.printStackTrace();
    }
  }

    
}