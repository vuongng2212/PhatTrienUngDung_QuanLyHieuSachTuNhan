package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_NhanVien;
import entity.NhanVien;
import list.DanhSachNhanVien;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class DialogNhanVien extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtMaNV;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JDateChooser dateChooser;
	private JTable table;
	private DefaultTableModel tableModel;
	private DanhSachNhanVien ls;
	private DAO_NhanVien DAO_NV;
	private int stt = 1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogNhanVien dialog = new DialogNhanVien();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	/**
	 * Create the dialog.
	 */
	public DialogNhanVien() {
		ls = new DanhSachNhanVien();
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(0, 0, 800, 700);
		contentPanel.setBounds(0, 75, 784, 552);

		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 628, 784, 33);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JLabel lblMaNV = new JLabel("Mã NV");
				lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblMaNV.setBounds(470, 3, 47, 25);
				buttonPane.add(lblMaNV);
			}
			{
				JButton btnChon = new JButton("Chọn");
				btnChon.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnChon.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnChon.setBounds(623, 5, 66, 23);
				btnChon.setActionCommand("OK");
				buttonPane.add(btnChon);
				getRootPane().setDefaultButton(btnChon);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnCancel.setBounds(699, 5, 75, 23);
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
			
			txtMaNV = new JTextField();
			txtMaNV.setBounds(527, 6, 86, 20);
			buttonPane.add(txtMaNV);
			txtMaNV.setColumns(10);
		}
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 784, 75);
		getContentPane().add(headerPanel);
		headerPanel.setLayout(null);
		
		JLabel lblTenNV = new JLabel("Tên NV");
		lblTenNV.setBounds(10, 11, 46, 20);
		headerPanel.add(lblTenNV);
		
		JLabel lblGT = new JLabel("Giới tính");
		lblGT.setBounds(10, 44, 69, 20);
		headerPanel.add(lblGT);
		
		JLabel lblSDT = new JLabel("SDT");
		lblSDT.setBounds(285, 11, 46, 20);
		headerPanel.add(lblSDT);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(285, 44, 46, 20);
		headerPanel.add(lblEmail);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(628, 11, 110, 20);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		headerPanel.add(dateChooser);
		
		txtTen = new JTextField();
		txtTen.setBounds(66, 11, 130, 20);
		headerPanel.add(txtTen);
		txtTen.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(341, 11, 110, 20);
		headerPanel.add(txtSDT);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(341, 44, 110, 20);
		headerPanel.add(txtEmail);
		
		JComboBox cbGT = new JComboBox();
		cbGT.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbGT.setBounds(89, 43, 51, 22);
		headerPanel.add(cbGT);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ten = txtTen.getText().trim();
				String sdt = txtSDT.getText().trim();
				String email = txtEmail.getText().trim();
				String d = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().trim();
				String gioiTinh = cbGT.getSelectedItem().toString();
				Integer gt = 0;
				if(gioiTinh=="Nam"){
					gt = 1;
				}
				loadData(ten, sdt, email, gt, d);
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTim.setBounds(553, 43, 89, 23);
		headerPanel.add(btnTim);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setBounds(553, 11, 65, 20);
		headerPanel.add(lblNgaySinh);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reFresh();
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLamMoi.setBounds(652, 43, 89, 23);
		headerPanel.add(btnLamMoi);
		
		String[] headers = { "STT", "Họ và tên", "Ngày sinh", "Giới tính", "SĐT", "Email"};
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 784, 552);
		scroll.setViewportView(table = new JTable(tableModel));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				if(row!=-1) {
					if(row >=0) {
						txtMaNV.setText(ls.getList().get(row).getMaNV());
					}
					else {
						txtMaNV.setText("");
					}
					txtTen.setText(table.getValueAt(row, 1).toString());
					String d = table.getValueAt(row, 2).toString();
					String gt = table.getValueAt(row, 3).toString();
					txtSDT.setText(table.getValueAt(row, 4).toString());
					txtEmail.setText(table.getValueAt(row, 5).toString());
					
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date = null;
					try {
						date = sdf1.parse(d);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
					dateChooser.setDate(sqlStartDate);
					cbGT.setSelectedItem(gt);
				}				
			}
		});
		table.setRowHeight(35);
		table.setAutoCreateRowSorter(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(3).setPreferredWidth(5);
//		table.getColumnModel().getColumn(2).setPreferredWidth(100);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		contentPanel.add(scroll);
		reFresh();
	}
	public void deleteAllDataJtable() {
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
		while(dm.getRowCount() > 0)
		{
		    dm.removeRow(0);
		}
	}
	private void xoaTrang() {
		txtTen.setText("");
		txtSDT.setText("");
		txtEmail.setText("");
		dateChooser.setCalendar(null);
	}
	public void reFresh() {
		xoaTrang();
		//delete all
		deleteAllDataJtable();
		//Load data
		DAO_NV = new DAO_NhanVien();
		stt = 1;
		ls.clear();
		for(NhanVien nv: DAO_NV.getAll()) {
			ls.themNhanVien(nv);
			String gioiTinh = "Nam";
			if(nv.getGioiTinh()==0) {
				gioiTinh = "Nữ";
			}
			Object row[] = {stt++,nv.getTenNV(),nv.getDoB(),gioiTinh,nv.getSDT(),nv.getEmail()};
			tableModel.addRow(row);
		}
	}
	public void loadData(String tenNV, String sdt, String email, Integer gt, String ns) {
		deleteAllDataJtable();
		DAO_NV = new DAO_NhanVien();

		ls.clear();
		stt =1;
		for(NhanVien nv: DAO_NV.findNV(tenNV,sdt,email,gt,ns)) {
			ls.themNhanVien(nv);
			String gioiTinh = "Nam";
			if(nv.getGioiTinh()==0) {
				gioiTinh = "Nữ";
			}
			Object row[] = {stt++,nv.getTenNV(),nv.getDoB(),gioiTinh,nv.getSDT(),nv.getEmail()};
			tableModel.addRow(row);
		}

	}



	public String getMaNVSelected() {
		return txtMaNV.getText();
	}
}
