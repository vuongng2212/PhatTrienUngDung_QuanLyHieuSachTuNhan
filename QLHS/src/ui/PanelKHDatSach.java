package ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PanelKHDatSach extends JPanel {
	
	private Image img_kinhLup = new ImageIcon(frmNV.class.getResource("/image/kinhLup.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private JTextField textField;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtLoaiKh;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtMaSach;
	private JTextField txtSoLuong;
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	private DialogAddKH2 dialog;

	/**
	 * Create the panel.
	 */
	public PanelKHDatSach() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
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
		
		textField = new JTextField();
		textField.setBounds(98, 92, 76, 37);
		add(textField);
		textField.setColumns(10);
		
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
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setBounds(837, 9, 108, 34);
		panel_2.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(1010, 9, 108, 34);
		panel_2.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setBounds(1166, 9, 108, 34);
		panel_2.add(btnXoa);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setBounds(1313, 9, 108, 34);
		panel_2.add(btnLamMoi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 396, 1534, 501);
		add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		row = new Object[5];
		String[] column = {"Mã Sách","Tên Sách","Số Lượng","Giá Bán","Discount","Thành Tiền"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("Tổng Tiền");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(51, 908, 94, 42);
		add(lblNewLabel_5);
		
		JTextField txtTongTien = new JTextField();
		txtTongTien.setBounds(155, 908, 157, 37);
		add(txtTongTien);
		txtTongTien.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Hủy Bỏ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(789, 908, 141, 42);
		add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Đặt Hàng");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2_1.setBounds(1064, 908, 141, 42);
		add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("In Hóa Đơn");
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2_2.setBounds(1325, 908, 141, 42);
		add(btnNewButton_2_2);
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
}
