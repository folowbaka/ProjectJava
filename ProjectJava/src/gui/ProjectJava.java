/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.MenuSecondaire;
import gui.MenuPrincipal;
import gui.ImageButton;
import handler.HandlerButtonLecture;
import handler.HandlerHome;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import projectjava.Adherent;
import projectjava.Adresse;
import projectjava.Bibliotheque;

/**
 *
 * @author david
 */
public class ProjectJava extends Application {
        private MenuSecondaire ms;
        private PartieCentrale pc;
        private Bibliotheque bq;
        final int NB_CACHE=4;
        class NavBar extends BorderPane{
            private ImageButton home;
            private MenuSecondaire mss;
            private MenuPrincipal mnn;
            public NavBar(){
                super();
                this.setId("navbar");
                
                home=new ImageButton();
                home.setId("homebutton");
                Image imgHome=new Image("ressource/home.png");
                home.setImages(imgHome);
                Parent visible=pc.getMn();
                Parent cache[]=new Parent[NB_CACHE];
                cache[0]=ms;
                for(int i=1;i<cache.length;i++)
                {
                    System.out.println(""+i);
                    cache[i]=pc.getLe()[i-1];
                }
                home.setOnMousePressed(new HandlerHome(visible,cache));
                this.setLeft(home);
                Calendar c=Calendar.getInstance();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Label datetoday=new Label(df.format(c.getTime()));
                BorderPane.setMargin(datetoday,new Insets(0,20,0,0));
                datetoday.setId("date");
                this.setRight(datetoday);
            }
        }
    
    @Override
    public void start(Stage primaryStage) {     
        BorderPane root = new BorderPane();
        //Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        double longueurScene=1280;
        double hauteurScene=900;
        Scene scene = new Scene(root,longueurScene,hauteurScene);
        primaryStage.setTitle("Bibliothèque");
        this.bq=Bibliotheque.loadBibliotheque("src/ressource/BDD.txt");
        this.ms=new MenuSecondaire();
        this.pc=new PartieCentrale(new MenuPrincipal(ms),this.bq);
        this.ms.getMl().getTg()[0].setOnMousePressed(new HandlerButtonLecture(0,this.pc));
        this.ms.getMl().getTg()[1].setOnMousePressed(new HandlerButtonLecture(1,this.pc));
        this.ms.getMl().getTg()[2].setOnMousePressed(new HandlerButtonLecture(2,this.pc));
        NavBar nv=new NavBar();
        root.setCenter(pc);
        root.setLeft(ms);
        root.setTop(nv);
        //primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        
        scene.getStylesheets().add(ProjectJava.class.getResource("Bibliotheque.css").toExternalForm());
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
    @Override
    public void handle(WindowEvent event) {
        System.out.println("Sauvegarde");
        bq.saveBibliotheque("src/ressource/BDD.txt");
    }});
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
