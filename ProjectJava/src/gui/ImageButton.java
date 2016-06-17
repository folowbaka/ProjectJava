/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package gui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageButton extends Button {

    public void setImages(final Image selected) 
    {
        final ImageView iv = new ImageView(selected);
        iv.setFitWidth(80);
        iv.setFitHeight(80);
        iv.setSmooth(true);    
        iv.setPreserveRatio(true);
        this.getChildren().add(iv);
        super.setGraphic(iv);
    }
}