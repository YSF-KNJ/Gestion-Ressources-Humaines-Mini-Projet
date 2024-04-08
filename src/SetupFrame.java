import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetupFrame extends BaseFrame {
    Font font = new Font("cairo", Font.BOLD, 22);

    public SetupFrame() {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(null);

        JLabel titleLabel = new JLabel("INSTALLATION!");
        titleLabel.setBounds(250, 40, 300, 60);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(font);

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

        JButton loginButton = new JButton("REGISTER");
        loginButton.setBounds(300, 380, 180, 40);
        loginButton.setFont(font);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "installation terminée avec succès!");
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                dispose(); // bach ykhroj mn l Frame
                try {
                    Admin.addAdmin(username.strip(), password.strip());
                    LoginFrame loginFrame = new LoginFrame();
                    loginFrame.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    //
                }


            }
        });


        add(titleLabel);
        add(usernameLabel);
        add(passwordLabel);
        add(usernameField);
        add(passwordField);
        add(loginButton);

        this.setVisible(true);
    }
}