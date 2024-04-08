import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SearchEmploye extends BaseFrame {
    String[] columns = new String[]{"ID", "Prénom", "Nom", "Email", "Téléphone", "Salaire", "ID Poste", "ID Département", "ID Manager"};
    String[][] data = Employe.getEmployeesData();

    DefaultTableModel model = new DefaultTableModel(data, columns);
    JTable table = new JTable(model);
    TableRowSorter<TableModel> sort = new TableRowSorter<>(table.getModel());
    JTextField textField = new JTextField();
    JLabel searchLabel = new JLabel("Search avec mot:");

    public SearchEmploye() {
        setLayout(null);
        model.setColumnIdentifiers(columns);
        table.setRowSorter(sort);
        searchLabel.setBounds(180, 20, 250, 30);
        textField.setBounds(380, 20, 200, 30);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 65, 750, 470);

        add(searchLabel);
        add(textField);
        add(scrollPane);

        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }


    private void search() {
        String str = textField.getText();
        if (str.trim().length() == 0) {
            sort.setRowFilter(null);
        } else {
            sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));
        }
    }


}