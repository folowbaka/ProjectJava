
package projectjava;

import static projectjava.Bibliotheque.loadBibliotheque;

public class Projet {

    public static void main(String[] args) {
        Bibliotheque bibli_test=new Bibliotheque();
        String hauteur="Nikudan";
        Livre livre_test=new Livre("Walid Adventure1",hauteur,"HEN",1,bibli_test);
        Adherent adh_test=new Adherent(bibli_test.getID(),"Nikudan","Roule","azeaze@gmail.com","Grateurq",new Adresse("29","rue des grateurq","99999","Partout"));
        
        bibli_test.addLivre(livre_test);
        bibli_test.addLivre(new Livre("Walid Adventure2",hauteur,"HEN",1,bibli_test));
        bibli_test.addLivre(new Livre("Walid Adventure3",hauteur,"HEN",1,bibli_test));
        bibli_test.addAdherent(adh_test);
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Abdellah","Ghiles","azeaze@gmail.com","Bananier",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Galente","David","fsdf@gmail.com","Plombier",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Dieu","Arnaud","xcvxc@gmail.com","Coiffeur",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Boyer","Guyaume","fgdgfdgtr@gmail.com","Sodomite",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Hedili","Abdelsalem","mlkmlk@gmail.com","Pas tres Charlie",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Moustawi","Walid","hjgjg@gmail.com","Malade",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Kissi","Naim","zez@gmail.com","Mediateur",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Koulibay","Amedi","rfds@gmail.com","Salafiste",new Adresse("29","rue des grateur","99999","Partout")));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"fdsfsd","fsfsd","tryr@gmail.com","ezez",new Adresse("29","rue des grateur","99999","Partout")));
        
        System.out.println(bibli_test.Livre_toString());
        System.out.println(adh_test.toString());
        adh_test.emprunter(livre_test);
        System.out.println(adh_test.toString());
        System.out.println(bibli_test.Livre_toString());
        
        System.out.println(bibli_test.saveBibliotheque("src\\ressource\\BDD.txt"));
        
        Bibliotheque bibli_test2=loadBibliotheque("src\\ressource\\BDD.txt");
        System.out.println(bibli_test2.Livre_toString());
    }  
}
