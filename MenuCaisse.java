import java.util.Scanner; 
 
public class MenuCaisse { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        long total = 0; 
        int choix; 
        do { 
            System.out.println("1. Ajouter un article  2. Afficher le total  0. Quitter"); 
            choix = Integer.parseInt(sc.nextLine()); 
            switch (choix) { 
                case 1 -> { 
                    System.out.print("Prix : "); 
                    total += Long.parseLong(sc.nextLine()); 
                } 
                case 2 -> System.out.println("Total actuel : " + total + " FCFA"); 
                case 0 -> System.out.println("Au revoir !"); 
                default -> System.out.println("Choix invalide"); 
            } 
        } while (choix != 0); 
        sc.close();
    } 
}