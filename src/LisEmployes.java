import javax.swing.*;


public class LisEmployes extends BaseFrame {
    public LisEmployes() {
        String[] columnNames = {"ID", "prenom", "nom", "email", "telephone", "salaire", "ID poste", "ID dep", "ID manger"};
        CustomTable customTable = new CustomTable(Employe.getEmployeesData(), columnNames);
        this.getContentPane().add(new JScrollPane(customTable));
        this.pack();
    }
}
