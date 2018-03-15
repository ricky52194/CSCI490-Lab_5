package com.example.ricky52194.csci490_lab_5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ricky52194 on 3/15/18.
 */

public class PersonsActivity extends AppCompatActivity {

    private ListView listView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_persons);
        listView = findViewById(R.id.personName);

        ArrayList<String> i = (ArrayList) this.getIntent().getExtras().get("Persons");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, i);

        listView.setAdapter(adapter);
    }
}
