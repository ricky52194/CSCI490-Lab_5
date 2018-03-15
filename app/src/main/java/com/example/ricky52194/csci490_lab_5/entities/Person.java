package com.example.ricky52194.csci490_lab_5.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ricky52194 on 3/15/18.
 */

@Entity
public class Person {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

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
