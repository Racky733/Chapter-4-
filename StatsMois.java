import java.util.Arrays;

public class StatsMois { 
    static long somme(long[] t) { 
        long s = 0; 
        for (long v : t) s += v; 
        return s; 
    } 
    static int indiceMax(long[] t) { 
        int iMax = 0; 
        for (int i = 1; i < t.length; i++) { 
            if (t[i] > t[iMax]) iMax = i; 
        } 
        return iMax; 
    } 
    static long mediane(long[] t) { 
        long[] trie = Arrays.copyOf(t, t.length);   // on ne modifie pas l'original 
        Arrays.sort(trie); 
        int n = trie.length; 
        return n % 2 == 1 ? trie[n / 2] : (trie[n / 2 - 1] + trie[n / 2]) / 2; 
    } 
 
    public static void main(String[] args) { 
        // chiffre d'affaires quotidien (FCFA) sur 10 jours 
        long[] ca = {85_000, 120_500, 64_000, 210_000, 99_500, 45_000, 180_000, 
                132_000, 77_500, 150_000}; 
        long total = somme(ca); 
        System.out.println("Total       : " + total + " FCFA"); 
        System.out.println("Moyenne     : " + total / ca.length + " FCFA/jour"); 
        System.out.println("Médiane     : " + mediane(ca) + " FCFA"); 
        int j = indiceMax(ca); 
        System.out.println("Meilleur jour : jour " + (j + 1) + " avec " + ca[j] + " FCFA"); 
        int joursObjectif = 0; 
        for (long v : ca) if (v >= 100_000) joursObjectif++; 
        System.out.println("Jours >= 100 000 FCFA : " + joursObjectif); 
    } 
}