/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 *
 * @author david
 */
public class MenuEcriture extends VBox {
        ToggleButton[] tg;
        String[] nameButton;
        final int NB_BUTTON=6;
        
        class Eva implements EventHandler{
            int i;
         public Eva(int i)
         {
             super();
             this.i=i;
         }
        @Override
        public void handle(Event event) {
             System.out.println(i);
        }
            
        }
    public MenuEcriture()
    {
        super();
        this.setId("menu-ecriture");
        tg=new ToggleButton[NB_BUTTON];
        String nameButton[]={"Ajouter Adhérent","Ajouter Livre","Supprimer Adhérent","Supprimer Livre","Emprunt","Restitution"};
        this.nameButton=nameButton;
        ToggleGroup tgg =new ToggleGroup();
        for(int i=0;i<NB_BUTTON;i++)
        {
            tg[i]=new ToggleButton(this.nameButton[i]);
            tg[i].setToggleGroup(tgg);
            tg[i].setOnMousePressed(new MenuEcriture.Eva(i));
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
