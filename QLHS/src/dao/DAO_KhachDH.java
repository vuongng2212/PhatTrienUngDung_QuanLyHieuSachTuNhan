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
			stm.setString(2, obj.getMaNv());
			stm.setString(3, obj.getMaKh());
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
