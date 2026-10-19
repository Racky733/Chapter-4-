public class TableMultiplication { 
    public static void main(String[] args) { 
        // Tableau des prix pour 1 à 5 articles à 1 500 FCFA, avec remise de 5 % à partir de 4 
        for (int qte = 1; qte <= 5; qte++) { 
            long brut = qte * 1_500L; 
            long net = qte >= 4 ? brut * 95 / 100 : brut; 
            System.out.printf("%d article(s) : %5d FCFA%n", qte, net); 
        } 
        // Compte à rebours, pas de 2 
        for (int i = 10; i > 0; i -= 2) { 
            System.out.print(i + " "); 
        } 
        System.out.println("Livraison !"); 
    } 
}