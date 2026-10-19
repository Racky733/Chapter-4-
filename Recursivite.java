public class Recursivite { 
    static long factorielle(int n) { 
        if (n <= 1) return 1;                 // cas de base 
        return n * factorielle(n - 1);        // cas général 
    } 
 
    static int pgcd(int a, int b) {           // algorithme d'Euclide 
        return b == 0 ? a : pgcd(b, a % b); 
    } 
 
    /** Recherche dichotomique récursive dans un tableau trié : indice ou -1. */ 
    static int rechercher(long[] t, long x, int debut, int fin) { 
        if (debut > fin) return -1; 
        int milieu = (debut + fin) >>> 1;     // évite le débordement de (debut + fin) / 2 
        if (t[milieu] == x) return milieu; 
        return t[milieu] < x ? rechercher(t, x, milieu + 1, fin) 
                             : rechercher(t, x, debut, milieu - 1); 
    } 
 
    static long fibonacciNaif(int n) { 
        return n < 2 ? n : fibonacciNaif(n - 1) + fibonacciNaif(n - 2); 
    } 
 
    static long fibonacci(int n) {            // version itérative, linéaire 
        long a = 0, b = 1; 
        for (int i = 0; i < n; i++) { 
            long c = a + b; a = b; b = c; 
        } 
        return a; 
    } 
 
    public static void main(String[] args) { 
        System.out.println("10! = " + factorielle(10)); 
        System.out.println("pgcd(84, 36) = " + pgcd(84, 36)); 
        long[] prix = {500, 1_000, 1_500, 2_500, 7_500, 12_000}; 
        System.out.println("7500 à l'indice " + rechercher(prix, 7_500, 0, prix.length - 1)); 
        System.out.println("3000 à l'indice " + rechercher(prix, 3_000, 0, prix.length - 1)); 
        System.out.println("fib(30) = " + fibonacciNaif(30) + " = " + fibonacci(30)); 
        System.out.println("fib(90) = " + fibonacci(90)); 
    } 
}