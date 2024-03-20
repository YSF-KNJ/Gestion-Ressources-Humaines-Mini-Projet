import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.sql.*;
import java.util.Scanner;

public class Poste {
    public static boolean checkID(int id) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT COUNT(*) AS count FROM poste WHERE id_poste = ?";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
            conct.close();
        } catch (ClassNotFoundException | SQLException e) {
            // gestion des exceptions
            System.out.println(e);
        }
        return false;
    }

    public static void deletePoste(int id) {
        try {

            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "DELETE FROM poste WHERE id_poste = ?;";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            conct.close();
            System.out.println("Poste avec l'ID " + id + " est supprimé.");
        } catch (ClassNotFoundException | SQLException e) {
            // gestion des exceptions
            System.out.println(e);
        }

    }

    public static void updatePost(int id, String title) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "UPDATE poste SET titre_poste = ? WHERE id_poste = ?";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setString(1, title.trim().toUpperCase());
            stmt.setInt(2, id);
            stmt.executeUpdate();
            conct.close();
            System.out.println("Poste avec l'ID " + id + " a été mis à jour..");
        } catch (ClassNotFoundException | SQLException e) {
            // gestion des exceptions
            System.out.println(e);
        }

    }

    public static void addPost(String title) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "INSERT INTO poste (titre_poste) VALUES (?);";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setString(1, title.trim().toUpperCase());
            stmt.executeUpdate();
            conct.close();
            System.out.println("Poste Ajoutée");
        } catch (ClassNotFoundException | SQLException e) {
            // gestion des exceptions
            System.out.println(e);
        }
    }

    public static void getPostes() {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT * FROM poste";
            Connection conct = MySQLConnector.getConnection();
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
            // gestion des exceptions
            System.out.println(e);
        }


    }

    public static void replacePosts(int oldId, int newId) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "UPDATE employes SET id_poste = ? WHERE id_poste = ?";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setInt(1, newId);
            stmt.setInt(2, oldId);
            stmt.executeUpdate();
            conct.close();
            System.out.println("les postes sont remplacés");
        } catch (ClassNotFoundException | SQLException e) {
            // gestion des exceptions
            System.out.println(e);
        }
    }

    public static boolean isPosteOccupied(int id) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT COUNT(*) AS count FROM employes WHERE id_poste = ?";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
            conct.close();
        } catch (Exception e) {
            // gestion des exceptions
            System.out.println(e);
        }
        return false;
    }
    
    public static void addFromFile(FileInputStream file){
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                addPost(line.trim());
        }
        System.out.println("done");
    }
    
    public static void exportFile(String fileName){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));        
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT * FROM poste";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                String line = resultSet.getString("titre_poste");
                writer.write(line);
                writer.newLine(); 
                
            }
            writer.close();
            conct.close();
            } catch(Exception e){
                System.out.println(e);
            }
    }

}
