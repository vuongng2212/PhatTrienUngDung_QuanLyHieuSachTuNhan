package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.DAO_NhanVien;
import entity.NhanVien;
import entity.userInfo;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

public class PanelProfit extends JPanel {
	public JTextField txtMaNV;
	public JTextField txtTenNV;
	public JTextField txtNgaySinh;
	public JTextField txtGioiTinh;
	public JTextField txtDienThoai;
	public JTextField txtDiaChi;
	public JTextField txtEmail;
	public JTextField txtChucVu;
	public JoptionChangePwd changePwd;
	private DAO_NhanVien nv;
	public DialogChangeSDT changeSDT;
	public DialogChangeEmail changeEmail;
	private JLabel lbllMaNV;
	private JLabel lbllTenNV;
	private JPanel panel_1;
	private JLabel lbllGioiTinh;
	private JLabel lbllSoDienThoai;
	private JLabel lbllDiaChi;
	private JLabel lbllEmail;
	private JLabel lbllChucVu;
	private JButton btnDoiSDT;
	private JButton btnDoiMatKhau;
	private JButton btnEmail;
	private JButton btnHoanTac;
	private JLabel lbllNgaySinh;
	/**
	 * Create the panel.
	 */
	public PanelProfit() {
		setBounds(0,0,1534,1017);
		setLayout(null);
		changeSDT = new DialogChangeSDT();
		changeEmail = new DialogChangeEmail();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(0, 0, 1534, 91);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông Tin Nhân Viên");
		lblNewLabel.setBackground(new Color(173, 255, 47));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setBounds(0, 0, 1534, 91);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 165, 0));
		panel_1.setBounds(0, 91, 1534, 926);
		add(panel_1);
		panel_1.setLayout(null);
		
		lbllMaNV = new JLabel("Mã Nhân Viên");
		lbllMaNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllMaNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllMaNV.setBounds(83, 32, 136, 36);
		panel_1.add(lbllMaNV);
		
		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtMaNV.setBounds(234, 32, 215, 39);
		panel_1.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		lbllTenNV = new JLabel("Tên Nhân Viên");
		lbllTenNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTenNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTenNV.setBounds(552, 32, 136, 36);
		panel_1.add(lbllTenNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(710, 32, 215, 39);
		panel_1.add(txtTenNV);
		
		lbllNgaySinh = new JLabel("Ngày Sinh");
		lbllNgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllNgaySinh.setBounds(1109, 32, 111, 36);
		panel_1.add(lbllNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(1255, 32, 215, 39);
		panel_1.add(txtNgaySinh);
		
		lbllGioiTinh = new JLabel("Giới Tính");
		lbllGioiTinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllGioiTinh.setBounds(83, 108, 136, 36);
		panel_1.add(lbllGioiTinh);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setHorizontalAlignment(SwingConstants.CENTER);
		txtGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(234, 108, 215, 39);
		panel_1.add(txtGioiTinh);
		
		lbllSoDienThoai = new JLabel("Số Điện Thoại");
		lbllSoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllSoDienThoai.setBounds(552, 108, 136, 36);
		panel_1.add(lbllSoDienThoai);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setEditable(false);
		txtDienThoai.setHorizontalAlignment(SwingConstants.CENTER);
		txtDienThoai.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDienThoai.setColumns(10);
		txtDienThoai.setBounds(710, 108, 215, 39);
		panel_1.add(txtDienThoai);
		
		lbllDiaChi = new JLabel("Địa Chỉ");
		lbllDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllDiaChi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllDiaChi.setBounds(1109, 108, 111, 36);
		panel_1.add(lbllDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiaChi.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(1255, 108, 215, 39);
		panel_1.add(txtDiaChi);
		
		lbllEmail = new JLabel("Email");
		lbllEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllEmail.setBounds(270, 205, 136, 36);
		panel_1.add(lbllEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEmail.setColumns(10);
		txtEmail.setBounds(421, 205, 215, 39);
		panel_1.add(txtEmail);
		
		lbllChucVu = new JLabel("Chức Vụ");
		lbllChucVu.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllChucVu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllChucVu.setBounds(721, 205, 136, 36);
		panel_1.add(lbllChucVu);
		
		txtChucVu = new JTextField();
		txtChucVu.setHorizontalAlignment(SwingConstants.CENTER);
		txtChucVu.setEditable(false);
		txtChucVu.setText("Nhân Viên");
		txtChucVu.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(877, 205, 215, 39);
		panel_1.add(txtChucVu);
		
		btnDoiSDT = new JButton("Thay Đổi SDT");
		btnDoiSDT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeSDT();
			}
		});
		btnDoiSDT.setBackground(new Color(255, 0, 255));
		btnDoiSDT.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDoiSDT.setBounds(180, 336, 171, 59);
		panel_1.add(btnDoiSDT);
		
		btnDoiMatKhau = new JButton("Thay Đổi Mật Khẩu");
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePwd = new JoptionChangePwd();
				changePwd.setModal(true);
				changePwd.setVisible(true);
				
			}
		});
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDoiMatKhau.setBackground(Color.MAGENTA);
		btnDoiMatKhau.setBounds(552, 336, 177, 59);
		panel_1.add(btnDoiMatKhau);
		
		btnEmail = new JButton("Thay Đổi Email");
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeEmail();
			}
		});
		btnEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEmail.setBackground(Color.MAGENTA);
		btnEmail.setBounds(905, 336, 171, 59);
		panel_1.add(btnEmail);
		
		btnHoanTac = new JButton("Hoàn Tác");
		btnHoanTac.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHoanTac.setBackground(Color.MAGENTA);
		btnHoanTac.setBounds(1220, 336, 171, 59);
		panel_1.add(btnHoanTac);
//		refresh();
	}
	public void refresh() {
		nv = new DAO_NhanVien();
//		NhanVien nhanvien = nv.getNV(userInfo.maNV);
		NhanVien nhanvien = nv.getNVTheoMa(userInfo.maNV);
			SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
		
		  txtMaNV.setText(nhanvien.getMaNV());
		  txtTenNV.setText(nhanvien.getTenNV());
		  txtNgaySinh.setText(date.format(nhanvien.getDoB()));
		  int gt = nhanvien.getGioiTinh();
		  if(gt == 1) {
			  txtGioiTinh.setText("Nam");
		  }else {
			  txtGioiTinh.setText("Nữ");
		  }
		  txtDienThoai.setText(nhanvien.getSDT());
		  txtDiaChi.setText(nhanvien.getDiaChi());
		  txtEmail.setText(nhanvien.getEmail());
		  txtChucVu.setText(nhanvien.getChucVu());
		  userInfo.sdt = nhanvien.getSDT();
		  userInfo.maNV = nhanvien.getMaNV();
	}
	public void changeSDT() {
		changeSDT.profit = this;
		changeSDT.refresh();
		changeSDT.setModal(true);
		changeSDT.setVisible(true);
	}
	public void changeEmail() {
		changeEmail.profit = this;
		changeEmail.refresh();
		changeEmail.setModal(true);
		changeEmail.setVisible(true);
	}
	public void refreshLocale(String cs1,String cs2) {
		Locale locale = new Locale(cs1, cs2);
		ResourceBundle rd = ResourceBundle.getBundle("resources.content",locale);
		lbllMaNV.setText(rd.getString("maNV"));
		lbllTenNV.setText(rd.getString("tenNV"));
		lbllNgaySinh.setText(rd.getString("ngaySinh"));
		lbllGioiTinh.setText(rd.getString("gioiTinh"));
		lbllSoDienThoai.setText(rd.getString("soDienThoai"));
		lbllDiaChi.setText(rd.getString("diaChi"));
		lbllChucVu.setText(rd.getString("chucVu"));
		btnDoiSDT.setText(rd.getString("thayDoiSDT"));
		btnDoiMatKhau.setText(rd.getString("doiMatKhau"));
		btnEmail.setText(rd.getString("doiEmail"));
		btnHoanTac.setText(rd.getString("hoanTac"));
		
	}
}
