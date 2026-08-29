import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {

    MainGUI() {

        // --------------------------------
        // Load hospital data
        // --------------------------------

        HospitalData.loadDoctors();


        // --------------------------------
        // Title and sizing
        // --------------------------------

        setTitle("Hospital Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        // --------------------------------
        // Welcome label
        // --------------------------------

        JLabel welcomeLabel =
                new JLabel(
                        "Welcome to Hospital Management System",
                        SwingConstants.CENTER
                );


        // --------------------------------
        // Buttons
        // --------------------------------

        JButton patientButton =
                new JButton("Patient");

        JButton staffButton =
                new JButton("Medical Staff");


        // --------------------------------
        // Button panel
        // --------------------------------

        JPanel buttonPanel =
                new JPanel();

        buttonPanel.add(patientButton);
        buttonPanel.add(staffButton);


        // --------------------------------
        // Layout
        // --------------------------------

        setLayout(new BorderLayout());

        add(
                welcomeLabel,
                BorderLayout.CENTER
        );

        add(
                buttonPanel,
                BorderLayout.SOUTH
        );


        // --------------------------------
        // Patient button
        // --------------------------------

        patientButton.addActionListener(e -> {

            new PatientGUI();

            dispose();
        });


        // --------------------------------
        // Medical Staff button
        // --------------------------------

        staffButton.addActionListener(e -> {

            new MedicalStaffGUI();

            dispose();
        });


        // ----
        // ----------------------------
        // Show window
        // --------------------------------

        setVisible(true);
    }


    // --------------------------------
    // Main method
    // --------------------------------

    public static void main(String[] args) {

        new MainGUI();
    }
}