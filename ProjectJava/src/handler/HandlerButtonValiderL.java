/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package handler;

import gui.FormulaireAdherent;
import gui.FormulaireLivre;
import gui.ListeElementEditable;
import gui.ProjectJava;
import java.util.ArrayList;
import javafx.event.Event;
import javafx.event.EventHandler;
import projectjava.Adherent;
import projectjava.Adresse;
import projectjava.Livre;

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
       ((ListeElementEditable)pa.getPCentrale().getEc()[3]).setData(pa.getBibliotheque().getListAdherent());
    }
}
