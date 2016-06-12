/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

/**
 *
 * @author david
 */
public class ListeElement extends VBox {
    private TableView table;
    
    public ListeElement(String nomTable,String[] nomColonne)
    {
        super();
        this.table=new TableView();
        Label titreTable=new Label(nomTable);
        this.table.setEditable(true);
        for(int i=0;i<nomColonne.length;i++)
        {
            TableColumn tc=new TableColumn(nomColonne[i]);
            table.getColumns().add(tc);
        }
         this.setPadding(new Insets(10, 0, 0, 10));
         this.getChildren().addAll(titreTable, table);
        
    }
}
