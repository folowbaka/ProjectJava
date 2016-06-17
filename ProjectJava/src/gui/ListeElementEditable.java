/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.input.MouseEvent;
import projectjava.Adherent;
import projectjava.Livre;

public class ListeElementEditable<T> extends ListeElement {
    
    private ProjectJava pa;
    final private int MAXLIVRE=3;
    public ListeElementEditable(String nomTable, String[] nomColonne, String[] attribut, T test,ProjectJava pa) 
    {
        super(nomTable, nomColonne, attribut, test);
        this.pa=pa;
        this.getStyleClass().add("TableEditable");
        
        
        this.getTable().setOnMousePressed(new EventHandler<MouseEvent>() 
        {
        @Override 
        public void handle(MouseEvent event) 
        {
            if (event.isPrimaryButtonDown() && event.getClickCount() == 2) 
            {
                setVisible(false);
                if(test instanceof Adherent)
                {
                   ((FicheAdherent)pa.getPCentrale().getEc()[4]).setAd((Adherent)getTable().getSelectionModel().getSelectedItem());
                   ((FicheAdherent)pa.getPCentrale().getEc()[4]).remplissage();
                   Livre[] l=new Livre[MAXLIVRE];
                   ObservableList<Livre> listlivre =FXCollections.observableArrayList (pa.getBibliotheque().getListLivre());
                   for(int i=0;i<l.length;i++)
                   {
                       l[i]=((FicheAdherent)pa.getPCentrale().getEc()[4]).getAd().getEmprunt_livre()[i];
                       ObservableList<Livre> items =FXCollections.observableArrayList (l[i]);
                       ((FicheAdherent)pa.getPCentrale().getEc()[4]).getEmprunt().get(i).setItems(items);
                       ((FicheAdherent)pa.getPCentrale().getEc()[4]).getEmprunt().get(i).setCellFactory(ComboBoxListCell.forListView(listlivre));
                       //System.out.println(((FicheAdherent)pa.getPCentrale().getEc()[4]).getAd().getEmprunt_date()[0].getTime());
                       if(((FicheAdherent)pa.getPCentrale().getEc()[4]).getEmprunt().get(i).getItems().get(0)==null)
                       {
                           ((FicheAdherent)pa.getPCentrale().getEc()[4]).getEmprunt().get(i).setEditable(true);
                           ((FicheAdherent)pa.getPCentrale().getEc()[4]).getRestituer()[i].setDisable(true);
                           ((FicheAdherent)pa.getPCentrale().getEc()[4]).getEmprunter()[i].setDisable(false);
                       }
                       else
                       {
                           ((FicheAdherent)pa.getPCentrale().getEc()[4]).getEmprunt().get(i).setEditable(false);
                            ((FicheAdherent)pa.getPCentrale().getEc()[4]).getRestituer()[i].setDisable(false);
                            ((FicheAdherent)pa.getPCentrale().getEc()[4]).getEmprunter()[i].setDisable(true);
                       }
                   }
                   ((FicheAdherent)pa.getPCentrale().getEc()[4]).setVisible(true);
                }
                else if(test instanceof Livre)
                {
                    ((FicheLivre)pa.getPCentrale().getEc()[5]).setLi((Livre)getTable().getSelectionModel().getSelectedItem());
                    ((FicheLivre)pa.getPCentrale().getEc()[5]).remplissage();
                    ((FicheLivre)pa.getPCentrale().getEc()[5]).setVisible(true);
                }
            
            }
        }});
    }
    
    
}
