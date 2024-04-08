import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeesFrame extends BaseFrame {
    Font font = new Font("cairo", Font.BOLD, 22);

    public EmployeesFrame() {
        this.setLayout(null);

        JLabel titleLabel = new JLabel("EMPLOYEES");
        titleLabel.setBounds(250, 40, 300, 20);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(font);


        ButtonCard button1 = new ButtonCard("Lister", "resources/list.png", 100, 100, 180, 100);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LisEmployes lisEmployes = new LisEmployes();
                lisEmployes.setVisible(true);
            }
        });
        ButtonCard button2 = new ButtonCard("Ajouter", "resources/add.png", 310, 100, new AjouterEmploye(), 180, 100);
        ButtonCard button3 = new ButtonCard("Supprimer", "resources/remove.png", 520, 100, 180, 100);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupprimerEmploye supprimeremploye = new SupprimerEmploye();
                supprimeremploye.setVisible(true);
            }
        });
        ButtonCard button4 = new ButtonCard("Mettre à jour", "resources/update.png", 100, 250, 180, 100);

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateEmploye updateemploye = new UpdateEmploye();
                updateemploye.setVisible(true);
            }
        });
        ButtonCard button5 = new ButtonCard("Augmenter le salaire", "resources/Increase.png", 310, 250, new AugmenterSalaire(), 180, 100);
        ButtonCard button6 = new ButtonCard("Rechercher", "resources/find.png", 520, 250, 180, 100);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchEmploye searchemploye = new SearchEmploye();
                searchemploye.setVisible(true);
            }
        });

        ButtonCard button7 = new ButtonCard("Importer", "resources/txt.png", 205, 400, 180, 100);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImportTxt importTxt = new ImportTxt();
                importTxt.importTxt();
            }
        });
        ButtonCard button8 = new ButtonCard("Exporter", "resources/xls.png", 420, 400, new ExportEmploye(), 180, 100);


        HomeButton button9 = new HomeButton(this);
        this.add(titleLabel);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
        this.add(button8);
        this.add(button9);


    }
}
