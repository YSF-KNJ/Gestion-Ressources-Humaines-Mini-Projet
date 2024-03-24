import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Admin {
    public static boolean CheckEmpty() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT COUNT(*) AS num FROM admin";
            Connection conct = MySQLConnector.getConnection();
            PreparedStatement stmt = conct.prepareStatement(Query);
            ResultSet resultSet = stmt.executeQuery();
            int rowCount = 0;
            if (resultSet.next()) {
                rowCount = resultSet.getInt("num");
            }
            conct.close();
            return rowCount == 0; 
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public static void addAdmin(String login, String password) throws ClassNotFoundException {
        Connection conct = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "INSERT INTO admin (login, password) VALUES (?, ?)";
            conct = MySQLConnector.getConnection();
            conct.setAutoCommit(false);
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setString(1,login);
            stmt.setString(2,password);
            stmt.executeUpdate();
            conct.commit();
            conct.close();
            System.out.println("Admin Ajoutée");
            System.out.println("--------------------------------");
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

