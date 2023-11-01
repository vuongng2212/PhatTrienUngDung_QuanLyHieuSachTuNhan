package entity;

import java.util.Date;

public class PhieuDatHang {
	private String maDH, maNV;
	private Date ngayDH;
	private Double chietKhau;
	public PhieuDatHang() {
		super();
	}
	public PhieuDatHang(String maDH, String maNV, Date ngayDH, Double chietKhau) {
		super();
		this.maDH = maDH;
		this.maNV = maNV;
		this.ngayDH = ngayDH;
		this.chietKhau = chietKhau;
	}
	public String getMaDH() {
		return maDH;
	}
	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public Date getNgayDH() {
		return ngayDH;
	}
	public void setNgayDH(Date ngayDH) {
		this.ngayDH = ngayDH;
	}
	public Double getChietKhau() {
		return chietKhau;
	}
	public void setChietKhau(Double chietKhau) {
		this.chietKhau = chietKhau;
	}
	
}
