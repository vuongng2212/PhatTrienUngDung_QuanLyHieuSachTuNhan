package entity;

import java.util.Date;

public class NhanVien {
	private String maNV, tenNV;
	private Date doB;
	private Boolean gioiTinh;
	private String SDT, diaChi, email, chucVu;
	
	public NhanVien() {
		super();
	}

	public NhanVien(String maNV, String tenNV, Date doB, Boolean gioiTinh, String sDT, String diaChi, String email,
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

	public Boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
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
	
	
}
