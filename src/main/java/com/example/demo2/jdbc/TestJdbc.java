package com.example.demo2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String user ="root";
        String pass = "123456";

        try {
            System.out.println("Connectin to database: "+jdbcUrl);

            Connection myConn= DriverManager.getConnection(jdbcUrl,user,pass);

            System.out.println("Connection Successful!");
        } catch (Exception e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
    }
}
