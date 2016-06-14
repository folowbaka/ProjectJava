/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import projectjava.Adherent;

/**
 *
 * @author david
 */
public class ListeElement<T> extends VBox {
    private TableView<T> table;
    ObservableList<T> data;
    public ListeElement(String nomTable,String[] nomColonne,String[] attribut)
    {
        super();
        this.table=new TableView();
        table.setEditable(true);
        Label titreTable=new Label(nomTable);
        this.setId("listeElement");
        titreTable.setId("TitreTable");
        this.table.setEditable(true);
        for(int i=0;i<nomColonne.length;i++)
        {
            TableColumn tc=new TableColumn(nomColonne[i]);
            tc.prefWidthProperty().bind(this.table.widthProperty().divide(nomColonne.length));
            tc.setCellValueFactory(new PropertyValueFactory<T,String>(attribut[i]));
            table.getColumns().add(tc);
        }
         this.setPadding(new Insets(10, 0, 0, 10));
         this.getChildren().addAll(titreTable, table);
        
    }
    public void setData(ArrayList<T> ar)
    {
        this.data=FXCollections.observableArrayList(ar);
        this.table.setItems(this.data);
    }
}
