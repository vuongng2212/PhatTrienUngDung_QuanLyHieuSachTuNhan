package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;
import list.DanhSachNhanVien;

public class DAO_NhanVien {
	public ArrayList<NhanVien> getAll() {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from nhanVien";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			dsNhanVien.add(new NhanVien(rs.getString("maNV"),rs.getString("tenNV"),rs.getDate("ngaySinh"),rs.getInt("gioiTinh"),rs.getString("soDienThoai"),rs.getString("diaChi"),rs.getString("email"),rs.getString("ChucVu")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNhanVien;

	}	
	
		

	public boolean add(NhanVien nv) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT [dbo].[nhanVien] VALUES"
				+ "(?,?,?,?,?,?,?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, nv.getMaNV());
			stm.setString(2, nv.getTenNV());
			stm.setDate(3, nv.getDoB());
			stm.setInt(4, nv.getGioiTinh());
			stm.setString(5, nv.getSDT());
			stm.setString(6, nv.getDiaChi());
			stm.setString(7, nv.getEmail());
			stm.setString(8, "QL");
			System.out.println(stm);
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
	
	public boolean addPwd(String user, String pwd) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT taiKhoan VALUES"
				+ "(?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, user);
			stm.setString(2, pwd);
			System.out.println(stm);
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
		String sql = "Update nhanVien set tenNV = ?, ngaySinh = ?, gioiTinh = ?, soDienThoai = ?, diaChi = ?, email = ?, chucVu = ?\r\n"
				+ "where maNV = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, nv.getTenNV());
			stm.setDate(2, nv.getDoB());
			stm.setInt(3, nv.getGioiTinh());
			stm.setString(4, nv.getSDT());
			stm.setString(5, nv.getDiaChi());
			stm.setString(6, nv.getEmail());
			stm.setString(7, nv.getChucVu());
			stm.setString(8, nv.getMaNV());

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
		String sql = "DELETE from nhanVien where maNV = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, maNV);
			
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public ArrayList<NhanVien> findNV(String tenNV, String sdt, String email, Integer gt, String ns) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		Date date = Date.valueOf(ns);
		String strTen = "tenNV = ?",strSDT = "soDienThoai = ?",strEmail = "email = ?";
		String strDate = "ngaySinh = ?";
		String strGender = "gioiTinh = ?";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		if(tenNV.equals("")) {
			strTen = "tenNV IS NOT NULL";
		}
		if(sdt.equals("")) {
			strSDT = "soDienThoai IS NOT NULL";
		}
		if(email.equals("")) {
			strEmail = "email IS NOT NULL";
		}
		if(ns.equals("")) {
			strDate = "ngaySinh IS NOT NULL";
		}
		String sql = "SELECT * FROM NhanVien WHERE ("
				+ strTen + " and "
				+ strSDT + " and "
				+ strEmail + " and "
				+ strDate + " and "
				+ strGender + ")";
		System.out.println(strTen+strSDT+strEmail+strDate+strGender);
		System.out.println(sql);
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, tenNV);
			stm.setString(2, sdt);
			stm.setString(3, email);
			stm.setDate(4, date);
			stm.setInt(5, gt);
			System.out.println(stm);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				ds.add(new NhanVien(rs.getString("maNV"),rs.getString("tenNV"),rs.getDate("ngaySinh"),rs.getInt("gioiTinh"),rs.getString("soDienThoai"),rs.getString("diaChi"),rs.getString("email"),rs.getString("ChucVu")));
			}		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return ds;
	}
	public ArrayList<NhanVien> findNV2(String tenNV, String sdt, String email, Integer gt, String ns) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		
		String strTen = "tenNV = N'"+tenNV+"'";
		String strSDT = "soDienThoai = N'"+tenNV+"'";
		String strEmail = "email = N'"+ email +"'";
		String strDate = "ngaySinh = '" +ns+ "'";
		String strGender = "gioiTinh = " + gt;
		if(tenNV.equals("")) {
			strTen = "tenNV IS NOT NULL";
		}
		if(sdt.equals("")) {
			strSDT = "soDienThoai IS NOT NULL";
		}
		if(email.equals("")) {
			strEmail = "email IS NOT NULL";
		}
		if(ns.equals("")) {
			strDate = "ngaySinh IS NOT NULL";
		}
		
		String sql = "SELECT * FROM NhanVien WHERE " +strTen + " and "+strSDT+ " and "+strEmail+ " and "+strDate+ " and "+strGender;
//		System.out.println(strTen+strSDT+strEmail+strDate+strGender);
		System.out.println(sql);
		try {
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			ds.add(new NhanVien(rs.getString("maNV"),rs.getString("tenNV"),rs.getDate("ngaySinh"),rs.getInt("gioiTinh"),rs.getString("soDienThoai"),rs.getString("diaChi"),rs.getString("email"),rs.getString("ChucVu")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
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
