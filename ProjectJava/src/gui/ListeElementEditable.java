/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import projectjava.Adherent;
import projectjava.Livre;

/**
 *
 * @author david
 */
public class ListeElementEditable<T> extends ListeElement {
    
    private ProjectJava pa;
    
    public ListeElementEditable(String nomTable, String[] nomColonne, String[] attribut, T test,ProjectJava pa) {
        super(nomTable, nomColonne, attribut, test);
        this.pa=pa;
        this.getStyleClass().add("TableEditable");
        
        
        this.getTable().setOnMousePressed(new EventHandler<MouseEvent>() {
        @Override 
        public void handle(MouseEvent event) {
            if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                setVisible(false);
                if(test instanceof Adherent)
                {
                   ((FicheAdherent)pa.getPCentrale().getEc()[4]).setAd((Adherent)getTable().getSelectionModel().getSelectedItem());
                   ((FicheAdherent)pa.getPCentrale().getEc()[4]).remplissage();
                   
                    ((FicheAdherent)pa.getPCentrale().getEc()[4]).setVisible(true);
                }
                else if(test instanceof Livre)
                {
                    //((FicheLivre)pa.getPCentrale().getEc()[4]).setLi((Livre)getTable().getSelectionModel().getSelectedItem());
                   //((FicheLivre)pa.getPCentrale().getEc()[4]).remplissage();
                   
                    ((FicheLivre)pa.getPCentrale().getEc()[5]).setVisible(true);
                }
            
            }
        }});
    }
    
    
}
