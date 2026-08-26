import javax.swing.*;
import java.awt.*;

class PatientGUI extends JFrame {

    PatientGUI() {

        setTitle("Patient Portal");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        // --------------------------------
        // Main panel
        // --------------------------------

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();


        // --------------------------------
        // Doctor objects
        // --------------------------------

        Doctor doctor1 = new Doctor(
                "Dr. Rahim", 101, 40, "Cardiology"
        );

        Doctor doctor2 = new Doctor(
                "Dr. Karim", 102, 45, "Neurology"
        );

        Doctor doctor3 = new Doctor(
                "Dr. Hasan", 103, 38, "Medicine"
        );


        // --------------------------------
        // Doctor available times
        // --------------------------------

        doctor1.addAvailableTime("10:00 AM");
        doctor1.addAvailableTime("11:00 AM");
        doctor1.addAvailableTime("12:00 PM");

        doctor2.addAvailableTime("2:00 PM");
        doctor2.addAvailableTime("3:00 PM");
        doctor2.addAvailableTime("4:00 PM");

        doctor3.addAvailableTime("9:00 AM");
        doctor3.addAvailableTime("10:00 AM");
        doctor3.addAvailableTime("11:00 AM");


        // --------------------------------
        // Today's attendance
        // --------------------------------

        doctor1.markAttendance(true);
        doctor2.markAttendance(false);
        doctor3.markAttendance(true);


        // --------------------------------
        // Welcome label
        // --------------------------------

        JLabel welcomeLabel =
                new JLabel("Welcome to Patient Portal");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 20, 10);

        panel.add(welcomeLabel, gbc);


        // --------------------------------
        // Choose doctor label
        // --------------------------------

        JLabel doctorLabel =
                new JLabel("Choose your doctor:");

        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);

        panel.add(doctorLabel, gbc);


        // --------------------------------
        // Doctor dropdown
        // --------------------------------

        JComboBox<Doctor> doctorBox =
                new JComboBox<>();

        doctorBox.addItem(doctor1);
        doctorBox.addItem(doctor2);
        doctorBox.addItem(doctor3);

        gbc.gridy = 2;

        panel.add(doctorBox, gbc);


        // --------------------------------
        // Doctor information
        // --------------------------------

        JLabel specializationLabel =
                new JLabel("Specialization: ");

        JLabel statusLabel =
                new JLabel("Status: ");


        gbc.gridy = 3;
        panel.add(specializationLabel, gbc);

        gbc.gridy = 4;
        panel.add(statusLabel, gbc);


        // --------------------------------
        // Choose time label
        // --------------------------------

        JLabel timeLabel =
                new JLabel("Choose appointment time:");

        gbc.gridy = 5;

        panel.add(timeLabel, gbc);


        // --------------------------------
        // Time dropdown
        // --------------------------------

        JComboBox<String> timeBox =
                new JComboBox<>();

        timeBox.addItem("9:00 AM");
        timeBox.addItem("10:00 AM");
        timeBox.addItem("11:00 AM");
        timeBox.addItem("12:00 PM");
        timeBox.addItem("2:00 PM");
        timeBox.addItem("3:00 PM");
        timeBox.addItem("4:00 PM");

        gbc.gridy = 6;

        panel.add(timeBox, gbc);


        // --------------------------------
        // Book appointment button
        // --------------------------------

        JButton bookButton =
                new JButton("Book Appointment");

        gbc.gridy = 7;
        gbc.insets = new Insets(20, 10, 10, 10);

        panel.add(bookButton, gbc);


        // --------------------------------
        // Doctor selection action
        // --------------------------------

        doctorBox.addActionListener(e -> {

            // Get selected doctor
            Doctor selectedDoctor =
                    (Doctor) doctorBox.getSelectedItem();


            // Display specialization
            specializationLabel.setText(
                    "Specialization: "
                            + selectedDoctor.getSpecialization()
            );


            // Display attendance status
            statusLabel.setText(
                    "Status: "
                            + (selectedDoctor.isPresent()
                            ? "Available"
                            : "Not Available")
            );

        });


        // --------------------------------
        // Button action
        // --------------------------------

        bookButton.addActionListener(e -> {

            // Get the selected doctor
            Doctor selectedDoctor =
                    (Doctor) doctorBox.getSelectedItem();

            // Get the selected time
            String selectedTime =
                    (String) timeBox.getSelectedItem();


            // Check if doctor is present
            if (!selectedDoctor.isPresent()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Doctor is not available today."
                );

            }

            // Doctor is present but busy at this time
            else if (!selectedDoctor.isTimeAvailable(selectedTime)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Doctor is busy at this time."
                );

            }

            // Doctor is present and time is available
            else {

                JOptionPane.showMessageDialog(
                        this,
                        "Appointment booked successfully!"
                );
            }

        });


        // --------------------------------
        // Add panel to frame
        // --------------------------------

        add(panel);

        setVisible(true);
    }
}