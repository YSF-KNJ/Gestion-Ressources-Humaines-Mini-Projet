import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SupprimerDepartement extends BaseFrame {
    private final JTable table;
    private final DefaultTableModel tableModel;

    public SupprimerDepartement() {
        setTitle("Supprimer");
        JLabel titleLabel = new JLabel("Supprimer un Departement ");

        titleLabel.setBounds(280, 15, 300, 40);
        add(titleLabel);
        String[] columns = {"ID", "titre de Departement"};
        String[][] data = Departement.getDepartementData();
        tableModel = new DefaultTableModel(data, columns);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 60, 700, 420);
        add(scrollPane);

        JButton deleteButton = new JButton("Supprimer le Departement sélectionné");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedDepartement();
            }
        });
        deleteButton.setBounds(240, 500, 350, 35);
        add(deleteButton);

        setLayout(null);
    }


    private void deleteSelectedDepartement() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
            if (Departement.isDepartmentOccupied(id)) {
                openDepartementReplacementFrame(id, selectedRow);

            } else {
                Departement.deleteDepartement(id);
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Employé avec l'ID " + id + " supprimé avec succès.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un employé à supprimer.");
        }
    }

    private void openDepartementReplacementFrame(int DepartementId, int selectedRow) {
        JFrame DepartementReplacementFrame = new JFrame("Remplacement de Departement");
        JLabel label = new JLabel("Entrez le nouvel ID du Departement:");
        JTextField textField = new JTextField(10);
        JButton replaceButton = new JButton("Remplacer");
        replaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newDepartementId = Integer.parseInt(textField.getText());
                if (Departement.checkID(newDepartementId)) {
                    Departement.replaceDepartements(DepartementId, newDepartementId);
                    Departement.deleteDepartement(DepartementId);
                    tableModel.removeRow(selectedRow);
                    DepartementReplacementFrame.dispose();
                    JOptionPane.showMessageDialog(null, "Departement remplacé avec succès.");
                } else {
                    JOptionPane.showMessageDialog(null, "Departement not found.");
                }
            }
        });
        DepartementReplacementFrame.add(label);
        DepartementReplacementFrame.add(textField);
        DepartementReplacementFrame.add(replaceButton);
        DepartementReplacementFrame.setSize(400, 150);
        DepartementReplacementFrame.setLayout(new FlowLayout());
        DepartementReplacementFrame.setVisible(true);
        DepartementReplacementFrame.setLocationRelativeTo(null);

    }
}
