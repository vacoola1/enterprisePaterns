package com.company.manualMapper;

import jdk.nashorn.internal.ir.WhileNode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by r.vakulenko on 16.04.2017.
 */
public class ProductMapper {

    public static Product getProduct(ResultSet productRS) {
        Product product = null;
        try {
            if (productRS.next()) {
                product = new Product(productRS.getInt("id"), productRS.getString("name"), productRS.getString("typer"));
                productRS.close();
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {

        }
        return product;
    }

    public static List<Product> getProducts(ResultSet productsRS) {
        List<Product> products = new ArrayList<>();
        try {
            while (productsRS.next()) {
                try {
                    if (productsRS.next()) {
                        products.add(getProduct(productsRS));
                    }
                    return products;
                } catch (Exception e) {
                }
            }
        } catch (SQLException e) {

        }
        return products;
    }
}
