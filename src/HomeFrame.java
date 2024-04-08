import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame extends BaseFrame {

    public HomeFrame() {
        this.setLayout(null);

        JLabel titleLabel = new JLabel("RESSOURCES HUMAINES!");
        titleLabel.setBounds(250, 40, 300, 60);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);


        ButtonCard button1 = new ButtonCard("Employees", "resources/Employees.png", 100, 170);
        if (Poste.countPost() == 0 || Departement.countDepartement() == 0) {
            button1.setEnabled(false);
        }
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeesFrame empframe = new EmployeesFrame();
                empframe.setTitle("EMPLOYEES");
                empframe.setVisible(true);
                dispose();
            }
        });


        ButtonCard button2 = new ButtonCard("Posts", "resources/Posts.png", 450, 170);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PostsFrame pstframe = new PostsFrame();
                pstframe.setTitle("POSTS");
                pstframe.setVisible(true);
                dispose();
            }
        });


        ButtonCard button3 = new ButtonCard("Departments", "resources/Departments.png", 100, 330);
        if (Localisation.countLocalisation() == 0) {
            button3.setEnabled(false);
        }
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepartmentsFrame depframe = new DepartmentsFrame();
                depframe.setTitle("DÉPARTEMENTS");
                depframe.setVisible(true);
                dispose();
            }
        });


        ButtonCard button4 = new ButtonCard("Localisation", "resources/Localisation.png", 450, 330);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalisationFrame locframe = new LocalisationFrame();
                locframe.setTitle("LOCALISATION");
                locframe.setVisible(true);
                dispose();
            }
        });

        CloseButton button5 = new CloseButton(this);

        this.add(titleLabel);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
    }
}
