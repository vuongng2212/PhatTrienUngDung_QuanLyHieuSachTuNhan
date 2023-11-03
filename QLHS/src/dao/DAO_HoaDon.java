package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.NhanVien;
import interfaces.daoInterface;
import list.DanhSachHoaDon;
import list.DanhSachKhuyenMai;
import list.DanhSachNhanVien;

public class DAO_HoaDon implements daoInterface<HoaDon, DanhSachHoaDon>{
	
	@Override
	public DanhSachHoaDon getAll() {
		DanhSachHoaDon dsHoaDon = new DanhSachHoaDon();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from hoaDon";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			dsHoaDon.add(new HoaDon());

		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return dsHoaDon;	
	}

	@Override
	public void add(HoaDon obj) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString  = dateFormat.format(obj.getNgayTaoHD());
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT INTO hoaDon (maHD, maNV, maKH, ngayTaoHD) "
				+ "values(?,?,?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, obj.getMaHD());
			stm.setString(2, obj.getMaNV());
			stm.setString(3, obj.getMaKH());
			
			stm.setString(4, dateString);
			
			System.out.println(stm);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stm);
		}
		
	}

	@Override
	public boolean update(HoaDon obj) {
		SimpleDateFormat dateformat  = new SimpleDateFormat("yyyy-MM-dd");
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "Update hoaDon set maNV = ?,maKH = ?,ngayTaoHD = ? \r\n"
				+ "where maHD = ?";
		try {
			stm = con.prepareStatement(sql);
			
			stm.setString(1, obj.getMaNV());
			stm.setString(2, obj.getMaKH());
			stm.setString(3, dateformat.format(obj.getNgayTaoHD()));
			stm.setString(4, obj.getMaHD());
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
		String sql = "DELETE from hoaDon where maHD = ?";
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
