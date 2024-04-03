package CourseAllocationSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement; // Import the correct Statement class

import java.sql.*;

public class conn {

    Connection c;
    Statement s;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///courseallocationsystem", "root",
                    "scfinalprojectcas5");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}