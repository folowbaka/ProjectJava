
package projectjava;

import static projectjava.Bibliotheque.loadBibliotheque;

public class Projet {

    public static void main(String[] args) {
        Bibliotheque bibli_test=new Bibliotheque();
        String hauteur="Nikudan";
        Livre livre_test=new Livre("Walid Adventure1","Cerin","HEN",1,bibli_test);
        Adherent adh_test=new Adherent(bibli_test.getID(),"Nikudan","Roule","azeaze@gmail.com","Grateurq",new Adresse("29","rue des grateurq","99999","Partout"));
        
        //bibli_test.addLivre(livre_test);
        //bibli_test.addLivre(new Livre("Walid Adventure2","Boruto","HEN",1,bibli_test));
        //bibli_test.addAdherent(adh_test);
        //bibli_test.getListAdherent().get(0).emprunterRetard(bibli_test.getListLivre().get(0));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Abdellah","Ghiles","Bananier"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Ben Aissa","Aya","Etudiante"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Boyer","Guillaume","Footballeur"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Capogna","Jeremy","Mafia"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Deliry","Lucas","Calimero"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Djoko","Alex Lionel","2eme Major"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Dieu","Arnaud","Erudit"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Galante","David","UTTiste"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Gandouin","Yolene","Architecte"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Greslin","Kevin","Streamer"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Guilgori","Mehdi","Responsable MZF"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Hedhili","Abdelsalem","Barbier"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Hypolite","Alexandre","Preparateur de commande"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Kissi","Naim","Mediateur"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Moustaoui","Walid","Pilote"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Queinec","Florian","BDE"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Razafinjatouo","Rudy","Absanteiste"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Saada","Dylan","Culturiste"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Thireau","Rudy","Ninja"));
        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Tilouine","Nassim","Imam"));

        bibli_test.addLivre(new Livre("Walid Adventure 1 : Le commancement","Obaka","HEN",bibli_test));
        bibli_test.addLivre(new Livre("Walid Adventure 2 : Le soulevement","Obaka","HEN",bibli_test));
        bibli_test.addLivre(new Livre("Walid Adventure 3 : l'achevement","Obaka","HEN",bibli_test));
        bibli_test.addLivre(new Livre("Nikudan in Love","Team Fan Fic","FIC",bibli_test));
        bibli_test.addLivre(new Livre("Au pays des grateurs","Nikudan","BIO",1,bibli_test));
        bibli_test.addLivre(new Livre("Seul au monde","Nikudan","BIO",1,bibli_test));
        bibli_test.addLivre(new Livre("Alice au pays des merveilles","Pouet","AVT",bibli_test));
        bibli_test.addLivre(new Livre("L'etranger","Albert Camus","FIC",bibli_test));
        bibli_test.addLivre(new Livre("La complexité pour les nuls","Roupin","EDU",bibli_test));
        bibli_test.addLivre(new Livre("L'induction structurel pour les nuls","Guerini","EDU",bibli_test));
        bibli_test.addLivre(new Livre("La maleficence","Pablo","HOR",bibli_test));
        bibli_test.addLivre(new Livre("N+1 byte","Roupin","AVT",bibli_test));
        bibli_test.addLivre(new Livre("Bouteilles de France et d'ailleurs","Grape","SCI",bibli_test));
        bibli_test.addLivre(new Livre("Petit guide du bananeur","Riles","EDU",bibli_test));
        bibli_test.addLivre(new Livre("Formes et couleur","Yolene","ART",bibli_test));
        bibli_test.addLivre(new Livre("Reussire son brushing","Harumix","ART",bibli_test));
        bibli_test.addLivre(new Livre("L'economie des betrave en bolivie","Exaltion","ECO",bibli_test));
        bibli_test.addLivre(new Livre("Travailler seul ou en groupe","David","SCI",bibli_test));
//        
//        bibli_test.addLivre(new Livre("","","",bibli_test));
//        bibli_test.addLivre(new Livre("","","",bibli_test));
        
        



        
        

//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Galante","David","Plombier",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Dieu","Arnaud","Coiffeur",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Boyer","Guyaume","Sodomite",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Hedili","Abdelsalem","Pas tres Charlie",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Moustawi","Walid","Malade",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Kissi","Naim","Mediateur",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Koulibay","Amedi","Salafiste",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"fdsfsd","fsfsd","ezez",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Galente","David","Plombier",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Dieu","Arnaud","Coiffeur",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Boyer","Guyaume","Sodomite",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Hedili","Abdelsalem","Pas tres Charlie",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Moustawi","Walid","Malade",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Kissi","Naim","Mediateur",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Koulibay","Amedi","Salafiste",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"fdsfsd","fsfsd","ezez",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Galente","David","Plombier",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Dieu","Arnaud","adresse1@gmail.com","Coiffeur",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Boyer","Guyaume","adresse1@gmail.com","Sodomite",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Hedili","Abdelsalem","adresse1@gmail.com","Pas tres Charlie",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Moustawi","Walid","adresse1@gmail.com","Malade",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Kissi","Naim","adresse1@gmail.com","Mediateur",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Koulibay","Amedi","adresse1@gmail.com","Salafiste",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"fdsfsd","fsfsd","adresse1@gmail.com","ezez",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Galente","David","adresse1@gmail.com","Plombier",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Dieu","Arnaud","adresse1@gmail.com","Coiffeur",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Boyer","Guyaume","adresse1@gmail.com","Sodomite",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Hedili","Abdelsalem","adresse1@gmail.com","Pas tres Charlie",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Moustawi","Walid","adresse1@gmail.com","Malade",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Kissi","Naim","adresse1@gmail.com","Mediateur",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"Koulibay","Amedi","adresse1@gmail.com","Salafiste",new Adresse("29","rue des grateur","99999","Partout")));
//        bibli_test.addAdherent(new Adherent(bibli_test.getID(),"fdsfsd","fsfsd","adresse1@gmail.com","ezez",new Adresse("29","rue des grateur","99999","Partout")));
        
        System.out.println(bibli_test.Livre_toString());
        System.out.println(adh_test.toString());
        //adh_test.emprunter(livre_test);
        System.out.println(adh_test.toString());
        System.out.println(bibli_test.Livre_toString());
        
        System.out.println(bibli_test.saveBibliotheque("src\\ressource\\BDD.txt"));
        
        Bibliotheque bibli_test2=loadBibliotheque("src\\ressource\\BDD.txt");
        System.out.println(bibli_test2.Livre_toString());
    }  
}
