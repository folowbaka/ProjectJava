/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import handler.HandlerButtonValiderA;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import projectjava.Adherent;
import projectjava.Adresse;
import projectjava.Livre;

/**
 *
 * @author david
 */
public class FicheAdherent extends Fiche{
        private Adherent ad;
        private ArrayList<ListView<Livre>> list;
        private Button[] restituer;
        private Button[] emprunter;
        private DatePicker[] retour;
    public FicheAdherent(ProjectJava pa) {
        super(pa);
        this.setId("FicheAdherent");
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
        this.add(this.ficheEmprunt(),0,5);
        this.add(this.getEdition(),0,6);
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
    public Adherent getAd()
    {
        return this.ad;
    }
    public Button[] getRestituer()
    {
        return this.restituer;
    }
    public ArrayList<ListView<Livre>> getEmprunt()
    {
        return this.list;
    }
    public Button[] getEmprunter()
    {
        return this.emprunter;
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
       
         this.getModifier().setOnMousePressed(new EventHandler<MouseEvent>() {
    @Override 
        public void handle(MouseEvent event) {
                
               ad.setNom(getValeur().get(0).getText());
               ad.setPrenom(getValeur().get(1).getText());
               ad.setEmail(getValeur().get(2).getText());
               ad.setProfession(getValeur().get(3).getText());
               ad.setAdresse(new Adresse(getValeur().get(4).getText(),getValeur().get(5).getText(),getValeur().get(6).getText(),getValeur().get(7).getText()));
               getPa().getPCentrale().getLe()[0].getTable().refresh();
               getPa().getPCentrale().getLe()[1].getTable().refresh();
               getPa().getPCentrale().getLe()[3].getTable().refresh();
               ((ListeElementEditable)getPa().getPCentrale().getEc()[2]).getTable().refresh();
     
            }
        });
     
    }
     public GridPane ficheEmprunt()
    {
        GridPane emprunt=new GridPane();
        this.list=new ArrayList<ListView<Livre>>();
        this.restituer=new Button[3];
        this.emprunter=new Button[3];
        this.retour=new DatePicker[3];
        for(int i=0;i<3;i++)
        {
            this.restituer[i]=new Button("Restituer");
            this.emprunter[i]=new Button("Emprunter");
            this.retour[i]=new DatePicker();
            this.list.add(new ListView<Livre>());
            this.list.get(i).getStyleClass().add("listEmprunt");
            emprunt.add(this.list.get(i), 0, i);
            emprunt.add(this.restituer[i], 1, i);
             emprunt.add(this.emprunter[i], 2, i);
             emprunt.add(this.retour[i], 3, i);
            
        }
        emprunt.setHgap(20);
        this.restituer[0].setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
                
               ad.rendre(0);
               emprunter[0].setDisable(false);
               ObservableList<Livre> items=FXCollections.observableArrayList(ad.getEmprunt_livre()[0]);
               list.get(0).setItems(items);
               list.get(0).refresh();
               items=FXCollections.observableArrayList(ad.getEmprunt_livre()[1]);
               list.get(1).setItems(items);
               list.get(1).refresh();
               items=FXCollections.observableArrayList(ad.getEmprunt_livre()[2]);
               list.get(2).setItems(items);
               list.get(2).refresh();
               System.out.println(ad.getEmprunt_livre()[0]);
               if(ad.getEmprunt_livre()[0]==null)
               {
                   restituer[0].setDisable(true);
                   emprunter[0].setDisable(false);
                   list.get(0).setEditable(true);
               }
               getPa().getPCentrale().getLe()[2].getTable().refresh();
               getPa().getPCentrale().getLe()[3].setData(getPa().getBibliotheque().livreEmprunter());
               getPa().getPCentrale().getLe()[3].getTable().refresh();
               
            }});
        this.restituer[1].setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
                
               ad.rendre(1);
               ObservableList<Livre> items=FXCollections.observableArrayList(ad.getEmprunt_livre()[1]);
               list.get(1).setItems(items);
               list.get(1).refresh();
               items=FXCollections.observableArrayList(ad.getEmprunt_livre()[2]);
               list.get(2).setItems(items);
               list.get(2).refresh();
              System.out.println(ad.getEmprunt_livre()[1]);
              if(ad.getEmprunt_livre()[1]==null)
               {
                   restituer[1].setDisable(true);
                   emprunter[1].setDisable(false);
                   list.get(1).setEditable(true);
               }
               getPa().getPCentrale().getLe()[2].getTable().refresh();
               getPa().getPCentrale().getLe()[3].setData(getPa().getBibliotheque().livreEmprunter());
               getPa().getPCentrale().getLe()[3].getTable().refresh();
               
            }});
        this.restituer[2].setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
                
               ad.rendre(2);
               ObservableList<Livre> items=FXCollections.observableArrayList(ad.getEmprunt_livre()[2]);
               list.get(2).setItems(items);
               list.get(2).refresh();
               System.out.println(ad.getEmprunt_livre()[2]);
               if(ad.getEmprunt_livre()[2]==null)
               {
                   restituer[2].setDisable(true);
                   emprunter[2].setDisable(false);
                   list.get(2).setEditable(true);
               }
               getPa().getPCentrale().getLe()[2].getTable().refresh();
               getPa().getPCentrale().getLe()[3].setData(getPa().getBibliotheque().livreEmprunter());
               getPa().getPCentrale().getLe()[3].getTable().refresh();
               
            }});
         this.emprunter[0].setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
                
              if(list.get(0).getItems().get(0)!=null && retour[0].getValue()!=null)
               {
                Calendar c=Calendar.getInstance();
                c.setTime(Date.valueOf(retour[0].getValue()));
                System.out.println(c.getTime());
                ad.emprunter(list.get(0).getItems().get(0),c);
               ObservableList<Livre> items=FXCollections.observableArrayList(ad.getEmprunt_livre()[0]);
               list.get(0).setItems(items);
               list.get(0).refresh();
               if(ad.getEmprunt_livre()[0]!=null)
               {
                   restituer[0].setDisable(false);
                   emprunter[0].setDisable(true);
                   list.get(0).setEditable(false);
               }
               getPa().getPCentrale().getLe()[1].setData(getPa().getBibliotheque().adherentRetardataire());
               getPa().getPCentrale().getLe()[1].getTable().refresh();
               getPa().getPCentrale().getLe()[2].getTable().refresh();
               getPa().getPCentrale().getLe()[3].setData(getPa().getBibliotheque().livreEmprunter());
               getPa().getPCentrale().getLe()[3].getTable().refresh();
               }
               
               
            }});
          this.emprunter[1].setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
                
              if(list.get(1).getItems().get(0)!=null && retour[1].getValue()!=null)
               {
                Calendar c=Calendar.getInstance();
                c.setTime(Date.valueOf(retour[1].getValue()));
                 ad.emprunter(list.get(1).getItems().get(0),c);
               ObservableList<Livre> items=FXCollections.observableArrayList(ad.getEmprunt_livre()[1]);
               list.get(2).setItems(items);
               list.get(2).refresh();
               if(ad.getEmprunt_livre()[1]!=null)
               {
                   restituer[1].setDisable(false);
                   emprunter[1].setDisable(true);
                   list.get(1).setEditable(false);
               }
               getPa().getPCentrale().getLe()[1].setData(getPa().getBibliotheque().adherentRetardataire());
               getPa().getPCentrale().getLe()[1].getTable().refresh();
               getPa().getPCentrale().getLe()[2].getTable().refresh();
               getPa().getPCentrale().getLe()[3].setData(getPa().getBibliotheque().livreEmprunter());
               getPa().getPCentrale().getLe()[3].getTable().refresh();
               }
               
            }});
           this.emprunter[2].setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
                System.out.println(retour[2].getValue());
                
               if(list.get(2).getItems().get(0)!=null && retour[2].getValue()!=null)
               {
                Calendar c=Calendar.getInstance();
                c.setTime(Date.valueOf(retour[2].getValue()));
                ad.emprunter(list.get(2).getItems().get(0),c);
               ObservableList<Livre> items=FXCollections.observableArrayList(ad.getEmprunt_livre()[2]);
               list.get(2).setItems(items);
               list.get(2).refresh();
               if(ad.getEmprunt_livre()[2]!=null)
               {
                   restituer[2].setDisable(false);
                   emprunter[2].setDisable(true);
                   list.get(2).setEditable(false);
               }
               getPa().getPCentrale().getLe()[1].setData(getPa().getBibliotheque().adherentRetardataire());
               getPa().getPCentrale().getLe()[1].getTable().refresh();
               getPa().getPCentrale().getLe()[2].getTable().refresh();
               getPa().getPCentrale().getLe()[3].setData(getPa().getBibliotheque().livreEmprunter());
               getPa().getPCentrale().getLe()[3].getTable().refresh();
               }
               
            }});
        return emprunt;
    }
    
}
