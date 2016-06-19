/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package projectjava;


public class EmpruntE {
    private String titre;
    private String nom;
    private String prenom;
    private String date;

        
    public EmpruntE()
    {
        this.titre=null;
        this.nom=null;
        this.prenom=null;
        this.date=null;
    }
    
    public EmpruntE(String titre,String nom,String prenom,String date)
    {
        this.titre=titre;
        this.nom=nom;
        this.prenom=prenom;
        this.date=date;
    }
    
    public String getTitre()
    {
        return this.titre;
    }
    
    public String getNom()
    {
        return this.nom;
    }
    
    public String getPrenom()
    {
        return this.prenom;
    }
    
    public String getDate()
    {
        return this.date;
    }
    
    public String toString()
    {
        return titre+" "+nom+" "+prenom+" "+date;
    }
}
