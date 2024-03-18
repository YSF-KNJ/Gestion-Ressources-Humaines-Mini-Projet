import java.util.* ;
import java.sql.* ;
import java.io.* ;
import com.mysql.jdbc.Driver.*;

public class AfficherTous {
   public static void AfficherTous()
   {
    try
    {
       Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
       String protocole =  "jdbc:mysql:" ;
       String ip =  "10.18.1.1" ;  
       String port =  "3306" ;  
       String conString = protocole +  "//" + ip +  ":" + port ;
       String nomConnexion =  "root" ;  
       String motDePasse =  "FSTet.23" ; 
       Connection conct = DriverManager.getConnection(
          conString, nomConnexion, motDePasse) ;
      Statement stmt = conct.createStatement();
      System.out.println("\nAffichage toute les articles...");
      String sql = "SELECT id_article, nom_article, marque_article, type_article, description_article, prix_article FROM student" +
      " ORDER BY nom_article ASC";
      ResultSet res = stmt.executeQuery(sql) ;
      System.out.println("Liste Des �tudiants Inscrits \n");
      System.out.print("id_article\t|\tnom_article\t\t|\tmarque_article\t\t|\ttype_article\t\t|\tdescription_article\t\t|\tprix_article\n");
      System.out.println("-------------------------------------------------------------------");
      while (res.next()) {
        int id = res.getInt("id_article");
        String nom = res.getString("nom_article ");
        String marque = res.getString("marque_article");
        String type = res.getString("type_article ");
        String description = res.getString("description_article ");
        String prix = res.getString("prix_article ");
        //Afficher les valeurs
        System.out.print(" " + id + "\t|\t");
        System.out.print(nom + "\t|\t");
        System.out.print(marque + "\t|\t");
        System.out.print(type + "\t|\t");
        System.out.print(description + "\t|\t");
        System.out.println(prix);
      }
       conct.close();
    }  catch (Exception e) {
       System.out.println(e);
    }
   }
}

