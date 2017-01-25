package com.meanroom.greatdb.model;

/**
 * Created by phuon on 25-Jan-17.
 */
public class Teacher {

    private  long id;
    private String name;


    public Teacher(String name){
        this.name = name;
    }

    public Teacher() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
