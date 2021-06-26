package com.example.prefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.prefinal.Database.DatabaseHelper;
import com.example.prefinal.Model.Lop;
import com.example.prefinal.Model.Student;
import com.example.prefinal.Model.StudentClass;

import java.util.ArrayList;
import java.util.List;

public class AddStudentToClass extends AppCompatActivity {

    private Spinner spinnerStudent, spinnerClassroom, spinnerSemester, spinnerCredits;
    private Button btnAdd;
    private int student_id = 0;
    private int class_id = 0;
    private int semester = 0;
    private int credits = 0;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_to_class);

        db = new DatabaseHelper(getBaseContext());

        spinnerStudent = findViewById(R.id.spinnerStudent);
        spinnerClassroom = findViewById(R.id.spinnerClassroom);
        spinnerSemester = findViewById(R.id.spinnerSemester);
        spinnerCredits = findViewById(R.id.spinnerCredits);
        btnAdd = findViewById(R.id.btnAdd);

        List<Student> studentList = db.getAllStudent();
        List<Lop> classList = db.getAllClass();
        List<String> studentSpinnerData = new ArrayList<>();
        List<String> classroomSpinnerData = new ArrayList<>();

        for (Student student: studentList) {
            String data = "ID: " + student.getMaSV() + ", Name: " + student.getTen();
            studentSpinnerData.add(data);
        }

        for (Lop lop: classList) {
            String data = "ID: " + lop.getMaLop() + ", Name: " + lop.getTenLop();
            classroomSpinnerData.add(data);
        }

        ArrayAdapter<String> arrayAdapterStudent = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentSpinnerData);
        ArrayAdapter<String> arrayAdapterClassroom = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, classroomSpinnerData);
        spinnerStudent.setAdapter(arrayAdapterStudent);
        spinnerClassroom.setAdapter(arrayAdapterClassroom);

        spinnerStudent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                student_id = studentList.get(position).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerClassroom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                class_id = classList.get(position).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String[] semesterData = new String[] {"1", "2", "3"};
        String[] creditsData = new String[] {"1", "2", "3", "4"};

        ArrayAdapter<String> arrayAdapterSemester = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, semesterData);
        ArrayAdapter<String> arrayAdapterCredits = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, creditsData);
        spinnerSemester.setAdapter(arrayAdapterSemester);
        spinnerCredits.setAdapter(arrayAdapterCredits);

        spinnerSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                semester = Integer.valueOf(semesterData[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerCredits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                credits = Integer.valueOf(creditsData[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
    }

    private void insert() {
        Student student = new Student();
        Lop lop = new Lop();
        StudentClass studentClass = new StudentClass();
        student=  db.getStudentById(student_id);
        studentClass.setStudentId(student);
        lop = db.getLopById(class_id);
        studentClass.setClassroomId(lop);
        studentClass.setSemester(semester);
        studentClass.setCredits(credits);
        db.addStudentToClass(studentClass);
        finish();
    }
}