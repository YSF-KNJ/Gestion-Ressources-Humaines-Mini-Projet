import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjouterLocalisation extends BaseFrame {
    public AjouterLocalisation() {
        this.setTitle("ajouter");
        this.setLayout(null);
        this.setSize(700, 500);

        JLabel label = new JLabel("Ajouter une Localisation");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(200, 40, 300, 60);
        JLabel labeladresse = new JLabel("adresse:");
        JLabel labelIdville = new JLabel("ville:");

        labeladresse.setBounds(200, 120, 300, 30);
        labelIdville.setBounds(200, 210, 300, 30);

        JTextField txtadresse = new JTextField();
        JTextField txtidville = new JTextField();

        txtadresse.setBounds(200, 150, 300, 50);
        txtidville.setBounds(200, 240, 300, 50);

        JButton addButton = new JButton("Ajouter");
        JButton clearButton = new JButton("Clear");

        addButton.setBounds(225, 370, 100, 35);
        clearButton.setBounds(375, 370, 100, 35);

        add(label);
        add(labeladresse);
        add(labelIdville);
        add(txtadresse);
        add(txtidville);
        add(addButton);
        add(clearButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtadresse.getText().isEmpty() ||
                        txtidville.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                    return;
                }
                Localisation.addLocalisation(txtadresse.getText(), txtidville.getText());
                JOptionPane.showMessageDialog(null, "L'ajout de la Localisation avec succès.");
                txtadresse.setText("");
                txtidville.setText("");
                dispose();

            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtadresse.setText("");
                txtidville.setText("");
            }
        });
    }

}
