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
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.NumberFormatter;

import entity.*;

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
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

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
	public JLabel lbllMaKH;
	public JLabel lbllTenKH;
	public JLabel lbllSDT;
	public JLabel lbllDiaChi;
	public JLabel lbllLoai;
	public JLabel lbllTongTien;
	public JLabel lbllTienNhan;
	public JLabel lblTienTra;
	public JButton btnHuy;
	public JButton btnThanhToan;
	public JButton btnInHD;
	public JLabel lbllChonSach;
	public JButton btnThem;
	public JButton btnLamMoi;
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
	private List<Subject>listEnty;
	
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
	private JLabel lbllThemSach;
	private JButton btnSua;
	private JButton btnXoa;
	private JLabel lbllMaHD;
	private JTextField txtMaHD;
	private JButton btnTaoHD;
	private JTable table;
	private JLabel lbllTienTra;
	private boolean firstFlag;
//	private
	
	//Phần Column của table
	private String maSachCl,tenSachCL,soLuongCL,giaBancl,discountCl,thanhTiencl;
	private JTextField txtTrongKho;
	private JLabel lblTrongKho;
//	private ArrayList<SanPham>
	
	
	public panelBanHang() {
		listEnty = new ArrayList<Subject>();
		firstFlag = false;
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
		
		lbllChonSach = new JLabel("Chọn Sách");
		lbllChonSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllChonSach.setBounds(10, 11, 100, 23);
		txtSach.add(lbllChonSach);
		
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
		lbllSoLuong.setBounds(626, 12, 85, 21);
		txtSach.add(lbllSoLuong);
		lbllSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(804, 9, 112, 31);
		txtSach.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int discount = 0;
				if(!txtMaSP.getText().equalsIgnoreCase("")) {
					if(!txtMaSP.getText().equalsIgnoreCase("")){
						if(indexMaSPInList(txtMaSP.getText())==-1) {
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
//									tongTien+= giaBan*(Integer.parseInt(txtSoLuong.getText())) - ((discount/100)*(giaBan*(Integer.parseInt(txtSoLuong.getText()))));
//									tongTien+=total;
									System.out.println(tongTien);
									txtTongTien.setText(String.format("%.2f", tongThanhTien()));
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
//									row[5] = total;
									System.out.println(total);
									row[5] = total;
									model.addRow(row);
									tongTien+=total;
									txtTongTien.setText(String.format("%.2f", tongTien));
									JOptionPane.showMessageDialog(null, "Thêm Thành Công");
								}
							txtMaSP.setText("");
							txtSoLuong.setText("");
							txtTrongKho.setText("");
							}else {
								JOptionPane.showMessageDialog(null, "Số Lượng vượt quá mức cho phép!");
							}
						}else {
							System.out.println(indexMaSPInList(txtMaSP.getText()));
							JOptionPane.showMessageDialog(null, "Sản Phẩm đã tồn tại");
							int option = JOptionPane.showOptionDialog(null, "Cập nhật lại số lượng  trong danh sách", "Xác nhận", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
							switch (option) {
							case JOptionPane.YES_OPTION:
								model = (DefaultTableModel) table.getModel();
								model.setValueAt(txtSoLuong.getText(), indexMaSPInList(txtMaSP.getText()), 2);
								break;

							default:
								break;
							}
						}
					}else {
						JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Sách Trước");
					}
				}
				System.out.println("Thoat!!!");
			}
		});
		btnThem.setBackground(new Color(102, 204, 0));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setBounds(1214, 9, 121, 31);
		txtSach.add(btnLamMoi);
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model =(DefaultTableModel) table.getModel();
				model.setRowCount(0);
			}
		});
		btnLamMoi.setBackground(new Color(102, 204, 0));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(721, 9, 42, 31);
		txtSach.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				DefaultTableModel  model = (DefaultTableModel)table.getModel();
				if(i>=0) {
					if(Integer.parseInt(txtSoLuong.getText()) < Integer.parseInt(txtTrongKho.getText())) {
						model.setValueAt(txtSoLuong.getText(), i, 2);
						double soLuong = Double.parseDouble(model.getValueAt(i, 2).toString());
						double giaBan = Double.parseDouble(model.getValueAt(i, 3).toString());
						double discount = Double.parseDouble(model.getValueAt(i, 4).toString());
						double tongTien = ((soLuong*giaBan) - ((soLuong*giaBan*discount)/100));
						model.setValueAt(tongTien, i, 5);
						txtTongTien.setText(String.format("%5.2f",tongThanhTien()));
						
						JOptionPane.showMessageDialog(null, "Sửa Thành Công!!");
					}else {
						JOptionPane.showMessageDialog(null, "Số lượng lớn hơn trong kho không thể sửa.!");
					}
					
					txtMaSP.setText("");
					txtSoLuong.setText("");
					txtTrongKho.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Chọn dòng cần xóa!!");
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSua.setBackground(new Color(102, 204, 0));
		btnSua.setBounds(934, 9, 112, 31);
		txtSach.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model =(DefaultTableModel) table.getModel();
				int i = table.getSelectedRow();
				int option = JOptionPane.showOptionDialog(null, "Xóa Sản Phẩm Khỏi Danh Sách", "Xác nhận", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
				switch (option) {
				case JOptionPane.YES_OPTION:
					model.removeRow(i);
					txtTongTien.setText(String.format("%.2f", tongThanhTien()));
					JOptionPane.showMessageDialog(null, "Xóa Thành Công!!!");
					txtMaSP.setText("");
					txtSoLuong.setText("");
					txtTrongKho.setText("");
					break;

				default:
					break;
				}
				
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXoa.setBackground(new Color(102, 204, 0));
		btnXoa.setBounds(1067, 9, 121, 31);
		txtSach.add(btnXoa);
		
		lblTrongKho = new JLabel("Trong Kho");
		lblTrongKho.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrongKho.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrongKho.setBounds(363, 12, 177, 21);
		txtSach.add(lblTrongKho);
		
		txtTrongKho = new JTextField();
		txtTrongKho.setEditable(false);
		txtTrongKho.setColumns(10);
		txtTrongKho.setBounds(561, 9, 42, 31);
		txtSach.add(txtTrongKho);
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
		
		lbllTongTien = new JLabel("Tổng Tiền(Bao gồm VAT)");
		lbllTongTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTongTien.setBounds(10, 40, 185, 38);
		panel_2.add(lbllTongTien);
		
		txtTongTien = new JTextField();
		txtTongTien.setBackground(new Color(255, 255, 255));
		txtTongTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTongTien.setBounds(205, 41, 183, 38);
		txtTongTien.setEditable(false);
		panel_2.add(txtTongTien);
		txtTongTien.setColumns(10);
		
		lbllTienNhan = new JLabel("Tiền Nhận");
		lbllTienNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTienNhan.setBounds(398, 40, 88, 38);
		panel_2.add(lbllTienNhan);
		
		txtTienNhan = new JTextField();
		txtTienNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
//		txtTienNhan.setEditable(false);
		txtTienNhan.setColumns(10);
		txtTienNhan.setBackground(new Color(255, 255, 255));
		txtTienNhan.setBounds(488, 41, 162, 38);

		panel_2.add(txtTienNhan);
		
		lblTienTra = new JLabel("Tiền Trả");
		lblTienTra.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTienTra.setBounds(660, 40, 88, 38);
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
					
//					tongTien = 0;
//					txtTongTien.setText(String.format("%.2f", tongTien));
					
					JOptionPane.showMessageDialog(null,"Tạo Hóa Đơn Thành Công");
					if(txtLoaiKH.getText().equalsIgnoreCase("VL")) {
						daokm = new DAO_KhuyenMai();
						daokh = new DAO_KhachHang();
						double total = daokm.tongTienCuaKH(txtMaKH.getText());
						if(total >=300000) {
							daokh.updateLoaiKH(txtMaKH.getText());
							JOptionPane.showMessageDialog(null, "Tổng chi tiêu của khách hàng đã vượt 300k.LoạiKh set TV");
						}
					}
					btnInHD.setEnabled(true);
					Locale localVN = new Locale("vi","VN");
					NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(localVN);
					
//					String fora
					
					
//					model = (DefaultTableModel) table.getModel();
//					model.setRowCount(0);
//					
//					txtMaHD.setText("");
//					txtMaKH.setText("");
//					txtMaSP.setText("");
//					txtSoLuong.setText("");
//					txtDiaChi.setText("");
//					txtLoaiKH.setText("");
//					txtSDT.setText("");
//					txtTenKH.setText("");
//					txtTongTien.setText("");
//					txtTienNhan.setText("");
//					lbllTienTra.setText("");
					//
					
				}else {
					JOptionPane.showMessageDialog(null, "Thất bại");
				}
				
			}
		});
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThanhToan.setBackground(new Color(102, 204, 0));
		btnThanhToan.setBounds(1113, 40, 138, 38);
		panel_2.add(btnThanhToan);
		
		btnInHD = new JButton("In Hóa Đơn");
		btnInHD.setEnabled(false);
		btnInHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				CustomReport cs = new CustomReport();
//				cs.setVisible(true);
				int n = table.getRowCount();
				if(n>0) {
					printReport();	
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng thanh toán trước khi in hóa đơn!!");
				}
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
		lblTimKH.setBounds(10, 61, 161, 28);
		add(lblTimKH);
		lblTimKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 87, 1534, 89);
		add(panel);
		panel.setLayout(null);
		
		JLabel lbllTimKH = new JLabel("Tìm Khách Hàng");
		lbllTimKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllTimKH.setBounds(10, 11, 105, 26);
		panel.add(lbllTimKH);
		
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
		
		lbllMaKH = new JLabel("Mã Khách Hàng");
		lbllMaKH.setBounds(345, 12, 99, 25);
		panel.add(lbllMaKH);
		lbllMaKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(473, 15, 144, 20);
		txtMaKH.setEditable(false);
		panel.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		lbllSDT = new JLabel("Số Điện Thoại");
		lbllSDT.setBounds(345, 48, 99, 25);
		panel.add(lbllSDT);
		lbllSDT.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtSDT = new JTextField();
		txtSDT.setBounds(473, 51, 144, 20);
		panel.add(txtSDT);
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		
		lbllTenKH = new JLabel("Tên Khách Hàng");
		lbllTenKH.setBounds(754, 12, 125, 25);
		panel.add(lbllTenKH);
		lbllTenKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(889, 15, 166, 20);
		txtTenKH.setEditable(false);
		panel.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		lbllDiaChi = new JLabel("Địa Chỉ");
		lbllDiaChi.setBounds(754, 48, 120, 25);
		panel.add(lbllDiaChi);
		lbllDiaChi.setFont(new Font("Tahoma", Font.BOLD, 13));
		
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
		
		lbllThemSach = new JLabel("Thêm Sách");
		lbllThemSach.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllThemSach.setBounds(10, 176, 151, 32);
		add(lbllThemSach);
		
		lbllMaHD = new JLabel("Mã Hóa Đơn");
		lbllMaHD.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllMaHD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllMaHD.setBounds(0, 11, 95, 39);
		add(lbllMaHD);
		
		txtMaHD = new JTextField();
		txtMaHD.setEditable(false);
		txtMaHD.setBounds(106, 17, 60, 28);
		add(txtMaHD);
		txtMaHD.setColumns(10);
		
		btnTaoHD = new JButton("Tạo Hóa Đơn");
		btnTaoHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tongTien = 0;
				txtTongTien.setText(String.format("%.2f", tongTien));
				firstFlag = true;
				refresh();
				String maSinh =  daoHD.sinhMaHD();
				if(!maSinh.equalsIgnoreCase("")) {
					String result = maSinh.substring(2);
					int so = Integer.parseInt(result) + 1;
					String numberPart = String.format("%03d",so);
					txtMaHD.setText("HD"+numberPart);
				}else {
					txtMaHD.setText("HD001");
				}
			}
		});
		btnTaoHD.setBounds(337, 12, 132, 39);
		add(btnTaoHD);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 273, 1534, 503);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DAO_SanPham daosp = new DAO_SanPham();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int i = table.getSelectedRow();
				txtMaSP.setText(model.getValueAt(i, 0).toString());
				txtSoLuong.setText(model.getValueAt(i, 2).toString());
				txtTrongKho.setText(String.valueOf(daosp.searchSoLuong(String.valueOf(model.getValueAt(i, 0).toString()))));
			}
		});
		String[] columnsp = {"Mã Sách","Tên Sách","Số Lượng","Giá Bán","Discount","Thành Tiền"};
		row = new Object[6];
		model.setColumnIdentifiers(columnsp);
		table.setModel(model);	
		scrollPane.setViewportView(table);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i = 0;i<table.getColumnCount();i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
	}
	private void onOpenFormButtonClick() {
//		SanPhamFrm spFrm = new SanPhamFrm();
//		spfrm.setKhuyenMai(this);
		if(checkFlagKH()) {
			dialogAddSp.banHang = this;
			dialogAddSp.setModal(true);
			dialogAddSp.setVisible(true);
			dialogAddSp.refresh();
		}else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng trước khi nhập sản phẩm");
		}
	}
	private void onOpenFormKHButtonCLick() {
		if(firstFlag) {
			dialogAddKH.refresh();
			dialogAddKH.banHang = this;
			dialogAddKH.setModal(true);
			dialogAddKH.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Vui lòng click nút tạo hóa đơn trước khi chọn khách hàng!!");
		}
	}
	public void onDataReturned(String str) {
		DAO_SanPham daosp = new DAO_SanPham();
		System.out.println("Ma sp vua tra ve la:" + str);
		txtMaSP.setText(str);
		txtTrongKho.setText(String.valueOf(daosp.searchSoLuong(str)));
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
//	public class CustomReport extends JFrame{
//		private static final long serialVersionID = 1L;
//		public CustomReport() {
//			super("Report Printer");
////			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////			setResizable(false);
////			JButton btPrint = new JButton("Print");
////			JPanel pane = new JPanel();
////			
////			btPrint.addActionListener((e) ->{
////				printReport();
////			});
////			
////			pane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
////			
////			pane.add(btPrint,"width 100::, height 25:28:30, grow");
////			
////			setContentPane(pane);
////			
////			pack();
//			printReport();
//		}
		private void printReport() {
			
			try {
				String filePath = "src\\resources\\HD.jrxml";
				
//				Subject subject1 = new Subject("Java",5,"50000",0,"260VND");
//				Subject subject2 = new Subject("JavaScript",2,"50000",0,"260VND");
//				Subject subject3 = new Subject("Jsp",3,"50000",0,"260VND");
//				
//				
				List<Subject> list = new ArrayList<Subject>();
				list = listHd();
				
//				list.add(subject1);
//				list.add(subject2);
//				list.add(subject3);
				Locale localeCN = new Locale("vi","VN");
				NumberFormat currency = NumberFormat.getCurrencyInstance(localeCN);
				
				model = (DefaultTableModel) table.getModel();				
				JRBeanCollectionDataSource dataSource = 
						new JRBeanCollectionDataSource(list);
				
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("tenKH", txtTenKH.getText());
				parameters.put("SDT", txtSDT.getText());
				parameters.put("DiaChi", txtDiaChi.getText());
				parameters.put("TongTien",currency.format(Double.parseDouble(txtTongTien.getText())));
				parameters.put("VAT", currency.format(Double.parseDouble(txtTongTien.getText())/10));
				parameters.put("TienPhaiTra", currency.format(Double.parseDouble(txtTongTien.getText())));
				parameters.put("tienKhachGui", currency.format(Double.parseDouble(txtTienNhan.getText())));
				parameters.put("tienTra", currency.format(Double.parseDouble(lbllTienTra.getText())));
				parameters.put("maHD", txtMaHD.getText());
				
				parameters.put("tableData", dataSource);
				
				JasperReport report = JasperCompileManager.compileReport(filePath);
				
				JasperPrint print = 
						JasperFillManager.fillReport(report, parameters,dataSource);
				JasperViewer jv = new JasperViewer(print,false);
				jv.setVisible(true);
				
				
//				JasperExportManager.exportReportToPdfFile(print,
//						"C:\\Users\\phant\\Downloads\\Total-Count-Of-Particular-Column-Values\\Total-Count-Of-Particular-"
//						+ "Column-Values\\src\\main\\resources\\student.pdf");
//				
//				System.out.println("Report Created...");
//				
				
			} catch(Exception e) {
				System.out.println("Exception while creating report");
			}
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
	
	private double tongThanhTien() {
		double sum = 0;
		model = (DefaultTableModel) table.getModel();
		int n = table.getRowCount();
		for(int i=0;i<n;i++) {
			sum += Double.parseDouble(model.getValueAt(i, 5).toString());
		}

		return sum;
		
	}
		
	private boolean checkFlagKH() {
		if(txtMaKH.getText().equalsIgnoreCase("")) {
			return false;
		}
		return true;
	}
	
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
	private boolean isNumeric(String str) {
        // Biểu thức chính quy để kiểm tra chuỗi có phải là một số
        String regex = "^\\d+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
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
	public void refresh() {
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
//		listEnty = null;
//		txtMaHD.setText("");
		txtMaKH.setText("");
		txtTrongKho.setText("");
		txtMaSP.setText("");
		txtSoLuong.setText("");
		txtDiaChi.setText("");
		txtLoaiKH.setText("");
		txtSDT.setText("");
		txtTenKH.setText("");
		txtTongTien.setText("");
		txtTienNhan.setText("");
		lbllTienTra.setText("");
		btnInHD.setEnabled(false);
	}
	public ArrayList<Subject>listHd(){
		ArrayList<Subject>list = new ArrayList<Subject>();
		Locale localVN = new Locale("vi","VN");
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(localVN);
		
		model = (DefaultTableModel) table.getModel();
		int n = table.getRowCount();
		for(int i=0;i<n;i++) {
			list.add(new Subject(model.getValueAt(i, 1).toString(),Integer.parseInt(model.getValueAt(i, 2).toString()),currencyFormat.format(Double.parseDouble(model.getValueAt(i, 3).toString())),Integer.parseInt(model.getValueAt(i, 4).toString()),currencyFormat.format(Double.parseDouble(model.getValueAt(i, 5).toString()))));
		}
		
		return list;
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
	public void refreshLocale(String cs1,String cs2) {
		Locale locale = new Locale(cs1, cs2);
		ResourceBundle rd = ResourceBundle.getBundle("resources.content",locale);
		lbllMaHD.setText(rd.getString("maHoaDon"));
		btnTaoHD.setText(rd.getString("taoHoaDon"));
		lblTimKH.setText(rd.getString("timKiemKhachHang"));
		lbllMaKH.setText(rd.getString("maKH"));
		lbllTenKH.setText(rd.getString("tenKH"));
		lbllLoai.setText(rd.getString("loaiKH"));
		lbllSDT.setText(rd.getString("SDT"));
		lbllDiaChi.setText(rd.getString("diaChi"));
		lbllThemSach.setText(rd.getString("themSach"));
		lbllChonSach.setText(rd.getString("chonSach"));
		lbllMaSach.setText(rd.getString("maSach"));
		lbllSoLuong.setText(rd.getString("soluong"));
		btnThem.setText(rd.getString("them"));
		btnSua.setText(rd.getString("sua"));
		btnXoa.setText(rd.getString("xoa"));
		btnLamMoi.setText(rd.getString("lammoi"));
		lbllTongTien.setText(rd.getString("tongTien"));
		lbllTienNhan.setText(rd.getString("tienNhan"));
		lblTienTra.setText(rd.getString("tienTra"));
		btnHuy.setText(rd.getString("huyBo"));
		btnThanhToan.setText(rd.getString("thanhToan"));
		btnInHD.setText(rd.getString("inHD"));
		lblTrongKho.setText(rd.getString("trongKho"));
		
		maSachCl = rd.getString("maSach");
		tenSachCL= rd.getString("tenSach");
		soLuongCL= rd.getString("soluong");
		giaBancl= rd.getString("donGia");
		discountCl= rd.getString("sale");
		thanhTiencl= rd.getString("thanhTien");
		model = (DefaultTableModel) table.getModel();
		String[] columnsp = {maSachCl,tenSachCL,soLuongCL,giaBancl,discountCl,thanhTiencl};
		model.setColumnIdentifiers(columnsp);
		//Change Text for Lbll
		
	}
}
