package entity;

import java.sql.Date;
import java.util.Objects;

public class PhieuDatHang {
	private String maDH, maNV,tenNV;
	private Date ngayDH;
	private Double chietKhau;
	public PhieuDatHang() {
		super();
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public PhieuDatHang(String maDH, String maNV, String tenNV, Date ngayDH, Double chietKhau) {
		super();
		this.maDH = maDH;
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngayDH = ngayDH;
		this.chietKhau = chietKhau;
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
	@Override
	public int hashCode() {
		return Objects.hash(chietKhau, maDH, maNV, ngayDH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuDatHang other = (PhieuDatHang) obj;
		return Objects.equals(chietKhau, other.chietKhau) && Objects.equals(maDH, other.maDH)
				&& Objects.equals(maNV, other.maNV) && Objects.equals(ngayDH, other.ngayDH);
	}
	@Override
	public String toString() {
		return "PhieuDatHang [maDH=" + maDH + ", maNV=" + maNV + ", ngayDH=" + ngayDH + ", chietKhau=" + chietKhau
				+ "]";
	}
	
}
