package entity;

public class ChiTietKhachDH {
	private String maDH;
	private String maSP;
	private int soLuong;
	private double donGia;
//	private int discount;
	
	
	public ChiTietKhachDH() {
		super();
	}


	public ChiTietKhachDH(String maDH, String maSP, int soLuong, double donGia) {
		super();
		this.maDH = maDH;
		this.maSP = maSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
//		this.discount = discount;
	}


	public String getMaDH() {
		return maDH;
	}


	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}


	public String getMaSP() {
		return maSP;
	}


	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}


	public int getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	public double getDonGia() {
		return donGia;
	}


	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}


//	public int getDiscount() {
//		return discount;
//	}
//
//
//	public void setDiscount(int discount) {
//		this.discount = discount;
//	}
	
	
}
