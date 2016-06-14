package projectjava;

import java.util.Calendar;

public class Adherent {
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String profession;
    private Livre[] emprunt_livre;
    private Calendar[] emprunt_date;
    private int nb_emprunt;
    private Adresse adresse;
    
    public Adherent(String id, String nom, String prenom, String email, String profession, Adresse adresse)
    {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setEmail(email);
        this.setProfession(profession);
        this.emprunt_livre = new Livre[3];
        this.emprunt_date = new Calendar[3];
        this.nb_emprunt=0;
        this.setAdresse(adresse);
    }
    
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getProfession()
    {
        return profession;
    }

    public void setProfession(String profession)
    {
        this.profession = profession;
    }

    public int getNb_emprunt()
    {
        return nb_emprunt;
    }

    public Adresse getAdresse()
    {
        return adresse;
    }

    public void setAdresse(Adresse adresse)
    {
        this.adresse = adresse;
    }
    
    public boolean emprunter(Livre livre)
    {
        if (this.getNb_emprunt()>=3)
        {
            return false;
        }
        if (livre.getNb_exemplaire_dispo()==0)
        {
            return false;
        }
        
        this.emprunt_livre[this.getNb_emprunt()]=livre;
        this.emprunt_date[this.getNb_emprunt()]=Calendar.getInstance();
        this.emprunt_date[this.getNb_emprunt()].add(Calendar.DAY_OF_MONTH, 15);
        this.nb_emprunt++;
        livre.decNb_exemplaire_dispo();
        return true;
    }
        
    public String toString()
    {
        return this.getNom()+" "+this.getPrenom()+" ["+this.getAdresse().toString()+"] "+this.getEmail()+" "+this.getProfession()+" "+this.getNb_emprunt();
    }
}
