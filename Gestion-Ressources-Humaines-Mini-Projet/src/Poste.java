import java.sql.* ;
public class Poste {
    public static boolean checkID(int id) {
        try {
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         String Query = "SELECT COUNT(*) AS count FROM poste WHERE id_poste = ?";
         Connection conct = MySQLConnector.getConnection() ;
         PreparedStatement stmt = conct.prepareStatement(Query);
         stmt.setInt(1, id);
         ResultSet resultSet = stmt.executeQuery();
         if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
         conct.close();
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
        return false;
    }
    public static void deletePoste(int id){
        if (checkID(id)){
            try {
                Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
                String Query = "DELETE FROM poste WHERE id_poste = ?;";
                Connection conct = MySQLConnector.getConnection() ;
                PreparedStatement stmt = conct.prepareStatement(Query);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                conct.close();
                System.out.println("Poste avec l'ID "+ id +" est supprimé.");
            }  catch (Exception e) {
                // gestion des exceptions
                System.out.println(e);
            }
            
        }
        else {
            System.out.println("Poste avec l'ID "+ id +" n'existe pas.");
        }
        
    }
    public static void updatePost(int id , String title){
        if (checkID(id)){
            try {
                Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
                String Query = "UPDATE poste SET titre_poste = ? WHERE id_poste = ?";
                Connection conct = MySQLConnector.getConnection() ;
                PreparedStatement stmt = conct.prepareStatement(Query);
                stmt.setString(1, title);
                stmt.setInt(2, id);
                stmt.executeUpdate();
                conct.close();
                System.out.println("Poste avec l'ID "+ id +" a été mis à jour..");
            }  catch (Exception e) {
                // gestion des exceptions
                System.out.println(e);
            }
        } else {
            System.out.println("Poste avec l'ID "+ id +" n'existe pas.");
        }
         
    }
    public static void addPost(String title){
        try {
                Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
                String Query = "INSERT INTO poste (titre_poste) VALUES (?);";
                Connection conct = MySQLConnector.getConnection() ;
                PreparedStatement stmt = conct.prepareStatement(Query);
                stmt.setString(1, title);
                stmt.executeUpdate();
                conct.close();
                System.out.println("Ajoutée");
            }  catch (Exception e) {
                // gestion des exceptions
                System.out.println(e);
            }
    }
    public static void getPostes(){
        try {
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         String Query = "SELECT * FROM poste";
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
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
    
    
    }

}