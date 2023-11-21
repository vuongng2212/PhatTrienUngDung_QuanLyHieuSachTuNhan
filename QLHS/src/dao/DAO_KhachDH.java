package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachDH;
import interfaces.daoInterface;
import list.DanhSachKhachDH;

public class DAO_KhachDH implements daoInterface<KhachDH, DanhSachKhachDH>{

	@Override
	public DanhSachKhachDH getAll() {
		DanhSachKhachDH dsKhachDH = new DanhSachKhachDH();
		ConnectDB.getInstance();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from datSach";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			try {
				dsKhachDH.add(new KhachDH(rs.getString("maDH"), rs.getString("maKH"), rs.getString("maNV"), dateFormat.parse(rs.getString("ngayTaoDH")), Integer.parseInt(rs.getString("trangThai"))));		
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKhachDH;
	}

	public String tenKHTheoMa(String str) {
		String name = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select tenKH from khachHang where maKH = '" + str + "'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			name = rs.getString("tenKH");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}	
	
	public String tenMaKHTheoDH(String str) {
		String name = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select khachHang.maKH from datSach join khachHang on datSach.maKH = khachHang.maKH where maDH = '" + str + "'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			name = rs.getString("maKH");
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
			String sql = "select tenNV from nhanVien where maNV = '" + str + "'";
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
	public String tenKhachTheoMa(String str) {
		String name = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select khachHang.tenKH from datSach join khachHang on datSach.maKH = khachHang.maKH where maDH = '"+ str+ "'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			name = rs.getString("tenKH");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	
	public String LoaiKhachTheoMa(String str) {
		String name = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select khachHang.loaiKH from datSach join khachHang on datSach.maKH = khachHang.maKH where maDH = '"+ str+ "'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			name = rs.getString("loaiKH");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	
	@Override
	public boolean add(KhachDH obj) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString  = dateFormat.format(obj.getNgayDat());
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "insert into datSach(maDH,maKH,maNV,ngayTaoDH,trangThai) values (?,?,?,?,0)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, obj.getMaDH());
			stm.setString(2, obj.getMaKh());
			stm.setString(3, obj.getMaNv());
			stm.setString(4, dateString);
//			stm.setFloat(5,(float) obj.getThanhTien());
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
	public boolean update(KhachDH obj) {
		SimpleDateFormat dateformat  = new SimpleDateFormat("yyyy-MM-dd");
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "update datSach set maKH = ?, maNV = ?,ngayTaoDH = ? where maDH = ?";
		try {
			stm = con.prepareStatement(sql);
			
			stm.setString(1, obj.getMaKh());
			stm.setString(2, obj.getMaNv());
			stm.setString(3, dateformat.format(obj.getNgayDat()));
			stm.setString(4, obj.getMaDH());
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
