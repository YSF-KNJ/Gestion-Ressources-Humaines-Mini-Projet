import java.sql.*;

public class MySQLConnector {
    private static final String protocole = "jdbc:mysql:";
    private static final String ip = "localhost";  // dépend du contexte
    private static final String port = "3306";  // port MySQL par défaut
    private static final String nomBase = "HR";  // dépend du contexte
    private static final String conString = protocole + "//" + ip + ":" + port + "/" + nomBase;
    private static final String nomConnexion = "root";  // dépend du contexte
    private static final String motDePasse = "root";  // dépend du contexte

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(conString, nomConnexion, motDePasse);
    }
}