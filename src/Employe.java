import java.sql.* ;
public class Employe {
    public static boolean checkID(int id) {
        try {
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         String Query = "SELECT COUNT(*) AS count FROM employes WHERE id_employe = ?";
         Connection conct = MySQLConnector.getConnection() ;
         PreparedStatement stmt = conct.prepareStatement(Query);
         stmt.setInt(1, id);
         ResultSet resultSet = stmt.executeQuery();
         if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
         conct.close();
        } catch (ClassNotFoundException | SQLException e) {
             System.out.println(e);
        }
        return false;
    }
     public static void getEmployes(){
        try {
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         String Query = "SELECT * FROM employes";
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
        } catch (ClassNotFoundException | SQLException e) {
             System.out.println(e);
        }
    }
    public static void addEmploye(String prenom, String nom, String email, String telephone, double salaire, int id_poste, int id_departement, int id_manager){
        try {
                Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
                String Query = "INSERT INTO employes (prenom, nom, email, telephone, salaire, id_poste, id_departement, id_manager) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";;
                Connection conct = MySQLConnector.getConnection() ;
                PreparedStatement stmt = conct.prepareStatement(Query);
                stmt.setString(1, prenom);
                stmt.setString(2, nom);
                stmt.setString(3, email);
                stmt.setString(4, telephone);
                stmt.setDouble(5, salaire);
                stmt.setInt(6, id_poste );
                stmt.setInt(7, id_departement);
                stmt.setInt(8, id_manager);
                stmt.executeUpdate();
                conct.close();
                System.out.println("L'employe a ete ajoute.");
            } catch (ClassNotFoundException | SQLException e) {
             System.out.println(e);
             }
    }
    public static void searchEmploye(int id) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
            String Query = "SELECT * FROM employes WHERE id_employe = ?";
            Connection conct = MySQLConnector.getConnection() ;
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                System.out.println("Employe trouve :");
                System.out.println("ID: " + resultSet.getInt("id_employe"));
                System.out.println("First Name: " + resultSet.getString("prenom"));
                System.out.println("Last Name: " + resultSet.getString("nom"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Phone: " + resultSet.getString("telephone"));
                System.out.println("Salary: " + resultSet.getDouble("salaire"));
                System.out.println("Post ID: " + resultSet.getInt("id_poste"));
                System.out.println("Department ID: " + resultSet.getInt("id_departement"));
                System.out.println("Manager ID: " + resultSet.getInt("id_manager"));
            } else {
                System.out.println("L'employe avec l'ID " + id + " est introuvable.");
            }
            conct.close();
        } catch (ClassNotFoundException | SQLException e) {
             System.out.println(e);
        }
    }
    public static void updateEmploye(int id, String prenom, String nom, String email, String telephone, double salaire, int id_poste, int id_departement, int id_manager){
        if (checkID(id)){
            try {
                Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
                String Query = "UPDATE employes SET prenom = ?, nom = ?, email = ?, telephone = ?, salaire = ?, id_poste = ?, id_departement = ?, id_manager = ? WHERE id_employe = ?";
                Connection conct = MySQLConnector.getConnection() ;
                PreparedStatement stmt = conct.prepareStatement(Query);
                stmt.setString(1, prenom);
                stmt.setString(2, nom);
                stmt.setString(3, email);
                stmt.setString(4, telephone);
                stmt.setDouble(5, salaire);
                stmt.setInt(6,id_poste );
                stmt.setInt(7, id_departement);
                stmt.setInt(8, id_manager);
                stmt.setInt(9, id); 
                stmt.executeUpdate();
                conct.close();
                System.out.println("Les informations de l'employe avec id"+id+" ont ete mises a jour avec succes");
            } catch (ClassNotFoundException | SQLException e) {
             System.out.println(e);
            }
        } else {
            System.out.println("L'Employe avec l'ID "+ id +" n'existe pas.");
        }
         
    }
    public static void deleteEmploye(int id){
        if (checkID(id)){
            try {
                Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
                String Query = "DELETE FROM employes WHERE id_employe = ?;";
                Connection conct = MySQLConnector.getConnection() ;
                PreparedStatement stmt = conct.prepareStatement(Query);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                conct.close();
                System.out.println("l'employe avec l'ID "+ id +" est supprime.");
            } catch (ClassNotFoundException | SQLException e) {
             System.out.println(e);
            }
            
        }
        else {
            System.out.println("l'employe avec l'ID "+ id +" n'existe pas.");
        }
        
    }
    public static void increaseSalary(int id, double amount) {
        if (checkID(id)){
            try {
                Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
                String Query = "UPDATE employes SET salaire = salaire + ? WHERE id_employe = ?";
                Connection conct = MySQLConnector.getConnection() ;
                PreparedStatement stmt = conct.prepareStatement(Query);
                stmt.setDouble(1, amount);
                stmt.setInt(2, id);
                stmt.executeUpdate();
                System.out.println("Le salaire de l'employe avec l'ID " + id + " a ete augmente.");
            } catch (ClassNotFoundException | SQLException e) {
             System.out.println(e);
            }
        } else {
            System.out.println("L'Employe avec l'ID "+ id +" n'existe pas.");
        }
    }
}



