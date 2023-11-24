package ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_CTPhieuNhapHang;
import dao.DAO_NhanVien;
import dao.DAO_PhieuNhapHang;
import dao.DAO_SanPham;
import entity.CTPhieuNhapHang;
import entity.NhanVien;
import entity.PhieuNhapHang;
import entity.SanPham;
import list.DanhSachChiTietPDH;
import list.DanhSachNhanVien;
import list.DanhSachPhieuNH;
import list.DanhSachSanPham;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelNhapSach extends JPanel {
	private JLabel lblTenNV;
	private JTextField txtChietKhau;
	private JTable table, tableTTSP;
	private DefaultTableModel tableModel,tableModelTTSP;
	private DanhSachPhieuNH ls;
	private DanhSachChiTietPDH lsChiTietPhieuDH;
	private DAO_PhieuNhapHang DAO_PhieuDH;
	private DAO_CTPhieuNhapHang DAO_CTPhieuDH;
	private String start,end;
	private int stt =1;
	private int stt_ctpdh =1;
	private String maDH;
	private int rowValue;
	/**
	 * Create the panel.
	 */
	public PanelNhapSach() {
		ls = new DanhSachPhieuNH();
		lsChiTietPhieuDH = new DanhSachChiTietPDH();
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
		
		
		JLabel lblValueMaDH = new JLabel("");
		lblValueMaDH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValueMaDH.setBounds(1395, 52, 150, 25);
		add(lblValueMaDH);
		
		txtChietKhau = new JTextField();
		txtChietKhau.setBounds(1395, 173, 50, 25);
		add(txtChietKhau);
		txtChietKhau.setColumns(10);
		txtChietKhau.setEditable(false);
		
		lblTenNV = new JLabel("");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenNV.setBounds(1395, 96, 150, 25);
		add(lblTenNV);
		
		JLabel lblNgayTao = new JLabel("");
		lblNgayTao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayTao.setBounds(1395, 137, 150, 25);
		add(lblNgayTao);
		
		JLabel lblTimDonDH = new JLabel("Tìm đơn đặt hàng");
		lblTimDonDH.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimDonDH.setBounds(450, 0, 200, 29);
		tblPanel.add(lblTimDonDH);
		
		
		
		JLabel lblStart = new JLabel("Ngày bắt đầu");
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStart.setBounds(20, 50, 100, 30);
		tblPanel.add(lblStart);
		
		JLabel lblEnd = new JLabel("Ngày bắt đầu");
		lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnd.setBounds(270, 50, 100, 30);
		tblPanel.add(lblEnd);
		
		JDateChooser dateChooserStart = new JDateChooser();
		dateChooserStart.setBounds(130, 52, 100, 30);
		tblPanel.add(dateChooserStart);
		
		JDateChooser dateChooserEnd = new JDateChooser();
		dateChooserEnd.setBounds(380, 52, 100, 30);
		tblPanel.add(dateChooserEnd);
		
		
		
		JPanel tbl = new JPanel();
		tbl.setBounds(1200, 240, 720, 576);
		add(tbl);
		String[] headers1 = { "STT", "Mã đặt hàng", "Mã sản phẩm", "Tên sản phẩm", "Số lượng"};
		tableModelTTSP = new DefaultTableModel(headers1, 0);
		JScrollPane scroll1 = new JScrollPane(tableTTSP, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll1.setBounds(0, 60, 720, 415);
		scroll1.setViewportView(tableTTSP = new JTable(tableModelTTSP));
		tableTTSP.setRowHeight(25);
		tableTTSP.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableTTSP.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableTTSP.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableTTSP.getColumnModel().getColumn(3).setPreferredWidth(200);
		tableTTSP.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableTTSP.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tbl.setLayout(null);
		tbl.add(scroll1);
//		JPanel westPanel = new JPanel();
//		westPanel.setBounds(0, 401, 600, 415);
//		westPanel.setLayout(null);
//		add(westPanel);
		JPanel tTDHPanel = new JPanel();
		scroll1.setColumnHeaderView(tTDHPanel);
		tTDHPanel.setLayout(null);
		
		JLabel lblHDDH = new JLabel("Danh sách sản phẩm đặt hàng");
		lblHDDH.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHDDH.setBounds(215, 11, 305, 30);
		tbl.add(lblHDDH);
		
		
		
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
		
		String[] headers = { "STT", "Mã đặt hàng","Mã nhân viên","Ngày đặt hàng","Chiết khấu","Trạng thái"};
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 93, 1170, 625);
		scroll.setViewportView(table = new JTable(tableModel));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rowValue = table.getSelectedRow();
				if(rowValue != -1) {
					maDH = table.getValueAt(rowValue, 1).toString();
					String ngayDat = table.getValueAt(rowValue, 3).toString();
					lblValueMaDH.setText(maDH);
					lblNgayTao.setText(ngayDat);
					findChiTietPhieuDH(maDH);
				}
			}
		});
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
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
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start = new Date(dateChooserStart.getDate().getTime()).toString();
				end = new Date(dateChooserEnd.getDate().getTime()).toString();
				findPhieuDH(start, end);
			}
		});
		btnTim.setBackground(new Color(0, 128, 255));
		btnTim.setBounds(560, 52, 90, 30);
		tblPanel.add(btnTim);
		
		JButton btnNhap = new JButton("Đã nhập sách");
		btnNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(rowValue!=-1) {
					String tt = table.getValueAt(rowValue, 5).toString();
					if(tt.equals("Chờ xử lý")) {
						for(int i=0;i<lsChiTietPhieuDH.getCount();i++) {
							DAO_CTPhieuDH = new DAO_CTPhieuNhapHang();
							if(DAO_CTPhieuDH.updateSL(lsChiTietPhieuDH.getList().get(i)) == false) {
								JOptionPane.showMessageDialog(getParent(), "Có lỗi xảy ra! Vui lòng kiểm tra lại...");
							}
						}
						lsChiTietPhieuDH.clear();
						DAO_PhieuDH = new DAO_PhieuNhapHang();
						DAO_PhieuDH.updateTrangThai(maDH, 1);
						findPhieuDH(start, end);
					}
					else {
						JOptionPane.showMessageDialog(getParent(), "Đơn đặt sách đã được nhập vào hệ thống");
					}
					
				}
				
				
			}
		});
		btnNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNhap.setBackground(new Color(0, 255, 64));
		btnNhap.setBounds(539, 500, 170, 45);
		tbl.add(btnNhap);
	}
	
	public void deleteAllDataJtable(JTable table) {
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
		while(dm.getRowCount() > 0)
		{
		    dm.removeRow(0);
		}
	}
	public void findPhieuDH(String start, String end) {
		deleteAllDataJtable(table);
		DAO_PhieuDH = new DAO_PhieuNhapHang();

		ls.clear();
		stt =1;
		
		for(PhieuNhapHang pdh: DAO_PhieuDH.getAll(start,end)) {
			ls.them(pdh);
			int tt = pdh.getTrangThai();
			String trangThai = "Chờ xử lý";
			if(tt==1) {
				trangThai = "Đã nhập";
			}
			Object row[] = {stt++,pdh.getmaNH(),pdh.getMaNV(),pdh.getNgayDH(),pdh.getChietKhau(),trangThai};
			tableModel.addRow(row);
			lblTenNV.setText(pdh.getTenNV());
			txtChietKhau.setText(String.valueOf(pdh.getChietKhau()));
		}
	}
	public void findChiTietPhieuDH(String maDH) {
		deleteAllDataJtable(tableTTSP);
		DAO_CTPhieuDH = new DAO_CTPhieuNhapHang();

		ls.clear();
		stt_ctpdh =1;
		for(CTPhieuNhapHang pdh: DAO_CTPhieuDH.getAll(maDH)) {
			lsChiTietPhieuDH.them(pdh);
			Object row[] = {stt_ctpdh++,pdh.getmaNH(),pdh.getMaSP(),pdh.getTenSP(),pdh.getSoLuong()};
			tableModelTTSP.addRow(row);
		}
	}
}
