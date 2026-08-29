import javax.swing.*;

class DoctorTypeGUI extends JFrame {

    DoctorTypeGUI() {

        setTitle("Doctor Type");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        // --------------------------------
        // Label
        // --------------------------------

        JLabel label = new JLabel(
                "Select Doctor Type",
                SwingConstants.CENTER
        );


        // --------------------------------
        // Buttons
        // --------------------------------

        JButton doctorButton =
                new JButton("Regular Doctor");

        JButton surgeonButton =
                new JButton("Surgeon");

        JButton backButton =
                new JButton("Back");


        // --------------------------------
        // Panel
        // --------------------------------

        JPanel panel = new JPanel();

        panel.add(doctorButton);
        panel.add(surgeonButton);
        panel.add(backButton);


        add(label, "North");
        add(panel, "Center");


        // --------------------------------
        // Regular Doctor
        // --------------------------------

        doctorButton.addActionListener(e -> {

            new DoctorGUI();

            dispose();
        });


        // --------------------------------
        // Surgeon
        // --------------------------------

        surgeonButton.addActionListener(e -> {

            new SurgeonGUI();

            dispose();
        });


        // --------------------------------
        // Back
        // --------------------------------

        backButton.addActionListener(e -> {

            new MedicalStaffGUI();

            dispose();
        });


        setVisible(true);
    }
}