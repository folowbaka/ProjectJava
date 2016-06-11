/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

/**
 *
 * @author david
 */
public class MenuPrincipal extends GridPane{
    
    public MenuPrincipal(){
        Button btnMl=new Button("Menu lecture");
        Button btnMe=new Button("Menu Ecriture");
        GridPane.setConstraints(btnMl, 0, 0);
        GridPane.setConstraints(btnMe, 0, 1);
        this.getChildren().addAll(btnMl,btnMe);
    }
}
