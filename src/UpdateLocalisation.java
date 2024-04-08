import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateLocalisation extends BaseFrame {
    public UpdateLocalisation() {
        this.setTitle("Mettre à jour ");
        this.setLocationRelativeTo(null);
        JLabel titleLabel = new JLabel("Mettre à jour les informations d'une departement");
        titleLabel.setBounds(200, 30, 450, 25);

        NumberField idTextField = new NumberField();
        JTextField addresseTextField = new JTextField();
        JTextField villetextField = new JTextField();



        JLabel idLabel = new JLabel("dep ID:");
        JLabel adresseLabel = new JLabel("adresse:");
        JLabel villeLabel = new JLabel("ville:");


        JButton searchButton = new JButton("Search");
        JButton updateButton = new JButton("Update");
        JButton clearButton = new JButton("Clear");

        idLabel.setBounds(220, 100, 120, 25);
        adresseLabel.setBounds(220, 150, 120, 25);
        villeLabel.setBounds(220, 190, 120, 25);


        idTextField.setBounds(390, 100, 200, 35);
        addresseTextField.setBounds(390, 150, 200, 35);
        villeLabel.setBounds(390, 190, 200, 35);


        searchButton.setBounds(610, 100, 100, 35);
        updateButton.setBounds(280, 490, 100, 35);
        clearButton.setBounds(420, 490, 100, 35);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idTextField.setText("");
                addresseTextField.setText("");
            }
        });

        updateButton.setVisible(false);
        clearButton.setVisible(false);
        adresseLabel.setVisible(false);
        villetextField.setVisible(false);
        villeLabel.setVisible(false);
        addresseTextField.setVisible(false);
        add(titleLabel);
        add(villetextField);
        add(villeLabel);
        add(idLabel);
        add(adresseLabel);
        add(idTextField);
        add(addresseTextField);
        add(searchButton);
        add(updateButton);
        add(clearButton);
        setLayout(null);
    }

}
