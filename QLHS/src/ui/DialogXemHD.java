package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_ChiTietHoaDon;
import entity.ChiTietHoaDon;
import list.DanhSachChiTietHoaDon;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogXemHD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public JTextField txtMaHD;
	private DefaultTableModel model;
	private Object[] row;
	public PanelSearchHD searchHd;
	private DAO_ChiTietHoaDon daoCTHD;
	private DanhSachChiTietHoaDon listCTHD;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogXemHD dialog = new DialogXemHD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	


	public DialogXemHD(PanelSearchHD searchHd) {
		new DialogXemHD();
		this.searchHd = searchHd;
	}



	/**
	 * Create the dialog.
	 */
	public DialogXemHD() {
		setBounds(100, 100, 628, 771);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		model = new DefaultTableModel();
		row = new Object[5];
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 48, 602, 651);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				model = (DefaultTableModel) table.getModel();
				String[] column = {"Mã Sản Phẩm","Số Lượng","Đơn Giá","Discount"};
				model.setColumnIdentifiers(column);
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("Thông Tin Chi Tiết ");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(10, 0, 132, 41);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Mã Hóa Đơn");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_1.setBounds(378, 7, 103, 34);
			contentPanel.add(lblNewLabel_1);
		}
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(491, 11, 96, 34);
		contentPanel.add(txtMaHD);
		txtMaHD.setColumns(10);
		txtMaHD.setEditable(false);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
//		refresh();
	}
	public void refresh() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		daoCTHD = new DAO_ChiTietHoaDon();
		listCTHD = new DanhSachChiTietHoaDon();
		
		ArrayList<ChiTietHoaDon>listCT = new ArrayList<ChiTietHoaDon>();
		listCT = daoCTHD.timCTHDtheoMa(txtMaHD.getText());
		model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		row = new Object[4];
		for (ChiTietHoaDon ct : listCT) {
			row[0] = ct.getMaSP();
			row[1] = ct.getSoLuong();
			row[2] = ct.getDonGia();
			System.out.println(ct.getDiscount());
			row[3] = ct.getDiscount();
			model.addRow(row);
		}
		
	}
}
