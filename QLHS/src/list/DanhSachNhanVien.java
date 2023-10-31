package list;

import java.util.ArrayList;
import java.util.Date;

import entity.NhanVien;

public class DanhSachNhanVien {
	private ArrayList<NhanVien> list;

	public DanhSachNhanVien() {
		list = new ArrayList<NhanVien>();
	}

	public String LayDanhSachNhanVien() {
		String s = "";
		for (NhanVien nv : list)
			s += nv + "\n";
		return s;
	}

	public boolean themNhanVien(NhanVien nv) {
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getMaNV().equalsIgnoreCase(nv.getMaNV())) {
				return false;
			}
		list.add(nv);
		return true;
	}

	public boolean xoaNV(int index) {
		if (index >= 0 && index <= list.size() - 1) {
			list.remove(index);
			return true;
		} else
			return false;
	}

	public int timNhanVienTheoMa(String maNhanVien) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getMaNV().equalsIgnoreCase(maNhanVien))
				return i;
		}
		return -1;
	}

	public int timNhanVienTheoTen(String tenNhanVien) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTenNV().equalsIgnoreCase(tenNhanVien))
				return i;
		}
		return -1;
	}

	public boolean capNhatThongTinNhanVien(NhanVien nv) {
		for (int i = 0; i < list.size(); i++)
//			private Date doB;
//			private Boolean gioiTinh;
//			private String SDT, diaChi, email, chucVu;
			if (list.get(i).getMaNV().equalsIgnoreCase(nv.getMaNV())) {
				list.get(i).setTenNV(nv.getTenNV());
				list.get(i).setGioiTinh(nv.getGioiTinh());
				list.get(i).setSDT(nv.getSDT());
				list.get(i).setDiaChi(nv.getDiaChi());
				list.get(i).setEmail(nv.getEmail());
				list.get(i).setChucVu(nv.getChucVu());
				return true;
			}
		return false;
	}

	public ArrayList<NhanVien> getList() {
		return list;
	}

	public int getCountNV() {
		return list.size();
	}
}
