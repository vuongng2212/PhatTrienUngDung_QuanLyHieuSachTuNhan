package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Country;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JComponent;

public class frmNV extends JFrame {

	List<Country>listCountries = new ArrayList<Country>();
	private JPanel contentPane;
	private Image img_logo = new ImageIcon(frmNV.class.getResource("/image/bookStore.png")).getImage().getScaledInstance(300, 300,Image.SCALE_SMOOTH );
	private Image img_system = new ImageIcon(frmNV.class.getResource("/image/system_icon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_product = new ImageIcon(frmNV.class.getResource("/image/product_icon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_payment = new ImageIcon(frmNV.class.getResource("/image/payment_icon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_thongKe = new ImageIcon(frmNV.class.getResource("/image/thongKe_icon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_customer = new ImageIcon(frmNV.class.getResource("/image/customer_icon.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_user = new ImageIcon(frmNV.class.getResource("/image/user.png")).getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH );
	private Image img_logout = new ImageIcon(frmNV.class.getResource("/image/logout.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_title = new ImageIcon(frmNV.class.getResource("/image/title.jpg")).getImage().getScaledInstance(1550, 1500,Image.SCALE_SMOOTH );
	
	private final JLabel lblNewLabel = new JLabel("");
	private panelSystem system;
	private panelProduct product;
	private PanelBill bill;
	private PanelCustomer customer;
	private PanelThongKe thongke;
	private JLabel lbllImage;
	private JPanel panel_image_title;
	private JComboBox comboCountries;
	private JLabel lbllDateShow;
	private JLabel lbllDate;
	private final LoginForm frmLogin = new LoginForm();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNV frame = new frmNV();
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
	public frmNV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1936, 1056);
//		setSize(1936,1056);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		system = new panelSystem();
		system.setVisible(false);
		product = new panelProduct();
		product.setVisible(false);
		bill = new PanelBill();
		bill.setVisible(false);
		customer = new PanelCustomer();
		customer.setVisible(false);
		thongke = new PanelThongKe();
		thongke.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(217,217,217));
		panel.setBounds(0, 0, 272, 1017);
		
		contentPane.add(panel);
		panel.setLayout(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 272, 212);
		lblNewLabel.setIcon(new ImageIcon(img_logo));
		panel.add(lblNewLabel);
		
		JPanel panelHeThong = new JPanel();
		panelHeThong.addMouseListener(new PanelButtonMouseAdapter(panelHeThong,system));
		panelHeThong.setBounds(0, 212, 272, 78);
		panelHeThong.setBackground(new Color(217,217,217));
		panel.add(panelHeThong);
		panelHeThong.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(0, 0, 108, 68);
		lblNewLabel_1.setIcon(new ImageIcon(img_system));
		panelHeThong.add(lblNewLabel_1);
		
		JLabel lbllHeThong = new JLabel("Hệ Thống");
		lbllHeThong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbllHeThong.setBounds(118, 0, 154, 68);
		panelHeThong.add(lbllHeThong);
		
		JPanel PanelSanPham = new JPanel();
		PanelSanPham.addMouseListener(new PanelButtonMouseAdapter(PanelSanPham,product));
		PanelSanPham.setBounds(0, 290, 272, 67);
		
		PanelSanPham.setBackground(new Color(217,217,217));
		
		panel.add(PanelSanPham);
		PanelSanPham.setLayout(null);
		
		JLabel lbllSanPham = new JLabel("");
		lbllSanPham.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllSanPham.setBounds(10, 0, 97, 63);
		lbllSanPham.setIcon(new ImageIcon(img_product));
		PanelSanPham.add(lbllSanPham);
		
		JLabel lbllProduct = new JLabel("Sản Phẩm");
		lbllProduct.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbllProduct.setBounds(116, 0, 156, 63);
		PanelSanPham.add(lbllProduct);
		
		JPanel panelHD = new JPanel();
		panelHD.addMouseListener(new PanelButtonMouseAdapter(panelHD,bill));
		panelHD.setBounds(0, 504, 385, 98);
		panel.add(panelHD);
		
		panelHD.setBackground(new Color(217,217,217));
		
		panelHD.setLayout(null);
		
		JLabel lbllHoaDon = new JLabel("");
		lbllHoaDon.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllHoaDon.setBounds(10, 0, 94, 98);
		lbllHoaDon.setIcon(new ImageIcon(img_payment));
		panelHD.add(lbllHoaDon);
		
		JLabel lbllHD = new JLabel("Hóa Đơn");
		lbllHD.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbllHD.setBounds(114, 0, 159, 98);
		panelHD.add(lbllHD);
		
		JPanel panelKH = new JPanel();
		panelKH.addMouseListener(new PanelButtonMouseAdapter(panelKH,customer));
		panelKH.setBounds(0, 602, 385, 98);

		panelKH.setBackground(new Color(217,217,217));
		panel.add(panelKH);
		
		
		panelKH.setLayout(null);
		
		JLabel lbllKH = new JLabel("Khách Hàng");
		lbllKH.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbllKH.setBounds(114, 0, 159, 98);
		panelKH.add(lbllKH);
		
		JLabel lbllKhachHang = new JLabel("");
		lbllKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllKhachHang.setBounds(10, 0, 94, 98);
		lbllKhachHang.setIcon(new ImageIcon(img_customer));
		panelKH.add(lbllKhachHang);
		
		JPanel panelThongKe = new JPanel();
		panelThongKe.addMouseListener(new PanelButtonMouseAdapter(panelThongKe,thongke));
		panelThongKe.setBounds(0, 700, 385, 98);
		panel.add(panelThongKe);
		
		panelThongKe.setBackground(new Color(217,217,217));
		
		panelThongKe.setLayout(null);
		
		JLabel lbllThongKe = new JLabel("Thống Kê");
		lbllThongKe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbllThongKe.setBounds(115, 0, 155, 98);
		panelThongKe.add(lbllThongKe);
		
		JLabel lbllTK = new JLabel("");
		lbllTK.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTK.setBounds(10, 0, 80, 98);
		lbllTK.setIcon(new ImageIcon(img_thongKe));
		panelThongKe.add(lbllTK);
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setBounds(0, 809, 385, 219);
		panel.add(panel_1);
		
		panel_1.setBackground(new Color(217,217,217));
		
		panel_1.setLayout(null);
		
		JLabel icon_user = new JLabel("");
		icon_user.setHorizontalAlignment(SwingConstants.CENTER);
		icon_user.setBounds(10, 138, 61, 59);
		icon_user.setIcon(new ImageIcon(img_user));
		panel_1.add(icon_user);
		
		JLabel lblNewLabel_3 = new JLabel("User:  Văn A");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(81, 138, 195, 59);
		panel_1.add(lblNewLabel_3);
		
		
		JLabel icon_logout = new JLabel("");
		icon_logout.setHorizontalAlignment(SwingConstants.CENTER);
		icon_logout.setBounds(316, 141, 51, 49);
		icon_logout.setIcon(new ImageIcon(img_logout));
		panel_1.add(icon_logout);
		icon_logout.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int option  = JOptionPane.showConfirmDialog(null, "Xác nhận Đăng Xuất?","Xác Nhận",JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					frmLogin.setVisible(true);
					frmNV.this.dispose();

				}
			}
		});
		
		JLabel lbllNgonNgu = new JLabel("Ngôn Ngữ");
		lbllNgonNgu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllNgonNgu.setBounds(10, 11, 92, 34);
		panel_1.add(lbllNgonNgu);
		
		comboCountries = new JComboBox();
		FillCountries();
		comboCountries.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int index = comboCountries.getSelectedIndex();
				String []country = listCountries.get(index).getId().split("-");
				Locale locale = new Locale(country[0], country[1]);
				
				ResourceBundle rd = ResourceBundle.getBundle("resources.content",locale);
				
				
				
				
				//Change Date
				DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,locale);
				lbllDateShow.setText(df.format(new Date()));

				
				//Change Text for Lbll
				lbllHeThong.setText(rd.getString("heThong"));
				lbllHeThong.setFont(listCountries.get(index).getFont());
				lbllProduct.setText(rd.getString("sanPham"));
				lbllProduct.setFont(listCountries.get(index).getFont());
				lbllHD.setText(rd.getString("hoaDon"));
				lbllHD.setFont(listCountries.get(index).getFont());
				lbllKH.setText(rd.getString("khachHang"));
				lbllKH.setFont(listCountries.get(index).getFont());
				lbllThongKe.setText(rd.getString("thongKe"));
				lbllThongKe.setFont(listCountries.get(index).getFont());
				lbllDate.setText(rd.getString("lich"));
				lbllDate.setFont(listCountries.get(index).getFont());
				//Change Text Frm Show
				//thêm các thay đổi vào bên trong 
				system.lbllSystem.setText(rd.getString("heThong"));
				system.lbllSystem.setFont(listCountries.get(index).getFont());
				
				//Change text for frm Bill
				bill.lblNewLabel.setText(rd.getString("banhang")); //Ban Hang
				bill.lblNewLabel.setFont(listCountries.get(index).getFont());
				bill.lblNewLabel_1.setText(rd.getString("nhaphang")); //Nhap hang
				bill.lblNewLabel_1.setFont(listCountries.get(index).getFont());
				
				//Change text for Bill.panelBanHang
				bill.banHang.lblTcGi.setText(rd.getString("tacGia"));
				bill.banHang.lblNhXutBn.setText(rd.getString("NXB"));
				bill.banHang.lbllSoLuong.setText(rd.getString("soluong"));
				bill.banHang.lblTimKH.setText(rd.getString("timKH"));
				bill.banHang.lbllKH.setText(rd.getString("maKH"));
				bill.banHang.lblTnKhchHng.setText(rd.getString("tenKH"));
				bill.banHang.lblSi.setText(rd.getString("SDT"));
				bill.banHang.lblaCh.setText(rd.getString("diaChi"));
				bill.banHang.lbllLoai.setText(rd.getString("loaiKH"));
				bill.banHang.lbllTongTien.setText(rd.getString("tongTien"));
				bill.banHang.lbllTienNhan.setText(rd.getString("tienNhan"));
				bill.banHang.lblTienTra.setText(rd.getString("tienTra"));
				bill.banHang.btnHuy.setText(rd.getString("huyBo"));
				bill.banHang.btnThanhToan.setText(rd.getString("thanhToan"));
				bill.banHang.btnInHD.setText(rd.getString("inHD"));
				bill.banHang.lbllTitle.setText(rd.getString("banhang"));
				bill.banHang.lbllProduct.setText(rd.getString("timsach"));
				bill.banHang.lbllMaSach.setText(rd.getString("maSach"));
				bill.banHang.lbllTenSach.setText(rd.getString("tenSach"));
				bill.banHang.lblDanhMc.setText(rd.getString("danhMuc"));
				
				
				bill.banHang.btnNewButton.setText(rd.getString("them"));
				bill.banHang.btnLmMi.setText(rd.getString("lammoi"));
//				
				
				
				
				
				
			
				
				
				//Change currency
				NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
				//
			}
		});
		comboCountries.setBounds(125, 11, 174, 34);
		panel_1.add(comboCountries);
		
		lbllDate = new JLabel("Lịch");
		lbllDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllDate.setBounds(10, 102, 92, 34);
		panel_1.add(lbllDate);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE,dd/MM/yyyy",new Locale("vi"));
		String currentDate = dateFormat.format(new Date());
		
		lbllDateShow = new JLabel();
		lbllDateShow.setText(currentDate);
		lbllDateShow.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbllDateShow.setBounds(125, 100, 215, 38);
		panel_1.add(lbllDateShow);
		
		JPanel panelFrm = new JPanel();
		panelFrm.setBounds(386, 0, 1534, 1017);
		contentPane.add(panelFrm);
	
		
		panelFrm.setLayout(null);
		lbllImage = new JLabel(new ImageIcon(img_title));
		lbllImage.setHorizontalAlignment(SwingConstants.CENTER);
		lbllImage.setHorizontalAlignment(JLabel.CENTER);
		lbllImage.setVerticalAlignment(JLabel.CENTER);
		lbllImage.setBounds(0, 0, 1534, 1017);
		
		
		panel_image_title = new JPanel();
		panel_image_title.setBounds(0, 0, 1534, 1006);
		panel_image_title.add(lbllImage);
		panelFrm.add(panel_image_title);
		
		panel_image_title.setLayout(null);
		
		
		panelFrm.add(system);
		panelFrm.add(product);
		panelFrm.add(bill);
		panelFrm.add(customer);
		panelFrm.add(thongke);
		
//		menuClicked(system);
//		
		
	}
	
	public void menuClicked(JPanel panel) {
		panel_image_title.setVisible(false);
		system.setVisible(false);
		product.setVisible(false);
		bill.setVisible(false);
		customer.setVisible(false);
		thongke.setVisible(false);
		
		panel.setVisible(true);
		
	}
	private void FillCountries() {
		listCountries.add(new Country("vi-VN", "VietNam", new Font("Tahoma", Font.BOLD, 20)));
		listCountries.add(new Country("en-US","English",new Font("Tahoma", Font.BOLD, 20)));
		listCountries.add(new Country("ja-JP","Japan",new Font("MS Gothic", Font.PLAIN, 20)));
		for (Country country : listCountries) {
			comboCountries.addItem(country.getName());
		}
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		JPanel jpanelShow;
		public PanelButtonMouseAdapter(JPanel panel,JPanel panelShow) {
			
			this.panel = panel;
			this.jpanelShow = panelShow;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			
			menuClicked(jpanelShow);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			
			panel.setBackground(new Color(112,128,144));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			
			panel.setBackground(new Color(217,217,217));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			
			panel.setBackground(new Color(60,179,113));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		
			panel.setBackground(new Color(112,128,144));
		}
	}
}
