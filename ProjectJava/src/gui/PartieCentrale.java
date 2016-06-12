/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author david
 */
public class PartieCentrale extends StackPane {
        private MenuPrincipal mn;
        private ListeElement[] listeE;
        public PartieCentrale(MenuPrincipal mn)
        {
            super();
            this.mn=mn;
            StackPane.setMargin(this.mn,new Insets(0,0,0,-200));
            this.getChildren().add(this.mn);
            String nomColonne[]={"Nom","Prenom"};
            listeE=new ListeElement[3];
            this.listeE[0]=new ListeElement("Adherent",nomColonne);
             nomColonne[0]="Titre";nomColonne[1]="Auteur";
            this.listeE[1]=new ListeElement("Livre",nomColonne);
            nomColonne[0]="Nom";nomColonne[1]="Prenom";
            this.listeE[2]=new ListeElement("Retardataire",nomColonne);
            for(int i=0;i<listeE.length;i++)
            {
               this.listeE[i].setVisible(false);
               this.getChildren().add(listeE[i]);
            }
        }
        public MenuPrincipal getMn(){
            return this.mn;
        }
        public ListeElement[] getLe()
        {
            return this.listeE;
        }
        public void desactiverListe()
        {
            for(int i=0;i<this.listeE.length;i++)
            {
                this.listeE[i].setVisible(false);
            }
        }
}
