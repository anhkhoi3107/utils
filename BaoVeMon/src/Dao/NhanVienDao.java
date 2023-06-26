/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import JDBC.JDBC;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import model.NhanVienModel;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class NhanVienDao implements Dao<NhanVienModel> {

    public static NhanVienDao getInstance() {
        return new NhanVienDao();
    }

    @Override
    public int insert(NhanVienModel t) {
        int result = 0;
        try {
            Connection cn = JDBC.getConnection();
            String sql = "insert into SinhVien (maSV, hoTen, email, soDT, gioiTinh, diaChi) values " + "(?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, t.getMaSv());
            pst.setString(2, t.getHoTen());
            pst.setString(3, t.getEmail());
            pst.setString(4, t.getSoDT());
            pst.setBoolean(5, t.isGioiTinh());
            pst.setString(6, t.getDiaChi());
            result = pst.executeUpdate();
            System.out.println("Đã thực thi " + result + " dòng");
            JDBC.closeConnection(cn);
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public int update(NhanVienModel t) {
        int result = 0;
        try {
            Connection connection = JDBC.getConnection();
            String sql = "update SinhVien set hoTen=?, email=?, soDT=?, gioiTinh=?, diaChi=? where " + "maSV=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getHoTen());
            pst.setString(2, t.getEmail());
            pst.setString(3, t.getSoDT());
            pst.setBoolean(4, t.isGioiTinh());
            pst.setString(5, t.getDiaChi());
            pst.setString(6, t.getMaSv());
            result = pst.executeUpdate();
            System.out.println("Đã thực thi " + result + " dòng");
            JDBC.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;
    }

    @Override
    public ArrayList<NhanVienModel> selectAll() {
        ArrayList<NhanVienModel> list = new ArrayList<>();
        try {
            Connection connection = JDBC.getConnection();
            String sql = "select * from SinhVien";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maSV = rs.getString("maSV");
                String hoTen = rs.getString("hoTen");
                String email = rs.getString("email");
                String soDT = rs.getString("soDT");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                String diaChi = rs.getString("diaChi");
                NhanVienModel sv = new NhanVienModel(maSV, hoTen, email, soDT, gioiTinh, diaChi);
                list.add(sv);
            }
            JDBC.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }

    @Override
    public int delete(NhanVienModel t) {
        int result = 0;
        try {
            Connection connection = JDBC.getConnection();
            String sql = "delete from SinhVien where MaSv=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaSv());
            result = pst.executeUpdate();
            System.out.println("Đã thực thi " + result + " dòng");
            JDBC.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }
//    	public static void main(String[] args) {
//		NhanVienModel sv = new NhanVienModel();
//		sv.setMaSv("NV0000");
//		NhanVienDao.getInstance().delete(sv);
//        }


    @Override
    public NhanVienModel selectByID(NhanVienModel t) {
        NhanVienModel sv = null;
        try {
            Connection connection = JDBC.getConnection();
            String sql = "select * from SinhVien where MaSv=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaSv());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String maSV = rs.getString("maSV");
                String hoTen = rs.getString("hoTen");
                String email = rs.getString("email");
                String soDT = rs.getString("soDT");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                String diaChi = rs.getString("diaChi");
                sv = new NhanVienModel(maSV, hoTen, email, soDT, gioiTinh, diaChi);
            }
            JDBC.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return sv;
    }


    @Override
    public ArrayList<NhanVienModel> selectBySQL(String sql, Object t) {
        return null;
    }

    @Override
    public ArrayList<NhanVienModel> selectByCondition(String condition) {
        return null;
    }

}
