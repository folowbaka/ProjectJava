/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 * Classe modelisant le focntionnement d'un bibliotheque
 */
package projectjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.lang.Integer.max;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bibliotheque implements Serializable {

    //Arraylist qui contient les adherents enregistrés
    private ArrayList<Adherent> adherent;
    //Arraylist qui contient les livres enregistrés
    private ArrayList<Livre> livre;
    private int current_id;

    //Constructeur par défaut
    public Bibliotheque() {
        adherent = new ArrayList<Adherent>();
        livre = new ArrayList<Livre>();
        current_id = 0;
    }

    public ArrayList<Adherent> getListAdherent() {
        return this.adherent;
    }

    public ArrayList<Livre> getListLivre() {
        return this.livre;
    }

    public int getID() {
        return this.current_id;
    }

    public int getNbAdherent() {
        return this.adherent.size();
    }

    //Compter les livres d'un certain type pour le code2
    public int getNbLivre_Type(String type) {
        int compteur = 0;

        for (Livre livre_ : this.livre) {
            if (livre_.getCode1().equals(type)) {
                compteur = max(compteur, livre_.getCode2());
            }
        }

        return compteur;
    }

    //Ajouter un livre à la liste
    public void addLivre(Livre livre) {
        if (!this.livre.contains(livre)) {
            this.livre.add(livre);
        }
    }

    //Ajouter un adhérent à la liste
    public void addAdherent(Adherent adherent) {
        if (!this.adherent.contains(adherent)) {
            this.adherent.add(adherent);
            current_id++;
        }
    }

    //Supprimer un adhérent(et rednre ses livres)
    public void removeAdherent(Adherent adh) {
        if (this.adherent.contains(adh)) {
            adh.rendre(0);
            adh.rendre(0);
            adh.rendre(0);
            this.adherent.remove(adh);
        }
    }

    //Supprimer un adhérent (et rednre ses livres) via son ID
    public void removeAdherent_id(String id) {
        for (Adherent adh : this.adherent) {
            if (adh.getId().equals(id)) {
                this.removeAdherent(adh);
            }
        }
    }

    //Supprimer un livre (et le rendre paris tout ses emprunteurs)
    public void removeLivre(Livre livre_) {
        if (this.livre.contains(livre_)) {
            for (Adherent adh : this.adherent) {
                if (adh.emprunteLivre(livre_) != null) {
                    adh.rendre(adh.emprunteLivre_id(livre_));
                    return;
                }
            }

            this.livre.remove(livre_);
        }
    }

    //Supprimer un livre (et le rendre paris tout ses emprunteurs) via ses ID
    public void removeLivre_id(String code1, String code2) {
        for (Livre livre_ : this.livre) {
            if (livre_.getCode().equals(code1 + code2)) {
                this.removeLivre(livre_);
                return;
            }
        }
    }

    public void rendreLivre(Livre livre_) {
        if (this.livre.contains(livre_)) {
            livre_.incNb_exemplaire_dispo();
        }
    }

    //Chercher les propriétaires actuels d'un livre
    public ArrayList<Adherent> search_possesseur_livre(Livre livre_) {
        ArrayList<Adherent> resultat = new ArrayList<Adherent>();
        Livre[] temp;

        for (Adherent adh : this.adherent) {
            temp = adh.getEmprunt_livre();

            if (temp[0] != null && temp[0].getCode().equals(livre_.getCode()) || temp[1] != null && temp[1].getCode().equals(livre_.getCode()) || temp[2] != null && temp[2].getCode().equals(livre_.getCode())) {
                resultat.add(adh);
            }
        }

        return resultat;
    }

    //Chercher les propriétaires actuels d'un livre par son titre
    public ArrayList<Adherent> search_possesseur_livre(String titre) {
        ArrayList<Adherent> resultat = new ArrayList<Adherent>();
        Livre[] temp;

        for (Adherent adh : this.adherent) {
            temp = adh.getEmprunt_livre();

            if (temp[0] != null && temp[0].getTitre().contains(titre) || temp[1] != null && temp[1].getTitre().contains(titre) || temp[2] != null && temp[2].getTitre().contains(titre)) {
                resultat.add(adh);
            }
        }

        return resultat;
    }

    //Chercher un livre par son titre
    public ArrayList<Livre> search_livre_titre(String titre) {
        ArrayList<Livre> resultat = new ArrayList<Livre>();

        for (Livre livre_ : this.livre) {
            if (livre_.getTitre().toLowerCase().contains(titre.toLowerCase())) {
                resultat.add(livre_);
            }
        }

        return resultat;
    }

    //Chercher un livre par son auteur
    public ArrayList<Livre> search_livre_auteur(String auteur) {
        ArrayList<Livre> resultat = new ArrayList<Livre>();

        for (Livre livre_ : this.livre) {
            if (livre_.getAuteurS().toLowerCase().contains(auteur.toLowerCase())) {
                resultat.add(livre_);
            }
        }

        return resultat;
    }

    //Chercher un livre par son genre
    public ArrayList<Livre> search_livre_genre(String genre) {
        ArrayList<Livre> resultat = new ArrayList<Livre>();

        for (Livre livre_ : this.livre) {
            if (livre_.getCode1().toLowerCase().contains(genre.toLowerCase())) {
                resultat.add(livre_);
            }
        }

        return resultat;
    }

    //Chercher un adhérent par son nom ou prenom
    public ArrayList<Adherent> search_adherent(String personne) {
        ArrayList<Adherent> resultat = new ArrayList<Adherent>();

        for (Adherent adh : this.adherent) {
            if (adh.getNom().toLowerCase().contains(personne.toLowerCase()) || adh.getPrenom().toLowerCase().contains(personne.toLowerCase())) {
                resultat.add(adh);
            }
        }

        return resultat;
    }

    //Chercher un adhérent par sa profession
    public ArrayList<Adherent> search_adherent_profession(String profession) {
        ArrayList<Adherent> resultat = new ArrayList<Adherent>();

        for (Adherent adh : this.adherent) {
            if (adh.getProfession().toLowerCase().contains(profession.toLowerCase())) {
                resultat.add(adh);
            }
        }

        return resultat;
    }

    //Chercher un adhérent par son mail
    public ArrayList<Adherent> search_adherent_mail(String mail) {
        ArrayList<Adherent> resultat = new ArrayList<Adherent>();

        for (Adherent adh : this.adherent) {
            if (adh.getEmail().toLowerCase().contains(mail.toLowerCase())) {
                resultat.add(adh);
            }
        }

        return resultat;
    }

    //Chercher la position d'un adherent
    public int foundAdherent(Adherent adh) {
        int i = 0;
        if (this.adherent.contains(adh)) {
            for (Adherent ad : this.adherent) {
                if (ad == adh) {
                    i++;
                }
            }
        }
        return i;
    }

    public ArrayList<Adherent> adherentRetardataire() {
        ArrayList<Adherent> resultat = new ArrayList<Adherent>();
        for (Adherent adh : this.adherent) {
            if (adh.retard()) {
                resultat.add(adh);
            }
        }
        return resultat;
    }

    public ArrayList<EmpruntE> livreEmprunter() {
        ArrayList<EmpruntE> resultat = new ArrayList<EmpruntE>();
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");

        for (Livre livre_ : this.livre) {
            if (livre_.getNb_exemplaire_total() != livre_.getNb_exemplaire_dispo()) {
                for (Adherent adh : this.search_possesseur_livre(livre_)) {
                    if (adh.emprunteLivre(livre_) != null) {
                        resultat.add(new EmpruntE(livre_.getTitre(), adh.getNom(), adh.getPrenom(), format1.format(adh.emprunteLivre(livre_).getTime())));
                    }
                }
            }
        }
        return resultat;
    }

    //Charger une bibliothèque à partir d'un fichier
    public static Bibliotheque loadBibliotheque(String file) {
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file));
            return (Bibliotheque) reader.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Bibliotheque.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bibliotheque.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    //Sauvegarder une bibliothèque
    public boolean saveBibliotheque(String file) {
        ObjectOutputStream writer;
        try {
            writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeObject(this);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Bibliotheque.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    //Affichage des données des livres
    public String Livre_toString() {
        String result = new String();

        for (Livre livre_ : this.livre) {
            result += livre_.toString() + "\n";
        }

        return result;
    }

    //Affichage des données des adhérents
    public String Adherent_toString() {
        String result = new String();

        for (Adherent adh : this.adherent) {
            result += adh.toString() + "\n";
        }

        return result;
    }
}
