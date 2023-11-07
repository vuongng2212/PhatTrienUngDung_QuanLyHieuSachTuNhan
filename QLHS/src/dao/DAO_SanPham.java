package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;

import entity.SanPham;
import interfaces.daoInterface;
import list.DanhSachSanPham;

public class DAO_SanPham implements daoInterface<SanPham, DanhSachSanPham>{
	@Override
	public DanhSachSanPham getAll() {
		DanhSachSanPham dsSP = new DanhSachSanPham();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from sanPham";
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
				+ "values(?,?,?,?,?,?,?,?,?,?)";
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
			stm.setString(10, sp.getTinhTrang());
			System.out.println(stm);
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
	@Override
	public boolean update(SanPham sp) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "Update sanPham set tenSP = ?, tenTacGia = ?, danhMuc = ?, nhaXB = ?, namXB = ?, soLuong = ?, donGiaGoc = ?, donGiaMua =?, tinhTrang=? \r\n"
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
			stm.setString(9, sp.getTinhTrang());
			stm.setString(10, sp.getMaSP());
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
	@Override
	public boolean delete(String maSP) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "DELETE from sanPham where maSP = ?";
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
