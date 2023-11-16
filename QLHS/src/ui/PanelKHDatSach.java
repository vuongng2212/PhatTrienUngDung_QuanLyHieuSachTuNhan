package ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PanelKHDatSach extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Create the panel.
	 */
	public PanelKHDatSach() {
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
		
		textField_1 = new JTextField();
		textField_1.setBounds(387, 11, 153, 33);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Tên Khách Hàng");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1.setBounds(665, 11, 115, 33);
		panel_1.add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(790, 12, 220, 33);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Loại Khách Hàng");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1_1.setBounds(1158, 11, 115, 33);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(1283, 11, 53, 33);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Số Điện Thoại");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_2.setBounds(277, 69, 105, 33);
		panel_1.add(lblNewLabel_2_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(387, 69, 153, 33);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Địa Chỉ");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1_2.setBounds(665, 69, 115, 33);
		panel_1.add(lblNewLabel_2_1_1_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(790, 70, 220, 33);
		panel_1.add(textField_5);
		
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
		
		textField_6 = new JTextField();
		textField_6.setBounds(338, 9, 76, 34);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Số Lượng");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1_1.setBounds(537, 11, 76, 29);
		panel_2.add(lblNewLabel_4_1_1);
		
		textField_7 = new JTextField();
		textField_7.setBounds(623, 11, 55, 34);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(848, 9, 108, 34);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Sửa");
		btnNewButton_1_1.setBounds(1010, 9, 108, 34);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Xóa");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setBounds(1166, 9, 108, 34);
		panel_2.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Làm Mới");
		btnNewButton_1_1_2.setBounds(1313, 9, 108, 34);
		panel_2.add(btnNewButton_1_1_2);
		
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
		lblNewLabel_5.setBounds(0, 908, 94, 42);
		add(lblNewLabel_5);
		
		textField_8 = new JTextField();
		textField_8.setBounds(98, 908, 157, 37);
		add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Hủy Bỏ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(921, 908, 141, 42);
		add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Thanh Toán");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2_1.setBounds(1141, 908, 141, 42);
		add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("In Hóa Đơn");
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2_2.setBounds(1349, 908, 141, 42);
		add(btnNewButton_2_2);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tiền Cọc");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(336, 908, 94, 37);
		add(lblNewLabel_5_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(436, 908, 157, 37);
		add(textField_9);
	}
}
