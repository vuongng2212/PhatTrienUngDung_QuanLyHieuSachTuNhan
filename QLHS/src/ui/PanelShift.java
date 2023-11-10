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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;

public class PanelShift extends JPanel {
	private JTextField textField;
	private JTable table;
	private DefaultTableModel tableModel;
	private DanhSachPhanCongCa ls;
	private DAO_PhanCongCa DAO_pcc;
	private String[] headers;
	private JScrollPane scroll;
	private boolean tableCheck;
	private Image img_TimNV = new ImageIcon(FormNVQuanLy.class.getResource("/image/pluss.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	/**
	 * Create the panel.
	 */
	public PanelShift() {
		ls = new DanhSachPhanCongCa();
		tableCheck=false;
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
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(1211, 89, 140, 30);
		add(dateChooser);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date(dateChooser.getDate().getTime());
				headers = findDayInWeek(date);
				DAO_pcc = new DAO_PhanCongCa();

				
				if(tableCheck==true) {
					remove(scroll);
				}
				
				tableModel = new DefaultTableModel(headers, 0);

				scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setBounds(0, 130, 1450, 689);
				add(scroll);
				tableCheck = true;
				scroll.setViewportView(table = new JTable(tableModel));
				table.setRowHeight(200);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
				
				if(tableCheck==true) {
					ArrayList<String> ca = new ArrayList<String>();
					for (int i = 0; i < 7; i++)
				    {	
						System.out.println(headers[i]);
						PhanCongCa pcc = DAO_pcc.get1Shift(headers[i], 1);
						if(pcc!=null) {
							ca.add(pcc.getMaNV());
						}
						else {
							ca.add("");
						}
				    }
					System.out.println(ca);
					tableModel.addRow(ca.toArray());
				}
			}
		});
		btnTim.setBackground(new Color(0, 255, 64));
		btnTim.setBounds(1361, 89, 89, 30);
		add(btnTim);

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
		
		
		
	}
	public void deleteAllDataJtable() {
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
		while(dm.getRowCount() > 0)
		{
		    dm.removeRow(0);
		}
	}
	public void loadData(String date, Integer shift, Integer r, Integer c ) {
		deleteAllDataJtable();
		DAO_pcc = new DAO_PhanCongCa();

		ls.clear();
//		ArrayList<String> ca = new ArrayList<String>();
//		for(PhanCongCa pcc: DAO_pcc.get1Shift(date, shift)) {
////			ca.add(pcc.getMaNV()+" "+pcc.getNgayLV());
//		}
//		tableModel.addRow(ca.toArray());
	}
	public String[] findDayInWeek(Date date) {
//		date = Date.valueOf("2023-11-10");
//		Calendar now = Calendar.getInstance();
		Calendar now = new GregorianCalendar();
		now.setTime(date);
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	    String[] days = new String[7];
	    int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 2; //add 2 if your week start on monday
	    now.add(Calendar.DAY_OF_MONTH, delta );
	    for (int i = 0; i < 7; i++)
	    {
	        days[i] = format.format(now.getTime());
	        now.add(Calendar.DAY_OF_MONTH, 1);
	    }
	    return days;
	}

}
