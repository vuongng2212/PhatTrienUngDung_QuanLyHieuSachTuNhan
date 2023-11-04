package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.SanPham;
import interfaces.daoInterface;
import list.DanhSachKhachHang;
import list.DanhSachSanPham;

public class DAO_KhachHang implements daoInterface<KhachHang, DanhSachKhachHang>{
	
	@Override
	public DanhSachKhachHang getAll() {
		DanhSachKhachHang dsKH = new DanhSachKhachHang();
		ConnectDB.getInstance();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from khachHang";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			dsKH.add(new KhachHang(rs.getString("maKH"),rs.getString("tenKH"),rs.getString("SDT"),rs.getString("diaChi"),rs.getString("loaiKH")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return dsKH;
	}

	@Override
	public boolean add(KhachHang obj) {
		System.out.println("Bat Dau Ket Noi Ket noi");
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT INTO khachHang (maKH, tenKH, SDT, diaChi, loaiKH) "
				+ "values(?,?,?,?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, obj.getMaKH());
			stm.setString(2, obj.getTenKH());
			stm.setString(3, obj.getSdt());
			stm.setString(4, obj.getDiaChi());
			stm.setString(5, obj.getLoaiKH());
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
	public boolean update(KhachHang obj) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "Update khachHang set tenKH = ?,SDT = ?,diaChi = ?,loaiKH = ? \r\n"
				+ "where maKH = ?";
		try {
			stm = con.prepareStatement(sql);
			
			stm.setString(1, obj.getTenKH());
			stm.setString(2, obj.getSdt());
			stm.setString(3, obj.getDiaChi());
			stm.setString(4, obj.getLoaiKH());
			stm.setString(5, obj.getMaKH());
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
		String sql = "DELETE from khachHang where maKH = ?";
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
	public static void testing() {
		System.out.println("ahihi");
	}
}
