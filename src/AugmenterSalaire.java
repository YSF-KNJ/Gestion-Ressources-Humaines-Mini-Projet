import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AugmenterSalaire extends BaseFrame {

    public AugmenterSalaire() {
        setTitle("Augmenter le salaire ");
        JLabel titleLabel = new JLabel("Augmenter le salaire d'un employe");
        titleLabel.setBounds(250, 30, 450, 25);
        add(titleLabel);
        setLayout(null);

        JLabel idLabel = new JLabel("Employee ID:");
        JLabel amountLabel = new JLabel(" Montant:");

        NumberField idField = new NumberField();
        NumberField amountField = new NumberField();

        JButton increaseButton = new JButton("Augmenter le salaire ");

        idLabel.setBounds(260, 200, 150, 25);
        idField.setBounds(450, 200, 150, 40);
        amountLabel.setBounds(260, 260, 150, 25);
        amountField.setBounds(450, 260, 150, 40);
        increaseButton.setBounds(300, 380, 250, 35);

        add(idLabel);
        add(idField);
        add(amountLabel);
        add(amountField);
        add(increaseButton);

        increaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    double amount = Double.parseDouble(amountField.getText());
                    Employe.increaseSalary(id, amount);
                    idField.setText("");
                    amountField.setText("");
                    JOptionPane.showMessageDialog(null, "Le salaire de l'employe avec l'ID " + idField.getText() + " a ete augmente..");
                    dispose();
                } catch (NumberFormatException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Entrée invalide. Veuillez entrer des chiffres valides.");
                }
            }
        });

        setLocationRelativeTo(null);
    }

}
