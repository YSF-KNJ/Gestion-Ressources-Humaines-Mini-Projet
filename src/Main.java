import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws IOException {
        Createdb.createdb();
        Createtables.createtables();
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("login : ");
        String login = reader.readLine();
        login.replace("'", "\"");
        System.out.print("password : ");
        String password = reader.readLine();
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            String Query = "SELECT * FROM admin WHERE login = ? AND password = ?";
            Connection conct = MySQLConnector.getConnection();
            ResultSet resultSet;
            PreparedStatement stmt = conct.prepareStatement(Query);
            stmt.setString(1, login);
            stmt.setString(2, password);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                        System.out.println("Bonjour, administrateur");
                        Menu m = new Menu();
                        m.run();
                    } else {
                        System.out.println("identifiant ou mot de passe incorrect");
                    }
            conct.close();
        } catch (Exception e) {
            // gestion des exceptions
            System.out.println(e);
        }
        scanner.close();
        reader.close();
    }
}
