public class JourClassique1 { 
    public static void main(String[] args) { 
        String jour = "Lundi"; 
        String nom;
         switch (jour) { 
            case "Lundi": 
                nom = "Lundi"; 
                break; 
            case "Mardi": 
                nom = "Mardi"; 
                break; 
            case "Mercredi": 
                nom = "Mercredi"; 
                break; 
            case "Jeudi": 
                nom = "Jeudi"; 
                break; 
            case "Vendredi": 
                nom = "Vendredi"; 
                break; 
            case "Samedi": 
            case "Dimanche": 
                nom = "Week-end"; 
                break; 
            default: 
                nom = "Jour invalide"; 
        } 
        System.out.println(nom); 
    } 
}