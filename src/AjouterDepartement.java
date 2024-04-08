import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjouterDepartement extends BaseFrame {
    public AjouterDepartement() {
        this.setTitle("ajouter");
        this.setLayout(null);
        this.setSize(700, 500);

        JLabel label = new JLabel("Ajouter un Departement");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(200, 40, 300, 60);
        JLabel labeltitre = new JLabel("Titre de Departement:");
        JLabel labelIdPos = new JLabel("ID Localisation:");

        labeltitre.setBounds(200, 120, 300, 30);
        labelIdPos.setBounds(200, 210, 300, 30);

        JTextField txttitre = new JTextField();
        NumberField txtidpos = new NumberField();

        txttitre.setBounds(200, 150, 300, 50);
        txtidpos.setBounds(200, 240, 300, 50);

        JButton addButton = new JButton("Ajouter");
        JButton clearButton = new JButton("Clear");

        addButton.setBounds(225, 370, 100, 35);
        clearButton.setBounds(375, 370, 100, 35);

        add(label);
        add(labeltitre);
        add(labelIdPos);
        add(txttitre);
        add(txtidpos);
        add(addButton);
        add(clearButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txttitre.getText().isEmpty() ||
                        txtidpos.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                    return;
                }
                int id_pos_int = Integer.parseInt(txtidpos.getText());
                if (Localisation.checkID(id_pos_int)) {
                    Departement.addDepartement(txttitre.getText(), id_pos_int);
                    JOptionPane.showMessageDialog(null, "L'ajout de le Departement avec succès.");
                    txttitre.setText("");
                    txtidpos.setText("");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Departement n'a pas été ajouté car le localisation ID " + id_pos_int + " n'existe pas.");
                }

            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txttitre.setText("");
                txtidpos.setText("");
            }
        });
    }

}
