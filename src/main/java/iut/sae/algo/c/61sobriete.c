#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>



char* RLE(char* text) {
    // on initialise les variables
    char lettre = text[0];
    int longueurTexte = strlen(text);
    char* chaineFinale = (char*)malloc(longueurTexte * 2 + 1);
    int compteurLettre = 0;
    int indexChaineFinale = 0;
    // on regarde chaque caractère du texte
    for (int i = 0; i < longueurTexte; i++) {
        // Si le caractère est le même que le précédent et que le compteur est inférieur à 9
        if (lettre == text[i] && compteurLettre < 9) {
            // on ajoute 1 au compteur
            compteurLettre++;
        } else {
            // on jaoute le compteur et la lettre à la chaîne finale
            sprintf(chaineFinale + indexChaineFinale, "%d%c", compteurLettre, lettre);
            indexChaineFinale += 2; // a chaque fois, nous on ajoute 2 caractères : un nombre et une lettre
            
            compteurLettre = 1;
            
            lettre = text[i];
        }
        // Si le compteur atteint 9 (il faut pas avoir 13w par exemple)
        if (compteurLettre == 9) {
            // on jaoute direct le compteur et la lettre à la chaîne finale
            sprintf(chaineFinale + indexChaineFinale, "%d%c", compteurLettre, lettre);
            indexChaineFinale += 2;
            // si on n'est pas à la fin de la chaîne
            if (i < longueurTexte - 1) {
                
                lettre = text[i + 1];
            }
            
            compteurLettre = 0;
        }
    }
    // si le compteur est supérieur à 0 à la fin de la boucle
    if (compteurLettre > 0) {
        // on ajoute ce qu'il reste a la chaine finale
        sprintf(chaineFinale + indexChaineFinale, "%d%c", compteurLettre, lettre);
    }
    // on alloue la memoire necessaire a chaineFinale
    chaineFinale = realloc(chaineFinale, indexChaineFinale + 1);
    
    return chaineFinale;
}

// fonction encoder de manière récursive
char* RLE_recursif(const char* chaine, int nombre) {
    char* resultat = strdup(chaine);
    char* temp = NULL;
    for (int i = 0; i < nombre; i++) {
        temp = RLE(resultat);
        free(resultat);
        resultat = temp;
    }
    return resultat;
}

char* unRLE(const char* chaine) {
    int length = strlen(chaine);
    char* result = malloc(length * sizeof(char));
    int index = 0;
    for (int i = 0; i < length; i += 2) {
        int nombre = chaine[i] - '0';
        char caractere = chaine[i + 1];
        for (int j = 0; j < nombre; j++) {
            result[index++] = caractere;
        }
    }
    result[index] = '\0';
    return result;
}

char* unRLE_recursif(const char* chaine, int nombre) {
    char* resultat = strdup(chaine);
    for (int i = 0; i < nombre; i++) {
        char* temp = unRLE(resultat);
        free(resultat);
        resultat = temp;
    }
    return resultat;
}



//__________________________________________________________________________________________________________________
#include <assert.h>

// Fonction de test pour RLE
void testRLE() {
    assert(strcmp(RLE(""), "") == 0 && "Erreur: RLE(\"\") != \"\"");
    assert(strcmp(RLE("abc"), "1a1b1c") == 0 && "Erreur: RLE(\"abc\") != \"1a1b1c\"");
    assert(strcmp(RLE("abbccc"), "1a2b3c") == 0 && "Erreur: RLE(\"abbccc\") != \"1a2b3c\"");
    assert(strcmp(RLE("aaabaa"), "3a1b2a") == 0 && "Erreur: RLE(\"aaabaa\") != \"3a1b2a\"");
    assert(strcmp(RLE("aAa"), "1a1A1a") == 0 && "Erreur: RLE(\"aAa\") != \"1a1A1a\"");
    assert(strcmp(RLE("WWWWWWWWWWWWW"), "9W4W") == 0 && "Erreur: RLE(\"WWWWWWWWWWWWW\") != \"9W4W\"");
}


// Fonction de test pour RLE_recursif
void testRLERecursif() {
    assert(strcmp(RLE_recursif("", 1), "") == 0);
    assert(strcmp(RLE_recursif("", 3), "") == 0);
    
    assert(strcmp(RLE_recursif("abc", 1), "1a1b1c") == 0);
    assert(strcmp(RLE_recursif("abbccc", 1), "1a2b3c") == 0);
    assert(strcmp(RLE_recursif("aaabaa", 1), "3a1b2a") == 0);
    assert(strcmp(RLE_recursif("aAa", 1), "1a1A1a") == 0);

    assert(strcmp(RLE_recursif("abc", 2), "111a111b111c") == 0);
    assert(strcmp(RLE_recursif("abc", 3), "311a311b311c") == 0);
}

// Fonction de test pour unRLE
void testUnRLE() {
    assert(strcmp(unRLE(""), "") == 0);
    assert(strcmp(unRLE("1a1b1c"), "abc") == 0);
    assert(strcmp(unRLE("1a2b3c"), "abbccc") == 0);
    assert(strcmp(unRLE("3a1b2a"), "aaabaa") == 0);
    assert(strcmp(unRLE("1a1A1a"), "aAa") == 0);
    assert(strcmp(unRLE("9W4W"), "WWWWWWWWWWWWW") == 0);
}

// Fonction de test pour unRLE_recursif
void testUnRLERecursif() {
    assert(strcmp(unRLE_recursif("", 1), "") == 0);
    assert(strcmp(unRLE_recursif("", 3), "") == 0);
    
    assert(strcmp(unRLE_recursif("1a1b1c", 1), "abc") == 0);
    assert(strcmp(unRLE_recursif("1a2b3c", 1), "abbccc") == 0);
    assert(strcmp(unRLE_recursif("3a1b2a", 1), "aaabaa") == 0);
    assert(strcmp(unRLE_recursif("1a1A1a", 1), "aAa") == 0);

    assert(strcmp(unRLE_recursif("111a111b111c", 2), "abc") == 0);
    assert(strcmp(unRLE_recursif("311a311b311c", 3), "abc") == 0);
}

// Fonction principale main pour tester
int main() {
    testRLE();
    testRLERecursif();
    testUnRLE();
    testUnRLERecursif();
    
    printf("Tests passés avec succès.\n");

}

