package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_KhachHang;
import entity.KhachHang;
import list.DanhSachKhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogAddKHSearchHD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTuKhoa;
	private JTextField txtMaKH;
	private JTable table;
//	private Defauttablemodel model;
	private DAO_KhachHang daoKh;
	private DanhSachKhachHang listKH;
	private DefaultTableModel model;
	private Object[] row;
//	public panelBanHang banHang;
//	public PanelKhXacNhanDatSach datSach;
	public PanelSearchHD searchHd;
	private KhachHang khTemp;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogAddKH dialog = new DialogAddKH();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public DialogAddKHSearchHD(PanelSearchHD searchHd) {
		new DialogAddKH();
		khTemp = new KhachHang();
		daoKh = new DAO_KhachHang();
		listKH = new DanhSachKhachHang();
		row = new Object[5];
		
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		listKH = daoKh.getAll();
		this.searchHd = searchHd;
	}
	
	
	
	public DialogAddKHSearchHD() {
		setBounds(100, 100, 919, 746);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Lọc Theo Tiêu Chí");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(10, 0, 123, 34);
			contentPanel.add(lblNewLabel);
		}
		
		comboBox = new JComboBox();
		comboBox.setBounds(132, 0, 137, 34);
		comboBox.addItem("Tiêu Chí Lọc");
		comboBox.addItem("Tên Khách Hàng");
		comboBox.addItem("Số Điện Thoại");
		comboBox.addItem("Loại Khách Hàng");
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				refreshHaveConditions();
			}
		});
		
		contentPanel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập Từ Khóa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(297, 0, 97, 34);
		contentPanel.add(lblNewLabel_1);
		
		txtTuKhoa = new JTextField();
		txtTuKhoa.setBounds(396, 0, 123, 34);
		contentPanel.add(txtTuKhoa);
		txtTuKhoa.setColumns(10);
		
		JButton btnNewButton = new JButton("Lọc");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshHaveConditions();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(529, 0, 97, 34);
		contentPanel.add(btnNewButton);
		
		JButton btnLmMi = new JButton("Làm Mới");
		btnLmMi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLmMi.setBounds(656, 0, 97, 34);
		contentPanel.add(btnLmMi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 45, 903, 629);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				khTemp = new KhachHang();
				txtMaKH.setText(model.getValueAt(i,0).toString());
				System.out.println(i);
				khTemp.setMaKH(model.getValueAt(i, 0).toString());
				khTemp.setTenKH(model.getValueAt(i, 1).toString());
				khTemp.setSdt(model.getValueAt(i, 2).toString());
				khTemp.setDiaChi(model.getValueAt(i, 3).toString());
				khTemp.setLoaiKH(model.getValueAt(i, 4).toString());
				
			}
		});
		
		model = new DefaultTableModel();
		String[] column = {"Mã Khách Hàng","Tên Khách Hàng","Số Điện Thoại","Địa Chỉ","Loại Khách Hàng"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JLabel lblNewLabel_2 = new JLabel("Mã Khách Hàng");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonPane.add(lblNewLabel_2);
			
			txtMaKH = new JTextField();
			buttonPane.add(txtMaKH);
			txtMaKH.setEditable(false);
			txtMaKH.setColumns(10);
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
		refresh();
	}
	public void refresh() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		daoKh = new DAO_KhachHang();
		listKH = new DanhSachKhachHang();
		listKH = daoKh.getAll();
		row = new Object[5];
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		
		for (KhachHang kh : listKH.getList()) {
			row[0] = kh.getMaKH();
			row[1] = kh.getTenKH();
			row[2] = kh.getSdt();
			row[3] = kh.getDiaChi();
			row[4] = kh.getLoaiKH();
			model.addRow(row);
		}
	}
	private void refreshHaveConditions() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		daoKh = new DAO_KhachHang();
		listKH = new DanhSachKhachHang();
		listKH = daoKh.getAll();
		if(!txtTuKhoa.getText().equalsIgnoreCase("")) {
			String index = comboBox.getSelectedItem().toString();
			System.out.println(index);
			if(index.equalsIgnoreCase("Tên Khách Hàng")) {
				ArrayList<KhachHang>listKHTemp = listKH.timKHTheoTen(txtTuKhoa.getText());
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				for (KhachHang kh : listKHTemp) {
					row[0] = kh.getMaKH();
					row[1] = kh.getTenKH();
					row[2] = kh.getSdt();
					row[3] = kh.getDiaChi();
					row[4] = kh.getLoaiKH();
					model.addRow(row);
					}
			}else if(index.equalsIgnoreCase("Số Điện Thoại")) {
				int i = listKH.timKHTheoSDT(txtTuKhoa.getText());
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				
					if(i>=0) {
						row[0] = listKH.getList().get(i).getMaKH();
						row[1] = listKH.getList().get(i).getTenKH();
						row[2] = listKH.getList().get(i).getSdt();
						row[3] = listKH.getList().get(i).getDiaChi();
						row[4] = listKH.getList().get(i).getLoaiKH();
						model.addRow(row);
					}
			}else if(index.equalsIgnoreCase("Loại Khách Hàng")) {
				ArrayList<KhachHang>listKHTemp = listKH.dsKhTheoLoai(txtTuKhoa.getText());
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				for (KhachHang kh : listKHTemp) {
					row[0] = kh.getMaKH();
					row[1] = kh.getTenKH();
					row[2] = kh.getSdt();
					row[3] = kh.getDiaChi();
					row[4] = kh.getLoaiKH();
					model.addRow(row);
					}
			}else {
				refresh();
			}
		}else {
			refresh();
		}
	}
	
	


	public PanelSearchHD getSearchHd() {
		return searchHd;
	}

	public void setSearchHd(PanelSearchHD searchHd) {
		this.searchHd = searchHd;
	}

	private void onSubmitButtonClick() {
		if(!txtMaKH.getText().equalsIgnoreCase("")) {
			model = (DefaultTableModel) table.getModel();
			int i = table.getSelectedRow();
		
          this.searchHd.onDataReturnedKH(txtMaKH.getText());

		dispose();
		}else {
			JOptionPane.showMessageDialog(null,"Bạn chưa chọn!!");
		}
    }
	
}
