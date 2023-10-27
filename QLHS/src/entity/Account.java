package entity;

public class Account {
	private String maNV, pwd;

	public Account(String maNV, String pwd) {
		super();
		this.maNV = maNV;
		this.pwd = pwd;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
