import javax.swing.*;

class PatientGUI extends JFrame {

    PatientGUI() {

        setTitle("Patient Portal");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(
                "Welcome to Patient Portal",
                SwingConstants.CENTER
        );

        add(label);

        setVisible(true);
    }
}