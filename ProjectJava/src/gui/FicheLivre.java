/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import projectjava.Adherent;
import projectjava.Livre;

/**
 *
 * @author david
 */
public class FicheLivre extends Fiche{
    private Livre li;
    public FicheLivre(ProjectJava pa) {
        super(pa);
        this.getStyleClass().add("formAjout");
        this.FormLGeneral();
        this.titreForm("Fiche Livre : ");
        this.EditionForm();
        this.add(this.getTitre(), 0, 0);
        this.add(this.sTitreForm("Description"), 0, 1);
        this.add(this.getSousForm().get(0),0,2);
        this.add(this.getEdition(),0,3);
    }
    public void FormLGeneral()
    {
        this.getSousForm().add(new GridPane());
        Label titreLi=new Label("Titre");
        TextField titreField=new TextField();
        this.getValeur().add(titreField);
        this.getSousForm().get(0).add(titreLi, 0, 1);
        this.getSousForm().get(0).add(titreField, 1, 1);
        Label auteurLi=new Label("Auteur");
        TextField auteurField=new TextField();
        this.getValeur().add(auteurField);
        this.getSousForm().get(0).add(auteurLi, 2, 1);
        this.getSousForm().get(0).add(auteurField, 3, 1);
        Label categLi=new Label("Disponible");
        TextField categField=new TextField();
        this.getValeur().add(categField);
        this.getSousForm().get(0).add(categLi,0, 2);
        this.getSousForm().get(0).add(categField, 1, 2);
        Label qaLi=new Label("Total");
        TextField qaField=new TextField();
        this.getValeur().add(qaField);
        this.getSousForm().get(0).add(qaLi,2, 2);
        this.getSousForm().get(0).add(qaField, 3, 2);
        this.getSousForm().get(0).setHgap(10);
        this.getSousForm().get(0).setVgap(5);
        this.getSousForm().get(0).getStyleClass().add("form");
    }
    public void setLi(Livre li)
    {
        this.li=li;
    }
    public void remplissage()
    {
        this.getTitreFiche().setText(this.getTitreFiche().getText()+" "+this.li.getCode());
        this.getValeur().get(0).setText(this.li.getTitre());
        this.getValeur().get(1).setText(this.li.getAuteur());
        this.getValeur().get(2).setText(Integer.toString(this.li.getNb_exemplaire_dispo()));
        this.getValeur().get(3).setText(Integer.toString(this.li.getNb_exemplaire_total()));
    }
      public void EditionForm()
    {
       super.EditionForm();
       
       this.getSupprimer().setOnMousePressed(new EventHandler<MouseEvent>() {
    @Override 
        public void handle(MouseEvent event) {
                
               getPa().getBibliotheque().removeLivre(li);
               ArrayList<Adherent> adherent=getPa().getBibliotheque().getListAdherent();
               ArrayList<Adherent> retard=getPa().getBibliotheque().adherentRetardataire();
               ArrayList<Livre> livre=getPa().getBibliotheque().getListLivre();
               getPa().getPCentrale().getLe()[0].setData(adherent);
               getPa().getPCentrale().getLe()[1].setData(retard);
               getPa().getPCentrale().getLe()[2].setData(livre);
               ((ListeElementEditable)getPa().getPCentrale().getEc()[2]).setData(adherent);
               ((ListeElementEditable)getPa().getPCentrale().getEc()[3]).setData(livre);
               clearText("Fiche Livre :");
            }
        });
     
    }
    
}
