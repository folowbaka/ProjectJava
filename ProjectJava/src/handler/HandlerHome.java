/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import gui.MenuSecondaire;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;

/**
 *
 * @author david
 */
public class HandlerHome  implements EventHandler {

    Parent visible;
    Parent[] cache;
    public HandlerHome(Parent visible,Parent cache[])
    {
        super();
        this.visible=visible;
        this.cache=cache;
    }
    @Override
    public void handle(Event event) {
        for(int i=0;i<cache.length;i++)
        {
            cache[i].setVisible(false);
            if(cache[i] instanceof MenuSecondaire)
            {
               ((MenuSecondaire)cache[i]).getMl().desactiver(); 
               ((MenuSecondaire)cache[i]).getMne().desactiver(); 
            }
        }
        visible.setVisible(true);
    }
    
}
