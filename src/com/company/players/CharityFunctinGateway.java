package com.company.players;

import com.company.dbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by r.vakulenko on 16.04.2017.
 */
public class CharityFunctinGateway {

    public static ResultSet findAll() {
        ResultSet resultSet = null;
        try {
            Connection db = dbUtil.connectToDatabase();
            PreparedStatement st = db.prepareStatement("SELECT * FROM charity_function");
            resultSet = st.executeQuery();
        } catch (Exception e) {
        }
        return resultSet;
    }

    public static ResultSet find(int charFuncId) {
        ResultSet resultSet = null;
        try {
            Connection db = dbUtil.connectToDatabase();
            PreparedStatement st = db.prepareStatement("SELECT * FROM charity_function WHERE id =?");
            st.setInt(1, charFuncId);
            resultSet = st.executeQuery();
        } catch (Exception e) {
        }
        return resultSet;
    }
}
