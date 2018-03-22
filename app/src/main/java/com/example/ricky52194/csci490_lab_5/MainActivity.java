package com.example.ricky52194.csci490_lab_5;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ricky52194.csci490_lab_5.async.MyAsyncTask;
import com.example.ricky52194.csci490_lab_5.async.MyAsyncTask2;
import com.example.ricky52194.csci490_lab_5.data.LabDatabase;

public class MainActivity extends AppCompatActivity {
    private static final String DATABASE_NAME = "person_DB";
    private EditText editText;
    private Button submitButton, listButton;
    private LabDatabase personDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME)
                .build();
        editText = findViewById(R.id.editText);
        submitButton = findViewById(R.id.button1);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Submit Button Clicked" + editText.getText().toString(), Toast.LENGTH_LONG).show();
                submitToDatabase(editText.getText().toString());
            }
        });
        listButton = findViewById(R.id.button2);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "List Button Clicked", Toast.LENGTH_LONG).show();
                retrieveName();
            }
        });

    }

    private void submitToDatabase(String name)
    {
        MyAsyncTask myAsyncTask = new MyAsyncTask(personDB, getApplicationContext());
        myAsyncTask.execute();
    }

    private void retrieveName()
    {
        MyAsyncTask2 myAsyncTask2 = new MyAsyncTask2(personDB, getApplicationContext());
        myAsyncTask2.execute();
    }
}
