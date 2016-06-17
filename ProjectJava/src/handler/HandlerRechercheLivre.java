/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package handler;

import gui.ProjectJava;
import java.util.ArrayList;
import javafx.event.Event;
import javafx.event.EventHandler;
import projectjava.Adherent;
import projectjava.Livre;

public class HandlerRechercheLivre implements EventHandler {
    
      ProjectJava pa;
    public HandlerRechercheLivre(ProjectJava pa)
    {
        super();
        this.pa=pa;
    }
    @Override
    public void handle(Event event) {
               
              String recherche=pa.getPCentrale().getLe()[2].getSearch().getText();
              System.out.println(recherche);
              ArrayList<Livre> a=null;
              int i=pa.getPCentrale().getLe()[2].getChoix().getSelectionModel().getSelectedIndex();
              switch(i)
              {
                case 0:
                a=pa.getBibliotheque().search_livre_titre(recherche);
                break;
                case 1:
                    a=pa.getBibliotheque().search_livre_auteur(recherche);
                break;
                case 2:
                    a=pa.getBibliotheque().search_livre_genre(recherche);
                break;
              }
              pa.getPCentrale().getLe()[2].setData(a);
    }
}
