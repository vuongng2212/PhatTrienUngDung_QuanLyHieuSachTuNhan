package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectDB;
import entity.Ca;
import entity.PhanCongCa;

public class DAO_Ca {
	public Ca getGio(Integer maCa) {
		Ca ds = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from ca where maCa = "+maCa;
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql); 
		if(rs.next()) {
			ds = new Ca(rs.getInt("maCa"), rs.getString("gioBatDau"), rs.getString("gioKetThuc"));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;	

	}	
}
