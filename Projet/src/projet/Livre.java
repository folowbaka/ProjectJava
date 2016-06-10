
package projet;

class Livre {
    String titre,hauteur[],code1;
    int code2,nb_exemplaire_total,nb_exemplaire_dispo;
    
    public void Livre(String titre, String hauteur[], String code1, int nb_exemplaire)
    {
        this.titre=titre;
        this.hauteur[0]=hauteur[0];
        this.hauteur[1]=hauteur[1];
        this.hauteur[2]=hauteur[2];
        this.code1=code1;
        this.nb_exemplaire_total=nb_exemplaire;
        this.nb_exemplaire_dispo=this.nb_exemplaire_total;
    }
}
