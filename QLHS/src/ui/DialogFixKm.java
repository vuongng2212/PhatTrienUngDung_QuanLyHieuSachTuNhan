package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.DAO_KhuyenMai;
import dao.DAO_SanPham;
import entity.KhuyenMai;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;

public class DialogFixKm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMaKm;
	private JTable table;
	private Object[] row;
	private DefaultTableModel model;
	private JTextField txtMaSP;
	private JTextField txtDiscount;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private DAO_KhuyenMai daoKm;
	private DAO_SanPham daoSp;
	public DialogAddSP4 dialoSp;
	private JDateChooser batDau;
	private JDateChooser ketThuc;
	public DialogShowKhuyenMai dialogShowKhuyenMai;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogFixKm dialog = new DialogFixKm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DialogShowKhuyenMai getDialogShowKhuyenMai() {
		return dialogShowKhuyenMai;
	}

	public void setDialogShowKhuyenMai(DialogShowKhuyenMai dialogShowKhuyenMai) {
		this.dialogShowKhuyenMai = dialogShowKhuyenMai;
	}

	/**
	 * Create the dialog.
	 */
	public DialogFixKm() {
		dialoSp = new DialogAddSP4();
		daoKm = new DAO_KhuyenMai();
		daoSp = new DAO_SanPham();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		setBounds(100, 100, 892, 762);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbllMaKm = new JLabel("Mã Khuyến Mãi");
		lbllMaKm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllMaKm.setBounds(10, 11, 116, 35);
		contentPanel.add(lbllMaKm);
		
		txtMaKm = new JTextField();
		txtMaKm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaKm.setBounds(137, 11, 101, 35);
		contentPanel.add(txtMaKm);
		txtMaKm.setColumns(10);
		txtMaKm.setEditable(false);
		{
			JLabel lblNewLabel = new JLabel("Danh Sách Các Sản Phẩm");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(10, 57, 162, 35);
			contentPanel.add(lblNewLabel);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 856, 456);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refresh();
				int i = table.getSelectedRow();
				model = (DefaultTableModel) table.getModel();
				txtMaSP.setText(model.getValueAt(i, 0).toString());
				txtDiscount.setText(model.getValueAt(i, 4).toString());
				
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
			}
		});
		model = new DefaultTableModel();
		String[] colummn = {"Mã Sản Phẩm","Tên Sản Phẩm","Tên Tác Giả","Số Lượng Trong Kho","Mức Giảm(%)"};
		row = new Object[5];
		model.setColumnIdentifiers(colummn);
		table.setModel(model);
		
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Thêm Sản Phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 570, 101, 28);
		contentPanel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Chọn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOpenFormButtonClick();
				btnThem.setEnabled(true);
			}
		});
		btnNewButton.setBounds(118, 574, 78, 23);
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(329, 570, 94, 28);
		contentPanel.add(lblNewLabel_1_1);
		
		txtMaSP = new JTextField();
		txtMaSP.setBounds(443, 571, 94, 28);
		contentPanel.add(txtMaSP);
		txtMaSP.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Discount");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(643, 570, 78, 28);
		contentPanel.add(lblNewLabel_2);
		
		txtDiscount = new JTextField();
		txtDiscount.setBounds(731, 570, 101, 28);
		contentPanel.add(txtDiscount);
		txtDiscount.setColumns(10);
		
		btnThem = new JButton("Thêm");
		btnThem.setEnabled(false);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtMaSP.getText().equalsIgnoreCase("")) {
					if(Integer.parseInt(txtDiscount.getText())>=5) {
						model = (DefaultTableModel) table.getModel();
						row = new Object[5];
						row[0]= txtMaSP.getText();
						row[1]= daoSp.searchTenSP(txtMaSP.getText());
						row[2]= daoSp.searchTenTacGia(txtMaSP.getText());
						row[3]= daoSp.searchSoLuong(txtMaSP.getText());
						row[4]=txtDiscount.getText();
						model.addRow(row);
						JOptionPane.showMessageDialog(null, "Thêm thành công!!");
						btnThem.setEnabled(false);
						txtDiscount.setText("");
						txtMaSP.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Discount phải lớn hơn 5!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm trước khi thêm!!");
				}
			}
		});
		btnThem.setBounds(161, 622, 89, 29);
		contentPanel.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(txtDiscount.getText())>=5) {
					model = (DefaultTableModel) table.getModel();
					int i = table.getSelectedRow();
					model.setValueAt(txtDiscount.getText(), i, 4);
					JOptionPane.showMessageDialog(null, "Thay đổi thành công!!");
					refresh();
				}else {
					JOptionPane.showMessageDialog(null, "Discount phải lớn hơn hoặc bằng 5");
				}
			}
		});
		btnSua.setEnabled(false);
		btnSua.setBounds(380, 619, 101, 35);
		contentPanel.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setEnabled(false);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setBounds(603, 622, 94, 32);
		contentPanel.add(btnXoa);
		
		JLabel lbllNgayBatDau = new JLabel("Ngày Bắt Đầu");
		lbllNgayBatDau.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllNgayBatDau.setBounds(252, 11, 116, 35);
		contentPanel.add(lbllNgayBatDau);
		
		batDau = new JDateChooser();
//		batDau.setda
		batDau.setDateFormatString("dd-MM-yyyy");
		batDau.setBounds(370, 11, 178, 35);
		contentPanel.add(batDau);
		
		ketThuc = new JDateChooser();
		ketThuc.setDateFormatString("dd-MM-yyyy");
		ketThuc.setBounds(688, 11, 178, 35);
		contentPanel.add(ketThuc);
		
		JLabel lblNgyKtThc = new JLabel("Ngày Kết Thúc");
		lblNgyKtThc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgyKtThc.setBounds(562, 11, 116, 35);
		contentPanel.add(lblNgyKtThc);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Xác Nhận Thay  Đổi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 Date currentDate = new Date(System.currentTimeMillis());
						 SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
						 long currenMill = currentDate.getTime();
						 long batdauMill = batDau.getDate().getTime();
						 long kethucMill = ketThuc.getDate().getTime();
						 long days = TimeUnit.MILLISECONDS.toDays((batdauMill - currenMill));
						 long days2 = TimeUnit.MILLISECONDS.toDays((batdauMill - kethucMill));
						 
						 if(days<7) {
							 JOptionPane.showMessageDialog(null, "Ngày bắt đầu chương trình khuyến mãi phải cách 7 ngày so với ngày tạo");
								
						 }else if(days2 >0){
							 JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải lớn hơn ngày kết thúc!");
						 }else {

						int option = JOptionPane.showOptionDialog(null, "Bạn chắc chắn với sự thay đổi của mình", "Xác nhận", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
						switch (option) {
						case JOptionPane.YES_OPTION:
							daoKm = new DAO_KhuyenMai();
							daoKm.delete(txtMaKm.getText());
							
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							Date dateBatDau = batDau.getDate();
							Date dateKetThuc = ketThuc.getDate();
							if(dateBatDau.before(dateKetThuc)) {
								JOptionPane.showMessageDialog(null, "Thanh cong");
								int rowCount = table.getRowCount();
								model = (DefaultTableModel) table.getModel();
								for(int i=0;i<rowCount;i++) {
									KhuyenMai km = new KhuyenMai();
									km.setMaKM(txtMaKm.getText());
									km.setDiscount(Integer.parseInt(model.getValueAt(i, 4).toString()));
									km.setNgayTao(dateBatDau);
									km.setNgayHetHan(dateKetThuc);
									km.setMaSP(model.getValueAt(i, 0).toString());
									daoKm.add(km);
								}
								JOptionPane.showMessageDialog(null,"Thành Công");
//								dialogShowKhuyenMai = new DialogShowKhuyenMai();
								dialogShowKhuyenMai.setTextReturn(txtMaKm.getText());
//								dialogShowKhuyenMai.
								dialogShowKhuyenMai.run(txtMaKm.getText());
								setVisible(false);
								setModal(false);
								dialogShowKhuyenMai.timKhuyenMai.refresh();
							}else {
								JOptionPane.showMessageDialog(null, "That bai!!");
							}
							
							
							break;

						default:
							break;
							}
						 }
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Hủy Bỏ");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setModal(false);
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
//		refreshWhereOpen("KM001");
	}
	public void refreshWhereOpen(String str) {
		txtMaKm.setText(str);
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		ArrayList<KhuyenMai>list = new ArrayList<KhuyenMai>();
		daoKm = new DAO_KhuyenMai();
		daoSp = new DAO_SanPham();
		row = new Object[5];
		list = daoKm.listKmKhiBietMa(str);
		batDau.setDate(list.get(0).getNgayTao());
		ketThuc.setDate(list.get(0).getNgayHetHan());
		for (KhuyenMai km : list) {
			row[0]= km.getMaSP();
			row[1]= daoSp.searchTenSP(km.getMaSP());
			row[2]= daoSp.searchTenTacGia(km.getMaSP());
			row[3]= daoSp.searchSoLuong(km.getMaSP());
			row[4]=km.getDiscount();
			model.addRow(row);
		}
	}
	
	public void refresh() {
		txtMaSP.setText("");
		txtDiscount.setText("");
		btnThem.setEnabled(false);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		
	}
	private void onOpenFormButtonClick() {
		dialoSp.refresh();
		dialoSp.dialogFix = this;
		dialoSp.setModal(true);
		dialoSp.setVisible(true);
		
	}
	public void onDataReturnedSP(String str) {
		System.out.println("Ma sp vua tra ve la:" + str);
		txtMaSP.setText(str);
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
