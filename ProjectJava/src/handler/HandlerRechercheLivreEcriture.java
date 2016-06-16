/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import gui.ListeElementEditable;
import gui.ProjectJava;
import java.util.ArrayList;
import javafx.event.Event;
import javafx.event.EventHandler;
import projectjava.Livre;

/**
 *
 * @author david
 */
public class HandlerRechercheLivreEcriture implements EventHandler {
    
       ProjectJava pa;
    public HandlerRechercheLivreEcriture(ProjectJava pa)
    {
        super();
        this.pa=pa;
    }
    @Override
    public void handle(Event event) {
               
              String recherche=((ListeElementEditable)pa.getPCentrale().getEc()[3]).getSearch().getText();
              System.out.println(recherche);
              ArrayList<Livre> a=null;
              int i=((ListeElementEditable)pa.getPCentrale().getEc()[3]).getChoix().getSelectionModel().getSelectedIndex();
              switch(i)
              {
                case 0:
                a=pa.getBibliotheque().search_livre_titre(recherche);
                break;
                case 1:
                    a=pa.getBibliotheque().search_livre_auteur(recherche);
                break;
              }
              ((ListeElementEditable)pa.getPCentrale().getEc()[3]).setData(a);
    }
}
