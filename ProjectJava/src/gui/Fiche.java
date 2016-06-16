/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 *
 * @author david
 */
public class Fiche extends GridPane{
    private ProjectJava pa;
    private ArrayList<TextField> valeur;
    private ArrayList<GridPane> sousForm;
    private Button supprimer;
    private Button modifier;
    private GridPane edition;
    private StackPane titre;
    private Label titreFiche;
    public Fiche(ProjectJava pa)
    {
        this.pa=pa;
        this.valeur=new ArrayList<TextField>();
        this.sousForm=new ArrayList<GridPane>();
        this.edition=new GridPane();
        this.titre=new StackPane();
        this.setVgap(30);
        this.setVisible(false);
        
    }
     public ProjectJava getPa()
    {
        return this.pa;
    }
    public ArrayList<TextField> getValeur()
    {
        return this.valeur;
    }
    public Button getSupprimer()
    {
        return this.supprimer;
    }
    public ArrayList<GridPane> getSousForm()
    {
        return this.sousForm;
    }
    public GridPane getEdition()
    {
        return this.edition;
    }
    public StackPane getTitre()
    {
        return this.titre;
    }
     public Label getTitreFiche()
    {
        return this.titreFiche;
    }
    public void desactiverTextF()
    {

       for(int i=0;i<this.valeur.size();i++)
       {
           this.valeur.get(i).setDisable(true);
       }
       
    }
    public void clearText()
    {
        for(int i=0;i<this.valeur.size();i++)
       {
           this.valeur.get(i).clear();
       }
    }
    public ArrayList<String> getValeurForm()
    {
       ArrayList<String> va=new ArrayList<String>();
       for(int i=0;i<this.valeur.size();i++)
       {
           va.add(this.valeur.get(i).getText());
           this.valeur.get(i).clear();
       }
       return va;
    }
      public void titreForm(String s)
    {
        this.titreFiche=new Label(s);
        this.titre.getStyleClass().add("TitreForm");
        this.titre.getChildren().add(this.titreFiche);
    }
       public Label sTitreForm(String s)
    {
        Label stitre=new Label(s);
        stitre.getStyleClass().add("STitreForm");
        return stitre;
    }
     public void EditionForm()
    {
        
        this.supprimer=new Button("Supprimer");
        this.modifier=new Button("Modifier");
        this.edition.add(supprimer,0,0);
        this.edition.add(modifier,1,0);
        this.edition.setHgap(20);
        this.edition.setPadding(new Insets(0,0,0,510));
        this.edition.getStyleClass().add("editionForm");
    }
}
