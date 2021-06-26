package com.example.prefinal.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.prefinal.Model.Lop;
import com.example.prefinal.Model.Student;
import com.example.prefinal.Model.StudentClass;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student Manager";

    //table Student
    private static final String TABLE_STUDENT = "student";
    private static final String COLUMN_STUDENT_ID = "idsv";
    private static final String COLUMN_STUDENT_MASV = "masv";
    private static final String COLUMN_STUDENT_NAME = "tensv";
    private static final String COLUMN_STUDENT_BORN = "bornyear";
    private static final String COLUMN_STUDENT_QUE = "quequan";
    private static final String COLUMN_STUDENT_NAMHOC = "namhoc";

    //table Class
    private static final String TABLE_CLASS = "lop";
    private static final String COLUMN_CLASS_ID = "idlop";
    private static final String COLUMN_CLASS_MALOP = "malop";
    private static final String COLUMN_CLASS_NAME = "tenlop";

    //table studentclass
    public static final String TABLE_STUDENT_CLASS = "lopsv";
    public static final String STUDENT_CLASS_ID = "idStudentClass";
    public static final String STUDENT_CLASS_STUDENT_ID = "svid";
    public static final String STUDENT_CLASS_CLASS_ID = "lopid";
    public static final String STUDENT_CLASS_SEMESTER = "kyhoc";
    public static final String STUDENT_CLASS_CREDITS = "tinchi";

    private String create_student = "CREATE TABLE " + TABLE_STUDENT + "(" +
            COLUMN_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_STUDENT_MASV + " TEXT, " +
            COLUMN_STUDENT_NAME + " TEXT, " +
            COLUMN_STUDENT_BORN + " INTEGER, " +
            COLUMN_STUDENT_QUE + " TEXT, " +
            COLUMN_STUDENT_NAMHOC + " INTEGER " + ")";

    private String create_class = "CREATE TABLE " + TABLE_CLASS + "(" +
            COLUMN_CLASS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_CLASS_MALOP + " TEXT, " +
            COLUMN_CLASS_NAME + " TEXT " + ")";

    private String create_student_class = "CREATE TABLE " + TABLE_STUDENT_CLASS + " (" +
            STUDENT_CLASS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            STUDENT_CLASS_STUDENT_ID + " INTEGER NOT NULL," +
            STUDENT_CLASS_CLASS_ID + " INTEGER NOT NULL," +
            STUDENT_CLASS_SEMESTER + " INTEGER, " +
            STUDENT_CLASS_CREDITS + " INTEGER, " +
            " FOREIGN KEY " + "(" + STUDENT_CLASS_STUDENT_ID + ") REFERENCES " + TABLE_STUDENT + "(" + COLUMN_STUDENT_ID + ")," +
            " FOREIGN KEY " + "(" + STUDENT_CLASS_CLASS_ID + ") REFERENCES " + TABLE_CLASS + "(" + COLUMN_CLASS_ID + "));";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_class);
        db.execSQL(create_student);
        db.execSQL(create_student_class);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLASS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT_CLASS);
        onCreate(db);
    }

    //===================Class===============================//
    public void addClass(Lop lop) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CLASS_MALOP, lop.getMaLop());
        contentValues.put(COLUMN_CLASS_NAME, lop.getTenLop());
        db.insert(TABLE_CLASS, null, contentValues);
        db.close();
    }

    public List<Lop> getAllClass() {
        List<Lop> lopList = new ArrayList<Lop>();
        String selectQuery = "SELECT  * FROM " + TABLE_CLASS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Lop lop = new Lop();
                lop.setId(Integer.parseInt(cursor.getString(0)));
                lop.setMaLop(cursor.getString(1));
                lop.setTenLop(cursor.getString(2));
                lopList.add(lop);
            } while (cursor.moveToNext());
        }
        return lopList;
    }

    public Lop getLopById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CLASS,
                new String[] { COLUMN_CLASS_ID, COLUMN_CLASS_NAME, COLUMN_CLASS_NAME},
                COLUMN_CLASS_ID + "=?",
                new String[] { String.valueOf(id) },
                null,
                null,
                null,
                null);
        if (cursor != null)
            cursor.moveToFirst();

        Lop lop = new Lop(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2));
        return lop;
    }

    //===================Student===============================//
    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_STUDENT_MASV, student.getMaSV());
        contentValues.put(COLUMN_STUDENT_NAME, student.getTen());
        contentValues.put(COLUMN_STUDENT_BORN, student.getNamSinh());
        contentValues.put(COLUMN_STUDENT_QUE, student.getQueQuan());
        contentValues.put(COLUMN_STUDENT_NAMHOC, student.getNamHoc());
        db.insert(TABLE_STUDENT, null, contentValues);
        db.close();
    }

    public List<Student> getAllStudent() {
        List<Student> stuList = new ArrayList<Student>();
        String selectQuery = "SELECT  * FROM " + TABLE_STUDENT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setMaSV(cursor.getString(1));
                student.setTen(cursor.getString(2));
                student.setNamSinh(Integer.parseInt(cursor.getString(3)));
                student.setQueQuan(cursor.getString(4));
                student.setNamHoc(Integer.parseInt(cursor.getString(5)));
                stuList.add(student);
            } while (cursor.moveToNext());
        }
        return stuList;
    }

    public Student getStudentById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_STUDENT,
                new String[] { COLUMN_STUDENT_ID, COLUMN_STUDENT_MASV, COLUMN_STUDENT_NAME},
                COLUMN_STUDENT_ID + "=?",
                new String[] { String.valueOf(id) },
                null,
                null,
                null,
                null);
        if (cursor != null)
            cursor.moveToFirst();

        Student student = new Student(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2));
        return student;
    }

    public List<Student> getSpecificStudent() {
        List<Student> studentList = new ArrayList<>();
        String sqlString = "SELECT * FROM " + TABLE_STUDENT + " WHERE " + COLUMN_STUDENT_NAME + "=? AND " + COLUMN_STUDENT_NAMHOC + "=?;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sqlString, new String[]{"Nam", "Nam hai"});
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setId(cursor.getInt(0));
                student.setMaSV(cursor.getString(1));
                student.setTen(cursor.getString(2));
                student.setNamSinh(cursor.getInt(3));
                student.setQueQuan(cursor.getString(4));
                student.setNamHoc(cursor.getInt(5));

                studentList.add(student);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return  studentList;
    }

    //================student class==========/
    public void addStudentToClass(StudentClass studentClass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENT_CLASS_STUDENT_ID, studentClass.getStudentId().getId());
        contentValues.put(STUDENT_CLASS_CLASS_ID, studentClass.getClassroomId().getId());
        contentValues.put(STUDENT_CLASS_SEMESTER, studentClass.getSemester());
        contentValues.put(STUDENT_CLASS_CREDITS, studentClass.getCredits());
        db.insert(TABLE_STUDENT_CLASS, null, contentValues);
        db.close();
    }

    public List<StudentClass> getAllStudentClass(){
        List<StudentClass> listStudentClass = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_STUDENT_CLASS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                StudentClass studentClass = new StudentClass();
                studentClass.setId(Integer.parseInt(cursor.getString(0)));
                studentClass.setStudentId(getStudentById(Integer.parseInt(cursor.getString(1))));
                studentClass.setClassroomId(getLopById(Integer.parseInt(cursor.getString(2))));
//                studentClass.setStudentName(cursor.getString(3));
//                studentClass.setClassroomName(cursor.getString(4));
                studentClass.setSemester(cursor.getInt(3));
                studentClass.setCredits(cursor.getInt(4));
                listStudentClass.add(studentClass);
            } while (cursor.moveToNext());
        }
        return listStudentClass;
    }
}
