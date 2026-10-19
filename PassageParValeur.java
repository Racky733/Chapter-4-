import java.util.Arrays; 
 
public class PassageParValeur { 
    static void augmenter(int stock) { 
        stock += 10;                       // modifie la copie locale seulement 
    } 
    static void augmenterTous(int[] stocks) { 
        for (int i = 0; i < stocks.length; i++) { 
            stocks[i] += 10;               // modifie le tableau partagé 
        } 
    } 
    static void remplacer(int[] stocks) { 
        stocks = new int[]{0, 0, 0};       // change la copie de la référence seulement 
    } 
 
    public static void main(String[] args) { 
        int s = 5; 
        augmenter(s); 
        System.out.println("s = " + s); 
 
        int[] t = {1, 2, 3}; 
        augmenterTous(t); 
        System.out.println("t = " + Arrays.toString(t)); 
        remplacer(t); 
        System.out.println("t = " + Arrays.toString(t)); 
    } 
}