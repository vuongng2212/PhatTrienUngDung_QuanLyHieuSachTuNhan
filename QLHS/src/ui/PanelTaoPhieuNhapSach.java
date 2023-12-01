package ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_CTPhieuNhapHang;
import dao.DAO_PhieuNhapHang;
import dao.DAO_SanPham;
import entity.CTPhieuNhapHang;
import entity.PhieuNhapHang;
import entity.SanPham;
import entity.userInfo;
import list.DanhSachChiTietPDH;
import list.DanhSachPhieuNH;
import list.DanhSachSanPham;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class PanelTaoPhieuNhapSach extends JPanel {
	private JTextField txtTen;
	private JTextField txtSoLuongNhap;
	private JTextField txtChietKhau;
	private JLabel lblValueTT;
	private JTable table, tableTTSP;
	private DefaultTableModel tableModel,tableModelTTSP;
	private JComboBox cbDM,cbNamXB,cbNhaXB;
	private JTextField txtMaDH;
	private DanhSachSanPham lsSP;
	private DAO_SanPham DAO_SP;
	private DanhSachChiTietPDH lsCTPDH;
	private DAO_CTPhieuNhapHang DAO_CTPDH;
	private DAO_PhieuNhapHang DAO_PDH;
	private int stt =1;
	private int sttCTDH = 1;
	private double thanhTien = 0;
	private Image img_TaoMaDH = new ImageIcon(FormNVQuanLy.class.getResource("/image/added.png")).getImage().getScaledInstance(25, 25,Image.SCALE_SMOOTH );
	/**
	 * Create the panel.
	 */
	public PanelTaoPhieuNhapSach() {
		lsSP = new DanhSachSanPham();
		lsCTPDH = new DanhSachChiTietPDH();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		setBounds(0, 200, 1920, 816);
		setLayout(null);
		JPanel tblPanel = new JPanel();
		tblPanel.setBounds(0, 0, 1170, 816);
		add(tblPanel);
		String[] headers = { "STT", "Mã sách", "Tên sách", "Danh mục", "NXB", "Năm XB", "Số lượng", "Đơn giá"};
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 60, 1170, 655);
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
//		table.getColumnModel().getColumn(0).setPreferredWidth(30);
//		table.getColumnModel().getColumn(1).setPreferredWidth(100);
//		table.getColumnModel().getColumn(2).setPreferredWidth(200);
//		table.getColumnModel().getColumn(3).setPreferredWidth(50);
//		table.getColumnModel().getColumn(4).setPreferredWidth(100);
//		table.getColumnModel().getColumn(6).setPreferredWidth(150);
//		table.getColumnModel().getColumn(7).setPreferredWidth(150);
//		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tblPanel.setLayout(null);
		tblPanel.add(scroll);
		
		JLabel lblTimSach = new JLabel("Tìm sách:");
		lblTimSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTimSach.setBounds(10, 15, 90, 20);
		tblPanel.add(lblTimSach);
		
		JLabel lblTen = new JLabel("Tên sách");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTen.setBounds(120, 17, 70, 20);
		tblPanel.add(lblTen);
		
		txtTen = new JTextField();
		txtTen.setBounds(200, 19, 100, 20);
		tblPanel.add(txtTen);
		txtTen.setColumns(10);
		
		JLabel lblTheLoai = new JLabel("Danh mục");
		lblTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTheLoai.setBounds(310, 17, 90, 20);
		tblPanel.add(lblTheLoai);
		
		cbDM = new JComboBox();
		cbDM.setBounds(410, 18, 100, 22);
		tblPanel.add(cbDM);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findSPByCondition();
			}
		});
		btnTim.setBackground(new Color(0, 128, 255));
		btnTim.setBounds(1080, 11, 90, 30);
		tblPanel.add(btnTim);
		
		JLabel lblSL = new JLabel("Số lượng");
		lblSL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSL.setBounds(800, 744, 90, 30);
		tblPanel.add(lblSL);
		
		txtSoLuongNhap = new JTextField();
		txtSoLuongNhap.setBounds(900, 747, 90, 30);
		tblPanel.add(txtSoLuongNhap);
		txtSoLuongNhap.setColumns(10);
		
		JLabel lblNXB = new JLabel("Nhà XB:");
		lblNXB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNXB.setBounds(520, 17, 70, 20);
		tblPanel.add(lblNXB);
		
		cbNhaXB = new JComboBox();
		cbNhaXB.setBounds(600, 18, 100, 22);
		tblPanel.add(cbNhaXB);
		
		JLabel lblNam = new JLabel("Năm XB:");
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNam.setBounds(710, 17, 70, 20);
		tblPanel.add(lblNam);
		
		cbNamXB = new JComboBox();
		cbNamXB.setBounds(790, 18, 70, 22);
		tblPanel.add(cbNamXB);
		
		cbDM.addItem("");
		cbNhaXB.addItem("");
		cbNamXB.addItem("");
		
		JPanel tbl = new JPanel();
		tbl.setBounds(1200, 240, 720, 584);
		add(tbl);
		String[] headers1 = { "STT", "Mã sách", "Tên sách", "Số lượng", "Đơn giá"};
		tableModelTTSP = new DefaultTableModel(headers1, 0);
		JScrollPane scroll1 = new JScrollPane(tableTTSP, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll1.setBounds(0, 60, 720, 415);
		scroll1.setViewportView(tableTTSP = new JTable(tableModelTTSP));
		tableTTSP.setRowHeight(25);
		tableTTSP.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableTTSP.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableTTSP.getColumnModel().getColumn(2).setPreferredWidth(200);
		tableTTSP.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableTTSP.getColumnModel().getColumn(4).setPreferredWidth(30);
		tableTTSP.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tbl.setLayout(null);
		tbl.add(scroll1);

		JPanel tTDHPanel = new JPanel();
		scroll1.setColumnHeaderView(tTDHPanel);
		tTDHPanel.setLayout(null);
		
		JLabel lblHDDH = new JLabel("Danh sách sản phẩm đặt hàng");
		lblHDDH.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHDDH.setBounds(215, 11, 305, 30);
		tbl.add(lblHDDH);
		
		JLabel lblThanhTien = new JLabel("Thành tiền");
		lblThanhTien.setForeground(new Color(255, 0, 0));
		lblThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThanhTien.setBounds(10, 530, 90, 30);
		tbl.add(lblThanhTien);
		
		JLabel lblTTPhieuDH = new JLabel("Thông tin phiếu đặt hàng");
		lblTTPhieuDH.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTTPhieuDH.setBounds(1440, 11, 270, 30);
		add(lblTTPhieuDH);
		
		JLabel lblMaDH = new JLabel("Mã đặt hàng");
		lblMaDH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaDH.setBounds(1200, 60, 150, 25);
		add(lblMaDH);
		
		JLabel lblMaNV = new JLabel("Nhân viên đặt hàng");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaNV.setBounds(1200, 96, 150, 25);
		add(lblMaNV);
		
		JLabel lblNgayDH = new JLabel("Ngày đặt");
		lblNgayDH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayDH.setBounds(1200, 132, 150, 25);
		add(lblNgayDH);
		
		JLabel lblChietKhau = new JLabel("Chiết khấu:");
		lblChietKhau.setBounds(1200, 168, 150, 30);
		add(lblChietKhau);
		lblChietKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtChietKhau = new JTextField();
		txtChietKhau.setBounds(1395, 173, 50, 25);
		add(txtChietKhau);
		txtChietKhau.setColumns(10);
		
		txtMaDH = new JTextField();
		txtMaDH.setColumns(10);
		txtMaDH.setBounds(1395, 62, 100, 25);
		add(txtMaDH);
		
		JLabel lblTenNV = new JLabel(userInfo.getMaNV()+"."+userInfo.getTenNV());
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenNV.setBounds(1395, 96, 515, 25);
		add(lblTenNV);
		
		
		Date currentDate = new Date();	
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    String str = formatter.format(currentDate);
		JLabel lblNgayTao = new JLabel(str);
		lblNgayTao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayTao.setBounds(1395, 137, 150, 25);
		add(lblNgayTao);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String sl = txtSoLuongNhap.getText();
				if (row != -1) {
					if(sl.equals("")) {
						JOptionPane.showMessageDialog(getParent(), "Vui lòng nhập số lượng sản phẩm muốn đặt");
					}
					else {
						String maSach = table.getModel().getValueAt(row, 1).toString();
						String tenSach = table.getModel().getValueAt(row, 2).toString();
						String donGia = table.getModel().getValueAt(row, 7).toString();
						
						CTPhieuNhapHang ctPDH = new CTPhieuNhapHang(maSach,tenSach, Integer.parseInt(sl), Double.parseDouble(donGia));
						
						
						if(lsCTPDH.them(ctPDH) == false) {
							for(int i=0; i<lsCTPDH.getCount();i++) {
								if(lsCTPDH.getList().get(i).getMaSP().equals(ctPDH.getMaSP())) {
									int newSL = lsCTPDH.getList().get(i).getSoLuong()+ctPDH.getSoLuong();
									lsCTPDH.getList().get(i).setSoLuong(newSL);
								}
							}
						}
						
						
						deleteAllDataJtable(tableTTSP);
						sttCTDH = 1;
						thanhTien = 0;
						for(CTPhieuNhapHang pdh: lsCTPDH.getList()) {
							Object rowTTSP[]= {sttCTDH++,pdh.getMaSP(),pdh.getTenSP(),pdh.getSoLuong(),pdh.getDonGiaNhap()};
							tableModelTTSP.addRow(rowTTSP);
							thanhTien += pdh.getDonGiaNhap() * pdh.getSoLuong();
						}
//						System.out.println(lsCTPDH.getList().toString());
						double ck = 0;
						if(!txtChietKhau.getText().equals("")) {
							ck = Double.parseDouble(txtChietKhau.getText());
						}
						lblValueTT.setText(String.valueOf(thanhTien*(100-ck)/100));
					}
				}
				else {
					JOptionPane.showMessageDialog(getParent(), "Vui lòng chọn sản phẩm muốn đặt hàng");
				}
			}
		});
		btnThem.setBounds(1030, 747, 90, 30);
		tblPanel.add(btnThem);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBackground(new Color(0, 255, 64));
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSP();
			}
		});
		btnLamMoi.setBackground(new Color(0, 255, 64));
		btnLamMoi.setBounds(969, 11, 90, 30);
		tblPanel.add(btnLamMoi);
		
		JButton btnXoa = new JButton("Xóa sản phẩm");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableTTSP.getSelectedRow();
				if(row!=-1) {
					lsCTPDH.xoa(row);
					deleteAllDataJtable(tableTTSP);
					sttCTDH = 1;
					thanhTien = 0;
					for(CTPhieuNhapHang pdh: lsCTPDH.getList()) {
						Object rowTTSP[]= {sttCTDH++,pdh.getMaSP(),pdh.getTenSP(),pdh.getSoLuong(),pdh.getDonGiaNhap()};
						tableModelTTSP.addRow(rowTTSP);
						thanhTien += pdh.getDonGiaNhap() * pdh.getSoLuong();
					}
					lblValueTT.setText(String.valueOf(thanhTien));
				}
				else {
					JOptionPane.showMessageDialog(getParent(), "Vui lòng chọn sản phẩm muốn xóa");
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBounds(530, 488, 180, 30);
		tbl.add(btnXoa);
		
		JButton btnDH = new JButton("Đặt hàng");
		btnDH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO_PDH = new DAO_PhieuNhapHang();
				
				String maDH = txtMaDH.getText().trim();
				Date currentDate = new Date();
				java.sql.Date ngayDH = new java.sql.Date(currentDate.getTime());
				String ck = txtChietKhau.getText().trim();

				if(validData()) {
					PhieuNhapHang pDHtmp = new PhieuNhapHang(maDH, userInfo.getMaNV(), ngayDH, Double.parseDouble(ck));
					if(DAO_PDH.add(pDHtmp)) {
						
						for(int i=0; i<lsCTPDH.getCount(); i++) {
							DAO_CTPhieuNhapHang DAO_ct = new DAO_CTPhieuNhapHang();
							String maDHString = txtMaDH.getText();
							String maSP = lsCTPDH.getList().get(i).getMaSP();
							int sl = lsCTPDH.getList().get(i).getSoLuong();
							CTPhieuNhapHang ct = new CTPhieuNhapHang(maDHString, maSP, sl);
							DAO_ct.add(ct);
						}
						
						System.out.println(lsCTPDH.getCount());
					    lsCTPDH.clear();
					    System.out.println(lsCTPDH.getCount());
						deleteAllDataJtable(tableTTSP);
						txtChietKhau.setText("");
						txtMaDH.setText("");
						txtSoLuongNhap.setText("");
						lblValueTT.setText("0");
						thanhTien = 0;
						JOptionPane.showMessageDialog(getParent(), "Đặt sách thành công");
						
					}
					else {
						JOptionPane.showMessageDialog(getParent(), "Đặt sách thất bại");
					}
				}	
			}
		});
		btnDH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDH.setBackground(new Color(0, 255, 64));
		btnDH.setBounds(530, 529, 180, 30);
		tbl.add(btnDH);
		
		lblValueTT = new JLabel("");
		lblValueTT.setForeground(Color.RED);
		lblValueTT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValueTT.setBounds(110, 529, 150, 30);
		tbl.add(lblValueTT);
		
		JButton btnTaoMaDH = new JButton("");
		btnTaoMaDH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO_PDH = new DAO_PhieuNhapHang();
				String lastPDH = DAO_PDH.getLastPhieuDH();
				if(lastPDH!=null) {	
					Integer strToInt = Integer.parseInt(lastPDH.substring(2));
					String s = String.format("%03d", strToInt + 1);
					txtMaDH.setText("NH"+s);
				}
				
			}
		});
		btnTaoMaDH.setBounds(1505, 63, 25, 25);
		btnTaoMaDH.setIcon(new ImageIcon(img_TaoMaDH));
		add(btnTaoMaDH);
		getSP();
		
	}
	public void deleteAllDataJtable(JTable table) {
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
		while(dm.getRowCount() > 0)
		{
		    dm.removeRow(0);
		}
	}
	public void getSP() {
		deleteAllDataJtable(table);
		DAO_SP = new DAO_SanPham();

		lsSP.clear();
		stt =1;
		for(SanPham sp: DAO_SP.getAll().getListData()) {
			lsSP.add(sp);
			if(((DefaultComboBoxModel)cbDM.getModel()).getIndexOf(sp.getDanhMuc()) == -1) {
				cbDM.addItem(sp.getDanhMuc());
			}
			if(((DefaultComboBoxModel)cbNamXB.getModel()).getIndexOf(sp.getNamXB()) == -1) {
				cbNamXB.addItem(sp.getNamXB());
			}
			if(((DefaultComboBoxModel)cbNhaXB.getModel()).getIndexOf(sp.getNhaXB()) == -1) {
				cbNhaXB.addItem(sp.getNhaXB());
			}
			Object row[] = {stt++,sp.getMaSP(),sp.getTenSP(),sp.getDanhMuc(),sp.getNhaXB(),sp.getNamXB(),sp.getSoLuong(),sp.getDonGiaGoc()};
			tableModel.addRow(row);
			
		}
	}
	public void findSPByCondition() {
		deleteAllDataJtable(table);
		DAO_SP = new DAO_SanPham();

		lsSP.clear();
		stt =1;
		String dm = cbDM.getSelectedItem().toString();
		String nhaXB = cbNhaXB.getSelectedItem().toString();
		String namXB = cbNamXB.getSelectedItem().toString();
		for(SanPham sp: DAO_SP.findSP(txtTen.getText(),dm,nhaXB,namXB)) {
			lsSP.add(sp);
			Object row[] = {stt++,sp.getMaSP(),sp.getTenSP(),sp.getDanhMuc(),sp.getNhaXB(),sp.getNamXB(),sp.getSoLuong(),sp.getDonGiaGoc()};
			tableModel.addRow(row);
			
		}
	}
	private boolean validData() {
		String maDH = txtMaDH.getText().trim();
		String ck = txtChietKhau.getText().trim();

		Pattern p = Pattern.compile("^(NH)[0-9]{3}");
		if (!(maDH.length() > 0 && p.matcher(maDH).find())) {
			JOptionPane.showMessageDialog(getParent(), "Lỗi mã đặt hàng");
			return false;
		}
		Pattern p3 = Pattern.compile("[0-9]{1,3}");
		if (!(ck.length() > 0 && p3.matcher(ck).find())) {
			JOptionPane.showMessageDialog(getParent(), "Chiết khấu không được rỗng và là số");
			return false;
		}
		
		return true;
	}
}
