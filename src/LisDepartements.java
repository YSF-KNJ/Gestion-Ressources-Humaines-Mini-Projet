import javax.swing.*;

public class LisDepartements extends BaseFrame {
    public LisDepartements() {
        String[] columnNames = {"ID", "nom", "ID localisation"};
        CustomTable customTable = new CustomTable(Departement.getDepartementData(), columnNames);
        this.getContentPane().add(new JScrollPane(customTable));
        this.pack();
    }
}
