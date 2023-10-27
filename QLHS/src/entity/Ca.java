package entity;

public class Ca {
	private String maCa;
	private String gioBatDau, gioKetThuc;
	
	public Ca() {
		super();
	}

	public Ca(String maCa, String gioBatDau, String gioKetThuc) {
		super();
		this.maCa = maCa;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
	}

	public String getMaCa() {
		return maCa;
	}

	public void setMaCa(String maCa) {
		this.maCa = maCa;
	}

	public String getGioBatDau() {
		return gioBatDau;
	}

	public void setGioBatDau(String gioBatDau) {
		this.gioBatDau = gioBatDau;
	}

	public String getGioKetThuc() {
		return gioKetThuc;
	}

	public void setGioKetThuc(String gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}
	
}
