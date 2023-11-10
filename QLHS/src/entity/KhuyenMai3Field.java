package entity;

import java.util.Date;

public class KhuyenMai3Field {
	private String maKm;
	private Date ngayTao;
	private Date ngayHetHan;
	
	
	
	
	public KhuyenMai3Field() {
		super();
	}




	public KhuyenMai3Field(String maKm, Date ngayTao, Date ngayHetHan) {
		super();
		this.maKm = maKm;
		this.ngayTao = ngayTao;
		this.ngayHetHan = ngayHetHan;
	}




	public String getMaKm() {
		return maKm;
	}




	public void setMaKm(String maKm) {
		this.maKm = maKm;
	}




	public Date getNgayTao() {
		return ngayTao;
	}




	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}




	public Date getNgayHetHan() {
		return ngayHetHan;
	}




	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	
	
}
