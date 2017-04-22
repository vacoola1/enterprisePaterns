package com.company.retryer;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by r.vakulenko on 16.04.2017.
 */
public class RetryConnector implements Retryeble {

    private int attamprCount = 10;
    private Retryeble connector;

    public RetryConnector(Retryeble connector) {
        this.connector = connector;
    }

    @Override
    public Connection connect() throws SQLException {
        Connection connection = null;
        try {
            connector.connect();
        } catch (SQLException e) {
            if (attamprCount > 0) {
                attamprCount--;
                this.connect();
            }
            attamprCount = 10;
            throw new SQLException();
        }
        attamprCount = 10;
        return connection;
    }
}
