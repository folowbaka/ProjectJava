
package projectjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    
    public void removeAdherent(Adherent adh)
    {
        if(this.adherent.contains(adh))
        {
            adh.rendre(0);
            adh.rendre(0);
            adh.rendre(0);
            this.adherent.remove(adh);
        }
    }
     public int foundAdherent(Adherent adh)
    {
        int i=0;
        if(this.adherent.contains(adh))
        {
          for(Adherent ad:this.adherent)
            {
                if(ad==adh)
                {
                    i++;
                }
            }
        }
        return i;
    }
    
    public void removeAdherent_id(String id)
    {
        for(Adherent adh:this.adherent)
        {
            if(adh.getId().equals(id))
            {
                this.removeAdherent(adh);
            }
        }
    }
    
    public void removeLivre(Livre livre_)
    {
        if(this.livre.contains(livre_))
        {
            for(Adherent adh:this.adherent)
            {
                if(adh.emprunteLivre(livre_)!=null)
                {
                    adh.rendre(adh.emprunteLivre_id(livre_));
                    return;
                }
            }
            
            this.livre.remove(livre_);
        }
    }
    
    public void removeLivre_id(String code1,String code2)
    {
        for(Livre livre_:this.livre)
        {
            if(livre_.getCode().equals(code1+code2))
            {
                this.removeLivre(livre_);
                return;
            }
        }
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
    
    public ArrayList<EmpruntE> livreEmprunter()
    {
        ArrayList<EmpruntE> resultat=new ArrayList<EmpruntE>();
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");

        for(Livre livre_:this.livre)
        {
            if(livre_.getNb_exemplaire_total()!=livre_.getNb_exemplaire_dispo())
            {
                for(Adherent adh:this.search_possesseur_livre(livre_))
                {
                    if(adh.emprunteLivre(livre_)!=null)
                    {
                        resultat.add(new EmpruntE(livre_.getTitre(),adh.getNom(),adh.getPrenom(),format1.format(adh.emprunteLivre(livre_).getTime())));                      
                    }
                }
            }
        }
        System.out.println(resultat.get(0).toString());
        return resultat;
    }
        
    public int getID()
    {
        return this.current_id;
    }
    
    public void rendreLivre(Livre livre_)
    {
        if(this.livre.contains(livre_))
        {
            this.livre.get(this.livre.indexOf(livre_)).incNb_exemplaire_dispo();
        }
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
    
    public ArrayList<Adherent> search_possesseur_livre(String titre)
    {
        ArrayList<Adherent> resultat=new ArrayList<Adherent>();
        Livre[] temp;
        
        for (Adherent adh:this.adherent)
        {
            temp=adh.getEmprunt_livre();
            
            if(temp[0]!=null&&temp[0].getTitre().contains(titre)||temp[1]!=null&&temp[1].getTitre().contains(titre)||temp[2]!=null&&temp[2].getTitre().contains(titre))
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
            if(livre_.getTitre().toLowerCase().contains(titre.toLowerCase()))
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
            if(livre_.getAuteurS().toLowerCase().contains(auteur.toLowerCase()))
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
            if(adh.getNom().toLowerCase().contains(personne.toLowerCase())||adh.getPrenom().toLowerCase().contains(personne.toLowerCase()))
            {
                resultat.add(adh);
            }
        }
        
        return resultat;
    }
    
    public ArrayList<Adherent> search_adherent_profession(String profession)
    {
        ArrayList<Adherent> resultat=new ArrayList<Adherent>();
        
        for (Adherent adh:this.adherent)
        {
            if(adh.getProfession().toLowerCase().contains(profession.toLowerCase()))
            {
                resultat.add(adh);
            }
        }
        
        return resultat;
    }
    
    public ArrayList<Adherent> search_adherent_mail(String mail)
    {
        ArrayList<Adherent> resultat=new ArrayList<Adherent>();
        
        for (Adherent adh:this.adherent)
        {
            if(adh.getEmail().toLowerCase().contains(mail.toLowerCase()))
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
