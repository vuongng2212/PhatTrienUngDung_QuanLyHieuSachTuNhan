package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import entity.Country;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuKeyEvent;


public class FormNVQuanLy extends JFrame{
	List<Country>listCountries = new ArrayList<Country>();
//	private JPanel contentPane,westPanel, tblPanel;
	private JPanel contentPane;
	private JMenu mnBar, mnTrangChu, mnNhanVien, mnPCC, mnSanPham, mnHelp;
	private JMenuItem mnTimNV, mnQLNV, mnTimSP, mnTaoPhieuDH;
	private JLabel lblBG;
	private JComboBox comboBox;
	private Image img_logo = new ImageIcon(FormNVQuanLy.class.getResource("/image/bookStore.png")).getImage().getScaledInstance(280, 200,Image.SCALE_SMOOTH );
	private Image img_employee = new ImageIcon(FormNVQuanLy.class.getResource("/image/employee.jpg")).getImage().getScaledInstance(100, 50,Image.SCALE_SMOOTH );
	private Image img_user = new ImageIcon(FormNVQuanLy.class.getResource("/image/user.png")).getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH );
	private Image img_logout = new ImageIcon(FormNVQuanLy.class.getResource("/image/logout.png")).getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH );
	private Image img_background = new ImageIcon(FormNVQuanLy.class.getResource("/image/title.jpg")).getImage().getScaledInstance(1920, 816,Image.SCALE_SMOOTH );
	private PanelTimNV PnTimNV = new PanelTimNV();
	private PanelDatHang pnDH = new PanelDatHang();
	private PanelQLNV pnQLNV = new PanelQLNV();
	private JLabel lblAccountIcon;

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
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenNV.setForeground(new Color(0, 0, 160));
		lblTenNV.setBounds(10, 970, 56, 14);
		northPanel.add(lblTenNV);
		
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(img_logo));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(70, 11, 250, 150);
		northPanel.add(lblLogo);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(192, 192, 192));
		menuPanel.setBounds(396, 0, 1524, 50);
		northPanel.add(menuPanel);
		menuPanel.setLayout(null);
		
		JMenuBar mnBar = new JMenuBar();
		mnBar.setBackground(new Color(255, 255, 255));
		mnBar.setBounds(0, 0, 700, 50);
		mnBar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		menuPanel.add(mnBar);
		
		mnTrangChu = new JMenu("Trang chủ");
		mnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnBar.add(mnTrangChu);
		
		mnNhanVien = new JMenu("Nhân viên");
		mnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		mnBar.add(mnNhanVien);
		
		
		
		mnTimNV = new JMenuItem("Tìm nhân viên");
		mnTimNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnNhanVien.add(mnTimNV);
		
		mnQLNV = new JMenuItem("Quản lý nhân viên");
		mnQLNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnNhanVien.add(mnQLNV);
		
		mnTaoPhieuDH = new JMenuItem("Tạo phiếu đặt sách");
		mnNhanVien.add(mnTaoPhieuDH);
		mnTaoPhieuDH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnTaoPhieuDH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearPanel();
				contentPane.add(pnDH);
				pnDH.setVisible(true);
			}
		});
		
		mnPCC = new JMenu("Ca làm việc");
		mnPCC.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnBar.add(mnPCC);
		
		mnSanPham = new JMenu("Sách");
		mnSanPham.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnBar.add(mnSanPham);
		
		mnTimSP = new JMenuItem("Tìm sách");
		mnTimSP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnSanPham.add(mnTimSP);
		
		mnHelp = new JMenu("Trợ giúp");
		mnHelp.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnBar.add(mnHelp);
		
		JLabel lblDate = new JLabel("");
		lblDate.setBounds(105, 161, 180, 18);
		northPanel.add(lblDate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE,dd/MM/yyyy",new Locale("vi"));
		String currentDate = dateFormat.format(new Date());
		lblDate.setText(currentDate);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblAccountIcon = new JLabel("");
		lblAccountIcon.setIcon(new ImageIcon(img_user));
		lblAccountIcon.setBounds(1520, 95, 60, 60);
		northPanel.add(lblAccountIcon);
		
		JButton btnLogOut = new JButton("");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm lg = new LoginForm();
				lg.setVisible(true);
				FormNVQuanLy.this.dispose();	
			}
		});
		btnLogOut.setBackground(new Color(192, 192, 192));
		btnLogOut.setIcon(new ImageIcon(img_logout));
		btnLogOut.setBounds(1850, 95, 60, 60);
		northPanel.add(btnLogOut);
		
		JLabel lblNgonNgu = new JLabel("Ngôn ngữ");
		lblNgonNgu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgonNgu.setBounds(1720, 160, 80, 20);
		northPanel.add(lblNgonNgu);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(1810, 162, 100, 20);
		FillCountries();
		northPanel.add(comboBox);
		
		lblBG = new JLabel("");
		lblBG.setIcon(new ImageIcon(img_background));
		lblBG.setBounds(0, 200, 1920, 816);
		clearPanel();
		contentPane.add(lblBG);
		
		mnTimNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearPanel();
				contentPane.add(PnTimNV);
				PnTimNV.setVisible(true);
			}
		});
		mnQLNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearPanel();
				contentPane.add(pnQLNV);
				pnQLNV.setVisible(true);
			}
		});
		mnTrangChu.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				clearPanel();
				contentPane.add(lblBG);
			}
		});
	}
	public void clearPanel() {
		contentPane.remove(lblBG);
		PnTimNV.setVisible(false);
		pnDH.setVisible(false);
		pnQLNV.setVisible(false);
	}
	private void FillCountries() {
		listCountries.add(new Country("vi-VN", "VietNam", new Font("Tahoma", Font.BOLD, 20)));
		listCountries.add(new Country("en-US","English",new Font("Tahoma", Font.BOLD, 20)));
//		listCountries.add(new Country("ja-JP","Japan",new Font("MS Gothic", Font.PLAIN, 20)));
		for (Country country : listCountries) {
			comboBox.addItem(country.getName());
		}
	}
}
