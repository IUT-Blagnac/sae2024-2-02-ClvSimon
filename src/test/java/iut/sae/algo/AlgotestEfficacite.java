package iut.sae.algo;

public class AlgotestEfficacite {

    // Chaîne de caractères fixe pour les tests
    private static final String FIXED_STRING = "ABBBCCCCDDDDDDEEEEEEEE";

    public static void main(String[] args) {
        int iterations = 40; // Nombre d'itérations pour les méthodes récursives

        // Test de la méthode RLE(String in)
        System.out.println("Testing RLE(String in) method:");
        String data = FIXED_STRING;

        long startTime = System.nanoTime();
        String result = Algo.RLE(data);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Chaîne de caractères: " + data + ", Temps d'exécution: " + duration + " nanosecondes");

        // Test de la méthode RLE(String in, int iteration)
        System.out.println("\nTesting RLE(String in, int iteration) method:");
        try {
            startTime = System.nanoTime();
            result = Algo.RLE(data, iterations);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Chaîne de caractères: " + data + ", Temps d'exécution: " + duration + " nanosecondes");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test de la méthode unRLE(String in)
        System.out.println("\nTesting unRLE(String in) method:");
        String encoded = Algo.RLE(data); // Encodage de la chaîne fixe

        
        try {
            startTime = System.nanoTime();
            result = Algo.unRLE(encoded);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Chaîne de caractères: " + data + ", Temps d'exécution: " + duration + " nanosecondes");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test de la méthode unRLE(String in, int iteration)
        System.out.println("\nTesting unRLE(String in, int iteration) method:");
        try {
            encoded = Algo.RLE(data, iterations); // Encodage de la chaîne fixe avec itérations
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            startTime = System.nanoTime();
            result = Algo.unRLE(encoded, iterations);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Chaîne de caractères: " + data + ", Temps d'exécution: " + duration + " nanosecondes");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
