/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 * Classe modelisant une adresse postale
 */
package projectjava;

import java.io.Serializable;

public class Adresse implements Serializable {

    //Variables qui caractérisent une adresse
    private String numero;
    private String rue;
    private String cp;
    private String ville;

    //Constructeur à paramètres
    public Adresse(String numero, String rue, String cp, String ville) {
        this.setNumero(numero);
        this.setRue(rue);
        this.setCp(cp);
        this.setVille(Perso.toTitleCase(ville));
    }

    /*
        Getters et Setters des variables de la classe
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCp() {
        return cp;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public String getNumero() {
        return numero;
    }

    //Méthode d'affichage/debug
    public String toString() {
        return getNumero() + " " + getRue() + " " + cp + " " + ville;
    }
}
