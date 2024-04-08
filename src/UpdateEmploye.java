import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class UpdateEmploye extends BaseFrame {

    public UpdateEmploye() {
        this.setTitle("Mettre à jour ");
        this.setLocationRelativeTo(null);
        JLabel titleLabel = new JLabel("Mettre à jour les informations d'un employé");

        titleLabel.setBounds(200, 30, 450, 25);

        NumberField idTextField = new NumberField();
        JTextField firstNameTextField = new JTextField();
        JTextField lastNameTextField = new JTextField();
        JTextField emailTextField = new JTextField();
        JTextField phoneTextField = new JTextField();
        NumberField salaryTextField = new NumberField();
        NumberField postIdTextField = new NumberField();
        NumberField deptIdTextField = new NumberField();
        NumberField managerIdTextField = new NumberField();

        JLabel idLabel = new JLabel("Employe ID:");
        JLabel firstNameLabel = new JLabel("Prénom:");
        JLabel lastNameLabel = new JLabel("Nom:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel phoneLabel = new JLabel("Téléphone:");
        JLabel salaryLabel = new JLabel("Salaire:");
        JLabel postIdLabel = new JLabel("ID Poste:");
        JLabel deptIdLabel = new JLabel("ID Département:");
        JLabel managerIdLabel = new JLabel("ID Manager:");

        JButton searchButton = new JButton("Search");
        JButton updateButton = new JButton("Update");
        JButton clearButton = new JButton("Clear");

        idLabel.setBounds(220, 100, 120, 25);
        firstNameLabel.setBounds(220, 150, 120, 25);
        lastNameLabel.setBounds(220, 190, 120, 25);
        emailLabel.setBounds(220, 230, 120, 25);
        phoneLabel.setBounds(220, 270, 120, 25);
        salaryLabel.setBounds(220, 310, 120, 25);
        postIdLabel.setBounds(220, 350, 120, 25);
        deptIdLabel.setBounds(220, 390, 160, 25);
        managerIdLabel.setBounds(220, 430, 120, 25);

        idTextField.setBounds(390, 100, 200, 35);
        firstNameTextField.setBounds(390, 150, 200, 35);
        lastNameTextField.setBounds(390, 190, 200, 35);
        emailTextField.setBounds(390, 230, 200, 35);
        phoneTextField.setBounds(390, 270, 200, 35);
        salaryTextField.setBounds(390, 310, 200, 35);
        postIdTextField.setBounds(390, 350, 200, 35);
        deptIdTextField.setBounds(390, 390, 200, 35);
        managerIdTextField.setBounds(390, 430, 200, 35);
        searchButton.setBounds(610, 100, 100, 35);
        updateButton.setBounds(280, 490, 100, 35);
        clearButton.setBounds(420, 490, 100, 35);
        JCheckBox managerCheckBox = new JCheckBox("Manager");
        managerCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                boolean isChecked = managerCheckBox.isSelected();
                managerIdTextField.setVisible(!isChecked);
                managerIdLabel.setVisible(!isChecked);
            }
        });
        managerCheckBox.setBackground(new Color(199, 249, 204));
        managerCheckBox.setBounds(600, 435, 120, 25);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String query = "SELECT * FROM employes WHERE id_employe = ?";
                    Connection conct = MySQLConnector.getConnection();
                    PreparedStatement stmt = conct.prepareStatement(query);
                    stmt.setString(1, idTextField.getText());
                    ResultSet res = stmt.executeQuery();
                    if (res.next()) {
                        firstNameTextField.setText(res.getString("prenom"));
                        lastNameTextField.setText(res.getString("nom"));
                        emailTextField.setText(res.getString("email"));
                        phoneTextField.setText(res.getString("telephone"));
                        salaryTextField.setText(res.getString("salaire"));
                        postIdTextField.setText(res.getString("id_poste"));
                        deptIdTextField.setText(res.getString("id_departement"));
                        managerIdTextField.setText(res.getString("id_manager"));

                        updateButton.setVisible(true);
                        clearButton.setVisible(true);
                        firstNameLabel.setVisible(true);
                        lastNameLabel.setVisible(true);
                        emailLabel.setVisible(true);
                        phoneLabel.setVisible(true);
                        salaryLabel.setVisible(true);
                        postIdLabel.setVisible(true);
                        deptIdLabel.setVisible(true);
                        managerIdLabel.setVisible(true);
                        firstNameTextField.setVisible(true);
                        lastNameTextField.setVisible(true);
                        emailTextField.setVisible(true);
                        phoneTextField.setVisible(true);
                        salaryTextField.setVisible(true);
                        postIdTextField.setVisible(true);
                        deptIdTextField.setVisible(true);
                        managerIdTextField.setVisible(true);
                        managerCheckBox.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee with ID " + idTextField.getText() + " not found.");
                    }
                    conct.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstNameTextField.getText().isEmpty() ||
                        lastNameTextField.getText().isEmpty() ||
                        emailTextField.getText().isEmpty() ||
                        phoneTextField.getText().isEmpty() ||
                        salaryTextField.getText().isEmpty() ||
                        postIdTextField.getText().isEmpty() ||
                        deptIdTextField.getText().isEmpty() ||
                        (managerIdTextField.getText().isEmpty() && !(managerCheckBox.isSelected()))) {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                    return;
                }
                int id_pos_int = Integer.parseInt(postIdTextField.getText());
                int id_dep_int = Integer.parseInt(deptIdTextField.getText());
                double salaire = Double.parseDouble(salaryTextField.getText());

                if (!managerCheckBox.isSelected()) {
                    int id_man_int = Integer.parseInt(managerIdTextField.getText());
                    if (Poste.checkID(id_pos_int) && Departement.checkID(id_dep_int) && Employe.checkID(id_man_int)) {
                        Employe.updateEmploye(Integer.parseInt(idTextField.getText()),
                                firstNameTextField.getText(),
                                lastNameTextField.getText(),
                                emailTextField.getText(),
                                phoneTextField.getText(),
                                Double.parseDouble(salaryTextField.getText()),
                                Integer.parseInt(postIdTextField.getText()),
                                Integer.parseInt(deptIdTextField.getText()),
                                id_man_int
                        );
                        JOptionPane.showMessageDialog(null, "L'ajout de l'employé avec succès.");
                        firstNameTextField.setText("");
                        lastNameTextField.setText("");
                        emailTextField.setText("");
                        phoneTextField.setText("");
                        salaryTextField.setText("");
                        deptIdTextField.setText("");
                        postIdTextField.setText("");
                        managerIdTextField.setText("");
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

                        Employe.updateManager(Integer.parseInt(idTextField.getText()),
                                firstNameTextField.getText(),
                                lastNameTextField.getText(),
                                emailTextField.getText(),
                                phoneTextField.getText(),
                                Double.parseDouble(salaryTextField.getText()),
                                Integer.parseInt(postIdTextField.getText()),
                                Integer.parseInt(deptIdTextField.getText())
                        );
                        JOptionPane.showMessageDialog(null, "manager updated.");
                        firstNameTextField.setText("");
                        lastNameTextField.setText("");
                        emailLabel.setText("");
                        phoneTextField.setText("");
                        salaryTextField.setText("");
                        deptIdTextField.setText("");
                        postIdTextField.setText("");
                        managerIdTextField.setText("");
                        dispose();
                    } else if (!Poste.checkID(id_pos_int)) {
                        JOptionPane.showMessageDialog(null, "... car le poste ID " + id_pos_int + " n'existe pas.");

                    } else if (!Departement.checkID(id_dep_int)) {
                        JOptionPane.showMessageDialog(null, "... car le département ID " + id_dep_int + " n'existe pas.");

                    }

                }
            }
        });

        /*updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (idTextField.getText().isEmpty() || firstNameTextField.getText().isEmpty() ||
                            lastNameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() ||
                            phoneTextField.getText().isEmpty() || salaryTextField.getText().isEmpty() ||
                            postIdTextField.getText().isEmpty() || deptIdTextField.getText().isEmpty() ||
                            managerIdTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                        return;
                    }

                    int id_pos_int = Integer.parseInt(postIdTextField.getText());
                    int id_dep_int = Integer.parseInt(deptIdTextField.getText());
                    int id_man_int = Integer.parseInt(managerIdTextField.getText());

                    if (Poste.checkID(id_pos_int) && Departement.checkID(id_dep_int) && Employe.checkID(id_man_int)) {
                        Employe.updateEmploye(Integer.parseInt(idTextField.getText()), firstNameTextField.getText(), lastNameTextField.getText(), emailTextField.getText(), phoneTextField.getText(), Double.parseDouble(salaryTextField.getText()), id_pos_int, id_dep_int, id_man_int);
                        JOptionPane.showMessageDialog(null, "Les informations de l'employe ont été mises à jour avec succès");
                        idTextField.setText("");
                        firstNameTextField.setText("");
                        lastNameTextField.setText("");
                        emailTextField.setText("");
                        phoneTextField.setText("");
                        salaryTextField.setText("");
                        postIdTextField.setText("");
                        deptIdTextField.setText("");
                        managerIdTextField.setText("");
                        dispose();
                    } else {
                        if (!Poste.checkID(id_pos_int)) {
                            JOptionPane.showMessageDialog(null, "La mise à jour de l'employé n'a pas été effectuée, le poste ID " + id_pos_int + " n'existe pas.");
                        } else if (!Departement.checkID(id_dep_int)) {
                            JOptionPane.showMessageDialog(null, "La mise à jour de l'employé n'a pas été effectuée, le département ID " + id_dep_int + " n'existe pas.");
                        } else if (!Employe.checkID(id_man_int)) {
                            JOptionPane.showMessageDialog(null, "La mise à jour de l'employé n'a pas été effectuée, le manager ID " + id_man_int + " n'existe pas.");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Entrée invalide. Veuillez entrer des chiffres valides.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });*/

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idTextField.setText("");
                firstNameTextField.setText("");
                lastNameTextField.setText("");
                emailTextField.setText("");
                phoneTextField.setText("");
                salaryTextField.setText("");
                postIdTextField.setText("");
                deptIdTextField.setText("");
                managerIdTextField.setText("");
            }
        });
        updateButton.setVisible(false);
        clearButton.setVisible(false);
        firstNameLabel.setVisible(false);
        lastNameLabel.setVisible(false);
        emailLabel.setVisible(false);
        phoneLabel.setVisible(false);
        salaryLabel.setVisible(false);
        postIdLabel.setVisible(false);
        deptIdLabel.setVisible(false);
        managerIdLabel.setVisible(false);
        firstNameTextField.setVisible(false);
        lastNameTextField.setVisible(false);
        emailTextField.setVisible(false);
        phoneTextField.setVisible(false);
        salaryTextField.setVisible(false);
        postIdTextField.setVisible(false);
        deptIdTextField.setVisible(false);
        managerIdTextField.setVisible(false);
        managerCheckBox.setVisible(false);
        add(titleLabel);
        add(idLabel);
        add(firstNameLabel);
        add(lastNameLabel);
        add(emailLabel);
        add(phoneLabel);
        add(salaryLabel);
        add(postIdLabel);
        add(deptIdLabel);
        add(managerIdLabel);

        add(idTextField);
        add(firstNameTextField);
        add(lastNameTextField);
        add(emailTextField);
        add(phoneTextField);
        add(salaryTextField);
        add(postIdTextField);
        add(deptIdTextField);
        add(managerIdTextField);
        add(searchButton);
        add(updateButton);
        add(managerCheckBox);
        add(clearButton);
        setLayout(null);

    }

}