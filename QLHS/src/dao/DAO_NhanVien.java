package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectDB;
import entity.NhanVien;
import list.DanhSachNhanVien;

public class DAO_NhanVien {
	public DanhSachNhanVien getAll() {
		DanhSachNhanVien dsNhanVien = new DanhSachNhanVien();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from NhanVien";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			dsNhanVien.themNhanVien(new NhanVien());

		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return dsNhanVien;	
	}	
	
		

	public void add(NhanVien nv) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT INTO NhanVien (MaNhanVien, HoTen, CMT, SDT, Gmail, DiaChi, GioiTinh, chucVu, Pwd) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, nv.getMaNV());
			stm.setString(6, nv.getDiaChi());
			stm.setBoolean(7, nv.getGioiTinh());
			stm.setString(8, nv.getChucVu());
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

	public boolean updateNhanVien(NhanVien nv) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "Update NhanVien set HoTen = ?, CMT = ?, SDT = ?, Gmail = ?, DiaChi = ?, GioiTinh = ?, ChucVu = ?, Pwd =?\r\n"
				+ "where MaNhanVien = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(5, nv.getDiaChi());
			stm.setBoolean(6, nv.getGioiTinh());
			stm.setString(7, nv.getChucVu());
			stm.setString(9, nv.getMaNV());

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
