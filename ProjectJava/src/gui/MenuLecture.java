/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 *
 * @author david
 */
public class MenuLecture extends VBox{
        
        ToggleButton[] tg;
        PartieCentrale pc;
        final int NB_BUTTON=4;
    public MenuLecture()
    {
        super();
        this.pc=pc;
        this.setId("menu-lecture");
        tg=new ToggleButton[4];
        tg[0]=new ToggleButton("Liste adherent");
        tg[1]=new ToggleButton("Liste livre");
        tg[2]=new ToggleButton("Liste lecteur walid");
        tg[3]=new ToggleButton("Rechercher");
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
