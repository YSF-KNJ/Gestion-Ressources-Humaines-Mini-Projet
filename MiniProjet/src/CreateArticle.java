//package App;
import java.util.* ;
import java.sql.* ;
import java.io.* ;
import com.mysql.jdbc.Driver.*;

public class CreateArticle {
   public static void createTable()
   {
    try
    {
       Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
       String protocole =  "jdbc:mysql:" ;
       String ip =  "localhost" ;  
       String port =  "3306" ;  
       String conString = protocole +  "//" + ip +  ":" + port + "/gestion_stock" ;
       String nomConnexion =  "root" ;  
       String motDePasse =  "root" ; 
       Connection conct = DriverManager.getConnection(conString, nomConnexion, motDePasse) ;
      Statement stmt = conct.createStatement();
      System.out.println("\nCreation de la table article...");
      stmt.executeUpdate("CREATE TABLE IF NOT EXISTS article(id_article int AUTO_INCREMENT NOT NULL PRIMARY KEY,nom_article varchar(30) NOT NULL,marque_article varchar(30) NOT NULL,type_article varchar(30) NOT NULL,description_article varchar(30) NOT NULL,prix_article varchar(30) NOT NULL);");
      System.out.println("La table article cree avec success...\n\n");
       conct.close();
    }  catch (Exception e) {
       System.out.println(e);
    }
   }
}
