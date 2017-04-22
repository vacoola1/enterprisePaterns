package com.company.cache;

import java.security.PrivateKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by r.vakulenko on 16.04.2017.
 */
public class CashedBase implements Cacheble {
    private Map<Integer, ResultSet> cacheMap = new HashMap<>();
    private Cacheble database;

    public CashedBase(Cacheble database) {
        this.database = database;
    }

    @Override
    public ResultSet doSelect(PreparedStatement select) {
        final ResultSet resultSet = cacheMap.get(select.hashCode());
        if (resultSet == null) {
            final ResultSet newCached = database.doSelect(select);
            cacheMap.put(select.hashCode(), newCached);
            return newCached;
        } else {
            return resultSet;
        }
    }

    @Override
    public void executeCRUDOperation(PreparedStatement statement) {
        if (evetNeeded(statement)) {
            cacheMap.remove(statement.hashCode());
        }
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    private boolean evetNeeded(PreparedStatement statement) {
        //todo realise
        return true;
    }

}
