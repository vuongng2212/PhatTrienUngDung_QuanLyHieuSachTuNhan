package ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelDatHang extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public PanelDatHang() {
		setBounds(0, 200, 1920, 816);
		setLayout(null);
		JPanel tblPanel = new JPanel();
		tblPanel.setBounds(0, 0, 1200, 816);
		add(tblPanel);
		String[] headers = { "STT", "Mã sách", "Tên sách", "Thể loại", "NXB", "Năm XB", "Số lượng", "Đơn giá", "Tình trạng", "Khuyến mãi"};
		JTable table = new JTable();
		DefaultTableModel tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 60, 1200, 700);
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tblPanel.setLayout(null);
		tblPanel.add(scroll);
		
		JLabel lblTimSach = new JLabel("Tìm sách:");
		lblTimSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTimSach.setBounds(10, 12, 90, 20);
		tblPanel.add(lblTimSach);
		
		JLabel lblTen = new JLabel("Tên sách");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTen.setBounds(110, 17, 70, 20);
		tblPanel.add(lblTen);
		
		textField = new JTextField();
		textField.setBounds(190, 16, 86, 20);
		tblPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTheLoai = new JLabel("Thể loại");
		lblTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTheLoai.setBounds(300, 17, 70, 20);
		tblPanel.add(lblTheLoai);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(380, 15, 105, 22);
		tblPanel.add(comboBox);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(0, 128, 255));
		btnTim.setBounds(1100, 11, 90, 30);
		tblPanel.add(btnTim);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(1100, 771, 90, 30);
		tblPanel.add(btnThem);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBackground(new Color(0, 255, 64));
		
		JLabel lblSL = new JLabel("Số lượng");
		lblSL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSL.setBounds(870, 771, 90, 30);
		tblPanel.add(lblSL);
		
		textField_1 = new JTextField();
		textField_1.setBounds(970, 771, 90, 30);
		tblPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNXB = new JLabel("Nhà XB:");
		lblNXB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNXB.setBounds(495, 19, 70, 20);
		tblPanel.add(lblNXB);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(575, 15, 105, 22);
		tblPanel.add(comboBox_1);
		
		JLabel lblNam = new JLabel("Năm XB");
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNam.setBounds(705, 19, 70, 20);
		tblPanel.add(lblNam);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(785, 15, 70, 22);
		tblPanel.add(comboBox_1_1);
		
		String[] headers1 = { "STT", "Mã sách", "Tên sách", "Thể loại", "Số lượng", "Đơn giá"};
		DefaultTableModel tableModel1 = new DefaultTableModel(headers1, 0);
		
		JPanel tbl = new JPanel();
		tbl.setBounds(1200, 0, 720, 816);
		add(tbl);
		JTable table1 = new JTable();
		JScrollPane scroll1 = new JScrollPane(table1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll1.setBounds(0, 58, 720, 656);
		scroll1.setViewportView(table1 = new JTable(tableModel1));
		table1.setRowHeight(25);
		table1.getColumnModel().getColumn(0).setPreferredWidth(30);
		table1.getColumnModel().getColumn(1).setPreferredWidth(100);
		table1.getColumnModel().getColumn(2).setPreferredWidth(200);
		table1.getColumnModel().getColumn(3).setPreferredWidth(50);
		table1.getColumnModel().getColumn(4).setPreferredWidth(100);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tbl.setLayout(null);
		tbl.add(scroll1);
		
//		JPanel westPanel = new JPanel();
//		westPanel.setBounds(0, 401, 600, 415);
//		westPanel.setLayout(null);
//		add(westPanel);
		JPanel tTDHPanel = new JPanel();
		scroll1.setColumnHeaderView(tTDHPanel);
		tTDHPanel.setLayout(null);
		
		JLabel lblHDDH = new JLabel("Danh sách đặt hàng");
		lblHDDH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHDDH.setBounds(280, 11, 178, 30);
		tbl.add(lblHDDH);
		
		JButton btnDH = new JButton("Đặt hàng");
		btnDH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDH.setBackground(new Color(0, 255, 64));
		btnDH.setBounds(580, 775, 130, 30);
		tbl.add(btnDH);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBounds(580, 725, 130, 30);
		tbl.add(btnXoa);
		
		JLabel lblChietKhau = new JLabel("Chiết khấu:");
		lblChietKhau.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChietKhau.setBounds(20, 735, 90, 30);
		tbl.add(lblChietKhau);
		
		JLabel lblThanhTien = new JLabel("Thành tiền");
		lblThanhTien.setForeground(new Color(255, 0, 0));
		lblThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThanhTien.setBounds(20, 776, 90, 30);
		tbl.add(lblThanhTien);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 738, 60, 30);
		tbl.add(textField_2);
		
		
	}
}
