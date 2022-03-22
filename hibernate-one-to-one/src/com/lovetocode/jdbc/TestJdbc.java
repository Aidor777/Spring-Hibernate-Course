package com.lovetocode.jdbc;

import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String databaseUrl = "jdbc:mysql://localhost:3306/hb_demo?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String password = "hbstudent";

        System.out.println("Attempting to connect to: " + databaseUrl);
        try (var connection = DriverManager.getConnection(databaseUrl, user, password)) {
            System.out.println("Connection successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
