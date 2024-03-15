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

}