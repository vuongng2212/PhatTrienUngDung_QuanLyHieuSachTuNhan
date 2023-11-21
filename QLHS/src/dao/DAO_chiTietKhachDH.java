package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.ChiTietKhachDH;
import interfaces.daoInterface;
import list.DanhSachChiTietKhachDH;

public class DAO_chiTietKhachDH implements daoInterface<ChiTietKhachDH, DanhSachChiTietKhachDH>{

	
	
	@Override
	public DanhSachChiTietKhachDH getAll() {
		DanhSachChiTietKhachDH dsChiTietDH = new DanhSachChiTietKhachDH();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from chiTietDatSach";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			dsChiTietDH.add(new ChiTietKhachDH(rs.getString("maDH"),rs.getString("maSP"),Integer.parseInt(rs.getString("soLuong")),Double.parseDouble(rs.getString("donGiaBan")),Integer.parseInt(rs.getString("discount"))));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return dsChiTietDH;
	}
	
	
	
	public DanhSachChiTietKhachDH getTheoMa(String str) {
		DanhSachChiTietKhachDH dsChiTietDH = new DanhSachChiTietKhachDH();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from chiTietDatSach where maDH = '"+str+"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			dsChiTietDH.add(new ChiTietKhachDH(rs.getString("maDH"),rs.getString("maSP"),Integer.parseInt(rs.getString("soLuong")),Double.parseDouble(rs.getString("donGiaBan")),Integer.parseInt(rs.getString("discount"))));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return dsChiTietDH;
	}
	
	@Override
	public boolean add(ChiTietKhachDH obj) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "insert into chiTietDatSach(maDH,maSP,soLuong,donGiaBan,discount) values (?,?,?,?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, obj.getMaDH());
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

	public String tenSPTheoMa(String str) {
		String name = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select tenSP from sanPham where maSP = '" + str + "'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			name = rs.getString("tenSP");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	public String tenNVTheoMa(String str) {
		String name = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select nhanVien.tenNV from datSach join nhanVien on datSach.maNV = nhanVien.maNV where maDH = '" + str + "'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			name = rs.getString("tenNV");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

	@Override
	public boolean update(ChiTietKhachDH obj) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "update chiTietDatSach set maSP = ? ,soLuong = ?,donGiaBan = ? ,discount = ? where maDH = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, obj.getMaSP());
			stm.setInt(2,obj.getSoLuong());
			stm.setFloat(3, (float)obj.getDonGia());
			stm.setInt(4, obj.getDiscount());
			stm.setString(5, obj.getMaDH());
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close(PreparedStatement stm) {
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
