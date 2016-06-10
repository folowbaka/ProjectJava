
package projet;

class Livre {
    private String titre;
    private String[] hauteur=new String[3];
    private String code1;
    private int nb_exemplaire_total;
    private int nb_exemplaire_dispo;
    private int code2;

    public Livre(String titre, String[] hauteur, String code1, int nb_exemplaire, Bibliotheque bibli)
    {
        this.titre=titre;
        this.hauteur[0]=hauteur[0];
        this.hauteur[1]=hauteur[1];
        this.hauteur[2]=hauteur[2];
        this.code1=code1;
        this.nb_exemplaire_total=nb_exemplaire;
        this.nb_exemplaire_dispo=this.getNb_exemplaire_total();
        this.code2=bibli.getNbLivre_Type(this.getCode1())+1;
    }

    public String getTitre() {
        return this.titre;
    }

    public String[] getHauteur() {
        return this.hauteur;
    }

    public String getCode1() {
        return this.code1;
    }
    
    public int getCode2() {
        return this.code2;
    }
    
    public String getCode() {
        return this.code1+String.valueOf(this.code2);
    }
    public int getNb_exemplaire_total() {
        return this.nb_exemplaire_total;
    }

    public int getNb_exemplaire_dispo() {
        return this.nb_exemplaire_dispo;
    }
    
    public String toString()
    {
        return "["+this.code1+"-"+String.format("%03d",this.code2)+"]"+this.titre+" : "+this.hauteur[0]+" "+String.valueOf(this.nb_exemplaire_dispo)+"/"+String.valueOf(this.nb_exemplaire_total);
    }
}
