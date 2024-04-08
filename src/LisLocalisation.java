import javax.swing.*;


public class LisLocalisation extends BaseFrame {
    public LisLocalisation() {
        String[] columnNames = {"ID", "adresse", "ville"};
        CustomTable customTable = new CustomTable(Localisation.getLocalisationsData(), columnNames);
        this.getContentPane().add(new JScrollPane(customTable));
        this.pack();
    }
}
