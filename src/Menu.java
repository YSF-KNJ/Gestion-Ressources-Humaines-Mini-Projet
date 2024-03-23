import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.IOException;

public class Menu {
    public void run() throws IOException{
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char choix;
        do {
            
            System.out.println("Menu Principal:");
            System.out.println("--------------");
            System.out.println("1. insérer cinq pseudo-valeurs pour tester le programme");
            System.out.println("2. Gérer les Employés");
            System.out.println("3. Gérer les Départements");
            System.out.println("4. Gérer les Postes");
            System.out.println("5. Gérer les Localisations");
            System.out.println("6. Quitter");
            System.out.print("Veuillez sélectionner une option: ");
            choix = scanner.next().charAt(0);
            System.out.println("\n");
            
            
            


            switch (choix) {
                case '1':
                    InsertValues.insert();
                    System.out.println("inséré avec succès");
                    break;
                case '2':
                    do {
                        System.out.println("************************");
                        System.out.println("a. Voir tous les employes");
                        System.out.println("b. Ajouter un nouvel employe sans manger");
                        System.out.println("c. Ajouter un nouvel employe");
                        System.out.println("d. Rechercher un employe");
                        System.out.println("e. Mettre a jour les informations sur un employe");
                        System.out.println("f. Supprimer un employe");
                        System.out.println("g. Augmenter le salaire d'un employe");
                        System.out.println("h. add posts from file");
                        System.out.println("i. export file");
                        System.out.println("j. export xls");
                        System.out.println("k. Quitte r");
                        System.out.print("Veuillez selectionner une option: ");
                        choix = scanner.next().charAt(0);
                        System.out.println("\n");


                        switch (choix) {
                            case 'a':
                                Employe.getEmployes();
                                break;
                            case 'b':
                                System.out.print("Premon de l'employe : ");
                                String prenom1 = reader.readLine();
                                System.out.print("Nom de l'employe: ");
                                String nom1 = reader.readLine();
                                System.out.print("Email de l'employe : ");
                                String email1 = reader.readLine();
                                System.out.print("Telephone de l'employe : ");
                                String telephone1 = reader.readLine();
                                System.out.print("salaire de l'employe : ");
                                int salaire1 = scanner.nextInt();
                                System.out.print("Poste ID de l'employe :");
                                int id_poste1 = scanner.nextInt();
                                System.out.print("Departement ID de l'employe :");
                                int id_departement1 = scanner.nextInt();
                                if (Poste.checkID(id_poste1) && Departement.checkID(id_departement1)) {
                                    Employe.addManger(prenom1, nom1, email1, telephone1, salaire1, id_poste1, id_departement1);
                                    System.out.println("Le manager a ete ajoute.");
                                } else if (!Poste.checkID(id_poste1)) {
                                    System.out.println("L'employe n'a pas ete ajoute car  poste ID " + id_poste1 + " n'existe pas.");
                                } else if (!Departement.checkID(id_departement1)) {
                                    System.out.println("L'employe n'a pas ete ajoute car departement ID " + id_departement1 + " n'existe pas.");
                                }

                                break;

                            case 'c':
                                System.out.print("Premon de l'employe : ");
                                String prenom2 = reader.readLine();
                                System.out.print("Nom de l'employe: ");
                                String nom2 = reader.readLine();
                                System.out.print("Email de l'employe : ");
                                String email2 = reader.readLine();
                                System.out.print("Telephone de l'employe : ");
                                String telephone2 = reader.readLine();
                                System.out.print("salaire de l'employe : ");
                                int salaire2 = scanner.nextInt();
                                System.out.print("Poste ID de l'employe :");
                                int id_poste2 = scanner.nextInt();
                                System.out.print("Departement ID de l'employe :");
                                int id_departement2 = scanner.nextInt();
                                System.out.print("Manager ID de l'employe :");
                                int id_manager2 = scanner.nextInt();
                                if (Poste.checkID(id_poste2) && Employe.checkID(id_manager2) && Departement.checkID(id_departement2)) {
                                    Employe.addEmploye(prenom2, nom2, email2, telephone2, salaire2, id_poste2, id_departement2, id_manager2);
                                    System.out.println("L'employe a ete ajoute.");
                                } else if (!Poste.checkID(id_poste2)) {
                                    System.out.println("L'employe n'a pas ete ajoute car  poste ID " + id_poste2 + " n'existe pas.");
                                } else if (!Departement.checkID(id_departement2)) {
                                    System.out.println("L'employe n'a pas ete ajoute car departement ID " + id_departement2 + " n'existe pas.");
                                } else if (!Employe.checkID(id_manager2)) {
                                    System.out.println("L'employe n'a pas ete ajoute car manager ID " + id_manager2 + " n'existe pas.");
                                }
                                break;
                            case 'd':
                                System.out.print("ID de l'employe :");
                                int id1 = scanner.nextInt();
                                if (Employe.checkID(id1)) {
                                    System.out.println("Employe trouve :");
                                    Employe.searchEmploye(id1);
                                } else {
                                    System.out.println("L'employe avec l'ID " + id1 + " est introuvable.");
                                }
                                break;
                            case 'e':
                                System.out.print("ID de l'employe :");
                                int id2 = scanner.nextInt();
                                if (Employe.checkID(id2)) {
                                    System.out.print("Premon de l'employe : ");
                                    String prenom3 = scanner.next();
                                    System.out.print("Nom de l'employe : ");
                                    String nom3 = reader.readLine();
                                    System.out.print("Email de l'employe : ");
                                    String email3 = reader.readLine();
                                    System.out.print("Telephone de l'employe : ");
                                    String telephone3 = reader.readLine();
                                    System.out.print("salaire de l'employe : ");
                                    int salaire3 = scanner.nextInt();
                                    System.out.print("Poste ID de l'employe :");
                                    int id_poste3 = scanner.nextInt();
                                    System.out.print("Departement ID de l'employe :");
                                    int id_departement3 = scanner.nextInt();
                                    System.out.print("Manager ID de l'employe :");
                                    int id_manager3 = scanner.nextInt();
                                    if (Poste.checkID(id_poste3) && Departement.checkID(id_departement3) && Employe.checkID(id_manager3)) {
                                        Employe.updateEmploye(id2, prenom3, nom3, email3, telephone3, salaire3, id_poste3, id_departement3, id_manager3);
                                        System.out.println("Les informations de l'employe avec id " + id2 + " ont ete mises a jour avec succes");
                                    } else if (!Poste.checkID(id_poste3)) {
                                        System.out.println("La mise a jour de l'employe n'a pas ete effectuee car   poste ID " + id_poste3 + " n'existe pas.");
                                    } else if (!Departement.checkID(id_departement3)) {
                                        System.out.println("La mise a jour de l'employe n'a pas ete effectuee departement ID " + id_departement3 + " n'existe pas.");
                                    } else if (!Employe.checkID(id_manager3)) {
                                        System.out.println("La mise a jour de l'employe n'a pas ete effectuee car manager ID " + id_manager3 + " n'existe pas.");
                                    }
                                } else {
                                    System.out.println("L'employe avec ID " + id2 + " n'existe pas.");
                                }
                                break;
                            case 'f':
                                System.out.print("ID de l'employe : ");
                                int old_id = scanner.nextInt();
                                if (Employe.checkID(old_id)) {
                                    if (Employe.isManager(old_id)) {
                                        System.out.println("L'employe avec ID " + old_id + " est un manager.");
                                        System.out.print("ID manager pour les employes ayant  ID manager que vous souhaitez supprimer:");
                                        int new_id = scanner.nextInt();
                                        if (Employe.checkID(new_id)) {
                                            Employe.replaceManager(new_id, old_id);
                                            System.out.println("Remplacement reussi de manager ID " + old_id + " par manager ID " + new_id + ".");
                                            System.out.println("Le manager avec l'ID " + old_id + " est supprime.");
                                        } else {
                                            System.out.println("Le nouvel manager avec ID " + new_id + " n'existe pas.");
                                        }
                                    } else {
                                        Employe.deleteEmploye(old_id);
                                        System.out.println("Membre avec l'ID " + old_id + " est supprime.");
                                    }
                                } else {
                                    System.out.println("L'employe avec ID " + old_id + " n'existe pas.");
                                }
                                break;
                            case 'g':
                                System.out.print("ID de l'employe :");
                                int id3 = scanner.nextInt();
                                if (Employe.checkID(id3)) {
                                    System.out.print("Le montant pour augmenter le salaire de l'employe: ");
                                    int amount = scanner.nextInt();
                                    Employe.increaseSalary(id3, amount);
                                    System.out.println("Le salaire de l'employe avec l'ID " + id3 + " a ete augmente.");
                                } else {
                                    System.out.println("L'Employe avec l'ID " + id3 + " n'existe pas.");
                                }
                                break;
                            case 'h':
                                System.out.print("file name :");
                                String fileName = reader.readLine();
                                try {
                                    File file = new File(fileName+".txt");
                                    FileInputStream fileInputStream = new FileInputStream(file);
                                    Employe.addFromFile(fileInputStream);
                                } catch (FileNotFoundException ex) {
                                    System.out.println("file does not exists");
                                }
                                break;
                            case 'i':
                                System.out.print("file name :");
                                String fileNameTxt = reader.readLine();
                                Employe.exportFileTxt(fileNameTxt);
                                break;
                            case 'j':
                                System.out.print("file name :");
                                String fileNameXls = reader.readLine();
                                Employe.exportFileXls(fileNameXls);
                                break;
                            default:
                                System.out.println("Option invalide.");
                        }


                    } while (choix != 'k');
                    break;
                case '3':
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
                                    System.out.println("ID de localisation n'existe pas");
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
                                            System.out.println("Le nouvel ID n'existe pas");
                                        }
                                    } else {
                                        Departement.deleteDepartement(idDepDel);
                                    }
                                } else {
                                    System.out.println("ID de departement n'existe pas");
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
                                        System.out.println("ID de localisation n'existe pas");
                                    }

                                } else {
                                    System.out.println("ID de departement n'existe pas");
                                }
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
                        System.out.println("a. Afficher la liste des postes");
                        System.out.println("b. Ajouter un nouveau poste");
                        System.out.println("c. Supprimer un poste");
                        System.out.println("d. Mettre à jour les informations sur un poste");
                        System.out.println("e. add posts from file");
                        System.out.println("f. export file");
                        System.out.println("g. export xls");
                        System.out.println("h. Quitter");
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
                                            Poste.replacePosts(idPostDel, idPostNew);
                                            Poste.deletePoste(idPostDel);
                                        } else {
                                            System.out.println("Le nouvel ID n'existe pas");
                                        }
                                    } else {
                                        Poste.deletePoste(idPostDel);
                                    }

                                } else {
                                    System.out.println("ID de poste n'existe pas");
                                }
                                break;
                            case 'd':
                                System.out.print("ID de Poste :");
                                int idPostUpd = scanner.nextInt();
                                if (Poste.checkID(idPostUpd)) {
                                    System.out.print("Titre de Poste : ");
                                    String titrePostUpd = reader.readLine();
                                    Poste.updatePost(idPostUpd, titrePostUpd);
                                } else {
                                    System.out.println("ID de poste n'existe pas");
                                }
                                break;
                            case 'e':
                                System.out.print("file name :");
                                String fileName = reader.readLine();
                                try {
                                    File file = new File(fileName+".txt");
                                    FileInputStream fileInputStream = new FileInputStream(file);
                                    Poste.addFromFile(fileInputStream);
                                } catch (FileNotFoundException ex) {
                                    System.out.println("file does not exists");
                                }
                                break;
                            case 'f':
                                System.out.print("file name :");
                                String fileNameTxt = reader.readLine();
                                Poste.exportFileTxt(fileNameTxt);
                                break;
                            case 'g':
                                System.out.print("file name :");
                                String fileNameXls = reader.readLine();
                                Poste.exportFileXls(fileNameXls);
                                break;
                            case 'h':
                                break;
                            default:

                                System.out.println("Option invalide.");
                        }


                    } while (choix != 'h');

                    break;
                case '5':
                    do {
                        System.out.println("************************");
                        System.out.println("a. Afficher la liste des Localisations");
                        System.out.println("b. Ajouter un nouveau Localisation");
                        System.out.println("c. Supprimer un Localisation");
                        System.out.println("d. Mettre à jour les informations sur un Localisation");
                        System.out.println("e. add localisations from txt file");
                        System.out.println("f. export txt");
                        System.out.println("g. Quitter");
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
                                int idLocDel = scanner.nextInt();
                                if (Localisation.checkID(idLocDel)) {
                                    if (Localisation.isLocalisationOccupied(idLocDel)) {
                                        System.out.println("Veuillez fournir l'identifiant du nouveau localisation, les departement du localisation à supprimer seront transférés vers celui-ci :");
                                        int idLocNew = scanner.nextInt();
                                        if (Localisation.checkID(idLocNew)) {
                                            Localisation.replaceLocalisations(idLocDel, idLocNew);
                                            Localisation.deleteLocalisation(idLocDel);
                                        } else {
                                            System.out.println("Le nouvel ID n'existe pas");
                                        }
                                    } else {
                                        Localisation.deleteLocalisation(idLocDel);
                                    }

                                } else {
                                    System.out.println("ID de Localisation n'existe pas");
                                }
                                break;
                            case 'd':
                                System.out.print("ID de Localisation :");
                                int idLocUpd = scanner.nextInt();
                                if (Localisation.checkID(idLocUpd)) {
                                    System.out.print("adresse de Localisation : ");
                                    String adresseUpd = reader.readLine();
                                    System.out.print("ville de Localisation : ");
                                    String villeUpd = reader.readLine();
                                    Localisation.updateLocalisation(idLocUpd, adresseUpd, villeUpd);
                                } else {
                                    System.out.println("ID de localisation n'existe pas");
                                }
                                break;
                            case 'e':
                                System.out.print("file name :");
                                String fileName = reader.readLine();
                                try {
                                    File file = new File(fileName+".txt");
                                    FileInputStream fileInputStream = new FileInputStream(file);
                                    Localisation.addFromFile(fileInputStream);
                                } catch (FileNotFoundException ex) {
                                    System.out.println("file does not exists");
                                }
                                break;
                            case 'f':
                                System.out.print("file name :");
                                String fName = reader.readLine();
                                Localisation.exportFileTxt(fName);
                                break;
                            case 'g':
                                break;
                            default:
                                System.out.println("Option invalide.");
                        }


                    } while (choix != 'g');
                    break;
                case '6':
                    System.out.println("Programme terminé.");
                    break;    
                default:
                    System.out.println("Option invalide.");
            }

        } while (choix != '6');
    }
}
