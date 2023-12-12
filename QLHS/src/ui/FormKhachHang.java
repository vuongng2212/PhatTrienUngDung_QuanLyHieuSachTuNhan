package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_SanPham;
import entity.SanPham;
import list.DanhSachSanPham;

public class FormKhachHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormKhachHang frame = new FormKhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormKhachHang() {
		listsp = new DanhSachSanPham();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		setTitle("Tìm sách");
		setSize(1936,1056);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 1936,1056);
		
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(255, 165, 0));
		panelTitle.setBounds(0, 0, 1920, 96);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblTimSach = new JLabel("Tìm Sách");
		lblTimSach.setForeground(new Color(0, 255, 0));
		lblTimSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimSach.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTimSach.setBounds(0, 0, 1910, 96);
		panelTitle.add(lblTimSach);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(new Color(255, 165, 0));
		panelSearch.setBounds(0, 114, 1920, 176);
		contentPane.add(panelSearch);
		panelSearch.setLayout(null);
		
		JLabel lbllTenSach = new JLabel("Tên Sách");
		lbllTenSach.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTenSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTenSach.setBounds(181, 22, 85, 29);
		panelSearch.add(lbllTenSach);
		
		txtTenSach = new JTextField();
		txtTenSach.setBounds(276, 23, 160, 30);
		panelSearch.add(txtTenSach);
		txtTenSach.setColumns(10);
		
		JLabel lblNXB = new JLabel("Nhà xuất bản");
		lblNXB.setHorizontalAlignment(SwingConstants.CENTER);
		lblNXB.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNXB.setBounds(1029, 22, 98, 29);
		panelSearch.add(lblNXB);
		
		JLabel lbllDanhMuc = new JLabel("Danh Mục");
		lbllDanhMuc.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllDanhMuc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllDanhMuc.setBounds(558, 22, 106, 29);
		panelSearch.add(lbllDanhMuc);
		
		lblNamXB = new JLabel("Năm Xuất Bản");
		lblNamXB.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNamXB.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNamXB.setBounds(1429, 22, 131, 29);
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
		btnSearch.setBounds(750, 104, 119, 40);
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
		btnRefresh.setBounds(1070, 104, 140, 40);
		panelSearch.add(btnRefresh);
		
		cbDM = new JComboBox();
		cbDM.setBounds(674, 23, 130, 30);
		panelSearch.add(cbDM);
		
		cbNhaXB = new JComboBox();
		cbNhaXB.setBounds(1137, 23, 130, 30);
		panelSearch.add(cbNhaXB);
		
		cbNamXB = new JComboBox();
		cbNamXB.setBounds(1570, 23, 130, 30);
		panelSearch.add(cbNamXB);
		
		cbDM.addItem("");
		cbNhaXB.addItem("");
		cbNamXB.addItem("");
		
		JPanel tblPanel = new JPanel();
		tblPanel.setBounds(0, 320, 1920, 695);
		contentPane.add(tblPanel);
		tblPanel.setLayout(null);

		String[] headers = {"STT","Mã Sách","Tên Sách","Tên Tác Giả","Danh Mục","Nhà XB","năm XB","Số Lượng","Đơn Giá"};
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 1920, 696);
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
