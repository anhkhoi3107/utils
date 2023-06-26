/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author ACER
 */
public class ClassNhanVien {

    String MaNV;
    String MatKhau;
    String HoTen;
    boolean VaiTro;

    public ClassNhanVien(String MaNV, String MatKhau, String HoTen, boolean VaiTro) {
        this.MaNV = MaNV;
        this.MatKhau = MatKhau;
        this.HoTen = HoTen;
        this.VaiTro = VaiTro;
    }

    public ClassNhanVien() {
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public boolean isVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(boolean VaiTro) {
        this.VaiTro = VaiTro;
    }
    
}
