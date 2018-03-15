package com.example.ricky52194.csci490_lab_5;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ricky52194.csci490_lab_5.data.LabDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button submitButton, listButton;
    private LabDatabase labDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME)
                .build();
        editText = findViewById(R.id.editText);
        submitButton = findViewById(R.id.button1);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "This works: " + editText.getText().toString(), Toast.LENGTH_LONG);
                submitToDatabase(editText.getText().toString());
            }
        });
        listButton = findViewById(R.id.button2);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "This works", Toast.LENGTH_LONG);
            }
        });

    }
}
