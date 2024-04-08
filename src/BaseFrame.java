import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class BaseFrame extends JFrame {
    public BaseFrame() {
        Color primaryColor = new Color(199, 249, 204);
        Color secondaryColor = new Color(128, 237, 153);
        Color accentColor = new Color(34, 87, 122);
        UIManager.put("Label.foreground", accentColor);
        Font font = new Font("cairo", Font.BOLD, 22);
        Font font2 = new Font("cairo", Font.BOLD, 18);
        UIManager.put("Label.font", font);
        UIManager.put("Button.foreground", accentColor);
        UIManager.put("Button.font", font2);
        UIManager.put("Button.background", secondaryColor);
        Font font3 = new Font("arial", Font.BOLD, 12);
        UIManager.put("Table.font", font3);
        UIManager.put("Table.background", Color.red);


        this.setVisible(false);
        ImageIcon image = new ImageIcon("resources/management.png");
        this.setSize(800, 600);
        this.setTitle("GESTION DES RESSOURCES HUMAINES!");
        this.setIconImage(image.getImage());
        this.setResizable(false);
        this.getContentPane().setBackground(primaryColor);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                checkAndKill();
            }
        });


    }

    private static void checkAndKill() {
        if (JFrame.getFrames().length == 0) {
            System.exit(0);
        }
    }

}
