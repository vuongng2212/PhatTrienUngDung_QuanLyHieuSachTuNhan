package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FormTimSach extends JFrame {
	private JPanel contentPane;
	private Image img_logo = new ImageIcon(FormTimSach.class.getResource("/image/bookStore.png")).getImage().getScaledInstance(200, 200,Image.SCALE_SMOOTH );
	private Image img_system = new ImageIcon(FormTimSach.class.getResource("/image/system_icon.png")).getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH );
	private Image img_product = new ImageIcon(FormTimSach.class.getResource("/image/product_icon.png")).getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH );
	private Image img_payment = new ImageIcon(FormTimSach.class.getResource("/image/payment_icon.png")).getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH );
	private Image img_thongKe = new ImageIcon(FormTimSach.class.getResource("/image/thongKe_icon.png")).getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH );
	private Image img_customer = new ImageIcon(FormTimSach.class.getResource("/image/customer_icon.png")).getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH );
	private Image img_user = new ImageIcon(FormTimSach.class.getResource("/image/user.png")).getImage().getScaledInstance(25, 25,Image.SCALE_SMOOTH );
	private Image img_logout = new ImageIcon(FormTimSach.class.getResource("/image/logout.png")).getImage().getScaledInstance(25, 25,Image.SCALE_SMOOTH );
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDanhMuc;
	private JTextField txtTacGia;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	
	//	private Image img_ = new ImageIcon(NvFrm.class.getResource("/image/system_icon.png")).getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH );

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormTimSach frame = new FormTimSach();
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
	public FormTimSach() {
		setBackground(new Color(0, 255, 255));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 555);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(217,217,217));
		panelMenu.setBounds(0, 0, 224, 555);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		//Logo BookStore
		JLabel lbllconLogo = new JLabel("");
		lbllconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbllconLogo.setBounds(0, 1, 223, 129);
		lbllconLogo.setIcon(new ImageIcon(img_logo));
		panelMenu.add(lbllconLogo);
		
		JPanel panelSanPham = new JPanel();
		panelSanPham.setLayout(null);
		panelSanPham.setForeground(Color.CYAN);
		panelSanPham.setBorder(null);
		panelSanPham.setBackground(new Color(217,217,217));
		panelSanPham.setBounds(0, 194, 276, 54);
		panelMenu.add(panelSanPham);
		//Logo San Pham
//		JLabel lbllSanPham = new JLabel("");
//		lbllSanPham.setHorizontalAlignment(SwingConstants.CENTER);
//		lbllSanPham.setBounds(0, 1, 243, 129);
//		lbllSanPham.setIcon(new ImageIcon(img_logo));
//		lbllSanPham.add(lbllconLogo);
		JLabel lbllSanPham = new JLabel("Sản Phẩm");
		lbllSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		lbllSanPham.setForeground(new Color(88,217,139));
		lbllSanPham.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllSanPham.setBounds(73, 0, 150, 54);
		panelSanPham.add(lbllSanPham);
		
		JLabel iconSanPham = new JLabel("");
		iconSanPham.setHorizontalAlignment(SwingConstants.CENTER);
		iconSanPham.setBounds(0, 0, 66, 54);
		panelSanPham.add(iconSanPham);
		iconSanPham.setIcon(new ImageIcon(img_product));
		
		JPanel panelHoaDon = new JPanel();
		panelHoaDon.setLayout(null);
		panelHoaDon.setForeground(Color.CYAN);
		panelHoaDon.setBorder(null);
		panelHoaDon.setBackground(new Color(217,217,217));
		panelHoaDon.setBounds(0, 248, 373, 54);
		panelMenu.add(panelHoaDon);
		
		JLabel lbllHoaDon = new JLabel("Hóa Đơn");
		lbllHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		lbllHoaDon.setForeground(new Color(88,217,139));
		lbllHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllHoaDon.setBounds(77, 0, 144, 54);
		panelHoaDon.add(lbllHoaDon);
		
		JLabel icon_hoaDon = new JLabel("");
		icon_hoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		icon_hoaDon.setBounds(0, 0, 67, 54);
		panelHoaDon.add(icon_hoaDon);
		icon_hoaDon.setIcon(new ImageIcon(img_payment));
		
		JPanel panelKhachHang = new JPanel();
		panelKhachHang.setLayout(null);
		panelKhachHang.setForeground(Color.CYAN);
		panelKhachHang.setBorder(null);
		panelKhachHang.setBackground(new Color(217,217,217));
		panelKhachHang.setBounds(0, 302, 276, 54);
		panelMenu.add(panelKhachHang);
		
		JLabel lbllKhachHang = new JLabel("Khách Hàng");
		lbllKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		lbllKhachHang.setForeground(new Color(88,217,139));
		lbllKhachHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllKhachHang.setBounds(77, 0, 144, 54);
		panelKhachHang.add(lbllKhachHang);
		
		JLabel icon_khachHang = new JLabel("");
		icon_khachHang.setHorizontalAlignment(SwingConstants.CENTER);
		icon_khachHang.setBounds(0, 0, 67, 54);
		icon_khachHang.setIcon(new ImageIcon(img_customer));
		panelKhachHang.add(icon_khachHang);
		
		JPanel panelThongKe = new JPanel();
		panelThongKe.setLayout(null);
		panelThongKe.setForeground(Color.CYAN);
		panelThongKe.setBorder(null);
		panelThongKe.setBackground(new Color(217,217,217));
		panelThongKe.setBounds(0, 356, 276, 54);
		panelMenu.add(panelThongKe);
		
		JLabel lbllThongKe = new JLabel("Thống Kê");
		lbllThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		lbllThongKe.setForeground(new Color(88,217,139));
		lbllThongKe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllThongKe.setBounds(77, 0, 145, 54);
		panelThongKe.add(lbllThongKe);
		
		JLabel icon_thongKe = new JLabel("");
		icon_thongKe.setHorizontalAlignment(SwingConstants.CENTER);
		icon_thongKe.setBounds(0, 0, 67, 54);
		icon_thongKe.setIcon(new ImageIcon(img_thongKe));
		panelThongKe.add(icon_thongKe);
		
		JPanel panelHeThong = new JPanel();
		panelHeThong.setLayout(null);
		panelHeThong.setForeground(Color.CYAN);
		panelHeThong.setBorder(null);
		panelHeThong.setBackground(new Color(217,217,217));
		panelHeThong.setBounds(0, 140, 276, 54);
		panelMenu.add(panelHeThong);
		
		// He thong
		JLabel lblHeThong = new JLabel("Hệ Thống");
		lblHeThong.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeThong.setForeground(new Color(88,217,139));
		lblHeThong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHeThong.setBounds(76, 0, 172, 54);
		panelHeThong.add(lblHeThong);
		
		JLabel lbllHeThong = new JLabel("");
		lbllHeThong.setBounds(0, 0, 66, 54);
		panelHeThong.add(lbllHeThong);
		lbllHeThong.setHorizontalAlignment(SwingConstants.CENTER);
		lbllHeThong.setIcon(new ImageIcon(img_system));
		
		JLabel icon_user = new JLabel("");
		icon_user.setHorizontalAlignment(SwingConstants.CENTER);
		icon_user.setBounds(10, 481, 39, 48);
		icon_user.setIcon(new ImageIcon(img_user));
		panelMenu.add(icon_user);
		
		JLabel icon_logout = new JLabel("");
		icon_logout.setHorizontalAlignment(SwingConstants.CENTER);
		icon_logout.setBounds(162, 481, 39, 32);
		icon_logout.setIcon(new ImageIcon(img_logout));
		panelMenu.add(icon_logout);
		
		JLabel lbllUser = new JLabel("User:");
		lbllUser.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbllUser.setBounds(59, 499, 45, 13);
		panelMenu.add(lbllUser);
		
		JLabel lblNewLabel = new JLabel("Văn A");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(101, 499, 64, 13);
		panelMenu.add(lblNewLabel);
		
		JPanel panelPayment = new JPanel();
		panelPayment.setBounds(221, 0, 793, 555);
		contentPane.add(panelPayment);
		panelPayment.setLayout(null);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setLayout(null);
		panelSearch.setBackground(new Color(57, 189, 218));
		panelSearch.setBounds(0, 0, 792, 102);
		panelPayment.add(panelSearch);
		
		JLabel lblTim = new JLabel("Tìm Kiếm Sách:");
		lblTim.setForeground(Color.WHITE);
		lblTim.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTim.setBounds(10, 10, 118, 20);
		panelSearch.add(lblTim);
		
		JLabel lbllMaSach = new JLabel("Mã Sách:");
		lbllMaSach.setForeground(Color.WHITE);
		lbllMaSach.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbllMaSach.setBounds(10, 40, 62, 20);
		panelSearch.add(lbllMaSach);
		
		txtMa = new JTextField();
		txtMa.setColumns(10);
		txtMa.setBounds(73, 42, 108, 18);
		panelSearch.add(txtMa);
		
		JLabel lbllTenSach = new JLabel("Tên Sách:");
		lbllTenSach.setForeground(Color.WHITE);
		lbllTenSach.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbllTenSach.setBounds(191, 40, 72, 20);
		panelSearch.add(lbllTenSach);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(259, 42, 136, 18);
		panelSearch.add(txtTen);
		
		JLabel lbllTDanhMuc = new JLabel("Danh Mục:");
		lbllTDanhMuc.setForeground(Color.WHITE);
		lbllTDanhMuc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbllTDanhMuc.setBounds(405, 40, 79, 20);
		panelSearch.add(lbllTDanhMuc);
		
		txtDanhMuc = new JTextField();
		txtDanhMuc.setColumns(10);
		txtDanhMuc.setBounds(479, 42, 118, 20);
		panelSearch.add(txtDanhMuc);
		
		JLabel lbllTacGia = new JLabel("Tác Giả:");
		lbllTacGia.setForeground(Color.WHITE);
		lbllTacGia.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbllTacGia.setBounds(608, 40, 62, 20);
		panelSearch.add(lbllTacGia);
		
		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(667, 42, 115, 20);
		panelSearch.add(txtTacGia);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 101, 793, 205);
		panelPayment.add(panel);
		
		JPanel panelAdd = new JPanel();
		panelAdd.setBounds(0, 307, 365, 35);
		panelPayment.add(panelAdd);
		panelAdd.setLayout(null);
		
		JLabel lbllAccount = new JLabel("Số Lượng:");
		lbllAccount.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lbllAccount.setBounds(10, 4, 65, 21);
		panelAdd.add(lbllAccount);
		
		textField_4 = new JTextField();
		textField_4.setBounds(73, 0, 34, 30);
		panelAdd.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAddSP = new JButton("Thêm");
		btnAddSP.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddSP.setHorizontalAlignment(SwingConstants.LEADING);
		btnAddSP.setBounds(160, 4, 65, 21);
		btnAddSP.setBackground(new Color(92,206,38));
		panelAdd.add(btnAddSP);
		
		JButton btnRefresh = new JButton("Làm Mới");
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRefresh.setHorizontalAlignment(SwingConstants.LEADING);
		btnRefresh.setBackground(new Color(92,206,38));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRefresh.setBounds(255, 4, 80, 21);
		panelAdd.add(btnRefresh);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(-12, 307, 80, 21);
		panelPayment.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(362, 307, 431, 248);
		panelPayment.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbllSearchKH = new JLabel("Tìm Khách Hàng");
		lbllSearchKH.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbllSearchKH.setBounds(0, 0, 125, 27);
		panel_1.add(lbllSearchKH);
		
		JLabel lblmaKH = new JLabel("Mã Khách Hàng");
		lblmaKH.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblmaKH.setBounds(0, 29, 125, 27);
		panel_1.add(lblmaKH);
		
		textField_5 = new JTextField();
		textField_5.setBounds(0, 58, 141, 27);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng");
		lblTnKhchHng.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTnKhchHng.setBounds(260, 29, 125, 27);
		panel_1.add(lblTnKhchHng);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(260, 58, 161, 27);
		panel_1.add(textField_6);
		
		JLabel lblSi = new JLabel("Số Điện Thoại");
		lblSi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSi.setBounds(0, 87, 125, 27);
		panel_1.add(lblSi);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(0, 115, 141, 27);
		panel_1.add(textField_7);
		
		JLabel lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblaCh.setBounds(260, 87, 125, 27);
		panel_1.add(lblaCh);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(260, 115, 161, 27);
		panel_1.add(textField_8);
		
		JLabel lblLoiKhchHng = new JLabel("Loại Khách Hàng:");
		lblLoiKhchHng.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLoiKhchHng.setBounds(0, 152, 125, 27);
		panel_1.add(lblLoiKhchHng);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(125, 152, 39, 18);
		panel_1.add(textField_9);
		
		JLabel lblNewLabel_3 = new JLabel("Tổng Tiền:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(0, 176, 93, 18);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tiền Khách Đưa");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(0, 201, 112, 13);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Tiền Trả");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(286, 201, 73, 13);
		panel_1.add(lblNewLabel_4_1);
		
		JButton btnNewButton = new JButton("Hủy Bỏ");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(79, 215, 85, 30);
		panel_1.add(btnNewButton);
		
		JButton btnThanhTon = new JButton("Thanh Toán");
		btnThanhTon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThanhTon.setBackground(Color.GREEN);
		btnThanhTon.setBounds(210, 215, 112, 30);
		panel_1.add(btnThanhTon);
		

	}
}
