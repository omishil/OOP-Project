import javax.swing.*;
import java.awt.*;

class SurgeonGUI extends JFrame {

    // --------------------------------
    // Current surgeon
    // --------------------------------

    Surgeon currentSurgeon;


    SurgeonGUI() {

        setTitle("Surgeon Portal");
        setSize(650, 750);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        // ========================================
        // Main Panel
        // ========================================

        JPanel panel =
                new JPanel(new GridBagLayout());

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(8, 8, 8, 8);


        // ========================================
        // SURGEON REGISTRATION
        // ========================================

        JLabel titleLabel =
                new JLabel("Surgeon Registration");

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
        // Available Time
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

        gbc.gridx = 0;
        gbc.gridy = 5;

        panel.add(timeLabel, gbc);

        gbc.gridx = 1;

        panel.add(timeBox, gbc);


        // --------------------------------
        // Add Time
        // --------------------------------

        JButton addTimeButton =
                new JButton("Add Time");

        gbc.gridx = 1;
        gbc.gridy = 6;

        panel.add(addTimeButton, gbc);


        // --------------------------------
        // Selected Surgery Times
        // --------------------------------

        JLabel selectedLabel =
                new JLabel("Selected Surgery Times:");

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;

        panel.add(selectedLabel, gbc);


        DefaultListModel<String> timeModel =
                new DefaultListModel<>();

        JList<String> timeList =
                new JList<>(timeModel);

        JScrollPane timeScrollPane =
                new JScrollPane(timeList);

        timeScrollPane.setPreferredSize(
                new Dimension(180, 70)
        );

        gbc.gridy = 8;

        panel.add(timeScrollPane, gbc);


        // --------------------------------
        // Register Surgeon
        // --------------------------------

        JButton registerButton =
                new JButton(
                        "Register & Mark Present"
                );

        gbc.gridy = 9;

        panel.add(registerButton, gbc);


        // ========================================
        // STAFF ASSISTANCE
        // ========================================

        JLabel assistanceLabel =
                new JLabel("Surgery Staff Assistance");

        gbc.gridy = 10;

        panel.add(assistanceLabel, gbc);


        // --------------------------------
        // Surgery Time
        // --------------------------------

        JLabel surgeryTimeLabel =
                new JLabel("Surgery Time:");

        JComboBox<String> surgeryTimeBox =
                new JComboBox<>();

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 1;

        panel.add(surgeryTimeLabel, gbc);

        gbc.gridx = 1;

        panel.add(surgeryTimeBox, gbc);


        // --------------------------------
        // Nurse
        // --------------------------------

        JLabel nurseLabel =
                new JLabel("Available Nurse:");

        JComboBox<Nurse> nurseBox =
                new JComboBox<>();

        gbc.gridx = 0;
        gbc.gridy = 12;

        panel.add(nurseLabel, gbc);

        gbc.gridx = 1;

        panel.add(nurseBox, gbc);


        // --------------------------------
        // Other Staff
        // --------------------------------

        JLabel staffLabel =
                new JLabel("Available Other Staff:");

        JComboBox<OtherStaff> staffBox =
                new JComboBox<>();

        gbc.gridx = 0;
        gbc.gridy = 13;

        panel.add(staffLabel, gbc);

        gbc.gridx = 1;

        panel.add(staffBox, gbc);


        // --------------------------------
        // Book Assistance
        // --------------------------------

        JButton bookAssistanceButton =
                new JButton(
                        "Book Staff Assistance"
                );

        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 2;

        panel.add(
                bookAssistanceButton,
                gbc
        );


        // --------------------------------
        // Back
        // --------------------------------

        JButton backButton =
                new JButton("Back");

        gbc.gridy = 15;

        panel.add(backButton, gbc);


        // ========================================
        // ADD TIME
        // ========================================

        addTimeButton.addActionListener(e -> {

            String selectedTime =
                    (String) timeBox.getSelectedItem();


            if (!timeModel.contains(selectedTime)) {

                timeModel.addElement(
                        selectedTime
                );
            }

        });


        // ========================================
        // REGISTER SURGEON
        // ========================================

        registerButton.addActionListener(e -> {

            String name =
                    nameField.getText();

            int id =
                    Integer.parseInt(
                            idField.getText()
                    );

            int age =
                    Integer.parseInt(
                            ageField.getText()
                    );

            String specialization =
                    specializationField.getText();


            // Create current surgeon

            currentSurgeon =
                    new Surgeon(
                            name,
                            id,
                            age,
                            specialization
                    );


            // Add available times

            for (int i = 0; i < timeModel.size(); i++) {

                currentSurgeon.addAvailableTime(
                        timeModel.getElementAt(i)
                );
            }


            // Mark present

            currentSurgeon.markAttendance(true);


            // Store surgeon

            HospitalData.doctors.add(
                    currentSurgeon
            );


            // Update surgery times

            surgeryTimeBox.removeAllItems();

            for (String time :
                    currentSurgeon.getAvailableTimes()) {

                surgeryTimeBox.addItem(time);
            }


            JOptionPane.showMessageDialog(
                    this,
                    "Surgeon registered and marked present!"
            );

        });


        // ========================================
        // SURGERY TIME SELECTION
        // ========================================

        surgeryTimeBox.addActionListener(e -> {

            String selectedTime =
                    (String) surgeryTimeBox.getSelectedItem();


            if (selectedTime == null) {

                return;
            }


            // Clear old staff

            nurseBox.removeAllItems();

            staffBox.removeAllItems();


            // --------------------------------
            // Check if surgeon is available
            // --------------------------------

            if (currentSurgeon == null) {

                return;
            }


            if (!currentSurgeon.isPresent()) {

                return;
            }


            if (!currentSurgeon.isTimeAvailable(
                    selectedTime)) {

                return;
            }


            // --------------------------------
            // Find available nurses
            // --------------------------------

            for (Nurse nurse :
                    HospitalData.nurses) {

                if (nurse.isPresent()
                        && nurse.isTimeAvailable(
                        selectedTime)) {

                    nurseBox.addItem(nurse);
                }
            }


            // --------------------------------
            // Find available other staff
            // --------------------------------

            for (OtherStaff staff :
                    HospitalData.otherStaff) {

                if (staff.isPresent()
                        && staff.isTimeAvailable(
                        selectedTime)) {

                    staffBox.addItem(staff);
                }
            }

        });


        // ========================================
        // BOOK STAFF ASSISTANCE
        // ========================================

        bookAssistanceButton.addActionListener(e -> {

            String selectedTime =
                    (String) surgeryTimeBox.getSelectedItem();

            Nurse selectedNurse =
                    (Nurse) nurseBox.getSelectedItem();

            OtherStaff selectedStaff =
                    (OtherStaff) staffBox.getSelectedItem();


            // --------------------------------
            // Check surgeon
            // --------------------------------

            if (currentSurgeon == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please register the surgeon first."
                );

                return;
            }


            // --------------------------------
            // Check surgery time
            // --------------------------------

            if (selectedTime == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a surgery time."
                );

                return;
            }


            // --------------------------------
            // Check surgeon availability
            // --------------------------------

            if (!currentSurgeon.isPresent()
                    || !currentSurgeon.isTimeAvailable(
                    selectedTime)) {

                JOptionPane.showMessageDialog(
                        this,
                        "The surgeon is not available at this time."
                );

                return;
            }


            // --------------------------------
            // At least one staff member
            // --------------------------------

            if (selectedNurse == null
                    && selectedStaff == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "No staff is available at this time."
                );

                return;
            }


            // --------------------------------
            // Book Nurse
            // --------------------------------

            if (selectedNurse != null) {

                selectedNurse.removeAvailableTime(
                        selectedTime
                );
            }


            // --------------------------------
            // Book Other Staff
            // --------------------------------

            if (selectedStaff != null) {

                selectedStaff.removeAvailableTime(
                        selectedTime
                );
            }


            // --------------------------------
            // Remove surgeon's time
            // --------------------------------

            currentSurgeon.removeAvailableTime(
                    selectedTime
            );


            // Remove from GUI

            surgeryTimeBox.removeItem(
                    selectedTime
            );


            nurseBox.removeAllItems();

            staffBox.removeAllItems();


            JOptionPane.showMessageDialog(
                    this,
                    "Staff assistance booked successfully!"
            );

        });


        // ========================================
        // BACK
        // ========================================

        backButton.addActionListener(e -> {

            new DoctorTypeGUI();

            dispose();

        });


        // ========================================
        // Add panel
        // ========================================

        add(panel);

        setVisible(true);
    }
}