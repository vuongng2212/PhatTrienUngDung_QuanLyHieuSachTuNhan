package list;

import java.util.ArrayList;

import entity.HoaDon;
import entity.KhachDH;
import interfaces.listInterface;

public class DanhSachKhachDH implements listInterface<KhachDH>{
	private ArrayList<KhachDH>list;

	
	
	public DanhSachKhachDH() {
		super();
	}



	public ArrayList<KhachDH> getList() {
		return list;
	}



	public void setList(ArrayList<KhachDH> list) {
		this.list = list;
	}



	public DanhSachKhachDH(ArrayList<KhachDH> list) {
		super();
		this.list = list;
	}



	@Override
	public String getDS() {
		String s = "";
		for (KhachDH hd : list) {
			s += hd + "\n";
		}
		return s;
	}



	@Override
	public boolean add(KhachDH obj) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMaDH().equalsIgnoreCase(obj.getMaDH()))
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



	@Override
	public boolean update(KhachDH obj) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public int getCount() {
		return list.size();
	}
	
	
	
}
