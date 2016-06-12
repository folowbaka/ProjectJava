/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author david
 */
public class ImageButton extends Button {

    public void setImages(final Image selected) {
        final ImageView iv = new ImageView(selected);
        iv.setFitWidth(80);
        iv.setFitHeight(80);
        iv.setSmooth(true);    
        iv.setPreserveRatio(true);
        this.getChildren().add(iv);
        

        super.setGraphic(iv);
    }
}