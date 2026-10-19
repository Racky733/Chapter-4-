public class Tarification { 
    static long prix(long unitaire, int quantite) { 
        return unitaire * quantite; 
    } 
    static long prix(long unitaire, int quantite, int remisePourcent) {   // surcharge 
        return prix(unitaire, quantite) * (100 - remisePourcent) / 100; 
    } 
    static long total(long... montants) {                                   // varargs 
        long somme = 0; 
        for (long m : montants) somme += m; 
        return somme; 
    } 
 
    public static void main(String[] args) { 
        System.out.println(prix(1_500, 3)); 
        System.out.println(prix(1_500, 3, 10)); 
        System.out.println(total()); 
        System.out.println(total(4_500, 2_000, 7_500)); 
        long[] panier = {1_000, 1_000, 3_000}; 
        System.out.println(total(panier));       // on peut aussi passer un tableau 
    } 
}