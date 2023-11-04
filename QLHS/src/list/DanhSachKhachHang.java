package list;

import java.util.ArrayList;

import entity.KhachHang;
import entity.SanPham;
import interfaces.listInterface;

public class DanhSachKhachHang implements listInterface<KhachHang>{
	private ArrayList<KhachHang>list;
	
	
	
	public DanhSachKhachHang() {
		list = new ArrayList<KhachHang>();
	}

	public DanhSachKhachHang(ArrayList<KhachHang> list) {
		super();
		this.list = list;
	}

	@Override
	public String getDS() {
		String s = "";
		for (KhachHang kh : list) {
			s+=kh + "\n";
		}
		return s;
	}

	@Override
	public boolean add(KhachHang kh) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMaKH().equalsIgnoreCase(kh.getMaKH())) {
				return false;
			}
		}
		list.add(kh);
		return true;
	}

	@Override
	public boolean xoa(int index) {
		if(index >=0 && index <=list.size()-1) {
			list.remove(index);
			return true;
		}else return false;
	}
	
	@Override
	public boolean update(KhachHang kh) {
		for(int i=0;i<list.size();i++)
			if(list.get(i).getMaKH().equalsIgnoreCase(kh.getMaKH())) {
				list.get(i).setTenKH(kh.getTenKH());
				list.get(i).setSdt(kh.getSdt());
				list.get(i).setDiaChi(kh.getDiaChi());
				list.get(i).setLoaiKH(kh.getLoaiKH());
				return true;
			}
		return false;
	}
	public int timKHTheoMa(String maKH) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMaKH().equalsIgnoreCase(maKH))
				return i;
		}
		return -1;
	}
//	public boolean ktraTrungSDT
//	public int timKHTheoTen(String tenKH) {
//		for(int i=0;i<list.size();i++) {
//			if(list.get(i).getTenKH().equalsIgnoreCase(tenKH))
//				return i;
//		}
//		return -1;
//	}
	public ArrayList<KhachHang>timKHTheoTen(String tenKH){
		ArrayList<KhachHang>listKH = new ArrayList<KhachHang>();
		for (KhachHang khachHang : list) {
			if(khachHang.getTenKH().equalsIgnoreCase(tenKH))
				listKH.add(khachHang);
		}
		return listKH;
	}
	
	public int timKHTheoSDT(String soDT) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getSdt().equalsIgnoreCase(soDT))
				return i;
		}
		return -1;
	}
	public boolean ktraTonTaiSDT(String sdt) {
		for (KhachHang khachHang : list) {
			if(khachHang.getSdt().equalsIgnoreCase(sdt))
				return true;
		}
		return false;
	}
	
	public ArrayList<KhachHang>dsKhTheoLoai(String loaiKH) {
		ArrayList<KhachHang>listKh = new ArrayList<KhachHang>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getLoaiKH().equalsIgnoreCase(loaiKH))
				listKh.add(list.get(i));
		}
		return listKh;
	}	
	
	public ArrayList<KhachHang> getList() {
		return list;
	}

	public void setList(ArrayList<KhachHang> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

}
