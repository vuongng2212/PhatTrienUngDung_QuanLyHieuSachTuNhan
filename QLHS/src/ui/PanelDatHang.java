package ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelDatHang extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtChietKhau;
	private JTable table, tableTTSP;
	private DefaultTableModel tableModel,tableModelTTSP;
	private JTextField textField_2;
	/**
	 * Create the panel.
	 */
	public PanelDatHang() {
		setBounds(0, 200, 1920, 816);
		setLayout(null);
		JPanel tblPanel = new JPanel();
		tblPanel.setBounds(0, 0, 1170, 816);
		add(tblPanel);
		String[] headers = { "STT", "Mã sách", "Tên sách", "Thể loại", "NXB", "Năm XB", "Số lượng", "Đơn giá", "Tình trạng", "Khuyến mãi"};
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 60, 1170, 655);
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
		
		JLabel lblTimSach = new JLabel("Tìm sách:");
		lblTimSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTimSach.setBounds(10, 15, 90, 20);
		tblPanel.add(lblTimSach);
		
		JLabel lblTen = new JLabel("Tên sách");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTen.setBounds(120, 17, 70, 20);
		tblPanel.add(lblTen);
		
		textField = new JTextField();
		textField.setBounds(200, 19, 100, 20);
		tblPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTheLoai = new JLabel("Thể loại");
		lblTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTheLoai.setBounds(310, 17, 70, 20);
		tblPanel.add(lblTheLoai);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(390, 18, 100, 22);
		tblPanel.add(comboBox);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(0, 128, 255));
		btnTim.setBounds(1080, 11, 90, 30);
		tblPanel.add(btnTim);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setBounds(1030, 747, 90, 30);
		tblPanel.add(btnThem);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBackground(new Color(0, 255, 64));
		
		JLabel lblSL = new JLabel("Số lượng");
		lblSL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSL.setBounds(800, 744, 90, 30);
		tblPanel.add(lblSL);
		
		textField_1 = new JTextField();
		textField_1.setBounds(900, 747, 90, 30);
		tblPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNXB = new JLabel("Nhà XB:");
		lblNXB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNXB.setBounds(520, 17, 70, 20);
		tblPanel.add(lblNXB);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(600, 18, 100, 22);
		tblPanel.add(comboBox_1);
		
		JLabel lblNam = new JLabel("Năm XB");
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNam.setBounds(740, 17, 70, 20);
		tblPanel.add(lblNam);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(820, 18, 70, 22);
		tblPanel.add(comboBox_1_1);
		
		
		
		JPanel tbl = new JPanel();
		tbl.setBounds(1200, 240, 720, 584);
		add(tbl);
		String[] headers1 = { "STT", "Mã sách", "Tên sách", "Thể loại", "Số lượng", "Đơn giá"};
		tableModelTTSP = new DefaultTableModel(headers1, 0);
		JScrollPane scroll1 = new JScrollPane(tableTTSP, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll1.setBounds(0, 60, 720, 415);
		scroll1.setViewportView(tableTTSP = new JTable(tableModelTTSP));
		tableTTSP.setRowHeight(25);
		tableTTSP.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableTTSP.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableTTSP.getColumnModel().getColumn(2).setPreferredWidth(200);
		tableTTSP.getColumnModel().getColumn(3).setPreferredWidth(50);
		tableTTSP.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableTTSP.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tbl.setLayout(null);
		tbl.add(scroll1);
		
//		JPanel westPanel = new JPanel();
//		westPanel.setBounds(0, 401, 600, 415);
//		westPanel.setLayout(null);
//		add(westPanel);
		JPanel tTDHPanel = new JPanel();
		scroll1.setColumnHeaderView(tTDHPanel);
		tTDHPanel.setLayout(null);
		
		JLabel lblHDDH = new JLabel("Danh sách sản phẩm đặt hàng");
		lblHDDH.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHDDH.setBounds(215, 11, 305, 30);
		tbl.add(lblHDDH);
		
		JButton btnDH = new JButton("Đặt hàng");
		btnDH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDH.setBackground(new Color(0, 255, 64));
		btnDH.setBounds(580, 529, 130, 30);
		tbl.add(btnDH);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBounds(580, 488, 130, 30);
		tbl.add(btnXoa);
		
		JLabel lblThanhTien = new JLabel("Thành tiền");
		lblThanhTien.setForeground(new Color(255, 0, 0));
		lblThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThanhTien.setBounds(10, 530, 90, 30);
		tbl.add(lblThanhTien);
		
		JLabel lblTTPhieuDH = new JLabel("Thông tin phiếu đặt hàng");
		lblTTPhieuDH.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTTPhieuDH.setBounds(1440, 11, 270, 30);
		add(lblTTPhieuDH);
		
		JLabel lblMaDH = new JLabel("Mã đặt hàng");
		lblMaDH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaDH.setBounds(1200, 60, 150, 25);
		add(lblMaDH);
		
		JLabel lblMaNV = new JLabel("Nhân viên đặt hàng");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaNV.setBounds(1200, 96, 150, 25);
		add(lblMaNV);
		
		JLabel lblNgayDH = new JLabel("Ngày đặt");
		lblNgayDH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayDH.setBounds(1200, 132, 150, 25);
		add(lblNgayDH);
		
		JLabel lblChietKhau = new JLabel("Chiết khấu:");
		lblChietKhau.setBounds(1200, 168, 150, 30);
		add(lblChietKhau);
		lblChietKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtChietKhau = new JTextField();
		txtChietKhau.setBounds(1395, 173, 50, 25);
		add(txtChietKhau);
		txtChietKhau.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(1395, 62, 100, 25);
		add(textField_2);
		
		JLabel lblTenNV = new JLabel("New label");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenNV.setBounds(1395, 96, 150, 25);
		add(lblTenNV);
		
		JLabel lblNgayTao = new JLabel("New label");
		lblNgayTao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayTao.setBounds(1395, 137, 150, 25);
		add(lblNgayTao);
		
		
	}
}
