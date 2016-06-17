/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package projectjava;


public class EmpruntE {
    public String titre;
    public String s2;
    public String s3;
    public String s4;

    public EmpruntE(String s1,String s2,String s3,String s4)
    {
        this.titre=s1;
        this.s2=s2;
        this.s3=s3;
        this.s4=s4;
    }
    
    public EmpruntE()
    {
        this.titre=null;
        this.s2=null;
        this.s3=null;
        this.s4=null;
    }
    
    public String toString()
    {
        return titre+s2+s3+s4;
    }
    
    public String getTitre()
    {
        return this.titre;
    }
    public String getS2()
    {
        return this.s2;
    }
    public String getS3()
    {
        return this.s3;
    }
    public String getS4()
    {
        return this.s4;
    }
}
