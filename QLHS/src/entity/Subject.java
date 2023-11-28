package entity;

public class Subject {

	private String tenSP;
	private int soLuong;
	private String giaBan;
	private int discount;
	private String thanhTien;
	
	
	
	public Subject() {
		super();
	}



	public Subject(String tenSP, int soLuong, String giaBan, int discount, String thanhTien) {
		super();
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.discount = discount;
		this.thanhTien = thanhTien;
	}



	public String getTenSP() {
		return tenSP;
	}



	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}



	public int getSoLuong() {
		return soLuong;
	}



	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}



	public String getGiaBan() {
		return giaBan;
	}



	public void setGiaBan(String giaBan) {
		this.giaBan = giaBan;
	}



	public int getDiscount() {
		return discount;
	}



	public void setDiscount(int discount) {
		this.discount = discount;
	}



	public String getThanhTien() {
		return thanhTien;
	}



	public void setThanhTien(String thanhTien) {
		this.thanhTien = thanhTien;
	}
	
	
}
