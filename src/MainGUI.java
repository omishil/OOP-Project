import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {

    public MainGUI() {
//title and sizing of the GUI
        setTitle("Hospital Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // tells to exit when cross tapped
        setLocationRelativeTo(null); //so window opens in middle of the screen
//text at center
        JLabel welcomeLabel = new JLabel(
                "Welcome to Hospital Management System",
                SwingConstants.CENTER
        );

        JButton patientButton = new JButton("Patient");
        JButton staffButton = new JButton("Medical Staff");
//panels help organize multiple buttons
        JPanel buttonPanel = new JPanel();
//panel e add
        buttonPanel.add(patientButton);
        buttonPanel.add(staffButton);

        setLayout(new BorderLayout());
//now we have 5 areas
        add(welcomeLabel, BorderLayout.CENTER);//The first CENTER controls the text inside the label.The second CENTER controls the position of the label inside the window.
        add(buttonPanel, BorderLayout.SOUTH);


        // now action listener for buttons being clicked>>>>
        patientButton.addActionListener(e -> {

            new PatientGUI();//The new means “create a new object.”

            dispose(); //closes the current MainGUI window.
        });

        staffButton.addActionListener(e -> {

            new MedicalStaffGUI();

            dispose();
        });

        setVisible(true);
    }
//now to create the obj of the main class MainGUI
    public static void main(String[] args) {
        new MainGUI();
    }
}