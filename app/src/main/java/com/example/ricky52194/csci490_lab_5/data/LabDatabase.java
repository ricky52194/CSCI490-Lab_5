package com.example.ricky52194.csci490_lab_5.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.ricky52194.csci490_lab_5.entities.Person;

/**
 * Created by ricky52194 on 3/15/18.
 */

@Database(entities = {Person.class}, version = 1)
public abstract class LabDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
}
