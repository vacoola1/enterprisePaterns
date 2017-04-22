package com.company.players;

/**
 * Created by r.vakulenko on 22.04.2017.
 */
public class PlayerCharityFunction {
    private Player player;
    private CharityFunction charityFunction;

    public PlayerCharityFunction(Player player, CharityFunction charityFunction) {
        this.player = player;
        this.charityFunction = charityFunction;
    }

    public CharityFunction getCharityFunction() {
        return charityFunction;
    }

    public void setCharityFunction(CharityFunction charityFunction) {
        this.charityFunction = charityFunction;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
