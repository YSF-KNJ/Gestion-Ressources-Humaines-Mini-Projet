import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFrame extends BaseFrame {
    Color secondaryColor = new Color(32, 201, 151);
    Color primaryColor = new Color(249, 170, 51);
    Font font = new Font("cairo", Font.BOLD, 22);


    public LoginFrame() {
        this.setLayout(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);


        JLabel titleLabel = new JLabel("BIENVENUE AU PROGRAMME!");
        titleLabel.setBounds(250, 40, 300, 60);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel usernameLabel = new JLabel("login:");
        usernameLabel.setBounds(300, 170, 200, 30);
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel passwordLabel = new JLabel("password:");
        passwordLabel.setBounds(300, 260, 200, 30);
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(250, 200, 300, 50);
        usernameField.setFont(font);


        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(250, 290, 300, 50);
        passwordField.setFont(font);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(300, 380, 180, 40);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                username.replace("'", "\"");
                String password = new String(passwordField.getPassword());
                try {
                    Class c = Class.forName("com.mysql.cj.jdbc.Driver");
                    String Query = "SELECT * FROM admin WHERE login = ? AND password = ?";
                    Connection conct = MySQLConnector.getConnection();
                    ResultSet resultSet;
                    PreparedStatement stmt = conct.prepareStatement(Query);
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    resultSet = stmt.executeQuery();
                    int counttimes = 0;
                    if (resultSet.next()) {
                        HomeFrame homeFrame = new HomeFrame();
                        dispose();
                        homeFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "identifiant ou mot de passe incorrect");
                    }
                    conct.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    dispose();
                }
            }
        });

        CloseButton closeButton = new CloseButton(this);


        this.add(titleLabel);
        this.add(usernameLabel);
        this.add(passwordLabel);
        this.add(usernameField);
        this.add(passwordField);
        this.add(loginButton);
        this.add(closeButton);

    }
}
