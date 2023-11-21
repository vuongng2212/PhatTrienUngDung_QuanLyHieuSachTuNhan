package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;

public class DAO_PhatSinhMa {
	
	public String getMaKHCuoi() {
		String ma="";
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "{call getmaKHTuDong}";
			CallableStatement myCall = con.prepareCall(sql);
			ResultSet rs = myCall.executeQuery();
			while (rs.next())
				ma = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ma;
	}
	public static void main(String[] args) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		DAO_PhatSinhMa psm = new DAO_PhatSinhMa();
		System.out.println(psm.getMaKHCuoi());
		
	}
	
}
