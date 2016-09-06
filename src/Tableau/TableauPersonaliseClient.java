/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tableau;

import Classe.Client;
import java.awt.BorderLayout;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ldescamps
 */
public class TableauPersonaliseClient extends AbstractTableModel {

    private final List<Client> client1 = new ArrayList<Client>();
    private final String[] entetes = {"Identifiant", "NomEnseigne", "Ville", "Email", "NombreCommandes","Siret"};
    
    public  TableauPersonaliseClient()
    {
        super();
        client1.add(new Client("Ikea","001","0555555555555","18","Lacombe","Bernard","163, rue de clés","59000","Lille","France","0379663253","0609882912","08888888888","bouya@bouya.com","",""));
            
        
    }
     public int getRowCount() {
        return client1.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return client1.get(rowIndex).getIdClient();
            case 1:
                return client1.get(rowIndex).getEnseigneClient();
            case 2:
                return client1.get(rowIndex).getVille();
            case 3:
                return client1.get(rowIndex).getEmail();
            case 4:
                return client1.get(rowIndex).getNombreCommandePassees();
            case 5:
                return client1.get(rowIndex).getSiret();
        
            default:
                return null; //Ne devrait jamais arriver
        }
    }
    
    public void ajouterClient(Client clients){
        client1.add(clients);
        
        fireTableRowsInserted(client1.size()-1,client1.size()-1);
    }
     
    
    
}