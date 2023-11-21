package ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_KhachDH;
import dao.DAO_KhuyenMai;
import dao.DAO_chiTietKhachDH;
import entity.ChiTietKhachDH;
import entity.KhachDH;
import entity.userInfo;
import list.DanhSachKhachDH;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelKHDatSach extends JPanel {
	
	private Image img_kinhLup = new ImageIcon(frmNV.class.getResource("/image/kinhLup.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private JTextField txtMaDH;
	private JTextField txtMaKH;
	public JTextField txtTenKH;
	public JTextField txtLoaiKh;
	public JTextField txtSDT;
	public JTextField txtDiaChi;
	private JTextField txtMaSach;
	private JTextField txtSoLuong;
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
//	public int discount;
	/**
	 * Create the panel.
	 */
	public PanelKHDatSach() {
		total = 0;
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
		
		JLabel lbllTitle = new JLabel("Đặt Hàng");
		lbllTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbllTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbllTitle.setBounds(0, 0, 1534, 81);
		panel.add(lbllTitle);
		
		JLabel lblNewLabel = new JLabel("Mã Đơn Đặt");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(0, 92, 88, 37);
		add(lblNewLabel);
		
		txtMaDH = new JTextField();
		txtMaDH.setBounds(98, 92, 76, 37);
		add(txtMaDH);
		txtMaDH.setColumns(10);
		
		JButton btnNewButton = new JButton("Tạo Đơn");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(193, 92, 105, 37);
		add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Chọn Khách Hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(0, 143, 133, 22);
		add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(0, 176, 1534, 113);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Chọn Khách Hàng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(0, 11, 122, 33);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mã Khách Hàng");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(277, 11, 115, 33);
		panel_1.add(lblNewLabel_2_1);
		
		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setBounds(387, 11, 153, 33);
		panel_1.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Tên Khách Hàng");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1.setBounds(665, 11, 115, 33);
		panel_1.add(lblNewLabel_2_1_1);
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(790, 12, 220, 33);
		panel_1.add(txtTenKH);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Loại Khách Hàng");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1_1.setBounds(1158, 11, 115, 33);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		txtLoaiKh = new JTextField();
		txtLoaiKh.setColumns(10);
		txtLoaiKh.setEditable(false);
		txtLoaiKh.setBounds(1283, 11, 53, 33);
		panel_1.add(txtLoaiKh);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Số Điện Thoại");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_2.setBounds(277, 69, 105, 33);
		panel_1.add(lblNewLabel_2_1_2);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setEditable(false);
		txtSDT.setBounds(387, 69, 153, 33);
		panel_1.add(txtSDT);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Địa Chỉ");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1_2.setBounds(665, 69, 115, 33);
		panel_1.add(lblNewLabel_2_1_1_2);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setEditable(false);
		txtDiaChi.setBounds(790, 70, 220, 33);
		panel_1.add(txtDiaChi);
		
		JButton btnSearchKH = new JButton("");
		btnSearchKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOpenFormButtonClick();
			}
		});
		btnSearchKH.setIcon(new ImageIcon(img_kinhLup));
		btnSearchKH.setBackground(null);
		btnSearchKH.setBorderPainted(false);
		btnSearchKH.setOpaque(false);
		btnSearchKH.setBounds(120, 5, 48, 40);
		panel_1.add(btnSearchKH);
		
		JLabel lblNewLabel_3 = new JLabel("Thêm Sách");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(0, 296, 105, 29);
		add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(205, 92, 92));
		panel_2.setBounds(0, 334, 1534, 62);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Chọn Sách");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 11, 102, 29);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mã Sách");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(232, 11, 76, 29);
		panel_2.add(lblNewLabel_4_1);
		
		txtMaSach = new JTextField();
		txtMaSach.setBounds(338, 9, 76, 34);
		txtMaSach.setEditable(false);
		panel_2.add(txtMaSach);
		txtMaSach.setColumns(10);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Số Lượng");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1.setBounds(537, 11, 76, 29);
		panel_2.add(lblNewLabel_4_1_1);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(623, 11, 55, 34);
		panel_2.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
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
					}else {
						JOptionPane.showMessageDialog(null,"Sản phẩm đã được thêm từ trước đó!!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm!!!");
				}
			}
		});
		btnThem.setBounds(837, 9, 108, 34);
		panel_2.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
				int i  = table.getSelectedRow();
				if(i==-1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng cần sửa");
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
					
				}
			}
		});
		btnSua.setBackground(new Color(255, 255, 0));
		btnSua.setBounds(1010, 9, 108, 34);
		panel_2.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(218, 112, 214));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
				int i = table.getSelectedRow();
				if(i==-1) {
					JOptionPane.showMessageDialog(null,"Vui lòng chọn dòng cần xóa");
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
				}
			}
		});
		btnXoa.setBounds(1166, 9, 108, 34);
		panel_2.add(btnXoa);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				
			}
		});
		btnLamMoi.setBackground(new Color(0, 255, 255));
		btnLamMoi.setBounds(1313, 9, 108, 34);
		panel_2.add(btnLamMoi);
		
		JButton btnNewButton_1 = new JButton("Chọn");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOpenFormSPButtonClick();
			}
		});
		btnNewButton_1.setBounds(114, 14, 76, 25);
		panel_2.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 396, 1534, 501);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model = (DefaultTableModel) table.getModel();
				int i = table.getSelectedRow();
				txtMaSach.setText(model.getValueAt(i, 0).toString());
				txtSoLuong.setText(model.getValueAt(i, 2).toString());
			}
		});
		model = new DefaultTableModel();
		row = new Object[4];
		String[] column = {"Mã Sách","Tên Sách","Số Lượng","Giá Bán","Thành Tiền"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("Tổng Tiền");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(51, 908, 94, 42);
		add(lblNewLabel_5);
		
		txtTongTien = new JTextField();
		txtTongTien.setEditable(false);
		txtTongTien.setBounds(155, 908, 157, 37);
		add(txtTongTien);
		txtTongTien.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Hủy Bỏ");
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(1028, 908, 141, 42);
		add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Đặt Hàng");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
							refresh();

							JOptionPane.showMessageDialog(null, "Đặt hàng thành công!!");
							
						}else {
							JOptionPane.showMessageDialog(null, "Tiền khách gửi trước phải lớn hơn tiền cọc đã yêu cầu!!!");
						}
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền khách gửi!!!");
					}
				
				}else {
					daoChiTietDh = new DAO_chiTietKhachDH();
					
					daoKhachDh.add(new KhachDH(txtMaDH.getText(),txtMaKH.getText() , "NV001", new Date(), 0,0));
					int limit = table.getRowCount();
					model = (DefaultTableModel) table.getModel();
					for(int i=0;i<limit;i++) {
						daoChiTietDh.add(new ChiTietKhachDH(txtMaDH.getText(), model.getValueAt(i, 0).toString(), Integer.parseInt(model.getValueAt(i, 2).toString()), Double.parseDouble(model.getValueAt(i, 3).toString())));
					}
					refresh();
					JOptionPane.showMessageDialog(null, "Đặt hàng thành công!!");
				}
			}
		});
		btnNewButton_2_1.setBackground(new Color(0, 255, 0));
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2_1.setBounds(1204, 908, 141, 42);
		add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("In Hóa Đơn");
		btnNewButton_2_2.setBackground(new Color(255, 215, 0));
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2_2.setBounds(1368, 908, 141, 42);
		add(btnNewButton_2_2);
		
		JLabel lblNewLabel_6 = new JLabel("Tiền Cọc");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(380, 908, 81, 42);
		add(lblNewLabel_6);
		
		txtTienPhaiCoc = new JTextField();
		txtTienPhaiCoc.setEditable(false);
		txtTienPhaiCoc.setColumns(10);
		txtTienPhaiCoc.setBounds(461, 908, 157, 37);
		add(txtTienPhaiCoc);
		
		JLabel lblNewLabel_6_1 = new JLabel("Khách Gửi");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_1.setBounds(685, 908, 81, 42);
		add(lblNewLabel_6_1);
		
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
	private void refresh() {
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
