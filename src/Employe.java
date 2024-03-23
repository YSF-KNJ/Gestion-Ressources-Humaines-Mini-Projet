import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.*;
import java.util.Scanner;

public class Employe {
    public static boolean checkID(int id) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT COUNT(*) AS count FROM employes WHERE id_employe = ?";
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
            System.out.println(e);
        }
        return false;
    }

    public static void getEmployes() {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT * FROM employes";
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
            System.out.println(e);
        }
    }

    public static void addManger(String prenom, String nom, String email, String telephone, double salaire, int id_poste, int id_departement) {
        Connection conct = null;
        try {
            String Query = "INSERT INTO employes (prenom, nom, email, telephone, salaire, id_poste, id_departement) VALUES (?, ?, ?, ?, ?, ?, ?)";
            conct = MySQLConnector.getConnection();
            conct.setAutoCommit(false);
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setString(1, prenom);
            stmt.setString(2, nom);
            stmt.setString(3, email);
            stmt.setString(4, telephone);
            stmt.setDouble(5, salaire);
            stmt.setInt(6, id_poste);
            stmt.setInt(7, id_departement);
            stmt.executeUpdate();
            conct.commit();
            conct.close();
        } catch (SQLException e) {
            if (conct != null) {
                try {
                    conct.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void addEmploye(String prenom, String nom, String email, String telephone, double salaire, int id_poste, int id_departement, int id_manager) {
        Connection conct = null;
        try {
            String Query = "INSERT INTO employes (prenom, nom, email, telephone, salaire, id_poste, id_departement, id_manager) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            conct = MySQLConnector.getConnection();
            conct.setAutoCommit(false);
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setString(1, prenom);
            stmt.setString(2, nom);
            stmt.setString(3, email);
            stmt.setString(4, telephone);
            stmt.setDouble(5, salaire);
            stmt.setInt(6, id_poste);
            stmt.setInt(7, id_departement);
            stmt.setInt(8, id_manager);
            stmt.executeUpdate();
            conct.commit();
            conct.close();
        } catch (SQLException e) {
            if (conct != null) {
                try {
                    conct.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void searchEmploye(int id) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT * FROM employes WHERE id_employe = ?";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_employe"));
                System.out.println("First Name: " + resultSet.getString("prenom"));
                System.out.println("Last Name: " + resultSet.getString("nom"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Phone: " + resultSet.getString("telephone"));
                System.out.println("Salary: " + resultSet.getDouble("salaire"));
                System.out.println("Post ID: " + resultSet.getInt("id_poste"));
                System.out.println("Department ID: " + resultSet.getInt("id_departement"));
                System.out.println("Manager ID: " + resultSet.getInt("id_manager"));
            }
            conct.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public static void updateEmploye(int id, String prenom, String nom, String email, String telephone, double salaire, int id_poste, int id_departement, int id_manager) {
        Connection conct = null;
        if (checkID(id)) {
            try {
                String Query = "UPDATE employes SET prenom = ?, nom = ?, email = ?, telephone = ?, salaire = ?, id_poste = ?, id_departement = ?, id_manager = ? WHERE id_employe = ?";
                conct = MySQLConnector.getConnection();
                conct.setAutoCommit(false);
                PreparedStatement stmt = conct.prepareStatement(Query);
                stmt.setString(1, prenom);
                stmt.setString(2, nom);
                stmt.setString(3, email);
                stmt.setString(4, telephone);
                stmt.setDouble(5, salaire);
                stmt.setInt(6, id_poste);
                stmt.setInt(7, id_departement);
                stmt.setInt(8, id_manager);
                stmt.setInt(9, id);
                stmt.executeUpdate();
                conct.commit();
                conct.close();
            } catch (SQLException e) {
                if (conct != null) {
                    try {
                        conct.rollback();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("L'Employe avec l'ID " + id + " n'existe pas.");
        }

    }

    public static boolean isManager(int id) {
        try {
            String query = "SELECT COUNT(*) AS count FROM employes WHERE id_manager = ?";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static void replaceManager(int newManagerId, int oldManagerId) {
        Connection conct = null;
        try {
            String query = "UPDATE employes SET id_manager = ? WHERE id_manager = ?";
            conct = MySQLConnector.getConnection();
            conct.setAutoCommit(false);
            PreparedStatement stmt = conct.prepareStatement(query);
            stmt.setInt(1, newManagerId);
            stmt.setInt(2, oldManagerId);
            stmt.executeUpdate();
            conct.commit();
            conct.close();
            deleteEmploye(oldManagerId);
        } catch (SQLException e) {
            if (conct != null) {
                try {
                    conct.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void deleteEmploye(int id) {
        Connection conct = null;
        try {
            String Query = "DELETE FROM employes WHERE id_employe = ?;";
            conct = MySQLConnector.getConnection();
            conct.setAutoCommit(false);
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            conct.commit();
            conct.close();
        } catch (SQLException e) {
            if (conct != null) {
                try {
                    conct.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void increaseSalary(int id, double amount) {
        Connection conct = null;
        try {
            String Query = "UPDATE employes SET salaire = salaire + ? WHERE id_employe = ?";
            conct = MySQLConnector.getConnection();
            conct.setAutoCommit(false);
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setDouble(1, amount);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            conct.commit();
            conct.close();
        } catch (SQLException e) {
            if (conct != null) {
                try {
                    conct.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void addFromFile(FileInputStream file) {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            String prenom = parts[0];
            String nom = parts[1];
            String email = parts[2];
            String telephone = parts[3];
            double salaire = Double.parseDouble(parts[4]);
            int id_poste = Integer.parseInt(parts[5]);
            int id_departement = Integer.parseInt(parts[6]);
            int id_manager = Integer.parseInt(parts[6]);
            addEmploye(prenom, nom, email, telephone, salaire, id_poste, id_departement, id_manager);

        }
        System.out.println("done");
    }

    public static void exportFileTxt(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT * FROM employes";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                String line = resultSet.getString("prenom") + "," + resultSet.getString("nom") + "," + resultSet.getString("email") + "," + resultSet.getString("telephone") + "," + resultSet.getString("salaire") + "," + resultSet.getString("id_poste") + "," + resultSet.getString("id_departement") + "," + resultSet.getString("id_manager");
                writer.write(line);
                writer.newLine();

            }
            writer.close();
            conct.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void exportFileXls(String fileName) {
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT * FROM employes";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            ResultSet resultSet = stmt.executeQuery();
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Employes");
            int rowNum = 0;
            while (resultSet.next()) {
                Row row = sheet.createRow(rowNum++);
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(resultSet.getString("prenom"));
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(resultSet.getString("nom"));
                Cell cell2 = row.createCell(2);
                cell2.setCellValue(resultSet.getString("email"));
                Cell cell3 = row.createCell(3);
                cell3.setCellValue(resultSet.getString("telephone"));
                Cell cell4 = row.createCell(4);
                cell4.setCellValue(resultSet.getString("salaire"));
                Cell cell5 = row.createCell(5);
                cell5.setCellValue(resultSet.getString("id_poste"));
                Cell cell6 = row.createCell(6);
                cell6.setCellValue(resultSet.getString("id_departement"));
                Cell cell7 = row.createCell(7);
                cell7.setCellValue(resultSet.getString("id_manager"));


            }

            FileOutputStream fileOut = new FileOutputStream(fileName.trim() + ".xls");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            conct.close();
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}