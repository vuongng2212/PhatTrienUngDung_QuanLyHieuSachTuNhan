package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import connectDB.ConnectDB;
import dao.DAO_ChiTietHoaDon;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_KhuyenMai;
import dao.DAO_SanPham;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.SanPham;
import list.DanhSachChiTietHoaDon;
import list.DanhSachHoaDon;
import list.DanhSachKhachHang;
import list.DanhSachKhuyenMai;
import list.DanhSachSanPham;

import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class panelBanHang extends JPanel {
	private Image img_title = new ImageIcon(frmNV.class.getResource("/image/pluss.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	public JTextField txtMaSP;
	public JTextField txtMaKH;
	public JTextField txtSDT;
	public JTextField txtLoaiKH;
	public JTextField txtTongTien;
	public JTextField txtTienNhan;
	public JTextField txtTenKH;
	public JTextField txtDiaChi;
	public JLabel lbllSoLuong;
	public JLabel lblTimKH;
	public JLabel lbllKH;
	public JLabel lblTnKhchHng;
	public JLabel lblSi;
	public JLabel lblaCh;
	public JLabel lbllLoai;
	public JLabel lbllTongTien;
	public JLabel lbllTienNhan;
	public JLabel lblTienTra;
	public JButton btnHuy;
	public JButton btnThanhToan;
	public JButton btnInHD;
	public JLabel lbllProduct;
	public JButton btnNewButton;
	public JButton btnLmMi;
	public JLabel lbllMaSach;
	private JButton btnSearch;
	private DefaultTableModel model;
	private Object[] row;
	public DialogAddSP dialogAddSp;
	public DialogAddKH dialogAddKH;
	public int soLuongSPTemp;
	public String tenSach;
	public double giaBan;
	private double tongTien;
	// Phần DAO của sản phẩm
	private DanhSachSanPham listSP;
	private DAO_SanPham daosp;
	
	// Phần DAO của hóa đơn
	private DanhSachHoaDon listHD;
	private DAO_HoaDon daoHD;
	//Phần DAO Của Khuyến Mãi
	private DanhSachKhuyenMai listKm;
	private DAO_KhuyenMai daokm;
	//Phần DAO của khách hàng
	private DanhSachKhachHang listkh;
	private DAO_KhachHang daokh;
	
	
	//Phần DAO của chi tiết hóa đơn
	private DanhSachChiTietHoaDon listCTHD;
	private DAO_ChiTietHoaDon daoCTHD;
	private JTextField txtSoLuong;
	private JLabel lblNewLabel_1;
	private JButton btnSa;
	private JButton btnXa;
	private JLabel lblNewLabel_2;
	private JTextField txtMaHD;
	private JButton btnNewButton_1;
	private JTable table;
	private JLabel lbllTienTra;
	
	
	
	
//	private ArrayList<SanPham>
	
	
	public panelBanHang() {
		
		DocumentListener documentListener = new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				calculateChange();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				calculateChange();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				calculateChange();
			}
		};
		
		
		soLuongSPTemp = 0;
		giaBan = 0;
		tenSach = "";
		tongTien = 0;
		listKm = new DanhSachKhuyenMai();
		daokm = new DAO_KhuyenMai();
		daokh = new DAO_KhachHang();
		listkh = new DanhSachKhachHang();
		dialogAddSp = new DialogAddSP();
		dialogAddKH = new DialogAddKH();
		listCTHD = new DanhSachChiTietHoaDon();
		daoCTHD = new DAO_ChiTietHoaDon();
		daosp = new DAO_SanPham();
		daoHD = new DAO_HoaDon();
		dialogAddSp = new DialogAddSP(this);
		dialogAddKH = new DialogAddKH(this);
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		listSP = daosp.getAll();
		listHD = daoHD.getAll();
		listCTHD = daoCTHD.getAll();
		
//		this.setVisible(false);
		setBounds(0,0,1534,956);
		setLayout(null);
		
		JPanel txtSach = new JPanel();
		txtSach.setBounds(0, 204, 1534, 70);
		txtSach.setBackground(new Color(102, 204, 255));
		add(txtSach);
		txtSach.setLayout(null);
		
		lbllProduct = new JLabel("Chọn Sách");
		lbllProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllProduct.setBounds(10, 11, 100, 23);
		txtSach.add(lbllProduct);
		
		txtMaSP = new JTextField();
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(290, 13, 63, 23);
		txtMaSP.setEditable(false);
		txtSach.add(txtMaSP);
		
		lbllMaSach = new JLabel("Mã Sách");
		lbllMaSach.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllMaSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllMaSach.setBounds(168, 11, 112, 23);
		txtSach.add(lbllMaSach);
		
		btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOpenFormButtonClick();
			}
		});
		btnSearch.setBounds(95, 9, 63, 33);
		btnSearch.setBackground(null);
		btnSearch.setOpaque(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setIcon(new ImageIcon(img_title));
		txtSach.add(btnSearch);
		
		lbllSoLuong = new JLabel("Số Lượng");
		lbllSoLuong.setBounds(488, 15, 85, 21);
		txtSach.add(lbllSoLuong);
		lbllSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnNewButton = new JButton("Thêm");
		btnNewButton.setBounds(804, 9, 112, 31);
		txtSach.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int discount = 0;
				if(!txtMaSP.getText().equalsIgnoreCase("")) {
					if(!txtMaSP.getText().equalsIgnoreCase("")){
						if(soLuongSPTemp > Integer.parseInt(txtSoLuong.getText())) {
							System.out.println("Được");
							if(daokm.ktraHienDangKhuyenMai(txtMaSP.getText())) {
								discount = daokm.discountSPDangKM(txtMaSP.getText());
								System.out.println(discount);
								model =(DefaultTableModel)table.getModel();
								row = new Object[6];
								row[0] = txtMaSP.getText();
								row[1] = tenSach;
								row[2] = txtSoLuong.getText();
								row[3] = giaBan;
								row[4] = discount;
								System.out.println("Gia Ban: " + giaBan);
								System.out.println("So luong: "+ txtSoLuong.getText());
								System.out.println("Discount: "+discount);
								double giaBanCrr = giaBan;
								int soLuong = Integer.parseInt(txtSoLuong.getText());
								double total = ((double)giaBanCrr*(double)soLuong - ((double)giaBanCrr*(double)soLuong)*((double)discount/100));
								System.out.println(total);
								System.out.println("ThanhTien:  "+ (giaBan*Integer.parseInt(txtSoLuong.getText()) - (giaBan * Integer.parseInt(txtSoLuong.getText()))*(discount/100)));
								row[5] = total;
								model.addRow(row);
//								tongTien+= giaBan*(Integer.parseInt(txtSoLuong.getText())) - ((discount/100)*(giaBan*(Integer.parseInt(txtSoLuong.getText()))));
								tongTien+=total;
								System.out.println(tongTien);
								txtTongTien.setText(String.format("%.2f", tongTien));
								JOptionPane.showMessageDialog(null, "Thêm Thành Công");
							}else {
								if(txtLoaiKH.getText().equalsIgnoreCase("TV"))
								{
									discount= 3;
									System.out.println("Thanh vienn!!!");
								}
								model =(DefaultTableModel)table.getModel();
								row = new Object[6];
								row[0] = txtMaSP.getText();
								row[1] = tenSach;
								row[2] = txtSoLuong.getText();
								row[3] = giaBan;
								row[4] = discount;
								double giaBanCrr = giaBan;
								int soLuong = Integer.parseInt(txtSoLuong.getText());
								double total = ((double)giaBanCrr*(double)soLuong - ((double)giaBanCrr*(double)soLuong)*((double)discount/100));
								System.out.println(total);
								System.out.println("ThanhTien:  "+ (giaBan*Integer.parseInt(txtSoLuong.getText()) - (giaBan * Integer.parseInt(txtSoLuong.getText()))*(discount/100)));
//								row[5] = total;
								System.out.println(total);
								row[5] = total;
								model.addRow(row);
								tongTien+=total;
								txtTongTien.setText(String.format("%.2f", tongTien));
								JOptionPane.showMessageDialog(null, "Thêm Thành Công");
							}
						txtMaSP.setText("");
						txtSoLuong.setText("");
						}else {
							JOptionPane.showMessageDialog(null, "Số Lượng vượt quá mức cho phép!");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Sách Trước");
					}
				}
				System.out.println("Thoat!!!");
			}
		});
		btnNewButton.setBackground(new Color(102, 204, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnLmMi = new JButton("Làm Mới");
		btnLmMi.setBounds(1214, 9, 121, 31);
		txtSach.add(btnLmMi);
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model =(DefaultTableModel) table.getModel();
				model.setRowCount(0);
			}
		});
		btnLmMi.setBackground(new Color(102, 204, 0));
		btnLmMi.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(583, 9, 42, 31);
		txtSach.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				DefaultTableModel  model = (DefaultTableModel)table.getModel();
				if(i>=0) {
					model.setValueAt(txtSoLuong.getText(), i, 2);
					JOptionPane.showMessageDialog(null, "Sửa Thành Công!!");
				}else {
					JOptionPane.showMessageDialog(null, "Chọn dòng cần xóa!!");
				}
			}
		});
		btnSa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSa.setBackground(new Color(102, 204, 0));
		btnSa.setBounds(934, 9, 112, 31);
		txtSach.add(btnSa);
		
		btnXa = new JButton("Xóa");
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXa.setBackground(new Color(102, 204, 0));
		btnXa.setBounds(1067, 9, 121, 31);
		txtSach.add(btnXa);
		String[] column = {"Mã Sách","Tên Sách","Tên Tác Giả","Danh Mục","Nhà XB","năm XB","Số Lượng","Đơn Giá","Tình Trạng","Khuyến Mãi"};
		
		DefaultTableModel model = new DefaultTableModel();
		
		
		DefaultTableModel model2 = new DefaultTableModel();
		model2.addColumn("Column 1");
		model2.addColumn("Column 1");
		model2.addColumn("Column 1");
		model2.addColumn("Column 1");
		model2.addColumn("Column 1");
		model2.addColumn("Column 1");
		model2.addColumn("Column 1");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 775, 1534, 181);
		add(panel_2);
		panel_2.setLayout(null);
		
		lbllTongTien = new JLabel("Tổng Tiền");
		lbllTongTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTongTien.setBounds(10, 40, 129, 38);
		panel_2.add(lbllTongTien);
		
		txtTongTien = new JTextField();
		txtTongTien.setBackground(new Color(255, 255, 255));
		txtTongTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTongTien.setBounds(116, 41, 154, 38);
		txtTongTien.setEditable(false);
		panel_2.add(txtTongTien);
		txtTongTien.setColumns(10);
		
		lbllTienNhan = new JLabel("Tiền Nhận");
		lbllTienNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTienNhan.setBounds(297, 40, 108, 38);
		panel_2.add(lbllTienNhan);
		
		txtTienNhan = new JTextField();
		txtTienNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
//		txtTienNhan.setEditable(false);
		txtTienNhan.setColumns(10);
		txtTienNhan.setBackground(new Color(255, 255, 255));
		txtTienNhan.setBounds(415, 41, 162, 38);

		panel_2.add(txtTienNhan);
		
		lblTienTra = new JLabel("Tiền Trả");
		lblTienTra.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTienTra.setBounds(640, 40, 111, 38);
		panel_2.add(lblTienTra);
		
		txtTienNhan.getDocument().addDocumentListener(documentListener);
		
		btnHuy = new JButton("Hủy Bỏ");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showOptionDialog(null,"Xác Nhận hủy bỏ", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				switch (option) {
				case JOptionPane.YES_OPTION:
					JOptionPane.showMessageDialog(null, "Xác nhận hủy bỏ");
					DefaultTableModel model =(DefaultTableModel) table.getModel();
					model.setRowCount(0);
					txtMaKH.setText("");
					txtTenKH.setText("");
					txtLoaiKH.setText("");
					txtSDT.setText("");
					txtDiaChi.setText("");
					txtMaSP.setText("");
					txtSoLuong.setText("");
					txtMaHD.setText("");
					break;

				default:
					break;
				}
			}
		});
		btnHuy.setBackground(new Color(255, 0, 0));
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHuy.setBounds(954, 40, 138, 38);
		panel_2.add(btnHuy);
		
		btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Double.parseDouble(lbllTienTra.getText())>0) {
					DefaultTableModel model =(DefaultTableModel) table.getModel();
					int sum = model.getRowCount();
					daosp = new DAO_SanPham();
					System.out.println(sum);
					HoaDon hd = new HoaDon();
					hd.setMaHD(txtMaHD.getText());
					hd.setMaNV("NV001");
					hd.setMaKH(txtMaKH.getText());
					hd.setNgayTaoHD(new Date());
					hd.setThanhTien(Double.parseDouble(txtTongTien.getText()));
					daoHD.add(hd);
					ChiTietHoaDon chHD = new ChiTietHoaDon();
					for(int i=0;i<sum;i++) {
						chHD.setMaHD(txtMaHD.getText());
						chHD.setMaSP(model.getValueAt(i, 0).toString());
						chHD.setSoLuong(Integer.parseInt(model.getValueAt(i, 2).toString()));
						chHD.setDonGia(Double.parseDouble(model.getValueAt(i, 3).toString()));
						chHD.setDiscount(Integer.parseInt(model.getValueAt(i, 4).toString()));
						daoCTHD.add(chHD);
						daosp.giamSoLuong(model.getValueAt(i, 0).toString(), Integer.parseInt(model.getValueAt(i, 2).toString()));
						
					}
					SimpleDateFormat dateformat = new SimpleDateFormat();
					
					
					JOptionPane.showMessageDialog(null,"Tạo Hóa Đơn Thành Công");
					txtMaHD.setText("");
					txtMaKH.setText("");
					txtMaSP.setText("");
					txtSoLuong.setText("");
					txtDiaChi.setText("");
					txtLoaiKH.setText("");
					txtSDT.setText("");
					txtTenKH.setText("");
					txtTongTien.setText("");
					txtTienNhan.setText("");
					lbllTienTra.setText("");
					//
					
				}else {
					JOptionPane.showMessageDialog(null, "Thất bại");
				}
				
			}
		});
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThanhToan.setBackground(new Color(102, 204, 0));
		btnThanhToan.setBounds(1112, 40, 138, 38);
		panel_2.add(btnThanhToan);
		
		btnInHD = new JButton("In Hóa Đơn");
		btnInHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInHD.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInHD.setBackground(new Color(102, 204, 0));
		btnInHD.setBounds(1270, 40, 154, 38);
		panel_2.add(btnInHD);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(748, 40, 154, 38);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		lbllTienTra = new JLabel("0");
		lbllTienTra.setHorizontalAlignment(SwingConstants.CENTER);
		lbllTienTra.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllTienTra.setBounds(0, 0, 154, 38);
		panel_1.add(lbllTienTra);
		
		lblTimKH = new JLabel("Chọn Khách Hàng");
		lblTimKH.setBounds(0, 61, 151, 28);
		add(lblTimKH);
		lblTimKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 87, 1534, 89);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm Khách Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 105, 26);
		panel.add(lblNewLabel);
		
		JButton btnSearchKH = new JButton("");
		btnSearchKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOpenFormKHButtonCLick();
			}
		});
		btnSearchKH.setIcon(new ImageIcon(img_title));
		btnSearchKH.setOpaque(false);
		btnSearchKH.setBorderPainted(false);
		btnSearchKH.setBackground((Color) null);
		btnSearchKH.setBounds(113, 11, 63, 26);
		panel.add(btnSearchKH);
		
		lbllKH = new JLabel("Mã Khách Hàng");
		lbllKH.setBounds(345, 12, 99, 25);
		panel.add(lbllKH);
		lbllKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(473, 15, 144, 20);
		txtMaKH.setEditable(false);
		panel.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		lblSi = new JLabel("Số Điện Thoại");
		lblSi.setBounds(345, 48, 99, 25);
		panel.add(lblSi);
		lblSi.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtSDT = new JTextField();
		txtSDT.setBounds(473, 51, 144, 20);
		panel.add(txtSDT);
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		
		lblTnKhchHng = new JLabel("Tên Khách Hàng");
		lblTnKhchHng.setBounds(754, 12, 125, 25);
		panel.add(lblTnKhchHng);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(889, 15, 166, 20);
		txtTenKH.setEditable(false);
		panel.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setBounds(754, 48, 120, 25);
		panel.add(lblaCh);
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(889, 51, 166, 20);
		txtDiaChi.setEditable(false);
		panel.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		lbllLoai = new JLabel("Loại Khách Hàng");
		lbllLoai.setBounds(1109, 12, 109, 25);
		panel.add(lbllLoai);
		lbllLoai.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtLoaiKH = new JTextField();
		txtLoaiKH.setBounds(1228, 11, 53, 30);
		txtLoaiKH.setEditable(false);
		panel.add(txtLoaiKH);
		txtLoaiKH.setBackground(new Color(255, 255, 255));
		txtLoaiKH.setEditable(false);
		txtLoaiKH.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Thêm Sách");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(0, 177, 132, 32);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Mã Hóa Đơn");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(0, 11, 96, 39);
		add(lblNewLabel_2);
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(106, 17, 60, 28);
		add(txtMaHD);
		txtMaHD.setColumns(10);
		
		btnNewButton_1 = new JButton("Tạo Hóa Đơn");
		btnNewButton_1.setBounds(337, 12, 132, 39);
		add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 273, 1534, 503);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int i = table.getSelectedRow();
				txtMaSP.setText(model.getValueAt(i, 0).toString());
				txtSoLuong.setText(model.getValueAt(i, 2).toString());
			}
		});
		String[] columnsp = {"Mã Sách","Tên Sách","Số Lượng","Giá Bán","Discount","Thành Tiền"};
		row = new Object[6];
		model.setColumnIdentifiers(columnsp);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
	private void onOpenFormButtonClick() {
//		SanPhamFrm spFrm = new SanPhamFrm();
//		spfrm.setKhuyenMai(this);
		dialogAddSp.banHang = this;
		dialogAddSp.setModal(true);
		dialogAddSp.setVisible(true);
		dialogAddSp.refresh();
	}
	private void onOpenFormKHButtonCLick() {
		dialogAddKH.banHang = this;
		dialogAddKH.setModal(true);
		dialogAddKH.setVisible(true);
	}
	public void onDataReturned(String str) {
		System.out.println("Ma sp vua tra ve la:" + str);
		txtMaSP.setText(str);
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void onDataKHReturned(KhachHang kh) {
		txtMaKH.setText(kh.getMaKH());
		txtTenKH.setText(kh.getTenKH());
		txtSDT.setText(kh.getSdt());
		txtDiaChi.setText(kh.getDiaChi());
		txtLoaiKH.setText(kh.getLoaiKH());
	}
	
	
	
	
	//	private void refreshHD2() {
//		
//	}
//	private void refreshHD() {
//		listSP = daosp.getAll();
//		model.setRowCount(0);
//		for (SanPham sp : listSP.getList()) {
//			rowSP[0] = sp.getMaSP();
//			rowSP[1] = sp.getTenSP();
//			rowSP[2] = sp.getTenTG();
//			rowSP[3] = sp.getDanhMuc();
//			rowSP[4] = sp.getNhaXB();
//			rowSP[5] = sp.getNamXB();
//			rowSP[6] = sp.getSoLuong();
//			rowSP[7] = sp.getDonGiaMua();
//			rowSP[8] = sp.getTinhTrang();
//			rowSP[9] = "null";
//			
//			
//			model.addRow(rowSP);
//		}
//	}

	private void calculateChange() {
		try {
			double total = Double.parseDouble(txtTongTien.getText());
			double tienKhachGui = Double.parseDouble(txtTienNhan.getText());
			double change = tienKhachGui - total;
//			System.out.println(change);
			String text = String.valueOf(change);
			lbllTienTra.setText(text);
//			txtTienTra.setText(text);
		}catch(NumberFormatException ex){
//			txtTienTra.setText("");

		}
	}
	
	
	
	private static Border createStrikethroughBorder() {
		return BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black),BorderFactory.createEmptyBorder(0, 0, 2, 0)
		        );
	}
	private static Border TopcreateStrikethroughBorder() {
		return BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black),BorderFactory.createEmptyBorder(0, 0, 2, 0)
		        );
	}
	
	private class OvalDrawingExample extends JPanel{
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.red);
			g.drawOval(50, 50, 50, 50);
			
		}
		  @Override
		    public Dimension getPreferredSize() {
		        return new Dimension(200, 250); // Kích thước ưu tiên cho JPanel
		    }
	}
}
