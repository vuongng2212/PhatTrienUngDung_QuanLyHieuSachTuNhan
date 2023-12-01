package entity;

public class SubjectSachBanChay {
	private String maSP;
	private String tenSP;
	private int soLuong;
	private String tienBan;
	
	
	
	
	public SubjectSachBanChay() {
		super();
	}




	public SubjectSachBanChay(String maSP, String tenSP, int soLuong, String tienBan) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.tienBan = tienBan;
	}




	public String getMaSP() {
		return maSP;
	}




	public void setMaSP(String maSP) {
		this.maSP = maSP;
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




	public String getTienBan() {
		return tienBan;
	}




	public void setTienBan(String tienBan) {
		this.tienBan = tienBan;
	}
	
	
	
}
