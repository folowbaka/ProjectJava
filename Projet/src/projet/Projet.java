
package projet;

/**
 *
 * @author Ghiles
 */
public class Projet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bibliotheque bibli_test=new Bibliotheque();
        String[] hauteur={"Nikudan","param2","param3"};
        Livre livre_test=new Livre("Walid Adventure1",hauteur,"HEN",1,bibli_test);
        bibli_test.addLivre(livre_test);
        bibli_test.addLivre(new Livre("Walid Adventure2",hauteur,"HEN",1,bibli_test));
        bibli_test.addLivre(new Livre("Walid Adventure3",hauteur,"HEN",1,bibli_test));

        System.out.println(bibli_test.Livre_toString());
    }
    
}
