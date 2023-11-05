package ui;

import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.DAO_NhanVien;
import entity.NhanVien;
import list.DanhSachNhanVien;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class PanelQLNV extends JPanel implements MouseListener{
	private JTable table;
	private DefaultTableModel tableModel;
	private DanhSachNhanVien ls;
	private DAO_NhanVien DAO_NV;
	private JTextField txtMa,txtTen,txtSDT,txtDiaChi,txtEmail;
	private JComboBox cbGT,cbCV;
	private int stt = 1;
	/**
	 * Create the panel.
	 */
	public PanelQLNV() {
		ls = new DanhSachNhanVien();
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setBounds(0, 200, 1920, 816);
		setLayout(null);
		
		JPanel westPanel = new JPanel();
		westPanel.setLayout(null);
		westPanel.setBounds(0, 0, 400, 817);
		add(westPanel);
		
		JLabel lblTen = new JLabel("Tên nhân viên:");
		lblTen.setForeground(new Color(0, 0, 160));
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTen.setBounds(10, 102, 150, 30);
		westPanel.add(lblTen);
		
		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setForeground(new Color(0, 0, 160));
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSDT.setBounds(10, 225, 130, 30);
		westPanel.add(lblSDT);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 0, 160));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(10, 307, 130, 30);
		westPanel.add(lblEmail);
		
		JLabel lblGT = new JLabel("Giới tính");
		lblGT.setForeground(new Color(0, 0, 160));
		lblGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGT.setBounds(10, 143, 130, 30);
		westPanel.add(lblGT);
		
		JLabel lblDoB = new JLabel("Ngày sinh:");
		lblDoB.setForeground(new Color(0, 0, 160));
		lblDoB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDoB.setBounds(10, 184, 130, 30);
		westPanel.add(lblDoB);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTen.setColumns(10);
		txtTen.setBounds(205, 102, 160, 30);
		westPanel.add(txtTen);
		
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(205, 225, 160, 30);
		westPanel.add(txtSDT);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(205, 266, 160, 30);
		westPanel.add(txtDiaChi);
		
		cbGT = new JComboBox();
		cbGT.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbGT.setBounds(205, 143, 70, 30);
		westPanel.add(cbGT);
		
		JLabel lblTimNV = new JLabel("Quản lý nhân viên");
		lblTimNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimNV.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTimNV.setBounds(0, 0, 400, 50);
		westPanel.add(lblTimNV);
		
		JLabel lblMa = new JLabel("Mã nhân viên:");
		lblMa.setForeground(new Color(0, 0, 160));
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMa.setBounds(10, 61, 130, 30);
		westPanel.add(lblMa);
		
		txtMa = new JTextField();
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMa.setColumns(10);
		txtMa.setBounds(205, 61, 160, 30);
		westPanel.add(txtMa);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setForeground(new Color(0, 0, 160));
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiaChi.setBounds(10, 266, 130, 30);
		westPanel.add(lblDiaChi);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(205, 307, 160, 30);
		westPanel.add(txtEmail);
		
		JLabel lblChcV = new JLabel("Chức vụ:");
		lblChcV.setForeground(new Color(0, 0, 160));
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChcV.setBounds(10, 348, 130, 30);
		westPanel.add(lblChcV);
		
		cbCV = new JComboBox();
		cbCV.setModel(new DefaultComboBoxModel(new String[] {"Quản lý", "Nhân viên"}));
		cbCV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbCV.setBounds(205, 354, 100, 30);
		westPanel.add(cbCV);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				// TODO Auto-generated method stub
				int r = table.getSelectedRow();
				if (r != -1) {
					int tb = JOptionPane.showConfirmDialog(getParent(), "Bạn muốn xóa nhân viên này không?", "Chú ý!", JOptionPane.YES_NO_OPTION);
					if (tb == JOptionPane.YES_OPTION) {
						ls.xoaNV(r);
						DAO_NV.delete(table.getValueAt(r, 1).toString());
						tableModel.removeRow(r);
						JOptionPane.showMessageDialog(getParent(), "Xoá dịch nhân viên thành công!");
						xoaTrang();
						loadData();
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "Vui lòng chọn nhân viên muốn xoá!");
				}
				
			}
		});
		
		btnXoa.setForeground(new Color(0, 0, 160));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBounds(265, 445, 100, 30);
		westPanel.add(btnXoa);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(205, 184, 160, 30);
		dateChooser.getDate();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		westPanel.add(dateChooser);
		
		
		String[] headers = { "STT", "Mã nhân viên", "Họ và tên","Ngày sinh",  "Giới tính",  "SĐT", "Địa chỉ", "Email", "Chức vụ"};
		tableModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(400, 0, 1520, 817);
		scroll.setViewportView(table = new JTable(tableModel));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				System.out.println(row);
				if(row != -1) {
					txtMa.setText(table.getValueAt(row, 1).toString());
					txtTen.setText(table.getValueAt(row, 2).toString());
					String gt = table.getValueAt(row, 4).toString();
					txtSDT.setText(table.getValueAt(row, 5).toString());
					txtDiaChi.setText(table.getValueAt(row, 6).toString());
					txtEmail.setText(table.getValueAt(row, 7).toString());
					String cv = table.getValueAt(row, 8).toString();
					
					cbGT.setSelectedItem(gt);
					cbCV.setSelectedItem(cv);
				}
				
			}
		});
		table.setRowHeight(35);
		table.setAutoCreateRowSorter(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
//		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
//		table.getColumnModel().getColumn(3).setPreferredWidth(50);
//		table.getColumnModel().getColumn(4).setPreferredWidth(10);
//		table.getColumnModel().getColumn(4).setPreferredWidth(10);
		table.getColumnModel().getColumn(6).setPreferredWidth(500);
		table.getColumnModel().getColumn(7).setPreferredWidth(300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		add(scroll);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = table.getSelectedRow();
				System.out.println(r);
				if (r != -1) {	
					String ma = txtMa.getText();
					String ten = txtTen.getText();
					Date ns = new Date(dateChooser.getDate().getTime());
					String gioiTinh = cbGT.getSelectedItem().toString();
					Integer gt = 1;
					if(gioiTinh=="Nữ") {
						gt =0;
					}
					String sdt = txtSDT.getText();
					String diaChi = txtDiaChi.getText();
					String email = txtEmail.getText();
					String CV = cbCV.getSelectedItem().toString();

					NhanVien nv = new NhanVien(ma, ten, ns, gt, sdt, diaChi, email, CV);
					System.out.println(nv.toString());
					if (DAO_NV.updateNhanVien(nv)) {
						ls.capNhatThongTinNhanVien(nv);
						loadData();
						JOptionPane.showMessageDialog(getParent(), "Cập nhật thông tin nhân viên thành công!");
					}
					else {
						JOptionPane.showMessageDialog(getParent(), "Không thành công! Vui lòng kiểm tra lại...");
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "Vui lòng chọn nhân viên muốn sửa thông tin!");
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSua.setBackground(new Color(0, 128, 255));
		btnSua.setBounds(140, 445, 100, 30);
		westPanel.add(btnSua);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = txtMa.getText();
				String ten = txtTen.getText();
				Date ns = new Date(dateChooser.getDate().getTime());
				String gioiTinh = cbGT.getSelectedItem().toString();
				Integer gt = 0;
				if(gioiTinh=="Nam"){
					gt = 1;
				}
				String sdt = txtSDT.getText();
				String diaChi = txtDiaChi.getText();
				String email = txtEmail.getText();
				String CV = cbCV.getSelectedItem().toString();
				NhanVien nv = new NhanVien(ma, ten, ns, gt, sdt, diaChi, email, CV);
				System.out.println(nv.toString());
				if(DAO_NV.add(nv)) {
					ls.themNhanVien(nv);
					Object row[] = {stt++,ma, ten, ns.toString(), gioiTinh, sdt, diaChi, email, CV};
					tableModel.addRow(row);
					JOptionPane.showMessageDialog(getParent(), "Thêm Nhân viên thành công!");
				}
				else {
					JOptionPane.showMessageDialog(getParent(), "Thêm Nhân viên thất bại!");
				}
			}
		});
		btnThem.setForeground(new Color(0, 0, 160));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBackground(Color.GREEN);
		btnThem.setBounds(10, 445, 100, 30);
		westPanel.add(btnThem);
		loadData();
	}
	public void deleteAllDataJtable() {
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
		while(dm.getRowCount() > 0)
		{
		    dm.removeRow(0);
		}
		stt = 1;
	}
	
	public void loadData() {
		xoaTrang();
		//delete all
		deleteAllDataJtable();
		//Load data
//		ArrayList<HoaDonDichVuPhong> dsDVP = new ArrayList<HoaDonDichVuPhong>();
		DAO_NV = new DAO_NhanVien();

		ls.clear();
		for(NhanVien nv: DAO_NV.getAll()) {
			ls.themNhanVien(nv);
			String gioiTinh = "Nam";
			if(nv.getGioiTinh()==0) {
				gioiTinh = "Nữ";
			}
			Object row[] = {stt++,nv.getMaNV(),nv.getTenNV(),nv.getDoB(),gioiTinh,nv.getSDT(),nv.getDiaChi(),nv.getEmail(),nv.getChucVu()};
			tableModel.addRow(row);
		}
//		dsDVP = ds.getList();
//		for(int i=0;i<dsDVP.size();i++) {
//			System.out.println(dsDVP.get(i).getThanhTienDichVu());
//		}
	}
	private void xoaTrang() {
		txtMa.setText("");
		txtTen.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
//		System.out.println(row);
		txtMa.setText(table.getValueAt(row, 1).toString());
		txtTen.setText(table.getValueAt(row, 2).toString());
		txtSDT.setText(table.getValueAt(row, 2).toString());
		txtDiaChi.setText(table.getValueAt(row, 1).toString());
		txtEmail.setText(table.getValueAt(row, 2).toString());
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
