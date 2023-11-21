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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PanelSearchProduct extends JPanel {
	private JTextField txtTenSach;
	private JTextField txtTacGia;
	private JTextField txtDanhMuc;
	private JTextField txtNXB;
	
	private Image img_update = new ImageIcon(frmNV.class.getResource("/image/reload.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private Image img_search = new ImageIcon(frmNV.class.getResource("/image/search.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private Image img_back = new ImageIcon(frmNV.class.getResource("/image/backing.png")).getImage().getScaledInstance(28, 28,Image.SCALE_SMOOTH );
	public panelProduct panelProduct;
	private JTable table;
	private DefaultTableModel model;
	private DanhSachSanPham listsp;
	private DAO_SanPham daosp;
	private Object[] row;
	
	public PanelSearchProduct() {
		daosp = new DAO_SanPham();
		listsp = new DanhSachSanPham();
		row = new Object[9];
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		listsp = daosp.getAll();
		
		
		setBounds(0,0,1534,956);
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(255, 165, 0));
		panelTitle.setBounds(0, 0, 1534, 96);
		add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm Sách");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(125, 0, 1327, 96);
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 114, 1534, 176);
		add(panel);
		panel.setLayout(null);
		
		JLabel lbllTenSach = new JLabel("Tên Sách");
		lbllTenSach.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTenSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTenSach.setBounds(60, 22, 85, 29);
		panel.add(lbllTenSach);
		
		txtTenSach = new JTextField();
		txtTenSach.setBounds(160, 24, 160, 26);
		panel.add(txtTenSach);
		txtTenSach.setColumns(10);
		
		JLabel lbllTacGia = new JLabel("Tác Giả");
		lbllTacGia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTacGia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTacGia.setBounds(383, 22, 98, 29);
		panel.add(lbllTacGia);
		
		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(491, 25, 177, 26);
		panel.add(txtTacGia);
		
		JLabel lbllDanhMuc = new JLabel("Danh Mục");
		lbllDanhMuc.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllDanhMuc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllDanhMuc.setBounds(720, 21, 106, 29);
		panel.add(lbllDanhMuc);
		
		txtDanhMuc = new JTextField();
		txtDanhMuc.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDanhMuc.setColumns(10);
		txtDanhMuc.setBounds(844, 23, 177, 28);
		panel.add(txtDanhMuc);
		
		JLabel lbllNXB = new JLabel("Nhà Xuất Bản");
		lbllNXB.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllNXB.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllNXB.setBounds(1134, 22, 131, 29);
		panel.add(lbllNXB);
		
		txtNXB = new JTextField();
		txtNXB.setColumns(10);
		txtNXB.setBounds(1286, 25, 188, 26);
		panel.add(txtNXB);
		
		JButton btnSearch = new JButton("Tìm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listsp = daosp.getAll();
				
				if(!txtTenSach.getText().equals("") && txtTacGia.getText().equals("") && txtDanhMuc.getText().equals("") && txtNXB.getText().equals("")) {
					
					ArrayList<SanPham>listTemp = listsp.timSPTheoTenSach(txtTenSach.getText());
					 if(listTemp.size()!=0) {
						 DefaultTableModel model =(DefaultTableModel) table.getModel();
						 model.setRowCount(0);
							for (SanPham sp : listTemp) {
								row[0] = sp.getMaSP();
								row[1] = sp.getTenSP();
								row[2] = sp.getTenTG();
								row[3] = sp.getDanhMuc();
								row[4] = sp.getNhaXB();
								row[5] = sp.getNamXB();
								row[6] = sp.getSoLuong();
								row[7] = sp.getDonGiaGoc();
								row[8] = sp.getDonGiaMua();
//								row[9] = sp.getTinhTrang();
								model.addRow(row);
							}
					 }
				}else if(txtTenSach.getText().equals("") && !txtTacGia.getText().equals("") && txtDanhMuc.getText().equals("") && txtNXB.getText().equals("")){
					ArrayList<SanPham>listTemp = listsp.timSPTheoTacGia(txtTacGia.getText());
					 if(listTemp.size()!=0) {
						 DefaultTableModel model =(DefaultTableModel) table.getModel();
						 model.setRowCount(0);
							for (SanPham sp : listTemp) {
								row[0] = sp.getMaSP();
								row[1] = sp.getTenSP();
								row[2] = sp.getTenTG();
								row[3] = sp.getDanhMuc();
								row[4] = sp.getNhaXB();
								row[5] = sp.getNamXB();
								row[6] = sp.getSoLuong();
								row[7] = sp.getDonGiaGoc();
								row[8] = sp.getDonGiaMua();
//								row[9] = sp.getTinhTrang();
								model.addRow(row);
							}
					 }
				}else if(txtTenSach.getText().equals("") && txtTacGia.getText().equals("") && !txtDanhMuc.getText().equals("") && txtNXB.getText().equals("")) {
					System.out.println("danh muc");
					ArrayList<SanPham>listTemp = listsp.timSPTheoDanhMuc(txtDanhMuc.getText());
					 if(listTemp.size()!=0) {
						 DefaultTableModel model =(DefaultTableModel) table.getModel();
						 model.setRowCount(0);
							for (SanPham sp : listTemp) {
								row[0] = sp.getMaSP();
								row[1] = sp.getTenSP();
								row[2] = sp.getTenTG();
								row[3] = sp.getDanhMuc();
								row[4] = sp.getNhaXB();
								row[5] = sp.getNamXB();
								row[6] = sp.getSoLuong();
								row[7] = sp.getDonGiaGoc();
								row[8] = sp.getDonGiaMua();
//								row[9] = sp.getTinhTrang();
								model.addRow(row);
							}
					 }
				}else if(txtTenSach.getText().equals("") && txtTacGia.getText().equals("") && txtDanhMuc.getText().equals("") && !txtNXB.getText().equals("")) {
					ArrayList<SanPham>listTemp = listsp.timSPTheoNhaXB(txtNXB.getText());
					 if(listTemp.size()!=0) {
						 DefaultTableModel model =(DefaultTableModel) table.getModel();
						 model.setRowCount(0);
							for (SanPham sp : listTemp) {
								row[0] = sp.getMaSP();
								row[1] = sp.getTenSP();
								row[2] = sp.getTenTG();
								row[3] = sp.getDanhMuc();
								row[4] = sp.getNhaXB();
								row[5] = sp.getNamXB();
								row[6] = sp.getSoLuong();
								row[7] = sp.getDonGiaGoc();
								row[8] = sp.getDonGiaMua();
//								row[9] = sp.getTinhTrang();
								model.addRow(row);
							}
					 }
				}else if(!txtTenSach.getText().equals("") && !txtTacGia.getText().equals("") && txtDanhMuc.getText().equals("") && txtNXB.getText().equals("")) {
					ArrayList<SanPham>listTemp = listsp.timSPTheoTenSachVaTgia(txtTenSach.getText(), txtTacGia.getText());
					 if(listTemp.size()!=0) {
						 DefaultTableModel model =(DefaultTableModel) table.getModel();
						 model.setRowCount(0);
							for (SanPham sp : listTemp) {
								row[0] = sp.getMaSP();
								row[1] = sp.getTenSP();
								row[2] = sp.getTenTG();
								row[3] = sp.getDanhMuc();
								row[4] = sp.getNhaXB();
								row[5] = sp.getNamXB();
								row[6] = sp.getSoLuong();
								row[7] = sp.getDonGiaGoc();
								row[8] = sp.getDonGiaMua();
//								row[9] = sp.getTinhTrang();
								model.addRow(row);
							}
					 }
				}else if(!txtTenSach.getText().equals("") && txtTacGia.getText().equals("") && !txtDanhMuc.getText().equals("") && txtNXB.getText().equals("")) {
					ArrayList<SanPham>listTemp = listsp.timSPTheoTenSachVaDanhMuc(txtTenSach.getText(), txtDanhMuc.getText());
					 if(listTemp.size()!=0) {
						 DefaultTableModel model =(DefaultTableModel) table.getModel();
						 model.setRowCount(0);
							for (SanPham sp : listTemp) {
								row[0] = sp.getMaSP();
								row[1] = sp.getTenSP();
								row[2] = sp.getTenTG();
								row[3] = sp.getDanhMuc();
								row[4] = sp.getNhaXB();
								row[5] = sp.getNamXB();
								row[6] = sp.getSoLuong();
								row[7] = sp.getDonGiaGoc();
								row[8] = sp.getDonGiaMua();
//								row[9] = sp.getTinhTrang();
								model.addRow(row);
							}
					 }
				}else if(!txtTenSach.getText().equals("") && txtTacGia.getText().equals("") && txtDanhMuc.getText().equals("") && !txtNXB.getText().equals("")) {
					ArrayList<SanPham>listTemp = listsp.timSPTheoTenSachVaNXB(txtTenSach.getText(), txtNXB.getText());
					 if(listTemp.size()!=0) {
						 DefaultTableModel model =(DefaultTableModel) table.getModel();
						 model.setRowCount(0);
							for (SanPham sp : listTemp) {
								row[0] = sp.getMaSP();
								row[1] = sp.getTenSP();
								row[2] = sp.getTenTG();
								row[3] = sp.getDanhMuc();
								row[4] = sp.getNhaXB();
								row[5] = sp.getNamXB();
								row[6] = sp.getSoLuong();
								row[7] = sp.getDonGiaGoc();
								row[8] = sp.getDonGiaMua();
//								row[9] = sp.getTinhTrang();
								model.addRow(row);
							}
					 }
				}else if(!txtTenSach.getText().equals("") && !txtTacGia.getText().equals("") && !txtDanhMuc.getText().equals("") && txtNXB.getText().equals("")) {
					ArrayList<SanPham>listTemp = listsp.timSPTheoTenSachvaTacGiaVaDanhMuc(txtTenSach.getText(), txtTacGia.getText(),txtDanhMuc.getText());
					 if(listTemp.size()!=0) {
						 DefaultTableModel model =(DefaultTableModel) table.getModel();
						 model.setRowCount(0);
							for (SanPham sp : listTemp) {
								row[0] = sp.getMaSP();
								row[1] = sp.getTenSP();
								row[2] = sp.getTenTG();
								row[3] = sp.getDanhMuc();
								row[4] = sp.getNhaXB();
								row[5] = sp.getNamXB();
								row[6] = sp.getSoLuong();
								row[7] = sp.getDonGiaGoc();
								row[8] = sp.getDonGiaMua();
//								row[9] = sp.getTinhTrang();
								model.addRow(row);
							}
					 }
				}else if(!txtTenSach.getText().equals("") && !txtTacGia.getText().equals("") && txtDanhMuc.getText().equals("") && !txtNXB.getText().equals("")) {
					ArrayList<SanPham>listTemp = listsp.timSPTheoTenSachvaTacGiaVaNXB(txtTenSach.getText(), txtTacGia.getText(),txtNXB.getText());
					 if(listTemp.size()!=0) {
						 DefaultTableModel model =(DefaultTableModel) table.getModel();
						 model.setRowCount(0);
							for (SanPham sp : listTemp) {
								row[0] = sp.getMaSP();
								row[1] = sp.getTenSP();
								row[2] = sp.getTenTG();
								row[3] = sp.getDanhMuc();
								row[4] = sp.getNhaXB();
								row[5] = sp.getNamXB();
								row[6] = sp.getSoLuong();
								row[7] = sp.getDonGiaGoc();
								row[8] = sp.getDonGiaMua();
//								row[9] = sp.getTinhTrang();
								model.addRow(row);
							}
					 }
				}else if(!txtTenSach.getText().equals("") && txtTacGia.getText().equals("") && !txtDanhMuc.getText().equals("") && !txtNXB.getText().equals("")) {
					ArrayList<SanPham>listTemp = listsp.timSPTheoTenSachvaDanhMucVaNXB(txtTenSach.getText(), txtDanhMuc.getText(),txtNXB.getText());
					 if(listTemp.size()!=0) {
						 DefaultTableModel model =(DefaultTableModel) table.getModel();
						 model.setRowCount(0);
							for (SanPham sp : listTemp) {
								row[0] = sp.getMaSP();
								row[1] = sp.getTenSP();
								row[2] = sp.getTenTG();
								row[3] = sp.getDanhMuc();
								row[4] = sp.getNhaXB();
								row[5] = sp.getNamXB();
								row[6] = sp.getSoLuong();
								row[7] = sp.getDonGiaGoc();
								row[8] = sp.getDonGiaMua();
//								row[9] = sp.getTinhTrang();
								model.addRow(row);
							}
					 }
				}else if(!txtTenSach.getText().equals("") && !txtTacGia.getText().equals("") && !txtDanhMuc.getText().equals("") && !txtNXB.getText().equals("")) {
					ArrayList<SanPham>listTemp = listsp.timSPTheoTenSachvaTacGiavaDanhMucVaNXB(txtTenSach.getText(),txtTacGia.getText(), txtDanhMuc.getText(),txtNXB.getText());
					 if(listTemp.size()!=0) {
						 DefaultTableModel model =(DefaultTableModel) table.getModel();
						 model.setRowCount(0);
							for (SanPham sp : listTemp) {
								row[0] = sp.getMaSP();
								row[1] = sp.getTenSP();
								row[2] = sp.getTenTG();
								row[3] = sp.getDanhMuc();
								row[4] = sp.getNhaXB();
								row[5] = sp.getNamXB();
								row[6] = sp.getSoLuong();
								row[7] = sp.getDonGiaGoc();
								row[8] = sp.getDonGiaMua();
//								row[9] = sp.getTinhTrang();
								model.addRow(row);
							}
					 }
				}else {
					JOptionPane.showMessageDialog(null, "Khong tim thay");					
				}
			}
		});
		btnSearch.setBackground(new Color(240, 128, 128));
		btnSearch.setForeground(new Color(0, 128, 0));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.setIcon(new ImageIcon(img_search));
		btnSearch.setBounds(597, 104, 119, 40);
		panel.add(btnSearch);
		
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
		panel.add(btnRefresh);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 320, 1534, 636);
		add(panel_1);
		panel_1.setLayout(null);

		table = new JTable();
		String[] column = {"Mã Sách","Tên Sách","Tên Tác Giả","Danh Mục","Nhà XB","năm XB","Số Lượng","Đơn Giá Mua","Đơn Giá Bán"};
		model = new DefaultTableModel(column,0);
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 0, 1534, 663);
		scrollPane.setViewportView(table = new JTable(model));
		table.setRowHeight(25);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		//
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(8).setPreferredWidth(150);
//		table.getColumnModel().getColumn(9).setPreferredWidth(150);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		panel_1.add(scrollPane);
		refresh();
		
	}
	public void refresh() {
		listsp = daosp.getAll();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		for (SanPham sp : listsp.getList()) {
			row[0] = sp.getMaSP();
			row[1] = sp.getTenSP();
			row[2] = sp.getTenTG();
			row[3] = sp.getDanhMuc();
			row[4] = sp.getNhaXB();
			row[5] = sp.getNamXB();
			row[6] = sp.getSoLuong();
			row[7] = sp.getDonGiaGoc();
			row[8] = sp.getDonGiaMua();
//			row[9] = sp.getTinhTrang();
			model.addRow(row);
		}
		txtDanhMuc.setText("");
		txtNXB.setText("");
		txtTacGia.setText("");
		txtTenSach.setText("");
	}
}
