/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package gui;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class MenuLecture extends VBox{
        
        ToggleButton[] tg;
        PartieCentrale pc;
        final int NB_BUTTON=4;
    public MenuLecture()
    {
        super();
        this.pc=pc;
        this.setId("menu-lecture");
        tg=new ToggleButton[NB_BUTTON];
        tg[0]=new ToggleButton("Adherent");
        tg[1]=new ToggleButton("Retard");
        tg[2]=new ToggleButton("Livre");
        tg[3]=new ToggleButton("Emprunt");

        ToggleGroup tgg =new ToggleGroup();
        for(int i=0;i<NB_BUTTON;i++)
        {
            tg[i].setToggleGroup(tgg);
            this.getChildren().add(tg[i]);
        }
        this.setVisible(false);
    }
    public void desactiver()
    {
        for(int i=0;i<this.tg.length;i++)
        {
            tg[i].setSelected(false);
        }
    }
    public ToggleButton[] getTg()
    {
        return this.tg;
    }
    
}
