package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import database.JDBCUtil;
//import lib.XDate;
public class ThongKeDAO {

    public static ThongKeDAO getInstance() {
        return new ThongKeDAO();
    }

    public List<Object[]> getLuongNguoiHoc() {
        List<Object[]> list = new ArrayList<>();
        String[] cols = {"Nam", "SoLuong", "DauTien", "CuoiCung"};
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "{CALL sp_ThongKeNguoiHoc}";
            CallableStatement cst = connection.prepareCall(sql);
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }

    public List<Object[]> getDoanhThu(int year) {
        List<Object[]> list = new ArrayList<>();
        String[] cols = {"ChuyenDe", "SoKH", "SoHV", "DoanhThu", "ThapNhat",
            "CaoNhat", "TrungBinh"};
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "{Call sp_ThongKeDoanhThu(?)}";
            CallableStatement cst = connection.prepareCall(sql);
            cst.setInt(1, year);
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Object[]> getDiemChuyenDe() {
        List<Object[]> list = new ArrayList<>();
        String[] cols = {"ChuyenDe", "SoHV", "ThapNhat", "CaoNhat", "TrungBinh"};
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "{CALL sp_ThongKeDiem}";
            CallableStatement cst = connection.prepareCall(sql);
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }

    public List<Object[]> getBangDiem(int maKhoaHoc) {
        List<Object[]> list = new ArrayList<>();
        String[] cols = {"MaNH", "HoTen", "Diem"};
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "{Call sp_BangDiem(?)}";
            CallableStatement cst = connection.prepareCall(sql);
            cst.setInt(1, maKhoaHoc);
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }

    public static void main(String[] args) {
        List<Object[]> list = ThongKeDAO.getInstance().getDiemChuyenDe();
        for (Object[] objects : list) {
            System.out.println(objects[0]);
        }
    }
}
