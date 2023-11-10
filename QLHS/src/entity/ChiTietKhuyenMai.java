package entity;

public class ChiTietKhuyenMai {
	private String maSP;
	private String tenSP;
	private String tenTG;
	private int discount;
	
	
	
	
	public ChiTietKhuyenMai(String maSP, String tenSP, String tenTG, int discount) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.tenTG = tenTG;
		this.discount = discount;
	}
	
	
	
	public ChiTietKhuyenMai() {
		super();
	}
	public String getmaSP() {
		return maSP;
	}
	public void setmaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getTenTG() {
		return tenTG;
	}
	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
}
