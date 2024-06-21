package iut.sae.algo;


public class AlgoE65 {

// unRLE

    public static String unRLE(String texte) {
        String decompresse = "";
        int taille = texte.length();
        int i = 0;

        while (i < taille) {
            char caractere = texte.charAt(i);

            if (Character.isDigit(caractere)) {
                int qtt = Character.getNumericValue(caractere);
                char nextCaractere = texte.charAt(++i);
                int compte = 0;
                while (compte < qtt) {
                    decompresse += nextCaractere;
                    compte++;
                }
            } else {
                decompresse += caractere;
            }
            i++;
        }
        return decompresse;
    }

    public static String unRLE(String texteCompresse, int i) {
        String result = texteCompresse;
        while (i-- > 0) {
            result = unRLE(result);
        }
        return result;
    }


// RLE

    public static String RLE(String texte) {
        String compresse = "";
        int i = 1;
        int index = 1;
        char caractere = texte.charAt(0);

        if (texte.isEmpty()) {
            return "";
        }
        while (index < texte.length()) {
            if (texte.charAt(index) == caractere) {
                i++;
                if (i == 9) {
                    compresse += i + String.valueOf(caractere);
                    i = 0;
                }
            } else {
                if (i > 0) {
                    compresse += i + String.valueOf(caractere);
                }
                caractere = texte.charAt(index);
                i = 1;
            }
            index++;
        }
        if (i > 0) {
            compresse += i + String.valueOf(caractere);
        }
        return compresse;
    }

    public static String RLE(String texte, int i) {
        String result = texte;
        while (i-- > 0) {
            result = RLE(result);
        }
        return result;
    }
}