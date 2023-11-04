package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhanCongCa;

public class DAO_PhanCongCa {
	public ArrayList<PhanCongCa> get1Shift(Date start, Date end, Integer shift) {
		ArrayList<PhanCongCa> ds = new ArrayList<PhanCongCa>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from phanCongCa where ngayLamViec BETWEEN CAST('"+start+"' AS DATE) AND CAST('"+end+"' AS DATE) and maCa = "+ shift;
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			ds.add(new PhanCongCa(rs.getString("maNV"),rs.getInt("maCa"),rs.getDate("ngayLamViec")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;	

	}	
	
	public boolean add(PhanCongCa ca) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT phanCongCa VALUES"
				+ "(?,?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, ca.getMaNV());
			stm.setInt(2, ca.getMaCa());
			stm.setDate(3, ca.getNgayLV());
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

	public void delete(String maNV, Integer maCa, Date ngayLV) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "DELETE from phanCongCa where maNV = ? and maCa = ? and ngayLamViec = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, maNV);
			stm.setInt(2, maCa);
			stm.setDate(3, ngayLV);
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
