/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 *
 * @author david
 */
public class MenuLecture extends VBox{
    
    public MenuLecture()
    {
        super();
        this.setId("menu-lecture");
        Button  btnLa=new Button("Liste adherent");
        Button btnLl=new Button("Liste livre");
        Button btnLed=new Button("Liste lecteur walid");
        Button btnRe=new Button("Rechercher");
        this.getChildren().addAll(btnLa,btnLl,btnLed,btnRe);
        this.setVisible(false);
    }
}
