package ui;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_KhuyenMai;
import dao.DAO_SanPham;
import entity.KhuyenMai;
import entity.SanPham;
import list.DanhSachKhuyenMai;
import list.DanhSachSanPham;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;

public class PanelKhuyenMai extends JPanel {
	
	
	private Image img_TimSach = new ImageIcon(frmNV.class.getResource("/image/search.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private JTextField txtMaSach;
	private JTextField txtDisCount;
	private JTable table;
	private DefaultTableModel model;
	private DanhSachKhuyenMai listkm;
	private DAO_KhuyenMai daoKm;
	private Object[] row;
	private SanPhamFrm spfrm;
	
	
	
	
	private boolean flagStart;
	
	private DanhSachSanPham listSP;
	private DAO_SanPham daosp;
	
	private ArrayList<SanPham>danhSachDcChon;
	private JTextField txtMaKM;
	private JDateChooser batdau;
	private JDateChooser kethuc;
	private KhuyenMai km;
	private JButton btnHoanTat;
	private JLabel lbllChonSachCuThe;
	private JLabel lbllNhapDiscount;
	private JButton btnThemVaoDS;
	private JButton btnSua;
	private JButton btnXoa;
	private JLabel lbllChonSpKhuyenMai;
	private JLabel danhSachSP;
	private JButton btnTaoMoi;
	private JLabel lbllKhuyenMai;
	private JLabel lbllNgayBatDau;
	private JLabel lbllNgayKetthuc;
	private JButton btnTaoKhuyenMai;
	private JLabel lbllTaoKM;
	private JLabel lbllSach;
	private String maSach,tenSach,tacGia,soLgTonKho,mucGiam;
	/**
	 * Create the panel.
	 */
	public PanelKhuyenMai() {
		
		flagStart = false;
		
		km = new KhuyenMai();
		spfrm = new SanPhamFrm();
		danhSachDcChon = new ArrayList<SanPham>();
		spfrm.setKhuyenMai(this);
		setBounds(0,0,1534,1017);
		setLayout(null);
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		daoKm = new DAO_KhuyenMai();
		listkm = new DanhSachKhuyenMai();
		listkm = daoKm.getAll();
		listSP = new DanhSachSanPham();
		daosp = new DAO_SanPham();
		listSP = daosp.getAll();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 1534, 85);
		add(panel);
		panel.setLayout(null);
		
		lbllTaoKM = new JLabel("Tạo Khuyến Mãi");
		lbllTaoKM.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lbllTaoKM.setHorizontalAlignment(SwingConstants.CENTER);
		lbllTaoKM.setBounds(0, 0, 1534, 85);
		panel.add(lbllTaoKM);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBounds(0, 208, 1534, 99);
		add(panel_1);
		panel_1.setLayout(null);
		
		lbllSach = new JLabel("Sách:");
		lbllSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllSach.setBounds(10, 0, 77, 54);
		panel_1.add(lbllSach);
		
		JButton btnChonSach = new JButton("");
		btnChonSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOpenFormButtonClick();
			}
		});
		btnChonSach.setBounds(473, 0, 64, 54);
		btnChonSach.setIcon(new ImageIcon(img_TimSach));
		btnChonSach.setBackground(null);
		btnChonSach.setBorderPainted(false);
		
		panel_1.add(btnChonSach);
		
		txtMaSach = new JTextField();
		txtMaSach.setBounds(92, 13, 126, 32);
		panel_1.add(txtMaSach);
		txtMaSach.setColumns(10);
		txtMaSach.setEditable(false);
		
		lbllChonSachCuThe = new JLabel("Chọn Sách Cụ Thể");
		lbllChonSachCuThe.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllChonSachCuThe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllChonSachCuThe.setBounds(247, 0, 219, 54);
		panel_1.add(lbllChonSachCuThe);
		
		lbllNhapDiscount = new JLabel("Nhập Discout:");
		lbllNhapDiscount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllNhapDiscount.setBounds(352, 45, 111, 54);
		panel_1.add(lbllNhapDiscount);
		
		txtDisCount = new JTextField();
		txtDisCount.setBounds(483, 58, 40, 32);
		panel_1.add(txtDisCount);
		txtDisCount.setColumns(10);
		
		btnThemVaoDS = new JButton("Thêm vào danh sách");
		btnThemVaoDS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtMaSach.getText().equalsIgnoreCase("")) {
					listSP = daosp.getAll();
					int index = listSP.timSPTheoMa(txtMaSach.getText());
					SanPham sp = new SanPham();
					sp = listSP.getList().get(index);
					
					if(!txtDisCount.getText().equalsIgnoreCase("")) {
						if(ktraLaChuSo(txtDisCount.getText())) {
							if(Integer.parseInt(txtDisCount.getText())>=5 &&Integer.parseInt(txtDisCount.getText())<100) {
								if(!ktraTonTaiTrongList(danhSachDcChon, txtMaSach.getText())) {
									danhSachDcChon.add(sp);
									addTable(sp, Integer.parseInt(txtDisCount.getText()));
									btnHoanTat.setEnabled(true);
									btnHoanTat.setFocusable(true);
								}else {
									int option = JOptionPane.showOptionDialog(null, "Cập nhật lại sản phẩm trong danh sách", "Xác nhận", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
									
//									JOptionPane.showMessageDialog(null, "Sách Đã có trong mục");
									switch (option) {
									case JOptionPane.YES_OPTION:
										System.out.println("Say yes");
										int i = updateList(danhSachDcChon, txtMaSach.getText());
										model.setValueAt(txtDisCount.getText(), i, 4);
										JOptionPane.showMessageDialog(null, "Đã sửa thành công");
										break;
									case JOptionPane.NO_OPTION:
										System.out.println("Say no");
										break;
									default:
										break;
									}
								}
							}else {
								JOptionPane.showMessageDialog(null, "Discount phải lớn hơn bằng 5 và bé hơn 100");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Discount nhập vào phải là chữ số");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Vui lòng không để trống mục Discount!!");
					}
					txtMaSach.setText("");
					txtDisCount.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "That bai");
				}
				
			}
			
		});
		btnThemVaoDS.setBounds(685, 56, 152, 36);
		panel_1.add(btnThemVaoDS);
		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				
				if(i>=0) {
					model.setValueAt(txtMaSach.getText(), i, 0);
					model.setValueAt(txtDisCount.getText(),i, 4);
					JOptionPane.showMessageDialog(null, "Đã Sửa Thành Công");
					txtMaSach.setText("");
					txtDisCount.setText("");
					table.clearSelection();
				}
			}
		});
		btnSua.setBounds(875, 56, 126, 36);
		panel_1.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					int option = JOptionPane.showOptionDialog(null,"Bạn chắc chắn muốn xóa","Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				switch (option) {
				case JOptionPane.YES_OPTION:
					danhSachDcChon.remove(i);
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Đã xóa thành công");
					break;
				case JOptionPane.NO_OPTION:
					
					break;
				default:
					break;
				}	
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng cần xóa");
				}
			}
		});
		btnXoa.setBounds(1033, 54, 126, 36);
		panel_1.add(btnXoa);
		
		lbllChonSpKhuyenMai = new JLabel("Chọn sản phẩm khuyến mãi");
		lbllChonSpKhuyenMai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllChonSpKhuyenMai.setBounds(0, 152, 370, 45);
		add(lbllChonSpKhuyenMai);
		
		danhSachSP = new JLabel("Danh Sách Sản Phẩm");
		danhSachSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		danhSachSP.setBounds(0, 318, 184, 35);
		add(danhSachSP);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 364, 1534, 439);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				txtMaSach.setText(model.getValueAt(i, 0).toString());
				txtDisCount.setText(model.getValueAt(i, 4).toString());
			}
		});
		model = new DefaultTableModel();
		String[] column = {"Mã Sách","Tên Sách","Tác Giả","Số Lượng Trong Kho","Mức Giảm(%)"};
		row = new Object[5];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i = 0;i<table.getColumnCount();i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}	
		scrollPane.setViewportView(table);
		
		btnHoanTat = new JButton("Hoàn Tất");
		btnHoanTat.setEnabled(false);
		btnHoanTat.setFocusable(false);
		btnHoanTat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				
				Date dateBatDau =  batdau.getDate();
				System.out.println(dateFormat.format(dateBatDau));
				Date dateKetThuc =  kethuc.getDate();
				System.out.println(dateFormat.format(dateKetThuc));
				if(dateBatDau.before(dateKetThuc)) {
					JOptionPane.showMessageDialog(null, "Thanh cong");
					int rowCount = table.getRowCount();
					model = (DefaultTableModel) table.getModel();
					for(int i=0;i<rowCount;i++) {
						km = new KhuyenMai();
						km.setMaKM(txtMaKM.getText());
						km.setDiscount(Integer.parseInt(model.getValueAt(i, 4).toString()));
						km.setNgayTao(dateBatDau);
						km.setNgayHetHan(dateKetThuc);
						km.setMaSP(model.getValueAt(i, 0).toString());
						daoKm.add(km);
					}
					JOptionPane.showMessageDialog(null,"Thành Công");
					batdau.setEnabled(true);
					kethuc.setEnabled(true);
					
				}else {
					JOptionPane.showMessageDialog(null,"That bai");
				}
				
				model.setRowCount(0);
				txtMaKM.setText("");
				txtDisCount.setText("");
				txtDisCount.setText("");
				batdau.setDate(null);
				kethuc.setDate(null);
				flagStart = false;
				
			}
		});
		btnHoanTat.setBounds(1335, 108, 167, 45);
		add(btnHoanTat);
		
		btnTaoMoi = new JButton("Tạo Mới");
		btnTaoMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showOptionDialog(null, "Tạo mới danh sách", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				switch (option) {
				case JOptionPane.YES_OPTION:
					danhSachDcChon.clear();
					model.setRowCount(0);
					JOptionPane.showMessageDialog(null, "Hoàn tất làm mới");
					batdau.setEnabled(true);
					kethuc.setEnabled(true);
					break;
				case JOptionPane.NO_OPTION:
					JOptionPane.showMessageDialog(null, "Bãi bỏ thao tác");
					break;
				default:
					break;
				}
			}
		});
		btnTaoMoi.setBounds(1143, 108, 160, 45);
		add(btnTaoMoi);
		
		lbllKhuyenMai = new JLabel("Mã Khuyến Mãi");
		lbllKhuyenMai.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllKhuyenMai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllKhuyenMai.setBounds(10, 116, 128, 35);
		add(lbllKhuyenMai);
		
		txtMaKM = new JTextField();
		txtMaKM.setEditable(false);
		txtMaKM.setBounds(148, 108, 86, 45);
		add(txtMaKM);
		txtMaKM.setColumns(10);
		
		kethuc = new JDateChooser();
		kethuc.setDateFormatString("dd-MM-yyyy");
		kethuc.setBounds(740, 118, 178, 35);
		add(kethuc);
		
		batdau = new JDateChooser();
		batdau.setDateFormatString("dd-MM-yyyy");
		batdau.setBounds(392, 118, 178, 35);
		add(batdau);
		
		lbllNgayBatDau = new JLabel("Ngày bắt đầu");
		lbllNgayBatDau.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbllNgayBatDau.setBounds(258, 118, 112, 35);
		add(lbllNgayBatDau);
		
		lbllNgayKetthuc = new JLabel("Ngày Kết Thúc");
		lbllNgayKetthuc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllNgayKetthuc.setBounds(606, 111, 123, 37);
		add(lbllNgayKetthuc);
		
		btnTaoKhuyenMai = new JButton("Tạo Khuyến Mãi");
		btnTaoKhuyenMai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(flag()) {
//					Calendar calendar = new Calendar();

					 Date currentDate = new Date(System.currentTimeMillis());
					 SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
					 long currenMill = currentDate.getTime();
					 long batdauMill = batdau.getDate().getTime();
					 long kethucMill = kethuc.getDate().getTime();
					 System.out.println("Current Date between : "+ TimeUnit.MILLISECONDS.toDays((batdauMill - currenMill)));	
					 long days = TimeUnit.MILLISECONDS.toDays((batdauMill - currenMill));
					 long days2 = TimeUnit.MILLISECONDS.toDays((batdauMill - kethucMill));
					if(!flag()) {
						System.out.println("Between Date: "+days2);
						JOptionPane.showMessageDialog(null, "Vui lòng Điền đầy đủ ngày bắt đầu và ngày kết thúc trước khi tạo khuyến mãi");
					}else if(days<7) {
						JOptionPane.showMessageDialog(null, "Ngày bắt đầu chương trình khuyến mãi phải cách 7 ngày so với ngày tạo");
					}else if(days2>0) {
						JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải lớn hơn ngày kết thúc");
							
					}else{

						JOptionPane.showMessageDialog(null, "Bắt đầu thao tác thêm sản phẩm vào danh sách khuyến mãi");
						flagStart = true;
						batdau.setEnabled(false);
						kethuc.setEnabled(false);
						String ma = daoKm.sinhMaKM();
						if(!ma.equalsIgnoreCase("")) {
							String result = ma.substring(2);
							int so = Integer.parseInt(result) + 1;
							String numberPart = String.format("%03d",so);
							txtMaKM.setText("KM"+numberPart);
						}else {
							txtMaKM.setText("KM001");
						}
							
					}
				}else {
					JOptionPane.showMessageDialog(null, "Điền thời gian trước khi tạo khuyến mãi");
				}

			}
		});
		btnTaoKhuyenMai.setBounds(947, 108, 160, 45);
		add(btnTaoKhuyenMai);
	}
	private void onOpenFormButtonClick() {
//		SanPhamFrm spFrm = new SanPhamFrm();
//		spfrm.setKhuyenMai(this);
		if(flagStart) {
			spfrm.setModal(true);
			spfrm.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn nut tạo khuyến mãi trước khi chọn sản phẩm");
		}
	}
	public void onDataReturned(String str) {
		System.out.println("Ma sp vua tra ve la:" + str);
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		daoKm = new DAO_KhuyenMai();
		SimpleDateFormat dateformat  = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dateformat.format(batdau.getDate()));
		if(daoKm.ktraHopLiSpTaoKhuyenMai(str,dateformat.format(batdau.getDate()))) {
			txtMaSach.setText(str);
		}else {
			JOptionPane.showMessageDialog(null, "Sản phẩm này không thể thêm vì đã có ở trương trình khác trùng với thời gian của Khuyến mãi đang tạo");
		}
	}

	public void addTable(SanPham sp,int discount) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		row = new Object[5];
		row[0] = sp.getMaSP();
		row[1] = sp.getTenSP();
		row[2] = sp.getTenTG();
		row[3] = sp.getSoLuong();
		row[4] = discount;
		model.addRow(row);
		txtMaSach.setText("");
	}
	public boolean ktraTonTaiTrongList(ArrayList<SanPham>list,String str) {
		for (SanPham sanPham : list) {
			if(sanPham.getMaSP().equalsIgnoreCase(str))
				return true;
		}
		return false;
	}
	public int updateList(ArrayList<SanPham>list,String str) {
		int count=0;
		for (SanPham sp : list) {
			if(sp.getMaSP().equalsIgnoreCase(str)) {
				return count;
			}
			count++;
		}
		return -1;
	}
	public boolean flag() {
		if(batdau.getDate()==null || kethuc.getDate()==null) {
			return false;
		}
		
		return true;
	}
	public boolean ktraLaChuSo(String str) {
		
		for(char c : str.toCharArray()) {
			if(!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}
	public void refreshLocale(String cs1,String cs2) {
		Locale locale = new Locale(cs1, cs2);
		ResourceBundle rd = ResourceBundle.getBundle("resources.content",locale);
		lbllTaoKM.setText(rd.getString("taoKM"));
		lbllKhuyenMai.setText(rd.getString("maKM"));
		lbllNgayBatDau.setText(rd.getString("ngayBatDau"));
		lbllNgayKetthuc.setText(rd.getString("ngayKetThuc"));
		btnTaoKhuyenMai.setText(rd.getString("taoKM"));
		btnTaoMoi.setText(rd.getString("lammoi"));
		btnHoanTat.setText(rd.getString("hoanTat"));
		lbllChonSpKhuyenMai.setText(rd.getString("chonSPKhuyenMai"));
		lbllSach.setText(rd.getString("sach"));
		lbllChonSachCuThe.setText(rd.getString("chonSachCuThe"));
		lbllNhapDiscount.setText(rd.getString("nhapDiscount"));
		btnThemVaoDS.setText(rd.getString("themVaoDanhSach"));
		danhSachSP.setText(rd.getString("danhSachSP"));
		btnSua.setText(rd.getString("sua"));
		btnXoa.setText(rd.getString("xoa"));
		
		maSach= rd.getString("maSach");
		tenSach= rd.getString("tenSach");
		tacGia= rd.getString("tacGia");
		soLgTonKho= rd.getString("soLuongTonKho");
		mucGiam= rd.getString("mucGiam");
		model = (DefaultTableModel) table.getModel();
		String[] column = {maSach,tenSach,tacGia,soLgTonKho,mucGiam};
		model.setColumnIdentifiers(column);
	}
}
