/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package projectjava;

public class EmpruntE {

    //Déclaration des variables qui caractérisent un emprunt
    private String titre;
    private String nom;
    private String prenom;
    private String date;

    //Constructeur par défaut
    public EmpruntE() {
        this.titre = null;
        this.nom = null;
        this.prenom = null;
        this.date = null;
    }

    //Constructeur à paramètres
    public EmpruntE(String titre, String nom, String prenom, String date) {
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
    }

    /*
        Getters et Setters des variables de la classe
     */
    public String getTitre() {
        return this.titre;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getDate() {
        return this.date;
    }

    //Méthode d'affichage/debug
    public String toString() {
        return titre + " " + nom + " " + prenom + " " + date;
    }
}
