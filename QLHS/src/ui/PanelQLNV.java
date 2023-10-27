package ui;

import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

import com.toedter.calendar.JDateChooser;

public class PanelQLNV extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelQLNV() {
		setBounds(0, 200, 1920, 816);
		setLayout(null);
		
		JPanel westPanel = new JPanel();
		westPanel.setLayout(null);
		westPanel.setBounds(0, 0, 400, 817);
		add(westPanel);
		
		JLabel lblTen = new JLabel("Tên nhân viên:");
		lblTen.setForeground(new Color(0, 0, 160));
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTen.setBounds(10, 102, 150, 30);
		westPanel.add(lblTen);
		
		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setForeground(new Color(0, 0, 160));
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSDT.setBounds(10, 225, 130, 30);
		westPanel.add(lblSDT);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 0, 160));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(10, 307, 130, 30);
		westPanel.add(lblEmail);
		
		JLabel lblGT = new JLabel("Giới tính");
		lblGT.setForeground(new Color(0, 0, 160));
		lblGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGT.setBounds(10, 143, 130, 30);
		westPanel.add(lblGT);
		
		JLabel lblDoB = new JLabel("Ngày sinh:");
		lblDoB.setForeground(new Color(0, 0, 160));
		lblDoB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDoB.setBounds(10, 184, 130, 30);
		westPanel.add(lblDoB);
		
		JTextField txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTen.setColumns(10);
		txtTen.setBounds(205, 102, 160, 30);
		westPanel.add(txtTen);
		
		JTextField txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSDT.setColumns(10);
		txtSDT.setBounds(205, 225, 160, 30);
		westPanel.add(txtSDT);
		
		JTextField txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(205, 266, 160, 30);
		westPanel.add(txtDiaChi);
		
		JComboBox cbGT = new JComboBox();
		cbGT.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbGT.setBounds(205, 143, 70, 30);
		westPanel.add(cbGT);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSua.setBackground(new Color(0, 128, 255));
		btnSua.setBounds(140, 445, 100, 30);
		westPanel.add(btnSua);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(new Color(0, 0, 160));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBackground(Color.GREEN);
		btnThem.setBounds(10, 445, 100, 30);
		westPanel.add(btnThem);
		
		JLabel lblTimNV = new JLabel("Quản lý nhân viên");
		lblTimNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimNV.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTimNV.setBounds(0, 0, 400, 50);
		westPanel.add(lblTimNV);
		
		JLabel lblMa = new JLabel("Mã nhân viên:");
		lblMa.setForeground(new Color(0, 0, 160));
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMa.setBounds(10, 61, 130, 30);
		westPanel.add(lblMa);
		
		JTextField txtMa = new JTextField();
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMa.setColumns(10);
		txtMa.setBounds(205, 61, 160, 30);
		westPanel.add(txtMa);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setForeground(new Color(0, 0, 160));
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiaChi.setBounds(10, 266, 130, 30);
		westPanel.add(lblDiaChi);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(205, 307, 160, 30);
		westPanel.add(txtEmail);
		
		JLabel lblChcV = new JLabel("Chức vụ:");
		lblChcV.setForeground(new Color(0, 0, 160));
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChcV.setBounds(10, 348, 130, 30);
		westPanel.add(lblChcV);
		
		JComboBox cbCV = new JComboBox();
		cbCV.setModel(new DefaultComboBoxModel(new String[] {"Quản lý", "Bán hàng"}));
		cbCV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbCV.setBounds(205, 354, 100, 30);
		westPanel.add(cbCV);
		
		JButton btnXoa = new JButton("Xóa");
		
		btnXoa.setForeground(new Color(0, 0, 160));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBounds(265, 445, 100, 30);
		westPanel.add(btnXoa);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(205, 184, 160, 30);
		dateChooser.getDate();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		westPanel.add(dateChooser);
		
		
		String[] headers = { "STT", "Mã nhân viên", "Họ và tên", "Giới tính", "Ngày sinh", "SĐT", "Địa chỉ", "Email", "Chức vụ"};
		DefaultTableModel tableModel = new DefaultTableModel(headers, 0);
		JTable table = new JTable();
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(400, 0, 1520, 817);
		add(scroll);
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.getColumnModel().getColumn(4).setPreferredWidth(10);
		table.getColumnModel().getColumn(6).setPreferredWidth(10);
		table.getColumnModel().getColumn(7).setPreferredWidth(10);
		table.getColumnModel().getColumn(8).setPreferredWidth(1000);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	}
}
