package entity;

import java.util.Date;

public class KhachDH {
	private String maDH;
	private String maKh;
	private String maNv;
	private Date ngayDat;
	private int trangThai;
	
	public KhachDH() {
		super();
	}

	public KhachDH(String maDH, String maKh, String maNv, Date ngayDat, int trangThai) {
		super();
		this.maDH = maDH;
		this.maKh = maKh;
		this.maNv = maNv;
		this.ngayDat = ngayDat;
		this.trangThai = trangThai;
	}

	public String getMaDH() {
		return maDH;
	}

	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}

	public String getMaKh() {
		return maKh;
	}

	public void setMaKh(String maKh) {
		this.maKh = maKh;
	}

	public String getMaNv() {
		return maNv;
	}

	public void setMaNv(String maNv) {
		this.maNv = maNv;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	
}
