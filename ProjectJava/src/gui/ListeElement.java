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
import projectjava.Livre;

/**
 *
 * @author david
 */
public class ListeElement<T> extends VBox {
    private TableView<T> table;
    private ObservableList<T> data;
    private T valeur;
    public ListeElement(String nomTable,String[] nomColonne,String[] attribut,T test)
    {
        super();
        this.valeur=test;
        this.table=new TableView();
        table.setEditable(true);
        Label titreTable=new Label(nomTable);
        this.setId("listeElement");
        titreTable.setId("TitreTable");
        this.table.setEditable(true);
        if(valeur instanceof Livre)
        {
            int i=0;
            while(i<nomColonne.length)
            {
                TableColumn tc=new TableColumn(nomColonne[i]);
                if(i==2)
                {
                    i++;
                    TableColumn tc1=new TableColumn(nomColonne[i]);
                    tc1.prefWidthProperty().bind(tc.widthProperty().divide(2));
                    tc1.setCellValueFactory(new PropertyValueFactory<T,String>(attribut[i]));
                    i++;
                    TableColumn tc2=new TableColumn(nomColonne[i]);
                    tc2.prefWidthProperty().bind(tc.widthProperty().divide(2));
                    tc2.setCellValueFactory(new PropertyValueFactory<T,String>(attribut[i]));
                    tc.getColumns().addAll(tc1,tc2);
                }
                else
                    tc.setCellValueFactory(new PropertyValueFactory<T,String>(attribut[i]));
                System.out.println(attribut[i]);
                tc.prefWidthProperty().bind(this.table.widthProperty().divide(nomColonne.length-2));
                table.getColumns().add(tc);
                i++;
            }
        }
        else
        {
            for(int i=0;i<nomColonne.length;i++)
            {
                TableColumn tc=new TableColumn(nomColonne[i]);
                tc.prefWidthProperty().bind(this.table.widthProperty().divide(nomColonne.length));
                tc.setCellValueFactory(new PropertyValueFactory<T,String>(attribut[i]));
                table.getColumns().add(tc);
            }
        }
        
        this.setPadding(new Insets(0, 50, 0, 50));
        this.getChildren().addAll(titreTable, table);
        
    }
    public void setData(ArrayList<T> ar)
    {
        this.data=FXCollections.observableArrayList(ar);
        this.table.setItems(this.data);
    }
    public TableView getTable()
    {
        return this.table;
    }
}
