/**
 *
 * @author ABDELLAH Ghiles, DIEU Arnaud, GALENTE David
 */
package projectjava;


class Perso {
public static String toTitleCase(String input) {
    input = input.toLowerCase();
    char c =  input.charAt(0);
    String s = new String("" + c);
    String f = s.toUpperCase();
    return f + input.substring(1);
}
}
