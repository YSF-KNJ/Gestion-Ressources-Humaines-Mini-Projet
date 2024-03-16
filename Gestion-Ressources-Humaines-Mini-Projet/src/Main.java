import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choix;
        
        do {
            System.out.println("Menu Principal:");
            System.out.println("\n");
            System.out.println("1. Gérer les Employés");
            System.out.println("2. Gérer les Départements");
            System.out.println("3. Gérer les Postes");
            System.out.println("4. Gérer les Localisations");
            System.out.println("5. Quitter");
            System.out.println("\n");
            System.out.print("Veuillez sélectionner une option: ");
            choix = scanner.next().charAt(0);

            
            switch (choix) {
                case '1':
                    do {
                        System.out.println("\n");
                        System.out.println("a. Voir tous les employés");
                        System.out.println("b. Ajouter un nouvel employé");
                        System.out.println("c. Rechercher un employé");
                        System.out.println("d. Mettre à jour les informations sur un employé");
                        System.out.println("e. Supprimer un employé");
                        System.out.println("f. Augmenter le salaire d'un employé");
                        System.out.println("g. Quitter");
                        System.out.println("\n");
                        System.out.print("Veuillez sélectionner une option: ");
                        choix = scanner.next().charAt(0);
                        
                        switch (choix) {
                            case 'a':
                                System.out.println("dir chi l3baa");
                                break;
                            default:
                                System.out.println("Option invalide.");}
                                
                        
                    } while (choix != 'g');
                    break;
                case '2':
                    do {
                        System.out.println("\n");
                        System.out.println("a. Afficher la liste des départements");
                        System.out.println("b. Ajouter un nouveau département");
                        System.out.println("c. Supprimer un département");
                        System.out.println("d. Mettre à jour les informations sur un département");
                        System.out.println("e. Quitter");
                        System.out.println("\n");
                        System.out.print("Veuillez sélectionner une option: ");
                        choix = scanner.next().charAt(0);
                        
                        switch (choix) {
                            case 'a':
                                System.out.println("dir chi l3baa");
                                break;
                            default:
                                System.out.println("Option invalide.");}
                                
                        
                    } while (choix != 'e');

                    break;
                case '3':
                    do {
                        System.out.println("\n");
                        System.out.println("a. Afficher la liste des postes");
                        System.out.println("b. Ajouter un nouveau poste");
                        System.out.println("c. Supprimer un poste");
                        System.out.println("d. Mettre à jour les informations sur un poste");
                        System.out.println("e. Quitter");
			System.out.println("\n");
                        System.out.print("Veuillez sélectionner une option: ");
                        choix = scanner.next().charAt(0);
                        
                        switch (choix) {
                            case 'a':
                                Poste.getPostes();
                                break;
                            case 'b':
                                System.out.print("Titre de Poste : ");
                                String title1 = scanner.next();
                                Poste.addPost(title1);
                                break;
                            case 'c':
                                System.out.print("ID de Poste :");
                                int id1 = scanner.nextInt();
                                Poste.deletePoste(id1);
                                break;
                            case 'd':
                                System.out.print("ID de Poste :");
                                int id2 = scanner.nextInt();
                                System.out.print("Titre de Poste : ");
                                String title2 = scanner.next();
                                Poste.updatePost(id2, title2);
                                break;
                            default:
                                
                                System.out.println("Option invalide.");}
                                
                        
                    } while (choix != 'e');

                    break;
                case '4':
                    do {
                        System.out.println("\n");
                        System.out.println("a. Afficher la liste des Localisations");
                        System.out.println("b. Ajouter un nouveau Localisation");
                        System.out.println("c. Supprimer un Localisation");
                        System.out.println("d. Mettre à jour les informations sur un Localisation");
                        System.out.println("e. Quitter");
			System.out.println("\n");
                        System.out.print("Veuillez sélectionner une option: ");
                        choix = scanner.next().charAt(0);
                        
                        switch (choix) {
                            case 'a':
                                Localisation.getLocalisations();
                                break;
                            case 'b':
                                System.out.print("adresse de Localisation : ");
                                String adresse1 = scanner.next();
                                System.out.print("ville de Localisation : ");
                                String ville1 = scanner.next();
                                Localisation.addLocalisation(adresse1,ville1);
                                break;
                            case 'c':
                                System.out.print("ID de Localisation :");
                                int id1 = scanner.nextInt();
                                Localisation.deleteLocalisation(id1);
                                break;
                            case 'd':
                                System.out.print("ID de Localisation :");
                                int id2 = scanner.nextInt();
                                System.out.print("adresse de Localisation : ");
                                String adresse2 = scanner.next();
                                System.out.print("ville de Localisation : ");
                                String ville2 = scanner.next();
                                Localisation.updateLocalisation(id2, adresse2,ville2);
                                break;
                            default:
                                
                                System.out.println("Option invalide.");}
                                
                        
                    } while (choix != 'e');
                    break;
                case '5':
                    System.out.println("Programme terminé.");
                    break;
                default:
                    System.out.println("Option invalide.");
            }
            
        } while (choix != '5');
        
        scanner.close();
    }
}
