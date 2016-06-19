/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 * Formats personnels pour la gestion des chaines de caractere
 */
package projectjava;

class Perso {
    
public static String toTitleCase(String input) 
    {
        input = input.toLowerCase();
        char c =  input.charAt(0);
        String s = new String("" + c);
        String f = s.toUpperCase();
        return f + input.substring(1);
    }

public static String intToFormat(int valeur) 
    {
        if(valeur<10)
            return "00"+String.valueOf(valeur);
        if(valeur<100)
            return "0"+String.valueOf(valeur);
        return String.valueOf(valeur);
    }

}