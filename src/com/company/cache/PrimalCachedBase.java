package com.company.cache;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by r.vakulenko on 16.04.2017.
 */
public class PrimalCachedBase implements Cacheble {

    private Map<Integer, ResultSet> cacheMap = new HashMap<>();
    private Cacheble database;

    public PrimalCachedBase(Cacheble database, List<PreparedStatement> statementList) {
        this.database = database;
        for (PreparedStatement statement : statementList) {
            cacheMap.put(statement.hashCode(), database.doSelect(statement));
        }
    }

    @Override
    public ResultSet doSelect(PreparedStatement select) {
        final ResultSet resultSet = cacheMap.get(select.hashCode());
        if (resultSet == null) {
            return database.doSelect(select);
        } else {
            return resultSet;
        }
    }

    @Override
    public void executeCRUDOperation(PreparedStatement select) {

    }
}
