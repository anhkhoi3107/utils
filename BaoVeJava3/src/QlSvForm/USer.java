/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QlSvForm;

/**
 *
 * @author ACER
 */
public class USer {
    String MaSv;
    String HoTen;
    String Email;
    String SoDT;
    boolean GioiTinh;
    String DiaChi;
    public USer() {
    }

//    public USer(String MaSv, String HoTen, String Email, String SoDT, 
//            String DiaChi, boolean GioiTinh) {
//        this.MaSv = MaSv;
//        this.HoTen = HoTen;
//        this.Email = Email;
//        this.SoDT = SoDT;
//        this.DiaChi = DiaChi;

    public USer(String MaSv, String HoTen, String Email, String SoDT, boolean GioiTinh, String DiaChi) {
        this.MaSv = MaSv;
        this.HoTen = HoTen;
        this.Email = Email;
        this.SoDT = SoDT;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
    }

//        this.GioiTinh = GioiTinh;
//    }
//
//    public String getMaSv() {
//        return MaSv;
//    }
//
//    public void setMaSv(String MaSv) {
//        this.MaSv = MaSv;
//    }
//
//    public String getHoTen() {
//        return HoTen;
//    }
//
//    public void setHoTen(String HoTen) {
//        this.HoTen = HoTen;
//    }
//
//    public String getEmail() {
//        return Email;
//    }
//
//    public void setEmail(String Email) {
//        this.Email = Email;
//    }
//
//    public String getSoDT() {
//        return SoDT;
//    }
//
//    public void setSoDT(String SoDT) {
//        this.SoDT = SoDT;
//    }
//
//    public String getDiaChi() {
//        return DiaChi;
//    }
//
//    public void setDiaChi(String DiaChi) {
//        this.DiaChi = DiaChi;
//    }
//
//    public boolean isGioiTinh() {
//        return GioiTinh;
//    }
//
//    public void setGioiTinh(boolean GioiTinh) {
//        this.GioiTinh = GioiTinh;
//    }
//
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