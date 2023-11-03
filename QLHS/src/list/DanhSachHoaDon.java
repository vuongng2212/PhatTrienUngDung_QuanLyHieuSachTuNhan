package list;

import java.util.ArrayList;

import entity.HoaDon;
import entity.SanPham;
import interfaces.listInterface;

public class DanhSachHoaDon implements listInterface<HoaDon>{

	private ArrayList<HoaDon>list;
	
	
	
	public DanhSachHoaDon() {
		list = new ArrayList<HoaDon>();
	}

	public DanhSachHoaDon(ArrayList<HoaDon> list) {
		super();
		this.list = list;
	}

	@Override
	public String getDS() {
		String s = "";
		for (HoaDon hd : list) {
			s += hd + "\n";
		}
		return s;
	}

	@Override
	public boolean add(HoaDon obj) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMaHD().equalsIgnoreCase(obj.getMaHD()))
				return false;
		}
		list.add(obj);
		return true;
	}

	@Override
	public boolean xoa(int index) {
		if(index >=0 && index <= list.size() - 1) {
			list.remove(index);
			return true;
		}else
			return false;
	}
	public int timHDTheoMa(String maHD) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMaHD().equalsIgnoreCase(maHD))
				return i;
		}
		return -1;
	}
	public ArrayList<HoaDon>timHDTheoMaNV(String maNV){
		ArrayList<HoaDon>listHD = new ArrayList<HoaDon>();
		for (HoaDon hoaDon : list) {
			if(hoaDon.getMaNV().equalsIgnoreCase(maNV))
				listHD.add(hoaDon);
		}
		return listHD;
	}
	public ArrayList<HoaDon>timHDTheoMaKH(String maKH){
		ArrayList<HoaDon>listHD = new ArrayList<HoaDon>();
		for (HoaDon hoaDon : list) {
			if(hoaDon.getMaKH().equalsIgnoreCase(maKH))
				listHD.add(hoaDon);
		}
		return listHD;
	}	
	
	@Override
	public boolean update(HoaDon obj) {
		for(int i=0;i<list.size();i++)
			if(list.get(i).getMaHD().equalsIgnoreCase(obj.getMaHD())) {
				list.get(i).setMaKH(obj.getMaKH());
				list.get(i).setMaNV(obj.getMaNV());
				list.get(i).setNgayTaoHD(obj.getNgayTaoHD());
				return true;
			}
		return false;
	}

	@Override
	public int getCount() {
		return list.size();
	}
	
}
