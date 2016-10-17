/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tableau;

import Classe.Prospect;
import static IHM.RepCliProsp.client;
import static IHM.RepCliProsp.pro;
import javax.swing.JTable;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ldescamps
 */
public class ModeleDynamiqueProspect extends AbstractTableModel{
    /*private final String[] entetes = {"Identifiant", "Enseigne", "Ville", "Dernière visite","SIRET",
        "Représentant","Nom contact","Prénom contact","Adresse","CP","Ville","Pays", "Téléphone","Téléphone 2",
        "Fax","Email","Cedex","Complément Adresse"};*/
    private final String[] entetes = {"Identifiant", "Enseigne", "Ville", "Dernière visite","SIRET",
        "Représentant","Nom contact","Ville","Pays", "Téléphone", "Fax","Email"};
 
    public ModeleDynamiqueProspect() {
        super();
       
    }
 
    @Override
    public int getRowCount() {
        return pro.size();
    }
 
    @Override
    public int getColumnCount() {
        return entetes.length;
    }
 
    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return pro.get(rowIndex).getIdProspect();
            case 1:
                return pro.get(rowIndex).getEnseigneProspect();
            case 2:
                return pro.get(rowIndex).getVille();
            case 3:
                return pro.get(rowIndex).getDerniereProspectionDate();
            case 4:
                return pro.get(rowIndex).getSiret();
                case 5:
                return pro.get(rowIndex).getRepresentant();
            case 6:
                return pro.get(rowIndex).getNom();
            case 7:
                return pro.get(rowIndex).getPrenom();
            case 8:
                return pro.get(rowIndex).getNumRueAdresse();
            case 9:
                return pro.get(rowIndex).getCp();
            case 10:
                return pro.get(rowIndex).getVille();
            case 11:
                return pro.get(rowIndex).getPays();
            case 12:
                return pro.get(rowIndex).getTelephone();
            case 13:
                return pro.get(rowIndex).getTelephonePortable();
            case 14:
                return pro.get(rowIndex).getFax();
            case 15:
                return pro.get(rowIndex).getEmail();
            case 16:
                return pro.get(rowIndex).getCedex();
            case 17:
                return pro.get(rowIndex).getComplementAdresse();
            default:
                return null;
        }
    }
 
    public void addPro(Prospect prospect) {
        pro.add(prospect);
 
        fireTableRowsInserted(pro.size() -1, pro.size() -1);
    }
 
    public void removePro(int rowIndex) {
        pro.remove(rowIndex);
 
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void removeAllPro(JTable model) {
        for (int i = model.getRowCount(); i > 0; --i) {
            pro.remove(i - 1);
        }
    }

}
