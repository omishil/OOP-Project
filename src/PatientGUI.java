import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class PatientGUI extends JFrame {

    PatientGUI() {

        setTitle("Patient Portal");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        // --------------------------------
        // Main panel
        // --------------------------------

        JPanel panel =
                new JPanel(new GridBagLayout());

        GridBagConstraints gbc =
                new GridBagConstraints();


        // --------------------------------
        // Get doctors from HospitalData
        // --------------------------------

        ArrayList<Doctor> doctors =
                HospitalData.doctors;


        // --------------------------------
        // Welcome label
        // --------------------------------

        JLabel welcomeLabel =
                new JLabel("Welcome to Patient Portal");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets =
                new Insets(10, 10, 20, 10);

        panel.add(welcomeLabel, gbc);


        // --------------------------------
        // Choose doctor label
        // --------------------------------

        JLabel doctorLabel =
                new JLabel("Choose your doctor:");

        gbc.gridy = 1;
        gbc.insets =
                new Insets(10, 10, 10, 10);

        panel.add(doctorLabel, gbc);


        // --------------------------------
        // Doctor dropdown
        // --------------------------------

        JComboBox<Doctor> doctorBox =
                new JComboBox<>();

        for (Doctor doctor : doctors) {

            doctorBox.addItem(doctor);
        }

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

        panel.add(
                specializationLabel,
                gbc
        );


        gbc.gridy = 4;

        panel.add(
                statusLabel,
                gbc
        );


        // --------------------------------
        // Choose time label
        // --------------------------------

        JLabel timeLabel =
                new JLabel(
                        "Choose appointment time:"
                );

        gbc.gridy = 5;

        panel.add(timeLabel, gbc);


        // --------------------------------
        // Time dropdown
        // --------------------------------

        JComboBox<String> timeBox =
                new JComboBox<>();

        gbc.gridy = 6;

        panel.add(timeBox, gbc);


        // --------------------------------
        // Book appointment button
        // --------------------------------

        JButton bookButton =
                new JButton(
                        "Book Appointment"
                );

        gbc.gridy = 7;

        gbc.insets =
                new Insets(
                        20,
                        10,
                        10,
                        10
                );

        panel.add(bookButton, gbc);


        // --------------------------------
        // Back button
        // --------------------------------

        JButton backButton =
                new JButton("Back");

        gbc.gridy = 8;

        panel.add(backButton, gbc);


        // --------------------------------
        // Doctor selection action
        // --------------------------------

        doctorBox.addActionListener(e -> {

            Doctor selectedDoctor =
                    (Doctor)
                            doctorBox.getSelectedItem();


            if (selectedDoctor == null) {

                return;
            }


            // Display specialization

            specializationLabel.setText(
                    "Specialization: "
                            + selectedDoctor
                            .getSpecialization()
            );


            // Display attendance status

            statusLabel.setText(
                    "Status: "
                            + (
                            selectedDoctor.isPresent()
                                    ? "Available"
                                    : "Not Available"
                    )
            );


            // --------------------------------
            // Update available times
            // --------------------------------

            timeBox.removeAllItems();


            for (
                    String time :
                    selectedDoctor
                            .getAvailableTimes()
            ) {

                timeBox.addItem(time);
            }

        });


        // --------------------------------
        // Book button action
        // --------------------------------

        bookButton.addActionListener(e -> {

            // Get selected doctor

            Doctor selectedDoctor =
                    (Doctor)
                            doctorBox.getSelectedItem();


            // Get selected time

            String selectedTime =
                    (String)
                            timeBox.getSelectedItem();


            // Check doctor

            if (selectedDoctor == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a doctor."
                );

                return;
            }


            // Check time

            if (selectedTime == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select an appointment time."
                );

                return;
            }


            // Check doctor attendance

            if (!selectedDoctor.isPresent()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Doctor is not available today."
                );

            }


            // Check time availability

            else if (
                    !selectedDoctor
                            .isTimeAvailable(
                                    selectedTime
                            )
            ) {

                JOptionPane.showMessageDialog(
                        this,
                        "Doctor is busy at this time."
                );

            }


            // Successful booking

            else {

                selectedDoctor
                        .removeAvailableTime(
                                selectedTime
                        );

                timeBox.removeItem(
                        selectedTime
                );


                JOptionPane.showMessageDialog(
                        this,
                        "Appointment booked successfully!"
                );
            }

        });


        // --------------------------------
        // Back button action
        // --------------------------------

        backButton.addActionListener(e -> {

            new MainGUI();

            dispose();

        });


        // --------------------------------
        // Add panel
        // --------------------------------

        add(panel);

        setVisible(true);
    }
}