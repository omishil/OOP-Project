import javax.swing.*;

class SurgeonGUI extends JFrame {

    SurgeonGUI() {

        setTitle("Surgeon");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(
                "Welcome to Surgeon Portal",
                SwingConstants.CENTER
        );

        add(label);

        setVisible(true);
    }
}
