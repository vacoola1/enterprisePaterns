package com.company.retryer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by r.vakulenko on 16.04.2017.
 */
public class Connector implements Retryeble {

    private static int failCount = 3;

    @Override
    public Connection connect() throws SQLException {
        if (failCount > 0) {
            failCount--;
            throw new SQLException();
        }
        Connection db = null;
        db = connectToDatabase();
        failCount = 3;
        return db;
    }

    private static Connection connectToDatabase() throws SQLException {
        String url = "jdbc:postgresql://localhost/revenue";
        return DriverManager.getConnection(url, "user", "password");
    }

}
