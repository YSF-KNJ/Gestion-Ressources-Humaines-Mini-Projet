import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjouterEmploye extends BaseFrame {
    public AjouterEmploye() {
        setTitle("ajouter");
        setLayout(null);
        JLabel label = new JLabel("Ajouter un employe ", JLabel.CENTER);
        label.setBounds(250, 17, 300, 25);
        JLabel labelPrenom = new JLabel("Prénom:");
        JLabel labelNom = new JLabel("Nom:");
        JLabel labelEmail = new JLabel("Email:");
        JLabel labelTelephone = new JLabel("Téléphone:");
        JLabel labelSalaire = new JLabel("Salaire:");
        JLabel labelIdPos = new JLabel("ID Poste:");
        JLabel labelIdDep = new JLabel("ID Département:");
        JLabel labelIdMan = new JLabel("ID Manager:");

        labelPrenom.setBounds(220, 85, 120, 25);
        labelNom.setBounds(220, 135, 120, 25);
        labelEmail.setBounds(220, 185, 120, 25);
        labelTelephone.setBounds(220, 235, 120, 25);
        labelSalaire.setBounds(220, 285, 120, 25);
        labelIdPos.setBounds(220, 335, 120, 25);
        labelIdDep.setBounds(220, 385, 160, 25);
        labelIdMan.setBounds(220, 435, 120, 25);

        JTextField txtprenom = new JTextField();
        JTextField txtnom = new JTextField();
        JTextField txtemail = new JTextField();
        JTextField txttelephone = new JTextField();
        NumberField txtsalaire = new NumberField();
        NumberField txtidpos = new NumberField();
        NumberField txtiddep = new NumberField();
        NumberField txtidman = new NumberField();
        JCheckBox managerCheckBox = new JCheckBox("Manager");
        managerCheckBox.setBackground(new Color(199, 249, 204));


        txtprenom.setBounds(390, 85, 200, 35);
        txtnom.setBounds(390, 135, 200, 35);
        txtemail.setBounds(390, 185, 200, 35);
        txttelephone.setBounds(390, 235, 200, 35);
        txtsalaire.setBounds(390, 285, 200, 35);
        txtidpos.setBounds(390, 335, 200, 35);
        txtiddep.setBounds(390, 385, 200, 35);
        txtidman.setBounds(390, 435, 200, 35);
        managerCheckBox.setBounds(600, 435, 120, 25);


        JButton addButton = new JButton("Ajouter");
        JButton clearButton = new JButton("Clear");

        addButton.setBounds(270, 495, 100, 35);
        clearButton.setBounds(410, 495, 100, 35);

        add(label);
        add(labelPrenom);
        add(labelNom);
        add(labelEmail);
        add(labelTelephone);
        add(labelSalaire);
        add(labelIdDep);
        add(labelIdPos);
        add(txtprenom);
        add(txtnom);
        add(txtemail);
        add(txttelephone);
        add(txtsalaire);
        add(txtiddep);
        add(txtidpos);
        add(managerCheckBox);
        add(labelIdMan);
        add(txtidman);
        add(addButton);
        add(clearButton);


        managerCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                boolean isChecked = managerCheckBox.isSelected();
                labelIdMan.setVisible(!isChecked);
                txtidman.setVisible(!isChecked);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtprenom.getText().isEmpty() ||
                        txtnom.getText().isEmpty() ||
                        txtemail.getText().isEmpty() ||
                        txttelephone.getText().isEmpty() ||
                        txtsalaire.getText().isEmpty() ||
                        txtidpos.getText().isEmpty() ||
                        txtiddep.getText().isEmpty() ||
                        (txtidman.getText().isEmpty() && !(managerCheckBox.isSelected()))) {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                    return;
                }
                int id_pos_int = Integer.parseInt(txtidpos.getText());
                int id_dep_int = Integer.parseInt(txtiddep.getText());
                double salaire = Double.parseDouble(txtsalaire.getText());

                if (!managerCheckBox.isSelected()) {
                    int id_man_int = Integer.parseInt(txtidman.getText());
                    if (Poste.checkID(id_pos_int) && Departement.checkID(id_dep_int) && Employe.checkID(id_man_int)) {
                        Employe.addEmploye(txtprenom.getText(), txtnom.getText(), txtemail.getText(), txttelephone.getText(), salaire, id_pos_int, id_dep_int, id_man_int);
                        JOptionPane.showMessageDialog(null, "L'ajout de l'employé avec succès.");
                        txtprenom.setText("");
                        txtnom.setText("");
                        txtemail.setText("");
                        txttelephone.setText("");
                        txtsalaire.setText("");
                        txtiddep.setText("");
                        txtidpos.setText("");
                        txtidman.setText("");
                        dispose();
                    } else if (!Poste.checkID(id_pos_int)) {
                        JOptionPane.showMessageDialog(null, "L'employé n'a pas été ajouté car le poste ID " + id_pos_int + " n'existe pas.");

                    } else if (!Departement.checkID(id_dep_int)) {
                        JOptionPane.showMessageDialog(null, "L'employé n'a pas été ajouté car le département ID " + id_dep_int + " n'existe pas.");

                    } else if (!Employe.checkID(id_man_int)) {
                        JOptionPane.showMessageDialog(null, "L'employé n'a pas été ajouté car le manager ID " + id_man_int + " n'existe pas.");
                    }

                } else {
                    if (Poste.checkID(id_pos_int) && Departement.checkID(id_dep_int)) {
                        Employe.addManger(txtprenom.getText(), txtnom.getText(), txtemail.getText(), txttelephone.getText(), salaire, id_pos_int, id_dep_int);
                        JOptionPane.showMessageDialog(null, "L'ajout de le manager avec succès.");
                        txtprenom.setText("");
                        txtnom.setText("");
                        txtemail.setText("");
                        txttelephone.setText("");
                        txtsalaire.setText("");
                        txtiddep.setText("");
                        txtidpos.setText("");
                        txtidman.setText("");
                        dispose();
                    } else if (!Poste.checkID(id_pos_int)) {
                        JOptionPane.showMessageDialog(null, "L'employé n'a pas été ajouté car le poste ID " + id_pos_int + " n'existe pas.");

                    } else if (!Departement.checkID(id_dep_int)) {
                        JOptionPane.showMessageDialog(null, "L'employé n'a pas été ajouté car le département ID " + id_dep_int + " n'existe pas.");

                    }

                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtprenom.setText("");
                txtnom.setText("");
                txtemail.setText("");
                txttelephone.setText("");
                txtsalaire.setText("");
                txtiddep.setText("");
                txtidpos.setText("");
                txtidman.setText("");

            }
        });

    }

}
