import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseButton extends JButton {
    private final JFrame frameToClose;

    public CloseButton(JFrame frame) {
        this.setText("fermer");

        ImageIcon addIcon = new ImageIcon("resources/hide.png");
        Image scaledImage = addIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        this.setIcon(scaledIcon);
        this.setIconTextGap(10);
        this.setBounds(610, 490, 150, 50);
        this.frameToClose = frame;

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameToClose.dispose();
            }
        });
    }
}
