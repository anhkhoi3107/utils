package dao;

import com.edusys.model.ChuyenDe;
import com.edusys.model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChuyenDeDAO implements DAOInterface<ChuyenDe> {

    public static ChuyenDeDAO getInstance() {
        return new ChuyenDeDAO();
    }

    @Override
    public int insert(ChuyenDe t) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "insert into ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa) values" + "(?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaCD());
            pst.setString(2, t.getTenCD());
            pst.setDouble(3, t.getHocPhi());
            pst.setInt(4, t.getThoiLuong());
            pst.setString(5, t.getHinh());
            pst.setString(6, t.getMoTa());
            result = pst.executeUpdate();
            System.out.println("Đã thực thi " + result + " dòng");
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;
    }

    @Override
    public int update(ChuyenDe t) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "update ChuyenDe " + "set TenCD=?, HocPhi=?, ThoiLuong=?, Hinh=?,MoTa=? " + "where MaCD=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getTenCD());
            pst.setDouble(2, t.getHocPhi());
            pst.setInt(3, t.getThoiLuong());
            pst.setString(4, t.getHinh());
            pst.setString(5, t.getMoTa());
            pst.setString(6, t.getMaCD());
            result = pst.executeUpdate();
            System.out.println("Đã thực thi " + result + " dòng");
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;
    }

    @Override
    public int delete(String MaCD) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "delete from ChuyenDe where MaCD=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, MaCD);
            result = pst.executeUpdate();
            System.out.println("Đã thực thi " + result + " dòng");
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

//    public List<ChuyenDe> select() {
//        String sql = "SELECT * FROM ChuyenDe";
//        return select(sql);
//    }
//
//    public ChuyenDe findbyID(String MaCD) {
//        String sql = "Select * From ChuyenDe Where MaCD = ?";
//        List<ChuyenDe> list = select(sql, MaCD);
//        return list.size() > 0 ? list.get(0) : null;
//    }
    @Override
    public ChuyenDe selectById(ChuyenDe t) {
        ChuyenDe cd = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from ChuyenDe where MaCD = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaCD());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String MaCD = rs.getString("MaCD");
                String TenCD = rs.getString("TenCD");
                Double HocPhi = rs.getDouble("HocPhi");
                int ThoiLuong = rs.getInt("ThoiLuong");
                String Hinh = rs.getString("Hinh");
                String MoTa = rs.getString("Mota");

                cd = new ChuyenDe(MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return cd;
    }

    @Override
    public ArrayList<ChuyenDe> selectAll() {
        ArrayList<ChuyenDe> list = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from ChuyenDe";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MaCD = rs.getString("MaCD");
                String TenCD = rs.getString("TenCD");
                double HocPhi = rs.getDouble("HocPhi");
                int ThoiLuong = rs.getInt("ThoiLuong");
                String Hinh = rs.getString("Hinh");
                String MoTa = rs.getString("MoTa");
                ChuyenDe cd = new ChuyenDe(MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa);
                list.add(cd);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        ArrayList<ChuyenDe> list = ChuyenDeDAO.getInstance().selectAll();
        for (ChuyenDe chuyenDe : list) {
            System.out.println(chuyenDe);
        }
    }
    public NhanVien findById(String manv) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        List<NhanVien> list = select(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<NhanVien> select(String sql, String manv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

