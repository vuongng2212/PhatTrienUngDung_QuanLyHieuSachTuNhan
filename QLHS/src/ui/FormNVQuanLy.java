package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

//	private JPanel contentPane,westPanel, tblPanel;
	private JPanel contentPane;
	private JMenu mnBar, mnTrangChu, mnNhanVien, mnPCC, mnSanPham, mnDatHang, mnHelp;
	private JMenuItem mnTimNV, mnQLNV, mnTimSP, mnTaoPhieuDH;
	JLabel lblBG;
	private Image img_logo = new ImageIcon(FormNVQuanLy.class.getResource("/image/bookStore.png")).getImage().getScaledInstance(280, 200,Image.SCALE_SMOOTH );
	private Image img_employee = new ImageIcon(FormNVQuanLy.class.getResource("/image/employee.jpg")).getImage().getScaledInstance(100, 50,Image.SCALE_SMOOTH );
	private Image img_user = new ImageIcon(FormNVQuanLy.class.getResource("/image/user.png")).getImage().getScaledInstance(25, 25,Image.SCALE_SMOOTH );
	private Image img_logout = new ImageIcon(FormNVQuanLy.class.getResource("/image/logout.png")).getImage().getScaledInstance(25, 25,Image.SCALE_SMOOTH );
	private Image img_background = new ImageIcon(FormNVQuanLy.class.getResource("/image/title.jpg")).getImage().getScaledInstance(1920, 816,Image.SCALE_SMOOTH );
	private PanelTimNV PnTimNV = new PanelTimNV();
	private PanelDatHang pnDH = new PanelDatHang();
	private PanelQLNV pnQLNV = new PanelQLNV();

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
		mnBar.setBounds(0, 0, 600, 50);
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
		
		mnPCC = new JMenu("Phân công ca");
		mnPCC.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnBar.add(mnPCC);
		
		mnSanPham = new JMenu("Sản phẩm");
		mnSanPham.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnBar.add(mnSanPham);
		
		mnTimSP = new JMenuItem("Tìm sản phẩm");
		mnTimSP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnSanPham.add(mnTimSP);
		
		mnDatHang = new JMenu("Đặt hàng");
		mnDatHang.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnBar.add(mnDatHang);
		
		mnTaoPhieuDH = new JMenuItem("Tạo phiếu đặt hàng");
		mnTaoPhieuDH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mnDatHang.add(mnTaoPhieuDH);
		
		mnHelp = new JMenu("Trợ giúp");
		mnHelp.setFont(new Font("Tahoma", Font.BOLD, 20));
		mnBar.add(mnHelp);
		
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
		mnTaoPhieuDH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearPanel();
				contentPane.add(pnDH);
				pnDH.setVisible(true);
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
}
