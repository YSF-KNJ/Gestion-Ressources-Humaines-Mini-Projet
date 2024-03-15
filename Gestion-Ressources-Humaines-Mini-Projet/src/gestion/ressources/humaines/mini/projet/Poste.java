import java.sql.* ;
public class Poste {
    
    private int id_poste = 0;
    private String titre_poste = "";

    public void setTitre_poste(String titre_poste) {
        this.titre_poste = titre_poste;        
        try {
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         String Query = "INSERT INTO poste (titre_poste) VALUES (?)"; // Example INSERT query
         Connection conct = MySQLConnector.getConnection() ;
         PreparedStatement stmt = conct.prepareStatement(Query);
         stmt.setString(1, titre_poste);
         stmt.executeUpdate();
         conct.close();
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
    }

}