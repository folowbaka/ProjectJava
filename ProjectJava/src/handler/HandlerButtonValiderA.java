/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import gui.FormulaireAdherent;
import gui.ListeElementEditable;
import gui.ProjectJava;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import projectjava.Adherent;
import projectjava.Adresse;

/**
 *
 * @author david
 */
public class HandlerButtonValiderA implements EventHandler {

    private ProjectJava pa;
    public HandlerButtonValiderA(ProjectJava pa)
    {
        this.pa=pa;
    }
    @Override
    public void handle(Event event) {
       ArrayList<String> va=((FormulaireAdherent)pa.getPCentrale().getEc()[0]).getValeurForm();
       pa.getBibliotheque().addAdherent(new Adherent(pa.getBibliotheque().getID(),va.get(0),va.get(1),va.get(2),va.get(3),new Adresse(va.get(4),va.get(5),va.get(6),va.get(7))));
       System.out.println("Ajout Réussi");
       pa.getPCentrale().getLe()[0].setData(pa.getBibliotheque().getListAdherent());
       ((ListeElementEditable)pa.getPCentrale().getEc()[2]).setData(pa.getBibliotheque().getListAdherent());
    }
    
}
