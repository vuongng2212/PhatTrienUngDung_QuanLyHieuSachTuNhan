package entity;

public class SubjectDH {
	private String tenSP;
	private int soLuong;
	private String giaBan;
	private String thanhTien;
	
	
	
	public SubjectDH() {
		super();
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



	public String getThanhTien() {
		return thanhTien;
	}



	public void setThanhTien(String thanhTien) {
		this.thanhTien = thanhTien;
	}



	public SubjectDH(String tenSP, int soLuong, String giaBan, String thanhTien) {
		super();
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.thanhTien = thanhTien;
	}
	
	
	
}
