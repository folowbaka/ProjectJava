/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package handler;

import gui.PartieCentrale;
import javafx.event.Event;
import javafx.event.EventHandler;

public class HandlerButtonLecture implements EventHandler{
         private int i;
         PartieCentrale pc;
         public HandlerButtonLecture(int i,PartieCentrale pc)
         {
             super();
             this.i=i;
             this.pc=pc;
         }
        @Override
        public void handle(Event event) {
             System.out.println(i);
             for(int j=0;j<pc.getLe().length;j++)
             {
                if(j==i)
                {
                    pc.getLe()[j].setVisible(true);
                }
                else
                   pc.getLe()[j].setVisible(false); 
             }
        }
    
}
