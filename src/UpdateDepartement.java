import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateDepartement extends BaseFrame {
    public UpdateDepartement() {
        this.setTitle("Mettre à jour ");
        this.setLocationRelativeTo(null);
        JLabel titleLabel = new JLabel("Mettre à jour les informations d'une departement");
        titleLabel.setBounds(200, 30, 450, 25);

        NumberField idTextField = new NumberField();
        JTextField posteTextField = new JTextField();
        NumberField locidtext = new NumberField();



        JLabel idLabel = new JLabel("dep ID:");
        JLabel posteLabel = new JLabel("nom departement:");
        JLabel locLabel = new JLabel("id localisation:");


        JButton searchButton = new JButton("Search");
        JButton updateButton = new JButton("Update");
        JButton clearButton = new JButton("Clear");

        idLabel.setBounds(220, 100, 120, 25);
        posteLabel.setBounds(220, 150, 120, 25);
        locLabel.setBounds(220, 190, 120, 25);


        idTextField.setBounds(390, 100, 200, 35);
        posteTextField.setBounds(390, 150, 200, 35);
        locLabel.setBounds(390, 190, 200, 35);


        searchButton.setBounds(610, 100, 100, 35);
        updateButton.setBounds(280, 490, 100, 35);
        clearButton.setBounds(420, 490, 100, 35);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idTextField.setText("");
                posteTextField.setText("");
            }
        });

        updateButton.setVisible(false);
        clearButton.setVisible(false);
        posteLabel.setVisible(false);
        locidtext.setVisible(false);
        locLabel.setVisible(false);
        posteTextField.setVisible(false);
        add(titleLabel);
        add(locidtext);
        add(locLabel);
        add(idLabel);
        add(posteLabel);
        add(idTextField);
        add(posteTextField);
        add(searchButton);
        add(updateButton);
        add(clearButton);
        setLayout(null);
    }
}
