package com.company.retryer;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by r.vakulenko on 16.04.2017.
 */
public interface Retryeble {
    Connection connect() throws SQLException;
}
