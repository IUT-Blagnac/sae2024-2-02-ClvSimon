package iut.sae.algo;

public class AlgoE20{

    /*
     * retourne une chaine de caractere modifié en suivant l'algorithme RLE
     * @param in La chaine de caractere a modifier
     * 
     * @return La chaine modifié par l'algorithme
     */
    public static String RLE(String in){
        if (in.length() == 0) {
            return "";
        }
        StringBuilder s = new StringBuilder("");
        int j=0;
        int i=0;
        while (i+1<in.length()) {
            i++;
            if (in.charAt(i) != in.charAt(j) || i-j>=9) {
                s.append(i-j);
                s.append(Character.toString(in.charAt(j)));
                j=i;    
            }
        }
        s.append(Integer.toString(i+1-j)+Character.toString(in.charAt(j)));
        return s.toString();
    }

    /*
     * retourne une chaine de caractere modifié en suivant l'algorithme RLE
     * 
     * @param in La chaine de caractere a modifier
     * @param iteration nombre de fois que la methode dois se repeter
     * 
     * @return La chaine modifié par l'algorithme recursivement
     */
    public static String RLE(String in, int iteration) throws AlgoException{
        if (in.length() == 0) {
            return "";
        }
        StringBuilder s = new StringBuilder("");
        int j=0;
        int i=0;
        while (i+1<in.length()) {
            i++;
            if (in.charAt(i) != in.charAt(j) || i-j>=9) {
                s.append(i-j);
                s.append(Character.toString(in.charAt(j)));
                j=i;    
            }
        }
        s.append(Integer.toString(i+1-j)+Character.toString(in.charAt(j)));
        if (iteration == 1) {
            return s.toString();
        }
        return RLE(s.toString(), iteration-1);
    }

    /*
     * retourne une chaine de caractere modifié en suivant l'algorithme RLE a l'envers
     * 
     * @param in La chaine de caractere a modifier
     * 
     * @return La chaine modifié par l'algorithme 
     */
    public static String unRLE(String in) throws AlgoException{
        StringBuilder s = new StringBuilder("");
        for (int i=0; i<in.length(); i+=2) {
            int n = in.charAt(i) - '0';
            char c = in.charAt(i+1);
            for (int j=0; j<n; j++) {
                s.append(c);
            }
        }
        return s.toString();
    }

    /*
     * retourne une chaine de caractere modifié en suivant l'algorithme RLE a l'envers
     * 
     * @param in La chaine de caractere a modifier
     * @param iteration nombre de fois que la methode doit se repeter
     * 
     * @return La chaine modifié par l'algorithme recursivement
     */
    public static String unRLE(String in, int iteration) throws AlgoException{
        StringBuilder s = new StringBuilder("");
        for (int i=0; i<in.length(); i+=2) {
            int n = in.charAt(i) - '0';
            char c = in.charAt(i+1);
            for (int j=0; j<n; j++) {
                s.append(c);
            }
        }
        if (iteration == 1) {
            return s.toString();
        }
        return unRLE(s.toString(), iteration-1);
    }
    
}


