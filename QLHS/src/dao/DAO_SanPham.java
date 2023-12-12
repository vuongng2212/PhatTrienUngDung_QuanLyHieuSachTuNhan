package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhuyenMai3Field;
import entity.NhanVien;
import entity.SanPham;
import entity.SanPhamShowBill;
import interfaces.daoInterface;
import list.DanhSachSanPham;

public class DAO_SanPham implements daoInterface<SanPham, DanhSachSanPham>{
	@Override
	public DanhSachSanPham getAll() {
		DanhSachSanPham dsSP = new DanhSachSanPham();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from sanPham where tinhTrang = 1";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			dsSP.add(new SanPham(rs.getString("maSP"), rs.getString("tenSP"), rs.getString("tenTacGia"), rs.getString("nhaXB"), rs.getInt("namXB"), rs.getInt("soLuong"), rs.getDouble("donGiaGoc"), rs.getDouble("donGiaMua"), rs.getString("tinhTrang"), rs.getString("danhMuc")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return dsSP;	
	}
	

	public DanhSachSanPham getAllCondiTion(int n) {
		String textKey  = "";
		if(n==0) {
			textKey= "maSP";
		}else if(n==1) {
			textKey= "tenSP";
		}else if(n==2) {
			textKey = "tenTacGia";
		}else if(n==3) {
			textKey = "danhMuc";
		}else if(n==4) {
			textKey="nhaXB";
		}else if(n==5) {
			textKey = "namXB";
		}else if(n==6) {
			textKey = "soLuong";
		}else if(n==7) {
			textKey="donGiaGoc";
		}else if(n==8) {
			textKey="donGiaMua";
		}
		DanhSachSanPham dsSP = new DanhSachSanPham();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			
			String sql = "select * from sanPham where tinhTrang = 1 order by "+textKey+" desc";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			dsSP.add(new SanPham(rs.getString("maSP"), rs.getString("tenSP"), rs.getString("tenTacGia"), rs.getString("nhaXB"), rs.getInt("namXB"), rs.getInt("soLuong"), rs.getDouble("donGiaGoc"), rs.getDouble("donGiaMua"), rs.getString("tinhTrang"), rs.getString("danhMuc")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return dsSP;	
	}
	
	@SuppressWarnings("finally")
	@Override
	public boolean add(SanPham sp) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT INTO sanPham (maSP, tenSP, tenTacGia, danhMuc, nhaXB, namXB, soLuong, donGiaGoc, donGiaMua,tinhTrang) "
				+ "values(?,?,?,?,?,?,?,?,?,1)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, sp.getMaSP());
			stm.setString(2, sp.getTenSP());
			stm.setString(3, sp.getTenTG());
			stm.setString(4, sp.getDanhMuc());
			stm.setString(5, sp.getNhaXB());
			stm.setInt(6, sp.getNamXB());
			stm.setInt(7, sp.getSoLuong());
			stm.setFloat(8,(float) sp.getDonGiaGoc());
			stm.setFloat(9,(float) sp.getDonGiaMua());
//			stm.setString(10, sp.getTinhTrang());
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			close(stm);
			return true;
		}
	}
	public String sinhMaSP() {
		String ma = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select top 1 maSP from sanPham where maSP like 'SP%' order by maSP desc";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			ma = rs.getString("maSP");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ma;
	}
	public String searchTenSP(String str) {
		String tenSP = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select tenSP from sanPham where maSP = '"+str+"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			tenSP = rs.getString("tenSP");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tenSP;
	}
	public String searchTenTacGia(String str) {
		String tacGia = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select tenTacGia from sanPham where maSP = '"+str+"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			tacGia = rs.getString("tenTacGia");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tacGia;
	}
	public int searchSoLuong(String str) {
		int soLuong = -1;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select soLuong from sanPham where maSP = '"+str+"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			soLuong = rs.getInt("soLuong");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return soLuong;
	}
	@Override
	public boolean update(SanPham sp) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "Update sanPham set tenSP = ?, tenTacGia = ?, danhMuc = ?, nhaXB = ?, namXB = ?, soLuong = ?, donGiaGoc = ?, donGiaMua =? \r\n"
				+ "where maSP = ?";
		try {
			stm = con.prepareStatement(sql);
			
			stm.setString(1, sp.getTenSP());
			stm.setString(2, sp.getTenTG());
			stm.setString(3, sp.getDanhMuc());
			stm.setString(4, sp.getNhaXB());
			stm.setInt(5, sp.getNamXB());
			stm.setInt(6, sp.getSoLuong());
			stm.setFloat(7,(float) sp.getDonGiaGoc());
			stm.setFloat(8,(float) sp.getDonGiaMua());
//			stm.setString(9, sp.getTinhTrang());
			stm.setString(9, sp.getMaSP());
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
	public void giamSoLuong(String maSP,int count) {
		System.out.println("Bat dau tru so k");
		ConnectDB.getInstance();
//		DAO_SanPham daosp = new DAO_SanPham();
		Connection con = ConnectDB.getConnection();
//		int soLuongTemp = daosp.getSoLuongSP(maSP);
//		int sum = soLuongTemp - count;
		PreparedStatement stm = null;
		String sql = "update sanPham set soLuong = soLuong - ? where maSP = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, count);
			stm.setString(2, maSP);		
			stm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}	
	}
	public void tangSoLuong(String maSP,int count) {
		System.out.println("Bat dau tru so k");
		ConnectDB.getInstance();
//		DAO_SanPham daosp = new DAO_SanPham();
		Connection con = ConnectDB.getConnection();
//		int soLuongTemp = daosp.getSoLuongSP(maSP);
//		int sum = soLuongTemp - count;
		PreparedStatement stm = null;
		String sql = "update sanPham set soLuong = soLuong + ? where maSP = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, count);
			stm.setString(2, maSP);		
			stm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}	
	}
	public int getSoLuongSP(String str) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "select soLuong from sanPham where maSP = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, str);
			
//			stm.executeUpdate();
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				return Integer.parseInt(rs.getString("soLuong"));
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	@Override
	public boolean delete(String maSP) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "update sanPham set tinhTrang = 0 where maSP = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, maSP);
			
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
	}
	
	
	
	public ArrayList<SanPhamShowBill>sanPhamBill(){
		
//		DAO_KhuyenMai daokm = new DAO_KhuyenMai();
//		ArrayList<KhuyenMai3Field>ktraConTonTai(){
		
		ArrayList<SanPhamShowBill>listSP = new ArrayList<SanPhamShowBill>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
//		PreparedStatement stm = null;
		try {
			String sql = "select distinct sanPham.maSP,sanPham.tenSP,sanPham.tenTacGia,sanPham.danhMuc,sanPham.nhaXB,sanPham.namXB,soLuong,donGiaGoc,donGiaMua,tinhTrang,khuyenMai.discount from khuyenMai join sanPham on khuyenMai.maSP = sanPham.maSP where ngayTao<GETDATE() and ngayHetHan>GETDATE()\r\n";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			listSP.add(new SanPhamShowBill(rs.getString("maSP"), rs.getString("tenSP"), rs.getString("tenTacGia"), rs.getString("nhaXB"), rs.getInt("namXB"), rs.getInt("soLuong"), rs.getDouble("donGiaGoc"), rs.getDouble("donGiaMua"), rs.getString("tinhTrang"), rs.getString("danhMuc"),Integer.parseInt(rs.getString("discount"))));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return listSP;
	}
	//written by Vuong
	public ArrayList<SanPham> findSP(String tenSP, String danhMuc, String nhaXB, String namXB) {
		ArrayList<SanPham> ds = new ArrayList<SanPham>();
		
		String strTen = "tenSP like N'%" +tenSP+ "%'";
		String strDanhMuc = "danhMuc = N'"+danhMuc+"'";
		String strNhaXB = "nhaXB = N'"+nhaXB+"'";
		String strNamXB = "namXB = "+namXB+"";

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		if(tenSP.equals("")) {
			strTen = "tenSP IS NOT NULL";
		}
		if(danhMuc.equals("")) {
			strDanhMuc = "danhMuc IS NOT NULL";
		}
		if(nhaXB.equals("")) {
			strNhaXB = "nhaXB IS NOT NULL";
		}
		if(namXB.equals("")) {
			strNamXB = "namXB IS NOT NULL";
		}
		String sql = "SELECT * FROM sanPham WHERE ("
				+ strTen + " and "
				+ strDanhMuc + " and "
				+ strNhaXB + " and "
				+ strNamXB + ")";
		try {
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				ds.add(new SanPham(rs.getString("maSP"), rs.getString("tenSP"), rs.getString("nhaXB"), rs.getInt("namXB"), rs.getInt("soLuong"), rs.getFloat("donGiaGoc"),rs.getString("tinhTrang"), rs.getString("danhMuc")));
			}		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return ds;
	}
	@Override
	public void close(PreparedStatement stm) {
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
