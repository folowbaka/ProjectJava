
package projectjava;

public class Adresse {
    private String numero;
    private String rue;
    private String cp;
    private String ville;
    
    public Adresse(String numero, String rue, String cp, String ville)
    {
        this.setNumero(numero);
        this.setRue(rue);
        this.setCp(cp);
        this.setVille(ville);
    }

    public String getNumero() 
    {
        return numero;
    }
    
    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    public String getRue() 
    {
        return rue;
    }
    
    public void setRue(String rue)
    {
        this.rue = rue;
    }

    public String getCp()
    {
        return cp;
    }

    public void setCp(String cp)
    {
        this.cp = cp;
    }

    public String getVille() 
    {
        return ville;
    }

    public void setVille(String ville)
    {
        this.ville = ville;
    }
    
    public String toString()
    {
        return getNumero()+" "+getRue()+" "+cp+" "+ville;
    }
}
