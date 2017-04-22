package com.company.manualMapper;

/**
 * Created by r.vakulenko on 16.04.2017.
 */
public class Product {
    private Integer id;
    private String Name;
    private String typeR;

    public Product(Integer id, String name, String typeR) {
        this.id = id;
        Name = name;
        this.typeR = typeR;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getTypeR() {
        return typeR;
    }
    public void setTypeR(String typeR) {
        this.typeR = typeR;
    }
}
