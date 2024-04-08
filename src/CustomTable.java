import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomTable extends JScrollPane {
    Color primaryColor = new Color(199, 249, 204);
    JTable table;

    public CustomTable(String[][] data, String[] columnNames) {
        table = new JTable(new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        table.setBackground(primaryColor);
        table.setPreferredScrollableViewportSize(new Dimension(800, 600));
        table.setFillsViewportHeight(true);
        setViewportView(table);
    }
}
