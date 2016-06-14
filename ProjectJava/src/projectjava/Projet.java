
package projectjava;

import static projectjava.Bibliotheque.loadBibliotheque;

public class Projet {

    public static void main(String[] args) {
        Bibliotheque bibli_test=new Bibliotheque();
        String[] hauteur={"Nikudan","param2","param3"};
        Livre livre_test=new Livre("Walid Adventure1",hauteur,"HEN",1,bibli_test);
        Adherent adh_test=new Adherent(bibli_test.getID(),"Nikudan","Roule","azeaze@gmail.com","Grateurq",new Adresse("29","rue des grateurq","99999","Partout"));
        
        bibli_test.addLivre(livre_test);
        bibli_test.addLivre(new Livre("Walid Adventure2",hauteur,"HEN",1,bibli_test));
        bibli_test.addLivre(new Livre("Walid Adventure3",hauteur,"HEN",1,bibli_test));
        bibli_test.addAdherent(adh_test);
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Abdellah","Ghiles","azeaze@gmail.com","Bananier",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Galente","David","azeaze@gmail.com","Plombier",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Dieu","Arnaud","azeaze@gmail.com","Coiffeur",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Boyer","Guyaume","azeaze@gmail.com","Sodomite",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Hedili","Abdelsalem","azeaze@gmail.com","Pas tres Charlie",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Moustawi","Walid","azeaze@gmail.com","Malade",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Kissi","Naim","azeaze@gmail.com","Mediateur",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Koulibay","Amedi","azeaze@gmail.com","Salafiste",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"fdsfsd","fsfsd","azeaze@gmail.com","ezez",new Adresse("29","rue des grateur","99999","Partout")));
        
        System.out.println(bibli_test.Livre_toString());
        System.out.println(adh_test.toString());
        adh_test.emprunter(livre_test);
        System.out.println(adh_test.toString());
        System.out.println(bibli_test.Livre_toString());
        
        
        for (Adherent elem: bibli_test.get_adherent_croissant_id())
        {
            System.out.println(elem.toString());
        }
        
        System.out.println(bibli_test.saveBibliotheque("src\\ressource\\bibliotheque.bdd"));
        
        Bibliotheque bibli_test2=loadBibliotheque("src\\ressource\\bibliotheque.bdd");
        System.out.println(bibli_test2.Livre_toString());
    }  
}
