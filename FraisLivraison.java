public class FraisLivraison { 
 
    static long frais(String quartier, double poidsKg) { 
        return switch (quartier.toUpperCase()) { 
            case "PLATEAU", "MEDINA", "FANN" -> 1_000; 
            case "PARCELLES ASSAINIES", "GRAND YOFF", "OUAKAM" -> 1_500; 
            case "RUFISQUE", "DIAMNIADIO" -> { 
                long base = 2_500; 
                long supplement = poidsKg > 5 ? 1_000 : 0; 
                yield base + supplement; 
            } 
            default -> throw new IllegalArgumentException("Zone non desservie : " + quartier); 
        }; 
    } 
 
    public static void main(String[] args) { 
        System.out.println("Plateau      : " + frais("Plateau", 1.2)); 
        System.out.println("Ouakam       : " + frais("ouakam", 3)); 
        System.out.println("Diamniadio   : " + frais("Diamniadio", 2)); 
        System.out.println("Diamniadio 8kg: " + frais("Diamniadio", 8)); 
        try { 
            frais("Saint-Louis", 1); 
        } catch (IllegalArgumentException e) { 
            System.out.println("Erreur : " + e.getMessage()); 
        } 
    } 
}