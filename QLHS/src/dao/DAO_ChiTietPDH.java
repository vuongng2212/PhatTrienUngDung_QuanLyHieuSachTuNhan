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
	public ArrayList<ChiTietPhieuDH> getAll(String maDH) {
		ArrayList<ChiTietPhieuDH> ds = new ArrayList<ChiTietPhieuDH>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select maDH,ctdh.maSP,tenSP,ctdh.soLuong from chiTietDatHang ctdh join sanPham sp on ctdh.maSP = sp.maSP where maDH = N'"+maDH+"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			ds.add(new ChiTietPhieuDH(rs.getString("maDH"),rs.getString("maSP"),rs.getString("tenSP"),rs.getInt("soLuong")));
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
				+ "(?,?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, pdh.getMaDH());
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
	
	public boolean updateSL(ChiTietPhieuDH pdh) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "UPDATE sanPham SET soLuong = soLuong + ? "
				+ "where maSP = ?";
		System.out.println(pdh.getMaSP()+" "+pdh.getSoLuong());
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
