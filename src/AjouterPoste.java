import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// wait
public class AjouterPoste extends BaseFrame {
    public AjouterPoste() {
        this.setTitle("ajouter");
        this.setLayout(null);
        this.setSize(700, 500);

        JLabel label = new JLabel("Ajouter un Poste");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(200, 40, 300, 60);
        JLabel labelposte = new JLabel("titre de poste :");
        JLabel labelIdville = new JLabel("ville:");

        labelposte.setBounds(200, 160, 300, 30);

        JTextField txtposte = new JTextField();

        txtposte.setBounds(200, 200, 300, 50);

        JButton addButton = new JButton("Ajouter");
        JButton clearButton = new JButton("Clear");

        addButton.setBounds(225, 370, 100, 35);
        clearButton.setBounds(375, 370, 100, 35);

        add(label);
        add(labelposte);
        add(labelIdville);
        add(txtposte);
        add(addButton);
        add(clearButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtposte.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                    return;
                }
                Poste.addPost(txtposte.getText());
                JOptionPane.showMessageDialog(null, "L'ajout de le Poste avec succès.");
                txtposte.setText("");
                dispose();

            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtposte.setText("");
            }
        });
    }

}
