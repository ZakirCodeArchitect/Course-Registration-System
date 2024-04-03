package CourseAllocationSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class addCourse extends JFrame implements ActionListener {

    JButton allocate, back;
    JTextField tfname, tfsemester, tfprogram;
    JComboBox<String> programComboBox, semesterComboBox;
    JLabel semesterLabel, programLabel, lablename;

    addCourse() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD Courses");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN SERIF", Font.BOLD, 25));
        add(heading);

        // Semester
        semesterLabel = new JLabel("Semester");
        semesterLabel.setBounds(50, 150, 150, 30);
        semesterLabel.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        add(semesterLabel);

        tfsemester = new JTextField();
        tfsemester.setBounds(200, 150, 150, 30);
        add(tfsemester);

        // Program
        programLabel = new JLabel("Program");
        programLabel.setBounds(400, 150, 150, 30);
        programLabel.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        add(programLabel);

        tfprogram = new JTextField();
        tfprogram.setBounds(600, 150, 150, 30);
        add(tfprogram);
        /*
         * // for the drop-down menu
         * String[] programOptions = { "BS", "MS", "M-Phil", "PH-D" };
         * programComboBox = new JComboBox<>(programOptions);
         * programComboBox.setBounds(600, 150, 150, 30);
         * add(programComboBox);
         */

        // Course Name
        lablename = new JLabel("Course Name");
        lablename.setBounds(400, 200, 150, 30);
        lablename.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        add(lablename);

        tfname = new JTextField();
        tfname.setBounds(600, 200, 150, 30);
        add(tfname);

        // Back button
        back = new JButton("Back");
        back.setBounds(400, 250, 150, 30); // Adjusted position and size for backButton
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Allocate Course button
        allocate = new JButton("Allocate Course");
        allocate.setBounds(600, 250, 150, 30);
        allocate.setBackground(Color.BLACK);
        allocate.setForeground(Color.WHITE);
        allocate.addActionListener(this);
        add(allocate);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == allocate) {

            // extracting data that was input from the user
            String courseName = tfname.getText();
            String Semester = tfsemester.getText();
            String Program = tfprogram.getText();
            // String Semester = (String) semesterComboBox.getSelectedItem();
            // String Program = (String) programComboBox.getSelectedItem(); // typecasting
            // becuase object is returning

            // Now storing all the data in database
            try {
                conn c = new conn();
                String query = "insert into courses values('" + courseName + "', '" + Semester + "', '" + Program
                        + "')"; // writing
                                // query
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Course Allocated successfully");
                setVisible(false);
                new AdminHome();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new AdminHome();

        }

    }

    public static void main(String[] args) {
        new addCourse();
    }

}
