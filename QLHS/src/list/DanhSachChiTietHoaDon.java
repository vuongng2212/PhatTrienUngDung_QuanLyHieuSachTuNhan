package list;

import java.util.ArrayList;

import entity.ChiTietHoaDon;
import entity.SanPham;
import interfaces.listInterface;

public class DanhSachChiTietHoaDon implements listInterface<ChiTietHoaDon>{
	private ArrayList<ChiTietHoaDon>list;
	
	
	
	
	public DanhSachChiTietHoaDon() {
		list = new ArrayList<ChiTietHoaDon>();
	}

	public ArrayList<ChiTietHoaDon> getList() {
		return list;
	}

	public void setList(ArrayList<ChiTietHoaDon> list) {
		this.list = list;
	}

	public DanhSachChiTietHoaDon(ArrayList<ChiTietHoaDon> list) {
		super();
		this.list = list;
	}

	@Override
	public String getDS() {
		String s = "";
		for (ChiTietHoaDon hd : list) {
			s+=hd + "\n";
		}
		return s;
	}

	@Override
	public boolean add(ChiTietHoaDon obj) {
//		for(int i=0;i < list.size();i++) {
//			if(list.get(i).getMaHD().equalsIgnoreCase(sp.getMaSP())) {
//				return false;
//			}
//		}
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

	@Override
	public boolean update(ChiTietHoaDon obj) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMaHD().equalsIgnoreCase(obj.getMaHD())){
				list.get(i).setSoLuong(obj.getSoLuong());
				list.get(i).setDonGia(obj.getDonGia());
				return true;
			}
		}
		return false;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	
}
