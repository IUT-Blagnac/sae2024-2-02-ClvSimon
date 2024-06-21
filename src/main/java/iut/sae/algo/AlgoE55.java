package iut.sae.algo;

public class AlgoE55 {

    // Encoder une chaîne avec RLE
    public static String RLE(String in) {
        if (in == null || in.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        char prevChar = in.charAt(0);
        int count = 1;

        for (int i = 1; i < in.length(); i++) {
            char currChar = in.charAt(i);
            if (currChar == prevChar) {
                count++;
                if (count == 10) {  // Séparer le compteur si il dépasse 9
                    result.append(9).append(prevChar);
                    count = 1;
                }
            } else {
                result.append(count).append(prevChar);
                prevChar = currChar;
                count = 1;
            }
        }
        result.append(count).append(prevChar);
        return result.toString();
    }

    // Encodage RLE récursif
    public static String RLE(String in, int iteration) throws AlgoException {
        if (iteration < 1) {
            throw new AlgoException("Le nombre d'itérations doit être supérieur ou égal à 1");
        }
        String result = in;
        for (int i = 0; i < iteration; i++) {
            result = RLE(result);
        }
        return result;
    }

    // Décoder une chaîne avec RLE
    public static String unRLE(String in) throws AlgoException {
        if (in == null || in.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < in.length(); i++) {
            char countChar = in.charAt(i);

            if (!Character.isDigit(countChar)) {
                throw new AlgoException("Format de chaîne RLE invalide");
            }

            int count = Character.getNumericValue(countChar);
            i++;

            if (i >= in.length()) {
                throw new AlgoException("Format de chaîne RLE invalide");
            }

            char letter = in.charAt(i);

            for (int j = 0; j < count; j++) {
                result.append(letter);
            }
        }

        return result.toString();
    }

    // Décodage RLE récursif
    public static String unRLE(String in, int iteration) throws AlgoException {
        if (iteration < 1) {
            throw new AlgoException("Le nombre d'itérations doit être supérieur ou égal à 1");
        }
        String result = in;
        for (int i = 0; i < iteration; i++) {
            result = unRLE(result);
        }
        return result;
    }
}