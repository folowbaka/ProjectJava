
package projectjava;

public class Projet {

    public static void main(String[] args) {
        Bibliotheque bibli_test=new Bibliotheque();
        String[] hauteur={"Nikudan","param2","param3"};
        Livre livre_test=new Livre("Walid Adventure1",hauteur,"HEN",1,bibli_test);
        Adherent adh_test=new Adherent("1","Nikudan","Roule","azeaze@gmail.com","Grateur",new Adresse("29","rue des grateur","99999","Partout"));
        
        bibli_test.addLivre(livre_test);
        bibli_test.addLivre(new Livre("Walid Adventure2",hauteur,"HEN",1,bibli_test));
        bibli_test.addLivre(new Livre("Walid Adventure3",hauteur,"HEN",1,bibli_test));
        bibli_test.addAdherent(adh_test);
        bibli_test.addAdherent(new Adherent("2","Abdellah","Ghiles","azeaze@gmail.com","Grateur",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent("3","Galente","David","azeaze@gmail.com","Grateur",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent("4","Dieu","Arnaud","azeaze@gmail.com","Grateur",new Adresse("29","rue des grateur","99999","Partout")));
        
        System.out.println(bibli_test.Livre_toString());
        System.out.println(adh_test.toString());
        adh_test.emprunter(livre_test);
        System.out.println(adh_test.toString());
        System.out.println(bibli_test.Livre_toString());
        
        
        for (Adherent elem: bibli_test.get_adherent_alpha())
        {
            System.out.println(elem.toString());
        }
    }  
}
