package com.meanroom.greatdb.model;

import android.provider.BaseColumns;

/**
 * Created by phuon on 25-Jan-17.
 */
public class Student {


    private long id;
    private String name;



    public Student(String name){
        this.name = name;
    }

    public Student() {

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
