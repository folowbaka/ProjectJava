/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author david
 */
public class Formulaire extends GridPane {
        private ProjectJava pa;
        private ArrayList<TextField> valeur;
        private ArrayList<GridPane> sousForm;
        private Button validation;
        private StackPane valider;
        private StackPane titre;
        
    public Formulaire(ProjectJava pa)
    {
        this.pa=pa;
        this.valeur=new ArrayList<TextField>();
        this.sousForm=new ArrayList<GridPane>();
        this.valider=new StackPane();
        this.titre=new StackPane();
        this.setVgap(20);
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
    public Button getValidation()
    {
        return this.validation;
    }
    public ArrayList<GridPane> getSousForm()
    {
        return this.sousForm;
    }
    public StackPane getValider()
    {
        return this.valider;
    }
    public StackPane getTitre()
    {
        return this.titre;
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
        Label titreForm=new Label(s);
        this.titre.getStyleClass().add("TitreForm");
        this.titre.getChildren().add(titreForm);
    }
       public Label sTitreForm(String s)
    {
        Label stitre=new Label(s);
        stitre.getStyleClass().add("STitreForm");
        return stitre;
    }
     public void validerForm()
    {
        
        this.validation=new Button("Valider");
        this.valider.getChildren().add(validation);
        this.valider.getStyleClass().add("validerForm");
    }
    
    
}
