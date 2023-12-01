package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_KhuyenMai;
import entity.ChiTietKhuyenMai;
import entity.Subject;
import entity.SubjectKm;
import list.DanhSachKhuyenMai;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

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
	private JButton btnInKM;
	

	
	
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
				{
					btnInKM = new JButton("In Khuyến Mãi");
					btnInKM.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							printReport();
						}
					});
					buttonPane.add(btnInKM);
				}
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
	private void printReport() {
		try {
			String filePath = "src\\resources\\XuatKM.jrxml";
			
//			Subject subject1 = new Subject("Java",5,"50000",0,"260VND");
//			Subject subject2 = new Subject("JavaScript",2,"50000",0,"260VND");
//			Subject subject3 = new Subject("Jsp",3,"50000",0,"260VND");
//			
//			
			List<SubjectKm> list = new ArrayList<SubjectKm>();
			list = listTable();
			
//			list.add(subject1);
//			list.add(subject2);
//			list.add(subject3);
			Locale localeCN = new Locale("vi","VN");
			NumberFormat currency = NumberFormat.getCurrencyInstance(localeCN);
			
			model = (DefaultTableModel) table.getModel();				
			JRBeanCollectionDataSource dataSource = 
					new JRBeanCollectionDataSource(list);
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("maKM", txtMaKM.getText());
			parameters.put("ngayTao", daoKm.ngayTaoTheoMa(txtMaKM.getText()));
			System.out.println(daoKm.ngayTaoTheoMa(txtMaKM.getText()));
			parameters.put("ngayHetHan",daoKm.ngayHetHanTheoMa(txtMaKM.getText()));
			System.out.println(daoKm.ngayHetHanTheoMa(txtMaKM.getText()));
			parameters.put("tableData", dataSource);
			
			
			JasperReport report = JasperCompileManager.compileReport(filePath);
			
			JasperPrint print = 
					JasperFillManager.fillReport(report, parameters,dataSource);
			JasperViewer jv = new JasperViewer(print,false);
			jv.setVisible(true);
			
			
//			JasperExportManager.exportReportToPdfFile(print,
//					"C:\\Users\\phant\\Downloads\\Total-Count-Of-Particular-Column-Values\\Total-Count-Of-Particular-"
//					+ "Column-Values\\src\\main\\resources\\student.pdf");
//			
//			System.out.println("Report Created...");
//			
			
		} catch(Exception e) {
			System.out.println("Exception while creating report");
		}
	}
	ArrayList<SubjectKm>listTable(){
		ArrayList<SubjectKm>list = new ArrayList<SubjectKm>();
		model = (DefaultTableModel) table.getModel();
		int n = table.getRowCount();
		for(int i=0;i<n;i++) {
			list.add(new SubjectKm(model.getValueAt(i, 0).toString(), model.getValueAt(i, 1).toString(), Integer.parseInt(model.getValueAt(i, 3).toString())));
		}
		return list;
	}
}

