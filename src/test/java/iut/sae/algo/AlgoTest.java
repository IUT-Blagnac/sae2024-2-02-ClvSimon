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
        // Tests supplémentaires
        assertEquals("1!1@1#", Algo.RLE("!@#"));
        assertEquals("2!2@2#", Algo.RLE("!!@@##"));
        
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            input.append("a");
        }
        assertEquals("1000a", Algo.RLE(input.toString()));
        
        assertEquals("12a", Algo.RLE("aaaaaaaaaaaa")); // 12 'a's
    }


    @Test
    public void testUnRLESupplementaire() {
        try {
            // Tests supplémentaires
            assertEquals("!@#", Algo.unRLE("1!1@1#"));
            assertEquals("!!@@##", Algo.unRLE("2!2@2#"));
            
            StringBuilder expected = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                expected.append("a");
            }
            assertEquals(expected.toString(), Algo.unRLE("1000a"));
            
            try {
                Algo.unRLE("a1b2c"); // Invalid format
                fail("Exception expected for invalid RLE format");
            } catch (AlgoException e) {
                // Expected exception
            }
        } catch (AlgoException e) {
            fail("Exception inattendue: " + e.getMessage());
        }
    }


    @Test
    public void testRLERecursifSupplementaire() {
        try {
            // Tests supplémentaires
            assertEquals("1!1@1#", Algo.RLE("!@#", 1));
            assertEquals("2!2@2#", Algo.RLE("!!@@##", 1));
            
            StringBuilder input = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                input.append("a");
            }
            assertEquals("1000a", Algo.RLE(input.toString(), 1));
            
            assertEquals("12a", Algo.RLE("aaaaaaaaaaaa", 1)); // 12 'a's
            
            assertEquals("31a31b31c", Algo.RLE("abc", 3));
        } catch (AlgoException e) {
            fail("Exception inattendue: " + e.getMessage());
        }
    }


    @Test
    public void testUnRLERecursifSupplementaire() {
        try {
            // Tests supplémentaires
            assertEquals("!@#", Algo.unRLE("1!1@1#", 1));
            assertEquals("!!@@##", Algo.unRLE("2!2@2#", 1));
            
            StringBuilder expected = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                expected.append("a");
            }
            assertEquals(expected.toString(), Algo.unRLE("1000a", 1));
            
            try {
                Algo.unRLE("a1b2c", 1); // Invalid format
                fail("Exception expected for invalid RLE format");
            } catch (AlgoException e) {
                // Expected exception
            }
            
            assertEquals("abc", Algo.unRLE("31a31b31c", 3));
        } catch (AlgoException e) {
            fail("Exception inattendue: " + e.getMessage());
        }
    }


    @Test
    public void testJavaUtil() {
        File file = new File("src/iut/sae/algo/Algo.java");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("import java.util")) {
                    fail("Usage of java.util is not allowed.");
                }
            }
        } catch (FileNotFoundException e) {
            fail("Algo.java file not found.");
        }
    }
















}