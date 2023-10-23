package ui;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelProduct extends JPanel {
	private JTextField txtMaSach;
	private JTextField txtTenSach;
	private JTextField txtTheLoai;
	private JTextField txtTacGia;
	private JTextField txtNXB;
	private JTextField textField;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
	private JTextField txtTinhTrang;
	private Image img_add = new ImageIcon(frmNV.class.getResource("/image/added.png")).getImage().getScaledInstance(40, 40,Image.SCALE_SMOOTH );
	private Image img_remove = new ImageIcon(frmNV.class.getResource("/image/rm.png")).getImage().getScaledInstance(20, 20,Image.SCALE_SMOOTH );
	private Image img_update = new ImageIcon(frmNV.class.getResource("/image/reload.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private Image img_search = new ImageIcon(frmNV.class.getResource("/image/search.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	public PanelSearchProduct panelSearchProduct;
	private JPanel panelTable;
	

	/**
	 * Create the panel.
	 */
	public panelProduct() {
		setBounds(0,0,1534,1017);
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(244, 164, 96));
		panelTitle.setBounds(0, 0, 1534, 101);
		add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lbllTitle = new JLabel("Thông Tin Sách");
		lbllTitle.setForeground(new Color(127, 255, 0));
		lbllTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lbllTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbllTitle.setBounds(0, 0, 1534, 101);
		panelTitle.add(lbllTitle);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(new Color(250, 235, 215));
		panelSearch.setBounds(0, 143, 1534, 200);
		add(panelSearch);
		panelSearch.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm Sách");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 82, 31);
		panelSearch.add(lblNewLabel);
		
		JLabel lbllMaSach = new JLabel("Mã Sách");
		lbllMaSach.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllMaSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllMaSach.setBounds(0, 53, 82, 31);
		panelSearch.add(lbllMaSach);
		
		txtMaSach = new JTextField();
		txtMaSach.setBounds(92, 57, 153, 27);
		panelSearch.add(txtMaSach);
		txtMaSach.setColumns(10);
		
		JLabel lbllTenSach = new JLabel("Tên Sách");
		lbllTenSach.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTenSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTenSach.setBounds(277, 53, 82, 31);
		panelSearch.add(lbllTenSach);
		
		txtTenSach = new JTextField();
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(369, 57, 170, 27);
		panelSearch.add(txtTenSach);
		
		JLabel lbllDanhMuc = new JLabel("Danh Mục");
		lbllDanhMuc.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllDanhMuc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllDanhMuc.setBounds(578, 53, 82, 31);
		panelSearch.add(lbllDanhMuc);
		
		txtTheLoai = new JTextField();
		txtTheLoai.setColumns(10);
		txtTheLoai.setBounds(670, 57, 170, 27);
		panelSearch.add(txtTheLoai);
		
		JLabel lbllTacGia = new JLabel("Tác Giả");
		lbllTacGia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTacGia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTacGia.setBounds(0, 104, 82, 31);
		panelSearch.add(lbllTacGia);
		
		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(92, 108, 153, 27);
		panelSearch.add(txtTacGia);
		
		JLabel lbllNXB = new JLabel("NXB");
		lbllNXB.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllNXB.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllNXB.setBounds(277, 104, 82, 31);
		panelSearch.add(lbllNXB);
		
		txtNXB = new JTextField();
		txtNXB.setColumns(10);
		txtNXB.setBounds(369, 108, 170, 27);
		panelSearch.add(txtNXB);
		
		JLabel lbllNamXB = new JLabel("Năm XB");
		lbllNamXB.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllNamXB.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllNamXB.setBounds(578, 104, 82, 31);
		panelSearch.add(lbllNamXB);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(670, 108, 170, 27);
		panelSearch.add(textField);
		
		JLabel lbllSoLuong = new JLabel("Số Lượng");
		lbllSoLuong.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllSoLuong.setBounds(890, 53, 82, 31);
		panelSearch.add(lbllSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(994, 57, 170, 27);
		panelSearch.add(txtSoLuong);
		
		JLabel lbllDonGia = new JLabel("Đơn Giá");
		lbllDonGia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllDonGia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllDonGia.setBounds(890, 104, 82, 31);
		panelSearch.add(lbllDonGia);
		
		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(994, 108, 170, 27);
		panelSearch.add(txtDonGia);
		
		JLabel lbllTinhTrang = new JLabel("Tình Trạng");
		lbllTinhTrang.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTinhTrang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTinhTrang.setBounds(1230, 53, 82, 31);
		panelSearch.add(lbllTinhTrang);
		
		txtTinhTrang = new JTextField();
		txtTinhTrang.setColumns(10);
		txtTinhTrang.setBounds(1343, 57, 95, 27);
		panelSearch.add(txtTinhTrang);
		
		JButton btnTacGia = new JButton("");
		btnTacGia.setIcon(new ImageIcon(img_add));
		btnTacGia.setOpaque(false);
		btnTacGia.setBorderPainted(false);
		btnTacGia.setBackground(null);
		btnTacGia.setBounds(255, 108, 35, 27);
		panelSearch.add(btnTacGia);
		
		JButton btnTenSach = new JButton("");
		btnTenSach.setOpaque(false);
		btnTenSach.setIcon(new ImageIcon(img_add));
		btnTenSach.setBorderPainted(false);
		btnTenSach.setBackground((Color) null);
		btnTenSach.setBounds(543, 59, 35, 27);
		panelSearch.add(btnTenSach);
		
		JButton btnDanhMuc = new JButton("");
		btnDanhMuc.setOpaque(false);
		btnDanhMuc.setIcon(new ImageIcon(img_add));
		btnDanhMuc.setBorderPainted(false);
		btnDanhMuc.setBackground((Color) null);
		btnDanhMuc.setBounds(845, 59, 35, 27);
		panelSearch.add(btnDanhMuc);
		
		JButton btnNXB = new JButton("");
		btnNXB.setOpaque(false);
		btnNXB.setIcon(new ImageIcon(img_add));
		btnNXB.setBorderPainted(false);
		btnNXB.setBackground((Color) null);
		btnNXB.setBounds(543, 108, 35, 27);
		panelSearch.add(btnNXB);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(240, 128, 128));
		btnThem.setForeground(new Color(60, 179, 113));
		btnThem.setIcon(new ImageIcon(img_add));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem.setBounds(250, 158, 125, 31);
		panelSearch.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(218, 112, 214));
		btnSua.setForeground(new Color(0, 255, 255));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSua.setIcon(new ImageIcon(img_update));
		btnSua.setBounds(509, 158, 109, 31);
		panelSearch.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(123, 104, 238));
		btnXoa.setForeground(new Color(255, 0, 0));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setIcon(new ImageIcon(img_remove));
		btnXoa.setBounds(784, 158, 109, 31);
		panelSearch.add(btnXoa);
		
		JCheckBox checkBoxKhuyenMai = new JCheckBox("Khuyến Mãi");
		checkBoxKhuyenMai.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBoxKhuyenMai.setBackground(null);
		
		checkBoxKhuyenMai.setBounds(1230, 108, 109, 25);
		panelSearch.add(checkBoxKhuyenMai);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				panelSearchProduct.setVisible(true);
			}
		});
		btnSearch.setBounds(92, 11, 51, 31);
		btnSearch.setIcon(new ImageIcon(img_search));
		btnSearch.setBackground(null);
		btnSearch.setOpaque(false);
		btnSearch.setBorderPainted(false);
		
		panelSearch.add(btnSearch);
		
		JLabel lbllSearch = new JLabel("Sách");
		lbllSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbllSearch.setForeground(new Color(255, 165, 0));
		lbllSearch.setBounds(10, 112, 118, 27);
		add(lbllSearch);
		
		
		
		panelTable = new JPanel();
		panelTable.setBounds(0, 354, 1534, 663);
		add(panelTable);
		JTable table = new JTable();
		String[] column = {"Mã Sách","Tên Sách","Danh Mục","Tên Tác Giả","Nhà XB","năm XB","Số Lượng","Đơn Giá","Tình Trạng","Khuyến Mãi"};
		DefaultTableModel model = new DefaultTableModel(column,0);
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 0, 1534, 663);
		scrollPane.setViewportView(table = new JTable(model));
		table.setRowHeight(25);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		//
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(8).setPreferredWidth(150);
		table.getColumnModel().getColumn(9).setPreferredWidth(150);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		panelTable.setLayout(null);
		
		panelTable.add(scrollPane);
	
	}
}
