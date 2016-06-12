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
public class MenuEcriture extends VBox {
    
    public MenuEcriture()
    {
        super();
        this.setId("menu-ecriture");
        Button  btnAa=new Button("Ajouter Adhérent");
        Button btnAl=new Button("Ajouter Livre");
        Button btnSa=new Button("Supprimer Adhérent");
        Button btnSl=new Button("Supprimer Livre");
        Button btnEp=new Button("Emprunt");
        Button btnRs=new Button("Restitution");
        this.getChildren().addAll(btnAa,btnAl,btnSa,btnSl,btnEp,btnRs);
        this.setVisible(false);
    }
}
