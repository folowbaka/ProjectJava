/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import handler.HandlerButtonValiderA;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author david
 */
public class FormulaireAdherent extends Formulaire {
    public FormulaireAdherent(ProjectJava pa)
    {
        super(pa);
        this.getStyleClass().add("formAjout");
        this.formAGeneral();
        this.formAadresse();
        this.titreForm("Formulaire Adhérent");
        this.validerForm();
        this.add(this.getTitre(), 0, 0);
        this.add(this.sTitreForm("Identité"), 0, 1);
        this.add(this.getSousForm().get(0),0,2);
        this.add(this.sTitreForm("Adresse"), 0, 3);
        this.add(this.getSousForm().get(1),0,4);
        this.add(this.getValider(),0,5);
    }
    
    public void formAGeneral()
    {
        this.getSousForm().add(new GridPane());
        Label nomAd=new Label("Nom");
        TextField nomField=new TextField();
        this.getValeur().add(nomField);
        this.getSousForm().get(0).add(nomAd, 0, 1);
        this.getSousForm().get(0).add(nomField, 1, 1);
        Label prenomAd=new Label("Prenom");
        TextField prenomField=new TextField();
        this.getValeur().add(prenomField);
        this.getSousForm().get(0).add(prenomAd, 2, 1);
        this.getSousForm().get(0).add(prenomField, 3, 1);
        Label mailAd=new Label("Email");
        TextField mailField=new TextField();
        this.getValeur().add(mailField);
        this.getSousForm().get(0).add(mailAd,0, 2);
        this.getSousForm().get(0).add(mailField, 1, 2);
        Label jobAd=new Label("Profession");
        TextField jobField=new TextField();
        this.getValeur().add(jobField);
        this.getSousForm().get(0).add(jobAd,2, 2);
        this.getSousForm().get(0).add(jobField, 3, 2);
        this.getSousForm().get(0).setHgap(10);
        this.getSousForm().get(0).setVgap(5);
        this.getSousForm().get(0).getStyleClass().add("form");
    }
    
    public void formAadresse()
    {
        this.getSousForm().add(new GridPane());
        Label numeroAd=new Label("Numero");
        TextField numeroField=new TextField();
        this.getValeur().add(numeroField);
        this.getSousForm().get(1).add(numeroAd, 0, 1);
        this.getSousForm().get(1).add(numeroField, 1, 1);
        Label rueAd=new Label("Rue");
        TextField rueField=new TextField();
        this.getValeur().add(rueField);
        this.getSousForm().get(1).add(rueAd, 2, 1);
        this.getSousForm().get(1).add(rueField, 3, 1);
        Label cPAd=new Label("Code postal");
        TextField cPField=new TextField();
        this.getValeur().add(cPField);
        this.getSousForm().get(1).add(cPAd,0, 2);
        this.getSousForm().get(1).add(cPField, 1, 2);
        Label villeAd=new Label("Ville");
        TextField villeField=new TextField();
        this.getValeur().add(villeField);
        this.getSousForm().get(1).add(villeAd,2, 2);
        this.getSousForm().get(1).add(villeField, 3, 2);
        this.getSousForm().get(1).setHgap(10);
        this.getSousForm().get(1).setVgap(5);
        this.getSousForm().get(1).getStyleClass().add("form");
    }
    public void validerForm()
    {
       super.validerForm();
       this.getValidation().setOnMousePressed(new HandlerButtonValiderA(this.getPa()));
    }
    

   
}
