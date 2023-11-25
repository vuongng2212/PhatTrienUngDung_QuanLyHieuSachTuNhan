package entity;

import java.sql.Date;
import java.util.Objects;

public class PhieuNhapHang {
	private String maNH, maNV,tenNV;
	private Date ngayDH;
	private Double chietKhau;
	private int trangThai;
	private double thanhTien;
	
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	public PhieuNhapHang(String maNH, Date ngayDH, Double chietKhau, double thanhTien) {
		super();
		this.maNH = maNH;
		this.ngayDH = ngayDH;
		this.chietKhau = chietKhau;
		this.thanhTien = thanhTien;
	}
	public PhieuNhapHang(String maNH, String maNV, String tenNV, Date ngayDH, Double chietKhau, int trangThai) {
		super();
		this.maNH = maNH;
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngayDH = ngayDH;
		this.chietKhau = chietKhau;
		this.trangThai = trangThai;
	}
	public PhieuNhapHang() {
		super();
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public PhieuNhapHang(String maNH, String maNV, String tenNV, Date ngayDH, Double chietKhau) {
		super();
		this.maNH = maNH;
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngayDH = ngayDH;
		this.chietKhau = chietKhau;
	}
	public PhieuNhapHang(String maNH, String maNV, Date ngayDH, Double chietKhau) {
		super();
		this.maNH = maNH;
		this.maNV = maNV;
		this.ngayDH = ngayDH;
		this.chietKhau = chietKhau;
	}
	public String getmaNH() {
		return maNH;
	}
	public void setmaNH(String maNH) {
		this.maNH = maNH;
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

	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(chietKhau, maNH, maNV, ngayDH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuNhapHang other = (PhieuNhapHang) obj;
		return Objects.equals(chietKhau, other.chietKhau) && Objects.equals(maNH, other.maNH)
				&& Objects.equals(maNV, other.maNV) && Objects.equals(ngayDH, other.ngayDH);
	}
	@Override
	public String toString() {
		return "PhieuDatHang [maNH=" + maNH + ", maNV=" + maNV + ", ngayDH=" + ngayDH + ", chietKhau=" + chietKhau
				+ "]";
	}
	
}
