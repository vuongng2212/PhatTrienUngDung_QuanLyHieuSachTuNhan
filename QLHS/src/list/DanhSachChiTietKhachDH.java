package list;

import java.util.ArrayList;

import entity.ChiTietHoaDon;
import entity.ChiTietKhachDH;
import interfaces.listInterface;

public class DanhSachChiTietKhachDH implements listInterface<ChiTietKhachDH>{
	private ArrayList<ChiTietKhachDH>list;

	
	
	public DanhSachChiTietKhachDH() {
		list = new ArrayList<ChiTietKhachDH>();
	}

	public DanhSachChiTietKhachDH(ArrayList<ChiTietKhachDH> list) {
		super();
		this.list = list;
	}

	public ArrayList<ChiTietKhachDH> getList() {
		return list;
	}

	public void setList(ArrayList<ChiTietKhachDH> list) {
		this.list = list;
	}

	@Override
	public String getDS() {
		String s = "";
		for (ChiTietKhachDH hd : list) {
			s+=hd + "\n";
		}
		return s;
	}

	@Override
	public boolean add(ChiTietKhachDH obj) {
		// TODO Auto-generated method stub
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
	public boolean update(ChiTietKhachDH obj) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMaDH().equalsIgnoreCase(obj.getMaDH())){
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
