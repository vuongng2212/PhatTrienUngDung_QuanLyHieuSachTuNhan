package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_KhuyenMai;
import entity.ChiTietKhuyenMai;
import list.DanhSachKhuyenMai;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogShowKhuyenMai extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public String textReturn;
	private JTable table;
	private Object[] row;
	private DAO_KhuyenMai daoKm;
	private DanhSachKhuyenMai listKm;
	private DefaultTableModel model;
	private ArrayList<ChiTietKhuyenMai>listCT;
	private JTextField txtMaKM;
	

	
	
	public DialogShowKhuyenMai(String textReturn) {
		new DialogShowKhuyenMai();
		
		this.textReturn = textReturn;
	}

	public String getTextReturn() {
		return textReturn;
	}

	public void setTextReturn(String textReturn) {
		this.textReturn = textReturn;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogShowKhuyenMai dialog = new DialogShowKhuyenMai();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	
	
	public DialogShowKhuyenMai() {
		model = new DefaultTableModel();
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		listCT = new ArrayList<ChiTietKhuyenMai>();
		
		daoKm = new DAO_KhuyenMai();
		listKm = new DanhSachKhuyenMai();
		listKm = daoKm.getAll();
		listCT = daoKm.getChiTiet();
		
		setBounds(100, 100, 687, 736);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 54, 671, 610);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				String[] column = {"Mã Sản Phẩm","Tên Sản Phẩm","Tên Tác Giả","Discount"};
				row = new Object[4];
				model.setColumnIdentifiers(column);
				table.setModel(model);
				
				
				
				scrollPane.setViewportView(table);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("Mã Khuyến Mãi");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(10, 0, 122, 53);
			contentPanel.add(lblNewLabel);
		}
		
		txtMaKM = new JTextField();
		txtMaKM.setText(textReturn);
		txtMaKM.setBounds(142, 3, 156, 40);
		txtMaKM.setEditable(false);
		txtMaKM.setText(textReturn);
		contentPanel.add(txtMaKM);
		
		txtMaKM.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		for (ChiTietKhuyenMai km : listCT) {
			row[0] = km.getmaSP();
			row[1] = km.getTenSP();
			row[2] = km.getTenTG();
			row[3] = km.getDiscount();
			model.addRow(row);
		}
	}
	public void run(String str) {
//		ArrayList<chitiet>
		txtMaKM.setText(str);
		daoKm = new DAO_KhuyenMai();
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		listCT = daoKm.getChiTietConditions(str);
		for(ChiTietKhuyenMai km : listCT) {
			row[0] = km.getmaSP();
			row[1] = km.getTenSP();
			row[2] = km.getTenTG();
			row[3] = km.getDiscount();
			model.addRow(row);
		}
		
	}
}
