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
	public Boolean checkAccount() {
		Account acc = new Account();

		String sql = "select * from taiKhoan where maNV = ? and password = ?";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1,acc.getMaNV());
			stm.setString(2,acc.getPwd());
			if(stm.execute()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stm);
		}
		return false;
		
	}	
	
		

	public boolean add(NhanVien nv) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT INTO NhanVien"
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, nv.getMaNV());
			stm.setString(2, nv.getTenNV());
			stm.setDate(3, (Date) nv.getDoB());
			stm.setInt(4, nv.getGioiTinh());
			stm.setString(5, nv.getSDT());
			stm.setString(6, nv.getDiaChi());
			stm.setString(7, nv.getEmail());
			stm.setString(8, nv.getChucVu());
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

	public boolean updateNhanVien(NhanVien nv) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "Update NhanVien set HoTen = ?, CMT = ?, SDT = ?, Gmail = ?, DiaChi = ?, GioiTinh = ?, ChucVu = ?, Pwd =?\r\n"
				+ "where MaNhanVien = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(2, nv.getTenNV());
			stm.setDate(3, (Date) nv.getDoB());
			stm.setInt(4, nv.getGioiTinh());
			stm.setString(5, nv.getSDT());
			stm.setString(6, nv.getDiaChi());
			stm.setString(7, nv.getEmail());
			stm.setString(8, nv.getChucVu());

			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			close(stm);
		}
		return true;
	}
	public void delete(String maNV) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "DELETE from NhanVien where MaNhanVien = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, maNV);
			
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
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
