package com.example.prefinal.Model;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String maSV, ten;
    private int namSinh;
    private String queQuan;
    private int namHoc;

    public Student(){

    }

    public Student(int id, String maSV, String ten) {
        this.id = id;
        this.maSV = maSV;
        this.ten = ten;
    }

    public Student(int id, String maSV, String ten, int namSinh, String queQuan, int namHoc) {
        this.id = id;
        this.maSV = maSV;
        this.ten = ten;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.namHoc = namHoc;
    }

    public Student(String maSV, String ten, int namSinh, String queQuan, int namHoc) {
        this.maSV = maSV;
        this.ten = ten;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.namHoc = namHoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

}
