package com.company.cache;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by r.vakulenko on 16.04.2017.
 */
public interface Cacheble {
    ResultSet doSelect(PreparedStatement select);

    void executeCRUDOperation(PreparedStatement select);

    void cleanCash(PreparedStatement statement);

}
