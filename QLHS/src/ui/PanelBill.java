package ui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JTree;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PanelBill extends JPanel {

	public JPanel panelTitle;
	public JLabel lbllHoaDonBanHang;
	public  panelBanHang banHang = new panelBanHang();
	
	/**
	 * Create the panel.
	 */
	public PanelBill() {
		setBounds(0,0,1534,1017);
//		setSize(1534,1017);
		setLayout(null);
		
		panelTitle = new JPanel();
		panelTitle.setBounds(0, 0, 1534, 61);
		add(panelTitle);
		panelTitle.setLayout(null);
		
		JPanel panelTitleNhap = new JPanel();
		panelTitleNhap.setBackground(new Color(0, 153, 255));
		panelTitleNhap.setBounds(0, 0, 1534, 61);
		panelTitle.add(panelTitleNhap);
		panelTitleNhap.setLayout(null);
		
		lbllHoaDonBanHang = new JLabel("HÓA ĐƠN BÁN HÀNG");
		lbllHoaDonBanHang.setBounds(0, 0, 1534, 61);
		panelTitleNhap.add(lbllHoaDonBanHang);
		lbllHoaDonBanHang.setBackground(new Color(0, 255, 255));
		lbllHoaDonBanHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbllHoaDonBanHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel panelCtn = new JPanel();
		panelCtn.setBounds(0, 61, 1534, 956);
		banHang.setLocation(0, 11);
		panelCtn.add(banHang);
		
//		JButton btnTimKiemKH = new JButton("");
//		btnTimKiemKH.setIcon(new ImageIcon());
//		btnTimKiemKH.setBackground(new Color(255, 255, 255));
//		btnTimKiemKH.setBounds(600, 114, 52, 23);
//		banHang.add(btnTimKiemKH);
		add(panelCtn);
		panelCtn.setLayout(null);
	}
}
