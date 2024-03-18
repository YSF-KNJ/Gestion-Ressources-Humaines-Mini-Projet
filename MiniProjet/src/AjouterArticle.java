import java.util.* ;
import java.sql.* ;
import java.io.* ;
import com.mysql.jdbc.Driver.*;

public class AjouterArticle {
   public static void AjouterArticle(String nom_article,String marque_article,String type_article,String description_article,String prix_article)
   {
    try
    {
       Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
       String protocole =  "jdbc:mysql:" ;
       String ip =  "localhost" ;  
       String port =  "3306" ;  
       String conString = protocole +  "//" + ip +  ":" + port + "/gestion_stock";
       String nomConnexion =  "root" ;  
       String motDePasse =  "root" ; 
       Connection conct = DriverManager.getConnection(
          conString, nomConnexion, motDePasse) ;
      Statement stmt = conct.createStatement();
      System.out.println("\nInsertion des donnees dans la table...");
      String sql = "INSERT INTO article (nom_article, marque_article, type_article, description_article, prix_article)" +
             "VALUES ('"+nom_article+"', '"+marque_article+"','"+type_article+"','"+description_article+"','"+prix_article+"')";
       stmt.executeUpdate(sql);
       System.out.println("Les donnees d'article ajoutees dans table article avec success...");
       conct.close();
    }  catch (Exception e) {
       System.out.println(e);
    }
   }
}