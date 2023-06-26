/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class NhanVien {
    String MaSv;
    String HoTen;
    String Email;
    String SoDT;
    boolean GioiTinh;
    String DiaChi;

    public NhanVien(String MaSv, String HoTen, String Email, String SoDT, boolean GioiTinh, String DiaChi) {
        this.MaSv = MaSv;
        this.HoTen = HoTen;
        this.Email = Email;
        this.SoDT = SoDT;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
    }

    public String getMaSv() {
        return MaSv;
    }

    public void setMaSv(String MaSv) {
        this.MaSv = MaSv;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }





}
    

