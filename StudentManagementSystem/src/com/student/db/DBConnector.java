package com.student.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    static Connection con;

    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String pass = "shani";
            String url = "jdbc:mysql://localhost:3306/student?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con; //
    }
}
