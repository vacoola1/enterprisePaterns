package com.company.players;

/**
 * Created by r.vakulenko on 22.04.2017.
 */
public class Cricketer extends Player {

    private int id;
    private String BattingAvaragge;

    public Cricketer(int id, String name,  String battingAvaragge) {
        this.id = id;
        this.name = name;
        this.BattingAvaragge = battingAvaragge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBattingAvaragge() {
        return BattingAvaragge;
    }

    public void setBattingAvaragge(String battingAvaragge) {
        BattingAvaragge = battingAvaragge;
    }
}
