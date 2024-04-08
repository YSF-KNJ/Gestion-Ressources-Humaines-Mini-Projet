import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImportTxt extends JFileChooser {
    public void importTxt() {
        int option = showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = getSelectedFile();
            try {
                Employe.addFromFile(new FileInputStream(selectedFile));
                JOptionPane.showMessageDialog(null, "Importation réussie.");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Erreur lors de l'importation.");
            }
        }
    }

}
