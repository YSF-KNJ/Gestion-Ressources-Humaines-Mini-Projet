import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExportEmploye extends BaseFrame {
    ButtonCard btnXls = new ButtonCard("Exporter XLS", "resources/xls.png", 180, 220, 200, 100);
    ButtonCard btnTxt = new ButtonCard("Exporter  Txt", "resources/txt.png", 420, 220, 200, 100);

    public ExportEmploye() {
        JLabel label = new JLabel("Export DataBase ", JLabel.CENTER);
        label.setBounds(250, 100, 300, 25);
        add(label);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("HR");
        add(btnXls);
        add(btnTxt);

        btnXls.addActionListener(new MyListener());
        btnTxt.addActionListener(new MyListener());
    }

    public void exportXls() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedDateTime = now.format(formatter);
        String defaultFilename = "export_emplyes_" + formattedDateTime + ".xls";


        JFileChooser fchoose = new JFileChooser();
        fchoose.setSelectedFile(new File(defaultFilename));
        int option = fchoose.showSaveDialog(ExportEmploye.this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String name = fchoose.getSelectedFile().getName();
            String path = fchoose.getSelectedFile().getParentFile().getPath();
            String file = path + "\\" + name;
            Employe.exportFileXls(file);
            JOptionPane.showMessageDialog(ExportEmploye.this, "Exportation XLS réussie..");
        }

    }

    public void exportTxt() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedDateTime = now.format(formatter);
        String defaultFilename = "export_emplyes_" + formattedDateTime + ".txt";
        JFileChooser fchoose = new JFileChooser();
        fchoose.setSelectedFile(new File(defaultFilename));
        int option = fchoose.showSaveDialog(ExportEmploye.this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String name = fchoose.getSelectedFile().getName();
            String path = fchoose.getSelectedFile().getParentFile().getPath();
            String file = path + "\\" + name;
            Employe.exportFileTxt(file);

            JOptionPane.showMessageDialog(ExportEmploye.this, "Exportation TXT réussie.");
        }
    }

    class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnXls) {
                exportXls();
            } else if (e.getSource() == btnTxt) {
                exportTxt();
            }
        }
    }
}
