/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tableau;

import Classe.Client;
import static IHM.RepCliProsp.client;
import static IHM.RepCliProsp.r;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author mhaynez
 */
public class ModeleDynamiqueClient extends AbstractTableModel{

     /* private final String[] entetes = {"Id" , "Enseigne" ,"Siret","NombreCommande","Représentant", "Nom contact",
          "Prenom contact","Adresse","CP","Ville","Pays", "Téléphone","Téléphone 2","Fax","Email","Cedex",
          "ComplementAdresse"};*/
    private final String[] entetes = {"Id" , "Enseigne" ,"Siret","NombreCommande","Représentant", "Nom contact",
          "Ville","Pays", "Téléphone","Fax","Email",};

     public ModeleDynamiqueClient() {
        super();
        
    }
 
    @Override
    public int getRowCount() {
        return client.size();   
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
                return client.get(rowIndex).getIdClient();
            case 1:
                return client.get(rowIndex).getEnseigneClient();
            case 2:
                return client.get(rowIndex).getSiret();
            case 3:
                return client.get(rowIndex).getNombreCommandePassees();
            case 4 : 
                return client.get(rowIndex).getRepresentant();
            case 5 :
                return client.get(rowIndex).getNom();
            case 6:
                return client.get(rowIndex).getPrenom();
            case 7:
                return client.get(rowIndex).getNumRueAdresse();
            case 8:
                return client.get(rowIndex).getCp();
            case 9:
                return client.get(rowIndex).getVille();
            case 10:
                return client.get(rowIndex).getPays();
            case 11:
                return client.get(rowIndex).getTelephone();
            case 12:
                return client.get(rowIndex).getTelephonePortable();
            case 13:
                return client.get(rowIndex).getFax();
            case 14:
                return client.get(rowIndex).getEmail();
            case 15:
                return client.get(rowIndex).getCedex();    
            case 16:
                return client.get(rowIndex).getComplementAdresse();
            default:
                return null;
        }
    }
 
    public void addClient(Client cli) {
        client.add(cli);
 
        fireTableRowsInserted(client.size() -1, client.size() -1);
    }
 
    public void removeClient(int rowIndex) {
        client.remove(rowIndex);
 
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void removeAllCli( JTable model) {
       for (int i = model.getRowCount(); i > 0; --i){
                                client.remove(i-1);
   }
}
}
