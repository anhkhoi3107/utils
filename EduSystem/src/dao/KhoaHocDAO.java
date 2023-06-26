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
import com.edusys.model.KhoaHoc;

public class KhoaHocDAO implements DAOInterface<KhoaHoc> {

	public static KhoaHocDAO getInstance() {
		return new KhoaHocDAO();
	}

	@Override
	public int insert(KhoaHoc t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into KhoaHoc (MaCD, HocPhi, ThoiLuong, NgayKhaiGiang, GhiChu, MaNV, NgayTao) values "
					+ "(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaCD());
			pst.setDouble(2, t.getHocPhi());
			pst.setInt(3, t.getThoiLuong());
			pst.setDate(4, t.getNgayKG());
			pst.setString(5, t.getGhiChu());
			pst.setString(6, t.getMaNV());
			pst.setDate(7, t.getNgayTao());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(KhoaHoc t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update KhoaHoc "
					+ "set MaCD=?, HocPhi=?, ThoiLuong=?, NgayKhaiGiang=?, GhiChu=?, MaNV=?, NgayTao=? "
					+ "where MaKH=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaCD());
			pst.setDouble(2, t.getHocPhi());
			pst.setInt(3, t.getThoiLuong());
			pst.setDate(4, t.getNgayKG());
			pst.setString(5, t.getGhiChu());
			pst.setString(6, t.getMaNV());
			pst.setDate(7, t.getNgayTao());
			pst.setInt(8, t.getMaKH());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	
	public int delete(KhoaHoc t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from KhoaHoc where MaKH=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, t.getMaKH());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	
	public KhoaHoc selectByID(KhoaHoc t) {
		KhoaHoc kh = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from KhoaHoc where MaKH = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, t.getMaKH());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int MaKH = rs.getInt("MaKH");
                                String MaCD = rs.getString("MaCD");
				double HocPhi = rs.getDouble("HocPhi");
				int ThoiLuong = rs.getInt("ThoiLuong");
				Date NgayKG = rs.getDate("NgayKG");
				String GhiChu = rs.getString("GhiChu");
				String MaNV = rs.getString("MaNV");
				Date NgayTao = rs.getDate("ngayTao");
				kh = new KhoaHoc(MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kh;
	}

	public ArrayList<KhoaHoc> selectByMaChuyenDe(KhoaHoc t) {
		ArrayList<KhoaHoc> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from KhoaHoc where MaCD = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaCD());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int MaKH = rs.getInt("MaKH");
				String MaCD = rs.getString("MaCD");
				double HocPhi = rs.getDouble("HocPhi");
				int ThoiLuong = rs.getInt("ThoiLuong");
				Date NgayKG = rs.getDate("NgayKG");
				String GhiChu = rs.getString("GhiChu");
				String MaNV = rs.getString("MaNV");
				Date NgayTao = rs.getDate("NgayTao");
				KhoaHoc kh = new KhoaHoc(MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV);
				list.add(kh);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<KhoaHoc> selectAll() {
		ArrayList<KhoaHoc> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from KhoaHoc";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int MaKH = rs.getInt("MaKH");
				String MaCD = rs.getString("MaCD");
				double HocPhi = rs.getDouble("HocPhi");
				int ThoiLuong = rs.getInt("ThoiLuong");
				Date NgayKG = rs.getDate("NgayKG");
				String GhiChu = rs.getString("GhiChu");
				String MaNV = rs.getString("MaNV");
				Date NgayTao = rs.getDate("NgayTao");
//				System.out.println(DataHelper.dateString(ngayTao));
				KhoaHoc kh = new KhoaHoc(MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV);
				list.add(kh);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public ArrayList<KhoaHoc> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<KhoaHoc> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object[]> getBangDiem(int maKhoaHoc) {
		List<Object[]> list = new ArrayList<>();
                String[] cols = { "MaNH", "HoTen", "Diem" };
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

	public List<Object[]> selectByTotal() {
		List<Object[]> list = new ArrayList<>();
		String cols[] = { "MaKH", "MaCD", "ThoiLuong", "HocPhi", "NgayKG", "GhiChu", "MaNV",
				"NgayTao" };
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select MaKH, cd.MaCD, cd.ThoiLuong, cd.HocPhi, NgayKG, GhiChu,MaNV, NgayTao from KhoaHoc as kh\r\n"
					+ "inner join ChuyenDe as cd  on kh.MaCD = cd.MaCD";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
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

	public ArrayList<Integer> getYearKH() {
		ArrayList<Integer> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select distinct year(NgayKG) as N'namKhaiGiang' from KhoaHoc order by N'namKhaiGiang' desc";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int namKhaiGiang = rs.getInt("namKhaiGiang");
				list.add(namKhaiGiang);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

    @Override
    public KhoaHoc selectById(KhoaHoc t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String nv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<KhoaHoc> selectKhoaHocByChuyenDe(String maCD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        ArrayList<KhoaHoc> list = KhoaHocDAO.getInstance().selectAll();
        for (KhoaHoc khoaHoc : list) {
            System.out.println(khoaHoc);
        }
    }

}
