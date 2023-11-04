package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietPhieuDH;

public class DAO_ChiTietPDH {
	public ArrayList<ChiTietPhieuDH> getAll() {
		ArrayList<ChiTietPhieuDH> ds = new ArrayList<ChiTietPhieuDH>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from chiTietDatHang";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			ds.add(new ChiTietPhieuDH());
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;	

	}	
	
	public boolean add(ChiTietPhieuDH pdh) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT chiTietDatHang VALUES"
				+ "(?,?,?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, pdh.getMaDH());
			stm.setString(2, pdh.getMaSP());
			stm.setInt(3, pdh.getSoLuong());
			stm.setDouble(4, pdh.getDonGiaNhap());
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
		String sql = "DELETE from chiTietDatHang where maDH = ?";
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
