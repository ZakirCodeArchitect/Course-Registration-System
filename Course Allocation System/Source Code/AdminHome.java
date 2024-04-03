package CourseAllocationSystem;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdminHome extends JFrame implements ActionListener {

    JButton offer, view, modify, delete, viewf;

    AdminHome() {

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Admin Interface");
        heading.setBounds(650, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);

        offer = new JButton("Add Course");
        offer.setBounds(650, 80, 150, 40);
        offer.addActionListener(this);
        image.add(offer);

        modify = new JButton("Modify Allocated Course");
        modify.setBounds(820, 80, 150, 40);
        modify.addActionListener(this);
        image.add(modify);

        delete = new JButton("Delete Allocacted Course");
        delete.setBounds(650, 140, 150, 40);
        delete.addActionListener(this);
        image.add(delete);

        view = new JButton("View Allocated Courses");
        view.setBounds(820, 140, 150, 40);
        view.addActionListener(this);
        image.add(view);

        viewf = new JButton("Update Fee Status");
        viewf.setBounds(650, 200, 150, 40);
        viewf.addActionListener(this);
        image.add(viewf);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }

    private void setLayout(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLayout'");
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == offer) {
            setVisible(false);
            new addCourse();
        } else if (ae.getSource() == modify) {
            setVisible(false);
            new viewCourses();
        } else if (ae.getSource() == delete) {

        } else if (ae.getSource() == view) {
            setVisible(false);
            new viewCourses();
        } else if (ae.getSource() == viewf) {

        }

    }

    public static void main(String[] args) {
        new AdminHome();
    }

}
