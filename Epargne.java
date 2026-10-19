public class Epargne { 
    public static void main(String[] args) { 
        long objectif = 250_000;    // achat d'un ordinateur portable 
        long versementMensuel = 30_000; 
        long epargne = 0; 
        int mois = 0; 
        while (epargne < objectif) { 
            epargne += versementMensuel; 
            mois++; 
        } 
        System.out.println("Objectif atteint en " + mois + " mois (épargne : " 
                + epargne + " FCFA)"); 
    } 
}