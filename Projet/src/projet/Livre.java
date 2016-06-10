
package projet;

class Livre {
    String titre,hauteur[],code1;
    int nb_exemplaire_total,nb_exemplaire_dispo,code2;
    
    public void Livre(String titre, String hauteur[], String code1, int nb_exemplaire, Bibliotheque bibli)
    {
        this.titre=titre;
        this.hauteur[0]=hauteur[0];
        this.hauteur[1]=hauteur[1];
        this.hauteur[2]=hauteur[2];
        this.code1=code1;
        this.nb_exemplaire_total=nb_exemplaire;
        this.nb_exemplaire_dispo=this.nb_exemplaire_total;
        this.code2=bibli.getNbLivre_Type(this.code1);
    }
}
