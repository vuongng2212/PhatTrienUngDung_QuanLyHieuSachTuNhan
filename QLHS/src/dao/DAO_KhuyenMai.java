package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.KhuyenMai;
import interfaces.daoInterface;
import list.DanhSachKhachHang;
import list.DanhSachKhuyenMai;

public class DAO_KhuyenMai implements daoInterface<KhuyenMai, DanhSachKhuyenMai>{
	
	
	@Override
	public DanhSachKhuyenMai getAll() {
		DanhSachKhuyenMai dsKM = new DanhSachKhuyenMai();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from NhanVien";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			dsKM.add(new KhuyenMai());
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return dsKM;
	}

	@Override
	public boolean add(KhuyenMai obj) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT INTO khuyenMai (maKM, maSP, discount, ngayTao, ngayHetHan) "
				+ "values(?,?,?,?,?)";
		
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, obj.getMaKM());
			stm.setString(2, obj.getMaSP());
			stm.setInt(3, obj.getDiscount());
			stm.setString(4, dateFormat.format(obj.getNgayTao()));
			stm.setString(5, dateFormat.format(obj.getNgayHetHan()));
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
	public boolean update(KhuyenMai obj) {
		SimpleDateFormat dateformat  = new SimpleDateFormat("yyyy-MM-dd");
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "Update khuyenMai set maSP = ?, discount = ?, ngayTao = ?, ngayHetHan = ? \r\n"
				+ "where maKM = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, obj.getMaSP());
			stm.setInt(2, obj.getDiscount());
			
			
			stm.setString(3, dateformat.format(obj.getNgayTao()));
			stm.setString(4,  dateformat.format(obj.getNgayHetHan()));
			stm.setString(5, obj.getMaKM());
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
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "DELETE from khuyenMai where maKM = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, ma);
			
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
