package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;

public class FormNVQuanLy extends JFrame {

	private JPanel contentPane;
	private Image img_logo = new ImageIcon(FormTimSach.class.getResource("/image/bookStore.png")).getImage().getScaledInstance(280, 200,Image.SCALE_SMOOTH );
	private Image img_employee = new ImageIcon(FormTimSach.class.getResource("/image/employee.jpg")).getImage().getScaledInstance(100, 50,Image.SCALE_SMOOTH );
	private Image img_user = new ImageIcon(FormTimSach.class.getResource("/image/user.png")).getImage().getScaledInstance(25, 25,Image.SCALE_SMOOTH );
	private Image img_logout = new ImageIcon(FormTimSach.class.getResource("/image/logout.png")).getImage().getScaledInstance(25, 25,Image.SCALE_SMOOTH );
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtNgaySinh;
	private JTextField txtMa;
	private JTextField txtEmail;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormNVQuanLy frame = new FormNVQuanLy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormNVQuanLy() {
		setAlwaysOnTop(true);
		setTitle("Nhan vien quan ly");
		
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(1936,1056);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 1936,1056);
		contentPane.setForeground(new Color(192, 192, 192));
		
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		JPanel northPanel = new JPanel();
		northPanel.setBounds(0, 0, 1920, 200);
		northPanel.setForeground(new Color(192, 192, 192));
		northPanel.setBackground(new Color(192, 192, 192));
		contentPane.add(northPanel);
		northPanel.setLayout(null);
		
		JLabel lblTenNV = new JLabel("User:");
		lblTenNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTenNV.setForeground(new Color(0, 0, 160));
		lblTenNV.setBounds(10, 970, 56, 14);
		northPanel.add(lblTenNV);
		
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(img_logo));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(70, 11, 250, 150);
		northPanel.add(lblLogo);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(396, 0, 1524, 29);
		northPanel.add(menuPanel);
		menuPanel.setLayout(null);
		
		JMenuBar mnBar = new JMenuBar();
		mnBar.setBounds(0, 0, 487, 30);
		mnBar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		menuPanel.add(mnBar);
		
		JMenu mnNhanVien = new JMenu("Nhân viên");
		mnNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		mnNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		mnBar.add(mnNhanVien);
		
		JMenuItem mnTimNV = new JMenuItem("Tìm nhân viên");
		mnTimNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnNhanVien.add(mnTimNV);
		
		JMenuItem mnQLNV = new JMenuItem("Quản lý nhân viên");
		mnQLNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnNhanVien.add(mnQLNV);
		
		JMenu mnPCC = new JMenu("Phân công ca");
		mnPCC.setFont(new Font("Times New Roman", Font.BOLD, 20));
		mnBar.add(mnPCC);
		
		JMenu mnSanPham = new JMenu("Sản phẩm");
		mnSanPham.setFont(new Font("Times New Roman", Font.BOLD, 20));
		mnBar.add(mnSanPham);
		
		JMenuItem mnTimSP = new JMenuItem("Tìm sản phẩm");
		mnTimSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnSanPham.add(mnTimSP);
		
		JMenu mnDatHang = new JMenu("Đặt hàng");
		mnDatHang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		mnBar.add(mnDatHang);
		
		JMenuItem mnTaoPhieuDH = new JMenuItem("Tạo phiếu đặt hàng");
		mnTaoPhieuDH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnDatHang.add(mnTaoPhieuDH);
		
		JMenu mnHelp = new JMenu("Trợ giúp");
		mnHelp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		mnBar.add(mnHelp);
		
		
		quanLyNhanVien();
	}
	public void quanLyNhanVien() {
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBounds(0, 200, 400, 817);
		contentPane.add(searchPanel);
		
		JLabel lblTen = new JLabel("Tên nhân viên:");
		lblTen.setForeground(new Color(0, 0, 160));
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTen.setBounds(10, 102, 130, 30);
		searchPanel.add(lblTen);
		
		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setForeground(new Color(0, 0, 160));
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSDT.setBounds(10, 225, 130, 30);
		searchPanel.add(lblSDT);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 0, 160));
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(10, 307, 130, 30);
		searchPanel.add(lblEmail);
		
		JLabel lblGT = new JLabel("Giới tính");
		lblGT.setForeground(new Color(0, 0, 160));
		lblGT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGT.setBounds(10, 143, 130, 30);
		searchPanel.add(lblGT);
		
		JLabel lblDoB = new JLabel("Ngày sinh:");
		lblDoB.setForeground(new Color(0, 0, 160));
		lblDoB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDoB.setBounds(10, 184, 130, 30);
		searchPanel.add(lblDoB);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTen.setColumns(10);
		txtTen.setBounds(205, 102, 160, 30);
		searchPanel.add(txtTen);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSDT.setColumns(10);
		txtSDT.setBounds(205, 225, 160, 30);
		searchPanel.add(txtSDT);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(205, 266, 160, 30);
		searchPanel.add(txtDiaChi);
		
		JComboBox cbGT = new JComboBox();
		cbGT.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbGT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbGT.setBounds(205, 143, 70, 30);
		searchPanel.add(cbGT);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(205, 184, 130, 30);
		searchPanel.add(txtNgaySinh);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSua.setBackground(new Color(0, 128, 255));
		btnSua.setBounds(140, 445, 100, 30);
		searchPanel.add(btnSua);
		
		JButton btnThem = new JButton("Tìm");
		btnThem.setForeground(new Color(0, 0, 160));
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThem.setBackground(Color.GREEN);
		btnThem.setBounds(10, 445, 100, 30);
		searchPanel.add(btnThem);
		
		JLabel lblTimNV = new JLabel("Quản lý nhân viên");
		lblTimNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimNV.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTimNV.setBounds(0, 0, 400, 50);
		searchPanel.add(lblTimNV);
		
		JLabel lblMa = new JLabel("Mã nhân viên:");
		lblMa.setForeground(new Color(0, 0, 160));
		lblMa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMa.setBounds(10, 61, 130, 30);
		searchPanel.add(lblMa);
		
		txtMa = new JTextField();
		txtMa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMa.setColumns(10);
		txtMa.setBounds(205, 61, 160, 30);
		searchPanel.add(txtMa);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setForeground(new Color(0, 0, 160));
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDiaChi.setBounds(10, 266, 130, 30);
		searchPanel.add(lblDiaChi);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(205, 307, 160, 30);
		searchPanel.add(txtEmail);
		
		JLabel lblChcV = new JLabel("Chức vụ:");
		lblChcV.setForeground(new Color(0, 0, 160));
		lblChcV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblChcV.setBounds(10, 348, 130, 30);
		searchPanel.add(lblChcV);
		
		JComboBox cbCV = new JComboBox();
		cbCV.setModel(new DefaultComboBoxModel(new String[] {"Quản lý", "Bán hàng"}));
		cbCV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbCV.setBounds(205, 354, 100, 30);
		searchPanel.add(cbCV);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(new Color(0, 0, 160));
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBounds(265, 445, 100, 30);
		searchPanel.add(btnXoa);
		
		JPanel tblPanel = new JPanel();
		tblPanel.setBounds(400, 200, 1520, 817);
		contentPane.add(tblPanel);
//		tblPanel.setLayout(null);
		String[] headers = { "STT", "Mã nhân viên", "Họ và tên", "Giới tính", "Ngày sinh", "SĐT", "Địa chỉ", "Email", "Chức vụ"};
		JTable table = new JTable();
		DefaultTableModel tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 1520, 817);
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
	}
	public void timNhanVien() {
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBounds(0, 200, 400, 817);
		contentPane.add(searchPanel);
		
		JLabel lblTen = new JLabel("Tên nhân viên");
		lblTen.setForeground(new Color(0, 0, 160));
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTen.setBounds(10, 192, 130, 30);
		searchPanel.add(lblTen);
		
		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setForeground(new Color(0, 0, 160));
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSDT.setBounds(10, 249, 130, 30);
		searchPanel.add(lblSDT);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 0, 160));
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(10, 290, 130, 30);
		searchPanel.add(lblEmail);
		
		JLabel lblGT = new JLabel("Giới tính");
		lblGT.setForeground(new Color(0, 0, 160));
		lblGT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGT.setBounds(10, 331, 130, 30);
		searchPanel.add(lblGT);
		
		JLabel lblDoB = new JLabel("Ngày sinh:");
		lblDoB.setForeground(new Color(0, 0, 160));
		lblDoB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDoB.setBounds(10, 372, 130, 30);
		searchPanel.add(lblDoB);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTen.setColumns(10);
		txtTen.setBounds(205, 192, 160, 30);
		searchPanel.add(txtTen);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSDT.setColumns(10);
		txtSDT.setBounds(205, 249, 160, 30);
		searchPanel.add(txtSDT);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(205, 290, 160, 30);
		searchPanel.add(txtDiaChi);
		
		JComboBox cbGT = new JComboBox();
		cbGT.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbGT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbGT.setBounds(205, 331, 100, 30);
		searchPanel.add(cbGT);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(205, 372, 100, 30);
		searchPanel.add(txtNgaySinh);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLamMoi.setBackground(new Color(0, 128, 255));
		btnLamMoi.setBounds(215, 445, 130, 50);
		searchPanel.add(btnLamMoi);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setForeground(new Color(0, 0, 160));
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnTim.setBackground(Color.GREEN);
		btnTim.setBounds(35, 445, 130, 50);
		searchPanel.add(btnTim);
		
		JLabel lblTimNV = new JLabel("Tìm nhân viên");
		lblTimNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTimNV.setBounds(0, 0, 400, 50);
		searchPanel.add(lblTimNV);
		
		JPanel tblPanel = new JPanel();
		tblPanel.setBounds(400, 200, 1520, 817);
		contentPane.add(tblPanel);
//		tblPanel.setLayout(null);
		String[] headers = { "STT", "Mã nhân viên", "Họ và tên", "Giới tính", "Ngày sinh", "SĐT", "Địa chỉ", "Email", "Chức vụ"};
		JTable table = new JTable();
		DefaultTableModel tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 1520, 817);
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
	}
}
