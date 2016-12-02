package com.Model;

/**
 * Created by Marko on 13.9.2016..
 */
public class DataProvider {

    private String name;
    private String email;
    private String task;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataProvider(String name, String email)
    {
        this.name = name;
        this.email = email;
        this.task = task;

    }
}
