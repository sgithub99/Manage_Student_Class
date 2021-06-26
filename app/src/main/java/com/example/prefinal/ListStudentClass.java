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
import com.example.prefinal.Adapter.RecyclerViewStudentClassAdapter;
import com.example.prefinal.Database.DatabaseHelper;
import com.example.prefinal.Model.Student;
import com.example.prefinal.Model.StudentClass;

import java.util.ArrayList;
import java.util.List;

public class ListStudentClass extends AppCompatActivity {
    private Button btnAddStudentClass;
    private RecyclerView recycler_listStudentClass;
    private DatabaseHelper db;
    private List<StudentClass> listStudentClass;
    private RecyclerViewStudentClassAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student_class);

        btnAddStudentClass = findViewById(R.id.btnAddStudentClass);

        db = new DatabaseHelper(getBaseContext());
        listStudentClass = new ArrayList<>();

        listStudentClass = db.getAllStudentClass();
        adapter = new RecyclerViewStudentClassAdapter();

        recycler_listStudentClass = findViewById(R.id.recycler_listStudentClass);
        btnAddStudentClass = findViewById(R.id.btnAddStudentClass);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler_listStudentClass.setLayoutManager(linearLayoutManager);
        recycler_listStudentClass.setAdapter(adapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getBaseContext(), DividerItemDecoration.VERTICAL);
        recycler_listStudentClass.addItemDecoration(itemDecoration);
        registerForContextMenu(this.recycler_listStudentClass);
        btnAddStudentClass.setOnClickListener(v -> {
            Intent intent = new Intent(ListStudentClass.this, AddStudentToClass.class);
            startActivity(intent);
        });
        adapter.updateDataStudent(listStudentClass);

    }
}