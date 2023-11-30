package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.ChiTietKhuyenMai;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.KhuyenMai3Field;
import interfaces.daoInterface;
import list.DanhSachKhachHang;
import list.DanhSachKhuyenMai;

public class DAO_KhuyenMai implements daoInterface<KhuyenMai, DanhSachKhuyenMai>{
	
	
	public ArrayList<KhuyenMai3Field> getForSearch() {
		ArrayList<KhuyenMai3Field>listKm = new ArrayList<KhuyenMai3Field>();
		ConnectDB.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select distinct maKM,ngayTao,ngayHetHan from khuyenMai";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			listKm.add(new KhuyenMai3Field(rs.getString("maKM"),rs.getDate("ngayTao") ,rs.getDate("ngayHetHan")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listKm;
	}
	public double tongTienCuaKH(String str) {
		double total = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select thanhTien from hoaDon where maKH = '" + str + "'";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			total+= Double.parseDouble(rs.getString("thanhTien"));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return total;
	}
	public String sinhMaKM() {
		String ma = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select top 1 maKM from khuyenMai order by maKM desc";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while(rs.next()) {
			ma = rs.getString("maKM");
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ma;
	}
	
	
	public ArrayList<KhuyenMai3Field>getHetHan(){
		ArrayList<KhuyenMai3Field>listKm = new ArrayList<KhuyenMai3Field>();
		ConnectDB.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select distinct maKM,ngayTao,ngayHetHan from khuyenMai where ngayHetHan<GETDATE()";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			listKm.add(new KhuyenMai3Field(rs.getString("maKM"),rs.getDate("ngayTao") ,rs.getDate("ngayHetHan")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			
		return listKm;
	}
	
	public ArrayList<KhuyenMai3Field>getApDung(){
		ArrayList<KhuyenMai3Field>listKm = new ArrayList<KhuyenMai3Field>();
		ConnectDB.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select distinct maKM,ngayTao,ngayHetHan from khuyenMai  where ngayTao<GETDATE() and ngayHetHan>GETDATE()";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			listKm.add(new KhuyenMai3Field(rs.getString("maKM"),rs.getDate("ngayTao") ,rs.getDate("ngayHetHan")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			
		return listKm;
		
	}
//	public boolean xoaKM(String str) {
//		
//	}
	public int discountSPDangKM(String str) {
		int discount = 0;
		DAO_KhuyenMai daoKm = new DAO_KhuyenMai();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
//		PreparedStatement stm = null;
		
		try {
			String sql = "select discount from khuyenMai  where ngayTao<GETDATE() and ngayHetHan>GETDATE() and maSP= " +"'" + str + "'";
//			stm = con.prepareStatement(sql);
//			stm.setString(1, str);
//			ResultSet rs = stm.executeQuery(sql);
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
		while(rs.next()) {
			discount = Integer.parseInt(rs.getString("discount"));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return discount;
	}
	
	
	public boolean ktraHienDangKhuyenMai(String maSP) {
		DAO_KhuyenMai daoKm = new DAO_KhuyenMai();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select distinct maSP from khuyenMai  where ngayTao<GETDATE() and ngayHetHan>GETDATE()";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			if(rs.getString("maSP").equalsIgnoreCase(maSP))
					return true;
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
//	public ArrayList<sanpham>
	
	public ArrayList<KhuyenMai3Field>getSapDienRa(){
		ArrayList<KhuyenMai3Field>listKm = new ArrayList<KhuyenMai3Field>();
		ConnectDB.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Connection con = ConnectDB.getConnection();
		
		try {
			String sql = "select distinct maKM,ngayTao,ngayHetHan from khuyenMai where ngayTao>GETDATE()";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			listKm.add(new KhuyenMai3Field(rs.getString("maKM"),rs.getDate("ngayTao") ,rs.getDate("ngayHetHan")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			
		return listKm;
		
	}
	
	public ArrayList<KhuyenMai3Field>getSearchConditions(String dateBd,String dateKt){
		ArrayList<KhuyenMai3Field>listKm = new ArrayList<KhuyenMai3Field>();
		ConnectDB.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			String sql = "select distinct maKM,ngayTao,ngayHetHan from khuyenMai where ngayTao >= ? and ngayHetHan <= ?";
			
			stm = con.prepareStatement(sql);
			stm.setString(1, dateBd);
			stm.setString(2, dateKt);
			
			
//			Statement statement =con.createStatement();
			ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			listKm.add(new KhuyenMai3Field(rs.getString("maKM"),rs.getDate("ngayTao") ,rs.getDate("ngayHetHan")));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listKm;
	}
	public boolean ktraHopLiSpTaoKhuyenMai(String str,String dateConvert) {
		int count =1;
//		ArrayList<KhuyenMai3Field>listKm = new ArrayList<KhuyenMai3Field>();
		ConnectDB.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			String sql = "select count(*) as count  from khuyenMai where ngayHetHan > ? and maSP = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, dateConvert);
			stm.setString(2, str);
			
			
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				System.out.println("Bat Dau");
				count = rs.getInt("count");
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		if(count==0) {
			return true;
		}
		
		return false;
	}
	
	public ArrayList<ChiTietKhuyenMai>getChiTietConditions(String str){
		ArrayList<ChiTietKhuyenMai>listKm = new ArrayList<ChiTietKhuyenMai>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			String sql = "select  khuyenMai.maKM,sanPham.maSP,sanPham.tenSP,sanPham.tenTacGia,khuyenMai.discount  from khuyenMai right join sanPham on khuyenMai.maSP = sanPham.maSP where discount is not null and khuyenMai.maKM = ?";
			
			stm = con.prepareStatement(sql);
			stm.setString(1, str);
			
			
//			Statement statement =con.createStatement();
			ResultSet rs = stm.executeQuery();
		while(rs.next()) {
//			listKm.add(new KhuyenMai3Field(rs.getString("maKM"),rs.getDate("ngayTao") ,rs.getDate("ngayHetHan")));
			listKm.add(new ChiTietKhuyenMai(rs.getString("maSP"), rs.getString("tenSP"),rs.getString("tenTacGia"), Integer.parseInt(rs.getString("discount"))));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listKm;
	}

	public ArrayList<ChiTietKhuyenMai>getChiTiet(){
		ArrayList<ChiTietKhuyenMai>listCT = new ArrayList<ChiTietKhuyenMai>();
		ConnectDB.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select sanPham.maSP,sanPham.tenSP,sanPham.tenTacGia,khuyenMai.discount  from khuyenMai right join sanPham on khuyenMai.maSP = sanPham.maSP where discount is not null";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			listCT.add(new ChiTietKhuyenMai(rs.getString("maSP"), rs.getString("tenSP"), rs.getString("tenTacGia"), Integer.parseInt(rs.getString("discount"))));
		}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listCT;
	}
	
//	public ArrayList<E>
	
	@Override
	public DanhSachKhuyenMai getAll() {
		DanhSachKhuyenMai dsKM = new DanhSachKhuyenMai();
		ConnectDB.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from khuyenMai";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			dsKM.add(new KhuyenMai(rs.getString("maKM"), rs.getString("maSP"), Integer.parseInt(rs.getString("discount")),rs.getDate("ngayTao") ,rs.getDate("ngayHetHan")));
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
