package com.example.prefinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.prefinal.Adapter.RecyclerViewStudentAdapter;
import com.example.prefinal.Database.DatabaseHelper;
import com.example.prefinal.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class ListStudent extends AppCompatActivity {
    private RecyclerView recycler_listStudent;
    private Button btnAddStudent;
    private DatabaseHelper db;
    private List<Student> listStudent;
    private RecyclerViewStudentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);

        db = new DatabaseHelper(getBaseContext());
        listStudent = new ArrayList<>();

        listStudent = db.getAllStudent();
        adapter = new RecyclerViewStudentAdapter();

        recycler_listStudent = findViewById(R.id.recycler_listStudent);
        btnAddStudent = findViewById(R.id.btnAddStudent);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler_listStudent.setLayoutManager(linearLayoutManager);
        recycler_listStudent.setAdapter(adapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getBaseContext(), DividerItemDecoration.VERTICAL);
        recycler_listStudent.addItemDecoration(itemDecoration);
        registerForContextMenu(this.recycler_listStudent);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListStudent.this, AddStudent.class);
                startActivity(intent);
            }
        });

        adapter.updateDataStudent(listStudent);
    }
}