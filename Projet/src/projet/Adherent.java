package javaapplication3;

import java.util.Calendar;

/**
 *
 * @author Ghiles
 */
public class Adherent {
    String id,nom,prenom,email,profession;
    Livre emprunt_livre[];
    Calendar emprunt_date[];
    int nb_emprunt;
    Adresse adresse;
    
    public void Adherent(String id, String nom, String prenom, String email, String profession, Adresse adresse)
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
        if (this.nb_emprunt<3)
        {
            this.emprunt_livre[this.nb_emprunt]=livre;
            this.emprunt_date[this.nb_emprunt]=Calendar.getInstance();
            this.emprunt_date[this.nb_emprunt].add(Calendar.DAY_OF_MONTH, 15);
            this.nb_emprunt++;
            return true;
        }
        else
        {
            return false;
        }
    }
}
