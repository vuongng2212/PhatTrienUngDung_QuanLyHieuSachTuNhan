package entity;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private String sdt;
	private String diaChi;
	private String loaiKH;
	
	
	
	public KhachHang() {
		super();
	}






	public KhachHang(String maKH, String tenKH, String sdt, String diaChi, String loaiKH) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.loaiKH = loaiKH;
	}






	public String getDiaChi() {
		return diaChi;
	}






	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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



	public String getSdt() {
		return sdt;
	}



	public void setSdt(String sdt) {
		this.sdt = sdt;
	}



	public String getLoaiKH() {
		return loaiKH;
	}



	public void setLoaiKH(String loaiKH) {
		this.loaiKH = loaiKH;
	}
	
	
	
	
}
