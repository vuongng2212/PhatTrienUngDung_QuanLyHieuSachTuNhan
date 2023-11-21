package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.KhuyenMai;
import interfaces.daoInterface;
import list.DanhSachChiTietHoaDon;
import list.DanhSachKhuyenMai;

public class DAO_ChiTietHoaDon implements daoInterface<ChiTietHoaDon, DanhSachChiTietHoaDon>{

	@Override
	public DanhSachChiTietHoaDon getAll() {
		DanhSachChiTietHoaDon dsChiTietHD = new DanhSachChiTietHoaDon();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from chiTietHD";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			dsChiTietHD.add(new ChiTietHoaDon(rs.getString("maHD"), rs.getString("maSP"), Integer.parseInt(rs.getString("soLuong")), Double.parseDouble(rs.getString("donGia")), Integer.parseInt(rs.getString("discount"))));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return dsChiTietHD;
	}
	
	public ArrayList<ChiTietHoaDon>timCTHDtheoMa(String str){
		ArrayList<ChiTietHoaDon>listCT = new ArrayList<ChiTietHoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from chiTietHD where maHD = '" + str + "'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			listCT.add(new ChiTietHoaDon(rs.getString("maHD"), rs.getString("maSP"), Integer.parseInt(rs.getString("soLuong")), Double.parseDouble(rs.getString("donGia")), Integer.parseInt(rs.getString("discount"))));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listCT;
	}
	
	@Override
	public boolean add(ChiTietHoaDon obj) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT INTO chiTietHD (maHD, maSP, soLuong, donGia,discount) "
				+ "values(?,?,?,?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, obj.getMaHD());
			stm.setString(2, obj.getMaSP());
			stm.setInt(3, obj.getSoLuong());
			stm.setFloat(4, (float) obj.getDonGia());
			stm.setInt(5, obj.getDiscount());

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
	public boolean update(ChiTietHoaDon obj) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "Update chiTietHD set  soLuong = ?, donGia = ? \r\n"
				+ "where maHD = ? and maSP = ? and discount = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setInt(1, obj.getSoLuong());
			stm.setFloat(2,(float) obj.getDonGia());
			stm.setString(3, obj.getMaHD());
			stm.setInt(4, obj.getDiscount());
			stm.setString(5, obj.getMaSP());
			System.out.println(stm);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stm);
		}
		return true;
	}

	@Override
	public boolean delete(String ma) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stm = null;
//		String sql = "DELETE from khuyenMai where maHD = ? and maSP = ?";
//		try {
//			stm = con.prepareStatement(sql);
//			stm.setString(1, ma);
//			
//			
//			stm.executeUpdate();
//			return true;
//		} catch (SQLException e) {
//			// TODO: handle exception
//			return false;
//		}
	return false;
	}

	@Override
	public void close(PreparedStatement stm) {
		// TODO Auto-generated method stub
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
