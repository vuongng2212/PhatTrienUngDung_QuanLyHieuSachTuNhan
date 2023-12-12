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
				dsKhachDH.add(new KhachDH(rs.getString("maDH"), rs.getString("maKH"), rs.getString("maNV"), dateFormat.parse(rs.getString("ngayTaoDH")), Integer.parseInt(rs.getString("trangThai")),Double.parseDouble(rs.getString("tienCoc"))));	
				
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
	public DanhSachKhachDH getAllCondition(int n) {
		String textKey = "";
		if(n==0) {
			textKey="maDH";
		}else if(n==1) {
			textKey="maKH";
		}else if(n==2) {
			textKey="maNV";
		}else if(n==3) {
			textKey="ngayTaoDH";
		}else if(n==4) {
			textKey="trangThai";
		}else if(n==5) {
			textKey="tienCoc";
		}
		DanhSachKhachDH dsKhachDH = new DanhSachKhachDH();
		ConnectDB.getInstance();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from datSach order by "+textKey + " desc";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			try {
				dsKhachDH.add(new KhachDH(rs.getString("maDH"), rs.getString("maKH"), rs.getString("maNV"), dateFormat.parse(rs.getString("ngayTaoDH")), Integer.parseInt(rs.getString("trangThai")),Double.parseDouble(rs.getString("tienCoc"))));	
				
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
	public DanhSachKhachDH getToConditionsMaKH(String maKH) {
		DanhSachKhachDH dsKhachDH = new DanhSachKhachDH();
		ConnectDB.getInstance();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from datSach where maKH = '" + maKH + "'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			try {
				dsKhachDH.add(new KhachDH(rs.getString("maDH"), rs.getString("maKH"), rs.getString("maNV"), dateFormat.parse(rs.getString("ngayTaoDH")), Integer.parseInt(rs.getString("trangThai")),Double.parseDouble(rs.getString("tienCoc"))));	
				
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
	public DanhSachKhachDH getToConditionsNgayDat(String ngayDat) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DanhSachKhachDH dsKhachDH = new DanhSachKhachDH();
		ConnectDB.getInstance();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from datSach where ngayTaoDH = '" + ngayDat + "'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			try {
				dsKhachDH.add(new KhachDH(rs.getString("maDH"), rs.getString("maKH"), rs.getString("maNV"), dateFormat.parse(rs.getString("ngayTaoDH")), Integer.parseInt(rs.getString("trangThai")),Double.parseDouble(rs.getString("tienCoc"))));	
				
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
	
	
	public DanhSachKhachDH getToConditionsNgayDatvaMaKH(String maKH,String ngayDat) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DanhSachKhachDH dsKhachDH = new DanhSachKhachDH();
		ConnectDB.getInstance();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from datSach where ngayTaoDH = '" + ngayDat + "' and maKH = '"+ maKH + "'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			try {
				dsKhachDH.add(new KhachDH(rs.getString("maDH"), rs.getString("maKH"), rs.getString("maNV"), dateFormat.parse(rs.getString("ngayTaoDH")), Integer.parseInt(rs.getString("trangThai")),Double.parseDouble(rs.getString("tienCoc"))));	
				
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
	public String sinhMaDH() {
		String ma = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select top 1 maDH from datSach where maDH like 'DH%' order by maDH desc";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			ma = rs.getString("maDH");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ma;
	}
	public String maKHTheoMa(String str) {
		String ma = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select maKH from datSach where maDH = '" + str + "'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			ma = rs.getString("maKH");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ma;
	}
	public void deleteChiTietdonDH(String maDH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
//		String sql = "update datSach set trangThai = -1 where  DATEDIFF(day,GETDATE(),ngayTaoDH) <-15 and tienCoc = 0 and trangThai = 0";
		String sql = "delete from chiTietDatSach where maDH = '"+maDH+"'";
		try {
			stm = con.prepareStatement(sql);
			
//			stm.setString(1, sdt);
//			stm.setString(2, manv);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stm);
		}
	}
	public void deletedonDH(String maDH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "delete from datSach where maDH = '"+maDH+"'";
		try {
			stm = con.prepareStatement(sql);
			
//			stm.setString(1, sdt);
//			stm.setString(2, manv);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stm);
		}
	}
	public void updateDonDatHangKhongCoc() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "update datSach set trangThai = -1 where  DATEDIFF(day,GETDATE(),ngayTaoDH) <-15 and tienCoc = 0 and trangThai = 0";
		try {
			stm = con.prepareStatement(sql);
			
//			stm.setString(1, sdt);
//			stm.setString(2, manv);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stm);
		}	
	}
	public void updateDonDatHangCoCoc() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "update datSach set trangThai = -1 where  DATEDIFF(day,GETDATE(),ngayTaoDH) <-30 and tienCoc != 0 and trangThai = 0";
		try {
			stm = con.prepareStatement(sql);
			
//			stm.setString(1, sdt);
//			stm.setString(2, manv);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stm);
		}	
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
	public double tienCocTheoMa(String str) {
		double coc = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select tienCoc from datSach where maDH = '" + str + "'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			coc = Double.parseDouble(rs.getString("tienCoc"));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return coc;
	}
	
	public int soLanHuy(String maKH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int count = 0;
		
		try {
			String sql = "select COUNT(*) as soLan from datSach where trangThai = -1 and maKH = '" + maKH +"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
//			coc = Double.parseDouble(rs.getString("tienCoc"));
			count = Integer.parseInt(rs.getString("soLan"));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public int soDonChuaXuLy(String maKH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int count = 0;
		
		try {
			String sql = "select COUNT(*) as soLan from datSach where trangThai = 0 and maKH = '" + maKH +"'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
//			coc = Double.parseDouble(rs.getString("tienCoc"));
			count = Integer.parseInt(rs.getString("soLan"));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public boolean add(KhachDH obj) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString  = dateFormat.format(obj.getNgayDat());
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "insert into datSach(maDH,maKH,maNV,ngayTaoDH,trangThai,tienCoc) values (?,?,?,?,0,?)";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, obj.getMaDH());
			stm.setString(2, obj.getMaKh());
			stm.setString(3, obj.getMaNv());
			stm.setString(4, dateString);
			stm.setFloat(5,(float) obj.getTienCoc());
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
	public void updateDaXacNhan(String str) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "update datSach set trangThai = 1 where maDH = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1,str);
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
	
	public void updateHuy(String str) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		String sql = "update datSach set trangThai = -1 where maDH = ?";
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1,str);
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
