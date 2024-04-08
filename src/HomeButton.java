import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeButton extends JButton {
    private final JFrame frameToClose;

    public HomeButton(JFrame frame) {
        this.setText("home");
        this.frameToClose = frame;
        ImageIcon addIcon = new ImageIcon("resources/home.png");
        Image scaledImage = addIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        this.setIcon(scaledIcon);
        this.setIconTextGap(10);
        this.setBounds(615, 490, 150, 50);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeFrame homeFrame = new HomeFrame();
                homeFrame.setVisible(true);
                frameToClose.dispose();
            }
        });
    }
}