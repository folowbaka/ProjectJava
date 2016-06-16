/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.MenuSecondaire;
import gui.MenuPrincipal;
import gui.ImageButton;
import handler.HandlerButtonEcriture;
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
        final int NB_CACHE=5;
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
                home.setOnMousePressed(new HandlerHome(visible,ms,pc));
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
        this.pc=new PartieCentrale(new MenuPrincipal(ms),this.bq,this);
        for(int i=0;i<this.ms.getMl().getTg().length;i++)
        {
        this.ms.getMl().getTg()[i].setOnMousePressed(new HandlerButtonLecture(i,this.pc));
        }
        for(int i=0;i<this.ms.getMne().getTg().length;i++)
        {
        this.ms.getMne().getTg()[i].setOnMousePressed(new HandlerButtonEcriture(i,this.pc));
        }
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
    public Bibliotheque getBibliotheque()
    {
        return this.bq;
    }
    public PartieCentrale getPCentrale()
    {
        return this.pc;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
