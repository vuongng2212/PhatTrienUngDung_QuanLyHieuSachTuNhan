package entity;

public class ChiTietPhieuDH {
	private String maDH, maSP;
	private Integer soLuong, donGiaNhap;
	
	public ChiTietPhieuDH() {
		super();
	}

	public ChiTietPhieuDH(String maDH, String maSP, Integer soLuong) {
		super();
		this.maDH = maDH;
		this.maSP = maSP;
		this.soLuong = soLuong;
	}

	public ChiTietPhieuDH(String maDH, String maSP, Integer soLuong, Integer donGiaNhap) {
		super();
		this.maDH = maDH;
		this.maSP = maSP;
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

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Integer getDonGiaNhap() {
		return donGiaNhap;
	}

	public void setDonGiaNhap(Integer donGiaNhap) {
		this.donGiaNhap = donGiaNhap;
	}
	
	
	
}
