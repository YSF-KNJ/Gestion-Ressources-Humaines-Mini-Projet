import javax.swing.*;


public class LisPostes extends BaseFrame {
    public LisPostes() {
        String[] columnNames = {"ID", "titre de poste"};
        CustomTable customTable = new CustomTable(Poste.getPostesData(), columnNames);
        this.getContentPane().add(new JScrollPane(customTable));
        this.pack();
    }
}
