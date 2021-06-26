package com.example.prefinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.prefinal.Adapter.RecyclerViewClassAdapter;
import com.example.prefinal.Database.DatabaseHelper;
import com.example.prefinal.Model.Lop;

import java.util.ArrayList;
import java.util.List;

public class ListClass extends AppCompatActivity {
    private RecyclerView recycler_listClass;
    private Button btnAddClass;
    private RecyclerViewClassAdapter adapter;
    private List<Lop> listLop;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_class);

        db = new DatabaseHelper(getBaseContext());
        listLop = new ArrayList<>();

        listLop = db.getAllClass();
        adapter = new RecyclerViewClassAdapter();

        recycler_listClass = findViewById(R.id.recycler_listClass);
        btnAddClass = findViewById(R.id.btnAddClass);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler_listClass.setLayoutManager(linearLayoutManager);
        recycler_listClass.setAdapter(adapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getBaseContext(), DividerItemDecoration.VERTICAL);
        recycler_listClass.addItemDecoration(itemDecoration);
        registerForContextMenu(this.recycler_listClass);

        btnAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListClass.this, AddClass.class);
                startActivity(intent);
            }
        });

        adapter.updateDataLop(listLop);
    }
}