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

public class FormTimNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtDoB;
	private JTable tbl;
	private Image img_logo = new ImageIcon(FormTimSach.class.getResource("/image/bookStore.png")).getImage().getScaledInstance(180, 130,Image.SCALE_SMOOTH );
	private Image img_employee = new ImageIcon(FormTimSach.class.getResource("/image/employee.jpg")).getImage().getScaledInstance(100, 50,Image.SCALE_SMOOTH );
	private Image img_user = new ImageIcon(FormTimSach.class.getResource("/image/user.png")).getImage().getScaledInstance(25, 25,Image.SCALE_SMOOTH );
	private Image img_logout = new ImageIcon(FormTimSach.class.getResource("/image/logout.png")).getImage().getScaledInstance(25, 25,Image.SCALE_SMOOTH );

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormTimNhanVien frame = new FormTimNhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormTimNhanVien() {
		setTitle("Nhan vien quan ly");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		contentPane = new JPanel();
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setLayout(null);
		getContentPane().add(contentPane, BorderLayout.CENTER);
		
		JPanel westPane = new JPanel();
		westPane.setForeground(new Color(192, 192, 192));
		westPane.setBackground(new Color(192, 192, 192));
		westPane.setBounds(0, 0, 200, 561);
		contentPane.add(westPane);
		westPane.setLayout(null);
		
		JLabel lblTenNV = new JLabel("User:");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTenNV.setForeground(new Color(0, 0, 160));
		lblTenNV.setBounds(10, 520, 56, 14);
		westPane.add(lblTenNV);
		
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(img_logo));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(10, 11, 180, 80);
		westPane.add(lblLogo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(43, 102, 101, 150);
		westPane.add(menuBar);
		menuBar.setLayout(new GridLayout(0,1));
//		JPanel panel = new JPanel();
//		panel.setBounds(10, 111, 180, 398);
//		westPane.add(panel);
		
		JMenu mnNhanVien = new JMenu("Nhân viên");
		menuBar.add(mnNhanVien);
		
		JMenuItem mnQLNV = new JMenuItem("Quản lý nhân viên");
		mnQLNV.setHorizontalAlignment(SwingConstants.CENTER);
		mnNhanVien.add(mnQLNV);
		
		JMenuItem mnTimNV = new JMenuItem("Tìm nhân viên");
		mnTimNV.setHorizontalAlignment(SwingConstants.CENTER);
		mnNhanVien.add(mnTimNV);
		
		JMenu mnCa = new JMenu("Phân công ca");
		menuBar.add(mnCa);
		
		JMenu mnSanPham = new JMenu("Sản phẩm");
		menuBar.add(mnSanPham);
		
		JMenuItem mnTimSP = new JMenuItem("Tìm sản phẩm");
		mnSanPham.add(mnTimSP);
		
		JMenu mnDatHang = new JMenu("Đặt hàng");
		menuBar.add(mnDatHang);
		
		JMenuItem mnTaoPhieuDH = new JMenuItem("Tạo phiếu đặt hàng");
		mnDatHang.add(mnTaoPhieuDH);
		
		JMenu mnHelp = new JMenu("Trợ giúp");
		menuBar.add(mnHelp);
		
		
//		JMenuBar menuBar = new JMenuBar();
//		menuBar.setLayout(new GridLayout(0,1));
//		menuBar.setBounds(89, 102, 101, 150);
//		JMenu fileMenu = new JMenu("Nhân viên");
//		menuBar.add(fileMenu);
//		JMenuItem menuItem1 = new JMenuItem("Quản lý nhân viên", KeyEvent.VK_N);
//	    fileMenu.add(menuItem1);
//	    JMenuItem menuItem2 = new JMenuItem("Tìm nhân viên", KeyEvent.VK_O);
//	    fileMenu.add(menuItem2);
//	    JMenu editMenu = new JMenu("Edit");
//	    editMenu.setMnemonic(KeyEvent.VK_E);
//	    menuBar.add(editMenu);
//	    JMenuItem menuItem3 = new JMenuItem("Cut", KeyEvent.VK_C);
//	    editMenu.add(menuItem3);
//	    JMenu sourceMenu = new JMenu("Source");
//	    sourceMenu.setMnemonic(KeyEvent.VK_S);
//	    menuBar.add(sourceMenu);
//	    JMenu refactorMenu = new JMenu("Refactor");
//	    refactorMenu.setMnemonic(KeyEvent.VK_R);
//	    menuBar.add(refactorMenu);
//		westPane.add(menuBar);
		
		JPanel headPanel = new JPanel();
		headPanel.setForeground(new Color(192, 192, 192));
		headPanel.setBackground(new Color(192, 192, 192));
		headPanel.setBounds(199, 0, 685, 50);
		contentPane.add(headPanel);
		headPanel.setLayout(null);
		
		JLabel lblTieuDe = new JLabel("Tìm nhân viên");
		lblTieuDe.setForeground(new Color(0, 0, 160));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTieuDe.setBounds(10, 11, 675, 28);
		headPanel.add(lblTieuDe);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(199, 49, 685, 174);
		contentPane.add(searchPanel);
		searchPanel.setLayout(null);
		
		JLabel lblTen = new JLabel("Tên nhân viên");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTen.setForeground(new Color(0, 0, 160));
		lblTen.setBounds(50, 11, 90, 14);
		searchPanel.add(lblTen);
		
		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSDT.setForeground(new Color(0, 0, 160));
		lblSDT.setBounds(50, 48, 90, 14);
		searchPanel.add(lblSDT);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setForeground(new Color(0, 0, 160));
		lblEmail.setBounds(50, 87, 90, 14);
		searchPanel.add(lblEmail);
		
		JLabel lblGT = new JLabel("Giới tính");
		lblGT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGT.setForeground(new Color(0, 0, 160));
		lblGT.setBounds(440, 11, 70, 14);
		searchPanel.add(lblGT);
		
		JLabel lblDoB = new JLabel("Ngày sinh:");
		lblDoB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDoB.setForeground(new Color(0, 0, 160));
		lblDoB.setBounds(440, 48, 70, 14);
		searchPanel.add(lblDoB);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTen.setBounds(150, 8, 160, 20);
		searchPanel.add(txtTen);
		txtTen.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSDT.setColumns(10);
		txtSDT.setBounds(150, 45, 160, 20);
		searchPanel.add(txtSDT);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		txtEmail.setBounds(150, 84, 160, 20);
		searchPanel.add(txtEmail);
		
		JComboBox cbGT = new JComboBox();
		cbGT.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbGT.setBounds(520, 8, 60, 22);
		searchPanel.add(cbGT);
		
		txtDoB = new JTextField();
		txtDoB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDoB.setColumns(10);
		txtDoB.setBounds(520, 45, 100, 20);
		searchPanel.add(txtDoB);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(new Color(0, 128, 255));
		btnLamMoi.setBounds(550, 121, 100, 30);
		searchPanel.add(btnLamMoi);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(0, 255, 0));
		btnTim.setForeground(new Color(0, 0, 160));
		btnTim.setBounds(440, 121, 100, 30);
		searchPanel.add(btnTim);
		
//		JPanel tblPanel = new JPanel();
//		tblPanel.setBounds(199, 221, 685, 340);
//		JTable table = new JTable();
//		String[] headers = "STT;Mã nhân viên;Họ và tên;Giới tính; Ngày sinh;SDT;Địa chỉ;Email".split(";");
//		DefaultTableModel tableModel = new DefaultTableModel(headers, 0);
//		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
//				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scroll.setViewportView(table = new JTable(tableModel));
//		table.setRowHeight(25);
//		table.setAutoCreateRowSorter(true);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		tblPanel.add(scroll);
//		contentPane.add(tblPanel);

	}
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
}
