import java.util.* ;
import java.sql.* ;
import java.io.* ;
import com.mysql.jdbc.Driver.*;

public class ModifierNom {
   public static void ModifierNom(int id_article,String nom_article)
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
      System.out.println("\nModefication de le nom...");
      stmt.executeUpdate("UPDATE article SET nom_article = '"+nom_article+"' WHERE id_article = '"+id_article+"'");
      System.out.println("Nom modifiee avec success...\n\n");
       conct.close();
    }  catch (Exception e) {
       System.out.println(e);
    }
   }
}

