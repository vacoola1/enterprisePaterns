package com.company.simpleFactory;

/**
 * Created by r.vakulenko on 15.04.2017.
 */
public class NameFactory {

    public Namer getName(String name) throws Exception {
        if ("FirstFirst".equals(name)) {
            return new FirstFirst();
        } else if ("LastFirst".equals(name)) {
            return new LastFirst();
        } else {
            throw new Exception();
        }
    }
}
