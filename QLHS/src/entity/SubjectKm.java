package entity;

public class SubjectKm {
	private String maSP;
    private String tenSP;
    private int discount;
    
    
    
    
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




	public int getDiscount() {
		return discount;
	}




	public void setDiscount(int discount) {
		this.discount = discount;
	}




	public SubjectKm(String maSP, String tenSP, int discount) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.discount = discount;
	}
    
    
    
}
