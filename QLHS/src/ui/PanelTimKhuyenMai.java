package ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_KhuyenMai;
import entity.KhuyenMai;
import entity.KhuyenMai3Field;
import list.DanhSachKhuyenMai;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class PanelTimKhuyenMai extends JPanel {
	private JTable table;
	
	private DAO_KhuyenMai daoKm;
	private DanhSachKhuyenMai listKm;
	private Object[] row;
	private KhuyenMai km;
	private DefaultTableModel model;
	private ArrayList<KhuyenMai3Field>listKmTable;
	private JDateChooser batdau;
	private JDateChooser ketThuc;
	public DialogShowKhuyenMai dialogShow;
	private String txtReturn;
	/**
	 * Create the panel.
	 */
	public PanelTimKhuyenMai() {
		km = new KhuyenMai();
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		dialogShow = new DialogShowKhuyenMai();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		daoKm = new DAO_KhuyenMai();
		listKm = new DanhSachKhuyenMai();
		listKm = daoKm.getAll();
		listKmTable = daoKm.getForSearch();
		
		
		setBounds(0,0,1534,1017);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1534, 91);
		panel.setBackground(new Color(255, 165, 0));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm Khuyến Mãi");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1534, 91);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBounds(10, 102, 1534, 133);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày Bắt Đầu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 25, 114, 32);
		panel_1.add(lblNewLabel_1);
		
		batdau = new JDateChooser();
		batdau.setDateFormatString("dd-MM-yyyy");
		batdau.setBounds(118, 25, 178, 35);
		panel_1.add(batdau);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày Kết Thúc");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(318, 25, 114, 32);
		panel_1.add(lblNewLabel_1_1);
		
		ketThuc = new JDateChooser();
		ketThuc.setDateFormatString("dd-MM-yyyy");
		ketThuc.setBounds(429, 25, 178, 35);
		panel_1.add(ketThuc);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(batdau.getDate()!=null && ketThuc.getDate()!=null) {
					if(batdau.getDate().before(ketThuc.getDate())) {
						SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
						System.out.println("Ngay bat dau: "+dateformat.format(batdau.getDate()) + " Ngay ket thuc: "+dateformat.format(ketThuc.getDate()));
						ArrayList<KhuyenMai3Field>listKmCond = daoKm.getSearchConditions(dateformat.format(batdau.getDate()),dateformat.format(ketThuc.getDate()));
						model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						for (KhuyenMai3Field km : listKmCond) {
							row[0] = km.getMaKm();
							row[1] = km.getNgayTao();
							row[2] = km.getNgayHetHan();
							model.addRow(row);
						}
					
					}else {
						JOptionPane.showMessageDialog(null,"Ngày Bắt Đầu phải lớn hơn ngày kết thúc");	
					}
				}else {
					JOptionPane.showMessageDialog(null,"Vui lòng không để trống!!");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(302, 79, 114, 43);
		panel_1.add(btnNewButton);
		
		JButton btnToMi = new JButton("Tạo Mới");
		btnToMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btnToMi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnToMi.setBounds(562, 79, 114, 43);
		panel_1.add(btnToMi);
		
		JButton btnXemChiTit = new JButton("Xem Chi Tiết");
		btnXemChiTit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = table.getSelectedRow();
				
				if(i>=0) {
					dialogShow.setTextReturn(txtReturn);
					
					dialogShow.setVisible(true);
					dialogShow.run(txtReturn);
				}else {
					JOptionPane.showMessageDialog(null,"Vui lòng chọn cột cần xem chi tiết");
				}
			}
		});
		btnXemChiTit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXemChiTit.setBounds(816, 79, 169, 43);
		panel_1.add(btnXemChiTit);
		
		
		//Sắp diễn ra
		JCheckBox checkBoxSapDienRa = new JCheckBox("Sắp Diễn Ra");
		checkBoxSapDienRa.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkBoxSapDienRa.setBounds(762, 32, 140, 23);
		panel_1.add(checkBoxSapDienRa);
		buttonGroup.add(checkBoxSapDienRa);
		checkBoxSapDienRa.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println("Sap dien ra");
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
//				System.out.println("Ngay bat dau: "+dateformat.format(batdau.getDate()) + " Ngay ket thuc: "+dateformat.format(ketThuc.getDate()));
				ArrayList<KhuyenMai3Field>listKmCond = daoKm.getSapDienRa();
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				for (KhuyenMai3Field km : listKmCond) {
					row[0] = km.getMaKm();
					row[1] = km.getNgayTao();
					row[2] = km.getNgayHetHan();
					model.addRow(row);
				}
				
			}
		});
		//Hêt Hạn
		JCheckBox checkBoxHetHan = new JCheckBox("Hết Hạn");
		checkBoxHetHan.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkBoxHetHan.setBounds(988, 30, 122, 23);
		panel_1.add(checkBoxHetHan);
		buttonGroup.add(checkBoxHetHan);
		checkBoxHetHan.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				System.out.println("het han");
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
//				System.out.println("Ngay bat dau: "+dateformat.format(batdau.getDate()) + " Ngay ket thuc: "+dateformat.format(ketThuc.getDate()));
				ArrayList<KhuyenMai3Field>listKmCond = daoKm.getHetHan();
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				for (KhuyenMai3Field km : listKmCond) {
					row[0] = km.getMaKm();
					row[1] = km.getNgayTao();
					row[2] = km.getNgayHetHan();
					model.addRow(row);
				}
			}
		});
		
		//Đang áp dụng
		JCheckBox checkBoxDangSuDung = new JCheckBox("Đang áp dụng");
		checkBoxDangSuDung.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkBoxDangSuDung.setBounds(1169, 32, 148, 23);
		panel_1.add(checkBoxDangSuDung);
		buttonGroup.add(checkBoxDangSuDung);
		
		JButton btnXoa = new JButton("Xóa Khuyến Mãi");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				int i = table.getSelectedRow();
				boolean flag = true;
				if(i>=0) {
					daoKm = new DAO_KhuyenMai();
					ArrayList<KhuyenMai3Field>listkm = new ArrayList<KhuyenMai3Field>();
					listkm = daoKm.getApDung();
					for (KhuyenMai3Field km : listkm) {
						if(km.getMaKm().equalsIgnoreCase(txtReturn))
							flag =  false;
						
					}
					
					if(flag) {
						int option = JOptionPane.showOptionDialog(null, "Chắc chắn xóa khuyến mãi khỏi danh sách", "Xác nhận", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
						switch (option) {
						case JOptionPane.YES_OPTION:
							System.out.println("Xoa khuyen mai: " +txtReturn);
							daoKm.delete(txtReturn);
//							table.remove(i);
//							listKm.xoa(i);
							model.removeRow(i);	
							break;
							
						default:
							break;
						}
						

					}else {
						JOptionPane.showMessageDialog(null, "Chỉ có thể xoá khuyến mãi đã hết hạn hoặc đang dự định");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng cần xóa!");
				}
				
				
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(1093, 79, 169, 43);
		panel_1.add(btnXoa);
		checkBoxDangSuDung.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println("dang ap dung");
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
//				System.out.println("Ngay bat dau: "+dateformat.format(batdau.getDate()) + " Ngay ket thuc: "+dateformat.format(ketThuc.getDate()));
				ArrayList<KhuyenMai3Field>listKmCond = daoKm.getApDung();
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				for (KhuyenMai3Field km : listKmCond) {
					row[0] = km.getMaKm();
					row[1] = km.getNgayTao();
					row[2] = km.getNgayHetHan();
					model.addRow(row);
				}
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 236, 1534, 626);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				txtReturn = model.getValueAt(i, 0).toString();
			}
		});
		model = new DefaultTableModel();
		String[] column = {"Mã Khuyến Mãi","Ngày Tạo","Ngày Hết Hạn"};
		row = new Object[3];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		for (KhuyenMai3Field km : listKmTable) {
			row[0] = km.getMaKm();
			row[1] = dateformat.format(km.getNgayTao());
			row[2] = dateformat.format(km.getNgayHetHan());
			model.addRow(row);
		}

	}
	public void refresh() {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		listKmTable = daoKm.getForSearch();
		for (KhuyenMai3Field km : listKmTable) {
		
			row[0] = km.getMaKm();
			row[1] = dateformat.format(km.getNgayTao());
			row[2] = dateformat.format(km.getNgayHetHan());
			model.addRow(row);
		}
	}
	
	public void dangDienRa() {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
	}
}
