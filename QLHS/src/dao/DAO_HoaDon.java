package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			try {
				dsHoaDon.add(new HoaDon(rs.getString("maHD"),rs.getString("maNV"),rs.getString("maKH"),dateFormat.parse(rs.getString("ngayTaoHD")),Double.parseDouble(rs.getString("thanhTien"))));
		
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return dsHoaDon;	
	}

	@Override
	public boolean add(HoaDon obj) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString  = dateFormat.format(obj.getNgayTaoHD());
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "INSERT INTO hoaDon (maHD, maNV, maKH, ngayTaoHD,thanhTien) "
				+ "values(?,?,?,?,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, obj.getMaHD());
			stm.setString(2, obj.getMaNV());
			stm.setString(3, obj.getMaKH());
			stm.setString(4, dateString);
			stm.setFloat(5,(float) obj.getThanhTien());
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
	public String sinhMaHD() {
		String ma = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select top 1 maHD from hoaDon where maHD like 'HD%' order by maHD desc";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			ma = rs.getString("maHD");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ma;
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

	public ArrayList<HoaDon>SearchHDTheoNgay(String str){
		ArrayList<HoaDon>listHD = new ArrayList<HoaDon>();
		SimpleDateFormat dateformat  = new SimpleDateFormat("yyyy-MM-dd");
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();


		try {
			String sql = "select * from hoaDon where ngayTaoHD = '" + str+ "'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			try {
				listHD.add(new HoaDon(rs.getString("maHD"),rs.getString("maNV"),rs.getString("maKH"),dateFormat.parse(rs.getString("ngayTaoHD")),Double.parseDouble(rs.getString("thanhTien"))));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listHD;
	
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
