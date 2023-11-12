package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhieuDatHang;
import entity.SanPham;

public class DAO_ThongKe {
	public ArrayList<PhieuDatHang> baoCaoThuChiNhapSach(Date start, Date end) {
		ArrayList<PhieuDatHang> ds = new ArrayList<PhieuDatHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select pdh.maDatHang, ngayDatHang , chietKhau ,thanhTien = SUM(ctPDH.soLuong*sp.donGiaGoc*(100-pdh.chietKhau)/100) from phieuDatHang pdh join chiTietDatHang ctPDH on pdh.maDatHang = ctPDH.maDH join sanPham sp on sp.maSP = ctPDH.maSP "
					+"where ngayDatHang BETWEEN CAST('"+start+"' AS DATE) AND CAST('"+end+"' AS DATE) and trangThai = 1 "
					+"group by pdh.maDatHang, ngayDatHang, chietKhau";
			System.out.println(sql);
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			ds.add(new PhieuDatHang(rs.getString("maDatHang"),rs.getDate("ngayDatHang"),rs.getDouble("chietKhau"),rs.getDouble("thanhTien")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;	

	}	
	public ArrayList<SanPham> ThongKeSLNhap(Date start, Date end) {
		ArrayList<SanPham> ds = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select sp.maSP , tenSP,soLuongNhap = SUM(ctPDH.soLuong), soLuongGoc = sp.soLuong - SUM(ctPDH.soLuong), sp.soLuong from phieuDatHang pdh join chiTietDatHang ctPDH on pdh.maDatHang = ctPDH.maDH join sanPham sp on sp.maSP = ctPDH.maSP\r\n"
					+ "where ngayDatHang BETWEEN CAST('"+start+"' AS DATE) AND CAST('"+end+"' AS DATE) and trangThai = 1\r\n"
					+ "group by sp.maSP, tenSP, sp.soLuong";
			System.out.println(sql);
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			ds.add(new SanPham(rs.getString("maSP"),rs.getString("tenSP"),rs.getInt("soLuongNhap"),rs.getInt("soLuongGoc"),rs.getInt("soLuong")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;	

	}	
}
