package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhanCongCa;

public class DAO_PhanCongCa {
	public PhanCongCa get1Shift(String date,Integer shift) {
		PhanCongCa ds = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select pcc.maNV,maCa,ngayLamViec,nv.tenNV from phanCongCa pcc join nhanVien nv on pcc.maNV = nv.maNV where ngayLamViec = CAST('"+date+"' AS DATE) and maCa = "+ shift;
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql); 
		if(rs.next()) {
			ds = new PhanCongCa(rs.getString("maNV"),rs.getDate("ngayLamViec"),rs.getInt("maCa"),rs.getString("tenNV"));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;	

	}	
	
	public boolean add(String maNV, Integer maCa, String date) throws ParseException {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT phanCongCa values (?,?,?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date utilDate = sdf.parse(date);
		 
		Date sqlDate = new Date(utilDate.getTime());
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, maNV); 
			stm.setInt(2, maCa);
			stm.setDate(3, sqlDate);
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
	public boolean update(String maNV, Integer maCa, String date) throws ParseException {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "Update phanCongCa set maNV = ? where maCa = ? and ngayLamViec = ?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date utilDate = sdf.parse(date);
		 
		Date sqlDate = new Date(utilDate.getTime());
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, maNV);
			stm.setInt(2, maCa);
			stm.setDate(3, sqlDate);
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
	public boolean delete(String maNV, Integer maCa, String date) throws ParseException {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "DELETE phanCongCa WHERE maNV = ? and maCa = ? and ngayLamViec = ?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date utilDate = sdf.parse(date);
		 
		Date sqlDate = new Date(utilDate.getTime());
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, maNV); 
			stm.setInt(2, maCa);
			stm.setDate(3, sqlDate);
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
