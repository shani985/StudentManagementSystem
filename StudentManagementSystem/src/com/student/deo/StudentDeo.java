package com.student.deo;
import com.student.db.DBConnector;
import com.student.model.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDeo implements StudentDeoInterface{

    @Override
    public boolean insertStudent(Student s) {
        boolean flag = false;
        try {
            Connection con = DBConnector.createConnection();
            String query = "insert into student_detail(Name, clgName, cityName, percentage) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, s.getName());
            pst.setString(2, s.getClgName());
            pst.setString(3, s.getCity());
            pst.setDouble(4, s.getPercentage());

            int result = pst.executeUpdate();
            if (result > 0) {
                flag = true;
            }

            pst.close();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }


    @Override
    public boolean delete(int roll) {
        boolean flag = false;
        try {
            Connection con = DBConnector.createConnection();
            String query = "delete from student_detail where rollNumber = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, roll); // ✅ use parameterized query (prevents SQL injection)

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                flag = true; // ✅ only if something was actually deleted
            }

            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(int roll, String update, int ch, Student s) {
        boolean flag = false;

        try {
            Connection con = DBConnector.createConnection();

            // Step 1: Check if the student exists
            String checkQuery = "SELECT * FROM student_detail WHERE rollNumber = ?";
            PreparedStatement checkStmt = con.prepareStatement(checkQuery);
            checkStmt.setInt(1, roll);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // ✅ Roll number found
                String updateQuery = null;

                if (ch == 1) {
                    updateQuery = "UPDATE student_detail SET name = ? WHERE rollNumber = ?";
                } else if (ch == 2) {
                    updateQuery = "UPDATE student_detail SET clgName = ? WHERE rollNumber = ?";
                } else {
                    System.out.println("Invalid update choice.");
                    return false;
                }

                PreparedStatement updateStmt = con.prepareStatement(updateQuery);
                updateStmt.setString(1, update);
                updateStmt.setInt(2, roll);

                int rowsUpdated = updateStmt.executeUpdate();
                if (rowsUpdated > 0) {
                    flag = true;
                }

                updateStmt.close();

            } else {
                // ❌ Roll number not found
                System.out.println("Student with roll number " + roll + " does not exist.");
            }

            // Close resources
            rs.close();
            checkStmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }



    @Override

        public void showAllStudent() {
            String query = "select * from student_detail";
            try (Connection con = DBConnector.createConnection();
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    System.out.println("RollNumber: " + rs.getInt(1) + "\n" +
                            "Name: " + rs.getString(2) + "\n" +
                            "Clg name: " + rs.getString(3) + "\n" +
                            "City: " + rs.getString(4) + "\n" +
                            "Percentage: " + rs.getDouble(5));
                    System.out.println("----------------------------------");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }





    @Override
    public boolean showStudentBtId(int roll) {
        String query = "select * from student_detail where  rollNumber = "+roll;
        try (Connection con = DBConnector.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("RollNumber: " + rs.getInt(1) + "\n" +
                        "Name: " + rs.getString(2) + "\n" +
                        "Clg name: " + rs.getString(3) + "\n" +
                        "City: " + rs.getString(4) + "\n" +
                        "Percentage: " + rs.getDouble(5));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}


