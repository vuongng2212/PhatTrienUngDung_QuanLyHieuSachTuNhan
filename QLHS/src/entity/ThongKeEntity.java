package entity;

public class ThongKeEntity {
	private String ma;
	private String name;
	private int number;
	private double tongTien;
	
	
	
	
	public ThongKeEntity() {
		super();
	}




	public ThongKeEntity(String ma, String name, int number, double tongTien) {
		super();
		this.ma = ma;
		this.name = name;
		this.number = number;
		this.tongTien = tongTien;
	}




	public String getMa() {
		return ma;
	}




	public void setMa(String ma) {
		this.ma = ma;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getNumber() {
		return number;
	}




	public void setNumber(int number) {
		this.number = number;
	}




	public double getTongTien() {
		return tongTien;
	}




	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	
	
}
