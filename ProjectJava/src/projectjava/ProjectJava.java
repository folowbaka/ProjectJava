/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        StackPane root = new StackPane();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(root,primScreenBounds.getWidth(),primScreenBounds.getHeight());
        primaryStage.setTitle("Bibliothèque");
        MenuPrincipal mn=new MenuPrincipal();
        root.getChildren().add(mn);
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
