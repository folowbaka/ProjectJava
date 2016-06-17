/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import projectjava.Adherent;
import projectjava.EmpruntE;
import projectjava.Livre;

/**
 *
 * @author david
 */
public class ListeElement<T> extends GridPane {
    private TableView<T> table;
    private ObservableList<T> data;
    private T test;
    private TextField search;
    private ChoiceBox chB;
    private int debRecherche;
    public ListeElement(String nomTable,String[] nomColonne,String[] attribut,T test)
    {
        super();
        this.test=test;
        this.table=new TableView();
        table.setEditable(true);
        this.setId("listeElement");
        this.table.setEditable(true);
        this.TitreListe(nomTable);
        if(test instanceof Livre)
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
        this.add(this.table, 0, 2);
        
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
    public TextField getSearch()
    {
        return this.search;
    }
    public ChoiceBox getChoix()
    {
        return this.chB;
    }
    public T getTest()
    {
        return this.test;
    }
    public void addSearch(String[] choix)
    {
        HBox recherche=new HBox();
        this.debRecherche=0;
        this.search=new TextField("Rechercher");
        this.getStyleClass().add("search");
        this.chB=new ChoiceBox(FXCollections.observableArrayList(choix));
        this.chB.getSelectionModel().selectFirst();
        recherche.getChildren().addAll(this.search,this.chB);
        this.add(recherche, 0, 1);
        
        this.search.setOnMousePressed(new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent me) {
        if(debRecherche==0)
        {
            search.clear();
            debRecherche++;
        }
    }
        });
        
    }
    public void TitreListe(String s)
    {
        StackPane titreTable=new StackPane();
        Label titre=new Label(s);
         titreTable.setId("TitreTable");
         titreTable.getChildren().add(titre);
         this.add(titreTable, 0, 0);
    }
}
