/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import gui.MenuSecondaire;
import gui.PartieCentrale;
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
    MenuSecondaire ms;
    PartieCentrale pc;
    public HandlerHome(Parent visible,MenuSecondaire ms,PartieCentrale pc)
    {
        super();
        this.visible=visible;
        this.ms=ms;
        this.pc=pc;
    }
    @Override
    public void handle(Event event) {
               
               ((MenuSecondaire)ms).getMl().desactiver(); 
               ((MenuSecondaire)ms).getMne().desactiver(); 
                final Timeline timeline = new Timeline();
                final KeyValue kv = new KeyValue(ms.translateXProperty(), -300);
                final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
                timeline.getKeyFrames().add(kf);
                timeline.play();
                pc.desactiverEcriture();
                pc.desactiverListe();
        visible.setVisible(true);
    }
    
}
