import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SupprimerPoste extends BaseFrame {
    private final JTable table;
    private final DefaultTableModel tableModel;

    public SupprimerPoste() {
        setTitle("Supprimer");
        JLabel titleLabel = new JLabel("Supprimer un poste ");

        titleLabel.setBounds(280, 15, 300, 40);
        add(titleLabel);
        String[] columns = {"ID", "titre de poste"};
        String[][] data = Poste.getPostesData();
        tableModel = new DefaultTableModel(data, columns);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 60, 700, 420);
        add(scrollPane);

        JButton deleteButton = new JButton("Supprimer le poste sélectionné");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedPoste();
            }
        });
        deleteButton.setBounds(240, 500, 350, 35);
        add(deleteButton);

        setLayout(null);
    }


    private void deleteSelectedPoste() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));
            if (Poste.isPosteOccupied(id)) {
                openPosteReplacementFrame(id, selectedRow);

            } else {
                Poste.deletePoste(id);
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Employé avec l'ID " + id + " supprimé avec succès.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un employé à supprimer.");
        }
    }

    private void openPosteReplacementFrame(int PosteId, int selectedRow) {
        JFrame PosteReplacementFrame = new JFrame("Remplacement de Poste");
        JLabel label = new JLabel("Entrez le nouvel ID du Poste:");
        JTextField textField = new JTextField(10);
        JButton replaceButton = new JButton("Remplacer");
        replaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newPosteId = Integer.parseInt(textField.getText());
                if (Poste.checkID(newPosteId)) {
                    Poste.replacePosts(PosteId, newPosteId);
                    Poste.deletePoste(PosteId);
                    tableModel.removeRow(selectedRow);
                    PosteReplacementFrame.dispose();
                    JOptionPane.showMessageDialog(null, "Poste remplacé avec succès.");
                } else {
                    JOptionPane.showMessageDialog(null, "Poste not found.");
                }
            }
        });
        PosteReplacementFrame.add(label);
        PosteReplacementFrame.add(textField);
        PosteReplacementFrame.add(replaceButton);
        PosteReplacementFrame.setSize(400, 150);
        PosteReplacementFrame.setLayout(new FlowLayout());
        PosteReplacementFrame.setVisible(true);
        PosteReplacementFrame.setLocationRelativeTo(null);

    }
}
