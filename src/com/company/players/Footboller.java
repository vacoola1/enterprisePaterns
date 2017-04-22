package com.company.players;

/**
 * Created by r.vakulenko on 22.04.2017.
 */
public class Footboller extends Player {
    private int id;
    private String club;

    public Footboller(int id, String name, String club) {
        this.id = id;
        this.name = name;
        this.club = club;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
