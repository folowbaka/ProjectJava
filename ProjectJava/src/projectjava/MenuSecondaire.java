/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

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
    
    MenuEcriture getMne()
    {
        return this.mne;
    }
    MenuLecture getMl()
    {
        return this.ml;
    }
    
}
