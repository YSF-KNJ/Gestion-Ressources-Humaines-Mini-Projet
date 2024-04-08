import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExportPoste extends BaseFrame {
    ButtonCard btnXls = new ButtonCard("Exporter XLS", "resources/xls.png", 130, 220, 200, 100);
    ButtonCard btnTxt = new ButtonCard("Exporter  Txt", "resources/txt.png", 370, 220, 200, 100);

    public ExportPoste() {
        JLabel label = new JLabel("Export Postes Table", JLabel.CENTER);
        this.setSize(700, 500);
        label.setBounds(200, 100, 300, 25);
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
        String defaultFilename = "export_postes_" + formattedDateTime + ".xls";


        JFileChooser fchoose = new JFileChooser();
        fchoose.setSelectedFile(new File(defaultFilename));
        int option = fchoose.showSaveDialog(ExportPoste.this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String name = fchoose.getSelectedFile().getName();
            String path = fchoose.getSelectedFile().getParentFile().getPath();
            String file = path + "\\" + name;
            Poste.exportFileXls(file);
            JOptionPane.showMessageDialog(ExportPoste.this, "Exportation XLS réussie..");
            dispose();
        }

    }

    public void exportTxt() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedDateTime = now.format(formatter);
        String defaultFilename = "export_postes_" + formattedDateTime + ".txt";
        JFileChooser fchoose = new JFileChooser();
        fchoose.setSelectedFile(new File(defaultFilename));
        int option = fchoose.showSaveDialog(ExportPoste.this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String name = fchoose.getSelectedFile().getName();
            String path = fchoose.getSelectedFile().getParentFile().getPath();
            String file = path + "\\" + name;
            Poste.exportFileTxt(file);

            JOptionPane.showMessageDialog(ExportPoste.this, "Exportation TXT réussie.");
            dispose();
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

