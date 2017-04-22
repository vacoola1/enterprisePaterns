package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by r.vakulenko on 16.04.2017.
 */
public class dbUtil {
    public static Connection connectToDatabase() throws SQLException {
        String url = "jdbc:postgresql://localhost/revenue";
        return DriverManager.getConnection(url, "user", "password");
    }
}
