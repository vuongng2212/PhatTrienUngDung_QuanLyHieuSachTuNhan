package entity;

public class SubjectKhachHangThanThiet {
	private String maKH;
	private String tenKH;
	private int lanMua;
	private String tienMua;
	
	
	
	public SubjectKhachHangThanThiet(String maKH, String tenKH, int lanMua, String tienMua) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.lanMua = lanMua;
		this.tienMua = tienMua;
	}



	public SubjectKhachHangThanThiet() {
		super();
	}



	public String getMaKH() {
		return maKH;
	}



	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}



	public String getTenKH() {
		return tenKH;
	}



	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}



	public int getLanMua() {
		return lanMua;
	}



	public void setLanMua(int lanMua) {
		this.lanMua = lanMua;
	}



	public String getTienMua() {
		return tienMua;
	}



	public void setTienMua(String tienMua) {
		this.tienMua = tienMua;
	}
	
	
	
}
