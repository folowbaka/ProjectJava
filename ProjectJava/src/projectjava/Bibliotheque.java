
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
    
    public int getID()
    {
        return this.current_id;
    }
    
    public ArrayList<Adherent> get_adherent_alpha_nom()
    {
        Collections.sort(this.adherent, (Adherent adh1, Adherent adh2) -> adh1.getNom().compareTo(adh2.getNom()));
        
        return this.adherent;
    }
    
    public ArrayList<Adherent> get_adherent_alpha_prenom()
    {
        Collections.sort(this.adherent, (Adherent adh1, Adherent adh2) -> adh1.getPrenom().compareTo(adh2.getPrenom()));
        
        return this.adherent;
    }
    
    public ArrayList<Adherent> get_adherent_croissant_id()
    {
        Collections.sort(this.adherent, (Adherent adh1, Adherent adh2) -> adh1.getId().compareTo(adh2.getId()));
        
        return this.adherent;
    }
    
    public ArrayList<Adherent> get_adherent_alpha_profession()
    {
        Collections.sort(this.adherent, (Adherent adh1, Adherent adh2) -> adh1.getProfession().compareTo(adh2.getProfession()));
        
        return this.adherent;
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
}
