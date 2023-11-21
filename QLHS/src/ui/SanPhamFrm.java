package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_SanPham;
import entity.SanPham;
import list.DanhSachSanPham;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class SanPhamFrm extends JDialog {

	public final JPanel contentPanel = new JPanel();
	public JTextField txtAhihi;
	public PanelKhuyenMai khuyenMai;
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	private DanhSachSanPham listsp;
	private DAO_SanPham daosp;
	private SanPham spReturn;
	private JTextField txtMasp;
	private JComboBox comboBox;
	private JTextField txtKeyText;
	

	public static void main(String[] args) {
		try {
			SanPhamFrm dialog = new SanPhamFrm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	
	public SanPhamFrm(PanelKhuyenMai khuyenMai) {
		daosp = new DAO_SanPham();
		listsp = new DanhSachSanPham();
		spReturn = new SanPham();
		row = new Object[9];
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		listsp = daosp.getAll();
		
		this.khuyenMai = khuyenMai;
		setBounds(100, 100, 711, 735);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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

	public PanelKhuyenMai getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(PanelKhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public SanPhamFrm() {
		new SanPhamFrm(khuyenMai);
		spReturn = new SanPham();
		setBounds(100, 100, 700, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 38, 684, 590);
			contentPanel.add(scrollPane);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int i = table.getSelectedRow();
					
					spReturn.setMaSP(model.getValueAt(i,0).toString());
					System.out.println("Selected!!");
					txtMasp.setText(model.getValueAt(i, 0).toString());
					
				}
			});
			String[] column = {"Mã Sách","Tên Sách","Tên Tác Giả","Danh Mục","Nhà XB","năm XB","Số Lượng","Đơn Giá","Tình Trạng"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(column);
			table.setModel(model);
			refresh();
			
			scrollPane.setViewportView(table);
		
		
			
			
		
		}
		
		JLabel lblNewLabel_1 = new JLabel("Tìm Sản Phẩm Theo");
		lblNewLabel_1.setBounds(0, 0, 117, 38);
		contentPanel.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(101, 0, 154, 38);
		comboBox.addItem("Tiêu Chí Lọc");
		comboBox.addItem("Theo Tên Sách");
		comboBox.addItem("Theo Tác Giả");
		comboBox.addItem("Theo Danh Mục");
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(!txtKeyText.getText().equalsIgnoreCase("")) {
					String index = comboBox.getSelectedItem().toString();
					if(index.equalsIgnoreCase("Theo Tác Giả")) {
						ArrayList<SanPham>listSPTemp = listsp.timSPTheoTacGia(txtKeyText.getText());
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						for (SanPham sp : listSPTemp) {
							row[0] = sp.getMaSP();
							row[1] = sp.getTenSP();
							row[2] = sp.getTenTG();
							row[3] = sp.getDanhMuc();
							row[4] = sp.getNhaXB();
							row[5] = sp.getNamXB();
							row[6] = sp.getSoLuong();
							row[7] = sp.getDonGiaMua();
							row[8] = sp.getTinhTrang();
//							row[9] = 
							model.addRow(row);
						}
					}else if(index.equalsIgnoreCase("Theo Danh Mục")) {
						ArrayList<SanPham>listSPTemp = listsp.timSPTheoDanhMuc(txtKeyText.getText());
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						for (SanPham sp : listSPTemp) {
							row[0] = sp.getMaSP();
							row[1] = sp.getTenSP();
							row[2] = sp.getTenTG();
							row[3] = sp.getDanhMuc();
							row[4] = sp.getNhaXB();
							row[5] = sp.getNamXB();
							row[6] = sp.getSoLuong();
							row[7] = sp.getDonGiaMua();
							row[8] = sp.getTinhTrang();
//							row[9] = 
							model.addRow(row);
						}
					}else if(index.equalsIgnoreCase("Theo Tên Sách")){
						ArrayList<SanPham>listSPTemp = listsp.timSPTheoTenSach(txtKeyText.getText());
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						for (SanPham sp : listSPTemp) {
							row[0] = sp.getMaSP();
							row[1] = sp.getTenSP();
							row[2] = sp.getTenTG();
							row[3] = sp.getDanhMuc();
							row[4] = sp.getNhaXB();
							row[5] = sp.getNamXB();
							row[6] = sp.getSoLuong();
							row[7] = sp.getDonGiaMua();
							row[8] = sp.getTinhTrang();
//							row[9] = 
							model.addRow(row);
						}
					}else {
						refresh();
					}
				}else {
					refresh();
				}
			}
		});
				
		contentPanel.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập từ khóa");
		lblNewLabel_2.setBounds(366, 0, 94, 38);
		contentPanel.add(lblNewLabel_2);
		
		txtKeyText = new JTextField();
		txtKeyText.setBounds(458, 0, 154, 38);
		contentPanel.add(txtKeyText);
		txtKeyText.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Chọn");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onSubmitButtonClick();
						
						
					}
				});
				
				JButton btnNewButton = new JButton("Làm Mới");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						refresh();
					}
				});
				buttonPane.add(btnNewButton);
				{
					JLabel lblNewLabel = new JLabel("Mã Sản Phẩm");
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
					buttonPane.add(lblNewLabel);
				}
				{
					txtMasp = new JTextField();
					txtMasp.setFont(new Font("Tahoma", Font.BOLD, 13));
					buttonPane.add(txtMasp);
					txtMasp.setColumns(10);
				}
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
	 private void onSubmitButtonClick() {
	        
	        this.khuyenMai.onDataReturned(txtMasp.getText());
	        dispose();
	    }
	 private void refresh() {
		 daosp = new DAO_SanPham();
		 listsp = daosp.getAll();
		 row = new Object[9];
		 DefaultTableModel model = (DefaultTableModel) table.getModel();
		 model.setRowCount(0);
		 for (SanPham sp : listsp.getList()) {
			 row[0] = sp.getMaSP();
				row[1] = sp.getTenSP();
				row[2] = sp.getTenTG();
				row[3] = sp.getDanhMuc();
				row[4] = sp.getNhaXB();
				row[5] = sp.getNamXB();
				row[6] = sp.getSoLuong();
				row[7] = sp.getDonGiaMua();
				row[8] = sp.getTinhTrang();
//				row[9] = 
				model.addRow(row);
		}
	 }
}
