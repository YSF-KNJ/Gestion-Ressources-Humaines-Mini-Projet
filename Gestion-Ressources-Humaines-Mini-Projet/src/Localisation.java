import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Localisation {
        public static boolean checkID(int id) {
        try {
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         String Query = "SELECT COUNT(*) AS count FROM localisation WHERE id_poste = ?";
         Connection conct = MySQLConnector.getConnection() ;
         PreparedStatement stmt = conct.prepareStatement(Query);
         stmt.setInt(1, id);
         ResultSet resultSet = stmt.executeQuery();
         if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
         conct.close();
      }  catch (ClassNotFoundException | SQLException e) {
         // gestion des exceptions
         System.out.println(e);
      }
        return false;
    }
        public static void deleteLocalisation(int id){
            try {
                Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
                String Query = "DELETE FROM localisation WHERE id_localisation = ?;";
                Connection conct = MySQLConnector.getConnection() ;
                PreparedStatement stmt = conct.prepareStatement(Query);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                conct.close();
                System.out.println("Localisation avec l'ID "+ id +" est supprimé.");
            }  catch (ClassNotFoundException | SQLException e) {
                // gestion des exceptions
                System.out.println(e);
            }
        
    }
        public static void getLocalisations(){
        try {
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         String Query = "SELECT * FROM localisation";
         Connection conct = MySQLConnector.getConnection() ;
         PreparedStatement stmt = conct.prepareStatement(Query);
         ResultSet resultSet = stmt.executeQuery();
         ResultSetMetaData metaData = resultSet.getMetaData();
         int columnCount = metaData.getColumnCount();
         // Printing data
         while (resultSet.next()) {
             for (int i = 1; i <= columnCount; i++) {
                 System.out.print(resultSet.getString(i) + "  ");
             }
                System.out.println();
            }
         conct.close();
      }  catch (ClassNotFoundException | SQLException e) {
         // gestion des exceptions
         System.out.println(e);
      }
    
    
    }
        public static void updateLocalisation(int id , String adresse, String ville){
            try {
                Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
                String Query = "UPDATE localisation SET adresse = ?,ville = ? WHERE id_poste = ?";
                Connection conct = MySQLConnector.getConnection() ;
                PreparedStatement stmt = conct.prepareStatement(Query);
                stmt.setString(1, adresse.trim().toUpperCase());
                stmt.setString(2, ville.trim().toUpperCase());
                stmt.setInt(3, id);
                stmt.executeUpdate();
                conct.close();
                System.out.println("Localisation avec l'ID "+ id +" a été mis à jour..");
            }  catch (ClassNotFoundException | SQLException e) {
                // gestion des exceptions
                System.out.println(e);
            }     
    }
        public static void addLocalisation(String adresse, String ville) {
        try {
                Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
                String Query = "INSERT INTO localisation (adresse, ville) VALUES (?, ?);";

                Connection conct = MySQLConnector.getConnection() ;
                PreparedStatement stmt = conct.prepareStatement(Query);
                stmt.setString(1,adresse.trim().toUpperCase());
                stmt.setString(2,ville.trim().toUpperCase());

                stmt.executeUpdate();
                conct.close();
                System.out.println("Localisation Ajoutée");
            }  catch (ClassNotFoundException | SQLException e) {
                // gestion des exceptions
                System.out.println(e);
            }
    }
}
