package list;

import java.util.ArrayList;
import entity.CTPhieuNhapHang;

public class DanhSachChiTietPDH {
	private ArrayList<CTPhieuNhapHang> list;

	public DanhSachChiTietPDH() {
		list = new ArrayList<CTPhieuNhapHang>();
	}

	public String LayDanhSach() {
		String s = "";
		for (CTPhieuNhapHang pdh : list)
			s += pdh + "\n";
		return s;
	}

	public boolean them(CTPhieuNhapHang pdh) {
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getMaSP().equalsIgnoreCase(pdh.getMaSP())) {
				return false;
			}
		list.add(pdh);
		return true;
	}

	public boolean xoa(int index) {
		if (index >= 0 && index <= list.size() - 1) {
			list.remove(index);
			return true;
		} else
			return false;
	}


	public boolean update(CTPhieuNhapHang pdh) {
		for (int i = 0; i < list.size(); i++)
//			private Date doB;
//			private Boolean gioiTinh;
//			private String SDT, diaChi, email, chucVu;
			if (list.get(i).getmaNH().equalsIgnoreCase(pdh.getmaNH())) {
				list.get(i).setMaSP(pdh.getMaSP());
				list.get(i).setSoLuong(pdh.getSoLuong());
				list.get(i).setDonGiaNhap(pdh.getDonGiaNhap());
				return true;
			}
		return false;
	}

	public ArrayList<CTPhieuNhapHang> getList() {
		return list;
	}

	public int getCount() {
		return list.size();
	}
//	public void clear() {
//	    for (int i = 0; i <= list.size(); i++)
//	    	list.remove(i);
//	}
	public void clear() {
		list.clear();
	}
}
