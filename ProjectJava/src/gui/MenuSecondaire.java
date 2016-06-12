/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.MenuLecture;
import gui.MenuEcriture;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author david
 */
public class MenuSecondaire  extends GridPane{
    
    private MenuEcriture mne;
    private MenuLecture ml;
    
    public MenuSecondaire()
    {
        this.setId("menu-secondaire");
        mne=new MenuEcriture();
        ml=new MenuLecture();
        this.getChildren().addAll(ml,mne);
        this.setVisible(false);
    }
    
    public MenuEcriture getMne()
    {
        return this.mne;
    }
    public MenuLecture getMl()
    {
        return this.ml;
    }
    
}
