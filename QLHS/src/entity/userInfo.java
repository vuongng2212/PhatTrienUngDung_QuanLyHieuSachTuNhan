package entity;

public class userInfo {
	public static String maNV,tenNV,sdt;
	public userInfo() {
		
	}
	public static String getMaNV() {
		return maNV;
	}

	public static void setMaNV(String maNV) {
		userInfo.maNV = maNV;
	}

	public static String getTenNV() {
		return tenNV;
	}

	public static void setTenNV(String tenNV) {
		userInfo.tenNV = tenNV;
	}
	public static String getSdt() {
		return sdt;
	}
	public static void setSdt(String sdt) {
		userInfo.sdt = sdt;
	}
	
}
