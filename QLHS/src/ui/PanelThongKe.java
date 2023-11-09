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
import list.DanhSachChiTietHoaDon;
import list.DanhSachHoaDon;
import list.DanhSachKhachHang;
import list.DanhSachSanPham;

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
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class PanelThongKe extends JPanel {

	private Image img_statics = new ImageIcon(frmNV.class.getResource("/image/staticss.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private Image img_details = new ImageIcon(frmNV.class.getResource("/image/deitailss.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private JDateChooser dateChooserBatDau;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lbllSumTitle;
	private JLabel lbllSum; 
	private JLabel lbllPrice;
	private JTable table;
	
	private DefaultTableModel mode;
	private DanhSachSanPham listsp;
	private DAO_SanPham daosp;
	private Object[] rowSp;
	
	private DanhSachKhachHang listKH;
	private DAO_KhachHang daoKH;
	
	private DanhSachHoaDon listHD;
	private DAO_HoaDon daoHd;
	
	private DanhSachChiTietHoaDon listCTHD;
	private DAO_ChiTietHoaDon daoCTHD;
	
	
	
//	private danhsach
	
	
	
	/**
	 * Create the panel.
	 */
	public PanelThongKe() {
		setBounds(0,0,1534,1017);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1534, 90);
		panel.setBackground(new Color(255, 165, 0));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thống Kê Doanh Thu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 0, 1534, 88);
		panel.add(lblNewLabel);
		
		JLabel lbllThongKE = new JLabel("Thống Kê");
		lbllThongKE.setBounds(10, 94, 117, 32);
		lbllThongKE.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lbllThongKE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 123, 1033, 168);
		add(panel_1);
		panel_1.setLayout(null);
		
		dateChooserBatDau = new JDateChooser();
		dateChooserBatDau.setBounds(172, 21, 159, 30);
		dateChooserBatDau.getDate();
		dateChooserBatDau.setDateFormatString("dd-MM-yyyy");
		panel_1.add(dateChooserBatDau);
		
		
		JButton btnThongKe = new JButton("Thống Kê");
		btnThongKe.setBackground(new Color(0, 255, 255));
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThongKe.setIcon(new ImageIcon(img_statics));
		btnThongKe.setBounds(792, 11, 209, 48);
		panel_1.add(btnThongKe);
		
		JButton btnChiTiet = new JButton("In Thống Kê");
		btnChiTiet.setBackground(new Color(144, 238, 144));
		btnChiTiet.setIcon(new ImageIcon(img_details));
		btnChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChiTiet.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnChiTiet.setBounds(792, 95, 209, 48);
		panel_1.add(btnChiTiet);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(107, 72, 53, -20);
		panel_1.add(separator);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox checkBox = (JCheckBox) e.getSource();
                if (checkBox.isSelected()) {
                    if(checkBox.getText().equalsIgnoreCase("Báo cáo nhập hàng")) {
                    	System.out.println("Nhap hang");
                    	lbllSumTitle.setText("Tổng số hóa đơn");
                    	
                    }else if(checkBox.getText().equalsIgnoreCase("Báo cáo bán hàng")) {
                    	System.out.println("Ban hang");
                    	
                    }else if(checkBox.getText().equalsIgnoreCase("Sách bán chạy")) {
                    	System.out.println("Ban chay");
                    }else {
                    	System.out.println("khach hang than thiet");
                    }
                    	
                    	
                } else {
                    System.out.println("Đã bỏ chọn: " + checkBox.getText());
                }
            }
        };
		
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Báo cáo nhập hàng");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxNewCheckBox.setBounds(455, 11, 190, 23);
		panel_1.add(chckbxNewCheckBox);
		buttonGroup.add(chckbxNewCheckBox);
		chckbxNewCheckBox.addActionListener(actionListener);
		
		JCheckBox chckbxBoCoBn = new JCheckBox("Báo cáo bán hàng");
		chckbxBoCoBn.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxBoCoBn.setBounds(455, 55, 190, 23);
		panel_1.add(chckbxBoCoBn);
		buttonGroup.add(chckbxBoCoBn);
		chckbxBoCoBn.addActionListener(actionListener);
		JCheckBox chckbxSchBnChy = new JCheckBox("Sách bán chạy");
		chckbxSchBnChy.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxSchBnChy.setBounds(455, 95, 190, 23);
		panel_1.add(chckbxSchBnChy);
		buttonGroup.add(chckbxSchBnChy);
		chckbxSchBnChy.addActionListener(actionListener);
		JCheckBox chckbxKhchHngThn = new JCheckBox("Khách hàng thân thiết");
		chckbxKhchHngThn.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxKhchHngThn.setBounds(455, 138, 190, 23);
		panel_1.add(chckbxKhchHngThn);
		buttonGroup.add(chckbxKhchHngThn);
		chckbxKhchHngThn.addActionListener(actionListener);
	
        
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Ngày bắt đầu");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(11, 21, 149, 30);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ngày Kết thúc");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(11, 95, 149, 30);
		panel_1.add(lblNewLabel_2_1);
		
		JDateChooser dateChooserKetThuc = new JDateChooser();
		dateChooserKetThuc.setDateFormatString("dd-MM-yyyy");
		dateChooserKetThuc.setBounds(172, 98, 159, 30);
		panel_1.add(dateChooserKetThuc);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 291, 1534, 37);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Danh Sách Hóa Đơn Bán Hàng");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 1534, 37);
		panel_3.add(lblNewLabel_1);
		
		JPanel panelShowInfo = new JPanel();
		panelShowInfo.setBounds(1055, 94, 479, 197);
		panelShowInfo.setBackground(UIManager.getColor("Button.light"));
		add(panelShowInfo);
		panelShowInfo.setLayout(null);
		
		lbllSumTitle = new JLabel("Tổng số hóa đơn");
		lbllSumTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllSumTitle.setBounds(10, 30, 137, 28);
		panelShowInfo.add(lbllSumTitle);
		
		lbllSum = new JLabel("Tổng số Sách");
		lbllSum.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllSum.setBounds(10, 82, 137, 28);
		panelShowInfo.add(lbllSum);
		
		lbllPrice = new JLabel("Tổng số tiền");
		lbllPrice.setBackground(UIManager.getColor("Button.light"));
		lbllPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllPrice.setBounds(10, 140, 137, 28);
		panelShowInfo.add(lbllPrice);
		
		textField = new JTextField();
		textField.setBounds(181, 30, 162, 28);
		panelShowInfo.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(181, 82, 162, 28);
		panelShowInfo.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(181, 140, 162, 28);
		panelShowInfo.add(textField_2);
		
		JLabel lblNewLabel_5 = new JLabel("Cuốn");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(353, 82, 83, 28);
		panelShowInfo.add(lblNewLabel_5);
		
		JPanel panelContent = new JPanel();
		panelContent.setBounds(0, 327, 1534, 652);
		add(panelContent);
		panelContent.setLayout(null);
		
		JPanel panelnhapHang = new JPanel();
		panelnhapHang.setBounds(0, 0, 1532, 652);
		panelContent.add(panelnhapHang);
		panelnhapHang.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1532, 652);
		panelnhapHang.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		


	}
}
