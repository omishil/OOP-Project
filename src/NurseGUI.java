import javax.swing.*;

class NurseGUI extends JFrame {

    NurseGUI() {

        setTitle("Nurse");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(
                "Welcome to Nurse Portal",
                SwingConstants.CENTER
        );

        add(label);

        setVisible(true);
    }
}