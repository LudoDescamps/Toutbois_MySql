/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tableau;

import Classe.Representant;
import static IHM.RepCliProsp.r;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author caroline
 */
public class ModeleDynamiqueRepresentant extends AbstractTableModel {
    
 
   // private final String[] entetes = {"Identifiant", "Nom", "Ville", "Fixe Brut", "Taux Comm.","Nom", "Prénom", "Adresse", "Complément",
   //     "Code Postal","Cedex", "Pays", "Tél.", "Tél.2", "Fax","E-Mail"};
    private final String[] entetes = {"Identifiant", "Nom", "Ville", "Fixe Brut", "Taux Comm.",
        "Code Postal", "Pays", "Tél.",  "Fax","E-Mail"};
 
    public ModeleDynamiqueRepresentant() {
        super();
 
        
        
    }
 
    @Override
    public int getRowCount() {
        return r.size();
    }
 
    @Override
    public int getColumnCount() {
        return entetes.length;                       //remplacement de "return entetes.length" par la valeur 5 pour afficher les 4 colonnes necessaires
    }
 
    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0:
                return r.get(rowIndex).getIdRepresentant();
            case 1:
                return r.get(rowIndex).getNomRepresentant();
            case 2:
                return r.get(rowIndex).getVille();
            case 3:
                return r.get(rowIndex).getSalaireFixe();
            case 4:                                         
                return r.get(rowIndex).getTauxCommission();
            case 5:
                return r.get(rowIndex).getNom();
            case 6:
                return r.get(rowIndex).getPrenom();
            case 7:
                return r.get(rowIndex).getNumRueAdresse();
            case 8:
                return r.get(rowIndex).getComplementAdresse();
            case 9:
                return r.get(rowIndex).getCp();
            case 10:
                return r.get(rowIndex).getCedex();
            case 11:                                         
                return r.get(rowIndex).getPays();
            case 12:
                return r.get(rowIndex).getTelephone();
            case 13:
                return r.get(rowIndex).getTelephonePortable();
            case 14:                                         
                return r.get(rowIndex).getFax();
            case 15:
                return r.get(rowIndex).getEmail();
            default:
                return null;
        }
    
    }
    
 
    public void addRep(Representant representant) {
        r.add(representant);
 
       fireTableRowsInserted(r.size() -1, r.size() -1);
    }
 
    public void removeRep(int rowIndex) {
        r.remove(rowIndex);
 
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void removeAllRep( JTable model) {
       for (int i = model.getRowCount(); i > 0; --i){
                                r.remove(i-1);
   }
}

}