import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SupprimerLocalisation extends BaseFrame {
    private final JTable table;
    private final DefaultTableModel tableModel;

    public SupprimerLocalisation() {
        setTitle("Supprimer");
        JLabel titleLabel = new JLabel("Supprimer un Localisation ");

        titleLabel.setBounds(280, 15, 300, 40);
        add(titleLabel);
        String[] columns = {"ID", "titre de Localisation"};
        String[][] data = Localisation.getLocalisationsData();
        tableModel = new DefaultTableModel(data, columns);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 60, 700, 420);
        add(scrollPane);

        JButton deleteButton = new JButton("Supprimer le Localisation sélectionné");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedLocalisation();
            }
        });
        deleteButton.setBounds(240, 500, 350, 35);
        add(deleteButton);

        setLayout(null);
    }


    private void deleteSelectedLocalisation() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
            if (Localisation.isLocalisationOccupied(id)) {
                openLocalisationReplacementFrame(id, selectedRow);

            } else {
                Localisation.deleteLocalisation(id);
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Employé avec l'ID " + id + " supprimé avec succès.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un employé à supprimer.");
        }
    }

    private void openLocalisationReplacementFrame(int LocalisationId, int selectedRow) {
        JFrame LocalisationReplacementFrame = new JFrame("Remplacement de Localisation");
        JLabel label = new JLabel("Entrez le nouvel ID du Localisation:");
        JTextField textField = new JTextField(10);
        JButton replaceButton = new JButton("Remplacer");
        replaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newLocalisationId = Integer.parseInt(textField.getText());
                if (Localisation.checkID(newLocalisationId)) {
                    Localisation.replaceLocalisations(LocalisationId, newLocalisationId);
                    Localisation.deleteLocalisation(LocalisationId);
                    tableModel.removeRow(selectedRow);
                    LocalisationReplacementFrame.dispose();
                    JOptionPane.showMessageDialog(null, "Localisation remplacé avec succès.");
                } else {
                    JOptionPane.showMessageDialog(null, "Localisation not found.");
                }
            }
        });
        LocalisationReplacementFrame.add(label);
        LocalisationReplacementFrame.add(textField);
        LocalisationReplacementFrame.add(replaceButton);
        LocalisationReplacementFrame.setSize(400, 150);
        LocalisationReplacementFrame.setLayout(new FlowLayout());
        LocalisationReplacementFrame.setVisible(true);
        LocalisationReplacementFrame.setLocationRelativeTo(null);

    }

}