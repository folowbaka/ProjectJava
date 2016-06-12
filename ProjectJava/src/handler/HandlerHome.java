/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import gui.MenuSecondaire;
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
            if(cache[i] instanceof MenuSecondaire)
            {
               
               ((MenuSecondaire)cache[i]).getMl().desactiver(); 
               ((MenuSecondaire)cache[i]).getMne().desactiver(); 
                final Timeline timeline = new Timeline();
                final KeyValue kv = new KeyValue(cache[i].translateXProperty(), -300);
                final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
                timeline.getKeyFrames().add(kf);
                timeline.play();
            }
            else
                cache[i].setVisible(false);
        }
        visible.setVisible(true);
    }
    
}
