package list;

import java.util.ArrayList;
import java.util.Date;

import entity.KhachHang;
import entity.KhuyenMai;
import interfaces.listInterface;

public class DanhSachKhuyenMai implements listInterface<KhuyenMai>{
	private ArrayList<KhuyenMai>list;
	
	
	
	
	public DanhSachKhuyenMai() {
		list = new ArrayList<KhuyenMai>();
	}

	public DanhSachKhuyenMai(ArrayList<KhuyenMai> list) {
		super();
		this.list = list;
	}
	
	
	
	public ArrayList<KhuyenMai> getList() {
		return list;
	}

	public void setList(ArrayList<KhuyenMai> list) {
		this.list = list;
	}

	@Override
	public String getDS() {
		String s = "";
		for (KhuyenMai kh : list) {
			s+=kh + "\n";
		}
		return s;
	}

	@Override
	public boolean add(KhuyenMai obj) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getMaKM().equalsIgnoreCase(obj.getMaKM())) {
				return false;
			}else {
				{
					if(list.get(i).getMaSP().equalsIgnoreCase(obj.getMaSP()) && list.get(i).getNgayHetHan().compareTo(obj.getNgayTao())<0) {
						return false;
					}
				}
			}
		}
		list.add(obj);
		return true;
	}

	@Override
	public boolean xoa(int index) {
		if(index >=0 && index<=list.size()-1) {
			list.remove(index);
			return true;
		}else return false;
	}

	@Override
	public boolean update(KhuyenMai obj) {
		for(int i=0;i<list.size();i++)
			if(list.get(i).getMaKM().equalsIgnoreCase(obj.getMaKM())) {
				list.get(i).setMaSP(obj.getMaSP());
				list.get(i).setDiscount(obj.getDiscount());
				list.get(i).setNgayHetHan(obj.getNgayHetHan());
				list.get(i).setNgayTao(obj.getNgayTao());
				return true;
			}
		return false;
	}
	ArrayList<KhuyenMai>TimKhuyenMaiTheoSP(String maSP){
		ArrayList<KhuyenMai>listKM = new ArrayList<KhuyenMai>();
		for (KhuyenMai khuyenMai : list) {
			if(khuyenMai.getMaSP().equalsIgnoreCase(maSP))
				listKM.add(khuyenMai);
		}
		return listKM;
	}
	ArrayList<KhuyenMai>khuyenMaiConSuDung(Date startTime,Date endTime){
		ArrayList<KhuyenMai>listKM = new ArrayList<KhuyenMai>();
		for (KhuyenMai khuyenMai : list) {
			if((khuyenMai.getNgayTao().compareTo(startTime)>=0) && (khuyenMai.getNgayHetHan().compareTo(endTime)<=0))
					listKM.add(khuyenMai);
		}
		return listKM;
	}

	@Override
	public int getCount() {
		return list.size();
	}
	
}
