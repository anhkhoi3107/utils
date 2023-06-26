package dao;

import com.edusys.model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class NhanVienDAO implements DAOInterface<NhanVien> {

	public static NhanVienDAO getInstance() {
		return new NhanVienDAO();
	}

	@Override
	public int insert(NhanVien t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into NhanVien (maNV, matKhau, hoTen, vaiTro) values" + "(?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNV());
			pst.setString(2, t.getMatKhau());
			pst.setString(3, t.getHoTen());
			pst.setBoolean(4, t.isVaiTro());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(NhanVien t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update NhanVien " + "set matKhau=?, hoTen=?, vaiTro=? " + "where maNV=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMatKhau());
			pst.setString(2, t.getHoTen());
			pst.setBoolean(3, t.isVaiTro());
			pst.setString(4, t.getMaNV());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(String nv) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from NhanVien where maNV=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, nv);
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public NhanVien selectById(NhanVien t) {
		NhanVien nv = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NhanVien where MaNV = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNV());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maNV = rs.getString("MaNV");
				String passWord = rs.getString("MatKhau");
				String name = rs.getString("HoTen");
				boolean role = rs.getBoolean("VaiTro");
				nv = new NhanVien(maNV, maNV, name, role);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nv;
	}

	@Override
	public ArrayList<NhanVien> selectAll() {
		ArrayList<NhanVien> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NhanVien";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString("maNV");
				String passWord = rs.getString("matKhau");
				String name = rs.getString("hoTen");
				boolean role = rs.getBoolean("vaiTro");
				NhanVien nv = new NhanVien(maNV, maNV, name, role);
				list.add(nv);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public NhanVien selectByUandP(NhanVien t) {
		NhanVien nv = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NhanVien where MaNV=? and MatKhau=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNV());
			pst.setString(2, t.getMatKhau());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maNV = rs.getString("MaNV");
				String passWord = rs.getString("MatKhau");
				String name = rs.getString("HoTen");
				boolean role = rs.getBoolean("VaiTro");
				nv = new NhanVien(maNV, passWord, name, role);

			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nv;
	}

	public ArrayList<NhanVien> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<NhanVien> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

    public NhanVien selectById(String strMaNV) {
        NhanVien nv = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "select * from NhanVien where MaNV=?";
            PreparedStatement pst = connection.prepareStatement(sql);
        } catch (Exception e) {
        }
        return nv;
    }
    

    private List<NhanVien> select(String sql, String manv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
