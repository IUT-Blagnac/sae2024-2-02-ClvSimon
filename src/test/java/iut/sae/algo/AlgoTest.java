package iut.sae.algo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;
import junit.framework.TestCase;


public class AlgoTest extends TestCase{

/*
 * RLE("")=""
 * RLE("abc")="1a1b1c"
 * RLE("abbccc")="1a2b3c"
 * RLE("aaabaa")="3a1b2a"
 * RLE("aAa")="1a1A1a"
 */
   @Test
   public void testRLE(){
      assertEquals("", Algo.RLE("") );
      
      assertEquals("1a1b1c", Algo.RLE("abc"));
      assertEquals("1a2b3c", Algo.RLE("abbccc"));
      assertEquals("3a1b2a", Algo.RLE("aaabaa"));
      assertEquals("1a1A1a", Algo.RLE("aAa"));
      assertEquals("9W4W", Algo.RLE("WWWWWWWWWWWWW"));

   }


   /*
   * RLE(str, 1)=RLE(str)
   * RLE(str, 3)=RLE(RLE(RLE(str)))
   */
   @Test
   public void testRLERecursif(){
      try{
         assertEquals("", Algo.RLE("", 1));
         assertEquals("", Algo.RLE("", 3));
         
         assertEquals("1a1b1c", Algo.RLE("abc", 1));
         assertEquals("1a2b3c", Algo.RLE("abbccc", 1));
         assertEquals("3a1b2a", Algo.RLE("aaabaa", 1));
         assertEquals("1a1A1a", Algo.RLE("aAa", 1));

         assertEquals("111a111b111c", (Algo.RLE("abc", 2)));
         assertEquals("311a311b311c", (Algo.RLE("abc", 3)));

         String saeIte20="1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211S1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211A1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211E1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211 1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211A1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211l1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211g1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211o";
         assertEquals(saeIte20, Algo.RLE("SAE Algo", 20));
      }
      catch(Exception e){
         fail("Exception inatendue");
      }
   }

   /*
  * unRLE(RLE(str))=str
  *
  * unRLE("")=""
  * unRLE("1a1b1c")="abc"
  * unRLE("1a2b3c")="abbccc"
  * unRLE("3a1b2a")="aaabaa"
  * unRLE("1a1A1a")="aAa"
  */

   @Test
   public void testUnRLE(){
      try{
         assertEquals("", Algo.unRLE(""));
         assertEquals("abc", Algo.unRLE("1a1b1c"));
         assertEquals("abbccc", Algo.unRLE("1a2b3c"));
         assertEquals("aaabaa", Algo.unRLE("3a1b2a"));
         assertEquals("aAa", Algo.unRLE("1a1A1a"));
         assertEquals("WWWWWWWWWWWWW", Algo.unRLE("9W4W"));
      }
      catch(Exception e){
         fail("Exception inatendue");
      }
   }
   
   @Test
   public void testUnRLERecursif(){
      try{
         assertEquals("", Algo.unRLE("", 1));
         assertEquals("", Algo.unRLE("", 3));
         
         assertEquals("abc", Algo.unRLE("1a1b1c", 1));
         assertEquals("abbccc", Algo.unRLE("1a2b3c", 1));
         assertEquals("aaabaa", Algo.unRLE("3a1b2a", 1));
         assertEquals("aAa", Algo.unRLE("1a1A1a", 1));

         assertEquals("abc", (Algo.unRLE("111a111b111c", 2)));
         assertEquals("abc", (Algo.unRLE("311a311b311c", 3)));
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }

// algo des tests supplémentaire : 



@Test
      public void testRLESupplementaire() {
        // Teste la méthode RLE avec des cas supplémentaires
        
        // Cas de base
        assertEquals("1!1@1#", Algo.RLE("!@#"));
        
        // Cas avec répétition
        assertEquals("2!2@2#", Algo.RLE("!!@@##"));
        
        // Cas avec une chaîne longue de 'a' (1000 'a's)
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            input.append("a");
        }
        // Limite la répétition à 9
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < 111; i++) {
            expected.append("9a");
        }
        expected.append("1a");
        assertEquals(expected.toString(), Algo.RLE(input.toString()));
        
        // Cas avec une séquence spécifique
        assertEquals("9a3a", Algo.RLE("aaaaaaaaaaaa")); // 12 'a's
    }


    @Test
    public void testRLERecursifSupplementaire() {
        try {
            // Teste la méthode RLE récursive avec des cas supplémentaires
            
            // Cas de base
            assertEquals("1!1@1#", Algo.RLE("!@#", 1));
            
            // Cas avec répétition
            assertEquals("2!2@2#", Algo.RLE("!!@@##", 1));
            
            // Cas avec une chaîne longue de 'a' (1000 'a's)
            StringBuilder input = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                input.append("a");
            }
            // Limite la répétition à 9
            StringBuilder expected = new StringBuilder();
            for (int i = 0; i < 111; i++) {
                expected.append("9a");
            }
            expected.append("1a");
            assertEquals(expected.toString(), Algo.RLE(input.toString(), 1));
            
            // Cas avec une séquence spécifique
            assertEquals("9a3a", Algo.RLE("aaaaaaaaaaaa", 1)); // 12 'a's
            
            // Cas avec une récursion plus profonde
            assertEquals("311a311b311c", Algo.RLE("abc", 3));
        } catch (AlgoException e) {
            fail("Exception inattendue: " + e.getMessage());
        }
    }


    @Test
    public void testUnRLESupplementaire() {
        try {
            // Teste la méthode unRLE avec des cas supplémentaires
            
            // Cas de base
            assertEquals("!@#", Algo.unRLE("1!1@1#"));
            
            // Cas avec répétition
            assertEquals("!!@@##", Algo.unRLE("2!2@2#"));
            
            // Cas avec une chaîne longue de 'a' (1000 'a's)
            StringBuilder expected = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                expected.append("a");
            }
            // Construire l'entrée RLE correspondante
            StringBuilder input = new StringBuilder();
            for (int i = 0; i < 111; i++) {
                input.append("9a");
            }
            input.append("1a");
            assertEquals(expected.toString(), Algo.unRLE(input.toString()));
            
            // Cas avec une séquence spécifique
            assertEquals("9a3a", Algo.RLE("aaaaaaaaaaaa")); // 12 'a's
            
            // Cas avec une récursion plus profonde
            assertEquals("311a311b311c", Algo.RLE("abc", 3));
        } catch (AlgoException e) {
            fail("Exception inattendue: " + e.getMessage());
        }
    }


    @Test
    public void testUnRLERecursifSupplementaire() {
        try {
            // Teste la méthode unRLE récursive avec des cas supplémentaires
            
            // Cas de base
            assertEquals("!@#", Algo.unRLE("1!1@1#", 1));
            
            // Cas avec répétition
            assertEquals("!!@@##", Algo.unRLE("2!2@2#", 1));
            
            // Cas avec une chaîne longue de 'a' (1000 'a's)
            StringBuilder expected = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                expected.append("a");
            }
            // Construire l'entrée RLE correspondante
            StringBuilder input = new StringBuilder();
            for (int i = 0; i < 111; i++) {
                input.append("9a");
            }
            input.append("1a");
            assertEquals(expected.toString(), Algo.unRLE(input.toString(), 1));
            
            // Cas avec une séquence spécifique
            assertEquals("aaaaaaaaaaaa", Algo.unRLE("9a3a", 1)); // 12 'a's
            
            // Cas avec une récursion plus profonde
            assertEquals("abc", Algo.unRLE("311a311b311c", 3));
        } catch (AlgoException e) {
            fail("Exception inattendue: " + e.getMessage());
        }
    }
    


    @Test
    public void testJavaUtil() {
        File file = new File("src/main/java/iut/sae/algo/Algo.java");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("import java.util")) {
                    fail("L'utilisation de java.util n'est pas autorisée.");
                }
            }
        } catch (FileNotFoundException e) {
            fail("Fichier Algo.java non trouvé.");
        }
    }









}