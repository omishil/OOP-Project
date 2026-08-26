import javax.swing.*;
import java.awt.*;

class NurseGUI extends JFrame {

    NurseGUI() {

        setTitle("Nurse Management");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        // Main panel
        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();


        // --------------------------------
        // Nurse object
        // --------------------------------

        Nurse nurse1 = new Nurse(
                "Nurse A", 201, 28
        );


        // --------------------------------
        // Title
        // --------------------------------

        JLabel titleLabel =
                new JLabel("Nurse Management");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 20, 10);

        panel.add(titleLabel, gbc);


        // --------------------------------
        // Nurse label
        // --------------------------------

        JLabel nurseLabel =
                new JLabel("Select Nurse:");

        gbc.gridy = 1;

        panel.add(nurseLabel, gbc);


        // --------------------------------
        // Nurse dropdown
        // --------------------------------

        JComboBox<Nurse> nurseBox =
                new JComboBox<>();

        nurseBox.addItem(nurse1);

        gbc.gridy = 2;

        panel.add(nurseBox, gbc);


        // --------------------------------
        // Attendance label
        // --------------------------------

        JLabel attendanceLabel =
                new JLabel("Attendance: Absent");

        gbc.gridy = 3;

        panel.add(attendanceLabel, gbc);


        // --------------------------------
        // Present button
        // --------------------------------

        JButton presentButton =
                new JButton("Mark Present");

        gbc.gridy = 4;

        panel.add(presentButton, gbc);


        // --------------------------------
        // Absent button
        // --------------------------------

        JButton absentButton =
                new JButton("Mark Absent");

        gbc.gridy = 5;

        panel.add(absentButton, gbc);


        // --------------------------------
        // Present button action
        // --------------------------------

        presentButton.addActionListener(e -> {

            Nurse selectedNurse =
                    (Nurse) nurseBox.getSelectedItem();

            selectedNurse.markAttendance(true);

            attendanceLabel.setText(
                    "Attendance: Present"
            );
        });


        // --------------------------------
        // Absent button action
        // --------------------------------

        absentButton.addActionListener(e -> {

            Nurse selectedNurse =
                    (Nurse) nurseBox.getSelectedItem();

            selectedNurse.markAttendance(false);

            attendanceLabel.setText(
                    "Attendance: Absent"
            );
        });


        // --------------------------------
        // Add panel
        // --------------------------------

        add(panel);

        setVisible(true);
    }
}