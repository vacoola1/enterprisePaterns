package com.company.revenueRecognition;

import java.sql.*;
import java.time.temporal.ChronoUnit;

/**
 * Created by r.vakulenko on 15.04.2017.
 */
public class TranzactionRecognition {

    public static void doRecognition(int contractId) {
        try {
            Connection db = connectToDatabase();
            PreparedStatement st = db.prepareStatement("SELECT id, procuct, product.typer AS typer, revenue, date_signed  FROM contracts WHERE id=?");
            st.setInt(1, contractId);
            ResultSet contract = st.executeQuery();
            if (contract.next()) {
                String type = contract.getString("typer");
                Double revenue = contract.getDouble("revenue");
                Date signedDate = contract.getDate("date_signed");

                st = db.prepareStatement("INSERT INTO revenue_recognitions (contract, amount, recognized_on ) VALUES (?, ?, ?)");
                st.setInt(1, contractId);
                if ("word".equals(type)) {
                    insertRecognition(st, revenue, signedDate);
                } else if ("database".equals(type)) {
                    insertRecognition(st, revenue / 3, signedDate);
                    insertRecognition(st, revenue / 3, Date.valueOf(signedDate.toLocalDate().plus(60, ChronoUnit.DAYS)));
                    insertRecognition(st, revenue / 3, Date.valueOf(signedDate.toLocalDate().plus(90, ChronoUnit.DAYS)));
                } else if ("spreadsheet".equals(type)) {
                    insertRecognition(st, revenue / 3, signedDate);
                    insertRecognition(st, revenue / 3, Date.valueOf(signedDate.toLocalDate().plus(30, ChronoUnit.DAYS)));
                    insertRecognition(st, revenue / 3, Date.valueOf(signedDate.toLocalDate().plus(60, ChronoUnit.DAYS)));
                }
            }
        } catch (SQLException e) {}
    }

    private static void insertRecognition(PreparedStatement st, Double revenue, Date recognitionDate) throws SQLException {
        st.setDouble(2, revenue);
        st.setDate(3, recognitionDate);
        st.executeUpdate();
    }

    private static Connection connectToDatabase() throws SQLException {
        String url = "jdbc:postgresql://localhost/revenue";
        return DriverManager.getConnection(url, "user", "password");
    }
}
