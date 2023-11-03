package entity;

import java.util.Calendar;
import java.util.Date;

public class KhuyenMai {
	private String maKM;
	private String maSP;
	private int discount;
	private Date ngayTao;
	private Date ngayHetHan;
	
	


	public KhuyenMai() {
		super();
	}



	public KhuyenMai(String maKM, String maSP, int discount, Date ngayTao, Date ngayHetHan) {
		super();
		this.maKM = maKM;
		this.maSP = maSP;
		this.discount = discount;
		this.ngayTao = ngayTao;
		this.ngayHetHan = ngayHetHan;
	}



	public String getMaSP() {
		return maSP;
	}



	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}



	public int getDiscount() {
		return discount;
	}



	public void setDiscount(int discount) {
		this.discount = discount;
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



	public String getMaKM() {
		return maKM;
	}



	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}
	
	
	
}
