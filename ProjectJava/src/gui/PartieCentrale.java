/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import handler.HandlerRechercheAdherent;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import projectjava.Adherent;
import projectjava.Bibliotheque;
import projectjava.Livre;

/**
 *
 * @author david
 */
public class PartieCentrale extends StackPane {
        private MenuPrincipal mn;
        private ListeElement[] listeE;
        private Pane[] ecriture;
        final int NB_BUTTON=4;

        public PartieCentrale(MenuPrincipal mn,Bibliotheque bq,ProjectJava pa)
        {
            super();
            this.setId("PaneCentral");
            this.mn=mn;
            StackPane.setMargin(this.mn,new Insets(0,0,0,-200));
            this.getChildren().add(this.mn);
            String nomColonne[]={"Nom","Prenom","@Mail","Profession"};
            String attribut[]={"nom","prenom","email","profession"};
            /*String nomColonne1[]={"Titre","Auteur","Exemplaire dispo","Exemplaire total"};
            String attribut1[]={"titre","auteur","exemplaire dispo","exemplaire total"};
            String nomColonne2[]={"Nom","Prenom","@Mail","Profession"};
            String attribut2[]={"nom","prenom","email","profession"};*/
            //
            listeE=new ListeElement[NB_BUTTON];
            bq.getListAdherent().get(0).emprunter(bq.getListLivre().get(0));
            this.listeE[0]=new ListeElement<Adherent>("Adherent",nomColonne,attribut,new Adherent());
            this.listeE[0].setData(bq.getListAdherent());
            //
            this.listeE[1]=new ListeElement("Retard",nomColonne,attribut,new Adherent());
            this.listeE[1].setData(bq.adherentRetardataire());
            for(int i=0;i<listeE.length;i++)
            //
            nomColonne=new String[7];
            nomColonne[0]="Titre";nomColonne[1]="Auteur";nomColonne[2]="Code";nomColonne[3]="Code1";
            nomColonne[4]="Code2";nomColonne[5]="NB_Exemplaire";nomColonne[6]="NB_Disponible";
            attribut=new String[7];
            attribut[0]="titre";attribut[1]="auteur";attribut[3]="code1";attribut[4]="code2";
            attribut[5]="nb_exemplaire_total";attribut[6]="nb_exemplaire_dispo";
            this.listeE[2]=new ListeElement<Livre>("Livre",nomColonne,attribut,new Livre());
            this.listeE[2].setData(bq.getListLivre());
            System.out.println(bq.getListLivre().get(0).getAuteur());
            //
            this.listeE[3]=new ListeElement("Emprunt en cours",nomColonne,attribut,new Livre());
            this.listeE[3].setData(bq.livreEmprunter());
            for(int i=0;i<listeE.length;i++)
            {
               this.listeE[i].setVisible(false);
               this.getChildren().add(listeE[i]);
            }
            this.ecriture=new Pane[2];
            this.ecriture[0]=new FormulaireAdherent(pa);
            this.ecriture[1]=new FormulaireLivre(pa);
            this.getChildren().addAll(this.ecriture[0],this.ecriture[1]);
            this.listeE[0].addSearch();
            this.listeE[0].getSearch().setOnKeyPressed(new HandlerRechercheAdherent(pa));
            this.setPadding(new Insets(0, 50, 0, 50));
            
        }
        public MenuPrincipal getMn(){
            return this.mn;
        }
        public ListeElement[] getLe()
        {
            return this.listeE;
        }
         public Pane[] getEc()
        {
            return this.ecriture;
        }
        public void desactiverListe()
        {
            for(int i=0;i<this.listeE.length;i++)
            {
                this.listeE[i].setVisible(false);
            }
        }
        public void desactiverEcriture()
        {
             for(int i=0;i<this.ecriture.length;i++)
            {
                this.ecriture[i].setVisible(false);
            }
        }
}
