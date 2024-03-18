import java.util.* ;
import java.sql.* ;
import java.io.* ;
import com.mysql.jdbc.Driver.*;

public class ModifierPrix {
   public static void ModifierPrix(int id_article,String prix_article)
   {
    try
    {
       Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
       String protocole =  "jdbc:mysql:" ;
       String ip =  "localhost" ;  
       String port =  "3306" ;  
       String conString = protocole +  "//" + ip +  ":" + port ;
       String nomConnexion =  "root" ;  
       String motDePasse =  "root" ; 
       Connection conct = DriverManager.getConnection(
          conString, nomConnexion, motDePasse) ;
      Statement stmt = conct.createStatement();
      System.out.println("\nModification de le prix...");
      stmt.executeUpdate("UPDATE STUDENT SET prix_article = '"+prix_article+"' WHERE id_article = '"+id_article+"'");
      System.out.println("Prix modifiee avec success...\n\n");
       conct.close();
    }  catch (Exception e) {
       System.out.println(e);
    }
   }
}
