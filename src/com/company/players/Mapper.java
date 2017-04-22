package com.company.players;

import com.company.manualMapper.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by r.vakulenko on 16.04.2017.
 */
public class Mapper {

    private static final String TYPE_FOOTBOLLER = "foot";
    private static final String TYPE_CRICKETER = "cric";

    public static Footboller getFootboller(ResultSet rs) {
        Footboller footboller  = null;
        try {
            if (rs.next()) {
                footboller = new Footboller(rs.getInt("id"), rs.getString("name"), rs.getString("club"));
                rs.close();
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {

        }
        return footboller;
    }

    public static List<Footboller> getFootbollers(ResultSet rs) {
        List<Footboller> footbollers = new ArrayList<>();
        try {
            while (rs.next()) {
                try {
                    if (rs.next()) {
                        footbollers.add(getFootboller(rs));
                    }
                    return footbollers;
                } catch (Exception e) {
                }
            }
        } catch (SQLException e) {

        }
        return footbollers;
    }

    public static Cricketer getCricketer(ResultSet rs) {
        Cricketer cricketer  = null;
        try {
            if (rs.next()) {
                cricketer = new Cricketer(rs.getInt("id"), rs.getString("name"), rs.getString("batting_avarage"));
                rs.close();
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {

        }
        return cricketer;
    }

    public static List<Cricketer> getCricketers(ResultSet rs) {
        List<Cricketer> cricketers = new ArrayList<>();
        try {
            while (rs.next()) {
                try {
                    if (rs.next()) {
                        cricketers.add(getCricketer(rs));
                    }
                    return cricketers;
                } catch (Exception e) {
                }
            }
        } catch (SQLException e) {

        }
        return cricketers;
    }

    public static CharityFunction getCharityFunction(ResultSet rs) {
        CharityFunction charityFunction  = null;
        try {
            if (rs.next()) {
                charityFunction = new CharityFunction(rs.getInt("is"), rs.getString("name"));
                rs.close();
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {

        }
        return charityFunction;
    }

    public static List<CharityFunction> getCharityFunctions(ResultSet rs) {
        List<CharityFunction> charityFunctions = new ArrayList<>();
        try {
            while (rs.next()) {
                try {
                    if (rs.next()) {
                        charityFunctions.add(getCharityFunction(rs));
                    }
                    return charityFunctions;
                } catch (Exception e) {
                }
            }
        } catch (SQLException e) {

        }
        return charityFunctions;
    }

    public static PlayerCharityFunction getPlayerCharityFunction(ResultSet rs) {
        PlayerCharityFunction playerCharityFunction  = null;
        try {
            if (rs.next()) {
                int playrId = rs.getInt("player_id");
                int charityId = rs.getInt("charity_function_id");
                ResultSet playerRs = PlayerGateway.find(playrId);
                Player player = null;
                if (TYPE_FOOTBOLLER.equals(playerRs.getString("type"))) {
                    player = getFootboller(playerRs);
                } else if (TYPE_CRICKETER.equals(playerRs.getString("type"))) {
                    player = getCricketer(playerRs);
                }
                CharityFunction charityFunction = getCharityFunction(CharityFunctinGateway.find(charityId));
                playerCharityFunction = new PlayerCharityFunction(player, charityFunction);
                rs.close();
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {

        }
        return playerCharityFunction;
    }

    public static List<PlayerCharityFunction> getPlayerCharityFunctions(ResultSet rs) {
        List<PlayerCharityFunction> playerCharityFunctions = new ArrayList<>();
        try {
            while (rs.next()) {
                try {
                    if (rs.next()) {
                        playerCharityFunctions.add(getPlayerCharityFunction(rs));
                    }
                    return playerCharityFunctions;
                } catch (Exception e) {
                }
            }
        } catch (SQLException e) {

        }
        return playerCharityFunctions;
    }
}
