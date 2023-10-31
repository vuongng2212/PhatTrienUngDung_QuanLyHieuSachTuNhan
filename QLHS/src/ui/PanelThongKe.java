package ui;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class PanelThongKe extends JPanel {

	private Image img_statics = new ImageIcon(frmNV.class.getResource("/image/staticss.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private Image img_details = new ImageIcon(frmNV.class.getResource("/image/deitailss.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	
	/**
	 * Create the panel.
	 */
	public PanelThongKe() {
		setBounds(0,0,1534,1017);
//		setSize(1534,1017);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 1534, 90);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thống Kê Doanh Thu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 0, 1534, 88);
		panel.add(lblNewLabel);
		
		JLabel lbllThongKE = new JLabel("Thống Kê");
		lbllThongKE.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllThongKE.setBounds(10, 94, 117, 32);
		add(lbllThongKE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 123, 1534, 168);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbllNgay = new JLabel("Ngày");
		lbllNgay.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllNgay.setBounds(298, 23, 56, 35);
		panel_1.add(lbllNgay);
		
		JComboBox comboBoxNgay = new JComboBox();
		comboBoxNgay.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBoxNgay.setModel(new DefaultComboBoxModel(new String[] {"Tất Cả", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		comboBoxNgay.setBounds(371, 23, 87, 35);
		panel_1.add(comboBoxNgay);
		
		JLabel lbllThang = new JLabel("Ngày");
		lbllThang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllThang.setBounds(584, 23, 56, 35);
		panel_1.add(lbllThang);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tất Cả", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox.setBounds(650, 23, 87, 35);
		panel_1.add(comboBox);
		
		JLabel lbllNam = new JLabel("Năm");
		lbllNam.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllNam.setBounds(862, 23, 56, 35);
		panel_1.add(lbllNam);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Tất Cả"}));
		comboBox_1.setBounds(928, 23, 87, 35);
		panel_1.add(comboBox_1);
		
		JButton btnThongKe = new JButton("Thống Kê");
		btnThongKe.setBackground(new Color(0, 255, 255));
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThongKe.setIcon(new ImageIcon(img_statics));
		btnThongKe.setBounds(1195, 11, 209, 48);
		panel_1.add(btnThongKe);
		
		JButton btnChiTiet = new JButton("Chi Tiết Hóa Đơn");
		btnChiTiet.setBackground(new Color(144, 238, 144));
		btnChiTiet.setIcon(new ImageIcon(img_details));
		btnChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChiTiet.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnChiTiet.setBounds(1195, 70, 209, 48);
		panel_1.add(btnChiTiet);
		
		JRadioButton radioBtnNgay = new JRadioButton("Thống Kê Theo Ngày");
		radioBtnNgay.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioBtnNgay.setBounds(308, 65, 160, 23);
		panel_1.add(radioBtnNgay);
		
		JRadioButton radioBtnThang = new JRadioButton("Thống Kê Theo Tháng");
		radioBtnThang.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioBtnThang.setBounds(577, 65, 160, 23);
		panel_1.add(radioBtnThang);
		
		JRadioButton radioBtnNam = new JRadioButton("Thống Kê Theo Năm");
		radioBtnNam.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioBtnNam.setBounds(855, 65, 160, 23);
		panel_1.add(radioBtnNam);
		
		JLabel lbllDoanhThu = new JLabel("Doanh Thu:");
		lbllDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbllDoanhThu.setBounds(468, 114, 145, 43);
		panel_1.add(lbllDoanhThu);
		
		JLabel lbllDoanhThuValue = new JLabel("Null");
		lbllDoanhThuValue.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbllDoanhThuValue.setBounds(603, 114, 145, 43);
		panel_1.add(lbllDoanhThuValue);
		
		JPanel panelContent = new JPanel();
		panelContent.setBounds(0, 329, 1534, 688);
		add(panelContent);
		panelContent.setLayout(null);
		
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

		JTable table = new JTable();
		String[] column = {"Mã Hóa Đơn","Mã Nhân Viên","Mã Khách Hàng","Ngày Tạo Hóa Đơn","Thành Tiền"};
		DefaultTableModel model = new DefaultTableModel(column,0);
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 0, 1534, 663);
		scrollPane.setViewportView(table = new JTable(model));
		table.setRowHeight(25);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
	
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
	
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		panelContent.add(scrollPane);
		
		
		
	}
}
