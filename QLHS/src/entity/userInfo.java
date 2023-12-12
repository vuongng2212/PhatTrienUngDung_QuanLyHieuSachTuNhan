package entity;

public class userInfo {
	public static String maNV,tenNV,sdt,ngaySinh,email;
	public static int gt;
	public userInfo() {
		
	}
	
	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		userInfo.email = email;
	}

	public static int getGt() {
		return gt;
	}

	public static void setGt(int gt) {
		userInfo.gt = gt;
	}

	public static String getNgaySinh() {
		return ngaySinh;
	}

	public static void setNgaySinh(String ngaySinh) {
		userInfo.ngaySinh = ngaySinh;
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
