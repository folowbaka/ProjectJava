package projectjava;

import java.io.Serializable;
import java.util.Calendar;

public class Adherent implements Serializable {
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String profession;
    private Livre[] emprunt_livre;
    private Calendar[] emprunt_date;
    private int nb_emprunt;
    private Adresse adresse;
    
    public Adherent()            
    {
        this.setId(null);
        this.setNom(null);
        this.setPrenom(null);
        this.setEmail(null);
        this.setProfession(null);
        this.emprunt_livre =null;
        this.emprunt_date = null;
        this.nb_emprunt=0;
        this.setAdresse(null);
    }
      
    public Adherent(int id, String nom, String prenom, String email, String profession, Adresse adresse)
    {
        this.setId(String.valueOf(id));
        this.setNom(Perso.toTitleCase(nom));
        this.setPrenom(Perso.toTitleCase(prenom));
        this.setEmail(email);
        this.setProfession(Perso.toTitleCase(profession));
        this.emprunt_livre = new Livre[3];
        this.emprunt_date = new Calendar[3];
        this.nb_emprunt=0;
        this.setAdresse(adresse);
    }
    
    public Adherent(int id, String nom, String prenom, String profession)
    {
        this(id,nom,prenom,"bibli."+String.valueOf(id)+"@bibli.net",profession,new Adresse(String.valueOf(id),"rue du Random","93800","Epinay Sur Seine"));
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
    
    public Livre[] getEmprunt_livre() {
        return emprunt_livre;
    }

    public Calendar[] getEmprunt_date() {
        return emprunt_date;
    }
    
    /*public boolean emprunter(Livre livre)
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
        this.getEmprunt_date()[this.getNb_emprunt()].add(Calendar.DAY_OF_MONTH, 15);
        this.nb_emprunt++;
        livre.decNb_exemplaire_dispo();
        return true;
    }*/
    public boolean emprunter(Livre livre,Calendar c)
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
        this.emprunt_date[this.getNb_emprunt()]=c;
        System.out.println(this.nb_emprunt);
        System.out.println(c.getTime());
        this.nb_emprunt++;
        livre.decNb_exemplaire_dispo();
        return true;
    }
    
    public void rendre(int id)
    {
        if(this.nb_emprunt>=0)
     {
            if(id<this.nb_emprunt)
            {
                this.emprunt_date[id]=null;
                this.emprunt_livre[id].getBibli().rendreLivre(this.emprunt_livre[id]);
            }
            while(id<2)
            {
                this.emprunt_date[id]=this.emprunt_date[id+1];
                this.emprunt_livre[id]=this.emprunt_livre[id+1];
                id++;
            }
            this.nb_emprunt--;
     }
    }
    
    public Calendar emprunteLivre(Livre livre)
    {
        if(this.emprunt_livre[0]!=null&&this.emprunt_livre[0].equals(livre))
        {
            return this.emprunt_date[0];
        }
        if(this.emprunt_livre[1]!=null&&this.emprunt_livre[1].equals(livre))
        {
            return this.emprunt_date[1];
        }
        if(this.emprunt_livre[2]!=null&&this.emprunt_livre[2].equals(livre))
        {
            return this.emprunt_date[2];
        }
        
        return null;
    }
    
    public int emprunteLivre_id(Livre livre)
    {
        if(this.emprunt_livre[0]!=null&&this.emprunt_livre[0].equals(livre))
        {
            return 0;
        }
        if(this.emprunt_livre[1]!=null&&this.emprunt_livre[1].equals(livre))
        {
            return 1;
        }
        if(this.emprunt_livre[2]!=null&&this.emprunt_livre[2].equals(livre))
        {
            return 2;
        }
        
        return -1;
    }
    
    public boolean emprunterRetard(Livre livre)
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
        this.getEmprunt_date()[this.getNb_emprunt()].add(Calendar.DAY_OF_MONTH, -2);
        this.nb_emprunt++;
        livre.decNb_exemplaire_dispo();
        return true;
    }
    public boolean retard()
    {
        System.out.println("retard");
        int i=0;
        Calendar actuel=Calendar.getInstance();
        while(i<this.emprunt_date.length && !actuel.after(this.getEmprunt_date()[i]))
        {
            i++;
        }
        System.out.println(i);
        return i<this.emprunt_date.length;
    }
        
    public String toString()
    {
        return this.getId()+" "+this.getNom()+" "+this.getPrenom()+" ["+this.getAdresse().toString()+"] "+this.getEmail()+" "+this.getProfession()+" "+this.getNb_emprunt();
    }
}
