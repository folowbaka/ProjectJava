/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package gui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class MenuPrincipal extends GridPane{
    private Button btnMl;
    private Button btnMe;
    private MenuSecondaire ms;
    public MenuPrincipal(MenuSecondaire ms){
        super();
        this.setMaxSize(400, 400);
        Label titre=new Label("BIBLIOTHEQUE");
        this.setId("menu-principal");
        this.ms=ms;
        btnMl=new Button("Menu Lecture");
        btnMe=new Button("Menu Ecriture");
        GridPane.setConstraints(titre, 0, 0);
        GridPane.setConstraints(btnMl, 0, 1);
        GridPane.setConstraints(btnMe, 0, 2);
        btnMl.setPrefSize(400, 50);
        btnMe.setPrefSize(400, 50);
        this.setVgap(15);
        this.getChildren().addAll(titre,btnMl,btnMe);
        btnMl.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                btnMl.getParent().setVisible(false);
                ms.setVisible(true);
                ms.getMl().setVisible(true);
                final Timeline timeline = new Timeline();
                final KeyValue kv = new KeyValue(ms.translateXProperty(),0);
                final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
                timeline.getKeyFrames().add(kf);
                timeline.play();
                ms.getMne().setVisible(false);
            }
        });
        
          btnMe.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                btnMe.getParent().setVisible(false);
                ms.setVisible(true);
                ms.getMne().setVisible(true);
                ms.getMl().setVisible(false);
                final Timeline timeline = new Timeline();
                final KeyValue kv = new KeyValue(ms.translateXProperty(), 0);
                final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
                timeline.getKeyFrames().add(kf);
                timeline.play();
            }
        });
    }
}
