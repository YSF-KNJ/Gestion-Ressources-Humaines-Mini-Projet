import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SupprimerEmploye extends BaseFrame {
    private final JTable table;
    private final DefaultTableModel tableModel;

    public SupprimerEmploye() {
        setTitle("Supprimer");
        JLabel titleLabel = new JLabel("Supprimer un employé ");

        titleLabel.setBounds(280, 15, 300, 40);
        add(titleLabel);
        String[] columns = {"ID", "Prénom", "Nom", "Email", "Téléphone", "Salaire", "ID Poste", "ID Département", "ID Manager"};
        String[][] data = Employe.getEmployeesData();
        tableModel = new DefaultTableModel(data, columns);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 60, 700, 420);
        add(scrollPane);

        JButton deleteButton = new JButton("Supprimer l'employé sélectionné");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedEmployee();
            }
        });
        deleteButton.setBounds(240, 500, 350, 35);
        add(deleteButton);

        setLayout(null);
    }


    private void deleteSelectedEmployee() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
            if (Employe.isManager(id)) {
                openManagerReplacementFrame(id, selectedRow);

            } else {
                Employe.deleteEmploye(id);
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Employé avec l'ID " + id + " supprimé avec succès.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un employé à supprimer.");
        }
    }

    private void openManagerReplacementFrame(int managerId, int selectedRow) {
        JFrame managerReplacementFrame = new JFrame("Remplacement de manager");
        JLabel label = new JLabel("Entrez le nouvel ID du manager:");
        JTextField textField = new JTextField(10);
        JButton replaceButton = new JButton("Remplacer");
        replaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newManagerId = Integer.parseInt(textField.getText());
                if (Employe.checkID(newManagerId)) {
                    Employe.replaceManager(newManagerId, managerId);
                    Employe.deleteEmploye(managerId);
                    tableModel.removeRow(selectedRow);
                    managerReplacementFrame.dispose();
                    JOptionPane.showMessageDialog(null, "Manager remplacé avec succès.");
                } else {
                    JOptionPane.showMessageDialog(null, "Manager not found.");
                }
            }
        });
        managerReplacementFrame.add(label);
        managerReplacementFrame.add(textField);
        managerReplacementFrame.add(replaceButton);
        managerReplacementFrame.setSize(400, 150);
        managerReplacementFrame.setLayout(new FlowLayout());
        managerReplacementFrame.setVisible(true);
        managerReplacementFrame.setLocationRelativeTo(null);

    }


}
