package ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_NhanVien;
import dao.DAO_PhanCongCa;
import entity.Ca;
import entity.NhanVien;
import entity.PhanCongCa;
import list.DanhSachNhanVien;
import list.DanhSachPhanCongCa;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelShift extends JPanel {
	private JTextField textField;
	private JTable table;
	private DefaultTableModel tableModel;
	private DanhSachPhanCongCa ls;
	private DAO_PhanCongCa DAO_pcc;
	private Image img_TimNV = new ImageIcon(FormNVQuanLy.class.getResource("/image/pluss.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	/**
	 * Create the panel.
	 */
	public PanelShift() {
		ls = new DanhSachPhanCongCa();
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(0, 200, 1920, 816);
		setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 1920, 50);
		add(headerPanel);
		headerPanel.setLayout(null);
		
		JLabel lblTieuDe = new JLabel("Phân công ca làm việc");
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTieuDe.setBounds(880, 11, 232, 28);
		headerPanel.add(lblTieuDe);
		
		String[] headers = { "", "Thứ 2\nhello", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ nhật"};
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 130, 1450, 689);
		add(scroll);
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(200);
//		table.getColumnModel().getColumn(0).setPreferredWidth(10);
//		table.getColumnModel().getColumn(1).setPreferredWidth(10);
//		table.getColumnModel().getColumn(2).setPreferredWidth(10);
//		table.getColumnModel().getColumn(3).setPreferredWidth(10);
//		table.getColumnModel().getColumn(4).setPreferredWidth(10);
//		table.getColumnModel().getColumn(6).setPreferredWidth(10);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		JPanel panel = new JPanel();
		panel.setBounds(1450, 130, 489, 686);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNgayLamViec = new JLabel("Ngày làm việc");
		lblNgayLamViec.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayLamViec.setBounds(22, 55, 115, 30);
		panel.add(lblNgayLamViec);
		
		JLabel lblCa = new JLabel("Ca");
		lblCa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCa.setBounds(22, 96, 115, 30);
		panel.add(lblCa);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaNV.setBounds(22, 137, 115, 30);
		panel.add(lblMaNV);
		
		JLabel lblTenNV = new JLabel("Tên nhân viên");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenNV.setBounds(22, 178, 115, 30);
		panel.add(lblTenNV);
		
		JLabel lblHrsStart = new JLabel("Giờ bắt đầu");
		lblHrsStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHrsStart.setBounds(22, 216, 115, 30);
		panel.add(lblHrsStart);
		
		JLabel lblHrsEnd = new JLabel("Giờ kết thúc");
		lblHrsEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHrsEnd.setBounds(22, 257, 115, 30);
		panel.add(lblHrsEnd);
		
		JPanel panelThongTinCa = new JPanel();
		panelThongTinCa.setBounds(0, 0, 479, 44);
		panel.add(panelThongTinCa);
		
		JLabel lblThongTinCa = new JLabel("Thông tin ca làm việc");
		panelThongTinCa.add(lblThongTinCa);
		lblThongTinCa.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		
		textField = new JTextField();
		textField.setBounds(147, 139, 86, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblStart = new JLabel("Ngày bắt đầu");
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStart.setBounds(10, 89, 100, 30);
		add(lblStart);
		
		JLabel lblEnd = new JLabel("Ngày kết thúc");
		lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnd.setBounds(400, 89, 100, 30);
		add(lblEnd);
		JDateChooser dateChooserStart = new JDateChooser();
		dateChooserStart.setDateFormatString("dd-MM-yyyy");
		dateChooserStart.setBounds(120, 89, 140, 30);
		add(dateChooserStart);
		
		JDateChooser dateChooserEnd = new JDateChooser();
		dateChooserEnd.setDateFormatString("dd-MM-yyyy");
		dateChooserEnd.setBounds(510, 89, 140, 30);
		add(dateChooserEnd);
		
		JButton btnTimNV = new JButton("");
		btnTimNV.setIcon(new ImageIcon(img_TimNV));
		btnTimNV.setBounds(243, 137, 30, 30);
		panel.add(btnTimNV);
		
		JButton btnXoa = new JButton("Xóa ca");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBounds(184, 324, 89, 30);
		panel.add(btnXoa);
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setBackground(new Color(0, 255, 64));
		btnLuu.setForeground(new Color(255, 255, 255));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLuu.setBounds(22, 324, 89, 30);
		panel.add(btnLuu);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String start = ((JTextField)dateChooserStart.getDateEditor().getUiComponent()).getText().trim();
//				String end = ((JTextField)dateChooserStart.getDateEditor().getUiComponent()).getText().trim();
				String start = new Date(dateChooserStart.getDate().getTime()).toString();
				String end = new Date(dateChooserEnd.getDate().getTime()).toString();
//				System.out.println(start + "" + end);
				loadData(start, end, 1);
			}
		});
		btnTim.setBackground(new Color(0, 255, 64));
		btnTim.setBounds(700, 89, 89, 30);
		add(btnTim);
		
	}
	public void deleteAllDataJtable() {
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
		while(dm.getRowCount() > 0)
		{
		    dm.removeRow(0);
		}
	}
	public void loadData(String start, String end, Integer shift ) {
		deleteAllDataJtable();
		DAO_pcc = new DAO_PhanCongCa();

		ls.clear();
		ArrayList<String> ca = new ArrayList<String>();

		for(PhanCongCa pcc: DAO_pcc.get1Shift(start, end, shift)) {
			ca.add(pcc.getMaNV()+"\n"+pcc.getNgayLV());
			System.out.println(pcc.getMaNV());
		}
		
		tableModel.addRow(ca.toArray());
	}
	 private Object[] appendValue(Object[] obj, Object newObj) {

		ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(obj));
		temp.add(newObj);
		return temp.toArray();

	  }
}
