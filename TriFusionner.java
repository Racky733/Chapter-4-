import java.util.Arrays;

public class TriFusionner {

    // Fusionne deux tableaux triés (ordre croissant) en un seul tableau trié
    static int[] fusionner(int[] a, int[] b) {
        int[] resultat = new int[a.length + b.length];
        int i = 0;   // position dans a
        int j = 0;   // position dans b
        int k = 0;   // position dans resultat

        // 1) Tant qu'il reste des éléments dans les DEUX tableaux :
        //    on copie le plus petit des deux éléments courants
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                resultat[k] = a[i];
                i++;
            } else {
                resultat[k] = b[j];
                j++;
            }
            k++;
        }

        // 2) Un des deux tableaux est épuisé : on recopie le reste de l'autre
        while (i < a.length) {
            resultat[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            resultat[k] = b[j];
            j++;
            k++;
        }

        return resultat;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 9};
        int[] b = {2, 3, 10, 12};
        System.out.println(Arrays.toString(fusionner(a, b)));
        // [1, 2, 3, 4, 9, 10, 12]

        // Cas particuliers
        System.out.println(Arrays.toString(fusionner(new int[]{}, b)));
        System.out.println(Arrays.toString(fusionner(a, new int[]{})));
        System.out.println(Arrays.toString(fusionner(new int[]{1, 1, 5}, new int[]{1, 2})));
    }
}