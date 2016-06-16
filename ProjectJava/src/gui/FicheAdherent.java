/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import handler.HandlerButtonValiderA;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import projectjava.Adherent;
import projectjava.Livre;

/**
 *
 * @author david
 */
public class FicheAdherent extends Fiche{
        private Adherent ad;
    public FicheAdherent(ProjectJava pa) {
        super(pa);
        this.getStyleClass().add("formAjout");
        this.formAGeneral();
        this.formAadresse();
        this.titreForm("Fiche Adhérent :");
        this.EditionForm();
        this.add(this.getTitre(), 0, 0);
        this.add(this.sTitreForm("Identité"), 0, 1);
        this.add(this.getSousForm().get(0),0,2);
        this.add(this.sTitreForm("Adresse"), 0, 3);
        this.add(this.getSousForm().get(1),0,4);
        this.add(this.getEdition(),0,5);
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
    public void setAd(Adherent ad)
    {
        this.ad=ad;
    }
    public void remplissage()
    {
        this.getTitreFiche().setText(this.getTitreFiche().getText()+" "+this.ad.getId());
        this.getValeur().get(0).setText(this.ad.getNom());
        this.getValeur().get(1).setText(this.ad.getPrenom());
        this.getValeur().get(2).setText(this.ad.getEmail());
        this.getValeur().get(3).setText(this.ad.getProfession());
        this.getValeur().get(4).setText(this.ad.getAdresse().getNumero());
        this.getValeur().get(5).setText(this.ad.getAdresse().getRue());
        this.getValeur().get(6).setText(this.ad.getAdresse().getCp());
        this.getValeur().get(7).setText(this.ad.getAdresse().getVille());
    }
    public void EditionForm()
    {
       super.EditionForm();
       
       this.getSupprimer().setOnMousePressed(new EventHandler<MouseEvent>() {
    @Override 
        public void handle(MouseEvent event) {
                
               getPa().getBibliotheque().removeAdherent(ad);
               ArrayList<Adherent> adherent=getPa().getBibliotheque().getListAdherent();
               ArrayList<Adherent> retard=getPa().getBibliotheque().adherentRetardataire();
               ArrayList<Livre> livre=getPa().getBibliotheque().getListLivre();
               getPa().getPCentrale().getLe()[0].setData(adherent);
               getPa().getPCentrale().getLe()[1].setData(retard);
               getPa().getPCentrale().getLe()[2].setData(livre);
               ((ListeElementEditable)getPa().getPCentrale().getEc()[2]).setData(adherent);
               ((ListeElementEditable)getPa().getPCentrale().getEc()[3]).setData(livre);
               clearText("Fiche Adherent :");
            }
        });
     
    }
}
