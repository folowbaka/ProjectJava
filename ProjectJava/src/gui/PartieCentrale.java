/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import handler.HandlerRechercheAdherent;
import handler.HandlerRechercheAdherentEcriture;
import handler.HandlerRechercheLivre;
import handler.HandlerRechercheLivreEcriture;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import projectjava.Adherent;
import projectjava.Bibliotheque;
import projectjava.EmpruntE;
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
        final int NB_BUTTONECRITURE=6;

        public PartieCentrale(MenuPrincipal mn,Bibliotheque bq,ProjectJava pa)
        {
            super();
            this.setId("PaneCentral");
            this.mn=mn;
            StackPane.setMargin(this.mn,new Insets(0,0,0,-200));
            this.ecriture=new Pane[NB_BUTTONECRITURE];
            this.getChildren().add(this.mn);
            String nomColonne[]={"Nom","Prenom","@Mail","Profession"};
            String attribut[]={"nom","prenom","email","profession"};
            /*String nomColonne1[]={"Titre","Auteur","Exemplaire dispo","Exemplaire total"};
            String attribut1[]={"titre","auteur","exemplaire dispo","exemplaire total"};
            String nomColonne2[]={"Nom","Prenom","@Mail","Profession"};
            String attribut2[]={"nom","prenom","email","profession"};*/
            //
            listeE=new ListeElement[NB_BUTTON];
            //bq.getListAdherent().get(0).emprunter(bq.getListLivre().get(2));
            this.listeE[0]=new ListeElement<Adherent>("Adherent",nomColonne,attribut,new Adherent());
            this.ecriture[2]=new ListeElementEditable("Adherent",nomColonne,attribut,new Adherent(),pa);
            this.listeE[0].setData(bq.getListAdherent());
            ((ListeElementEditable)this.ecriture[2]).setData(bq.getListAdherent());
            //
            this.listeE[1]=new ListeElement("Retard",nomColonne,attribut,new Adherent());
            this.listeE[1].setData(bq.adherentRetardataire());
            System.out.println(bq.adherentRetardataire().size());
            for(int i=0;i<listeE.length;i++)
            //
            nomColonne=new String[7];
            nomColonne[0]="Titre";nomColonne[1]="Auteur";nomColonne[2]="Code";nomColonne[3]="Code1";
            nomColonne[4]="Code2";nomColonne[5]="NB_Exemplaire";nomColonne[6]="NB_Disponible";
            attribut=new String[7];
            attribut[0]="titre";attribut[1]="auteur";attribut[3]="code1";attribut[4]="code2";
            attribut[5]="nb_exemplaire_total";attribut[6]="nb_exemplaire_dispo";
            this.listeE[2]=new ListeElement<Livre>("Livre",nomColonne,attribut,new Livre());
            this.ecriture[3]=new ListeElementEditable("Livre",nomColonne,attribut,new Livre(),pa);
            this.listeE[2].setData(bq.getListLivre());
            ((ListeElementEditable)this.ecriture[3]).setData(bq.getListLivre());
            System.out.println(bq.getListLivre().get(0).getAuteur());
            //
            nomColonne=new String[4];
            nomColonne[0]="Titre";nomColonne[1]="Nom";nomColonne[2]="Prenom";nomColonne[3]="D_Retour";
            attribut=new String[4];
            attribut[0]="titre";attribut[1]="s2";attribut[2]="s3";attribut[3]="s4";
            this.listeE[3]=new ListeElement<EmpruntE>("Emprunt en cours",nomColonne,attribut,new EmpruntE());
            this.listeE[3].setData(bq.livreEmprunter());
            this.ecriture[4]=new FicheAdherent(pa);
            this.ecriture[5]=new FicheLivre(pa);
            
            for(int i=2;i<NB_BUTTONECRITURE;i++)
            {
               this.ecriture[i].setVisible(false);
               this.getChildren().add(ecriture[i]);
            }
            for(int i=0;i<listeE.length;i++)
            {
               this.listeE[i].setVisible(false);
               this.getChildren().add(listeE[i]);
            }
            this.ecriture[0]=new FormulaireAdherent(pa);
            this.ecriture[1]=new FormulaireLivre(pa);
            this.getChildren().addAll(this.ecriture[0],this.ecriture[1]);
            String[] choix={"Nom","Titre"};
            this.listeE[0].addSearch(choix);
            ((ListeElementEditable)this.ecriture[2]).addSearch(choix);
            this.listeE[0].getSearch().setOnKeyReleased(new HandlerRechercheAdherent(pa));
            ((ListeElementEditable)this.ecriture[2]).getSearch().setOnKeyReleased(new HandlerRechercheAdherentEcriture(pa));
            choix=new String[2];
            choix[0]="Titre";choix[1]="Auteur";
            this.listeE[2].addSearch(choix);
            ((ListeElementEditable)this.ecriture[3]).addSearch(choix);
            this.listeE[2].getSearch().setOnKeyReleased(new HandlerRechercheLivre(pa));
            ((ListeElementEditable)this.ecriture[3]).getSearch().setOnKeyReleased(new HandlerRechercheLivreEcriture(pa));
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
