/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import gui.MenuSecondaire;
import gui.PartieCentrale;
import gui.ProjectJava;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.util.Duration;

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
               
               System.out.println("Je Recherche!!!");
    }
}
