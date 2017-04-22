package com.company.players;

/**
 * Created by r.vakulenko on 22.04.2017.
 */
public class CharityFunction {
    int id;
    String name;

    public CharityFunction(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
