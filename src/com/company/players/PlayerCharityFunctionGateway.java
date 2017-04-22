package com.company.players;

import com.company.dbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by r.vakulenko on 22.04.2017.
 */
public class PlayerCharityFunctionGateway {

    public static ResultSet findAll() {
        ResultSet resultSet = null;
        try {
            Connection db = dbUtil.connectToDatabase();
            PreparedStatement st = db.prepareStatement("SELECT * FROM player_charity_function");
            resultSet = st.executeQuery();
        } catch (Exception e) {
        }
        return resultSet;
    }
}
