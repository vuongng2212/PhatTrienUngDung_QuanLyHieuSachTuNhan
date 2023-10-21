package ui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JTree;
import java.awt.Color;

public class PanelBill extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelBill() {
		setBounds(0,0,1534,1017);
//		setSize(1534,1017);
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBounds(0, 0, 1534, 61);
		add(panelTitle);
		panelTitle.setLayout(null);
		
		JPanel panelTitleNhap = new JPanel();
		panelTitleNhap.setBackground(new Color(0, 153, 255));
		panelTitleNhap.setBounds(0, 0, 767, 61);
		panelTitle.add(panelTitleNhap);
		panelTitleNhap.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HÓA ĐƠN BÁN HÀNG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 0, 767, 61);
		panelTitleNhap.add(lblNewLabel);
		
		JPanel panelTitleBan = new JPanel();
		panelTitleBan.setBounds(767, 0, 767, 61);
		panelTitleBan.setBackground(new Color(153, 102, 0));
		panelTitle.add(panelTitleBan);
		panelTitleBan.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("HÓA ĐƠN NHẬP HÀNG");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 767, 61);
		panelTitleBan.add(lblNewLabel_1);
		
		JPanel panelCtn = new JPanel();
		panelCtn.setBounds(0, 61, 1534, 956);
		panelCtn.add(new panelBanHang());
		add(panelCtn);
		panelCtn.setLayout(null);
	}
}
