package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhieuNhapHang;
import entity.SanPham;
import entity.ThongKeEntity;

public class DAO_ThongKe {
	public ArrayList<PhieuNhapHang> baoCaoThuChiNhapSach(Date start, Date end) {
		ArrayList<PhieuNhapHang> ds = new ArrayList<PhieuNhapHang>();
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
			ds.add(new PhieuNhapHang(rs.getString("maDatHang"),rs.getDate("ngayDatHang"),rs.getDouble("chietKhau"),rs.getDouble("thanhTien")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;	
	}	
	public ArrayList<ThongKeEntity>SachBanChay(int dateNumber){
		ArrayList<ThongKeEntity> ds = new ArrayList<ThongKeEntity>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select sanPham.maSP, sanPham.tenSP,sum(chiTietHD.soLuong) as soLuong,sum(chiTietHD.soLuong*donGia - (chiTietHD.soLuong*chiTietHD.donGia)*(chiTietHD.discount/100)) as tongTien from chiTietHD join hoaDon on chiTietHD.maHD = hoaDon.maHD join sanPham on chiTietHD.maSP = sanPham.maSP where ngayTaoHD >= CAST(DATEADD(DAY,"+ dateNumber+",GETDATE()) AS Date)  \r\n"
					+ "group by sanPham.maSP,sanPham.tenSP";
			System.out.println(sql);
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
//			ds.add(new PhieuDatHang(rs.getString("maDatHang"),rs.getDate("ngayDatHang"),rs.getDouble("chietKhau"),rs.getDouble("thanhTien")));
			ds.add(new ThongKeEntity(rs.getNString("maSP"),rs.getString("tenSP"),Integer.parseInt(rs.getString("soLuong")),Double.parseDouble(rs.getString("tongTien"))));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<ThongKeEntity>khachHangThanThiet(int dateNumber){
		ArrayList<ThongKeEntity> ds = new ArrayList<ThongKeEntity>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select khachHang.maKH,khachHang.tenKH,count(*) as tong,sum(hoaDon.thanhTien) AS tongTien  from hoaDon join khachHang on hoaDon.maKH = khachHang.maKH where ngayTaoHD >= CAST(DATEADD(DAY,"+dateNumber+",GETDATE()) AS DATE)\r\n"
					+ "group by khachHang.tenKH,khachHang.maKH";
			System.out.println(sql);
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
//			ds.add(new PhieuDatHang(rs.getString("maDatHang"),rs.getDate("ngayDatHang"),rs.getDouble("chietKhau"),rs.getDouble("thanhTien")));
			ds.add(new ThongKeEntity(rs.getNString("maKH"),rs.getString("tenKH"),Integer.parseInt(rs.getString("tong")),Double.parseDouble(rs.getString("tongTien"))));
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
