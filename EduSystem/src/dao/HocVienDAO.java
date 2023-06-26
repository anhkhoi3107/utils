package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import database.JDBCUtil;
import com.edusys.model.HocVien;
import com.edusys.model.NguoiHoc;

public class HocVienDAO implements DAOInterface<HocVien> {

	public static HocVienDAO getInstance() {
		return new HocVienDAO();
	}

	@Override
	public int insert(HocVien t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into HocVien (MaKH, MaNH, Diem) values " + "(?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, t.getMaKH());
			pst.setString(2, t.getMaNH());
			pst.setDouble(3, t.getDiem());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(HocVien t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update HocVien " + "set MaKH=?, MaNH=?, Diem=? " + "where MaHV=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, t.getMaKH());
			pst.setString(2, t.getMaNH());
			pst.setDouble(3, t.getDiem());
			pst.setInt(4, t.getMaHV());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}


	public int delete(HocVien t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from HocVien where MaHV=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, t.getMaHV());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi xóa " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}


	public HocVien selectByID(HocVien t) {
		HocVien hv = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from HocVien where maHocVien=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, t.getMaHV());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int MaHV = rs.getInt("MaHV");
				int MaKH = rs.getInt("MaKH");
				String MaNH = rs.getString("MaNH");
				double Diem = rs.getDouble("Diem");
				hv = new HocVien(MaHV, MaKH, MaNH);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hv;
	}

	@Override
	public ArrayList<HocVien> selectAll() {
		ArrayList<HocVien> list = new ArrayList<>();
		try {
                    Connection connection = JDBCUtil.getConnection();
			String sql = "select * from HocVien";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int MaHV = rs.getInt("MaHV");
				int MaKH = rs.getInt("MaKH");
				String MaNH = rs.getString("MaNH");
				double Diem = rs.getDouble("Diem");
				HocVien hv = new HocVien(MaHV, MaKH, MaNH);
				list.add(hv);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

        public ArrayList<NguoiHoc> selectAllNotCourse() {
		ArrayList<NguoiHoc> list = new ArrayList<>();
		try {
                    Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM NguoiHoc where MaNH not in (select MaNH from HocVien)";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
                          
				
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public ArrayList<HocVien> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<HocVien> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object[]> getDanhSachNH(int MaKH) {
		List<Object[]> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select hv.*, nh.nameNH from HocVien hv\r\n" + "inner join NguoiHoc nh\r\n"
					+ "on nh.MaNH = hv.MaNH\r\n" + "where MaKH = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, MaKH);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int maHocVien = rs.getInt("MaHV");
				String maNguoiHoc = rs.getString("MaNH");
				String nameNH = rs.getString("nameNH");
				double diem = rs.getDouble("Diem");
				Object[] vals = { maHocVien, maNguoiHoc, nameNH, diem };
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Object[]> getDanhSachNhChuaNhapDiem(int maKhoaHoc) {
		List<Object[]> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select hv.*, nh.nameNH from HocVien hv\r\n" + "inner join NguoiHoc nh\r\n"
					+ "on hv.MaNH = nh.MaNH\r\n" + "where MaKH = ? and Diem = -1";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, maKhoaHoc);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int maHocVien = rs.getInt("MaHV");
				String maNguoiHoc = rs.getString("MaNH");
				String nameNH = rs.getString("nameNH");
				double diem = rs.getDouble("Diem");
				Object[] vals = { maHocVien, maNguoiHoc, nameNH, diem };
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}

	public List<Object[]> getDanhSachNHDaNhapDiem(int maKhoaHoc) {
		List<Object[]> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select hv.*, nh.nameNH from HocVien hv\r\n" + "inner join NguoiHoc nh\r\n"
					+ "on hv.MaNH = nh.MaNH\r\n" + "where MaKH = ? and Diem >= 0";
                        PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, maKhoaHoc);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int MaHV = rs.getInt("MaHV");
				String MaNH = rs.getString("MaNH");
				String nameNH = rs.getString("nameNH");
				double Diem = rs.getDouble("Diem");
				Object[] vals = { MaHV, MaNH, nameNH, Diem };
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

    @Override
    public HocVien selectById(HocVien t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String nv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
