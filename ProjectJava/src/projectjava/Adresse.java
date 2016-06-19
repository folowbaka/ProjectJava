/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 * Classe modelisant une adresse postale
 */
package projectjava;

import java.io.Serializable;

public class Adresse implements Serializable {
    private String numero;
    private String rue;
    private String cp;
    private String ville;
    
    public Adresse(String numero, String rue, String cp, String ville)
    {
        this.setNumero(numero);
        this.setRue(rue);
        this.setCp(cp);
        this.setVille(Perso.toTitleCase(ville));
    }
    
    public void setNumero(String numero)
    {
        this.numero = numero;
    }
    
    public void setVille(String ville)
    {
        this.ville = ville;
    }
    
    public void setRue(String rue)
    {
        this.rue = rue;
    }
    
    public void setCp(String cp)
    {
        this.cp = cp;
    }
    
    public String getCp()
    {
        return cp;
    }
    
    public String getRue() 
    {
        return rue;
    }
    
    public String getVille() 
    {
        return ville;
    }

    public String getNumero() 
    {
        return numero;
    }

    public String toString()
    {
        return getNumero()+" "+getRue()+" "+cp+" "+ville;
    }
}
