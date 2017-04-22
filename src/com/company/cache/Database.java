package com.company.cache;

import java.sql.*;

/**
 * Created by r.vakulenko on 16.04.2017.
 */
public class Database implements Cacheble {

    @Override
    public ResultSet doSelect(PreparedStatement select) {
        ResultSet productsRs = null;
        try {
            productsRs = select.executeQuery();
        } catch (Exception e) {
        }
        return productsRs;
    }

    private static Connection connectToDatabase() throws SQLException {
        String url = "jdbc:postgresql://localhost/revenue";
        return DriverManager.getConnection(url, "user", "password");
    }

    @Override
    public void executeCRUDOperation(PreparedStatement select) {
        /*NOP*/
    }
}
