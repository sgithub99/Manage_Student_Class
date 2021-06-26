package com.example.prefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prefinal.Database.DatabaseHelper;
import com.example.prefinal.Model.Lop;

public class AddClass extends AppCompatActivity {
    private EditText etClassID, etClassName;
    private Button btnSaveClass;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        db = new DatabaseHelper(getBaseContext());

        etClassID = findViewById(R.id.etClassID);
        etClassName = findViewById(R.id.etClassName);
        btnSaveClass = findViewById(R.id.btnSaveClass);

        btnSaveClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
    }

    private void insert() {
        String malop = etClassID.getText().toString();
        String tenlop = etClassName.getText().toString();
        Lop lop = new Lop(malop, tenlop);
        db.addClass(lop);
        Toast.makeText(AddClass.this, "success", Toast.LENGTH_SHORT).show();
        etClassID.setText("");
        etClassName.setText("");
        Intent intent = new Intent(this, ListClass.class);
        startActivity(intent);
    }
}