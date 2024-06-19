package iut.sae.algo;


public class AlgoS40{
    public static String RLE(String in){
        // Provide your algo here
        if (in == null || in.length() == 0) {
            return "" ;
        }
        StringBuilder rle = new StringBuilder() ; 
        char[] tab = in.toCharArray() ;
        int cpt = 1 ;
        int i = 0 ;
        while (i < in.length() - 1) {
            if (tab[i] == tab[i + 1]) {
                cpt++ ; 
                if (cpt == 10) {
                    rle.append(9) ; 
                    rle.append(tab[i]) ; 
                    cpt = 1 ;
                }
            } else {
                rle.append(cpt).append(tab[i]) ;
                cpt = 1 ;
            } 
           i++ ; 
        } 
        rle.append(cpt).append(tab[i]) ; 
        return rle.toString();
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        // Provide your algo here
        String rle = in ; 
        for (int i = 0 ; i < iteration ; i++) {
            rle = RLE(rle) ; 
        }
        return rle ;
    }

    public static String unRLE(String in) throws AlgoException{
        // Provide your algo here
        StringBuilder rle = new StringBuilder() ; 
        int cpt ; 
        int i = 0 ;
        while( i < in.length()) {
            if(Character.isDigit(in.charAt(i))) {
                cpt = Character.getNumericValue(in.charAt(i)) ;
                i++ ;
                for (int j = 0 ; j < cpt ; j++) {
                    rle.append(in.charAt(i)) ;
                }
                i++ ; 
            } else {
                rle.append(in.charAt(i)) ; 
                i++ ;
            }
        }
        return rle.toString() ;
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        // Provide your algo here
        String rle = in ; 
        for (int i = 0 ; i < iteration ; i++) {
            rle = unRLE(rle) ; 
        }
        return rle ;
    }

    /** 
    public static String unRLE2(String in) throws AlgoException{
        // Provide your algo here
        StringBuffer rle = new StringBuffer() ; 
        int cpt ; 
         char[] tab = in.toCharArray() ;
        for (int i = 0 ; i < in.length() ; i++) {
            if(in.charAt(tab[i])) {
                cpt = in.charAt(tab[i]) ;
                while (cpt-- != 1) {
                    rle.append(tab[i-1]) ;
                } 
            } else {
                rle.append(tab[i]) ; 
            }
        }
        return rle.toString() ;
    }
    */

}


