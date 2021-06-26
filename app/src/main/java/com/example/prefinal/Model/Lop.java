package com.example.prefinal.Model;

import java.io.Serializable;

public class Lop implements Serializable {
    private int id;
    private String maLop, tenLop;

    public Lop() {
    }

    public Lop(int id, String maLop, String tenLop) {
        this.id = id;
        this.maLop = maLop;
        this.tenLop = tenLop;
    }

    public Lop(String maLop, String tenLop) {
        this.maLop = maLop;
        this.tenLop = tenLop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

}
