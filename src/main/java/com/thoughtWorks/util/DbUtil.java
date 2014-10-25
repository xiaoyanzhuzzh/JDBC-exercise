package com.thoughtWorks.util;

import java.sql.*;

/**
 * Created by zhangzhihui on 14-10-25.
 */
public class DbUtil {
    private String driverName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/management";
    private String userName = "pos";
    private String password = "123";

    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;

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
