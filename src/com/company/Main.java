package com.company;

import com.company.cache.CashedBase;
import com.company.cache.Database;
import com.company.cache.PrimalCachedBase;
import com.company.manualMapper.Product;
import com.company.manualMapper.ProductGateway;
import com.company.manualMapper.ProductMapper;
import com.company.players.CharityFunctinGateway;
import com.company.players.Mapper;
import com.company.players.PlayerCharityFunction;
import com.company.retryer.Connector;
import com.company.retryer.RetryConnector;
import com.company.revenueRecognition.TranzactionRecognition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //1
        TranzactionRecognition.doRecognition(123);

        //2
        final List<Product> products = ProductMapper.getProducts(ProductGateway.findAll());

        //3
        try {
            Connection connect = new RetryConnector(new Connector()).connect();
        } catch (SQLException e) {}

        //4
        try {
            Connection db = dbUtil.connectToDatabase();
            List<PreparedStatement> primedStatments = new ArrayList<>();
            primedStatments.add(db.prepareStatement("SELECT id, name FROM product"));
            primedStatments.add(db.prepareStatement("SELECT id, typer FROM product"));
            primedStatments.add(db.prepareStatement("SELECT name, typer FROM product"));

            PreparedStatement st = db.prepareStatement("SELECT id, name, typer FROM product");
            ResultSet resultSet = new PrimalCachedBase(new CashedBase(new Database()), primedStatments).doSelect(st);


        } catch (SQLException e) {
            e.printStackTrace();
        }


        //5

        List<PlayerCharityFunction> playerCharityFunctions =Mapper.getPlayerCharityFunctions(CharityFunctinGateway.findAll());

    }
}
