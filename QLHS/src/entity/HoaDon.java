package entity;

import java.util.Date;

public class HoaDon {
	private String maHD;
	private String maNV;
	private String maKH;
	private Date ngayTaoHD;
	
	
	
	
	public HoaDon() {
		super();
	}




	public HoaDon(String maHD, String maNV, String maKH, Date ngayTaoHD) {
		super();
		this.maHD = maHD;
		this.maNV = maNV;
		this.maKH = maKH;
		this.ngayTaoHD = ngayTaoHD;
	}




	public String getMaHD() {
		return maHD;
	}




	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}




	public String getMaNV() {
		return maNV;
	}




	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}




	public String getMaKH() {
		return maKH;
	}




	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}



	
	public Date getNgayTaoHD() {
		return ngayTaoHD;
	}




	public void setNgayTaoHD(Date ngayTaoHD) {
		this.ngayTaoHD = ngayTaoHD;
	}
	
	
	
}
