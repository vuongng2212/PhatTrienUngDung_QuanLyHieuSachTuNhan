package entity;

public class SanPhamShowBill extends SanPham{
	private int discount;

	public SanPhamShowBill() {
		super();
	}
	public SanPhamShowBill(String maSP, String tenSP, String tenTG, String nhaXB, int namXB, int soLuong, double donGiaGoc,
			double donGiaMua, String tinhTrang, String danhMuc,int discount) {
		super( maSP,  tenSP,  tenTG,  nhaXB,  namXB,  soLuong,  donGiaGoc,
				 donGiaMua,  tinhTrang,danhMuc);
		this.discount = discount;
	}
	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
}
