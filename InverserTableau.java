import java.util.Arrays;

public class InverserTableau {

    // Inverse le tableau SUR PLACE : le tableau de l'appelant est modifié
    static void inverser(int[] t) {
        for (int i = 0; i < t.length / 2; i++) {
            int temp = t[i];
            t[i] = t[t.length - 1 - i];
            t[t.length - 1 - i] = temp;
        }
    }

    // Renvoie un NOUVEAU tableau inversé : le tableau original reste intact
    static int[] inverse(int[] t) {
        int[] resultat = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            resultat[t.length - 1 - i] = t[i];
        }
        return resultat;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println("Tableau de départ     : " + Arrays.toString(a));

        // 1) inverse : crée un nouveau tableau, a ne change pas
        int[] b = inverse(a);
        System.out.println("Après inverse(a)      : a = " + Arrays.toString(a));
        System.out.println("                        b = " + Arrays.toString(b));

        // 2) inverser : modifie a directement
        inverser(a);
        System.out.println("Après inverser(a)     : a = " + Arrays.toString(a));
    }
}