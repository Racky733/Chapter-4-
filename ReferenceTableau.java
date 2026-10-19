import java.util.Arrays;
public class ReferenceTableau {
    public static void main (String [] args){
        int [] stockLundi = {10, 20, 30};
        int[] alias = stockLundi;
        alias[0] =0;
        System.out.println(Arrays.toString(stockLundi));

        int[] copie = Arrays.copyOf(stockLundi, stockLundi.length);
        copie[1] = 99;
        System.out.println(Arrays.toString(stockLundi) + " / " + Arrays.toString(copie));

        int[] agrandi = Arrays.copyOf(stockLundi, 5);
        System.out.println(Arrays.toString(agrandi));

        System.out.println(stockLundi == copie);

        System.out.println(Arrays.equals(stockLundi, new int [] {0, 20 , 30}));
    }
}
