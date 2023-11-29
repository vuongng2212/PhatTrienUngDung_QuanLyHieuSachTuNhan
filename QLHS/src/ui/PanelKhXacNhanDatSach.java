package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_ChiTietHoaDon;
import dao.DAO_HoaDon;
import dao.DAO_KhachDH;
import dao.DAO_KhachHang;
import dao.DAO_KhuyenMai;
import dao.DAO_SanPham;
import dao.DAO_chiTietKhachDH;
import entity.ChiTietHoaDon;
import entity.ChiTietKhachDH;
import entity.HoaDon;
import entity.KhachDH;
import list.DanhSachChiTietKhachDH;
import list.DanhSachKhachDH;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PanelKhXacNhanDatSach extends JPanel {
	public JTextField txtMaKH;
	public JTable table;
	public DefaultTableModel modelDonDatHang;
	public Object[] rowDatHang;
	
	public DefaultTableModel modelInfo;
	public Object[] rowInfo;
	public JTextField txtLoaiKH;
	public JTextField txtMaDH;
	public JTextField txtNV;
	public JTextField txtKH;
	public JTextField txtNgayDat;
	public JTextField txtMaSach;
	public JTextField txtSoLuong;
	public JTable tableDetails;
	public DAO_KhachDH daoKh;
	public DAO_chiTietKhachDH daoChiTiet;
	public DanhSachChiTietKhachDH listChiTietKh;
	public DanhSachKhachDH listDH;
	public DAO_KhachHang daoKhachHang;
	public DefaultTableModel modelSPAdd;
	public int limit;
	public DialogAddSP3 dialogSP;
	public DialogAddKH3 dialogKH;
	public int soLuongSPTemp;
	public String tenSach;
	public double giaBan;
	private Object[] rowAddSp;
	private JTextField txtLoai;
	private DAO_KhuyenMai daoKm;
	private DAO_ChiTietHoaDon dao_chiTietHD;
	private DAO_HoaDon dao_HoaDon;
	private DAO_SanPham dapsp;
	private JTextField txtThanhTien;
	private double thanhTien;
	public JTextField txtTienCoc;
	public JTextField txtTienTraThem;
	public JButton btnXacNhan;
	public JButton btnHuyBo;
	public JButton btnInHoaDon;
	public JDateChooser batdau;
	public JLabel lbllDonDatHang;
	public JLabel lbllNgayDat;
	public JLabel lblMaKH;
	public JButton btnTim2;
	public JLabel lbllTimKH;
	public JButton btnTim;
	public JLabel lbllLoaiKH;
	public JLabel lbllThongtinDatHang;
	public JLabel lbllMaDH;
	public JLabel lbllNhanVienDH;
	public JLabel lbllKhachDatHang;
	public JLabel lbllNgayDatHang;
	public JLabel lbllDanhSachDatHang;
	public JLabel lbllThemSach;
	public JButton btnTim3;
	public JLabel lbllMaSach;
	public JLabel lbllSoLuong;
	public JButton btnAdd;
	public JButton btnSua;
	public JButton btnXoa;
	public JButton btnTaomoi;
	public JLabel lbllLoai;
	public JLabel lbllThanhTien;
	public JLabel lbllTienDaCoc;
	public JLabel lbllTienPhaiTraThem;
	/**
	 * Create the panel.
	 */
	public PanelKhXacNhanDatSach() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		dialogKH = new DialogAddKH3();
		rowAddSp = new Object[5];
		thanhTien = 0;
		limit = -1;
		daoKm = new DAO_KhuyenMai();
		soLuongSPTemp = 0;
		tenSach = "";
		giaBan = 0;
		setBounds(0,0,1534,1017);
		setLayout(null);
		dao_chiTietHD = new DAO_ChiTietHoaDon();
		dao_HoaDon = new DAO_HoaDon();
		dialogSP = new DialogAddSP3();
		listDH = new DanhSachKhachDH();
		daoKhachHang = new DAO_KhachHang();
		dapsp = new DAO_SanPham();
		listChiTietKh = new DanhSachChiTietKhachDH();
		daoKh = new DAO_KhachDH();
		daoChiTiet = new DAO_chiTietKhachDH();
		modelSPAdd = new DefaultTableModel();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 0));
		panel.setBounds(0, 0, 708, 56);
		add(panel);
		panel.setLayout(null);
		
		lbllDonDatHang = new JLabel("Đơn Đặt Hàng");
		lbllDonDatHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbllDonDatHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbllDonDatHang.setBounds(0, 0, 805, 55);
		panel.add(lbllDonDatHang);
		
		lbllNgayDat = new JLabel("Ngày Đặt");
		lbllNgayDat.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllNgayDat.setBounds(20, 113, 66, 34);
		add(lbllNgayDat);
		
		batdau = new JDateChooser();
		batdau.setDateFormatString("dd-MM-yyyy");
		batdau.setBounds(96, 112, 165, 35);
		add(batdau);
		
		lblMaKH = new JLabel("Mã Khách Hàng");
		lblMaKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaKH.setBounds(216, 67, 123, 34);
		add(lblMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(349, 67, 66, 33);
		txtMaKH.setEditable(false);
		add(txtMaKH);
		txtMaKH.setColumns(10);
		
		btnTim2 = new JButton("Tìm");
		btnTim2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshCondition();
				
			}
		});
		btnTim2.setBounds(297, 114, 110, 34);
		add(btnTim2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 158, 723, 645);
		add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int discount = 0;
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				
				modelDonDatHang  = (DefaultTableModel) table.getModel();
				int i = table.getSelectedRow();
				String maDH = modelDonDatHang.getValueAt(i, 0).toString();
				modelDonDatHang = (DefaultTableModel) table.getModel();
				modelInfo.setRowCount(0);
				listChiTietKh = daoChiTiet.getTheoMa(maDH);
				txtMaDH.setText(modelDonDatHang.getValueAt(i, 0).toString());
				txtNV.setText(daoChiTiet.tenNVTheoMa(maDH));
				txtKH.setText(daoKh.tenKhachTheoMa(maDH));
				txtNgayDat.setText(modelDonDatHang.getValueAt(i, 3).toString());
				txtLoai.setText(daoKh.LoaiKhachTheoMa(maDH));
				txtTienCoc.setText(String.format("%.1f", daoKh.tienCocTheoMa(maDH)));
				rowInfo = new Object[6];
				if(modelDonDatHang.getValueAt(i, 4).toString().equalsIgnoreCase("Chưa Thanh Toán")) {
					btnXacNhan.setEnabled(true);
					btnHuyBo.setEnabled(true);
				}
				if(i>=0) {
					for (ChiTietKhachDH kh : listChiTietKh.getList()) {
						rowInfo[0] = kh.getMaSP();
						rowInfo[1] = daoChiTiet.tenSPTheoMa(kh.getMaSP());
						rowInfo[2] = kh.getSoLuong();
						rowInfo[3] = kh.getDonGia();
						if(daoKm.ktraHienDangKhuyenMai(kh.getMaSP())) {
							discount = daoKm.discountSPDangKM(kh.getMaSP());
						}else if(txtLoai.getText().equalsIgnoreCase("TV")) {
							discount = 3;
						}
						rowInfo[4] = discount;
						
						rowInfo[5] = kh.getSoLuong()*kh.getDonGia() - kh.getSoLuong()*kh.getDonGia()*((double)discount)/100;
						modelInfo.addRow(rowInfo);
						limit++;
					}
				}
				limit = tableDetails.getRowCount();
				txtThanhTien.setText(String.format("%.1f", tinhThanhTien()));
				txtTienTraThem.setText(String.format("%.1f",tienKhachPhaiTra()));
				table.clearSelection();
			}
		});
		modelDonDatHang = new DefaultTableModel();
		String[] column = {"Mã Đơn Hàng","Khách Đặt Hàng","Nhân Viên Đặt","Ngày Đặt","Trạng Thái"};
		modelDonDatHang.setColumnIdentifiers(column);
		table.setModel(modelDonDatHang);
				
				scrollPane.setViewportView(table);
		modelDonDatHang = new DefaultTableModel();
		rowDatHang = new Object[4];
		
		lbllTimKH = new JLabel("Tìm Khách Hàng");
		lbllTimKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllTimKH.setBounds(10, 67, 110, 34);
		add(lbllTimKH);
		
		btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOpenFormKHButtonClick();
			}
		});
		btnTim.setBounds(130, 67, 76, 33);
		add(btnTim);
		
		lbllLoaiKH = new JLabel("Loại Khách Hàng");
		lbllLoaiKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllLoaiKH.setBounds(459, 67, 110, 34);
		add(lbllLoaiKH);
		
		txtLoaiKH = new JTextField();
		txtLoaiKH.setColumns(10);
		txtLoaiKH.setEditable(false);
		txtLoaiKH.setBounds(589, 68, 66, 34);
		add(txtLoaiKH);
		
		lbllThongtinDatHang = new JLabel("Thông Tin Đặt Hàng");
		lbllThongtinDatHang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbllThongtinDatHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbllThongtinDatHang.setBounds(1018, 0, 348, 45);
		add(lbllThongtinDatHang);
		
		lbllMaDH = new JLabel("Mã Đặt Hàng");
		lbllMaDH.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllMaDH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllMaDH.setBounds(764, 45, 89, 34);
		add(lbllMaDH);
		
		txtMaDH = new JTextField();
		txtMaDH.setBounds(863, 46, 58, 34);
		txtMaDH.setEditable(false);
		add(txtMaDH);
		txtMaDH.setColumns(10);
		
		lbllNhanVienDH = new JLabel("Nhân Viên đặt Hàng");
		lbllNhanVienDH.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllNhanVienDH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllNhanVienDH.setBounds(943, 45, 131, 34);
		add(lbllNhanVienDH);
		
		txtNV = new JTextField();
		txtNV.setColumns(10);
		txtNV.setEditable(false);
		txtNV.setBounds(1085, 46, 184, 34);
		add(txtNV);
		
		lbllKhachDatHang = new JLabel("Khách Đặt Hàng");
		lbllKhachDatHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllKhachDatHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllKhachDatHang.setBounds(752, 90, 104, 34);
		add(lbllKhachDatHang);
		
		lbllNgayDatHang = new JLabel("Ngày Đặt Hàng");
		lbllNgayDatHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllNgayDatHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllNgayDatHang.setBounds(1279, 45, 104, 34);
		add(lbllNgayDatHang);
		
		txtKH = new JTextField();
		txtKH.setColumns(10);
		txtKH.setEditable(false);
		txtKH.setBounds(865, 91, 137, 34);
		add(txtKH);
		
		txtNgayDat = new JTextField();
		txtNgayDat.setColumns(10);
		txtNgayDat.setEditable(false);
		txtNgayDat.setBounds(1393, 46, 131, 34);
		add(txtNgayDat);
		
		lbllDanhSachDatHang = new JLabel("Danh Sách Đặt Hàng");
		lbllDanhSachDatHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbllDanhSachDatHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllDanhSachDatHang.setBounds(1057, 127, 255, 34);
		add(lbllDanhSachDatHang);
		modelInfo = new DefaultTableModel();
		
		btnXacNhan = new JButton("Xác Nhận");
		btnXacNhan.setEnabled(false);
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double total  = Double.parseDouble(txtThanhTien.getText());
				DAO_SanPham daosp = new DAO_SanPham();
				ArrayList<ChiTietHoaDon>list = new ArrayList<ChiTietHoaDon>();
				list = listHDTable();
				HoaDon hd = new HoaDon();
				hd.setMaHD(txtMaDH.getText());
				hd.setMaNV("NV001");
				hd.setThanhTien(total);
				hd.setNgayTaoHD(new Date());
				hd.setMaKH(daoKh.tenMaKHTheoDH(txtMaDH.getText()));
				dao_HoaDon.add(hd);
				for (ChiTietHoaDon chit : list) {
					dao_chiTietHD.add(chit);
					daosp.giamSoLuong(chit.getMaSP(), chit.getSoLuong());
				}
				JOptionPane.showMessageDialog(null, "Lập hóa đơn thành công!!!");
				btnInHoaDon.setEnabled(true);
				daoKh.updateDaXacNhan(txtMaDH.getText());
				if(txtLoai.getText().equalsIgnoreCase("VL")) {
					daoKm = new DAO_KhuyenMai();
					daoKhachHang = new DAO_KhachHang();
					double tongTien = daoKm.tongTienCuaKH(daoKh.tenMaKHTheoDH(txtMaDH.getText()));
					if(tongTien >=300000) {
						daoKhachHang.updateLoaiKH(daoKh.tenMaKHTheoDH(txtMaDH.getText()));
						JOptionPane.showMessageDialog(null,"Tổng chi tiêu của khách đã vượt 300k. Loại Khách hàng chuyển thành thành viên");
					}
				}
				refresh();
			}
		});
		
//		btnNewButton_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////				double total = 0;
////				dapsp = new DAO_SanPham();
////				List<ChiTietHoaDon>listTemp = new ArrayList<ChiTietHoaDon>();
////				modelInfo = (DefaultTableModel) tableDetails.getModel();
//////				modelSPAdd = (DefaultTableModel) tableAddSP.getModel();
////				int sumMacDinh = tableDetails.getRowCount();
////				for(int i=0;i<sumMacDinh;i++) {
////					ChiTietHoaDon chit = new ChiTietHoaDon();
////					chit.setMaHD(txtMaDH.getText());
////					chit.setMaSP(modelInfo.getValueAt(0, 0).toString());
////					chit.setDonGia(Double.parseDouble(modelInfo.getValueAt(i, 3).toString()));
////					chit.setSoLuong(Integer.parseInt(modelInfo.getValueAt(i, 2).toString()));
////					chit.setDiscount(Integer.parseInt(modelInfo.getValueAt(i,4).toString()));
////					listTemp.add(chit);
////					total+= Double.parseDouble(modelInfo.getValueAt(i, 5).toString());
////					dapsp.giamSoLuong(modelInfo.getValueAt(i, 0).toString(), Integer.parseInt(modelInfo.getValueAt(i, 2).toString()));
////				}
//////				int sumThem = tableAddSP.getRowCount();
////				if(sumThem>0) {
////					for(int i=0;i<sumThem;i++) {
////						
////						// Phần xet có trùng với sản phẩm ở trên không với discount như nhau..
////						int indexTemp = -1;
////						if( (indexTemp = ktraTrungTrongList(listTemp, modelSPAdd.getValueAt(i, 0).toString(), Integer.parseInt(modelSPAdd.getValueAt(i,4).toString()))) !=-1) {
////							listTemp.get(indexTemp).setSoLuong(listTemp.get(indexTemp).getSoLuong() + Integer.parseInt(modelSPAdd.getValueAt(i,2).toString()));
////						}else {
////							ChiTietHoaDon chit = new ChiTietHoaDon();
////							chit.setMaHD(txtMaDH.getText());
////							chit.setMaSP(modelSPAdd.getValueAt(i, 0).toString());
////							chit.setDonGia(Double.parseDouble(modelSPAdd.getValueAt(i, 3).toString()));
////							chit.setSoLuong(Integer.parseInt(modelSPAdd.getValueAt(i, 2).toString()));
////							chit.setDiscount(Integer.parseInt(modelSPAdd.getValueAt(i,4).toString()));
////							listTemp.add(chit);
////							total+= Double.parseDouble(modelSPAdd.getValueAt(i, 5).toString());
////							dapsp.giamSoLuong(modelSPAdd.getValueAt(i, 0).toString(), Integer.parseInt(modelSPAdd.getValueAt(i, 2).toString()));
//						
//						}
//						
//						
//					}
//				}
//				SimpleDateFormat dateformat = new SimpleDateFormat();
//				HoaDon hd  = new HoaDon();
//		
//				hd.setMaHD(txtMaDH.getText());
//				hd.setMaNV("NV001");
//				hd.setMaKH(daoKh.tenMaKHTheoDH(txtMaDH.getText()));
//				hd.setNgayTaoHD(new Date());
//				hd.setThanhTien(total);
//				dao_HoaDon.add(hd);
//				for (ChiTietHoaDon chitiet : listTemp) {
//					dao_chiTietHD.add(chitiet);
//				}
//				JOptionPane.showMessageDialog(null, "Đã Tạo Hóa Đơn");
//				if(txtLoai.getText().equalsIgnoreCase("VL")) {
////					daoKh = new DAO_KhachDH();
//					if(total>=300000) {
//						daoKhachHang.updateLoaiKH(daoKh.tenMaKHTheoDH(txtMaDH.getText()));
//						JOptionPane.showMessageDialog(null, "Tổng chi tiêu của bạn đã vượt qua 300k. Loại Kh set TV");
//					}
//				}
//				refresh();
//				modelSPAdd.setRowCount(0);
//				modelInfo.setRowCount(0);
//			}
//		});
		// Phần cần fix
		
		
		btnXacNhan.setBounds(1119, 898, 162, 45);
		add(btnXacNhan);
		
		btnInHoaDon = new JButton("In Hóa Đơn");
		btnInHoaDon.setEnabled(false);
		btnInHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInHoaDon.setBounds(1348, 898, 162, 45);
		add(btnInHoaDon);
		
		btnHuyBo = new JButton("Hủy Bỏ");
		btnHuyBo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option =  JOptionPane.showOptionDialog(null, "Xác nhận hủy bỏ ", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				switch (option) {
				case JOptionPane.YES_OPTION:
					daoKh.updateHuy(txtMaDH.getText());
					JOptionPane.showMessageDialog(null, "Đã hủy đơn đặt!");
					int soLanHuy = daoKh.soLanHuy(daoKh.tenMaKHTheoDH(txtMaDH.getText()));
					if(soLanHuy>=3) {
						JOptionPane.showMessageDialog(null, "khách hàng đã hủy quá 3 đơn hàng. Hệ thống sẽ đưa vào danh sách không cho đặt đơn");
					}else {
						JOptionPane.showMessageDialog(null, "Đúng 3 lần hủy sẽ bị đưa vào danh sách cấm. Vui lòng không hủy đơn.");
						JOptionPane.showMessageDialog(null, "Số lần khách đã hủy là: "+ soLanHuy +" lần.");
						refresh();
						
					}
					
					break;

				default:
					break;
				}
			}
		});
		btnHuyBo.setEnabled(false);
		btnHuyBo.setBounds(909, 898, 151, 45);
		add(btnHuyBo);
		
		lbllThemSach = new JLabel("Thêm Sách");
		lbllThemSach.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllThemSach.setBounds(752, 852, 72, 34);
		add(lbllThemSach);
		
		btnTim3 = new JButton("Tìm");
		btnTim3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOpenFormSPButtonClick();
			}
		});
		btnTim3.setBounds(834, 853, 58, 34);
		add(btnTim3);
		
		lbllMaSach = new JLabel("Mã Sách");
		lbllMaSach.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllMaSach.setBounds(943, 852, 66, 35);
		add(lbllMaSach);
		
		txtMaSach = new JTextField();
		txtMaSach.setBounds(1018, 853, 66, 34);
		add(txtMaSach);
		txtMaSach.setColumns(10);
		
		lbllSoLuong = new JLabel("Số Lượng");
		lbllSoLuong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllSoLuong.setBounds(1090, 852, 66, 35);
		add(lbllSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(1155, 853, 58, 34);
		add(txtSoLuong);
		
		btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int discount = 0;
				if(txtMaSach.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,"Vui lòng chọn sách !!");
				}else {
					if(txtSoLuong.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng điền số lượng");
					}else {
						if(indexTrungTrenBang(txtMaSach.getText()) ==-1) {
							if(Integer.parseInt(txtSoLuong.getText()) > soLuongSPTemp) {
								JOptionPane.showMessageDialog(null, "Số Lương vượt quá trong kho!!");
							}else {
								if(daoKm.ktraHienDangKhuyenMai(txtMaSach.getText())) {
									discount = daoKm.discountSPDangKM(txtMaSach.getText());
								}else if(txtLoai.getText().equalsIgnoreCase("TV")) {
									discount = 3;
								}
								
								modelSPAdd = (DefaultTableModel) tableDetails.getModel();
//								modelSPAdd.setRowCount(0);
								rowAddSp = new Object[6];
								rowAddSp[0] = txtMaSach.getText();
								rowAddSp[1] = tenSach;
								rowAddSp[2] = Integer.parseInt(txtSoLuong.getText());
								rowAddSp[3] = giaBan;
								rowAddSp[4] = discount;
								double goc = ((double)Integer.parseInt(txtSoLuong.getText()))*giaBan;
								System.out.println(goc);
								double disc = goc*(((double)discount))/100;
								System.out.println(disc);
//								rowAddSp[5] = ((double)Integer.parseInt(txtSoLuong.getText())*giaBan - (double)Integer.parseInt(txtSoLuong.getText())*((double)discount/100));
								rowAddSp[5] = (goc - disc);
								modelSPAdd.addRow(rowAddSp);
								txtMaSach.setText("");
								txtSoLuong.setText("");
								JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
								txtThanhTien.setText(String.format("%.1f", tinhThanhTien()));
								txtTienTraThem.setText(String.format("%.1f",tienKhachPhaiTra()));
							}
						}else {
							JOptionPane.showMessageDialog(null, "Sản phẩm đã có trên list giao dịch");
							txtSoLuong.setText("");
							txtMaSach.setText("");
						}
					}
				}
			}
		});
		btnAdd.setBounds(1223, 853, 89, 34);
		add(btnAdd);
		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableDetails.getSelectedRow();
				System.out.println(limit);
				if(i>=0) {
					if(i<limit) {
						System.out.println("Đã loại vào limit");
						int index = Integer.parseInt(txtSoLuong.getText());
//						int indexGoc = Integer.parseInt(modelInfo.getValueAt(i, 2).toString());
						int indexGoc = daoChiTiet.soLuongDaDatTheoMaSPvaMaDH(modelInfo.getValueAt(i, 0).toString(),txtMaDH.getText());
						if(index >= indexGoc) {
							modelInfo.setValueAt(txtSoLuong.getText(), i, 2);
							double discount = Double.parseDouble(modelInfo.getValueAt(i, 4).toString());
							double giaBan = Double.parseDouble(modelInfo.getValueAt(i, 3).toString());
							double soLuong = Double.parseDouble(modelInfo.getValueAt(i, 2).toString());
							double total = (giaBan*soLuong)  - (giaBan*soLuong*discount/100);
							modelInfo.setValueAt(total, i, 5);
							JOptionPane.showMessageDialog(null,"Sửa thành công!!");
							txtSoLuong.setText("");
							txtMaSach.setText("");
						}else{
							JOptionPane.showMessageDialog(null, "Sửa số lượng sẩn phẩm đã đặt phải lớn hơn số lượng trước đó!!!");
						}
					}else {
						System.out.println("Thoat khỏi limit!!");
						modelInfo.setValueAt(txtSoLuong.getText(), i, 2);
						double discount = Double.parseDouble(modelInfo.getValueAt(i, 4).toString());
						double giaBan = Double.parseDouble(modelInfo.getValueAt(i, 3).toString());
						double soLuong = Double.parseDouble(modelInfo.getValueAt(i, 2).toString());
						double total = (giaBan*soLuong)  - (giaBan*soLuong*discount/100);
						modelInfo.setValueAt(total, i, 5);
						JOptionPane.showMessageDialog(null,"Sửa thành công!!");
						txtSoLuong.setText("");
						txtMaSach.setText("");
						txtThanhTien.setText(String.format("%.1f", tinhThanhTien()));
						txtTienTraThem.setText(String.format("%.1f",tienKhachPhaiTra()));
						
					}
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần sửa!!");
				}
			}
		});

		btnSua.setBounds(1322, 853, 89, 34);
		add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableDetails.getSelectedRow();
				if(i <limit) {
					txtSoLuong.setText("");
					txtMaSach.setText("");
					JOptionPane.showMessageDialog(null, "Sản phẩm đã đặt trước không thể xóa!!");
				}else {
					modelInfo = (DefaultTableModel) tableDetails.getModel();
//					 i = tableDetails.getRowCount();
					modelInfo.removeRow(i);
					txtThanhTien.setText(String.format("%.1f", tinhThanhTien()));
					txtTienTraThem.setText(String.format("%.1f",tienKhachPhaiTra()));
					txtSoLuong.setText("");
					txtMaSach.setText("");

				}
			}
		});
		btnXoa.setBounds(1421, 853, 89, 34);
		add(btnXoa);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(733, 159, 792, 644);
		add(scrollPane_2);
		
		tableDetails = new JTable();
		tableDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableDetails.getSelectedRow();
				modelInfo = (DefaultTableModel) tableDetails.getModel();
				if(i >=0) {
					txtMaSach.setText(modelInfo.getValueAt(i, 0).toString());
					txtSoLuong.setText(modelInfo.getValueAt(i, 2).toString());
				}
			}
		});
		modelInfo = new DefaultTableModel();
		rowInfo = new Object[6];
		String[] column2 = {"Mã","Tên Sản Phẩm","Số Lượng","Giá Bán","Discount","Thành Tiền"};
		modelInfo.setColumnIdentifiers(column2);
		tableDetails.setModel(modelInfo);
		scrollPane_2.setViewportView(tableDetails);
		String[] columnAdd = {"Mã","Tên Sản Phẩm","Số Lượng","Giá Bán","Discount","Thành Tiền"};
		modelSPAdd.setColumnIdentifiers(columnAdd);
		
		lbllLoai = new JLabel("Loại");
		lbllLoai.setHorizontalAlignment(SwingConstants.CENTER);
		lbllLoai.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllLoai.setBounds(1047, 90, 62, 34);
		add(lbllLoai);
		
		txtLoai = new JTextField();
		txtLoai.setEditable(false);
		txtLoai.setColumns(10);
		txtLoai.setBounds(1119, 91, 48, 34);
		add(txtLoai);
		
		lbllThanhTien = new JLabel("Thành Tiền");
		lbllThanhTien.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllThanhTien.setBounds(743, 814, 77, 24);
		add(lbllThanhTien);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setBounds(839, 814, 89, 29);
		txtThanhTien.setEditable(false);
		add(txtThanhTien);
		txtThanhTien.setColumns(10);
		
		lbllTienDaCoc = new JLabel("Tiền Đã Cọc");
		lbllTienDaCoc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllTienDaCoc.setBounds(1223, 91, 83, 34);
		add(lbllTienDaCoc);
		
		txtTienCoc = new JTextField();
		txtTienCoc.setEditable(false);
		txtTienCoc.setEditable(false);
		txtTienCoc.setColumns(10);
		txtTienCoc.setBounds(1316, 91, 184, 34);
		add(txtTienCoc);
		
		lbllTienPhaiTraThem = new JLabel("Tiền Phải Trả Thêm");
		lbllTienPhaiTraThem.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTienPhaiTraThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbllTienPhaiTraThem.setBounds(943, 817, 159, 24);
		add(lbllTienPhaiTraThem);
		
		txtTienTraThem = new JTextField();
		txtTienTraThem.setColumns(10);
		txtTienTraThem.setEditable(false);
		txtTienTraThem.setBounds(1112, 814, 101, 29);
		add(txtTienTraThem);
		
		btnTaomoi = new JButton("Làm Mới");
		btnTaomoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btnTaomoi.setBounds(449, 114, 123, 34);
		add(btnTaomoi);
//		String[] columnTable = {""}; 
		
		
		TableColumn nameColumn = tableDetails.getColumnModel().getColumn(1);
		nameColumn.setPreferredWidth(1);
		TableColumn nameColumn2 = tableDetails.getColumnModel().getColumn(2);
		nameColumn2.setPreferredWidth(2);
		TableColumn nameColumn3 = tableDetails.getColumnModel().getColumn(3);
		nameColumn3.setPreferredWidth(3);
		
		refresh();
	}
			
	public void refresh() {
		modelDonDatHang = (DefaultTableModel) table.getModel();
		btnInHoaDon.setEnabled(false);
		btnHuyBo.setEnabled(false);
		btnXacNhan.setEnabled(false);
		modelDonDatHang.setRowCount(0);
		modelInfo = (DefaultTableModel) tableDetails.getModel();
		modelInfo.setRowCount(0);
		daoKh = new DAO_KhachDH();
		listDH = new DanhSachKhachDH();
//		daoKhachHang = new DAO_KhachHang();
		listDH = daoKh.getAll();
		rowDatHang = new  Object[5];
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (KhachDH dh : listDH.getList()) {
			rowDatHang[0] = dh.getMaDH();
			rowDatHang[1] = daoKh.tenKHTheoMa(dh.getMaKh());
			rowDatHang[2] = daoKh.tenNVTheoMa(dh.getMaNv());
			rowDatHang[3] = dateFormat.format(dh.getNgayDat());
			int trangThai = dh.getTrangThai();
			if(trangThai ==0) {
				rowDatHang[4] = "Chưa Thanh Toán";
			}else if(trangThai == 1){
				rowDatHang[4] = "Đã Thanh Toán";
			}else {
				rowDatHang[4] = "Đã Hủy Bỏ";	
			}
			modelDonDatHang.addRow(rowDatHang);
		}
		txtMaKH.setText("");
		txtLoaiKH.setText("");
		batdau.setDate(null);
	}
	public void refreshLocale(String cs1,String cs2) {
		Locale locale = new Locale(cs1, cs2);
		ResourceBundle rd = ResourceBundle.getBundle("resources.content",locale);
		lbllDonDatHang.setText(rd.getString("donDatHang"));
		lbllTimKH.setText(rd.getString("timKH"));
		btnTim.setText(rd.getString("tim"));
		lblMaKH.setText(rd.getString("maKH"));
		lbllLoaiKH.setText(rd.getString("loaiKH"));
		lbllNgayDat.setText(rd.getString("ngayDatHang"));
		btnTim2.setText(rd.getString("tim"));
		btnTaomoi.setText(rd.getString("lammoi"));
		lbllThongtinDatHang.setText(rd.getString("thongTinDatHang"));
		lbllMaDH.setText(rd.getString("maDonDat"));
		lbllNhanVienDH.setText(rd.getString("nhanVienDH"));
		lbllNgayDatHang.setText(rd.getString("ngayDatHang"));
		lbllKhachDatHang.setText(rd.getString("khachDatHang"));
		lbllLoai.setText(rd.getString("loai"));
		lbllTienDaCoc.setText(rd.getString("tienCoc"));
		lbllTienPhaiTraThem.setText(rd.getString("tienPhaiTraThem"));
		lbllThemSach.setText(rd.getString("themSach"));
		btnTim3.setText(rd.getString("tim"));
		lbllMaSach.setText(rd.getString("maSach"));
		lbllSoLuong.setText(rd.getString("soluong"));
		btnAdd.setText(rd.getString("them"));
		btnSua.setText(rd.getString("sua"));
		btnXoa.setText(rd.getString("xoa"));
		btnHuyBo.setText(rd.getString("huyBo"));
		btnXacNhan.setText(rd.getString("xacNhan"));
		btnInHoaDon.setText(rd.getString("inHD"));
		
	}
	public void refreshCondition() {
		modelDonDatHang = (DefaultTableModel) table.getModel();
		modelDonDatHang.setRowCount(0);
		listDH = new DanhSachKhachDH();
		SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		daoKh = new DAO_KhachDH();
		if(!txtMaKH.getText().equalsIgnoreCase("") && batdau.getDate() == null) {
			listDH = daoKh.getToConditionsMaKH(txtMaKH.getText());
		}else if(!txtMaKH.getText().equalsIgnoreCase("") && batdau.getDate()!=null){
			listDH = daoKh.getToConditionsNgayDatvaMaKH(txtMaKH.getText(), dateformat2.format(batdau.getDate()));
			
		}else if(txtMaKH.getText().equalsIgnoreCase("") && batdau.getDate()!=null) {
			listDH = daoKh.getToConditionsNgayDat(dateformat2.format(batdau.getDate()));
		}else {
			listDH = daoKh.getAll();
		}
		
		// Phần sau --
		rowDatHang = new  Object[5];
		
		for (KhachDH dh : listDH.getList()) {
			rowDatHang[0] = dh.getMaDH();
			rowDatHang[1] = daoKh.tenKHTheoMa(dh.getMaKh());
			rowDatHang[2] = daoKh.tenNVTheoMa(dh.getMaNv());
			rowDatHang[3] = dateFormat.format(dh.getNgayDat());
			int trangThai = dh.getTrangThai();
			if(trangThai ==0) {
				rowDatHang[4] = "Chưa Thanh Toán";
			}else if(trangThai == 1){
				rowDatHang[4] = "Đã Thanh Toán";
			}else {
				rowDatHang[4] = "Đã Hủy Bỏ";	
			}
			modelDonDatHang.addRow(rowDatHang);
		}
		txtMaKH.setText("");
		txtLoaiKH.setText("");
		batdau.setDate(null);
	}
	public void onOpenFormSPButtonClick() {
		dialogSP.refresh();
//		dialogSP.datSach = this;
		dialogSP.datSach = this;
		dialogSP.setModal(true);
		dialogSP.setVisible(true);
	}
	public void onOpenFormKHButtonClick() {
		dialogKH.refresh();
		dialogKH.datSach = this;
		dialogKH.setModal(true);
		dialogKH.setVisible(true);
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
	public void onDataReturnedKH(String str,String loaiKH) {
		System.out.println("Ma sp vua tra ve la:" + str);
		txtMaKH.setText(str);
		txtLoaiKH.setText(loaiKH);
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public int ktraTrungTrongList(List<ChiTietHoaDon>listTemp,String maSP,int discount) {
		int sum = -1;
		for (ChiTietHoaDon chit : listTemp) {
			if(chit.getMaSP().equalsIgnoreCase(maSP) && chit.getDiscount() == discount) {
				return sum;
			}
			sum++;
		}
		return -1;
	}
	public int indexTrungTrenBang(String str) {
		int index = -1;
		modelInfo = (DefaultTableModel) tableDetails.getModel();
		int count = tableDetails.getRowCount();
		for(int i=0;i<count;i++) {
			if(modelInfo.getValueAt(i, 0).toString().equalsIgnoreCase(str)) {
				return count;
			}
		}
		return index;
	}
	public boolean ktraDangClickVaoDHTRrc(String str,int limit) {
		     modelInfo = (DefaultTableModel) tableDetails.getModel();
		     
			for(int i=0;i<limit;i++) {
				if(modelInfo.getValueAt(i, 0).toString().equalsIgnoreCase(str)) {
					return true;
				}
			}
			return false;
	}
	public double tinhThanhTien() {
		double sum = 0;
		int count = tableDetails.getRowCount();
		modelInfo = (DefaultTableModel) tableDetails.getModel();
		for(int i=0;i<count;i++) {
			double soLuong = Double.parseDouble(modelInfo.getValueAt(i, 2).toString());
			double giaBan = Double.parseDouble(modelInfo.getValueAt(i, 3).toString());
			double discount = Double.parseDouble(modelInfo.getValueAt(i,4).toString());
			double total = (soLuong*giaBan) - (soLuong*giaBan*discount/100);
			sum+=total;
		}
		return sum;
	}
	public double tienKhachPhaiTra() {
		double tienCoc = Double.parseDouble(txtTienCoc.getText());
		double tongTien = tinhThanhTien();
		return tongTien - tienCoc;
	}
	public ArrayList<ChiTietHoaDon>listHDTable(){
		ArrayList<ChiTietHoaDon>listHD = new ArrayList<ChiTietHoaDon>();
		int count = tableDetails.getRowCount();
		modelInfo = (DefaultTableModel) tableDetails.getModel();
		
		for(int i=0;i<count;i++) {
			ChiTietHoaDon hd = new ChiTietHoaDon();
			hd.setMaHD(txtMaDH.getText());
			hd.setMaSP(modelInfo.getValueAt(i, 0).toString());
			hd.setDiscount(Integer.parseInt(modelInfo.getValueAt(i,4).toString()));
			hd.setDonGia(Double.parseDouble(modelInfo.getValueAt(i, 3).toString()));
			hd.setSoLuong(Integer.parseInt(modelInfo.getValueAt(i, 2).toString()));
			
			listHD.add(hd);
		}
		return listHD;
	}
	
}
