package entity;

import java.sql.Date;
import java.util.Objects;

public class NhanVien {
	private String maNV, tenNV;
	private Date doB;
	private Integer gioiTinh;
	private String SDT, diaChi, email, chucVu;
	public NhanVien(String maNV, String tenNV, Date doB, Integer gioiTinh, String sDT, String diaChi, String email,
			String chucVu) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.doB = doB;
		this.gioiTinh = gioiTinh;
		SDT = sDT;
		this.diaChi = diaChi;
		this.email = email;
		this.chucVu = chucVu;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", doB=" + doB + ", gioiTinh=" + gioiTinh + ", SDT="
				+ SDT + ", diaChi=" + diaChi + ", email=" + email + ", chucVu=" + chucVu + "]";
	}
	public NhanVien() {
		super();
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public Date getDoB() {
		return doB;
	}
	public void setDoB(Date doB) {
		this.doB = doB;
	}
	public Integer getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(Integer gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(SDT, chucVu, diaChi, doB, email, gioiTinh, maNV, tenNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(SDT, other.SDT) && Objects.equals(chucVu, other.chucVu)
				&& Objects.equals(diaChi, other.diaChi) && Objects.equals(doB, other.doB)
				&& Objects.equals(email, other.email) && Objects.equals(gioiTinh, other.gioiTinh)
				&& Objects.equals(maNV, other.maNV) && Objects.equals(tenNV, other.tenNV);
	}
	
	
	
	
	
}
