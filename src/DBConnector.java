import java.sql.* ;

public class DBConnector {

    public static void insertQuery(String query)
    {
       try {

         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         //String protocole =  "jdbc:mysql:" ;
         //String ip =  "localhost" ;  // dépend du contexte
         //String port =  "3306" ;  // port MySQL par défaut
         //String conString = protocole +  "//" + ip +  ":" + port ;
         String conString = "jdbc:mysql://localhost:3306/HR"; 
         String nomConnexion =  "wassima" ;  // dépend du contexte
         String motDePasse =  "admin" ;  // dépend du contexte
         Connection conct = DriverManager.getConnection(conString, nomConnexion, motDePasse) ;
         Statement stmt = conct.createStatement();
         stmt.executeUpdate(query);
         conct.close();
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
    }
}