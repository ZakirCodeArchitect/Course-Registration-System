package CourseAllocationSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Splash extends JFrame implements ActionListener {

    Splash() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Course Allocation System");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("LucidaConsole", Font.PLAIN, 60));
        heading.setForeground(Color.DARK_GRAY);

        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);

        JButton Student = new JButton("Student");
        Student.setBounds(350, 550, 200, 40); // Adjusted position and size for Student button
        Student.setBackground(Color.WHITE);
        Student.setForeground(Color.BLACK);
        Student.addActionListener(this); // click event is called here
        add(Student);

        JButton Admin = new JButton("Admin");
        Admin.setBounds(550, 550, 200, 40); // Adjusted position and size for Admin button
        Admin.setBackground(Color.WHITE);
        Admin.setForeground(Color.BLACK);
        Admin.addActionListener(this); // click event is called here
        add(Admin); // to add the button on above the image

        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Admin")) {
            setVisible(false);
            new AdminLogin();
        } else if (ae.getActionCommand().equals("Student")) {
            setVisible(false);
            new StudentLogin();
        }
    }

    public static void main(String args[]) {
        new Splash();
    }
}
