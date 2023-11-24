package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CTPhieuNhapHang;
import entity.PhieuNhapHang;

public class DAO_PhieuNhapHang {
	public ArrayList<PhieuNhapHang> getAll(String start, String end) {
		ArrayList<PhieuNhapHang> ds = new ArrayList<PhieuNhapHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select maNH,pdh.maNv,nv.tenNV,ngayNhap,chietKhau,trangThai from phieuNhap pdh join nhanVien nv on pdh.maNv = nv.maNV\n"
					+ "where ngayNhap BETWEEN CAST('"+start+"' AS DATE) AND CAST('"+end+"' AS DATE)";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			ds.add(new PhieuNhapHang(rs.getString("maNH"),rs.getString("maNv"),rs.getString("tenNV"),rs.getDate("ngayNhap"),rs.getDouble("chietKhau"),rs.getInt("trangThai")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;	

	}	
	public String getLastPhieuDH() {
		String sttmaNH = null;
		ArrayList<PhieuNhapHang> ds = new ArrayList<PhieuNhapHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select TOP 1 * from phieuNhap ORDER BY maNH DESC ";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		if(rs.next()) {
			sttmaNH = rs.getString("maNH");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return sttmaNH;	

	}	
	public boolean add(PhieuNhapHang pdh) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT phieuNhap VALUES"
				+ "(?,?,?,?,?)";
//		System.out.println(pdh.getmaNH() + pdh.getMaNV() + pdh.getNgayDH() + pdh.getChietKhau() );
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, pdh.getmaNH());
			stm.setString(2, pdh.getMaNV());
			stm.setDate(3, pdh.getNgayDH());
			stm.setDouble(4, pdh.getChietKhau());
			stm.setInt(5, 0);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			close(stm);
		}
		return true;
	}

	public void delete(String maNH) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "DELETE from phieuNhap where maNH = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, maNH);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public boolean updateTrangThai(String maNH, Integer value) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "UPDATE phieuNhap SET trangThai = ? "
				+ "where maNH = ?";

		try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, value);
			stm.setString(2, maNH);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			close(stm);
		}
		return true;
	}
	private void close(PreparedStatement stm) {
		// TODO Auto-generated method stub
		if(stm!=null) {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
