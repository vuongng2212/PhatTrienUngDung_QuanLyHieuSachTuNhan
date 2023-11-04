package ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.DAO_KhachHang;
import entity.KhachHang;
import entity.SanPham;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelCRUDKHang extends JPanel {
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtPhone;
	private JTextField txtDiaChi;
	private JTextField txtLoaiKH;
	private Image img_title = new ImageIcon(frmNV.class.getResource("/image/pluss.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private Image img_find = new ImageIcon(frmNV.class.getResource("/image/search.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private Image img_reload = new ImageIcon(frmNV.class.getResource("/image/reload.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private Image img_remove= new ImageIcon(frmNV.class.getResource("/image/rm.png")).getImage().getScaledInstance(28, 28,Image.SCALE_SMOOTH );
	private Image img_back = new ImageIcon(frmNV.class.getResource("/image/backing.png")).getImage().getScaledInstance(28, 28,Image.SCALE_SMOOTH );

	private PanelCustomer panelCustomer;
	private JTable table;
	private DefaultTableModel model;
 	private Object[] row;
 	
 	//
 	private DAO_KhachHang daoKh;
 	private KhachHang kh;
	//
 	
 	public PanelCRUDKHang(PanelCustomer panelCustomer) {
		this.panelCustomer = panelCustomer;
		panelCustomer.setVisible(false);
		this.init();
	}
	

	public PanelCRUDKHang() {
//		this.setVisible(false);
		setBounds(0,0,1534,1017);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 1534, 100);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông Tin Khách Hàng");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(144, 0, 1235, 100);
		panel.add(lblNewLabel);
		
		JButton btnTroVe = new JButton("Trở Về");
		btnTroVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				panelCustomer.setVisible(true);
			}
		});
		btnTroVe.setForeground(new Color(0, 255, 0));
		btnTroVe.setBackground(null);
		btnTroVe.setOpaque(false);
		btnTroVe.setBorderPainted(false);
		btnTroVe.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTroVe.setIcon(new ImageIcon(img_back));
		btnTroVe.setBounds(10, 21, 124, 55);
		panel.add(btnTroVe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 165, 0));
		panel_1.setBounds(0, 111, 1534, 173);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbllMaKH = new JLabel("Mã Khách Hàng");
		lbllMaKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllMaKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllMaKH.setBounds(66, 23, 128, 30);
		panel_1.add(lbllMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(204, 23, 195, 30);
		panel_1.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng");
		lblTnKhchHng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTnKhchHng.setBounds(66, 78, 136, 30);
		panel_1.add(lblTnKhchHng);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(204, 78, 195, 30);
		panel_1.add(txtTenKH);
		
		JLabel lbllSDT = new JLabel("Số Điện Thoại");
		lbllSDT.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllSDT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllSDT.setBounds(448, 78, 128, 30);
		panel_1.add(lbllSDT);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(586, 78, 186, 30);
		panel_1.add(txtPhone);
		
		JLabel lbllDiaChi = new JLabel("Địa Chỉ");
		lbllDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllDiaChi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllDiaChi.setBounds(796, 78, 118, 30);
		panel_1.add(lbllDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(924, 80, 205, 30);
		panel_1.add(txtDiaChi);
		
		JLabel lbllLoaiKH = new JLabel("Loại Khách Hàng");
		lbllLoaiKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllLoaiKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllLoaiKH.setBounds(1167, 78, 136, 30);
		panel_1.add(lbllLoaiKH);
		
		txtLoaiKH = new JTextField();
		txtLoaiKH.setColumns(10);
		txtLoaiKH.setBounds(1319, 80, 205, 30);
		panel_1.add(txtLoaiKH);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(txtMaKH.getText().equals("") || txtTenKH.getText().equals("") || txtDiaChi.getText().equals("") || txtPhone.getText().equals("") || txtLoaiKH.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng điền tất cả thông tin");
				DAO_KhachHang.testing();
			}else {
				System.out.println("Bat dau");
				daoKh = new DAO_KhachHang();
				row[0] = txtMaKH.getText();
				row[1] = txtTenKH.getText();
				row[2] = txtPhone.getText();
				row[3] = txtDiaChi.getText();
				row[4] = txtLoaiKH.getText();
				model.addRow(row);
				DAO_KhachHang.testing();
				txtMaKH.setText("");
				txtTenKH.setText("");
				txtPhone.setText("");
				txtDiaChi.setText("");
				txtLoaiKH.setText("");
				JOptionPane.showMessageDialog(null, "Thêm Thành Công");
			}
				
			}
		});
		btnAdd.setBackground(new Color(255, 192, 203));
		btnAdd.setIcon(new ImageIcon(img_title));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnAdd.setForeground(new Color(0, 255, 0));
		btnAdd.setBounds(442, 132, 111, 30);
		panel_1.add(btnAdd);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					model.setValueAt(txtMaKH.getText(), i, 0);
					model.setValueAt(txtTenKH.getText(), i, 1);
					model.setValueAt(txtPhone.getText(), i, 2);
					model.setValueAt(txtDiaChi.getText(), i, 3);
					model.setValueAt(txtLoaiKH.getText(), i, 4);
					JOptionPane.showMessageDialog(null, "Đã Sửa Thành Công");
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng cần sửa");
				}
				
			}
		});
		btnSua.setForeground(new Color(0, 255, 255));
		btnSua.setIcon(new ImageIcon(img_reload));
		btnSua.setBackground(new Color(255, 192, 203));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnSua.setBounds(730, 132, 104, 30);
		panel_1.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				
				if(i>=0) {
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Xóa Thành Công");
				
					}else {
						JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Hàng Cần Xóa");
					}
				}
		});
		btnXoa.setForeground(new Color(255, 0, 0));
		btnXoa.setBackground(new Color(250, 235, 215));
		btnXoa.setIcon(new ImageIcon(img_remove));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnXoa.setBounds(989, 132, 104, 30);
		panel_1.add(btnXoa);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 285, 1534, 732);
		add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1514, 612);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				txtMaKH.setText(model.getValueAt(i, 0).toString());
				txtTenKH.setText(model.getValueAt(i, 1).toString());
				txtPhone.setText(model.getValueAt(i, 2).toString());
				txtDiaChi.setText(model.getValueAt(i, 3).toString());
				txtLoaiKH.setText(model.getValueAt(i, 4).toString());
				
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"Mã Khách Hàng","Tên Khách Hàng","Số Điện Thoại","Địa Chỉ","Loại Khách Hàng"};
		row = new Object[5];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
			

		setBounds(0,0,1534,1017);
		setLayout(null);

	}
	public void init() {
		setBounds(0,0,1534,1017);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 1534, 100);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông Tin Khách Hàng");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(144, 0, 1235, 100);
		panel.add(lblNewLabel);
		
		JButton btnTroVe = new JButton("Trở Về");
		btnTroVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				panelCustomer.setVisible(true);
			}
		});
		btnTroVe.setForeground(new Color(0, 255, 0));
		btnTroVe.setBackground(null);
		btnTroVe.setOpaque(false);
		btnTroVe.setBorderPainted(false);
		btnTroVe.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTroVe.setIcon(new ImageIcon(img_back));
		btnTroVe.setBounds(10, 21, 124, 55);
		panel.add(btnTroVe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 165, 0));
		panel_1.setBounds(0, 111, 1534, 173);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbllMaKH = new JLabel("Mã Khách Hàng");
		lbllMaKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllMaKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllMaKH.setBounds(66, 23, 128, 30);
		panel_1.add(lbllMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(204, 23, 195, 30);
		panel_1.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng");
		lblTnKhchHng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTnKhchHng.setBounds(66, 78, 136, 30);
		panel_1.add(lblTnKhchHng);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(204, 78, 195, 30);
		panel_1.add(txtTenKH);
		
		JLabel lbllSDT = new JLabel("Số Điện Thoại");
		lbllSDT.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllSDT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllSDT.setBounds(448, 78, 128, 30);
		panel_1.add(lbllSDT);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(586, 78, 186, 30);
		panel_1.add(txtPhone);
		
		JLabel lbllDiaChi = new JLabel("Địa Chỉ");
		lbllDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllDiaChi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllDiaChi.setBounds(796, 78, 118, 30);
		panel_1.add(lbllDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(924, 80, 205, 30);
		panel_1.add(txtDiaChi);
		
		JLabel lbllLoaiKH = new JLabel("Loại Khách Hàng");
		lbllLoaiKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllLoaiKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllLoaiKH.setBounds(1167, 78, 136, 30);
		panel_1.add(lbllLoaiKH);
		
		txtLoaiKH = new JTextField();
		txtLoaiKH.setColumns(10);
		txtLoaiKH.setBounds(1319, 80, 205, 30);
		panel_1.add(txtLoaiKH);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(txtMaKH.getText().equals("") || txtTenKH.getText().equals("") || txtDiaChi.getText().equals("") || txtPhone.getText().equals("") || txtLoaiKH.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng điền tất cả thông tin");
			}else {
				row[0] = txtMaKH.getText();
				row[1] = txtTenKH.getText();
				row[2] = txtPhone.getText();
				row[3] = txtDiaChi.getText();
				row[4] = txtLoaiKH.getText();
				model.addRow(row);
				
				txtMaKH.setText("");
				txtTenKH.setText("");
				txtPhone.setText("");
				txtDiaChi.setText("");
				txtLoaiKH.setText("");
				JOptionPane.showMessageDialog(null, "Thêm Thành Công");
			}
				
			}
		});
		btnAdd.setBackground(new Color(255, 192, 203));
		btnAdd.setIcon(new ImageIcon(img_title));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnAdd.setForeground(new Color(0, 255, 0));
		btnAdd.setBounds(442, 132, 111, 30);
		panel_1.add(btnAdd);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					model.setValueAt(txtMaKH.getText(), i, 0);
					model.setValueAt(txtTenKH.getText(), i, 1);
					model.setValueAt(txtPhone.getText(), i, 2);
					model.setValueAt(txtDiaChi.getText(), i, 3);
					model.setValueAt(txtLoaiKH.getText(), i, 4);
					JOptionPane.showMessageDialog(null, "Đã Sửa Thành Công");
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng cần sửa");
				}
				
			}
		});
		btnSua.setForeground(new Color(0, 255, 255));
		btnSua.setIcon(new ImageIcon(img_reload));
		btnSua.setBackground(new Color(255, 192, 203));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnSua.setBounds(730, 132, 104, 30);
		panel_1.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				
				if(i>=0) {
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Xóa Thành Công");
				
					}else {
						JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Hàng Cần Xóa");
					}
				}
		});
		btnXoa.setForeground(new Color(255, 0, 0));
		btnXoa.setBackground(new Color(250, 235, 215));
		btnXoa.setIcon(new ImageIcon(img_remove));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnXoa.setBounds(989, 132, 104, 30);
		panel_1.add(btnXoa);
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(img_find));
		btnSearch.setOpaque(false);
		btnSearch.setBackground(null);
		btnSearch.setBorderPainted(false);
		btnSearch.setBounds(400, 23, 42, 30);
		panel_1.add(btnSearch);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 285, 1534, 732);
		add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1514, 612);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				txtMaKH.setText(model.getValueAt(i, 0).toString());
				txtTenKH.setText(model.getValueAt(i, 1).toString());
				txtPhone.setText(model.getValueAt(i, 2).toString());
				txtDiaChi.setText(model.getValueAt(i, 3).toString());
				txtLoaiKH.setText(model.getValueAt(i, 4).toString());
				
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"Mã Khách Hàng","Tên Khách Hàng","Số Điện Thoại","Địa Chỉ","Loại Khách Hàng"};
		row = new Object[5];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
			

		setBounds(0,0,1534,1017);
		setLayout(null);


	}
}
