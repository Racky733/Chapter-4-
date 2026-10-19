    public static void main(String[] args) { 
        for (int jour = 1; jour <= 7; jour++) { 
            String nomFrancais = switch (jour) { 
                case 1 -> "Lundi"; 
                case 2 -> "Mardi"; 
                case 3 -> "Mercredi"; 
                case 4 -> "Jeudi"; 
                case 5 -> "Vendredi"; 
                case 6 -> "Samedi"; 
                case 7 -> "Dimanche"; 
                default -> throw new IllegalArgumentException("Jour invalide : " + jour); 
            }; 
            String nomWolof = switch (jour) { 
                case 1 -> "Altine"; 
                case 2 -> "Talaata"; 
                case 3 -> "Àllarba"; 
                case 4 -> "Alxamis"; 
                case 5 -> "Àjjuma";
                case 6 -> "Gaawu"; 
                case 7 -> "Dibéer"; 
                default -> "?"; 
            }; 
            String type = switch (jour) { 
                case 6, 7 -> "week-end"; 
                default -> "semaine"; 
            }; 
            System.out.printf("%d : %-9s %-8s (%s)%n", jour, nomFrancais, nomWolof, type); 
        } 
    } 
