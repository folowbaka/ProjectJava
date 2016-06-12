/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author david
 */
public class ProjectJava extends Application {
    @Override
    public void start(Stage primaryStage) {     
        BorderPane root = new BorderPane();
        //Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        double longueurScene=1280;
        double hauteurScene=900;
        Scene scene = new Scene(root,longueurScene,hauteurScene);
        primaryStage.setTitle("Bibliothèque");
        MenuSecondaire ms=new MenuSecondaire();
        MenuPrincipal mn=new MenuPrincipal(ms);
        root.setCenter(mn);
        root.setLeft(ms);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(ProjectJava.class.getResource("Bibliotheque.css").toExternalForm());
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
