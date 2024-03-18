import java.util.* ;
import java.sql.* ;
import java.io.* ;
import com.mysql.jdbc.Driver.*;

public class RechercherId {
   public static void RechercherId()
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
      System.out.println("\nCreation de la base de donnees...");
      stmt.executeUpdate("CREATE DATABASE Gestion_Stock;");
      System.out.println("Base de donnees Gestion_Stock cree avec success...\n\n");
       conct.close();
    }  catch (Exception e) {
       System.out.println(e);
    }
   }
}

