package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelKhXacNhanDatSach extends JPanel {
	private JTextField txtMaKH;
	private JTable table;
	private DefaultTableModel modelDonDatHang;
	private Object[] rowDatHang;
	
	private DefaultTableModel modelInfo;
	private Object[] rowInfo;
	private JTextField txtLoaiKH;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_1;
	
	/**
	 * Create the panel.
	 */
	public PanelKhXacNhanDatSach() {
		setBounds(0,0,1534,1017);
		setLayout(null);
		
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
		btnNewButton.setBounds(421, 114, 110, 34);
		add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 158, 814, 645);
		add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
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
		lblNewLabel_3.setBounds(837, 45, 98, 34);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(961, 46, 136, 34);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nhân Viên đặt Hàng");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(822, 90, 131, 34);
		add(lblNewLabel_3_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(961, 91, 191, 34);
		add(textField_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Khách Đặt Hàng");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1_1.setBounds(822, 135, 131, 34);
		add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Ngày Đặt Hàng");
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1_1_1.setBounds(822, 180, 131, 34);
		add(lblNewLabel_3_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(961, 136, 191, 34);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(961, 181, 191, 34);
		add(textField_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Danh Sách Đặt Hàng");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(1106, 215, 184, 34);
		add(lblNewLabel_2_1);
		modelInfo = new DefaultTableModel();
		
		JButton btnNewButton_2 = new JButton("Xác Nhận");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(1126, 748, 162, 45);
		add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("In Hóa Đơn");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setBounds(1344, 748, 162, 45);
		add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("Hủy Bỏ");
		btnNewButton_3.setBounds(913, 748, 151, 45);
		add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Thêm Sách");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(824, 702, 81, 34);
		add(lblNewLabel_4);
		
		JButton btnNewButton_4 = new JButton("Tìm");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(903, 702, 58, 34);
		add(btnNewButton_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mã Sách");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(971, 702, 66, 35);
		add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(1031, 702, 66, 34);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5_1 = new JLabel("Số Lượng");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_1.setBounds(1106, 702, 72, 35);
		add(lblNewLabel_5_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(1177, 702, 58, 34);
		add(textField_5);
		
		JButton btnNewButton_5 = new JButton("Thêm");
		btnNewButton_5.setBounds(1245, 703, 89, 34);
		add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Sửa]");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setBounds(1344, 703, 89, 34);
		add(btnNewButton_6);
		
		JButton btnNewButton_6_1 = new JButton("Xóa");
		btnNewButton_6_1.setBounds(1443, 703, 89, 34);
		add(btnNewButton_6_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(817, 243, 715, 448);
		add(scrollPane_2);
		
		table_1 = new JTable();
		modelInfo = new DefaultTableModel();
		rowInfo = new Object[6];
		String[] column2 = {"Mã Sản Phẩm","Tên Sản Phẩm","Số Lượng","Giá Bán","Discount","Thành Tiền"};
		modelInfo.setColumnIdentifiers(column2);
		table_1.setModel(modelInfo);
		scrollPane_2.setViewportView(table_1);
	}
}
