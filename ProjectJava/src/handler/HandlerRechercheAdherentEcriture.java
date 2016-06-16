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
import projectjava.Adherent;

/**
 *
 * @author david
 */
public class HandlerRechercheAdherentEcriture implements EventHandler {
     ProjectJava pa;
    public HandlerRechercheAdherentEcriture(ProjectJava pa)
    {
        super();
        this.pa=pa;
    }
    @Override
    public void handle(Event event) {
               
              String recherche=((ListeElementEditable)pa.getPCentrale().getEc()[2]).getSearch().getText();
              System.out.println(recherche);
              ArrayList<Adherent> a=null;
              int i=((ListeElementEditable)pa.getPCentrale().getEc()[2]).getChoix().getSelectionModel().getSelectedIndex();
              switch(i)
              {
                case 0:
                a=pa.getBibliotheque().search_adherent(recherche);
                break;
              }
              ((ListeElementEditable)pa.getPCentrale().getEc()[2]).setData(a);
             
    }
}
