package ui;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_KhachHang;
import entity.KhachHang;
import list.DanhSachKhachHang;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class PanelCustomer extends JPanel {
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private TableCustom tableCustom = new TableCustom();
	private JTable table;
	private Image img_title = new ImageIcon(frmNV.class.getResource("/image/search.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private Image img_reload = new ImageIcon(frmNV.class.getResource("/image/reload.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private Image img_refresh = new ImageIcon(frmNV.class.getResource("/image/refreshSP.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	
	public PanelCRUDKHang crudkHang;
	
	private JTable table_1;
	private DefaultTableModel model;
	private DanhSachKhachHang listKH;
	private DAO_KhachHang daoKh = new DAO_KhachHang();
	private Object[] row;
	
	public PanelCustomer() {
		listKH = new DanhSachKhachHang();
		row = new Object[5];
//		Object[] column = {"Mã Khách Hàng","Tên Khách Hàng","Số Điện Thoại","Địa Chỉ","Loại Khách Hàng"};
//		model.setColumnIdentifiers(column);
//		table.setModel(model);
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		listKH = daoKh.getAll();
		
		this.setVisible(false);
		setBounds(0,0,1534,1017);
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(255, 165, 0));
		panelTitle.setBounds(0, 0, 1534, 58);
		add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lbllTItle = new JLabel("Tìm Kiếm Khách Hàng");
		lbllTItle.setForeground(new Color(0, 255, 0));
		lbllTItle.setHorizontalAlignment(SwingConstants.CENTER);
		lbllTItle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lbllTItle.setBounds(0, 0, 1534, 58);
		panelTitle.add(lbllTItle);
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(new Color(255, 165, 0));
		panelContent.setBounds(0, 57, 1534, 960);
		add(panelContent);
		panelContent.setLayout(null);
		
		JPanel panelTimKiem = new JPanel();
		panelTimKiem.setBackground(new Color(100, 149, 237));
		panelTimKiem.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelTimKiem.setBounds(10, 44, 1514, 222);
		panelContent.add(panelTimKiem);
		panelTimKiem.setLayout(null);
		
		JLabel lbllMaKH = new JLabel("Mã Khách Hàng");
		lbllMaKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllMaKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllMaKH.setBounds(494, 24, 125, 41);
		panelTimKiem.add(lbllMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(629, 26, 239, 41);
		panelTimKiem.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lbllTenKH = new JLabel("Tên  Khách Hàng");
		lbllTenKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTenKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTenKH.setBounds(494, 76, 125, 41);
		panelTimKiem.add(lbllTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(629, 78, 239, 41);
		panelTimKiem.add(txtTenKH);
		
		JLabel lbllSDTKH = new JLabel("Số Điện Thoại");
		lbllSDTKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllSDTKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllSDTKH.setBounds(494, 139, 125, 41);
		panelTimKiem.add(lbllSDTKH);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(629, 141, 239, 41);
		panelTimKiem.add(txtSDT);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm Khách Hàng");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtMaKH.getText().equals("") && txtTenKH.getText().equals("") && txtSDT.getText().equals("")) {
					
//					System.out.println("Bat dau");
//					System.out.println(i);
//					for (KhachHang kh : listKH.getList()) {
//						System.out.println(kh.toString());
//					}
//					listKH = daoKh.getAll();
					int i = listKH.timKHTheoMa(txtMaKH.getText());
//					System.out.println(listKH.getList().get(i).toString());
					System.out.println(i);
					if(i!=-1) {
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
						
						row[0] = listKH.getList().get(i).getMaKH();
						row[1] = listKH.getList().get(i).getTenKH();
						row[2] = listKH.getList().get(i).getSdt();
						row[3] = listKH.getList().get(i).getDiaChi();
						row[4] = listKH.getList().get(i).getLoaiKH();
						model.addRow(row);
					}
				}
				if(txtMaKH.getText().equals("") && !txtTenKH.getText().equals("") && txtSDT.getText().equals("")) {
					
					ArrayList<KhachHang> listkhTemp = listKH.timKHTheoTen(txtTenKH.getText());
					
					if(listkhTemp.size()!=0) {
						System.out.println("ahiih");
						System.out.println(listkhTemp.size());
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
						
						for (KhachHang khachHang : listkhTemp) {
							
							row[0] = khachHang.getMaKH();
							row[1] = khachHang.getTenKH();
							row[2] = khachHang.getSdt();
							row[3] = khachHang.getDiaChi();
							row[4] = khachHang.getLoaiKH();
							model.addRow(row);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Khong tim thay ");
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
					}
				}
				if(txtMaKH.getText().equals("") && txtTenKH.getText().equals("") && !txtSDT.getText().equals(e)) {
					int i = listKH.timKHTheoSDT(txtSDT.getText());
					System.out.println(i);
					if(i!=-1) {
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
						
						row[0] = listKH.getList().get(i).getMaKH();
						row[1] = listKH.getList().get(i).getTenKH();
						row[2] = listKH.getList().get(i).getSdt();
						row[3] = listKH.getList().get(i).getDiaChi();
						row[4] = listKH.getList().get(i).getLoaiKH();
						model.addRow(row);
					}else {
						JOptionPane.showMessageDialog(null, "Khong tim thay ");
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
					}
				}
			}
		});
		btnTimKiem.setBackground(new Color(0, 255, 255));
		btnTimKiem.setIcon(new ImageIcon(img_title));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTimKiem.setBounds(960, 24, 239, 41);
		panelTimKiem.add(btnTimKiem);
		
		JButton btnCapNhat = new JButton("Cập Nhật Khách Hàng");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				crudkHang.setVisible(true);
			}
		});
		btnCapNhat.setForeground(new Color(255, 255, 255));
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCapNhat.setBackground(new Color(75, 0, 130));
		btnCapNhat.setBounds(960, 76, 239, 41);
		btnCapNhat.setIcon(new ImageIcon(img_reload));
		panelTimKiem.add(btnCapNhat);
		
		JButton BtnRefresh = new JButton("Tạo Mới");
		BtnRefresh.setIcon(new ImageIcon(img_refresh));
		BtnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		BtnRefresh.setForeground(new Color(0, 0, 0));
		BtnRefresh.setFont(new Font("Tahoma", Font.BOLD, 15));
		BtnRefresh.setBackground(new Color(175, 238, 238));
		BtnRefresh.setBounds(960, 139, 239, 41);
		panelTimKiem.add(BtnRefresh);
		
		JLabel lbllTimKiem = new JLabel("Tìm Kiếm Khách Hàng");
		lbllTimKiem.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbllTimKiem.setForeground(new Color(165, 42, 42));
		lbllTimKiem.setBounds(10, 0, 194, 40);
		panelContent.add(lbllTimKiem);
		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(new Color(255, 165, 0));
		panelTable.setBounds(0, 307, 1534, 627);
		panelTable.setLayout(null);
		tableCustom.setBounds(1532, 373, -1533, -368);
		DefaultTableModel mode = (DefaultTableModel) tableCustom.getModel();		
		panelContent.add(panelTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 1514, 627);
		panelTable.add(scrollPane);
		
		table_1 = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Mã Khách Hàng","Tên Khách Hàng","Số Điện Thoại","Địa Chỉ","Loại Khách Hàng"};
		Object[] row = new Object[5];
		model.setColumnIdentifiers(column);
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);
		table_1.setBackground(SystemColor.activeCaptionBorder);
		
		for (KhachHang kh : listKH.getList()) {
			row[0] = kh.getMaKH();
			row[1] = kh.getTenKH();
			row[2] = kh.getSdt();
			row[3] = kh.getDiaChi();
			row[4] = kh.getLoaiKH();
			model.addRow(row);
		}
	}
	public void refresh() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		daoKh = new DAO_KhachHang();
		listKH = new DanhSachKhachHang();
		listKH = daoKh.getAll();
		model = (DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for (KhachHang kh : listKH.getList()) {
			row[0] = kh.getMaKH();
			row[1] = kh.getTenKH();
			row[2] = kh.getSdt();
			row[3] = kh.getDiaChi();
			row[4] = kh.getLoaiKH();
			model.addRow(row);
		}
	
	}
}
