package entity;

public class ChiTietPhieuDH {
	private String maDH, maSP, tenSP;
	private Integer soLuong;
	private Double donGiaNhap;
	
	public ChiTietPhieuDH() {
		super();
	}

	public ChiTietPhieuDH(String maDH, String maSP, Integer soLuong) {
		super();
		this.maDH = maDH;
		this.maSP = maSP;
		this.soLuong = soLuong;
	}
	
	public ChiTietPhieuDH(String maSP, String tenSP, Integer soLuong, Double donGiaNhap) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGiaNhap = donGiaNhap;
	}

	public ChiTietPhieuDH(String maDH, String maSP, String tenSP, Integer soLuong) {
		super();
		this.maDH = maDH;
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
	}

	public ChiTietPhieuDH(String maDH, String maSP, String tenSP, Integer soLuong, Double donGiaNhap) {
		super();
		this.maDH = maDH;
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGiaNhap = donGiaNhap;
	}

	public String getMaDH() {
		return maDH;
	}

	public void setMaDH(String maDH) {
		this.maDH = maDH;
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

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Double getDonGiaNhap() {
		return donGiaNhap;
	}

	public void setDonGiaNhap(Double donGiaNhap) {
		this.donGiaNhap = donGiaNhap;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuDH [maDH=" + maDH + ", maSP=" + maSP + ", tenSP=" + tenSP + ", soLuong=" + soLuong
				+ ", donGiaNhap=" + donGiaNhap + "]";
	}
	
	
	
	
	
}
