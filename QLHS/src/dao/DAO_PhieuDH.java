package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhieuDatHang;

public class DAO_PhieuDH {
	public ArrayList<PhieuDatHang> getAll() {
		ArrayList<PhieuDatHang> ds = new ArrayList<PhieuDatHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from phieuDatHang";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			ds.add(new PhieuDatHang(rs.getString("maDatHang"),rs.getString("maNv"),rs.getDate("ngayDatHang"),rs.getDouble("chietKhau")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;	

	}	
	
	public boolean add(PhieuDatHang pdh) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT phieuDatHang VALUES"
				+ "(?,?,?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, pdh.getMaDH());
			stm.setString(2, pdh.getMaNV());
			stm.setDate(3, pdh.getNgayDH());
			stm.setDouble(4, pdh.getChietKhau());
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

	public void delete(String maDH) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "DELETE from phieuDatHang where maDH = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, maDH);
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
