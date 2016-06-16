/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import gui.MenuSecondaire;
import gui.PartieCentrale;
import gui.ProjectJava;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.util.Duration;
import projectjava.Adherent;

/**
 *
 * @author david
 */
public class HandlerRechercheAdherent implements EventHandler{
    
    ProjectJava pa;
    public HandlerRechercheAdherent(ProjectJava pa)
    {
        super();
        this.pa=pa;
    }
    @Override
    public void handle(Event event) {
               
              String recherche=pa.getPCentrale().getLe()[0].getSearch().getText();
              System.out.println(recherche);
              ArrayList<Adherent> a=null;
              int i=pa.getPCentrale().getLe()[0].getChoix().getSelectionModel().getSelectedIndex();
              switch(i)
              {
                case 0:
                a=pa.getBibliotheque().search_adherent(recherche);
                break;
              }
              pa.getPCentrale().getLe()[0].setData(a);
    }
}
