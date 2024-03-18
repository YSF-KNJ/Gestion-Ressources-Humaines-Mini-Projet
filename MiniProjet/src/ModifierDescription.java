import java.util.* ;
import java.sql.* ;
import java.io.* ;
import com.mysql.jdbc.Driver.*;

public class ModifierDescription {
   public static void ModifierDescription(int id_article,String description_article)
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
      System.out.println("\nModefication de la description...");
      stmt.executeUpdate("UPDATE STUDENT SET description_article = '"+description_article+"' WHERE id_article = '"+id_article+"'");
      System.out.println("Description modifiee avec success...\n\n");
       conct.close();
    }  catch (Exception e) {
       System.out.println(e);
    }
   }
}

