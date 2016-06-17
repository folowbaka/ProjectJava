/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package gui;

import handler.HandlerButtonValiderL;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FormulaireLivre  extends Formulaire{
    
    public FormulaireLivre(ProjectJava pa)
    {
        super(pa);
        this.getStyleClass().add("formAjout");
        this.FormLGeneral();
        this.titreForm("Formulaire Livre");
        this.validerForm();
        this.add(this.getTitre(), 0, 0);
        this.add(this.sTitreForm("Description"), 0, 1);
        this.add(this.getSousForm().get(0),0,2);
        this.add(this.getValider(),0,3);
    }
    
    public void FormLGeneral()
    {
        this.getSousForm().add(new GridPane());
        Label titreLi=new Label("Titre");
        TextField titreField=new TextField();
        this.getValeur().add(titreField);
        this.getSousForm().get(0).add(titreLi, 0, 1);
        this.getSousForm().get(0).add(titreField, 1, 1);
        Label auteurLi=new Label("Auteur");
        TextField auteurField=new TextField();
        this.getValeur().add(auteurField);
        this.getSousForm().get(0).add(auteurLi, 2, 1);
        this.getSousForm().get(0).add(auteurField, 3, 1);
        Label categLi=new Label("Catégorie");
        TextField categField=new TextField();
        this.getValeur().add(categField);
        this.getSousForm().get(0).add(categLi,0, 2);
        this.getSousForm().get(0).add(categField, 1, 2);
        Label qaLi=new Label("Quantité");
        TextField qaField=new TextField();
        this.getValeur().add(qaField);
        this.getSousForm().get(0).add(qaLi,2, 2);
        this.getSousForm().get(0).add(qaField, 3, 2);
        this.getSousForm().get(0).setHgap(10);
        this.getSousForm().get(0).setVgap(5);
        this.getSousForm().get(0).getStyleClass().add("form");
    }
    
    public void validerForm()
    {
       super.validerForm();
       this.getValidation().setOnMousePressed(new HandlerButtonValiderL(this.getPa()));
    }
}
