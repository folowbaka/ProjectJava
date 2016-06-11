package projet;

import java.util.ArrayList;

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
