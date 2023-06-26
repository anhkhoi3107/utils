/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author ACER
 */
public class ClassHocVien {
    int MaHV;
    int MaKH;
    String MaNH;
    float Diem;

    public ClassHocVien(int MaHV, int MaKH, String MaNH, float Diem) {
        this.MaHV = MaHV;
        this.MaKH = MaKH;
        this.MaNH = MaNH;
        this.Diem = Diem;
    }

    public ClassHocVien() {
    }

    public int getMaHV() {
        return MaHV;
    }

    public void setMaHV(int MaHV) {
        this.MaHV = MaHV;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNH() {
        return MaNH;
    }

    public void setMaNH(String MaNH) {
        this.MaNH = MaNH;
    }

    public float getDiem() {
        return Diem;
    }

    public void setDiem(float Diem) {
        this.Diem = Diem;
    }
    
    
}
