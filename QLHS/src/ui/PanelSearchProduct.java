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
import javax.swing.table.JTableHeader;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
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
	private JButton btnRefresh;
	private JButton btnSearch;
	private JLabel lbllNXB;
	private JLabel lbllDanhMuc;
	private JLabel lbllTacGia;
	private JLabel lbllTenSach;
	private JButton btnTroVe;
	private JLabel lbllTimSach;
	private String maSachCl,tenSachcl,tenTGcl,danhMuccl,nhaXBcl,namXBcl,soLuongcl,donGiaMuacl,donGiaBancl;
	
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
		
		lbllTimSach = new JLabel("Tìm Sách");
		lbllTimSach.setForeground(new Color(0, 255, 0));
		lbllTimSach.setHorizontalAlignment(SwingConstants.CENTER);
		lbllTimSach.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lbllTimSach.setBounds(125, 0, 1327, 96);
		panelTitle.add(lbllTimSach);
		
		btnTroVe = new JButton("Trở Về");
		btnTroVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				panelProduct.setVisible(true);
			}
		});
		btnTroVe.setForeground(new Color(0, 255, 0));
		btnTroVe.setBackground(null);
		btnTroVe.setBorderPainted(false);
		btnTroVe.setOpaque(false);
		btnTroVe.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTroVe.setBounds(0, 31, 115, 48);
		btnTroVe.setIcon(new ImageIcon(img_back));
		panelTitle.add(btnTroVe);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 114, 1534, 176);
		add(panel);
		panel.setLayout(null);
		
		lbllTenSach = new JLabel("Tên Sách");
		lbllTenSach.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTenSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTenSach.setBounds(30, 22, 115, 29);
		panel.add(lbllTenSach);
		
		txtTenSach = new JTextField();
		txtTenSach.setBounds(160, 24, 160, 26);
		panel.add(txtTenSach);
		txtTenSach.setColumns(10);
		
		lbllTacGia = new JLabel("Tác Giả");
		lbllTacGia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTacGia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTacGia.setBounds(366, 22, 115, 29);
		panel.add(lbllTacGia);
		
		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(491, 25, 177, 26);
		panel.add(txtTacGia);
		
		lbllDanhMuc = new JLabel("Danh Mục");
		lbllDanhMuc.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllDanhMuc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllDanhMuc.setBounds(695, 21, 131, 29);
		panel.add(lbllDanhMuc);
		
		txtDanhMuc = new JTextField();
		txtDanhMuc.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDanhMuc.setColumns(10);
		txtDanhMuc.setBounds(844, 23, 177, 28);
		panel.add(txtDanhMuc);
		
		lbllNXB = new JLabel("Nhà Xuất Bản");
		lbllNXB.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllNXB.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllNXB.setBounds(1105, 22, 160, 29);
		panel.add(lbllNXB);
		
		txtNXB = new JTextField();
		txtNXB.setColumns(10);
		txtNXB.setBounds(1286, 25, 188, 26);
		panel.add(txtNXB);
		
		btnSearch = new JButton("Tìm");
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
		btnSearch.setBounds(556, 104, 160, 40);
		panel.add(btnSearch);
		
		btnRefresh = new JButton("Làm Mới");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btnRefresh.setBackground(new Color(240, 128, 128));
		btnRefresh.setForeground(new Color(0, 191, 255));
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setIcon(new ImageIcon(img_update));
		btnRefresh.setBounds(840, 104, 181, 40);
		panel.add(btnRefresh);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 320, 1534, 636);
		add(panel_1);
		panel_1.setLayout(null);

		table = new JTable();
		JTableHeader header = table.getTableHeader();
		
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int n = header.columnAtPoint(e.getPoint());
				System.out.println("CLicked in " +n);
				listsp = new DanhSachSanPham();
				daosp = new DAO_SanPham();
				listsp = daosp.getAllCondiTion(n);
				row = new Object[9];
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
					model.addRow(row);
				}
			}
		});
		String[] column = {"Mã Sách","Tên Sách","Tên Tác Giả","Danh Mục","Nhà XB","năm XB","Số Lượng","Đơn Giá Mua","Đơn Giá Bán"};
		model = new DefaultTableModel(column,0);
		model.setColumnIdentifiers(column);
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 0, 1534, 663);
		
		scrollPane.setViewportView(table);
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
	public void refreshLocale(String cs1,String cs2) {
		Locale locale = new Locale(cs1, cs2);
		ResourceBundle rd = ResourceBundle.getBundle("resources.content",locale);
		btnTroVe.setText(rd.getString("troVe"));
		lbllTimSach.setText(rd.getString("timsach"));
		lbllTenSach.setText(rd.getString("tenSach"));
		lbllTacGia.setText(rd.getString("tacGia"));
		lbllDanhMuc.setText(rd.getString("danhMuc"));
		lbllNXB.setText(rd.getString("NXB"));
		btnSearch.setText(rd.getString("tim"));
		btnRefresh.setText(rd.getString("lammoi"));
		
		 maSachCl=rd.getString("maSach");
		 tenSachcl=rd.getString("tenSach");
		 tenTGcl=rd.getString("tacGia");
		 danhMuccl=rd.getString("danhMuc");
		 nhaXBcl=rd.getString("NXB");
		 namXBcl=rd.getString("namXB");
		 soLuongcl=rd.getString("soluong");
		 donGiaMuacl=rd.getString("donGiaMua");
		 donGiaBancl=rd.getString("donGiaBan");
		 model = (DefaultTableModel) table.getModel();
		 String[] column = {maSachCl,tenSachcl,tenTGcl,danhMuccl,nhaXBcl,namXBcl,soLuongcl,donGiaMuacl,donGiaBancl};
		 model.setColumnIdentifiers(column);
	}
}
