package list;

import java.util.ArrayList;

import entity.CTPhieuNhapHang;
import entity.PhieuNhapHang;

public class DanhSachPhieuNH {
	private ArrayList<PhieuNhapHang> list;

	public DanhSachPhieuNH() {
		list = new ArrayList<PhieuNhapHang>();
	}

	public String getDanhSach() {
		String s = "";
		for (PhieuNhapHang pdh : list)
			s += pdh + "\n";
		return s;
	}

	public boolean them(PhieuNhapHang pdh) {
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getmaNH().equalsIgnoreCase(pdh.getmaNH())) {
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


	public boolean update(PhieuNhapHang pdh) {
		for (int i = 0; i < list.size(); i++)
//			private Date doB;
//			private Boolean gioiTinh;
//			private String SDT, diaChi, email, chucVu;
			if (list.get(i).getmaNH().equalsIgnoreCase(pdh.getmaNH())) {
				list.get(i).setMaNV(pdh.getMaNV());
				list.get(i).setNgayDH(pdh.getNgayDH());
				list.get(i).setChietKhau(pdh.getChietKhau());
				return true;
			}
		return false;
	}

	public ArrayList<PhieuNhapHang> getList() {
		return list;
	}

	public int getCount() {
		return list.size();
	}
	public void clear() {
		list.clear();
	}
}
