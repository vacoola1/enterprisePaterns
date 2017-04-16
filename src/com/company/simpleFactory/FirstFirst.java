package com.company.simpleFactory;

/**
 * Created by r.vakulenko on 15.04.2017.
 */
public class FirstFirst implements Namer {

    private String frName;
    private String lastName;

    @Override
    public String getName() {
        return frName+frName;
    }
}
