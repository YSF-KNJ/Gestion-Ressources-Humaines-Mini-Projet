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

public class Departement {
    public static boolean checkID(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
        }
        return false;
    }

    public static void deleteDepartement(int id) throws ClassNotFoundException {
        if (checkID(id)) {
            Connection conct = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String Query = "DELETE FROM departement WHERE id_departement = ?;";
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

    }

    public static int countDepartement() {
        Connection conct = null;
        int count = 0;
        try {
            conct = MySQLConnector.getConnection();
            String query = "SELECT COUNT(*) AS total FROM departement";
            PreparedStatement stmt = conct.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt("total");
            }
            return count;
        } catch (SQLException e) {
            // do chi l3ba
        }
        return count;
    }


    public static void updateDepartement(int id, String nom_Departement, int id_localisation) throws ClassNotFoundException {
        if (checkID(id)) {
            Connection conct = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String Query = "UPDATE  departement SET nom_departement = ? , id_localisation = ? WHERE id_departement = ?";
                conct = MySQLConnector.getConnection();
                conct.setAutoCommit(false);
                PreparedStatement stmt = conct.prepareStatement(Query);
                stmt.setString(1, nom_Departement);
                stmt.setInt(2, id_localisation);
                stmt.setInt(3, id);
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
    }

    public static void addDepartement(String nom_Departement, int id_localisation) {
        Connection conct = null;
        try {
            String Query = "INSERT INTO departement (nom_Departement,id_localisation) VALUES (? , ? );";
            conct = MySQLConnector.getConnection();
            conct.setAutoCommit(false);
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setString(1, nom_Departement.trim().toUpperCase());
            stmt.setInt(2, id_localisation);
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

    public static String[][] getDepartementData() {
        String[][] data = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String query = "SELECT * FROM departement";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = stmt.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            int rowCount = 0;
            if (resultSet.last()) {
                rowCount = resultSet.getRow();
                resultSet.beforeFirst();
            }

            data = new String[rowCount][columnCount];

            int row = 0;
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    data[row][i - 1] = resultSet.getString(i);
                }
                row++;
            }

            conct.close();
        } catch (ClassNotFoundException | SQLException e) {
            //
        }
        return data;
    }


    public static void replaceDepartements(int oldId, int newId) throws ClassNotFoundException {
        Connection conct = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "UPDATE employes SET id_departement = ? WHERE id_departement = ?";
            conct = MySQLConnector.getConnection();
            conct.setAutoCommit(false);
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setInt(1, newId);
            stmt.setInt(2, oldId);
            stmt.executeUpdate();
            conct.commit();
            conct.close();
            //
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

    public static boolean isDepartmentOccupied(int id) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
        } catch (SQLException e) {
            // gestion des exceptions
        }
        return false;
    }

    public static void addFromFile(FileInputStream file) throws ClassNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            String nom_departement = parts[0];
            int id_localisation = Integer.parseInt(parts[1]);
            addDepartement(nom_departement, id_localisation);
        }

    }

    public static void exportFileTxt(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
            Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT * FROM departement";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                String line = resultSet.getString("nom_departement") + "," + resultSet.getString("id_localisation");
                writer.write(line);
                writer.newLine();

            }
            writer.close();
            conct.close();
        } catch (Exception e) {
            //
        }
    }

    public static void exportFileXls(String fileName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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

            FileOutputStream fileOut = new FileOutputStream(fileName.trim() + ".xls");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            conct.close();
        } catch (Exception e) {
            //
        }
    }

}