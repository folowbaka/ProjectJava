
package projectjava;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bibliotheque implements Serializable {
    private ArrayList<Adherent> adherent;
    private ArrayList<Livre> livre;
    private int current_id;
    
    public Bibliotheque()
    {
        adherent=new ArrayList<Adherent>();
        livre=new ArrayList<Livre>();
        current_id=0;
    }
    
    public void addLivre(Livre livre)
    {
        this.livre.add(livre);
    }
    
    public void addAdherent(Adherent adherent)
    {
        this.adherent.add(adherent);
        current_id++;
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
    public ArrayList<Adherent> getListAdherent()
    {
        return this.adherent;
    }
    
    public ArrayList<Livre> getListLivre()
    {
        return this.livre;
    }
    
    public ArrayList<Livre> livreEmprunter()
    {
        ArrayList<Livre> resultat=new ArrayList<Livre>();
        
        for(Livre livre_:this.livre)
        {
            if(livre_.getNb_exemplaire_total()!=livre_.getNb_exemplaire_dispo())
            {
                resultat.add(livre_);
            }
        }
        
        return resultat;
    }
        
    public int getID()
    {
        return this.current_id;
    }
    
    public static Bibliotheque loadBibliotheque(String file)
    {
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
    
    public boolean saveBibliotheque(String file)
    {
        ObjectOutputStream  writer;
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
    
    public ArrayList<Adherent> search_possesseur_livre(Livre l)
    {
        ArrayList<Adherent> resultat=new ArrayList<Adherent>();
        Livre[] temp;
        
        for (Adherent adh:this.adherent)
        {
            temp=adh.getEmprunt_livre();
            
            if(temp[0]!=null&&temp[0].getCode().equals(l.getCode())||temp[1]!=null&&temp[1].getCode().equals(l.getCode())||temp[2]!=null&&temp[2].getCode().equals(l.getCode()))
            {
                resultat.add(adh);
            }
        }
        
        return resultat;
    }
    
    public ArrayList<Livre> search_livre_titre(String titre)
    {
        ArrayList<Livre> resultat=new ArrayList<Livre>();
        
        for (Livre livre_:this.livre)
        {
            if(livre_.getTitre().equals(titre))
            {
                resultat.add(livre_);
            }
        }
        
        return resultat;
    }
    
    public ArrayList<Livre> search_livre_auteur(String auteur)
    {
        ArrayList<Livre> resultat=new ArrayList<Livre>();
        
        for (Livre livre_:this.livre)
        {
            if(livre_.getAuteurS().contains(auteur))
            {
                resultat.add(livre_);
            }
        }
        
        return resultat;
    }
    
    public ArrayList<Adherent> search_adherent(String personne)
    {
        ArrayList<Adherent> resultat=new ArrayList<Adherent>();
        
        for (Adherent adh:this.adherent)
        {
            if(adh.getNom().contains(personne)||adh.getPrenom().contains(personne))
            {
                resultat.add(adh);
            }
        }
        
        return resultat;
    }
   public ArrayList<Adherent> adherentRetardataire()
    {
        ArrayList<Adherent> resultat=new ArrayList<Adherent>();
        for (Adherent adh:this.adherent)
        {
            if(adh.retard())
            {
                resultat.add(adh);
            }
        }
        return resultat;
    }
}
