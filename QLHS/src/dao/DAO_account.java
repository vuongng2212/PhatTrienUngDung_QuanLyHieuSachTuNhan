package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Account;
import entity.NhanVien;

public class DAO_account {
	public Boolean checkAccount(Account acc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		System.out.println(":::"+con);
		String sql = "select * from taiKhoan where username = N'"+acc.getUser()+"' and password = N'"+acc.getPwd()+"'";
		try {
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		if(rs.next()) {
			return true;
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public void deleteAcc(String str) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "delete from taiKhoan where username = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, str);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void insertAcc(String username,String pwd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "insert into taiKhoan(username,password) values (?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, pwd);
			
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public String getRole(String sdt) {
		String str = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select chucVu from nhanVien where soDienThoai = N'"+sdt+"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			str = rs.getString("chucVu");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return str;

	}
	public NhanVien getIDandName(String sdt) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		NhanVien nv = null;
		try {
			String sql = "select maNV,tenNV from nhanVien where soDienThoai = N'"+sdt+"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		if(rs.next()) {
			nv = new NhanVien(rs.getString("maNV"), rs.getString("tenNV"));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return nv;
	}
	public String ReturnPwd(String username) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String str = "";
		
		try {
			String sql = "select * from taiKhoan where username = '"+ username+ "'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			str = rs.getString("password");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}
	public void ChangePwd(String username,String newPwd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "update taiKhoan set password = ? where username = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, newPwd);
			stm.setString(2, username);
			System.out.println(stm);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stm);
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
