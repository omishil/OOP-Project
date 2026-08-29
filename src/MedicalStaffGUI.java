import javax.swing.*;

class MedicalStaffGUI extends JFrame {

    MedicalStaffGUI() {

        setTitle("Medical Staff");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(
                "Select Medical Staff Type",
                SwingConstants.CENTER
        );

        JButton doctorButton =
                new JButton("Doctor");

        JButton nurseButton =
                new JButton("Nurse");

        JButton staffButton =
                new JButton("Other Staff");

        JButton backButton =
                new JButton("Back");


        JPanel panel = new JPanel();

        panel.add(doctorButton);
        panel.add(nurseButton);
        panel.add(staffButton);
        panel.add(backButton);


        add(label, "North");

        add(panel, "Center");


        // --------------------------------
        // Doctor button
        // --------------------------------

        doctorButton.addActionListener(e -> {

            new DoctorTypeGUI();

            dispose();
        });


        // --------------------------------
        // Nurse button
        // --------------------------------

        nurseButton.addActionListener(e -> {

            new NurseGUI();

            dispose();
        });


        // --------------------------------
        // Other Staff button
        // --------------------------------

        staffButton.addActionListener(e -> {

            new OtherStaffGUI();

            dispose();
        });


        // --------------------------------
        // Back button
        // --------------------------------

        backButton.addActionListener(e -> {

            new MainGUI();

            dispose();
        });


        setVisible(true);
    }
}