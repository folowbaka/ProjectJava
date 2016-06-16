/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import gui.FormulaireAdherent;
import gui.FormulaireLivre;
import gui.ProjectJava;
import java.util.ArrayList;
import javafx.event.Event;
import javafx.event.EventHandler;
import projectjava.Adherent;
import projectjava.Adresse;
import projectjava.Livre;

/**
 *
 * @author david
 */
public class HandlerButtonValiderL implements EventHandler{
     private ProjectJava pa;
    public HandlerButtonValiderL(ProjectJava pa)
    {
        this.pa=pa;
    }
    @Override
    public void handle(Event event) {
       ArrayList<String> va=((FormulaireLivre)pa.getPCentrale().getEc()[1]).getValeurForm();
       pa.getBibliotheque().addLivre(new Livre(va.get(0),va.get(1),va.get(2),Integer.parseInt(va.get(3)),pa.getBibliotheque()));
       System.out.println("Ajout Réussi");
       pa.getPCentrale().getLe()[2].setData(pa.getBibliotheque().getListLivre());
    }
}
