
package projectjava;

import java.io.Serializable;

public class Livre implements Serializable {
    private String titre;
    private String auteur;
    private String code1;
    private int nb_exemplaire_total;
    private int nb_exemplaire_dispo;
    private int code2;
    
     public Livre()
    {
        this.titre=null;
        this.auteur=null;
        this.code1=null;
        this.nb_exemplaire_total=0;
        this.nb_exemplaire_dispo=0;
        this.code2=0;
    }
    public Livre(String titre, String auteur, String code1, int nb_exemplaire, Bibliotheque bibli)
    {
        this.titre=titre;
        this.auteur=auteur;
        this.code1=code1;
        this.nb_exemplaire_total=nb_exemplaire;
        this.nb_exemplaire_dispo=this.getNb_exemplaire_total();
        this.code2=bibli.getNbLivre_Type(this.getCode1())+1;
    }

    public String getTitre()
    {
        return this.titre;
    }

    public String getAuteur()
    {
        return this.auteur;
    }
    
    public String getAuteurS()
    {
        return this.auteur;
    }

    public String getCode1()
    {
        return this.code1;
    }
    
    public int getCode2()
    {
        return this.code2;
    }
    
    public String getCode()
    {
        return this.code1+String.valueOf(this.code2);
    }
    public int getNb_exemplaire_total()
    {
        return this.nb_exemplaire_total;
    }

    public int getNb_exemplaire_dispo()
    {
        return this.nb_exemplaire_dispo;
    }
    
    public boolean decNb_exemplaire_dispo()
    {
        if(this.nb_exemplaire_dispo>0)
        {
            this.nb_exemplaire_dispo--;
            return true;
        }
        return false;
    }
    
    public String toString()
    {
        return "["+this.code1+"-"+String.format("%03d",this.code2)+"]"+this.titre+" : "+this.auteur+" "+String.valueOf(this.nb_exemplaire_dispo)+"/"+String.valueOf(this.nb_exemplaire_total);
    }
}
