package com.thoughtWorks.util;

import java.sql.*;


public class DbUtil {
    private String driverName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/management";
    private String userName = "pos";
    private String password = "123";

    Connection connection = null;
   
    public void getConnection(){
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
