package ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_HoaDon;
import entity.HoaDon;
import list.DanhSachHoaDon;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSearchHD extends JPanel {
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	private DAO_HoaDon daohd;
	private DanhSachHoaDon listHD;
	private HoaDon hd;
	public DialogXemHD xemHd;
	/**
	 * Create the panel.
	 */
	public PanelSearchHD() {
		setBounds(0,0,1534,1017);
		setLayout(null);
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		xemHd = new DialogXemHD(this);
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1534, 78);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm Hóa Đơn");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 0, 1534, 78);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(0, 102, 1534, 153);
		add(panel_1);
		panel_1.setLayout(null);
		
		JDateChooser batdau = new JDateChooser();
		batdau.setDateFormatString("dd-MM-yyyy");
		batdau.setBounds(186, 22, 178, 35);
		panel_1.add(batdau);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày Tạo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(66, 22, 85, 35);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Tìm Kiếm");
		btnNewButton.setBounds(220, 96, 197, 46);
		panel_1.add(btnNewButton);
		
		JButton btnLmMi = new JButton("Làm Mới");
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refresh();
			}
		});
		btnLmMi.setBounds(624, 96, 197, 46);
		panel_1.add(btnLmMi);
		
		JButton btnXemChiTit = new JButton("Xem Chi Tiết");
		btnXemChiTit.setEnabled(false);
		btnXemChiTit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				onOpenFrmButtonClick();
			}
		});
		btnXemChiTit.setBounds(991, 96, 220, 46);
		panel_1.add(btnXemChiTit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 254, 1534, 763);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					btnXemChiTit.setEnabled(true);
				}
			}
		});
		model = new DefaultTableModel();
		String[] column = {"Mã Hóa Đơn","Mã Nhân Viên","Mã Khách Hàng","Ngày Tạo Hóa Đơn","Thành Tiền"};
		row = new Object[5];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		refresh();
	}
	public void refresh() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		daohd  = new DAO_HoaDon();
		listHD = new DanhSachHoaDon();
		listHD = daohd.getAll();
		row = new Object[5];
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		model =(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (HoaDon hd : listHD.getList()) {
			row[0] = hd.getMaHD();
			row[1] = hd.getMaNV();
			row[2] = hd.getMaKH();
			row[3] = dateformat.format(hd.getNgayTaoHD());
			row[4] = hd.getThanhTien();
			model.addRow(row);
		}
	}
	private void onOpenFrmButtonClick() {
		model =(DefaultTableModel) table.getModel();
		int i = table.getSelectedRow();
		
		xemHd.searchHd = this;
		xemHd.txtMaHD.setText(model.getValueAt(i,0).toString());
		xemHd.refresh();
		xemHd.setModal(true);
		xemHd.setVisible(true);
		
	}
	
}
