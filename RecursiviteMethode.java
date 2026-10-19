public class RecursiviteMethode {

    // Somme des chiffres de n (n >= 0). Ex : 2026 -> 2 + 0 + 2 + 6 = 10
    static int sommeChiffres(int n) {
        if (n < 10) {                            // cas de base : un seul chiffre
            return n;
        }
        return n % 10 + sommeChiffres(n / 10);   // dernier chiffre + somme du reste
    }

    // x puissance n par exponentiation rapide (n >= 0)
    static long puissance(long x, int n) {
        if (n == 0) {                            // cas de base : x^0 = 1
            return 1;
        }
        long moitie = puissance(x, n / 2);       // calculé UNE seule fois
        if (n % 2 == 0) {
            return moitie * moitie;              // x^n = (x^(n/2))^2
        } else {
            return moitie * moitie * x;          // x^n = x * (x^(n/2))^2
        }
    }

    // Vrai si s se lit pareil dans les deux sens
    static boolean estPalindrome(String s) {
        if (s.length() <= 1) {                   // cas de base : vide ou 1 caractère
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;                        // premier et dernier différents
        }
        // On enlève le premier et le dernier caractère, et on recommence
        return estPalindrome(s.substring(1, s.length() - 1));
    }

    // Affiche n (n >= 0) en binaire
    static void afficherBinaire(int n) {
        if (n < 2) {                             // cas de base : 0 ou 1
            System.out.print(n);
            return;
        }
        afficherBinaire(n / 2);                  // d'abord les chiffres de poids fort
        System.out.print(n % 2);                 // puis le dernier bit
    }

    public static void main(String[] args) {
        System.out.println("sommeChiffres(2026) = " + sommeChiffres(2026));
        System.out.println("sommeChiffres(7)    = " + sommeChiffres(7));

        System.out.println("puissance(2, 10) = " + puissance(2, 10));
        System.out.println("puissance(3, 5)  = " + puissance(3, 5));
        System.out.println("puissance(5, 0)  = " + puissance(5, 0));

        System.out.println("estPalindrome(\"radar\") = " + estPalindrome("radar"));
        System.out.println("estPalindrome(\"kayak\") = " + estPalindrome("kayak"));
        System.out.println("estPalindrome(\"java\")  = " + estPalindrome("java"));

        System.out.print("afficherBinaire(10) = ");
        afficherBinaire(10);
        System.out.println();
        System.out.print("afficherBinaire(37) = ");
        afficherBinaire(37);
        System.out.println();
    }
}