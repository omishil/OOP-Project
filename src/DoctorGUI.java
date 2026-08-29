import javax.swing.*;
import java.awt.*;

class DoctorGUI extends JFrame {

    DoctorGUI() {

        setTitle("Doctor Registration");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // --------------------------------
        // Main panel
        // --------------------------------

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);


        // --------------------------------
        // Title
        // --------------------------------

        JLabel titleLabel =
                new JLabel("Doctor Registration");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        panel.add(titleLabel, gbc);


        // --------------------------------
        // Name
        // --------------------------------

        JLabel nameLabel =
                new JLabel("Name:");

        JTextField nameField =
                new JTextField(15);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;

        panel.add(nameLabel, gbc);

        gbc.gridx = 1;

        panel.add(nameField, gbc);


        // --------------------------------
        // ID
        // --------------------------------

        JLabel idLabel =
                new JLabel("ID:");

        JTextField idField =
                new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 2;

        panel.add(idLabel, gbc);

        gbc.gridx = 1;

        panel.add(idField, gbc);


        // --------------------------------
        // Age
        // --------------------------------

        JLabel ageLabel =
                new JLabel("Age:");

        JTextField ageField =
                new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 3;

        panel.add(ageLabel, gbc);

        gbc.gridx = 1;

        panel.add(ageField, gbc);


        // --------------------------------
        // Specialization
        // --------------------------------

        JLabel specializationLabel =
                new JLabel("Specialization:");

        JTextField specializationField =
                new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 4;

        panel.add(specializationLabel, gbc);

        gbc.gridx = 1;

        panel.add(specializationField, gbc);


        // --------------------------------
        // Available time
        // --------------------------------

        JLabel timeLabel =
                new JLabel("Available Time:");

        String[] times = {
                "9:00 AM",
                "10:00 AM",
                "11:00 AM",
                "12:00 PM",
                "2:00 PM",
                "3:00 PM",
                "4:00 PM"
        };

        JComboBox<String> timeBox =
                new JComboBox<>(times);

        JButton addTimeButton =
                new JButton("Add Time");

        gbc.gridx = 0;
        gbc.gridy = 5;

        panel.add(timeLabel, gbc);

        gbc.gridx = 1;

        panel.add(timeBox, gbc);


        // --------------------------------
        // Add time button
        // --------------------------------

        gbc.gridx = 1;
        gbc.gridy = 6;

        panel.add(addTimeButton, gbc);


        // --------------------------------
        // Available times display
        // --------------------------------

        JLabel availableLabel =
                new JLabel("Selected Times:");

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;

        panel.add(availableLabel, gbc);


        DefaultListModel<String> timeModel =
                new DefaultListModel<>();

        JList<String> timeList =
                new JList<>(timeModel);

        JScrollPane scrollPane =
                new JScrollPane(timeList);

        scrollPane.setPreferredSize(
                new Dimension(180, 80)
        );

        gbc.gridy = 8;

        panel.add(scrollPane, gbc);


        // --------------------------------
        // Register button
        // --------------------------------

        JButton registerButton =
                new JButton("Register & Mark Present");

        gbc.gridy = 9;

        panel.add(registerButton, gbc);


        // --------------------------------
        // Back button
        // --------------------------------

        JButton backButton =
                new JButton("Back");

        gbc.gridy = 10;

        panel.add(backButton, gbc);


        // --------------------------------
        // Add time action
        // --------------------------------

        addTimeButton.addActionListener(e -> {

            String selectedTime =
                    (String) timeBox.getSelectedItem();

            if (!timeModel.contains(selectedTime)) {

                timeModel.addElement(selectedTime);
            }

        });


        // --------------------------------
        // Register button action
        // --------------------------------

        registerButton.addActionListener(e -> {

            String name =
                    nameField.getText();

            String idText =
                    idField.getText();

            String ageText =
                    ageField.getText();

            String specialization =
                    specializationField.getText();


            // Convert ID and age

            int id =
                    Integer.parseInt(idText);

            int age =
                    Integer.parseInt(ageText);


            // Create Doctor object

            Doctor doctor =
                    new Doctor(
                            name,
                            id,
                            age,
                            specialization
                    );


            // Add available times

            for (int i = 0; i < timeModel.size(); i++) {

                doctor.addAvailableTime(
                        timeModel.getElementAt(i)
                );
            }


            // Mark doctor present

            doctor.markAttendance(true);


            // Store doctor

            HospitalData.doctors.add(doctor);


            JOptionPane.showMessageDialog(
                    this,
                    "Doctor registered successfully!"
            );

        });


        // --------------------------------
        // Back button action
        // --------------------------------

        backButton.addActionListener(e -> {

            new MedicalStaffGUI();

            dispose();

        });


        // --------------------------------
        // Add panel to frame
        // --------------------------------

        add(panel);

        setVisible(true);
    }
}