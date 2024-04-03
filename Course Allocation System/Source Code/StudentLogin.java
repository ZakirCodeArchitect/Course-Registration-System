package CourseAllocationSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.management.Query;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StudentLogin extends JFrame implements ActionListener {

    // declarig globally
    JTextField tfusername, tfpassword;

    StudentLogin() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null); // to create our own customized layout.

        // For username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);

        // For userpassword
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);

        // Login button for student
        JButton StudentLogin = new JButton("Login");
        StudentLogin.setBounds(150, 140, 150, 30); // Adjusted position and size for StudentLogin button
        StudentLogin.setBackground(Color.WHITE);
        StudentLogin.setForeground(Color.BLACK);
        StudentLogin.addActionListener(this);
        add(StudentLogin);

        // image for login
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        // creating a frame
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }

    // this function will be called on button click
    public void actionPerformed(ActionEvent ae) {

        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();

            conn c = new conn();

            // creating a query
            String query = "select * from StudentLogin where username = '" + username + "' and password = '" + password
                    + "'";

            // executing query
            ResultSet rs = c.s.executeQuery(query); // this will return some value , either value is turned or what.
            if (rs.next()) {
                setVisible(false);
                new StudentHome();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid");
                setVisible(false);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentLogin();
    }

}
