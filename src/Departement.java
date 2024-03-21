import static Localisation.addLocalisation;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.*;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Departement {
    public static boolean checkID(int id) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT COUNT(*) AS count FROM departement WHERE id_departement = ?";
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

    public static void deleteDepartement(int id) {
        if (checkID(id)) {
            try {
                Class c = Class.forName("com.mysql.cj.jdbc.Driver");
                String Query = "DELETE FROM departement WHERE id_departement = ?;";
                Connection conct = MySQLConnector.getConnection();
                PreparedStatement stmt = conct.prepareStatement(Query);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                conct.close();
                System.out.println("Departement avec l'ID " + id + " est supprimé.");
            } catch (ClassNotFoundException | SQLException e) {
                // gestion des exceptions
                System.out.println(e);
            }

        } else {
            System.out.println("Departement avec l'ID " + id + " n'existe pas.");
        }

    }

    public static void updateDepartement(int id, String nom_Departement, int id_localisation) {
        if (checkID(id)) {
            try {
                Class c = Class.forName("com.mysql.cj.jdbc.Driver");
                String Query = "UPDATE  departement SET nom_departement = ? , id_localisation = ? WHERE id_departement = ?";
                Connection conct = MySQLConnector.getConnection();
                PreparedStatement stmt = conct.prepareStatement(Query);
                stmt.setString(1, nom_Departement);
                stmt.setInt(2, id_localisation);
                stmt.setInt(3, id);
                stmt.executeUpdate();
                conct.close();
                System.out.println("departement avec l'ID " + id + " a été mis à jour..");
            } catch (ClassNotFoundException | SQLException e) {
                // gestion des exceptions
                System.out.println(e);
            }
        } else {
            System.out.println("departement avec l'ID " + id + " n'existe pas.");
        }

    }

    public static void addDepartement(String nom_Departement, int id_localisation) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "INSERT INTO departement (nom_Departement,id_localisation) VALUES (? , ? );";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setString(1, nom_Departement.trim().toUpperCase());
            stmt.setInt(2, id_localisation);
            stmt.executeUpdate();
            conct.close();
            System.out.println("Ajoutée");
        } catch (ClassNotFoundException | SQLException e) {
            // gestion des exceptions
            System.out.println(e);
        }
    }

    public static void getDepartement() {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT * FROM departement";
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

    public static void replaceDepartements(int oldId, int newId) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "UPDATE employes SET id_departement = ? WHERE id_departement = ?";
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

    public static boolean isDepartmentOccupied(int id) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT COUNT(*) AS count FROM employes WHERE id_departement = ?";
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
                String nom_departement = parts[0];
                int id_localisation = Integer.parseInt(parts[1]);
                addDepartement(nom_departement,id_localisation);
        }
        System.out.println("done");
    }
    
    public static void exportFileTxt(String fileName){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName+".txt"));        
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT * FROM departement";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                String line = resultSet.getString("nom_departement") + ", " + resultSet.getString("id_localisation");
                writer.write(line);
                writer.newLine(); 
                
            }
            writer.close();
            conct.close();
            } catch(Exception e){
                System.out.println(e);
            }
    }
    
    public static void exportFileXls(String fileName){
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT * FROM departement";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            ResultSet resultSet = stmt.executeQuery();
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Departements");
            int rowNum = 0;
            while (resultSet.next()) {
                Row row = sheet.createRow(rowNum++);
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(resultSet.getString("nom_departement"));
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(resultSet.getString("id_localisation"));


            }
            
            FileOutputStream fileOut = new FileOutputStream(fileName.trim()+".xls");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            conct.close();
            } catch(Exception e){
                System.out.println(e);
            }
        
        
    }

}