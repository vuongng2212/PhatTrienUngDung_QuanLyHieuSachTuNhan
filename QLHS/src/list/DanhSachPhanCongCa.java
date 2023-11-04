package list;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import entity.Ca;
import entity.NhanVien;
import entity.PhanCongCa;

public class DanhSachPhanCongCa {
	private Date date;
	private ArrayList<PhanCongCa> list;

	public DanhSachPhanCongCa() {
		list = new ArrayList<PhanCongCa>();
	}

	public String GetList() {
		String s = "";
		for (PhanCongCa ca : list)
			s += ca + "\n";
		return s;
	}

	public boolean add(PhanCongCa ca) {
		date = new Date(Calendar.getInstance().getTime().getTime());
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getMaNV().equalsIgnoreCase(ca.getMaNV()) && !list.get(i).getNgayLV().before(date) && !list.get(i).getNgayLV().after(date)) {
				return false;
			}
		list.add(ca);
		return true;
	}

	public boolean xoa(int index) {
		if (index >= 0 && index <= list.size() - 1) {
			list.remove(index);
			return true;
		} else
			return false;
	}

	public boolean update(PhanCongCa ca) {
		date = new Date(Calendar.getInstance().getTime().getTime());
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getMaNV().equalsIgnoreCase(ca.getMaNV()) && !list.get(i).getNgayLV().before(date) && !list.get(i).getNgayLV().after(date)) {
				list.get(i).setMaCa(ca.getMaCa());
				return true;
			}
		return false;
	}

	public ArrayList<PhanCongCa> getList() {
		return list;
	}

	public int getCountNV() {
		return list.size();
	}
	public void clear() {
	    for (int i = 0; i < list.size(); i++)
	    	list.remove(i);
	}
}
