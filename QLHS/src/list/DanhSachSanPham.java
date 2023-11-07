package list;

import java.util.ArrayList;

import entity.SanPham;
import interfaces.listInterface;

public class DanhSachSanPham implements listInterface<SanPham>{
	private ArrayList<SanPham>list;

	
	
	
	public ArrayList<SanPham> getList() {
		return list;
	}

	public void setList(ArrayList<SanPham> list) {
		this.list = list;
	}

	public DanhSachSanPham() {
		list = new ArrayList<SanPham>();
	}

	public DanhSachSanPham(ArrayList<SanPham> list) {
		super();
		this.list = list;
	}
	
	@Override
	public String getDS() {
		String s = "";
		for (SanPham sanPham : list) {
			s+=sanPham + "\n";
		}
		return s;
	}
	@Override
	public boolean add(SanPham sp) {
		for(int i=0;i < list.size();i++) {
			if(list.get(i).getMaSP().equalsIgnoreCase(sp.getMaSP())) {
				return false;
			}
		}
		list.add(sp);
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
	
	public int timSPTheoMa(String maSP) {
		for(int i =0; i < list.size();i++) {
			if(list.get(i).getMaSP().equalsIgnoreCase(maSP))
				return i;
		}
		return -1;
	}
	public ArrayList<SanPham>timSPTheoTenSach(String tenSach){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getTenSP().equalsIgnoreCase(tenSach))
				listSP.add(sanPham);
		}
		
		return listSP;
	}
	public ArrayList<SanPham>timSPTheoTenSachVaTgia(String tenSach,String tacGia){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getTenSP().equalsIgnoreCase(tenSach) && sanPham.getTenTG().equalsIgnoreCase(tacGia)) {
				listSP.add(sanPham);
			}
		}
		
		return listSP;
	}
	
	public ArrayList<SanPham>timSPTheoTenSachVaDanhMuc(String tenSach,String danhMuc){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getTenSP().equalsIgnoreCase(tenSach) && sanPham.getDanhMuc().equalsIgnoreCase(danhMuc)) {
				listSP.add(sanPham);
			}
		}
		return listSP;
	}
	
	public ArrayList<SanPham>timSPTheoTenSachVaNXB(String tenSach,String nxb){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getTenSP().equalsIgnoreCase(tenSach) && sanPham.getNhaXB().equalsIgnoreCase(nxb)) {
				listSP.add(sanPham);
			}
		}
		return listSP;
	}
	
	public ArrayList<SanPham>timSPTheoTacGiaVaDanhMuc(String tacGia,String danhMuc){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getTenTG().equalsIgnoreCase(tacGia) && sanPham.getDanhMuc().equalsIgnoreCase(danhMuc)) {
				listSP.add(sanPham);
			}
		}
		return listSP;
	}
	
	public ArrayList<SanPham>timSPTheoTacGiaVaNXB(String tacGia,String nxb){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getTenTG().equalsIgnoreCase(tacGia) && sanPham.getNhaXB().equalsIgnoreCase(nxb)) {
				listSP.add(sanPham);
			}
		}
		return listSP;
	}
	
	public ArrayList<SanPham>timSPTheoDanhMucVaNXB(String danhMuc,String nxb){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getDanhMuc().equalsIgnoreCase(danhMuc) && sanPham.getNhaXB().equalsIgnoreCase(nxb)) {
				listSP.add(sanPham);
			}
		}
		return listSP;
	}
	
	public ArrayList<SanPham>timSPTheoTacGiavaDanhMucVaNXB(String tacGia,String danhMuc,String nxb){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getTenTG().equalsIgnoreCase(tacGia) && sanPham.getDanhMuc().equalsIgnoreCase(danhMuc) && sanPham.getNhaXB().equalsIgnoreCase(nxb)) {
				listSP.add(sanPham);
			}
		}
		return listSP;
	}
	
	public ArrayList<SanPham>timSPTheoTenSachvaTacGiaVaDanhMuc(String tenSach,String tacGia,String danhMuc){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getTenTG().equalsIgnoreCase(tacGia) && sanPham.getDanhMuc().equalsIgnoreCase(danhMuc) && sanPham.getTenSP().equalsIgnoreCase(tenSach)) {
				listSP.add(sanPham);
			}
		}
		return listSP;
	}
	
	public ArrayList<SanPham>timSPTheoTenSachvaDanhMucVaNXB(String tenSach,String danhMuc,String nxb){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getTenSP().equalsIgnoreCase(tenSach) && sanPham.getDanhMuc().equalsIgnoreCase(danhMuc) && sanPham.getNhaXB().equalsIgnoreCase(nxb)) {
				listSP.add(sanPham);
			}
		}
		return listSP;
	}
	
	public ArrayList<SanPham>timSPTheoTenSachvaTacGiaVaNXB(String tenSach,String tacGia,String nxb){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getTenSP().equalsIgnoreCase(tenSach) && sanPham.getTenTG().equalsIgnoreCase(tacGia) && sanPham.getNhaXB().equalsIgnoreCase(nxb)) {
				listSP.add(sanPham);
			}
		}
		return listSP;
	}
	
	
	
	public ArrayList<SanPham>timSPTheoTenSachvaTacGiavaDanhMucVaNXB(String tenSach ,String tacGia,String danhMuc,String nxb){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getTenSP().equalsIgnoreCase(tenSach) && sanPham.getTenTG().equalsIgnoreCase(tacGia) && sanPham.getDanhMuc().equalsIgnoreCase(danhMuc) && sanPham.getNhaXB().equalsIgnoreCase(nxb)) {
				listSP.add(sanPham);
			}
		}
		return listSP;
	}
	
	
	public ArrayList<SanPham>timSPTheoTacGia(String tacGia){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getTenTG().equalsIgnoreCase(tacGia))
				listSP.add(sanPham);
		}
		return listSP;
	}
	public ArrayList<SanPham>timSPTheoDanhMuc(String danhMuc){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getDanhMuc().equalsIgnoreCase(danhMuc))
				listSP.add(sanPham);
		}
		return listSP;
	}
	public ArrayList<SanPham>timSPTheoNhaXB(String nhaXB){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getNhaXB().equalsIgnoreCase(nhaXB))
				listSP.add(sanPham);
		}
		return listSP;
	}
	public ArrayList<SanPham>timSPTheoTinhTrang(String tinhTrang){
		ArrayList<SanPham>listSP = new ArrayList<SanPham>();
		for (SanPham sanPham : list) {
			if(sanPham.getTinhTrang().equalsIgnoreCase(tinhTrang))
				listSP.add(sanPham);
		}
		return listSP;
	}
	
	
	@Override
	public boolean update(SanPham sp) {
		for(int i=0;i<list.size();i++)
			if(list.get(i).getMaSP().equalsIgnoreCase(sp.getMaSP())) {
				list.get(i).setTenSP(sp.getTenSP());
				list.get(i).setTenTG(sp.getTenTG());
				list.get(i).setNhaXB(sp.getNhaXB());
				list.get(i).setNamXB(sp.getNamXB());
				list.get(i).setSoLuong(sp.getSoLuong());
				list.get(i).setDonGiaGoc(sp.getDonGiaGoc());
				list.get(i).setDonGiaMua(sp.getDonGiaMua());
				list.get(i).setTinhTrang(sp.getTinhTrang());
				list.get(i).setDanhMuc(sp.getDanhMuc());
				return true;
			}
		return false;
	}
	@Override
	public int getCount() {
		return list.size();
	}
	
	public void clear() {
	    for (int i = 0; i < list.size(); i++)
	    	list.remove(i);
	}
	
	public ArrayList<SanPham> getListData(){
		return list;
	}
}