package com.example.prefinal.Model;

import java.io.Serializable;

public class StudentClass implements Serializable {
    private int id;
    private Student studentId;
    private Lop classroomId;
    private String studentName;
    private String classroomName;
    private int semester;
    private int credits;

    public StudentClass(){

    }

    public StudentClass(int id, Student studentId, Lop classroomId, String studentName, String classroomName, int semester, int credits) {
        this.id = id;
        this.studentId = studentId;
        this.classroomId = classroomId;
        this.studentName = studentName;
        this.classroomName = classroomName;
        this.semester = semester;
        this.credits = credits;
    }

    public StudentClass(Student studentId, Lop classroomId, String studentName, String classroomName, int semester, int credits) {
        this.studentId = studentId;
        this.classroomId = classroomId;
        this.studentName = studentName;
        this.classroomName = classroomName;
        this.semester = semester;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Lop getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Lop classroomId) {
        this.classroomId = classroomId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
