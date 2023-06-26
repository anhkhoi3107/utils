package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import database.JDBCUtil;
//import lib.XDate;
import com.edusys.model.NguoiHoc;

public class NguoiHocDAO implements DAOInterface<NguoiHoc> {

    public static NguoiHocDAO getInstance() {
        return new NguoiHocDAO();
    }

    @Override
    public int insert(NguoiHoc t) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "insert into NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) values"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaNH());
            pst.setString(2, t.getHoTen());
            pst.setDate(3, (Date) t.getNgaySinh());
            pst.setBoolean(4, t.getGioiTinh());
            pst.setString(5, t.getDienThoai());
            pst.setString(6, t.getEmail());
            pst.setString(7, t.getGhiChu());
            pst.setString(8, t.getMaNV());
            pst.setDate(9, (Date) t.getNgayDK());
            result = pst.executeUpdate();
            System.out.println("Đã thực thi " + result + " dòng");
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;
    }

    @Override
    public int update(NguoiHoc t) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "update NguoiHoc "
                    + "set HoTen=?, NgaySinh=?, GioiTinh=?, DienThoai=?, Email=?, GhiChu=?, MaNV=?, NgayDK=? "
                    + "where MaNH=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getHoTen());
            pst.setDate(2, (Date) t.getNgaySinh());
            pst.setBoolean(3, t.getGioiTinh());
            pst.setString(4, t.getDienThoai());
            pst.setString(5, t.getEmail());
            pst.setString(6, t.getGhiChu());
            pst.setString(7, t.getMaNV());
            pst.setDate(8, (Date) t.getNgaySinh());
            pst.setString(9, t.getMaNH());
            result = pst.executeUpdate();
            System.out.println("Đã thực thi " + result + " dòng");
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;
    }

    public int delete(NguoiHoc t) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "delete from NguoiHoc where MaNH = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaNH());
            result = pst.executeUpdate();
            System.out.println("Đã thực thi " + result + " dòng");
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;
    }

    public NguoiHoc selectByID(NguoiHoc t) {
        NguoiHoc nh = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from NguoiHoc where MaNH=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaNH());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String MaNH = rs.getString("MaNH");
                String TenNH = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                String DienThoai = rs.getString("DienThoai");
                String Email = rs.getString("Email");
                String GhiChu = rs.getString("GhiChu");
                String MaNV = rs.getString("MaNV");
                Date NgayDK = rs.getDate("NgayDK");
                nh = new NguoiHoc(MaNH, TenNH, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return nh;
    }

    public ArrayList<NguoiHoc> selectAll() {
        ArrayList<NguoiHoc> list = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from NguoiHoc";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MaNH = rs.getString("MaNH");
                String TenNH = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                String DienThoai = rs.getString("DienThoai");
                String Email = rs.getString("Email");
                String GhiChu = rs.getString("GhiChu");
                String MaNV = rs.getString("MaNV");
                Date NgayDK = rs.getDate("NgayDK");
                NguoiHoc nh = new NguoiHoc(MaNH, TenNH, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK);

                list.add(nh);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }

    public ArrayList<NguoiHoc> selectByCondition(String condition) {
        ArrayList<NguoiHoc> list = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from NguoiHoc where MaNH like ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, "%" + condition + "%");
            System.out.println(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MaNH = rs.getString("MaNH");
                String TenNH = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                String DienThoai = rs.getString("DienThoai");
                String Email = rs.getString("Email");
                String GhiChu = rs.getString("GhiChu");
                String MaNV = rs.getString("MaNV");
                Date NgayDK = rs.getDate("NgayDK");
                NguoiHoc nh = new NguoiHoc();
                list.add(nh);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }

    public ArrayList<NguoiHoc> selectBySQL(String sql, Object t) {
        // TODO Auto-generated method stub
        return null;
    }

    public ArrayList<NguoiHoc> selectByCourse(int MaKH) {
        ArrayList<NguoiHoc> list = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "SELECT * FROM NguoiHoc WHERE MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH = ?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, MaKH);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MaNH = rs.getString("MaNH");
                String TenNH = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                String DienThoai = rs.getString("DienThoai");
                String Email = rs.getString("Email");
                String GhiChu = rs.getString("GhiChu");
                Date NgayDK = rs.getDate("NgayDK");
                NguoiHoc nh = new NguoiHoc();
                list.add(nh);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }

    public NguoiHoc selectByTenNguoiHoc(NguoiHoc t) {
        NguoiHoc nh = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from NguoiHoc where HoTen = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getHoTen());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String MaNH = rs.getString("MaNH");
                nh = new NguoiHoc();
                nh.setMaNH(MaNH);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return nh;
    }

    public List<NguoiHoc> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM NguoiHoc WHERE HoTen LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public NguoiHoc findById(String manh) {
        String sql = "SELECT * FROM NguoiHoc WHERE MaNH=?";
        List<NguoiHoc> list = select(sql, manh);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public NguoiHoc selectById(NguoiHoc t) {
        NguoiHoc nh = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from NguoiHoc where MaNH=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, t.getMaNH());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String MaNH = rs.getString("MaNH");
                String TenNH = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                String DienThoai = rs.getString("DienThoai");
                String Email = rs.getString("Email");
                String GhiChu = rs.getString("GhiChu");
                Date NgayDK = rs.getDate("NgayDK");
                nh = new NguoiHoc(MaNH, TenNH, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, NgayDK);

            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
        }
        return nh;
    }

    public static void main(String[] args) {
        List<Object[]> list = ThongKeDAO.getInstance().getLuongNguoiHoc();
        for (Object[] objects : list) {
            System.out.println(objects[1]);
        }
    }

    @Override
    public int delete(String nv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private List<NguoiHoc> select(String sql, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Object[]> getLuongNguoiHoc() {
        List<Object[]> list = new ArrayList<>();
        String[] cols = {"Năm", "Số lượng", "Ngày đăng ký đầu tiên", "Ngày đăng ký cuối cùng"};
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "{CALL sp_LuongNguoiHoc}";
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

}
