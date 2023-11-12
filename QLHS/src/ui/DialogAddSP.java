package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_KhuyenMai;
import dao.DAO_SanPham;
import entity.SanPham;
import list.DanhSachKhuyenMai;
import list.DanhSachSanPham;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogAddSP extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtMaSP;

	private DanhSachSanPham listSP;
	private DAO_SanPham daoSP;
	
	private DanhSachKhuyenMai listKM;
	private DAO_KhuyenMai daoKm;
	
	private Object[] row;
	private DefaultTableModel model;
	private JTextField txtTuKhoa;
	private JComboBox comboBox;
	
	public panelBanHang banHang;
	private int soLuongReturn;
	private double giaBan;
	private String tenSach;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogAddSP dialog = new DialogAddSP();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public DialogAddSP(panelBanHang banHang) {
		new DialogAddSP();
		daoSP = new DAO_SanPham();
		listSP = new DanhSachSanPham();
		row = new Object[9];
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		listSP = daoSP.getAll();
		this.banHang = banHang;
		
	}
	
	
	public DialogAddSP() {
		
		daoSP = new DAO_SanPham();
		listSP = new DanhSachSanPham();
		row = new Object[9];
		
		soLuongReturn = 0;
		setBounds(100, 100, 1006, 747);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lọc Theo Tiêu Chí");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 0, 140, 34);
		contentPanel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(140, 2, 135, 33);
		comboBox.addItem("Tiêu Chí Lọc");
		comboBox.addItem("Theo Tên Sách");
		comboBox.addItem("Theo Tác Giả");
		comboBox.addItem("Theo Danh Mục");
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				refreshHaveConditions();
			}
		});
		contentPanel.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//			}
//		});
		scrollPane.setBounds(0, 45, 990, 630);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				txtMaSP.setText(model.getValueAt(i, 0).toString());
				
				soLuongReturn = Integer.parseInt(model.getValueAt(i, 6).toString());
				tenSach = model.getValueAt(i, 1).toString();
				giaBan = Double.parseDouble(model.getValueAt(i, 8).toString());
				System.out.println(i);
			}
		});
		model = new DefaultTableModel();
		String[] column = {"Mã Sản Phẩm","Tên Sản Phẩm","Tên Tác Giả","Danh Mục","Nhà Xuất Bản","Năm Xuất Bản","Số Lượng","Đơn Giá Gốc","Đơn Giá Mua"};
		
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
		refresh();
		
		JLabel lblNhpTKha = new JLabel("Nhập Từ Khóa");
		lblNhpTKha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNhpTKha.setBounds(314, 0, 111, 34);
		contentPanel.add(lblNhpTKha);
		
		txtTuKhoa = new JTextField();
		txtTuKhoa.setBounds(434, 1, 140, 34);
		contentPanel.add(txtTuKhoa);
		txtTuKhoa.setColumns(10);
		
		JButton btnLoc = new JButton("Lọc");
		btnLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedValue =(String) comboBox.getSelectedItem();
				refreshHaveConditions();
				
			}
		});
		btnLoc.setBounds(715, 1, 102, 34);
		contentPanel.add(btnLoc);
		
		JButton btnNewButton = new JButton("Làm Mới");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btnNewButton.setBounds(827, 1, 96, 34);
		contentPanel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JLabel lblNewLabel_1 = new JLabel("Mã Sản Phẩm");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonPane.add(lblNewLabel_1);
			
			txtMaSP = new JTextField();
			buttonPane.add(txtMaSP);
			txtMaSP.setEditable(false);
			txtMaSP.setColumns(10);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onSubmitButtonClick();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}


	public panelBanHang getBanHang() {
		return banHang;
	}

	public void setBanHang(panelBanHang banHang) {
		this.banHang = banHang;
	}

	private void refresh() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		daoSP = new DAO_SanPham();
		listSP = new DanhSachSanPham();
		listSP = daoSP.getAll();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		for (SanPham sp : listSP.getList()) {
			row[0] = sp.getMaSP();
			row[1] = sp.getTenSP();
			row[2] = sp.getTenTG();
			row[3] = sp.getDanhMuc();
			row[4] = sp.getNhaXB();
			row[5] = sp.getNamXB();
			row[6] = sp.getSoLuong();
			row[7] = sp.getDonGiaGoc();
			row[8] = sp.getDonGiaMua();
			model.addRow(row);
		}
	}
	private void refreshHaveConditions() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		daoSP = new DAO_SanPham();
		listSP = new DanhSachSanPham();
		listSP = daoSP.getAll();
//		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		if(!txtTuKhoa.getText().equalsIgnoreCase("")) {
			String index = comboBox.getSelectedItem().toString();
			System.out.println(index);
			if(index.equalsIgnoreCase("Theo Tác Giả")) {
				ArrayList<SanPham>listSPTemp = listSP.timSPTheoTacGia(txtTuKhoa.getText());
				DefaultTableModel model =(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				for (SanPham sp : listSPTemp) {
					row[0] = sp.getMaSP();
					row[1] = sp.getTenSP();
					row[2] = sp.getTenTG();
					row[3] = sp.getDanhMuc();
					row[4] = sp.getNhaXB();
					row[5] = sp.getNamXB();
					row[6] = sp.getSoLuong();
					row[7] = sp.getDonGiaGoc();
					row[8] = sp.getDonGiaMua();
//					row[9] = 
					model.addRow(row);
				}
			}else if(index.equalsIgnoreCase("Theo Danh Mục")) {
				ArrayList<SanPham>listSPTemp = listSP.timSPTheoTacGia(txtTuKhoa.getText());
				DefaultTableModel model =(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				for (SanPham sp : listSPTemp) {
					row[0] = sp.getMaSP();
					row[1] = sp.getTenSP();
					row[2] = sp.getTenTG();
					row[3] = sp.getDanhMuc();
					row[4] = sp.getNhaXB();
					row[5] = sp.getNamXB();
					row[6] = sp.getSoLuong();
					row[7] = sp.getDonGiaGoc();
					row[8] = sp.getDonGiaMua();
//					row[9] = 
					model.addRow(row);
				}
			}else if(index.equalsIgnoreCase("Theo Tên Sách")) {
				ArrayList<SanPham>listSPTemp = listSP.timSPTheoTenSach(txtTuKhoa.getText());
				DefaultTableModel model =(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				for (SanPham sp : listSPTemp) {
					row[0] = sp.getMaSP();
					row[1] = sp.getTenSP();
					row[2] = sp.getTenTG();
					row[3] = sp.getDanhMuc();
					row[4] = sp.getNhaXB();
					row[5] = sp.getNamXB();
					row[6] = sp.getSoLuong();
					row[7] = sp.getDonGiaGoc();
					row[8] = sp.getDonGiaMua();
//					row[9] = 
					model.addRow(row);
				}
			}else {
				refresh();
			}
		}else {
			refresh();
		}
	}
	 private void onSubmitButtonClick() {
	        
	        this.banHang.onDataReturned(txtMaSP.getText());
	        this.banHang.soLuongSPTemp = soLuongReturn;
	        this.banHang.tenSach = tenSach;
	        this.banHang.giaBan = giaBan;
	        System.out.println(giaBan);
	        System.out.println(tenSach);
//	        this.
	        dispose();
	    }
}

