import javax.swing.*;

class MedicalStaffGUI extends JFrame {

    MedicalStaffGUI() {

        setTitle("Medical Staff");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(
                "Select Medical Staff Type",
                SwingConstants.CENTER
        );

        JButton doctorButton = new JButton("Doctor");
        JButton nurseButton = new JButton("Nurse");
        JButton staffButton = new JButton("Other Staff");

        JPanel panel = new JPanel();

        panel.add(doctorButton);
        panel.add(nurseButton);
        panel.add(staffButton);

        add(label, "North");
        add(panel, "Center");

        //now if the user clicks doctor he should see another interface
        doctorButton.addActionListener(e -> {

            new DoctorTypeGUI();

            dispose();
        });
        nurseButton.addActionListener(e -> {

            new NurseGUI();

            dispose();
        });
        staffButton.addActionListener(e -> {

            new OtherStaffGUI();

            dispose();
        });
        setVisible(true);
    }
}