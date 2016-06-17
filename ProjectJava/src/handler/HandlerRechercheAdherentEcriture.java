/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package handler;

import gui.ListeElementEditable;
import gui.ProjectJava;
import java.util.ArrayList;
import javafx.event.Event;
import javafx.event.EventHandler;
import projectjava.Adherent;

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
                case 1:
                    a=pa.getBibliotheque().search_adherent_mail(recherche);
                break;
                case 2:
                    a=pa.getBibliotheque().search_adherent_profession(recherche);
                break;
              }
              ((ListeElementEditable)pa.getPCentrale().getEc()[2]).setData(a);
             
    }
}
