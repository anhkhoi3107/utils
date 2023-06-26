/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



public class NhanVienModel {


    private String MaSv;
    private String HoTen;
    private String Email;
    private String SoDT;
    private boolean GioiTinh;
    private String DiaChi;

    public NhanVienModel() {
    }

    public NhanVienModel(String MaSv, String HoTen, String Email, String SoDT, boolean GioiTinh, String DiaChi) {
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
    	@Override
	public String toString() {
		return "SinhVienModel [maSV=" + MaSv + ", hoTen=" + HoTen + ", email=" + Email + ", soDT=" + SoDT
				+ ", gioiTinh=" + GioiTinh + ", diaChi=" + DiaChi + "]";
	}
}
