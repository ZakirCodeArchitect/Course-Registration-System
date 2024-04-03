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
import java.sql.*;

public class modifyCourse extends JFrame implements ActionListener {

    JButton allocate, back;
    JTextField tfname, tfsemester, tfprogram;
    JComboBox<String> programComboBox, semesterComboBox;
    JLabel semesterLabel, programLabel, lablename;
    String semester;

    modifyCourse(String semester) {
        this.semester = semester;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Modify Course Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN SERIF", Font.BOLD, 25));
        add(heading);

        // Semester
        semesterLabel = new JLabel("Semester");
        semesterLabel.setBounds(50, 150, 150, 30);
        semesterLabel.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        add(semesterLabel);

        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(200, 150, 150, 30);
        add(lblsemester);

        // Program
        programLabel = new JLabel("Program");
        programLabel.setBounds(400, 150, 150, 30);
        programLabel.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        add(programLabel);

        JLabel lblprogram = new JLabel();
        lblprogram.setBounds(600, 150, 150, 30);
        add(lblprogram);

        // Course Name
        lablename = new JLabel("Course Name");
        lablename.setBounds(400, 200, 150, 30);
        lablename.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        add(lablename);

        tfname = new JTextField();
        tfname.setBounds(600, 200, 150, 30);
        add(tfname);

        try {

            conn c = new conn();
            String query = "Select * from courses  where Semester = '" + semester + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblsemester.setText(rs.getString("Semester"));
                lblprogram.setText(rs.getString("Program"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

            // Now storing all the data in database
            try {
                conn c = new conn();
                String query = "update courses set courseName = '" + courseName + "' where Semester = '" + Semester
                        + "'";
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
        new modifyCourse("");
    }

}
