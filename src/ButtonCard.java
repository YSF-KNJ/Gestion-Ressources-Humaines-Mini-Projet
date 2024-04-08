import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCard extends JButton {

    public ButtonCard(String text, int x, int y) {
        this.setText(text);
        int buttonWidth = 250;
        int buttonHeight = 100;
        this.setBounds(x, y, buttonWidth, buttonHeight);
        this.setIconTextGap(10);

    }

    public ButtonCard(String text, int x, int y, int w, int h) {
        this(text, x, y);
        this.setBounds(x, y, w, h);

    }

    public ButtonCard(String text, String ImagePath, int x, int y) {
        this(text, x, y);
        ImageIcon addIcon = new ImageIcon(ImagePath);
        Image scaledImage = addIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        this.setIcon(scaledIcon);
    }

    public ButtonCard(String text, String ImagePath, int x, int y, int w, int h) {
        this(text, ImagePath, x, y);
        this.setBounds(x, y, w, h);

    }

    public ButtonCard(String text, String ImagePath, int x, int y, JFrame destinationFrame) {
        this(text, ImagePath, x, y);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //SwingUtilities.getWindowAncestor(ButtonCard.this).dispose();
                destinationFrame.setLayout(null);
                destinationFrame.setVisible(true);
            }
        });
    }

    public ButtonCard(String text, String ImagePath, int x, int y, JFrame destinationFrame, int w, int h) {
        this(text, ImagePath, x, y, destinationFrame);
        this.setBounds(x, y, w, h);
    }
}
