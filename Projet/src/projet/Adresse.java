/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

public class Adresse {
    private String numero;
    private String rue;
    private String cp;
    private String ville;
    
    public void Addresse(String numero, String rue, String cp,String ville)
    {
        this.setNumero(numero);
        this.setRue(rue);
        this.setCp(cp);
        this.setVille(ville);
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    public String toString()
    {
        return numero+rue+cp+ville;
    }
}
