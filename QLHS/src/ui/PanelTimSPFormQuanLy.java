package ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_SanPham;
import entity.KhachHang;
import entity.SanPham;
import list.DanhSachSanPham;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PanelTimSPFormQuanLy extends JPanel {
	private JTextField txtTenSach;
	private JTable table;
	private DefaultTableModel tableModel;
	private Image img_update = new ImageIcon(frmNV.class.getResource("/image/reload.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private Image img_search = new ImageIcon(frmNV.class.getResource("/image/search.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private Image img_back = new ImageIcon(frmNV.class.getResource("/image/backing.png")).getImage().getScaledInstance(28, 28,Image.SCALE_SMOOTH );
	public panelProduct panelProduct;
	private DanhSachSanPham listsp;
	private DAO_SanPham DAO_SP;
	private JLabel lblNamXB;
	private JComboBox cbDM,cbNamXB,cbNhaXB;
	private int stt =1;
	public PanelTimSPFormQuanLy() {
		listsp = new DanhSachSanPham();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		setBounds(0, 200, 1920, 816);
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(255, 165, 0));
		panelTitle.setBounds(0, 0, 1920, 96);
		add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm Sách");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(125, 0, 1920, 96);
		panelTitle.add(lblNewLabel);
		
		JButton btnBack = new JButton("Trở Về");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				panelProduct.setVisible(true);
			}
		});
		btnBack.setForeground(new Color(0, 255, 0));
		btnBack.setBackground(null);
		btnBack.setBorderPainted(false);
		btnBack.setOpaque(false);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(0, 31, 115, 48);
		btnBack.setIcon(new ImageIcon(img_back));
		panelTitle.add(btnBack);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(new Color(255, 165, 0));
		panelSearch.setBounds(0, 114, 1920, 176);
		add(panelSearch);
		panelSearch.setLayout(null);
		
		JLabel lbllTenSach = new JLabel("Tên Sách");
		lbllTenSach.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTenSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTenSach.setBounds(60, 22, 85, 29);
		panelSearch.add(lbllTenSach);
		
		txtTenSach = new JTextField();
		txtTenSach.setBounds(160, 24, 160, 30);
		panelSearch.add(txtTenSach);
		txtTenSach.setColumns(10);
		
		JLabel lblNXB = new JLabel("Nhà xuất bản");
		lblNXB.setHorizontalAlignment(SwingConstants.CENTER);
		lblNXB.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNXB.setBounds(814, 22, 98, 29);
		panelSearch.add(lblNXB);
		
		JLabel lbllDanhMuc = new JLabel("Danh Mục");
		lbllDanhMuc.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllDanhMuc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllDanhMuc.setBounds(410, 22, 106, 29);
		panelSearch.add(lbllDanhMuc);
		
		lblNamXB = new JLabel("Năm Xuất Bản");
		lblNamXB.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNamXB.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNamXB.setBounds(1134, 22, 131, 29);
		panelSearch.add(lblNamXB);
		
		JButton btnSearch = new JButton("Tìm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findSPByCondition();
			}
		});
		btnSearch.setBackground(new Color(240, 128, 128));
		btnSearch.setForeground(new Color(0, 128, 0));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.setIcon(new ImageIcon(img_search));
		btnSearch.setBounds(597, 104, 119, 40);
		panelSearch.add(btnSearch);
		
		JButton btnRefresh = new JButton("Làm Mới");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btnRefresh.setBackground(new Color(240, 128, 128));
		btnRefresh.setForeground(new Color(0, 191, 255));
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setIcon(new ImageIcon(img_update));
		btnRefresh.setBounds(840, 104, 119, 40);
		panelSearch.add(btnRefresh);
		
		cbDM = new JComboBox();
		cbDM.setBounds(526, 23, 130, 30);
		panelSearch.add(cbDM);
		
		cbNhaXB = new JComboBox();
		cbNhaXB.setBounds(922, 21, 130, 30);
		panelSearch.add(cbNhaXB);
		
		cbNamXB = new JComboBox();
		cbNamXB.setBounds(1275, 22, 130, 30);
		panelSearch.add(cbNamXB);
		
		cbDM.addItem("");
		cbNhaXB.addItem("");
		cbNamXB.addItem("");
		
		JPanel tblPanel = new JPanel();
		tblPanel.setBounds(0, 320, 1920, 496);
		add(tblPanel);
		tblPanel.setLayout(null);

		String[] headers = {"STT","Mã Sách","Tên Sách","Tên Tác Giả","Danh Mục","Nhà XB","năm XB","Số Lượng","Đơn Giá"};
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 1920, 496);
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(35);
		table.setAutoCreateRowSorter(true);
		tblPanel.add(scroll);
		
		refresh();
		
	}
	
	public void deleteAllDataJtable() {
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
		while(dm.getRowCount() > 0)
		{
		    dm.removeRow(0);
		}
	}
	private void refresh() {
		deleteAllDataJtable();
		DAO_SP = new DAO_SanPham();

		listsp.clear();
		stt =1;
		for(SanPham sp: DAO_SP.getAll().getListData()) {
			listsp.add(sp);
			if(((DefaultComboBoxModel)cbDM.getModel()).getIndexOf(sp.getDanhMuc()) == -1) {
				cbDM.addItem(sp.getDanhMuc());
			}
			if(((DefaultComboBoxModel)cbNamXB.getModel()).getIndexOf(sp.getNamXB()) == -1) {
				cbNamXB.addItem(sp.getNamXB());
			}
			if(((DefaultComboBoxModel)cbNhaXB.getModel()).getIndexOf(sp.getNhaXB()) == -1) {
				cbNhaXB.addItem(sp.getNhaXB());
			}
			Object row[] = {stt++,sp.getMaSP(),sp.getTenSP(),sp.getTenTG(),sp.getDanhMuc(),sp.getNhaXB(),sp.getNamXB(),sp.getSoLuong(),sp.getDonGiaMua()};
			tableModel.addRow(row);
			
		}
	}
	public void findSPByCondition() {
		deleteAllDataJtable();
		DAO_SP = new DAO_SanPham();

		listsp.clear();
		stt =1;
		String dm = cbDM.getSelectedItem().toString();
		String nhaXB = cbNhaXB.getSelectedItem().toString();
		String namXB = cbNamXB.getSelectedItem().toString();
		for(SanPham sp: DAO_SP.findSP(txtTenSach.getText(),dm,nhaXB,namXB)) {
			listsp.add(sp);
			Object row[] = {stt++,sp.getMaSP(),sp.getTenSP(),sp.getDanhMuc(),sp.getNhaXB(),sp.getNamXB(),sp.getSoLuong(),sp.getDonGiaMua()};
			tableModel.addRow(row);
			
		}
	}
}
