package ui;

import java.awt.Color;
import java.awt.Font;

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
import com.toedter.calendar.JDateChooser;

public class PanelTimNV extends JPanel {
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtMa;
	private JTextField txtEmail;
	/**
	 * Create the panel.
	 */
	public PanelTimNV() {
		setBounds(0, 200, 1920, 816);
		setLayout(null);
		JPanel westPanel = new JPanel();
		westPanel.setLayout(null);
		westPanel.setBounds(0, 0, 400, 817);
		add(westPanel);
		
		JLabel lblTen = new JLabel("Tên nhân viên");
		lblTen.setForeground(new Color(0, 0, 160));
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTen.setBounds(10, 192, 130, 30);
		westPanel.add(lblTen);
		
		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setForeground(new Color(0, 0, 160));
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSDT.setBounds(10, 249, 130, 30);
		westPanel.add(lblSDT);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 0, 160));
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(10, 290, 130, 30);
		westPanel.add(lblEmail);
		
		JLabel lblGT = new JLabel("Giới tính");
		lblGT.setForeground(new Color(0, 0, 160));
		lblGT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGT.setBounds(10, 331, 130, 30);
		westPanel.add(lblGT);
		
		JLabel lblDoB = new JLabel("Ngày sinh:");
		lblDoB.setForeground(new Color(0, 0, 160));
		lblDoB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDoB.setBounds(10, 372, 130, 30);
		westPanel.add(lblDoB);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTen.setColumns(10);
		txtTen.setBounds(205, 192, 160, 30);
		westPanel.add(txtTen);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSDT.setColumns(10);
		txtSDT.setBounds(205, 249, 160, 30);
		westPanel.add(txtSDT);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(205, 290, 160, 30);
		westPanel.add(txtDiaChi);
		
		JComboBox cbGT = new JComboBox();
		cbGT.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbGT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbGT.setBounds(205, 331, 100, 30);
		westPanel.add(cbGT);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLamMoi.setBackground(new Color(0, 128, 255));
		btnLamMoi.setBounds(215, 445, 130, 50);
		westPanel.add(btnLamMoi);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setForeground(new Color(0, 0, 160));
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnTim.setBackground(Color.GREEN);
		btnTim.setBounds(35, 445, 130, 50);
		westPanel.add(btnTim);
		
		JLabel lblTimNV = new JLabel("Tìm nhân viên");
		lblTimNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTimNV.setBounds(0, 0, 400, 50);
		westPanel.add(lblTimNV);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(205, 372, 160, 30);
		dateChooser.getDate();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		westPanel.add(dateChooser);
		
		JPanel tblPanel = new JPanel();
		tblPanel.setBounds(400, 200, 1520, 817);
		add(tblPanel);
//		tblPanel.setLayout(null);
		String[] headers = { "STT", "Mã nhân viên", "Họ và tên", "Giới tính", "Ngày sinh", "SĐT", "Địa chỉ", "Email", "Chức vụ"};
		DefaultTableModel tableModel = new DefaultTableModel(headers, 0);
		tblPanel.setLayout(null);
		JTable table = new JTable();
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(400, 0, 1520, 817);
		add(scroll);
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
	}
}
