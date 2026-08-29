import javax.swing.*;
import java.awt.*;

class OtherStaffGUI extends JFrame {

    OtherStaffGUI() {

        setTitle("Other Staff Registration");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel =
                new JPanel(new GridBagLayout());

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(10, 10, 10, 10);


        // --------------------------------
        // Title
        // --------------------------------

        JLabel titleLabel =
                new JLabel("Other Staff Registration");

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
        gbc.gridy = 4;

        panel.add(timeLabel, gbc);

        gbc.gridx = 1;

        panel.add(timeBox, gbc);


        // --------------------------------
        // Add Time
        // --------------------------------

        JButton addTimeButton =
                new JButton("Add Time");

        gbc.gridx = 1;
        gbc.gridy = 5;

        panel.add(addTimeButton, gbc);


        // --------------------------------
        // Selected Times
        // --------------------------------

        JLabel selectedLabel =
                new JLabel("Selected Times:");

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;

        panel.add(selectedLabel, gbc);


        DefaultListModel<String> timeModel =
                new DefaultListModel<>();

        JList<String> timeList =
                new JList<>(timeModel);

        JScrollPane scrollPane =
                new JScrollPane(timeList);

        scrollPane.setPreferredSize(
                new Dimension(180, 80)
        );

        gbc.gridy = 7;

        panel.add(scrollPane, gbc);


        // --------------------------------
        // Register
        // --------------------------------

        JButton registerButton =
                new JButton(
                        "Register & Mark Present"
                );

        gbc.gridy = 8;

        panel.add(registerButton, gbc);


        // --------------------------------
        // Back
        // --------------------------------

        JButton backButton =
                new JButton("Back");

        gbc.gridy = 9;

        panel.add(backButton, gbc);


        // --------------------------------
        // Add Time Action
        // --------------------------------

        addTimeButton.addActionListener(e -> {

            String selectedTime =
                    (String) timeBox.getSelectedItem();

            if (!timeModel.contains(selectedTime)) {

                timeModel.addElement(selectedTime);
            }

        });


        // --------------------------------
        // Register Action
        // --------------------------------

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


            // Create OtherStaff

            OtherStaff staff =
                    new OtherStaff(
                            name,
                            id,
                            age
                    );


            // Add available times

            for (int i = 0;
                 i < timeModel.size();
                 i++) {

                staff.addAvailableTime(
                        timeModel.getElementAt(i)
                );
            }


            // Mark present

            staff.markAttendance(true);


            // Store staff

            HospitalData.otherStaff.add(staff);


            JOptionPane.showMessageDialog(
                    this,
                    "Other staff registered successfully!"
            );

        });


        // --------------------------------
        // Back Action
        // --------------------------------

        backButton.addActionListener(e -> {

            new MedicalStaffGUI();

            dispose();

        });


        add(panel);

        setVisible(true);
    }
}