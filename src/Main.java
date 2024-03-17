import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char choix;

        do {
            System.out.println("Menu Principal:");
            System.out.println("--------------");
            System.out.println("1. Gérer les Employés");
            System.out.println("2. Gérer les Départements");
            System.out.println("3. Gérer les Postes");
            System.out.println("4. Gérer les Localisations");
            System.out.println("5. Quitter");
            System.out.print("Veuillez sélectionner une option: ");
            choix = scanner.next().charAt(0);
            System.out.println("\n");


            switch (choix) {
                case '1':
                    do {
                        System.out.println("************************");
                        System.out.println("a. Voir tous les employés");
                        System.out.println("b. Ajouter un nouvel employé");
                        System.out.println("c. Rechercher un employé");
                        System.out.println("d. Mettre à jour les informations sur un employé");
                        System.out.println("e. Supprimer un employé");
                        System.out.println("f. Augmenter le salaire d'un employé");
                        System.out.println("g. Quitter");
                        System.out.print("Veuillez sélectionner une option: ");
                        choix = scanner.next().charAt(0);
                        System.out.println("\n");


                        switch (choix) {
                            case 'a':
                                System.out.println("dir chi l3baa");
                                break;
                            case 'g':
                                break;
                            default:
                                System.out.println("Option invalide.");
                        }


                    } while (choix != 'g');
                    break;
                case '2':
                    do {
                        System.out.println("************************");
                        System.out.println("a. Afficher la liste des départements");
                        System.out.println("b. Ajouter un nouveau département");
                        System.out.println("c. Supprimer un département");
                        System.out.println("d. Mettre à jour les informations sur un département");
                        System.out.println("e. Quitter");
                        System.out.print("Veuillez sélectionner une option: ");
                        choix = scanner.next().charAt(0);
                        System.out.println("\n");

                        switch (choix) {
                            case 'a':
                                Departement.getDepartement();
                                break;
                            case 'b':
                                System.out.print("nom de departemet : ");
                                String nomDep = reader.readLine();
                                System.out.print("ID de localisation :");
                                int idLocAdd = scanner.nextInt();
                                if (Localisation.checkID(idLocAdd)) {
                                    Departement.addDepartement(nomDep, idLocAdd);
                                } else {
                                    System.out.println("id localisation makynchii");
                                }

                                break;
                            case 'c':
                                System.out.print("ID de departemet :");
                                int idDepDel = scanner.nextInt();
                                if (Departement.checkID(idDepDel)) {
                                    if (Departement.isDepartmentOccupied(idDepDel)) {
                                        System.out.println("Veuillez fournir l'identifiant du nouveau département, les employés du département à supprimer seront transférés vers celui-ci :");
                                        int idDepNew = scanner.nextInt();
                                        if (Departement.checkID(idDepNew)) {
                                            Departement.replaceDepartements(idDepDel, idDepNew);
                                            Departement.deleteDepartement(idDepDel);
                                        } else {
                                            System.out.println("new id makynchii");
                                        }
                                    } else {
                                        Departement.deleteDepartement(idDepDel);
                                    }
                                } else {
                                    System.out.println("id makynchii");
                                }
                                break;
                            case 'd':
                                System.out.print("ID de departemet :");
                                int idDepUpd = scanner.nextInt();
                                if (Departement.checkID(idDepUpd)) {
                                    System.out.print("nom de departemet : ");
                                    String nomDepUpd = reader.readLine();
                                    System.out.print("ID de localisation :");
                                    int idLocUpd = scanner.nextInt();
                                    if (Departement.checkID(idLocUpd)) {
                                        Departement.updateDepartement(idDepUpd, nomDepUpd, idLocUpd);
                                    } else {
                                        System.out.println("id localisation makynchi");
                                    }

                                } else {
                                    System.out.println("id departement makynchii");
                                }
                                break;
                            case 'e':
                                break;
                            default:
                                System.out.println("Option invalide.");
                        }


                    } while (choix != 'e');

                    break;
                case '3':
                    do {
                        System.out.println("************************");
                        System.out.println("a. Afficher la liste des postes");
                        System.out.println("b. Ajouter un nouveau poste");
                        System.out.println("c. Supprimer un poste");
                        System.out.println("d. Mettre à jour les informations sur un poste");
                        System.out.println("e. Quitter");
                        System.out.print("Veuillez sélectionner une option: ");
                        choix = scanner.next().charAt(0);
                        System.out.println("\n");


                        switch (choix) {
                            case 'a':
                                Poste.getPostes();
                                break;
                            case 'b':
                                System.out.print("Titre de Poste : ");
                                String titrePost = reader.readLine();
                                Poste.addPost(titrePost);
                                break;
                            case 'c':
                                System.out.print("ID de poste :");
                                int idPostDel = scanner.nextInt();
                                if (Poste.checkID(idPostDel)) {
                                    if (Poste.isPosteOccupied(idPostDel)) {
                                        System.out.println("Veuillez fournir l'identifiant du nouveau poste, les employés du post à supprimer seront transférés vers celui-ci :");
                                        int idPostNew = scanner.nextInt();
                                        if (Poste.checkID(idPostNew)) {
                                            Departement.replaceDepartements(idPostDel, idPostNew);
                                            Departement.deleteDepartement(idPostDel);
                                        } else {
                                            System.out.println("new post id makynchii");
                                        }
                                    } else {
                                        Departement.deleteDepartement(idPostDel);
                                    }

                                } else {
                                    System.out.println("id post makynchii");
                                }
                                break;
                            case 'd':
                                System.out.print("ID de Poste :");
                                int id2 = scanner.nextInt();
                                System.out.print("Titre de Poste : ");
                                String title2 = reader.readLine();
                                Poste.updatePost(id2, title2);
                                break;
                            case 'e':
                                break;
                            default:

                                System.out.println("Option invalide.");
                        }


                    } while (choix != 'e');

                    break;
                case '4':
                    do {
                        System.out.println("************************");
                        System.out.println("a. Afficher la liste des Localisations");
                        System.out.println("b. Ajouter un nouveau Localisation");
                        System.out.println("c. Supprimer un Localisation");
                        System.out.println("d. Mettre à jour les informations sur un Localisation");
                        System.out.println("e. Quitter");
                        System.out.print("Veuillez sélectionner une option: ");
                        choix = scanner.next().charAt(0);
                        System.out.println("\n");


                        switch (choix) {
                            case 'a':
                                Localisation.getLocalisations();
                                break;
                            case 'b':
                                System.out.print("adresse de Localisation : ");
                                String adresse1 = reader.readLine();
                                System.out.print("ville de Localisation : ");
                                String ville1 = reader.readLine();
                                Localisation.addLocalisation(adresse1, ville1);
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
                                String adresse2 = reader.readLine();
                                System.out.print("ville de Localisation : ");
                                String ville2 = reader.readLine();
                                Localisation.updateLocalisation(id2, adresse2, ville2);
                                break;
                            case 'e':
                                break;
                            default:
                                System.out.println("Option invalide.");
                        }


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
