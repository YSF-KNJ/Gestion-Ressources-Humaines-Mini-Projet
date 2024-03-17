import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choix;
        
        do {
            System.out.println("Menu Principal:");
            System.out.println("\n");
            System.out.println("1. Gerer les Employes");
            System.out.println("2. Gerer les Departements");
            System.out.println("3. Gerer les Postes");
            System.out.println("4. Gerer les Localisations");
            System.out.println("5. Quitter");
            System.out.println("\n");
            System.out.print("Veuillez selectionner une option: ");
            choix = scanner.next().charAt(0);

            
            switch (choix) {
                case '1':
                    do {
                        System.out.println("\n");
                        System.out.println("a. Voir tous les manager");
                        System.out.println("b. Voir tous les employes");
                        System.out.println("c. Ajouter un nouvel manager");
                        System.out.println("d. Ajouter un nouvel employe");
                        System.out.println("e. Rechercher un employe");
                        System.out.println("f. Mettre a jour les informations sur un employe");
                        System.out.println("g. Supprimer un employe");
                        System.out.println("h. Augmenter le salaire d'un employe");
                        System.out.println("i. Quitte r");
                        System.out.println("\n");
                        System.out.print("Veuillez selectionner une option: ");
                        choix = scanner.next().charAt(0);
                        
                         switch (choix) {
                            case 'b':
                                Employe.getEmployes();
                                break;
                            case 'd':
                                System.out.print("Premon de l'employe : ");
                                String prenom1 = scanner.next();
                                System.out.print("Nom de l'employe: ");
                                String nom1 = scanner.next();
                                System.out.print("Email de l'employe : ");
                                String email1 = scanner.next();
                                System.out.print("Telephone de l'employe : ");
                                String telephone1 = scanner.next();
                                System.out.print("salaire de l'employe : ");
                                double salaire1 = scanner.nextInt();
                                int id_poste1;
                                do {
                                   System.out.print("ID poster de l'employe : ");
                                   id_poste1 = scanner.nextInt();
                                   if (!Poste.checkID(id_poste1)) {
                                         System.out.println("Le poste avec cet ID"+id_poste1+" n'existe pas.");
                                   } else {
                                    break; 
                                   }
                                } while (true);
                                System.out.print("Id departement de l'employe : ");
                                int id_departement1 = scanner.nextInt();
                                /*int id_departement1;
                                do {
                                   System.out.print("ID  departement de l'employe : ");
                                   id_departement1 = scanner.nextInt();
                                   if (!Departement.checkID(id_departement1)) {
                                         System.out.println("Le departement avec cet ID "+id_departement1+"n'existe pas.");
                                   } else {
                                    break; 
                                   }
                                } while (true);*/
                                int id_manager1;
                                do {
                                   System.out.print("ID du manager de l'employe : ");
                                   id_manager1 = scanner.nextInt();
                                   if (!Employe.checkID(id_manager1)) {
                                         System.out.println("Le manager avec cet ID"+id_manager1+" n'existe pas. ");
                                   } else {
                                    break; 
                                   }
                                 } while (true);
                                Employe.addEmploye(prenom1 , nom1 , email1 ,telephone1 , salaire1 , id_poste1 , id_departement1 , id_manager1);
                                break;
                                        
                            case 'e':
                                System.out.print("ID de l'employe :");
                                int id1 = scanner.nextInt();
                                Employe.searchEmploye(id1);
                                break;
                            case 'f':
                                System.out.print("ID de l'employe :");
                                int id2 = scanner.nextInt();
                                System.out.print("Premon de l'employe : ");
                                String prenom2 = scanner.next();
                                System.out.print("Nom de l'employe : ");
                                String nom2 = scanner.next();
                                System.out.print("Email de l'employe : ");
                                String email2 = scanner.next();
                                System.out.print("Telephone de l'employe : ");
                                String telephone2 = scanner.next();
                                System.out.print("salaire de l'employe : ");
                                double salaire2 = scanner.nextInt();
                                int id_poste2;
                                do {
                                   System.out.print("ID poster de l'employé : ");
                                   id_poste2 = scanner.nextInt();
                                   if (!Poste.checkID(id_poste2)) {
                                         System.out.println("Le poste avec cet ID "+id_poste2+"n'existe pas.");
                                   } else {
                                    break; 
                                   }
                                } while (true);
                                System.out.print("Id departement de l'employe : ");
                                int id_departement2 = scanner.nextInt();
                                /*int id_departement2;
                                do {
                                   System.out.print("ID  departement de l'employe : ");
                                   id_departement2 = scanner.nextInt();
                                   if (!Departement.checkID(id_departement2)) {
                                         System.out.println("Le departement avec cet ID"+id_departement2+" n'existe pas.");
                                   } else {
                                    break; 
                                   }
                                } while (true);*/
                                int id_manager2;
                                do {
                                   System.out.print("ID du manager de l'employe : ");
                                   id_manager2 = scanner.nextInt();
                                   if (!Employe.checkID(id_manager2)) {
                                         System.out.println("Le manager avec cet ID"+id_manager2+" n'existe pas. ");
                                   } else {
                                    break; 
                                   }
                                } while (true);
                                Employe.updateEmploye(id2, prenom2 , nom2 , email2 ,telephone2 , salaire2 , id_poste2 , id_departement2 , id_manager2);
                                break;
                            case 'g':
                                
                                System.out.print("ID de l'employe :");
                                int old_id = scanner.nextInt();
                                if (Employe.isManager(old_id)) {
                                   System.out.println("Employee with ID " + old_id + " is a manager.");
                                   System.out.println("Enter the new manager ID:");
                                   int new_id = scanner.nextInt();
                                   Employe.replaceManager(new_id,old_id);
                                }else {
                                    Employe.deleteEmploye(old_id);
                                }
                                break;  
                            case 'h':
                                System.out.print("ID de l'employe :");
                                int id4 = scanner.nextInt();
                                System.out.print("Le montant pour augmenter le salaire de l'employe: ");
                                double amount1 = scanner.nextInt();
                                Employe.increaseSalary(id4 , amount1);
                                break;    
                            default:
                                
                                System.out.println("Option invalide.");}
                                
                        
                    
                    } while (choix != 'i');
                    break;
                case '2':
                    do {
                        System.out.println("\n");
                        System.out.println("a. Afficher la liste des departements");
                        System.out.println("b. Ajouter un nouveau departement");
                        System.out.println("c. Supprimer un département");
                        System.out.println("d. Mettre a jour les informations sur un departement");
                        System.out.println("e. Quitter");
                        System.out.println("\n");
                        System.out.print("Veuillez selectionner une option: ");
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
                        System.out.println("d. Mettre a jour les informations sur un poste");
                        System.out.println("e. Quitter");
			System.out.println("\n");
                        System.out.print("Veuillez selectionner une option: ");
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
                        System.out.println("d. Mettre a jour les informations sur un Localisation");
                        System.out.println("e. Quitter");
			System.out.println("\n");
                        System.out.print("Veuillez selectionner une option: ");
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
                    System.out.println("Programme termine.");
                    break;
                default:
                    System.out.println("Option invalide.");
            }
            
        } while (choix != '5');
        
        scanner.close();
    }
}