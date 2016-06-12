/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author david
 */
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
        this.setAlignment(Pos.CENTER);
        btnMl.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                btnMl.getParent().setVisible(false);
                ms.setVisible(true);
                ms.getMl().setVisible(true);
            }
        });
        
          btnMe.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                btnMe.getParent().setVisible(false);
                ms.setVisible(true);
                ms.getMne().setVisible(true);
            }
        });
    }
}
