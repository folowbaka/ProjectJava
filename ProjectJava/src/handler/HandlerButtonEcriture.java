/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package handler;

import gui.FicheAdherent;
import gui.FicheLivre;
import gui.PartieCentrale;
import javafx.event.Event;
import javafx.event.EventHandler;

public class HandlerButtonEcriture implements EventHandler {

    private int i;
    PartieCentrale pc;
    
    public HandlerButtonEcriture(int i,PartieCentrale pc)
         {
             super();
             this.i=i;
             this.pc=pc;
         }
    @Override
    public void handle(Event event) {
        System.out.println(i);
          for(int j=0;j<pc.getEc().length;j++)
             {
                if(j==i)
                {
                    pc.getEc()[j].setVisible(true);
                }
                else
                   pc.getEc()[j].setVisible(false);
           
                    ((FicheAdherent)pc.getEc()[4]).clearText("Fiche Adherent :");
                    ((FicheLivre)pc.getEc()[5]).clearText("Fiche Livre :");
           
             }
    }
    
}
