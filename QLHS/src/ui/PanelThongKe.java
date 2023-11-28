package ui;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.DAO_ChiTietHoaDon;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_SanPham;
import dao.DAO_ThongKe;
import entity.PhieuNhapHang;
import entity.SanPham;
import entity.ThongKeEntity;
import list.DanhSachChiTietHoaDon;
import list.DanhSachHoaDon;
import list.DanhSachKhachHang;
import list.DanhSachPhieuNH;
import list.DanhSachSanPham;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class PanelThongKe extends JPanel {

	private Image img_statics = new ImageIcon(frmNV.class.getResource("/image/staticss.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private Image img_details = new ImageIcon(frmNV.class.getResource("/image/deitailss.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private JTextField txtCount;
	private JTextField txtSoSach;
	private JTextField txtTongTien;
	private JLabel lbllSumTitle;
	private JLabel lbllSum; 
	private JLabel lbllPrice;
	private JTable table;
	private JPanel panelContent;
	private DefaultTableModel tableModel;
	private JScrollPane scroll;
	private JButton btnThongKe;
	private DefaultTableModel mode;
	private DanhSachSanPham listsp;
	private DAO_SanPham daosp;
	private Object[] rowSp;
	
	private DanhSachKhachHang listKH;
	private DAO_KhachHang daoKH;
	
	private DanhSachHoaDon listHD;
	private DAO_HoaDon daoHd;
	
	private DAO_ThongKe DAO_ThongKe;
	private DanhSachPhieuNH lsPDH;
	private DanhSachSanPham lsSP;
	
	private DanhSachChiTietHoaDon listCTHD;
	private DAO_ChiTietHoaDon daoCTHD;
	
	
	
	private int count = 0,thongKeVal = -1;
	private double thanhTien =0 ;
	private Date date = null;
	private int dateReturn = -1;
	private boolean tableCheck = false;
	
	
	
	/**
	 * Create the panel.
	 */
	public PanelThongKe() {
		
		setBounds(0, 200, 1920, 816);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1920, 60);
		panel.setBackground(new Color(255, 165, 0));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Thống kê");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitle.setBounds(0, 0, 1921, 60);
		panel.add(lblTitle);
		
		JLabel lbllThongKE = new JLabel("Thống Kê");
		lbllThongKE.setBounds(92, 60, 117, 32);
		lbllThongKE.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lbllThongKE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 94, 1388, 168);
		add(panel_1);
		panel_1.setLayout(null);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(107, 72, 53, -20);
		panel_1.add(separator);
		
		ButtonGroup buttonThongKeGroup = new ButtonGroup();
		ButtonGroup buttonNgayGroup = new ButtonGroup();
		ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox checkBox = (JCheckBox) e.getSource();
                if (checkBox.isSelected()) {
                    if(checkBox.getText().equalsIgnoreCase("Thống kê số lượng sách nhập")) {
                    	thongKeVal = 0;
                    }else if(checkBox.getText().equalsIgnoreCase("Thống kê chi tiêu nhập sách")) {
                    	thongKeVal = 1;
                    }else if(checkBox.getText().equalsIgnoreCase("Sách bán chạy")) {
                    	thongKeVal = 2;
                    }else if(checkBox.getText().equalsIgnoreCase("Khách hàng thân thiết")) {
                    	thongKeVal = 3;
                    }
                    
                    //Check thoi gian
                    if(checkBox.getText().equalsIgnoreCase("Hôm nay")) {
                    	date = Date.valueOf(getMinusTime(0));
                    	dateReturn = 0;
                    	System.out.println(date);
                    }else if(checkBox.getText().equalsIgnoreCase("Hôm qua")) {
                    	date = Date.valueOf(getMinusTime(1));
                    	dateReturn = -1;
                    	System.out.println(date);
                    }else if(checkBox.getText().equalsIgnoreCase("7 ngày trước")) {
                    	date = Date.valueOf(getMinusTime(7));
                    	dateReturn = -7;
                    	System.out.println(date);
                    }else if(checkBox.getText().equalsIgnoreCase("30 ngày trước")) {
                    	date = Date.valueOf(getMinusTime(30));
                    	dateReturn = -30;
                    	System.out.println(date);
                    }
                } 
            }
        };
		

		
		
		JCheckBox chkSLSN = new JCheckBox("Thống kê số lượng sách nhập");
		chkSLSN.setFont(new Font("Tahoma", Font.BOLD, 15));
		chkSLSN.setBounds(20, 11, 280, 23);
		panel_1.add(chkSLSN);
		buttonThongKeGroup.add(chkSLSN);
		chkSLSN.addActionListener(actionListener);
		
		JCheckBox chkNhapSach = new JCheckBox("Thống kê chi tiêu nhập sách");
		chkNhapSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		chkNhapSach.setBounds(20, 50, 250, 23);
		panel_1.add(chkNhapSach);
		buttonThongKeGroup.add(chkNhapSach);
		chkNhapSach.addActionListener(actionListener);
		
		JCheckBox chckbxSchBnChy = new JCheckBox("Sách bán chạy");
		chckbxSchBnChy.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxSchBnChy.setBounds(20, 95, 190, 23);
		panel_1.add(chckbxSchBnChy);
		buttonThongKeGroup.add(chckbxSchBnChy);
		chckbxSchBnChy.addActionListener(actionListener);
		
		JCheckBox chckbxKhchHngThn = new JCheckBox("Khách hàng thân thiết");
		chckbxKhchHngThn.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxKhchHngThn.setBounds(20, 138, 190, 23);
		panel_1.add(chckbxKhchHngThn);
		buttonThongKeGroup.add(chckbxKhchHngThn);
		chckbxKhchHngThn.addActionListener(actionListener);
		
		//Check box time
		JCheckBox chkHomNay = new JCheckBox("Hôm nay");
		chkHomNay.setFont(new Font("Tahoma", Font.BOLD, 15));
		chkHomNay.setBounds(367, 11, 280, 23);
		buttonNgayGroup.add(chkHomNay);
		panel_1.add(chkHomNay);
		chkHomNay.addActionListener(actionListener);
		
		JCheckBox chkHomQua = new JCheckBox("Hôm qua");
		chkHomQua.setFont(new Font("Tahoma", Font.BOLD, 15));
		chkHomQua.setBounds(367, 52, 280, 23);
		buttonNgayGroup.add(chkHomQua);
		panel_1.add(chkHomQua);
		chkHomQua.addActionListener(actionListener);
		
		JCheckBox chk7Ngay = new JCheckBox("7 ngày trước");
		chk7Ngay.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonNgayGroup.add(chk7Ngay);
		chk7Ngay.setBounds(367, 95, 280, 23);
		panel_1.add(chk7Ngay);
		chk7Ngay.addActionListener(actionListener);
		
		JCheckBox chk30Ngay = new JCheckBox("30 ngày trước");
		chk30Ngay.setFont(new Font("Tahoma", Font.BOLD, 15));
		chk30Ngay.setBounds(367, 140, 280, 23);
		buttonNgayGroup.add(chk30Ngay);
		panel_1.add(chk30Ngay);
		chk30Ngay.addActionListener(actionListener);
		
		JPanel panelShowInfo = new JPanel();
		panelShowInfo.setBounds(1398, 94, 522, 168);
		panelShowInfo.setBackground(UIManager.getColor("Button.light"));
		add(panelShowInfo);
		panelShowInfo.setLayout(null);
		
		lbllSumTitle = new JLabel("Tổng số hóa đơn");
		lbllSumTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllSumTitle.setBounds(10, 11, 137, 28);
		panelShowInfo.add(lbllSumTitle);
		
		lbllSum = new JLabel("Tổng số Sách");
		lbllSum.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllSum.setBounds(10, 60, 137, 28);
		panelShowInfo.add(lbllSum);
		
		lbllPrice = new JLabel("Tổng số tiền");
		lbllPrice.setBackground(UIManager.getColor("Button.light"));
		lbllPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllPrice.setBounds(10, 111, 137, 28);
		panelShowInfo.add(lbllPrice);
		
		txtCount = new JTextField();
		txtCount.setBounds(181, 13, 162, 28);
		panelShowInfo.add(txtCount);
		txtCount.setColumns(10);
		
		txtSoSach = new JTextField();
		txtSoSach.setColumns(10);
		txtSoSach.setBounds(181, 62, 162, 28);
		panelShowInfo.add(txtSoSach);
		
		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(181, 113, 162, 28);
		panelShowInfo.add(txtTongTien);
		
		JLabel lblNewLabel_5 = new JLabel("Cuốn");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(353, 60, 83, 28);
		panelShowInfo.add(lblNewLabel_5);
		
		panelContent = new JPanel();
		panelContent.setBounds(0, 316, 1920, 489);
		add(panelContent);
		panelContent.setLayout(null);
		
		JLabel lblTime = new JLabel("Thời gian");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTime.setBounds(383, 60, 117, 32);
		add(lblTime);
		
		btnThongKe = new JButton("Thống Kê");
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(thongKeVal!= -1 && date != null) {
					DAO_ThongKe = new DAO_ThongKe();
					if(tableCheck==true) {
						panelContent.remove(scroll);
						tableCheck = false;
					}
					//Thong ke sl sach nhap
					if(thongKeVal == 0) {
						lsSP = new DanhSachSanPham();
						xoaTxt();
						String[] headers = {"Mã sản phẩm","Tên sản phẩm","Số lượng nhập vào","Số lượng trước khi nhập", "Số lượng sau khi nhập"};
						taoBang(headers);						
						for(SanPham sp: DAO_ThongKe.ThongKeSLNhap(date, Date.valueOf(getMinusTime(0)))) {
							lsSP.add(sp);
							Object row[] = {sp.getMaSP(),sp.getTenSP(),sp.getSlNhap(),sp.getSlGoc(),sp.getSoLuong()};
							tableModel.addRow(row);
						}
					}
					//Bao cao chi tieu nhap sach
					if(thongKeVal == 1) {
						lsPDH = new DanhSachPhieuNH();
						count = 0;
						thanhTien = 0;
						xoaTxt();
						String[] headers = {"Mã đặt hàng","Ngày đặt hàng","Chiết khấu","Thành tiền"};
						taoBang(headers);						
						for(PhieuNhapHang pdh: DAO_ThongKe.baoCaoThuChiNhapSach(date, Date.valueOf(getMinusTime(0)))) {
							lsPDH.them(pdh);
							count++;
							thanhTien += pdh.getThanhTien();
							Object row[] = {pdh.getmaNH(),pdh.getNgayDH(),pdh.getChietKhau(),pdh.getThanhTien()};
							tableModel.addRow(row);
						}
						txtCount.setText(String.valueOf(count));
						txtTongTien.setText(String.valueOf(thanhTien));
					}
					if(thongKeVal == 2) {
						DAO_ThongKe = new DAO_ThongKe();
						ArrayList<ThongKeEntity>listTK = new ArrayList<ThongKeEntity>();
						ThongKeEntity tk = new ThongKeEntity();
						listTK = DAO_ThongKe.SachBanChay(dateReturn);
						count = 0;
						Object[] row = new Object[4];
						xoaTxt();
						String[] header = {"Mã Sản Phẩm","Tên Sản Phẩm","Số Lượng","Tiền Bán Được"};
						taoBang(header);
						for (ThongKeEntity sp : listTK) {
							row[0] = sp.getMa();
							row[1] = sp.getName();
							row[2] = sp.getNumber();
							row[3] = sp.getTongTien();
							tableModel.addRow(row);
						}
					}
					if(thongKeVal==3) {
						System.out.println("ahihi");
						DAO_ThongKe = new DAO_ThongKe();
						ArrayList<ThongKeEntity>listTK = new ArrayList<ThongKeEntity>();
						ThongKeEntity tk = new ThongKeEntity();
						listTK = DAO_ThongKe.khachHangThanThiet(dateReturn);
						count = 0;
						Object[] row = new Object[4];
						xoaTxt();
						String[] header = {"Mã Khách Hàng","Tên Khách Hàng","Số Lần Mua","Tiền Mua"};
						taoBang(header);
						for (ThongKeEntity kh : listTK) {
							row[0] = kh.getMa();
							row[1] = kh.getName();
							row[2] = kh.getNumber();
							row[3] = kh.getTongTien();
							tableModel.addRow(row);
						}
					}
				}
			}
		});
		btnThongKe.setBackground(new Color(0, 255, 255));
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThongKe.setIcon(new ImageIcon(img_statics));
		btnThongKe.setBounds(1169, 11, 209, 48);
		panel_1.add(btnThongKe);
		
		JButton btnChiTiet = new JButton("In Thống Kê");
		btnChiTiet.setBackground(new Color(144, 238, 144));
		btnChiTiet.setIcon(new ImageIcon(img_details));
		btnChiTiet.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnChiTiet.setBounds(1169, 109, 209, 48);
		panel_1.add(btnChiTiet);
		
		JLabel lblNewLabel_1 = new JLabel("Danh Sách Hóa Đơn Bán Hàng");
		lblNewLabel_1.setBounds(0, 262, 1920, 54);
		add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	}
	public LocalDate getMinusTime(long day) {
		LocalDate localDate = LocalDate.now();
		if(day>0) {
			localDate = localDate.minusDays(day);
		}
		return localDate;
	}
	public void taoBang(String[] headers) {
		tableModel = new DefaultTableModel(headers, 0);
		scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 1534, 652);
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(35);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		panelContent.add(scroll);
		tableCheck = true;
	}
	public void xoaTxt() {
		txtCount.setText("");
		txtSoSach.setText("");
		txtTongTien.setText("");
	}
	public void printReport(String fileName) {
		try {
			String URL = "jdbc:sqlserver://localhost:1433;databaseName=qlSachTuNhan;";
	        String user = "sa";
	        String pass = "123";
	        Connection con = DriverManager.getConnection(URL, user, pass);
			JasperReport jr = JasperCompileManager.compileReport(getClass().getResourceAsStream("/report/"+fileName+".jrxml"));
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer jv = new JasperViewer(jp);
			jv.setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
