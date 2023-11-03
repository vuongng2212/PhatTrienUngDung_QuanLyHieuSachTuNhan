package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_NhanVien;
import entity.NhanVien;
import list.DanhSachNhanVien;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTimNV extends JPanel {
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtMa;
	private JTextField txtEmail;
	private JTable table;
	private DefaultTableModel tableModel;
	private DanhSachNhanVien ls;
	private DAO_NhanVien DAO_NV;
	private int stt = 1;
	/**
	 * Create the panel.
	 */
	public PanelTimNV() {
		ls = new DanhSachNhanVien();
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setBounds(0, 200, 1920, 816);
		setLayout(null);
		JPanel westPanel = new JPanel();
		westPanel.setLayout(null);
		westPanel.setBounds(0, 0, 400, 817);
		add(westPanel);
		
		JLabel lblTen = new JLabel("Tên nhân viên");
		lblTen.setForeground(new Color(0, 0, 160));
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTen.setBounds(10, 150, 130, 30);
		westPanel.add(lblTen);
		
		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setForeground(new Color(0, 0, 160));
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSDT.setBounds(10, 200, 130, 30);
		westPanel.add(lblSDT);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 0, 160));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(10, 250, 130, 30);
		westPanel.add(lblEmail);
		
		JLabel lblGT = new JLabel("Giới tính");
		lblGT.setForeground(new Color(0, 0, 160));
		lblGT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGT.setBounds(10, 300, 130, 30);
		westPanel.add(lblGT);
		
		JLabel lblDoB = new JLabel("Ngày sinh:");
		lblDoB.setForeground(new Color(0, 0, 160));
		lblDoB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDoB.setBounds(10, 350, 130, 30);
		westPanel.add(lblDoB);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTen.setColumns(10);
		txtTen.setBounds(205, 150, 160, 30);
		westPanel.add(txtTen);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSDT.setColumns(10);
		txtSDT.setBounds(205, 200, 160, 30);
		westPanel.add(txtSDT);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(205, 250, 160, 30);
		westPanel.add(txtEmail);
		
		JComboBox cbGT = new JComboBox();
		cbGT.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbGT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbGT.setBounds(205, 300, 100, 30);
		westPanel.add(cbGT);
		
		JLabel lblTimNV = new JLabel("Tìm nhân viên");
		lblTimNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimNV.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTimNV.setBounds(0, 40, 400, 50);
		westPanel.add(lblTimNV);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(205, 350, 160, 30);
		dateChooser.getDate();
		dateChooser.setDateFormatString("yyyy-[m]m-[d]d");
		westPanel.add(dateChooser);
		
		String[] headers = { "STT", "Mã nhân viên", "Họ và tên", "Ngày sinh", "Giới tính", "SĐT", "Địa chỉ", "Email", "Chức vụ"};
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(400, 0, 1520, 817);
		scroll.setViewportView(table = new JTable(tableModel));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				System.out.println(row);
				txtTen.setText(table.getValueAt(row, 2).toString());
				String gt = table.getValueAt(row, 4).toString();
				txtSDT.setText(table.getValueAt(row, 5).toString());
				txtEmail.setText(table.getValueAt(row, 7).toString());			
			}
		});
		table.setRowHeight(35);
		table.setAutoCreateRowSorter(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
//		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
//		table.getColumnModel().getColumn(3).setPreferredWidth(50);
//		table.getColumnModel().getColumn(4).setPreferredWidth(10);
//		table.getColumnModel().getColumn(4).setPreferredWidth(10);
		table.getColumnModel().getColumn(6).setPreferredWidth(500);
		table.getColumnModel().getColumn(7).setPreferredWidth(300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		add(scroll);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLamMoi.setBackground(new Color(0, 128, 255));
		btnLamMoi.setBounds(215, 445, 130, 50);
		westPanel.add(btnLamMoi);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String ten = txtTen.getText().trim();
//				String sdt = txtSDT.getText().trim();
//				String email = txtEmail.getText().trim();
//				String d = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().trim();
////				Date sqlDate = new Date(dateChooser.getDate().getTime());
//				String gioiTinh = cbGT.getSelectedItem().toString();
//				Integer gt = 0;
//				if(gioiTinh=="Nam"){
//					gt = 1;
//				}
//				System.out.println(ten+sdt+email+d+gt);
				loadData("h", "ads", "ads", 1, "ads");
			}
		});
		btnTim.setForeground(new Color(0, 0, 160));
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnTim.setBackground(Color.GREEN);
		btnTim.setBounds(35, 445, 130, 50);
		westPanel.add(btnTim);
	}
	public void deleteAllDataJtable() {
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
		while(dm.getRowCount() > 0)
		{
		    dm.removeRow(0);
		}
	}
	public void loadData(String tenNV, String sdt, String email, Integer gt, String ns) {
		deleteAllDataJtable();
		DAO_NV = new DAO_NhanVien();

		ls.clear();
		stt =1;
		for(NhanVien nv: DAO_NV.findNV2(tenNV,sdt,email,gt,ns)) {
			ls.themNhanVien(nv);
			String gioiTinh = "Nam";
			if(nv.getGioiTinh()==0) {
				gioiTinh = "Nữ";
			}
			Object row[] = {stt++,nv.getMaNV(),nv.getTenNV(),nv.getDoB(),gioiTinh,nv.getSDT(),nv.getDiaChi(),nv.getEmail(),nv.getChucVu()};
			tableModel.addRow(row);
		}

	}
}
