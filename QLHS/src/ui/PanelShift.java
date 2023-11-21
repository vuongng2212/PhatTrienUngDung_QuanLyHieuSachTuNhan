package ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_Ca;
import dao.DAO_PhanCongCa;
import entity.Ca;
import entity.PhanCongCa;
import list.DanhSachPhanCongCa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class PanelShift extends JPanel {
	private JLabel lblValDate,lblValCa,lblValTen,lblStartHour,lblEndHour;
	private JTextField txtMaNV;
	private JTable table;
	private DefaultTableModel tableModel;
	private DanhSachPhanCongCa ls;
	private DAO_PhanCongCa DAO_pcc;
	private DAO_Ca DAO_ca;
	private String[] headers;
	private JScrollPane scroll;
	private boolean tableCheck;
	private DialogNhanVien dialogNV ;
	private Image img_TimNV = new ImageIcon(FormNVQuanLy.class.getResource("/image/search.png")).getImage().getScaledInstance(25, 25,Image.SCALE_SMOOTH );
	/**
	 * Create the panel.
	 */
	public PanelShift() {
		dialogNV = new DialogNhanVien();
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

				if(tableCheck==true) {
					remove(scroll);
				}
				
				tableModel = new DefaultTableModel(headers, 0);

				scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setBounds(0, 130, 1450, 689);
				add(scroll);
				tableCheck = true;
				scroll.setViewportView(table = new JTable(tableModel));
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						int r = table.getSelectedRow();
						String str = "";
						if(r!=-1) {
							int c = table.getSelectedColumn();
							str = (String) table.getValueAt(r,c);
							lblValDate.setText(headers[c]);
							if(!str.equals("")) {
								txtMaNV.setText(str.substring(0, 5));
								lblValTen.setText(str.substring(6));
							}
							else {
								txtMaNV.setText("");
								lblValTen.setText("");
							}
							int caVal = r +1;
							lblValCa.setText(""+caVal);
							
							DAO_ca = new DAO_Ca();
							Ca ca = DAO_ca.getGio(r+1);
							lblStartHour.setText(ca.getGioBatDau());
							lblEndHour.setText(ca.getGioKetThuc());
						}	
					}
				});
				table.setRowHeight(300);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
				
				if(tableCheck==true) {
					loadCa(headers);
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
		
		
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(147, 139, 86, 30);
		panel.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		
		JButton btnShowNV = new JButton("");
		btnShowNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogNV.setModal(true);
				dialogNV.setVisible(true);
				String str = dialogNV.getMaNVSelected();
				txtMaNV.setText(str);
			}
		});
		btnShowNV.setIcon(new ImageIcon(img_TimNV));
		btnShowNV.setBounds(243, 139, 30, 30);
		panel.add(btnShowNV);
		
		JButton btnXoa = new JButton("Xóa ca");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(DAO_pcc.delete(txtMaNV.getText(),Integer.parseInt(lblValCa.getText()),lblValDate.getText())) {
						JOptionPane.showMessageDialog(getParent(), "Xóa thành công");
					}
					else {
						JOptionPane.showMessageDialog(getParent(), "Xóa thất bại");
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				loadCa(headers);
			}
		});
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBounds(315, 324, 89, 30);
		panel.add(btnXoa);
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(DAO_pcc.add(txtMaNV.getText(),Integer.parseInt(lblValCa.getText()),lblValDate.getText())) {
						JOptionPane.showMessageDialog(getParent(), "Thêm thành công");
					}
					else {
						JOptionPane.showMessageDialog(getParent(), "Thêm thất bại");
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				loadCa(headers);
			}
		});
		btnLuu.setBackground(new Color(0, 255, 64));
		btnLuu.setForeground(new Color(255, 255, 255));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLuu.setBounds(22, 324, 89, 30);
		panel.add(btnLuu);
		
		lblValDate = new JLabel("");
		lblValDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValDate.setBounds(147, 55, 115, 30);
		panel.add(lblValDate);
		
		lblValCa = new JLabel("");
		lblValCa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValCa.setBounds(147, 96, 115, 30);
		panel.add(lblValCa);
		
		lblValTen = new JLabel("");
		lblValTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValTen.setBounds(147, 178, 200, 30);
		panel.add(lblValTen);
		
		lblStartHour = new JLabel("");
		lblStartHour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStartHour.setBounds(147, 216, 115, 30);
		panel.add(lblStartHour);
		
		lblEndHour = new JLabel("");
		lblEndHour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEndHour.setBounds(147, 257, 115, 30);
		panel.add(lblEndHour);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(DAO_pcc.update(txtMaNV.getText(),Integer.parseInt(lblValCa.getText()),lblValDate.getText())) {
						JOptionPane.showMessageDialog(getParent(), "Cập nhật thành công");
					}
					else {
						JOptionPane.showMessageDialog(getParent(), "Cập nhật thất bại");
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				loadCa(headers);
			}
		});
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBackground(new Color(0, 255, 64));
		btnSua.setBounds(173, 324, 89, 30);
		panel.add(btnSua);
		
		
		
	}
	public void deleteAllDataJtable() {
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
		while(dm.getRowCount() > 0)
		{
		    dm.removeRow(0);
		}
	}
	public void loadCa(String[] date) {
		deleteAllDataJtable();
		
		DAO_pcc = new DAO_PhanCongCa();
		ArrayList<String> ca1 = new ArrayList<String>();
		ArrayList<String> ca2 = new ArrayList<String>();
		for (int i = 0; i < 7; i++)
	    {	
			PhanCongCa pcc = DAO_pcc.get1Shift(date[i], 1);
			if(pcc!=null) {
				ca1.add(pcc.getMaNV()+"."+pcc.getTenNV());
			}
			else {
				ca1.add("");
			}
			
			PhanCongCa pcc2 = DAO_pcc.get1Shift(date[i], 2);
			if(pcc2!=null) {
				ca2.add(pcc2.getMaNV()+"."+pcc2.getTenNV());
			}
			else {
				ca2.add("");
			}
	    }
		tableModel.addRow(ca1.toArray());
		tableModel.addRow(ca2.toArray());
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
