package CourseAllocationSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class viewCourses extends JFrame implements ActionListener {

    JTable table;
    Choice csemester;
    JButton search, print, modify, back;

    viewCourses() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchlbl = new JLabel("Search by Course Code");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);

        csemester = new Choice();
        csemester.setBounds(180, 20, 150, 20);
        add(csemester);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from courses");
            while (rs.next()) {
                csemester.add(rs.getString("Semester"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from courses");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        modify = new JButton("Modify");
        modify.setBounds(220, 70, 80, 20);
        modify.addActionListener(this);
        add(modify);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from courses where Semester='" + csemester.getSelectedItem() + "'";

            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == modify) {
            setVisible(false);
            new modifyCourse(csemester.getSelectedItem());
        } else if (ae.getSource() == print) {
            try {
                table.print();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new AdminHome();
        }
    }

    public static void main(String[] args) {
        new viewCourses();
    }
}
