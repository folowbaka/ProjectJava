/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package gui;

import gui.MenuLecture;
import gui.MenuEcriture;
import javafx.scene.layout.GridPane;

public class MenuSecondaire  extends GridPane{
    
    private MenuEcriture mne;
    private MenuLecture ml;
    
    public MenuSecondaire()
    {
        this.setId("menu-secondaire");
        this.setTranslateX(-300);
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
