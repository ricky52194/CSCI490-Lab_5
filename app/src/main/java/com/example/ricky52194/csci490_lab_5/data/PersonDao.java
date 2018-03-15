package com.example.ricky52194.csci490_lab_5.data;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ricky52194.csci490_lab_5.entities.Person;

import java.util.List;

/**
 * Created by ricky52194 on 3/15/18.
 */

public interface PersonDao {
    @Insert
    void insertPerson(Person person);

    @Query("SELECT * FROM Person")
    List<Person> getAllPersons();
}
