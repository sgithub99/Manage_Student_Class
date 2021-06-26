package com.example.prefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.prefinal.Database.DatabaseHelper;
import com.example.prefinal.Model.Student;

public class AddStudent extends AppCompatActivity {
    private EditText id, name, bornYear, quequan;
    private Spinner spinnerNamhoc;
    private Button btnSaveStudent;
    private DatabaseHelper db;
    private int namhoc = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        db = new DatabaseHelper(getBaseContext());

        id = findViewById(R.id.etStudentID);
        name = findViewById(R.id.etStudentName);
        bornYear = findViewById(R.id.etStudentBorn);
        quequan = findViewById(R.id.etStudentCity);
        spinnerNamhoc = findViewById(R.id.spinnerStudentYear);
        btnSaveStudent = findViewById(R.id.btnSaveStudent);

        String[] namhocData = new String[] {"1", "2", "3","4"};
        ArrayAdapter<String> arrayAdapternamhoc = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, namhocData);
        spinnerNamhoc.setAdapter(arrayAdapternamhoc);

        spinnerNamhoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                namhoc = Integer.valueOf(namhocData[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnSaveStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
    }

    private void insert() {
        String masv = id.getText().toString();
        String tensv = name.getText().toString();
        int namsinh = Integer.parseInt(bornYear.getText().toString());
        String que = quequan.getText().toString();
        Student student = new Student(masv, tensv, namsinh, que, namhoc);
        db.addStudent(student);
        Toast.makeText(AddStudent.this, "success", Toast.LENGTH_SHORT).show();
        id.setText("");
        name.setText("");
        bornYear.setText("");
        quequan.setText("");
        Intent intent = new Intent(this, ListStudent.class);
        startActivity(intent);
    }
}