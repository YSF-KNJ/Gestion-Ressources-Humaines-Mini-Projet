import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LocalisationFrame extends BaseFrame {
    Font font = new Font("cairo", Font.BOLD, 22);

    public LocalisationFrame() {
        this.setLayout(null);

        JLabel titleLabel = new JLabel("LOCALISATION");
        titleLabel.setBounds(250, 40, 300, 60);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(font);


        ButtonCard button1 = new ButtonCard("Lister", "resources/list.png", 50, 180, 200, 100);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LisLocalisation lisLocalisation = new LisLocalisation();
                lisLocalisation.setVisible(true);
            }
        });
        ButtonCard button2 = new ButtonCard("Ajouter", "resources/add.png", 300, 180, new AjouterLocalisation(), 200, 100);
        ButtonCard button3 = new ButtonCard("Supprimer", "resources/remove.png", 550, 180, 200, 100);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupprimerLocalisation supprimerlocalisation = new SupprimerLocalisation();
                supprimerlocalisation.setVisible(true);
            }
        });

        ButtonCard button4 = new ButtonCard("Mettre à jour", "resources/update.png", 50, 320, new BaseFrame(), 200, 100);
        ButtonCard button5 = new ButtonCard("Importer", "resources/txt.png", 300, 320, 200, 100);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImportLocTxt importLocTxt = new ImportLocTxt();
                importLocTxt.importTxt();
            }
        });
        ButtonCard button6 = new ButtonCard("Exporter", "resources/xls.png", 550, 320, new ExportLocalisation(), 200, 100);
        HomeButton button7 = new HomeButton(this);

        this.add(titleLabel);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
    }
}
