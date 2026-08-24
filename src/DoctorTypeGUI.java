import javax.swing.*;

class DoctorTypeGUI extends JFrame {

    DoctorTypeGUI() {

        setTitle("Doctor Type");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(
                "Select Doctor Type",
                SwingConstants.CENTER
        );

        JButton doctorButton = new JButton("Regular Doctor");
        JButton surgeonButton = new JButton("Surgeon");

        JPanel panel = new JPanel();

        panel.add(doctorButton);
        panel.add(surgeonButton);

        add(label, "North");
        add(panel, "Center");
//now if user clicks on dc/surgeon
        doctorButton.addActionListener(e -> {

            new DoctorGUI();

            dispose();
        });

        surgeonButton.addActionListener(e -> {

            new SurgeonGUI();

            dispose();
        });
        setVisible(true);
    }
}