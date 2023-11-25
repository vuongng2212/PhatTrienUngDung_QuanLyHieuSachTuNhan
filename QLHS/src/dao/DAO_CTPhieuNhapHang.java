package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CTPhieuNhapHang;

public class DAO_CTPhieuNhapHang {
	public ArrayList<CTPhieuNhapHang> getAll(String maNH) {
		ArrayList<CTPhieuNhapHang> ds = new ArrayList<CTPhieuNhapHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select maNH,ctdh.maSP,tenSP,ctdh.soLuong from chiTietNhapHang ctdh join sanPham sp on ctdh.maSP = sp.maSP where maNH = N'"+maNH+"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			ds.add(new CTPhieuNhapHang(rs.getString("maNH"),rs.getString("maSP"),rs.getString("tenSP"),rs.getInt("soLuong")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;	

	}	
	
	public boolean add(CTPhieuNhapHang pdh) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT chiTietNhapHang VALUES"
				+ "(?,?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, pdh.getmaNH());
			stm.setString(2, pdh.getMaSP());
			stm.setInt(3, pdh.getSoLuong());
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
	
	public boolean updateSL(CTPhieuNhapHang pdh) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "UPDATE sanPham SET soLuong = soLuong + ? "
				+ "where maSP = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, pdh.getSoLuong());
			stm.setString(2, pdh.getMaSP());
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
		String sql = "DELETE from chiTietNhapHang where maNH = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, maNH);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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
