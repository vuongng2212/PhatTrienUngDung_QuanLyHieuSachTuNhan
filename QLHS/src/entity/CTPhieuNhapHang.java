package entity;

public class CTPhieuNhapHang {
	private String maNH, maSP, tenSP;
	private Integer soLuong;
	private Double donGiaNhap;
	
	public CTPhieuNhapHang() {
		super();
	}

	public CTPhieuNhapHang(String maNH, String maSP, Integer soLuong) {
		super();
		this.maNH = maNH;
		this.maSP = maSP;
		this.soLuong = soLuong;
	}
	
	public CTPhieuNhapHang(String maSP, String tenSP, Integer soLuong, Double donGiaNhap) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGiaNhap = donGiaNhap;
	}

	public CTPhieuNhapHang(String maNH, String maSP, String tenSP, Integer soLuong) {
		super();
		this.maNH = maNH;
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
	}

	public CTPhieuNhapHang(String maNH, String maSP, String tenSP, Integer soLuong, Double donGiaNhap) {
		super();
		this.maNH = maNH;
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGiaNhap = donGiaNhap;
	}

	public String getmaNH() {
		return maNH;
	}

	public void setmaNH(String maNH) {
		this.maNH = maNH;
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
		return "ChiTietPhieuDH [maNH=" + maNH + ", maSP=" + maSP + ", tenSP=" + tenSP + ", soLuong=" + soLuong
				+ ", donGiaNhap=" + donGiaNhap + "]";
	}
	
	
	
	
	
}
