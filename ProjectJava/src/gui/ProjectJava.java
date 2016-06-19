/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package gui;

import handler.HandlerButtonEcriture;
import handler.HandlerButtonLecture;
import handler.HandlerHome;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import projectjava.Bibliotheque;

public class ProjectJava extends Application {

    private MenuSecondaire ms;
    private PartieCentrale pc;
    private Bibliotheque bq;

    class NavBar extends BorderPane {

        private ImageButton home;
        private MenuSecondaire mss;
        private MenuPrincipal mnn;

        public NavBar() {
            super();
            this.setId("navbar");

            home = new ImageButton();
            home.setId("homebutton");
            Image imgHome = new Image("ressource/home.png");
            home.setImages(imgHome);
            Parent visible = pc.getMn();
            home.setOnMousePressed(new HandlerHome(visible, ms, pc));
            this.setLeft(home);
            Calendar c = Calendar.getInstance();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Label datetoday = new Label(df.format(c.getTime()));
            BorderPane.setMargin(datetoday, new Insets(5, 20, 0, 0));
            datetoday.setId("date");
            this.setRight(datetoday);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        double longueurScene = 1280;
        double hauteurScene = 900;
        Image anotherIcon = new Image("ressource/ico.png");
        primaryStage.getIcons().add(anotherIcon);
        Scene scene = new Scene(root, longueurScene, hauteurScene);
        primaryStage.setTitle("Bibliothèque");
        this.bq = Bibliotheque.loadBibliotheque("src/ressource/BDD.txt");
        this.ms = new MenuSecondaire();
        this.pc = new PartieCentrale(new MenuPrincipal(ms), this.bq, this);
        for (int i = 0; i < this.ms.getMl().getTg().length; i++) {
            this.ms.getMl().getTg()[i].setOnMousePressed(new HandlerButtonLecture(i, this.pc));
        }
        for (int i = 0; i < this.ms.getMne().getTg().length; i++) {
            this.ms.getMne().getTg()[i].setOnMousePressed(new HandlerButtonEcriture(i, this.pc));
        }
        NavBar nv = new NavBar();
        root.setCenter(pc);
        root.setLeft(ms);
        root.setTop(nv);
        primaryStage.setScene(scene);

        scene.getStylesheets().add(ProjectJava.class.getResource("Bibliotheque.css").toExternalForm());
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("Sauvegarde");
                bq.saveBibliotheque("src/ressource/BDD.txt");
            }
        });

    }

    public Bibliotheque getBibliotheque() {
        return this.bq;
    }

    public PartieCentrale getPCentrale() {
        return this.pc;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
