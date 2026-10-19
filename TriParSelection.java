import java.util.Arrays;
import java.util.Random;

public class TriParSelection {

    // Tri par sélection : trie le tableau sur place et renvoie le nombre de comparaisons
    static long triSelection(long[] t) {
        long comparaisons = 0;

        for (int i = 0; i < t.length - 1; i++) {
            // On cherche le plus petit élément dans la partie non triée t[i..fin]
            int indexMin = i;
            for (int j = i + 1; j < t.length; j++) {
                comparaisons++;                  // une comparaison de plus
                if (t[j] < t[indexMin]) {
                    indexMin = j;
                }
            }
            // On le place à la position i (échange)
            long temp = t[i];
            t[i] = t[indexMin];
            t[indexMin] = temp;
        }

        return comparaisons;
    }

    public static void main(String[] args) {
        Random hasard = new Random(42);          // graine fixe : résultats reproductibles
        int[] tailles = {10, 100, 1000};

        for (int n : tailles) {
            // Tableau aléatoire
            long[] original = new long[n];
            for (int i = 0; i < n; i++) {
                original[i] = hasard.nextInt(10_000);
            }

            // Deux copies indépendantes : une pour chaque tri
            long[] copie1 = Arrays.copyOf(original, n);
            long[] copie2 = Arrays.copyOf(original, n);

            long comparaisons = triSelection(copie1);
            Arrays.sort(copie2);

            System.out.printf("n = %4d | comparaisons = %7d | n(n-1)/2 = %7d | même résultat qu'Arrays.sort : %b%n",
                    n, comparaisons, (long) n * (n - 1) / 2, Arrays.equals(copie1, copie2));
        }
    }
}