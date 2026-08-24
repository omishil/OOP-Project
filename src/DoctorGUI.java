import javax.swing.*;

class DoctorGUI extends JFrame {

    DoctorGUI() {

        setTitle("Doctor");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(
                "Welcome to Doctor Portal",
                SwingConstants.CENTER
        );

        add(label);

        setVisible(true);
    }
}