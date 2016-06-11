package projet;

import java.util.Calendar;

/**
 *
 * @author Ghiles
 */
public class Adherent {
    String id,nom,prenom,email,profession;
    Livre emprunt_livre[]=new Livre[3];
    Calendar emprunt_date[]=new Calendar[3];
    int nb_emprunt;
    Adresse adresse;
    
    public Adherent(String id, String nom, String prenom, String email, String profession, Adresse adresse)
    {
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.profession=profession;
        nb_emprunt=0;
        this.adresse=adresse;
    }
    
    public boolean emprunter(Livre livre)
    {
        if (this.nb_emprunt>=3)
        {
            return false;
        }
        if (livre.getNb_exemplaire_dispo()==0)
        {
            return false;
        }
        
        this.emprunt_livre[this.nb_emprunt]=livre;
        this.emprunt_date[this.nb_emprunt]=Calendar.getInstance();
        this.emprunt_date[this.nb_emprunt].add(Calendar.DAY_OF_MONTH, 15);
        this.nb_emprunt++;
        livre.decNb_exemplaire_dispo();
        return true;
    }
    
    public String toString()
    {
        return this.nom+" "+this.prenom+" ["+this.adresse.toString()+"] "+this.email+" "+this.profession+" "+this.nb_emprunt;
    }
}
