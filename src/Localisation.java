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

public class Localisation {
    public static boolean checkID(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
        Connection conct = null;
        try {
            String Query = "DELETE FROM localisation WHERE id_localisation = ?;";
            conct = MySQLConnector.getConnection();
            conct.setAutoCommit(false);
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            conct.commit();
            conct.close();
            System.out.println("Localisation avec l'ID " + id + " est supprimé.");
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


    public static int countLocalisation() {
        Connection conct = null;
        int count = 0;
        try {
            conct = MySQLConnector.getConnection();
            String query = "SELECT COUNT(*) AS total FROM localisation";
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


    public static String[][] getLocalisationsData() {
        String[][] data = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String query = "SELECT * FROM localisation";
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


    public static void updateLocalisation(int id, String adresse, String ville) throws ClassNotFoundException {
        Connection conct = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "UPDATE localisation SET adresse = ?,ville = ? WHERE id_localisation = ?";
            conct = MySQLConnector.getConnection();
            conct.setAutoCommit(false);
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setString(1, adresse.trim().toUpperCase());
            stmt.setString(2, ville.trim().toUpperCase());
            stmt.setInt(3, id);
            stmt.executeUpdate();
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

    public static void addLocalisation(String adresse, String ville) {
        Connection conct = null;
        try {
            String Query = "INSERT INTO localisation (adresse, ville) VALUES (?, ?);";
            conct = MySQLConnector.getConnection();
            conct.setAutoCommit(false);
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setString(1, adresse.trim().toUpperCase());
            stmt.setString(2, ville.trim().toUpperCase());
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

    public static void replaceLocalisations(int oldId, int newId) {
        Connection conct = null;
        try {
            String Query = "UPDATE departement SET id_localisation = ? WHERE id_localisation = ?";
            conct = MySQLConnector.getConnection();
            conct.setAutoCommit(false);
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setInt(1, newId);
            stmt.setInt(2, oldId);
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

    public static boolean isLocalisationOccupied(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
        }
        return false;
    }

    public static void addFromFile(FileInputStream file) {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            String adresse = parts[0];
            String ville = parts[1];
            addLocalisation(adresse, ville);
        }
    }

    public static void exportFileTxt(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT * FROM localisation";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                String line = resultSet.getString("adresse") + "," + resultSet.getString("ville");
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
            String Query = "SELECT * FROM localisation";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            ResultSet resultSet = stmt.executeQuery();
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Localisations");
            int rowNum = 0;
            while (resultSet.next()) {
                Row row = sheet.createRow(rowNum++);
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(resultSet.getString("adresse"));
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(resultSet.getString("ville"));


            }

            FileOutputStream fileOut = new FileOutputStream(fileName.trim());
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            conct.close();
        } catch (Exception e) {
            //
        }


    }

}
