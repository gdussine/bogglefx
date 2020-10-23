package sample;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionnaire {
    private static Dictionnaire instance = new Dictionnaire("dico.txt") ;
    private ArrayList<String> dico ;

    /**
     * Créer un dictionnaire sur la base d'un fichier texte
     * @param s nom de fichier
     */
    private  Dictionnaire(String s) {
        this.dico = new ArrayList<String>(4000) ;
        InputStream file = getClass().getResourceAsStream(s);
        System.out.println(file);
        Scanner sc = new Scanner(file);
        while (sc.hasNext())
                    this.dico.add(sc.next());
    }

    /**
     * @return dictionnaire de la langue française
     */
    public static Dictionnaire getInstance() {
        return instance ;
    }

    /**
     * @param s
     * @return vrai si le mot s est dans le dictionnaire
     */
    public boolean contient(String s) {
        return dico.contains(s.toLowerCase()) ;
    }

    public static void main(String[] args) {
        Dictionnaire dico = Dictionnaire.getInstance();
        assert (dico.contient("pingouin")) ;
        assert (dico.contient("ours")) ;
        assert (dico.contient("Pyjama")) ;
        assert (!dico.contient("osdfsDFurs")) ;

    }
}

