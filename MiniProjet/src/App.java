import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws IOException{
        int choix;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        
        do
         {
            System.out.println(" >> **** GESTION DE STOCK **** << \n");
            System.out.println(" cree par Sanaa AJRIR - Alae El HADRI - Kaoutar CHAKROUN \n");
            System.out.println(" 1.Creer la base de donnee Gestion_Stock\n");
            System.out.println(" 2.Creer la table article\n");
            System.out.println(" 3.Ajouter un article au stock\n");
            System.out.println(" 4.Modifier le nom d'un article par id\n");
            System.out.println(" 5.Modifier la description d'un article par id\n");
            System.out.println(" 6.Modifier le prix de vente d'un article par id\n");
            System.out.println(" 7.Supprimer un article par id\n");
            System.out.println(" 8.Rechercher un article par id\n");
            System.out.println(" 9.Rechercher un article par nom\n");
            System.out.println(" 10.Afficher tous les articles\n");
            System.out.println(" 0.Quitter\n");
            System.out.print("\n Entrez votre choix :  ");
            
            choix = scanner.nextInt();
            switch(choix)
            {
                case 0: {
                    System.out.println("\n   Merci \n   -------   Fin de Programme   -------");
                    
                   break;
                }
                case 1: {
                    System.out.println("-----choix 1 : Creer la base de donnee Gestion_Stock ");
                    CreateDB.CreateDB();
                                        break;
                }
                case 2: {
                    System.out.println("-----choix 2 : Creer la table article ");
                    CreateArticle.createTable();
                    break;
                }
                case 3: {
                    System.out.println("-----choix 3 : Ajouter un article au stock");
                    System.out.print("nom_article:");
                    String nom_article = reader.readLine();

                    System.out.print("marque_article:");
                    String marque_article = reader.readLine();

                    System.out.print("type_article:");
                    String type_article = reader.readLine();

                    System.out.print("description:");
                    String description = reader.readLine();

                    System.out.print("prix_article:");
                    String prix_article = reader.readLine();
                    AjouterArticle.AjouterArticle(nom_article,marque_article,type_article,description,prix_article);
                    break;
                }
                case 4: {
                    System.out.println("-----choix 4 : Modifier le nom d'un article par id ");
                    System.out.print("nom_article:");
                    String nom_article = reader.readLine();
                    System.out.print("nom_article:");
                    int id_article = scanner.nextInt();
                    ModifierNom.ModifierNom(id_article, nom_article);
                    break;
                }
                case 5: {
                    System.out.println("-----choix 5 : Modifier la description d'un article par id ");
                    ModifierDescription.ModifierDescription(0, "");
                    break;
                }
                case 6: {
                    System.out.println("-----choix 6 : Modifier le prix de vente d'un article par id ");
                    ModifierPrix.ModifierPrix(0, "");
                    break;
                }
                case 7: {
                    System.out.println("-----choix 7 :Supprimer un article par id");
                    SupprimerArticle.SupprimerArticle();
                    break;
                }
                case 8: {
                    System.out.println("-----choix 8 : Rechercher un article par id");
                    
                    break;
                }
                case 9: {
                    System.out.println("-----choix 9 : Rechercher un article par nom");
                    RechercherId.RechercherId();
                    break;
                }
                case 10: {
                    System.out.println("-----choix 10 : Afficher tous les articles");
                    AfficherTous.AfficherTous();
                    break;
                }
                default : System.out.println("  Erreur, choix inconnu !!!!!   -------");
            }
        } while(choix !=0);	 	

      

    }
}
