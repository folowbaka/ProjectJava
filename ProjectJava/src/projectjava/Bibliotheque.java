
package projectjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Bibliotheque {
    private ArrayList<Adherent> adherent;
    private ArrayList<Livre> livre;
    
    public Bibliotheque()
    {
        adherent=new ArrayList<Adherent>();
        livre=new ArrayList<Livre>();
    }
    
    public void addLivre(Livre livre)
    {
        this.livre.add(livre);
    }
    
    public void addAdherent(Adherent adherent)
    {
        this.adherent.add(adherent);
    }
    
    public int getNbLivre_Type(String type)
    {
        int compteur=0;
        
        for(Livre livre_ : this.livre)
        {
            if (livre_.getCode1().equals(type))
            {
                compteur++;
            }
        }
        
        return compteur;
    }
    
    public int getNbAdherent()
    {
        return this.adherent.size();
    }
    
    public ArrayList<Adherent> get_adherent_alpha()
    {
        Collections.sort(this.adherent, (Adherent adh1, Adherent adh2) -> adh2.getPrenom().compareTo(adh2.getPrenom()));
        
        return this.adherent;
    }
    
    public String Livre_toString()
    {
        String result=new String();
        
        for(Livre livre_ : this.livre)
        {
            result+=livre_.toString()+"\n";
        }
        
        return result;
    }
    
    public String Adherent_toString()
    {
        String result=new String();
        
        for(Adherent adherent_ : this.adherent)
        {
            result+=adherent.toString()+"\n";
        }
        
        return result;
    }
}
