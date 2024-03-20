import java.io.FileInputStream;
import java.sql.*;
import java.util.Scanner;

public class Localisation {
    public static boolean checkID(int id) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT COUNT(*) AS count FROM localisation WHERE id_localisation = ?";
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

    public static void deleteLocalisation(int id) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "DELETE FROM localisation WHERE id_localisation = ?;";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            conct.close();
            System.out.println("Localisation avec l'ID " + id + " est supprimé.");
        } catch (ClassNotFoundException | SQLException e) {
            // gestion des exceptions
            System.out.println(e);
        }

    }

    public static void getLocalisations() {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT * FROM localisation";
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

    public static void updateLocalisation(int id, String adresse, String ville) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "UPDATE localisation SET adresse = ?,ville = ? WHERE id_localisation = ?";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setString(1, adresse.trim().toUpperCase());
            stmt.setString(2, ville.trim().toUpperCase());
            stmt.setInt(3, id);
            stmt.executeUpdate();
            conct.close();
            System.out.println("Localisation avec l'ID " + id + " a été mis à jour..");
        } catch (ClassNotFoundException | SQLException e) {
            // gestion des exceptions
            System.out.println(e);
        }
    }

    public static void addLocalisation(String adresse, String ville) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "INSERT INTO localisation (adresse, ville) VALUES (?, ?);";

            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setString(1, adresse.trim().toUpperCase());
            stmt.setString(2, ville.trim().toUpperCase());

            stmt.executeUpdate();
            conct.close();
            System.out.println("Localisation Ajoutée");
        } catch (ClassNotFoundException | SQLException e) {
            // gestion des exceptions
            System.out.println(e);
        }
    }

    public static void replaceLocalisations(int oldId, int newId) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "UPDATE departement SET id_localisation = ? WHERE id_localisation = ?";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setInt(1, newId);
            stmt.setInt(2, oldId);
            stmt.executeUpdate();
            conct.close();
            System.out.println("les departements sont remplacés");
        } catch (ClassNotFoundException | SQLException e) {
            // gestion des exceptions
            System.out.println(e);
        }
    }

    public static boolean isLocalisationOccupied(int id) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT COUNT(*) AS count FROM departement WHERE id_localisation = ?";
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
                String[] parts = line.split(",");
                String adresse = parts[0];
                String ville = parts[1];
                addLocalisation(adresse,ville);
        }
        System.out.println("done");
    }

}
