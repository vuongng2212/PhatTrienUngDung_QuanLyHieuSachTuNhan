package ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_HoaDon;
import dao.DAO_KhachDH;
import dao.DAO_KhuyenMai;
import dao.DAO_chiTietKhachDH;
import entity.ChiTietKhachDH;
import entity.KhachDH;
import entity.Subject;
import entity.SubjectDH;
import entity.userInfo;
import list.DanhSachKhachDH;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelKHDatSach extends JPanel {
	
	private Image img_kinhLup = new ImageIcon(frmNV.class.getResource("/image/kinhLup.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	public JTextField txtMaDH;
	public JTextField txtMaKH;
	public JTextField txtTenKH;
	public JTextField txtLoaiKh;
	public JTextField txtSDT;
	public JTextField txtDiaChi;
	public JTextField txtMaSach;
	public JTextField txtSoLuong;
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	public DialogAddKH2 dialog;
	public DialogAddSP2 dialogSP;
	public String tenSach;
	public double giaBan;
	public int soLuongSPTemp;
	private DAO_KhuyenMai daoKm;
	private DAO_chiTietKhachDH daoChiTietDh;
	private DanhSachKhachDH listkh;
	private DAO_KhachDH daoKhachDh;
	private JTextField txtTienPhaiCoc;
	private JTextField txtTienKhachGui;
	private double total;
	private JTextField txtTongTien;
	public JButton btnInHD;
	private JLabel lbllDatHang;
	private JLabel lbllMaDH;
	private JLabel lbllChonKH;
	private JLabel lbllChonKH2;
	private JLabel lbllMaKH;
	private JLabel lbllTenKH;
	private JLabel lbllLoaiKH;
	private JLabel lbllSDT;
	private JLabel lbllDiaChi;
	private JButton btnSearchKH;
	private JLabel lbllChonSach;
	private JLabel lbllThemSach;
	private JLabel lbllMaSach;
	private JLabel lbllSoLuong;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnLamMoi;
	private JButton btnChon;
	private JButton btnHuyBo;
	private JButton btnDatHang;
	private JLabel lbllTienCoc;
	private JLabel lbllKhachGui;
	private JLabel lbllTongTien;
	private JButton btnTaoDon;
	private String textError;
	private String textError1;
	private String textError2;
	private String textError3;
	private String textError4;
	private String textError5;
	private String textError6;
	private String textError7;
	private String textError8;
	private String textError9;
	private String column1;
	private String column2;
	private String column3;
	private String column4;
	private String column5;
	
	
//	public int discount;
	/**
	 * Create the panel.
	 */
	public PanelKHDatSach() {
		column1="Mã Sách";
		column2="Tên Sách";
		column3="Số Lượng";
		column4="Giá Bán";
		column5="Thành Tiền";
		total = 0;
		textError = "Sản phẩm đã được thêm từ trước đó!!";
		textError1="Vui lòng chọn sản phẩm!!!";
		textError2= "Vui lòng chọn hàng cần sửa";
		textError3="Vui lòng chọn dòng cần xóa";
		textError4="Đặt hàng thành công!!";
		textError5="Tiền khách gửi trước phải lớn hơn tiền cọc đã yêu cầu!!!";
		textError6="Vui lòng nhập số tiền khách gửi!!!";
		textError7= "Đặt hàng thành công!!";
		textError8="Vui lòng thanh toán trước khi in hóa đơn!!!";
		textError9= "khách hàng đã nằm trong danh sách cấm đặt hàng. KH sẽ không được phép đặt hàng nữa!";
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		daoChiTietDh = new DAO_chiTietKhachDH();
		daoKhachDh = new DAO_KhachDH();
		listkh = new DanhSachKhachDH();
		
//		discount = 0;
		tenSach = "";
		giaBan = 0;
		soLuongSPTemp = 0;
		daoKm = new DAO_KhuyenMai();
		dialogSP = new DialogAddSP2();
		dialog = new DialogAddKH2();
		setBounds(0,0,1534,1017);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(218, 165, 32));
		panel.setBounds(0, 0, 1544, 81);
		add(panel);
		panel.setLayout(null);
		
		lbllDatHang = new JLabel("Đặt Hàng");
		lbllDatHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbllDatHang.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbllDatHang.setBounds(0, 0, 1534, 81);
		panel.add(lbllDatHang);
		
		lbllMaDH = new JLabel("Mã Đơn Đặt");
		lbllMaDH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllMaDH.setBounds(0, 92, 105, 37);
		add(lbllMaDH);
		
		txtMaDH = new JTextField();
		txtMaDH.setEditable(false);
		txtMaDH.setBounds(138, 92, 76, 37);
		add(txtMaDH);
		txtMaDH.setColumns(10);
		
		btnTaoDon = new JButton("Tạo Đơn");
		btnTaoDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
				String ma = daoKhachDh.sinhMaDH();
				if(!ma.equalsIgnoreCase("")) {
					String result = ma.substring(2);
					int so = Integer.parseInt(result) + 1;
					String numberPart = String.format("%03d",so);
					txtMaDH.setText("DH"+numberPart);
				}else {
					txtMaDH.setText("DH001");
				}
			}
		});
		btnTaoDon.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTaoDon.setBounds(242, 92, 157, 37);
		add(btnTaoDon);
		
		lbllChonKH = new JLabel("Chọn Khách Hàng");
		lbllChonKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllChonKH.setBounds(0, 143, 133, 22);
		add(lbllChonKH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(0, 176, 1534, 113);
		add(panel_1);
		panel_1.setLayout(null);
		
		lbllChonKH2 = new JLabel("Chọn Khách Hàng");
		lbllChonKH2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllChonKH2.setBounds(0, 11, 122, 33);
		panel_1.add(lbllChonKH2);
		
		lbllMaKH = new JLabel("Mã Khách Hàng");
		lbllMaKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllMaKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllMaKH.setBounds(247, 11, 130, 33);
		panel_1.add(lbllMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setBounds(387, 11, 153, 33);
		panel_1.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		lbllTenKH = new JLabel("Tên Khách Hàng");
		lbllTenKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTenKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllTenKH.setBounds(665, 11, 115, 33);
		panel_1.add(lbllTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(790, 12, 220, 33);
		panel_1.add(txtTenKH);
		
		lbllLoaiKH = new JLabel("Loại Khách Hàng");
		lbllLoaiKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllLoaiKH.setBounds(1158, 11, 115, 33);
		panel_1.add(lbllLoaiKH);
		
		txtLoaiKh = new JTextField();
		txtLoaiKh.setColumns(10);
		txtLoaiKh.setEditable(false);
		txtLoaiKh.setBounds(1283, 11, 53, 33);
		panel_1.add(txtLoaiKh);
		
		lbllSDT = new JLabel("Số Điện Thoại");
		lbllSDT.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllSDT.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllSDT.setBounds(262, 69, 115, 33);
		panel_1.add(lbllSDT);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setEditable(false);
		txtSDT.setBounds(387, 69, 153, 33);
		panel_1.add(txtSDT);
		
		lbllDiaChi = new JLabel("Địa Chỉ");
		lbllDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllDiaChi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllDiaChi.setBounds(665, 69, 115, 33);
		panel_1.add(lbllDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setEditable(false);
		txtDiaChi.setBounds(790, 70, 220, 33);
		panel_1.add(txtDiaChi);
		
		btnSearchKH = new JButton("");
		btnSearchKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtMaDH.getText().equalsIgnoreCase("")) {
					onOpenFormButtonClick();
				}else {
					JOptionPane.showMessageDialog(null,"Vui lòng chọn tạo đơn hàng trước khi chọn khách hàng!!");
				}
			}
		});
		btnSearchKH.setIcon(new ImageIcon(img_kinhLup));
		btnSearchKH.setBackground(null);
		btnSearchKH.setBorderPainted(false);
		btnSearchKH.setOpaque(false);
		btnSearchKH.setBounds(120, 5, 48, 40);
		panel_1.add(btnSearchKH);
		
		lbllThemSach = new JLabel("Thêm Sách");
		lbllThemSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllThemSach.setBounds(0, 296, 133, 29);
		add(lbllThemSach);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(205, 92, 92));
		panel_2.setBounds(0, 334, 1534, 53);
		add(panel_2);
		panel_2.setLayout(null);
		
		lbllChonSach = new JLabel("Chọn Sách");
		lbllChonSach.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllChonSach.setBounds(10, 11, 102, 29);
		panel_2.add(lbllChonSach);
		
		lbllMaSach = new JLabel("Mã Sách");
		lbllMaSach.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllMaSach.setBounds(232, 11, 76, 29);
		panel_2.add(lbllMaSach);
		
		txtMaSach = new JTextField();
		txtMaSach.setBounds(338, 9, 76, 34);
		txtMaSach.setEditable(false);
		panel_2.add(txtMaSach);
		txtMaSach.setColumns(10);
		
		lbllSoLuong = new JLabel("Số Lượng");
		lbllSoLuong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllSoLuong.setBounds(537, 11, 76, 29);
		panel_2.add(lbllSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(623, 11, 55, 34);
		panel_2.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		btnThem = new JButton("Thêm");
		btnThem.setEnabled(false);
		btnThem.setBackground(new Color(0, 255, 0));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int discount = 0;
				if(daoKm.ktraHienDangKhuyenMai(txtMaSach.getText())) {
					discount = daoKm.discountSPDangKM(txtMaSach.getText());
				}else if(txtLoaiKh.getText().equalsIgnoreCase("TV")) {
					discount = 3;
					
				}
				if(!txtMaSach.getText().equalsIgnoreCase("")) {
					if(ktraTrung(txtMaSach.getText())==-1) {
						model = (DefaultTableModel) table.getModel();
						row = new Object[6];
						row[0] = txtMaSach.getText();
						row[1] = tenSach;
						row[2] = txtSoLuong.getText();
						row[3] = giaBan;
//						row[4] = discount;
//						double total = ((double)giaBan*(double)Integer.parseInt(txtSoLuong.getText()) - ((double)giaBan*(double)Integer.parseInt(txtSoLuong.getText()))*((double)discount/100));
						row[4] = giaBan*Integer.parseInt(txtSoLuong.getText()); 
						total+=giaBan*Integer.parseInt(txtSoLuong.getText());
						txtTongTien.setText(String.format("%.1f", total));
						if(total > 1000000) {
							double tienCoc = total*30/100;
							txtTienPhaiCoc.setText(String.format("%.1f", tienCoc));
						}
						model.addRow(row);
						
						txtMaSach.setText("");
						txtSoLuong.setText("");
						btnThem.setEnabled(false);
						JOptionPane.showMessageDialog(null,"Thêm thành công!!");
					}else {
						JOptionPane.showMessageDialog(null,textError);
					}
				}else {
					JOptionPane.showMessageDialog(null, textError1);
				}
			}
		});
		btnThem.setBounds(837, 9, 108, 34);
		panel_2.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setEnabled(false);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
				int i  = table.getSelectedRow();
				if(i==-1) {
					JOptionPane.showMessageDialog(null, textError2);
				}else {
					
					model.setValueAt(txtSoLuong.getText(), i, 2);
					int soLuong = Integer.parseInt(model.getValueAt(i, 2).toString());
					double giaBanTmp = Double.parseDouble(model.getValueAt(i, 3).toString());
//					int discount = Integer.parseInt(model.getValueAt(i, 4).toString());
//					double total = (double)soLuong*giaBanTmp - ((double)soLuong*giaBanTmp*(discount/100));
					model.setValueAt(soLuong*giaBanTmp, i, 4);
					
					total = totalChange();
					if(total >=1000000) {
						txtTongTien.setText(String.format("%.1f",total));
						double tienCoc = total*30/100;
						txtTienPhaiCoc.setText(String.format("%.1f", tienCoc));
					}else {
						txtTongTien.setText(String.format("%.1f",total));
						txtTienPhaiCoc.setText("");
					}
					JOptionPane.showMessageDialog(null, "Đã sửa!!");
					txtMaSach.setText("");
					txtSoLuong.setText("");
					btnSua.setEnabled(false);
					btnXoa.setEnabled(false);
				}
			}
		});
		btnSua.setBackground(new Color(255, 255, 0));
		btnSua.setBounds(1010, 9, 108, 34);
		panel_2.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setEnabled(false);
		btnXoa.setBackground(new Color(218, 112, 214));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
				int i = table.getSelectedRow();
				if(i==-1) {
					JOptionPane.showMessageDialog(null,textError3);
				}else {
					int soLuong = Integer.parseInt(model.getValueAt(i, 2).toString());
					double giaBan = Double.parseDouble(model.getValueAt(i, 3).toString());
					
					total-=(soLuong*giaBan);
					txtTongTien.setText(String.format("%.1f", total));
					if(total >=1000000) {
						double tienCoc = total*30/100;
						txtTienPhaiCoc.setText(String.format("%.1f", total));
					}else {
						txtTienPhaiCoc.setText("");
					}
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Đã xóa thành công!!");
					txtMaSach.setText("");
					txtSoLuong.setText("");
					btnSua.setEnabled(false);
					btnXoa.setEnabled(false);
				}
			}
		});
		btnXoa.setBounds(1166, 9, 108, 34);
		panel_2.add(btnXoa);
		
		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				
			}
		});
		btnLamMoi.setBackground(new Color(0, 255, 255));
		btnLamMoi.setBounds(1313, 9, 108, 34);
		panel_2.add(btnLamMoi);
		
		btnChon = new JButton("Chọn");
		btnChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtMaDH.getText().equalsIgnoreCase("")) {
					if(!txtMaKH.getText().equalsIgnoreCase("")) {
						onOpenFormSPButtonClick();
						btnThem.setEnabled(true);
						btnSua.setEnabled(false);
						btnXoa.setEnabled(false);
					}else {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng trước khi thêm sản phẩm!!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng bấm nút tạo đơn đặt hàng trước khi thêm sản phẩm!");
				}
			}
		});
		btnChon.setBounds(114, 14, 76, 25);
		panel_2.add(btnChon);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 393, 1534, 497);
		add(scrollPane);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model = (DefaultTableModel) table.getModel();
				int i = table.getSelectedRow();
				txtMaSach.setText(model.getValueAt(i, 0).toString());
				txtSoLuong.setText(model.getValueAt(i, 2).toString());
				btnThem.setEnabled(false);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
			}
		});
		model = new DefaultTableModel();
		row = new Object[4];
		String[] column = {"Mã Sách","Tên Sách","Số Lượng","Giá Bán","Thành Tiền"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i = 0;i<table.getColumnCount();i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		lbllTongTien = new JLabel("Tổng Tiền");
		lbllTongTien.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTongTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTongTien.setBounds(10, 908, 135, 42);
		add(lbllTongTien);
		
		txtTongTien = new JTextField();
		txtTongTien.setEditable(false);
		txtTongTien.setBounds(155, 908, 157, 37);
		add(txtTongTien);
		txtTongTien.setColumns(10);
		
		btnHuyBo = new JButton("Hủy Bỏ");
		btnHuyBo.setBackground(new Color(255, 0, 0));
		btnHuyBo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btnHuyBo.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHuyBo.setBounds(943, 908, 148, 42);
		add(btnHuyBo);
		
		btnDatHang = new JButton("Đặt Hàng");
		btnDatHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = table.getRowCount();
				
				if(n>0) {
					if(!txtTienPhaiCoc.getText().equalsIgnoreCase("")) {
						if(!txtTienKhachGui.getText().equalsIgnoreCase("")) {
							double tienCoc = Double.parseDouble(txtTienPhaiCoc.getText());
							double tienKhachGui = Double.parseDouble(txtTienKhachGui.getText());
							if(tienKhachGui >= tienCoc) {
								daoChiTietDh = new DAO_chiTietKhachDH();
								
								daoKhachDh.add(new KhachDH(txtMaDH.getText(),txtMaKH.getText() , "NV001", new Date(), 0,Double.parseDouble(txtTienKhachGui.getText())));
								int limit = table.getRowCount();
								model = (DefaultTableModel) table.getModel();
								for(int i=0;i<limit;i++) {
									daoChiTietDh.add(new ChiTietKhachDH(txtMaDH.getText(), model.getValueAt(i, 0).toString(), Integer.parseInt(model.getValueAt(i, 2).toString()), Double.parseDouble(model.getValueAt(i, 3).toString())));
								}
								btnDatHang.setEnabled(false);
								btnInHD.setEnabled(true);
//								refresh();

								JOptionPane.showMessageDialog(null, textError4);
								
							}else {
								JOptionPane.showMessageDialog(null, textError5);
							}
							
							
						}else {
							JOptionPane.showMessageDialog(null, textError6);
						}
					
					}else {
						daoChiTietDh = new DAO_chiTietKhachDH();
						
						daoKhachDh.add(new KhachDH(txtMaDH.getText(),txtMaKH.getText() , userInfo.maNV, new Date(), 0,0));
						int limit = table.getRowCount();
						model = (DefaultTableModel) table.getModel();
						for(int i=0;i<limit;i++) {
							daoChiTietDh.add(new ChiTietKhachDH(txtMaDH.getText(), model.getValueAt(i, 0).toString(), Integer.parseInt(model.getValueAt(i, 2).toString()), Double.parseDouble(model.getValueAt(i, 3).toString())));
						}
						btnDatHang.setEnabled(false);
						btnInHD.setEnabled(true);
//						refresh();
						
						JOptionPane.showMessageDialog(null, textError7);
					}
				}else {
					JOptionPane.showMessageDialog(null, textError1);
				}
			}
		});
		btnDatHang.setBackground(new Color(0, 255, 0));
		btnDatHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDatHang.setBounds(1125, 908, 176, 42);
		add(btnDatHang);
		
		btnInHD = new JButton("In Hóa Đơn");
		btnInHD.setEnabled(false);
		btnInHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = table.getRowCount();
				if(n>0) {
					printReport();
				}else {
					JOptionPane.showMessageDialog(null, textError8);
				}
			}
		});
		btnInHD.setBackground(new Color(255, 215, 0));
		btnInHD.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInHD.setBounds(1338, 908, 169, 42);
		add(btnInHD);
		
		lbllTienCoc = new JLabel("Tiền Cọc");
		lbllTienCoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTienCoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTienCoc.setBounds(322, 908, 139, 42);
		add(lbllTienCoc);
		
		txtTienPhaiCoc = new JTextField();
		txtTienPhaiCoc.setEditable(false);
		txtTienPhaiCoc.setColumns(10);
		txtTienPhaiCoc.setBounds(461, 908, 157, 37);
		add(txtTienPhaiCoc);
		
		lbllKhachGui = new JLabel("Khách Gửi");
		lbllKhachGui.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllKhachGui.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllKhachGui.setBounds(628, 908, 133, 42);
		add(lbllKhachGui);
		
		txtTienKhachGui = new JTextField();
//		txtTienKhachGui.setEditable(false);
		txtTienKhachGui.setColumns(10);
		txtTienKhachGui.setBounds(776, 908, 157, 37);
		add(txtTienKhachGui);
	}
	public void onOpenFormButtonClick() {
		dialog.refresh();
		dialog.datSach = this;
		dialog.setModal(true);
		dialog.setVisible(true);
	}
	public void onDataReturned(String str) {
		System.out.println("Ma sp vua tra ve la:" + str);
		txtMaKH.setText(str);
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		daoKhachDh  = new DAO_KhachDH();
		int soLanHuy = daoKhachDh.soLanHuy(txtMaKH.getText());
		if(soLanHuy >=3) {
			JOptionPane.showMessageDialog(null, textError9);
			txtMaKH.setText("");
			txtTenKH.setText("");
			txtLoaiKh.setText("");
			txtDiaChi.setText("");
			txtSDT.setText("");
		}
		
	}
	public void onOpenFormSPButtonClick() {
		dialogSP.refresh();
		dialogSP.datSach = this;
		dialogSP.setModal(true);
		dialogSP.setVisible(true);
	}
	public void onDataReturnedSP(String str) {
		System.out.println("Ma sp vua tra ve la:" + str);
		txtMaSach.setText(str);
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	private int indexMaSPInList(String str) {
		model = (DefaultTableModel) table.getModel();
		int size = model.getRowCount();
		for(int i=0;i<size;i++) {
			if(str.equalsIgnoreCase(model.getValueAt(i, 0).toString())) {
				return i;
			}
		}
		
		return -1;
	}
	private int ktraTrung(String str) {
		model = (DefaultTableModel) table.getModel();
		int count = model.getRowCount();
		for(int i=0;i<count;i++) {
			if(model.getValueAt(i,0).toString().equalsIgnoreCase(str)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public ArrayList<SubjectDH>listDH(){
		ArrayList<SubjectDH>list = new ArrayList<SubjectDH>();
		Locale localVN = new Locale("vi","VN");
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(localVN);
		model = (DefaultTableModel) table.getModel();
		int n = table.getRowCount();
		for(int i=0;i<n;i++) {
			list.add(new SubjectDH(model.getValueAt(i,1).toString(),Integer.parseInt(model.getValueAt(i, 2).toString()),currencyFormat.format(Double.parseDouble(model.getValueAt(i, 3).toString())),currencyFormat.format(Double.parseDouble(model.getValueAt(i, 4).toString()))));
			
		}
		
		return list;
	}
	private void printReport() {
		try {
			String filePath = "src\\resources\\PhieuDatSach.jrxml";
			
//			Subject subject1 = new Subject("Java",5,"50000",0,"260VND");
//			Subject subject2 = new Subject("JavaScript",2,"50000",0,"260VND");
//			Subject subject3 = new Subject("Jsp",3,"50000",0,"260VND");
//			
//			
			List<SubjectDH>list = new ArrayList<SubjectDH>();
			list = listDH();
			
			

			Locale localeCN = new Locale("vi","VN");
			NumberFormat currency = NumberFormat.getCurrencyInstance(localeCN);
			
			model = (DefaultTableModel) table.getModel();				
			JRBeanCollectionDataSource dataSource = 
					new JRBeanCollectionDataSource(list);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("maDH",txtMaDH.getText());
			parameters.put("tenKH",txtTenKH.getText());
			parameters.put("ngayDat",dateFormat.format(new Date()));
			parameters.put("tongTien", txtTongTien.getText());
			if(txtTienKhachGui.getText().equalsIgnoreCase("")) {
				parameters.put("tienCoc", "0");
			}else {
				parameters.put("tienCoc", txtTienKhachGui.getText());
				
			}
			
			parameters.put("tableData", dataSource);
			
			JasperReport report = JasperCompileManager.compileReport(filePath);
			
			JasperPrint print = 
					JasperFillManager.fillReport(report, parameters,dataSource);
			JasperViewer jv = new JasperViewer(print,false);
			jv.setVisible(true);
			
			
//			JasperExportManager.exportReportToPdfFile(print,
//					"C:\\Users\\phant\\Downloads\\Total-Count-Of-Particular-Column-Values\\Total-Count-Of-Particular-"
//					+ "Column-Values\\src\\main\\resources\\student.pdf");
//			
//			System.out.println("Report Created...");
//			
			
		} catch(Exception e) {
			System.out.println("Exception while creating report");
		}
	}
	public void refresh() {
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtSDT.setText("");
		txtLoaiKh.setText("");
		txtDiaChi.setText("");
		txtMaSach.setText("");
		txtSoLuong.setText("");
		
		total = 0;
		txtTienKhachGui.setText("");
		txtTienPhaiCoc.setText("");
		txtTongTien.setText("");
		btnInHD.setEnabled(false);
	}
	public void refreshLocale(String cs1,String cs2) {
		Locale locale = new Locale(cs1, cs2);
		ResourceBundle rd = ResourceBundle.getBundle("resources.content",locale);
		
		lbllDatHang.setText(rd.getString("datHang"));
		lbllMaDH.setText(rd.getString("maDonDat"));
		btnTaoDon.setText(rd.getString("taoDon"));
		lbllChonKH.setText(rd.getString("chonKhachHang"));
		lbllChonKH2.setText(rd.getString("chonKhachHang"));
		lbllSDT.setText(rd.getString("SDT"));
		lbllMaKH.setText(rd.getString("maKH"));
		lbllTenKH.setText(rd.getString("tenKH"));
		lbllDiaChi.setText(rd.getString("diaChi"));
		lbllLoaiKH.setText(rd.getString("loaiKH"));
		lbllChonSach.setText(rd.getString("chonSach"));
		lbllThemSach.setText(rd.getString("themSach"));
		lbllMaSach.setText(rd.getString("maSach"));
		lbllSoLuong.setText(rd.getString("soluong"));
		btnThem.setText(rd.getString("them"));
		btnSua.setText(rd.getString("sua"));
		btnXoa.setText(rd.getString("xoa"));
		btnLamMoi.setText(rd.getString("lammoi"));
		lbllTongTien.setText(rd.getString("tongTien"));
		lbllTienCoc.setText(rd.getString("tienCoc"));
		lbllKhachGui.setText(rd.getString("khachGui"));
		btnHuyBo.setText(rd.getString("huyBo"));
		btnDatHang.setText(rd.getString("datHang"));
		btnInHD.setText(rd.getString("inHD"));
		  textError = rd.getString("textError");
		  textError1 = rd.getString("textError1");
		  textError2= rd.getString("textError2");
		  textError3= rd.getString("textError3");
		  textError4= rd.getString("textError4");
		  textError5= rd.getString("textError5");
		  textError6= rd.getString("textError6");
		  textError7= rd.getString("textError7");
		  textError8= rd.getString("textError8");
		  textError9= rd.getString("textError9");
		  column1=rd.getString("maSach");
			column2=rd.getString("tenSach");
			column3=rd.getString("soluong");
			column4=rd.getString("donGia");
			column5=rd.getString("thanhTien");
			String[] column = {column1,column2,column3,column4,column5};
			model = (DefaultTableModel) table.getModel();
			model.setColumnIdentifiers(column);
	}
	private double totalChange() {
		double sum = 0;
		model = (DefaultTableModel) table.getModel();
		int count = table.getRowCount();
		for(int i =0;i<count;i++) {
			double giaBan = Double.parseDouble(model.getValueAt(i, 3).toString());
			int soLuong = Integer.parseInt(model.getValueAt(i,2).toString());
			sum+=(giaBan*soLuong);
		}
		return sum;
	}
}
