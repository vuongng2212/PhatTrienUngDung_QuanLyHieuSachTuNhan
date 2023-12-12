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
import entity.Account;
import entity.NhanVien;
import entity.PhieuNhapHang;
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
	
	public String getLastNV() {
		String str = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select TOP 1 maNV from nhanVien ORDER BY maNV DESC ";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		if(rs.next()) {
			str = rs.getString("maNV");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return str;	

	}
	
	public String getPwd(String user) {
		String s = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from taiKhoan where username = N'"+user+"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		if(rs.next()) {
			s = rs.getString("password");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public String getPwdForChange(String str) {
		String s = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select password from taiKhoan join nhanVien on taiKhoan.username = nhanVien.soDienThoai where nhanVien.maNV = '"+str+"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		if(rs.next()) {
			s = rs.getString("password");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}
	public NhanVien getNVTheoMa(String str) {
		NhanVien nv = new NhanVien();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from nhanVien where maNV = '"+str+"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		if(rs.next()) {
//			s = rs.getString("password");
			nv.setMaNV(rs.getString("maNV"));
			nv.setTenNV(rs.getString("tenNV"));
			nv.setDoB(rs.getDate("ngaySinh"));
			nv.setGioiTinh(rs.getInt("gioiTinh"));
			nv.setSDT(rs.getString("soDienThoai"));
			nv.setDiaChi(rs.getString("diaChi"));
			nv.setEmail(rs.getString("email"));
			nv.setChucVu(rs.getString("chucVu"));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return nv;
	}
	
	public String getMaNV(String str) {
		String s = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select maNV from nhanVien where soDienThoai = N'"+str+"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		if(rs.next()) {
			s = rs.getString("maNV");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	public String getTenNV(String str) {
		String s = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select tenNV from nhanVien where soDienThoai = N'"+str+"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		if(rs.next()) {
			s = rs.getString("tenNV");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
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
	public void updateSDT(String sdt,String manv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "update nhanVien set soDienThoai = ? where maNV = ?";
		try {
			stm = con.prepareStatement(sql);
			
			stm.setString(1, sdt);
			stm.setString(2, manv);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stm);
		}
	}
	public void updateEmail(String email,String manv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "update nhanVien set email = ? where maNV = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, email);
			stm.setString(2, manv);
			
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stm);
		}
	}
	public NhanVien getNV(String maNV) {
		NhanVien nv = new NhanVien();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		try {
			String sql = "select * from nhanVien where maNV = '" + maNV +"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		while(rs.next()) {
			nv.setMaNV(rs.getString("maNV"));
			nv.setTenNV(rs.getString("tenNV"));
			try {
				nv.setDoB((Date) dateFormat.parse(rs.getString("ngaySinh")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nv.setGioiTinh(Integer.parseInt(rs.getString("gioiTinh")));
			nv.setSDT(rs.getString("soDienThoai"));
			nv.setDiaChi(rs.getString("diaChi"));
			nv.setEmail(rs.getString("email"));
			nv.setChucVu(rs.getString("chucVu"));	
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return nv;
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
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		
		String strTen = "tenNV like N'%"+tenNV+"%'";
		String strSDT = "soDienThoai = N'"+sdt+"'";
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
