public class TableauDeBord {

    // Switch expression : nom du jour en français (0 = Lundi ... 6 = Dimanche)
    static String nomJour(int i) {
        return switch (i) {
            case 0 -> "Lundi";
            case 1 -> "Mardi";
            case 2 -> "Mercredi";
            case 3 -> "Jeudi";
            case 4 -> "Vendredi";
            case 5 -> "Samedi";
            case 6 -> "Dimanche";
            default -> "Inconnu";
        };
    }

    // Chiffre d'affaires de chaque jour : somme de (unités vendues x prix) sur les produits
    static long[] chiffreAffairesParJour(int[][] ventes, long[] prix) {
        long[] ca = new long[ventes.length];
        for (int j = 0; j < ventes.length; j++) {
            for (int p = 0; p < prix.length; p++) {
                ca[j] += ventes[j][p] * prix[p];
            }
        }
        return ca;
    }

    // Nombre total d'unités vendues pour chaque produit sur la semaine
    static int[] unitesParProduit(int[][] ventes) {
        int nbProduits = ventes[0].length;
        int[] unites = new int[nbProduits];
        for (int[] jour : ventes) {
            for (int p = 0; p < nbProduits; p++) {
                unites[p] += jour[p];
            }
        }
        return unites;
    }

    // Indice du produit qui a rapporté le plus d'argent sur la semaine
    static int produitTop(int[] unites, long[] prix) {
        int meilleur = 0;
        long meilleurCA = unites[0] * prix[0];
        for (int p = 1; p < prix.length; p++) {
            long ca = unites[p] * prix[p];
            if (ca > meilleurCA) {
                meilleurCA = ca;
                meilleur = p;
            }
        }
        return meilleur;
    }

    // Indice du jour qui a le plus grand chiffre d'affaires
    static int jourRecord(long[] caParJour) {
        int meilleur = 0;
        for (int j = 1; j < caParJour.length; j++) {
            if (caParJour[j] > caParJour[meilleur]) {
                meilleur = j;
            }
        }
        return meilleur;
    }

    public static void main(String[] args) {
        String[] produits = {"Produit 1", "Produit 2", "Produit 3", "Produit 4"};
        long[] prix = {1500, 2500, 800, 5000};

        // ventes[jour][produit]
        int[][] ventes = {
            {12,  5,  8,  3},   // Lundi
            {15,  7,  6,  4},   // Mardi
            {10,  9, 12,  2},   // Mercredi
            {20,  6,  9,  5},   // Jeudi
            {25, 12, 15,  8},   // Vendredi
            {30, 15, 20, 10},   // Samedi
            { 8,  4,  5,  1}    // Dimanche
        };

        long[] caParJour = chiffreAffairesParJour(ventes, prix);
        int[] unites = unitesParProduit(ventes);

        // En-tête
        System.out.printf("%-10s", "Jour");
        for (String nom : produits) {
            System.out.printf("%10s", nom);
        }
        System.out.printf("%16s%n", "CA (FCFA)");
        System.out.println("-".repeat(10 + 10 * produits.length + 16));

        // Une ligne par jour
        for (int j = 0; j < ventes.length; j++) {
            System.out.printf("%-10s", nomJour(j));
            for (int p = 0; p < produits.length; p++) {
                System.out.printf("%10d", ventes[j][p]);
            }
            System.out.printf("%16d%n", caParJour[j]);
        }

        // Ligne des totaux
        System.out.println("-".repeat(10 + 10 * produits.length + 16));
        long totalSemaine = 0;
        for (long ca : caParJour) {
            totalSemaine += ca;
        }
        System.out.printf("%-10s", "Total");
        for (int p = 0; p < produits.length; p++) {
            System.out.printf("%10d", unites[p]);
        }
        System.out.printf("%16d%n%n", totalSemaine);

        // Produit le plus rentable et jour record
        int top = produitTop(unites, prix);
        int record = jourRecord(caParJour);
        System.out.printf("Produit le plus rentable : %s (%d FCFA)%n", produits[top], unites[top] * prix[top]);
        System.out.printf("Jour record : %s (%d FCFA)%n", nomJour(record), caParJour[record]);
    }
}