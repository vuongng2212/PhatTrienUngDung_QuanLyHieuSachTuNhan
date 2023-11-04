package ui;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class PanelCustomer extends JPanel {
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private TableCustom tableCustom = new TableCustom();
	private JTable table;
	private Image img_title = new ImageIcon(frmNV.class.getResource("/image/search.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	private Image img_reload = new ImageIcon(frmNV.class.getResource("/image/reload.png")).getImage().getScaledInstance(30, 30,Image.SCALE_SMOOTH );
	public PanelCRUDKHang crudkHang;
	private JTable table_1;
	DefaultTableModel model;
	
	public PanelCustomer() {
		this.setVisible(false);
		setBounds(0,0,1534,1017);
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(255, 165, 0));
		panelTitle.setBounds(0, 0, 1534, 58);
		add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lbllTItle = new JLabel("Tìm Kiếm Khách Hàng");
		lbllTItle.setForeground(new Color(0, 255, 0));
		lbllTItle.setHorizontalAlignment(SwingConstants.CENTER);
		lbllTItle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lbllTItle.setBounds(0, 0, 1534, 58);
		panelTitle.add(lbllTItle);
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(new Color(255, 165, 0));
		panelContent.setBounds(0, 57, 1534, 960);
		add(panelContent);
		panelContent.setLayout(null);
		
		JPanel panelTimKiem = new JPanel();
		panelTimKiem.setBackground(new Color(100, 149, 237));
		panelTimKiem.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panelTimKiem.setBounds(10, 44, 1514, 222);
		panelContent.add(panelTimKiem);
		panelTimKiem.setLayout(null);
		
		JLabel lbllMaKH = new JLabel("Mã Khách Hàng");
		lbllMaKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllMaKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllMaKH.setBounds(494, 24, 125, 41);
		panelTimKiem.add(lbllMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(629, 26, 239, 41);
		panelTimKiem.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lbllTenKH = new JLabel("Tên  Khách Hàng");
		lbllTenKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllTenKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllTenKH.setBounds(494, 76, 125, 41);
		panelTimKiem.add(lbllTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(629, 78, 239, 41);
		panelTimKiem.add(txtTenKH);
		
		JLabel lbllSDTKH = new JLabel("Số Điện Thoại");
		lbllSDTKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllSDTKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllSDTKH.setBounds(494, 128, 125, 41);
		panelTimKiem.add(lbllSDTKH);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(629, 130, 239, 41);
		panelTimKiem.add(txtSDT);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm Khách Hàng");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnTimKiem.setBackground(new Color(0, 255, 255));
		btnTimKiem.setIcon(new ImageIcon(img_title));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTimKiem.setBounds(960, 45, 239, 41);
		panelTimKiem.add(btnTimKiem);
		
		JButton btnCapNhat = new JButton("Cập Nhật Khách Hàng");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				crudkHang.setVisible(true);
			}
		});
		btnCapNhat.setForeground(new Color(255, 255, 255));
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCapNhat.setBackground(new Color(75, 0, 130));
		btnCapNhat.setBounds(960, 113, 239, 41);
		btnCapNhat.setIcon(new ImageIcon(img_reload));
		panelTimKiem.add(btnCapNhat);
		
		JLabel lbllTimKiem = new JLabel("Tìm Kiếm Khách Hàng");
		lbllTimKiem.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbllTimKiem.setForeground(new Color(165, 42, 42));
		lbllTimKiem.setBounds(10, 0, 194, 40);
		panelContent.add(lbllTimKiem);
		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(new Color(255, 165, 0));
		panelTable.setBounds(0, 307, 1534, 627);
		panelTable.setLayout(null);
		tableCustom.setBounds(1532, 373, -1533, -368);
		DefaultTableModel mode = (DefaultTableModel) tableCustom.getModel();		
		panelContent.add(panelTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 1514, 627);
		panelTable.add(scrollPane);
		
		table_1 = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Mã Khách Hàng","Tên Khách Hàng","Số Điện Thoại","Địa Chỉ","Loại Khách Hàng"};
		Object[] row = new Object[5];
		model.setColumnIdentifiers(column);
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);
		table_1.setBackground(SystemColor.activeCaptionBorder);
		
		
		

	}
}
