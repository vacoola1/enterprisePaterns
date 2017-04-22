package com.company.manualMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by r.vakulenko on 16.04.2017.
 */
public class ProductGateway {

    public static ResultSet findAll() {
        ResultSet productsRs = null;
        try {
            Connection db = connectToDatabase();
            PreparedStatement st = db.prepareStatement("SELECT id, name, typer FROM product");
            productsRs = st.executeQuery();
        } catch (Exception e) {
        }
        return productsRs;
    }

    private static Connection connectToDatabase() throws SQLException {
        String url = "jdbc:postgresql://localhost/revenue";
        return DriverManager.getConnection(url, "user", "password");
    }

}
