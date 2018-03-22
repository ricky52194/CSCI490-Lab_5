package com.example.ricky52194.csci490_lab_5.async;

import android.arch.persistence.room.Database;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.ricky52194.csci490_lab_5.PersonsActivity;
import com.example.ricky52194.csci490_lab_5.data.LabDatabase;
import com.example.ricky52194.csci490_lab_5.entities.Person;

import java.util.ArrayList;

/**
 * Created by ricky52194 on 3/15/18.
 */

public class MyAsyncTask2 extends AsyncTask<Void, Void, ArrayList<Person>> {

    private LabDatabase personDB;
    Context context;

    public MyAsyncTask2(LabDatabase personDB, Context context){
        this.personDB = personDB;
        this.context = context;
    }

    @Override
    protected ArrayList<Person> doInBackground(Void... voids) {
        ArrayList<Person> persons = (ArrayList) personDB.personDao().getAllPersons();
        return persons;
    }

    @Override
    protected void onPostExecute(ArrayList<Person> persons) {
        super.onPostExecute(persons);
        ArrayList<String> names = new ArrayList<>();
        for(Person p: persons){
            names.add(p.getName());
        }

        Intent i = new Intent(context,PersonsActivity.class);
        i.putExtra("Persons", names);
        context.startActivity(i);

    }


}
