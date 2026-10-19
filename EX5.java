import java.util.Scanner;

public class EX5 {

    // Retourne le plus petit élément du tableau
    static int min(int[] t) {
        int resultat = t[0];
        for (int valeur : t) {
            if (valeur < resultat) {
                resultat = valeur;
            }
        }
        return resultat;
    }

    // Retourne le plus grand élément du tableau
    static int max(int[] t) {
        int resultat = t[0];
        for (int valeur : t) {
            if (valeur > resultat) {
                resultat = valeur;
            }
        }
        return resultat;
    }

    // Retourne la moyenne des éléments du tableau
    static double moyenne(int[] t) {
        long somme = 0;
        for (int valeur : t) {
            somme += valeur;
        }
        return (double) somme / t.length;
    }

    // Compte les valeurs strictement supérieures à la moyenne
    static int compterSuperieurs(int[] t, double moy) {
        int compteur = 0;
        for (int valeur : t) {
            if (valeur > moy) {
                compteur++;
            }
        }
        return compteur;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre de valeurs n : ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("n doit être supérieur à 0.");
            scanner.close();
            return;
        }

        int[] valeurs = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Valeur " + (i + 1) + " : ");
            valeurs[i] = scanner.nextInt();
        }

        double moy = moyenne(valeurs);

        System.out.println("Minimum : " + min(valeurs));
        System.out.println("Maximum : " + max(valeurs));
        System.out.printf("Moyenne : %.2f%n", moy);
        System.out.println("Valeurs supérieures à la moyenne : " + compterSuperieurs(valeurs, moy));

        scanner.close();
    }
}