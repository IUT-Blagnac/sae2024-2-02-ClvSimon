package iut.sae.algo;

public class Algo{
    
    public static String RLE(String in){
       
        //On vérifie si la chaine en entrée est vide
        if (in == "" ){
            return "";
        }

        String chaine ="";                           //Chaine dans laquelle le resultat sera concaténé
        char caracCompare = in.charAt(0);      //Premier caractère qui sera comparé
        int compteurDeCarac = 1;                     //Compteur du nombre de répétition d'un caractère

        
       //On commence à parcourir la chaine en partant du deuxieme caractère
        for (int i = 1; i < in.length(); i++) {
           
            //Si deux caractère consécutifs sont identiques alors on incrémente le compteur
            if (in.charAt(i) == caracCompare) {
                compteurDeCarac++;
                
                //Si le compteur dépasse 9, on ajoute "9" suivi du caractère dans la chaine
                if (compteurDeCarac == 10) {
                    chaine += "9" + caracCompare;
                    compteurDeCarac = 1;
                }
            } else {
                
                //Si le caractère suivant est différent alors on ajoute dans la chaine le compteur + le caractère
                chaine += compteurDeCarac + "" + caracCompare;
                caracCompare = in.charAt(i); //On met à jour le caractère comparé
                compteurDeCarac = 1; //On reinitialise le compteur
            }
        }
    
        chaine += compteurDeCarac + "" + caracCompare;
        
        return chaine;

        
       
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        String chaine =in;
        for (int i = 0; i< iteration;i++){
            chaine = RLE(chaine);

        }
        return chaine;
    }

    public static String unRLE(String in) throws AlgoException{
        //On vérifie si la chaine en entrée est vide
        if (in == "" ){
            return "";
        }

        String chaine =""; //Chaine dans laquelle le resultat sera concaténé

        //On parcourt la chaine par pas de 2
        for (int i = 0; i<in.length(); i+=2){
            int compteurDeCarac = Character.getNumericValue(in.charAt(i)); //On récupère le nombre de répétitions
            char caracCompare = in.charAt(i+1);                            //On récupère le caractère
            
            //On ajoute le caractère le nombre de fois qu'il a été répété
            for (int j =0; j<compteurDeCarac;j++){
                chaine += caracCompare;

            }
                

        }
        return chaine;

    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        String chaine =in;
        for (int i = 0; i< iteration;i++){
            chaine = unRLE(chaine);

        }
        return chaine;
    }


    
}

