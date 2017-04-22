package com.company.players;

import com.company.dbUtil;

import java.sql.*;

/**
 * Created by r.vakulenko on 16.04.2017.
 */
public class PlayerGateway {

    public static ResultSet findAll() {
        ResultSet resultSet = null;
        try {
            Connection db = dbUtil.connectToDatabase();
            PreparedStatement st = db.prepareStatement("SELECT * FROM player");
            resultSet = st.executeQuery();
        } catch (Exception e) {
        }
        return resultSet;
    }

    public static ResultSet find(int playrId) {
        ResultSet resultSet = null;
        try {
            Connection db = dbUtil.connectToDatabase();
            PreparedStatement st = db.prepareStatement("SELECT * FROM player WHERE id =?");
            st.setInt(1, playrId);
            resultSet = st.executeQuery();
        } catch (Exception e) {
        }
        return resultSet;
    }
}
