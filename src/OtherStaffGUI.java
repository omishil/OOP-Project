import javax.swing.*;

class OtherStaffGUI extends JFrame {

    OtherStaffGUI() {

        setTitle("Other Staff");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(
                "Welcome to Other Staff Portal",
                SwingConstants.CENTER
        );

        add(label);

        setVisible(true);
    }
}