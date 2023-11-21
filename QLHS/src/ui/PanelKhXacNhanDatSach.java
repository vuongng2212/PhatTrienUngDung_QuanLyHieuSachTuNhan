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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PanelKhXacNhanDatSach extends JPanel {
	private JTextField txtMaKH;
	private JTable table;
	private DefaultTableModel modelDonDatHang;
	private Object[] rowDatHang;
	
	private DefaultTableModel modelInfo;
	private Object[] rowInfo;
	private JTextField txtLoaiKH;
	private JTextField txtMaDH;
	private JTextField txtNV;
	private JTextField txtKH;
	private JTextField txtNgayDat;
	private JTextField txtMaSach;
	private JTextField txtSoLuong;
	private JTable tableDetails;
	private DAO_KhachDH daoKh;
	private DAO_chiTietKhachDH daoChiTiet;
	private DanhSachChiTietKhachDH listChiTietKh;
	private DanhSachKhachDH listDH;
	private DAO_KhachHang daoKhachHang;
	private DefaultTableModel modelSPAdd;
	private int limit;
	public DialogAddSP3 dialogSP;
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
	private JTextField txtTienCoc;
	/**
	 * Create the panel.
	 */
	public PanelKhXacNhanDatSach() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
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
		
		JLabel lblNewLabel = new JLabel("Đơn Đặt Hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 0, 805, 55);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày Đặt");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(20, 113, 66, 34);
		add(lblNewLabel_1);
		
		JDateChooser batdau = new JDateChooser();
		batdau.setDateFormatString("dd-MM-yyyy");
		batdau.setBounds(96, 112, 165, 35);
		add(batdau);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Khách Hàng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(216, 67, 110, 34);
		add(lblNewLabel_1_1);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(325, 67, 66, 33);
		add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setBounds(325, 114, 110, 34);
		add(btnNewButton);
		
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
		
		JLabel lblNewLabel_1_2 = new JLabel("Tìm Khách Hàng");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(10, 67, 110, 34);
		add(lblNewLabel_1_2);
		
		JButton btnNewButton_1 = new JButton("Tìm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(130, 67, 58, 33);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Loại Khách Hàng");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(411, 67, 110, 34);
		add(lblNewLabel_1_1_1);
		
		txtLoaiKH = new JTextField();
		txtLoaiKH.setColumns(10);
		txtLoaiKH.setBounds(538, 67, 66, 34);
		add(txtLoaiKH);
		
		JLabel lblNewLabel_2 = new JLabel("Thông Tin Đặt Hàng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(1065, 0, 246, 45);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mã Đặt Hàng");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(764, 45, 89, 34);
		add(lblNewLabel_3);
		
		txtMaDH = new JTextField();
		txtMaDH.setBounds(863, 46, 58, 34);
		txtMaDH.setEditable(false);
		add(txtMaDH);
		txtMaDH.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nhân Viên đặt Hàng");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(943, 45, 131, 34);
		add(lblNewLabel_3_1);
		
		txtNV = new JTextField();
		txtNV.setColumns(10);
		txtNV.setEditable(false);
		txtNV.setBounds(1085, 46, 184, 34);
		add(txtNV);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Khách Đặt Hàng");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1_1.setBounds(752, 90, 104, 34);
		add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Ngày Đặt Hàng");
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1_1_1.setBounds(1279, 45, 104, 34);
		add(lblNewLabel_3_1_1_1);
		
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
		
		JLabel lblNewLabel_2_1 = new JLabel("Danh Sách Đặt Hàng");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(1109, 127, 184, 34);
		add(lblNewLabel_2_1);
		modelInfo = new DefaultTableModel();
		
		JButton btnNewButton_2 = new JButton("Xác Nhận");
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
		
		
		btnNewButton_2.setBounds(1119, 898, 162, 45);
		add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("In Hóa Đơn");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setBounds(1348, 898, 162, 45);
		add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("Hủy Bỏ");
		btnNewButton_3.setBounds(909, 898, 151, 45);
		add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Thêm Sách");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(822, 852, 72, 34);
		add(lblNewLabel_4);
		
		JButton btnNewButton_4 = new JButton("Tìm");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOpenFormSPButtonClick();
			}
		});
		btnNewButton_4.setBounds(895, 853, 58, 34);
		add(btnNewButton_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mã Sách");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(961, 852, 66, 35);
		add(lblNewLabel_5);
		
		txtMaSach = new JTextField();
		txtMaSach.setBounds(1018, 853, 66, 34);
		add(txtMaSach);
		txtMaSach.setColumns(10);
		
		JLabel lblNewLabel_5_1 = new JLabel("Số Lượng");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_1.setBounds(1090, 852, 66, 35);
		add(lblNewLabel_5_1);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(1155, 853, 58, 34);
		add(txtSoLuong);
		
		JButton btnNewButton_5 = new JButton("Thêm");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int discount = 0;
				if(txtMaSach.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,"Vui lòng chọn sách !!");
				}else {
					if(txtSoLuong.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng điền số lượng");
					}else {
						if(Integer.parseInt(txtSoLuong.getText()) > soLuongSPTemp) {
							JOptionPane.showMessageDialog(null, "Số Lương vượt quá trong kho!!");
						}else {
							if(daoKm.ktraHienDangKhuyenMai(txtMaSach.getText())) {
								discount = daoKm.discountSPDangKM(txtMaSach.getText());
							}else if(txtLoai.getText().equalsIgnoreCase("TV")) {
								discount = 3;
							}
							
							modelSPAdd = (DefaultTableModel) tableDetails.getModel();
//							modelSPAdd.setRowCount(0);
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
//							rowAddSp[5] = ((double)Integer.parseInt(txtSoLuong.getText())*giaBan - (double)Integer.parseInt(txtSoLuong.getText())*((double)discount/100));
							rowAddSp[5] = (goc - disc);
							modelSPAdd.addRow(rowAddSp);
							txtMaSach.setText("");
							txtSoLuong.setText("");
							JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
						}
					}
				}
			}
		});
		btnNewButton_5.setBounds(1223, 853, 89, 34);
		add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Sửa");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableDetails.getSelectedRow();
				System.out.println(limit);
				if(i>=0) {
					if(i<limit) {
						System.out.println("Đã loại vào limit");
						int index = Integer.parseInt(txtSoLuong.getText());
						int indexGoc = Integer.parseInt(modelInfo.getValueAt(i, 2).toString());
						if(index > indexGoc) {
							modelInfo.setValueAt(txtSoLuong.getText(), i, 2);
							double discount = Double.parseDouble(modelInfo.getValueAt(i, 4).toString());
							double giaBan = Double.parseDouble(modelInfo.getValueAt(i, 3).toString());
							double soLuong = Double.parseDouble(modelInfo.getValueAt(i, 2).toString());
							double total = (giaBan*soLuong)  - (giaBan*soLuong*discount/100);
							modelInfo.setValueAt(total, i, 5);
							JOptionPane.showMessageDialog(null,"Sửa thành công!!");
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
					}
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần sửa!!");
				}
			}
		});

		btnNewButton_6.setBounds(1322, 853, 89, 34);
		add(btnNewButton_6);
		
		JButton btnNewButton_6_1 = new JButton("Xóa");
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableDetails.getSelectedRow();
				if(i <limit) {
					JOptionPane.showMessageDialog(null, "Sản phẩm đã đặt trước không thể xóa!!");
				}else {
					modelInfo = (DefaultTableModel) tableDetails.getModel();
//					 i = tableDetails.getRowCount();
					modelInfo.removeRow(i);

				}
			}
		});
		btnNewButton_6_1.setBounds(1421, 853, 89, 34);
		add(btnNewButton_6_1);
		
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
		
		JLabel lblNewLabel_7 = new JLabel("Loại");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(1012, 90, 36, 34);
		add(lblNewLabel_7);
		
		txtLoai = new JTextField();
		txtLoai.setEditable(false);
		txtLoai.setColumns(10);
		txtLoai.setBounds(1048, 90, 48, 34);
		add(txtLoai);
		
		JLabel lblNewLabel_8 = new JLabel("Thành Tiền");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(824, 813, 77, 24);
		add(lblNewLabel_8);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setBounds(901, 813, 77, 24);
		add(txtThanhTien);
		txtThanhTien.setColumns(10);
		
		JLabel lblNewLabel_7_1 = new JLabel("Tiền Đã Cọc");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7_1.setBounds(1130, 90, 83, 34);
		add(lblNewLabel_7_1);
		
		txtTienCoc = new JTextField();
		txtTienCoc.setEditable(false);
		txtTienCoc.setEditable(false);
		txtTienCoc.setColumns(10);
		txtTienCoc.setBounds(1223, 91, 184, 34);
		add(txtTienCoc);
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
			}else {
				rowDatHang[4] = "Đã Thanh Toán";
			}
			modelDonDatHang.addRow(rowDatHang);
		}
	}
	
	public void onOpenFormSPButtonClick() {
		dialogSP.refresh();
//		dialogSP.datSach = this;
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
}
