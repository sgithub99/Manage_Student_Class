package com.example.prefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button addClass, addStudent, addStudentToClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addClass = findViewById(R.id.addClass);
        addStudent = findViewById(R.id.addStudent);
        addStudentToClass = findViewById(R.id.addStudentToClass);

        addClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListClass.class);
                startActivity(intent);
            }
        });

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListStudent.class);
                startActivity(intent);
            }
        });

        addStudentToClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListStudentClass.class);
                startActivity(intent);
            }
        });
    }
}