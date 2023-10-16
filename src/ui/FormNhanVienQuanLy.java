package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

public class FormNhanVienQuanLy extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtDoB;
	private JTable tbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormNhanVienQuanLy frame = new FormNhanVienQuanLy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormNhanVienQuanLy() {
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
		
		JButton btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setBounds(90, 100, 100, 50);
		westPane.add(btnNhanVien);
		
		JButton btnPhanCongCa = new JButton("Phân công ca");
		btnPhanCongCa.setBounds(90, 180, 100, 50);
		westPane.add(btnPhanCongCa);
		
		JButton btnSanPham = new JButton("Sản phẩm");
		btnSanPham.setBounds(90, 260, 100, 50);
		westPane.add(btnSanPham);
		
		JButton btnDatHang = new JButton("Đặt hàng");
		btnDatHang.setBounds(90, 340, 100, 50);
		westPane.add(btnDatHang);
		
		JButton btnHelp = new JButton("Trợ giúp");
		btnHelp.setBounds(90, 420, 100, 50);
		westPane.add(btnHelp);
		
		JLabel lblTenNV = new JLabel("User:");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTenNV.setForeground(new Color(0, 0, 160));
		lblTenNV.setBounds(10, 520, 56, 14);
		westPane.add(lblTenNV);
		
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 180, 80);
		westPane.add(lblNewLabel);
		
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
//		contentPane.add(tblPanel);
//		String[] collumns = {
//			"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
//		};
//		tbl = new JTable(null,collumns);
//		tbl.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
//			}
//		));
//		JScrollPane sp = new JScrollPane(tbl);
//		contentPane.add(sp);
//		tblPanel.add(tbl);
	}
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
}
