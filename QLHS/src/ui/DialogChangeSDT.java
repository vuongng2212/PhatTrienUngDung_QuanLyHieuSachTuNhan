package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DAO_NhanVien;
import dao.DAO_account;
import entity.userInfo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class DialogChangeSDT extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lbllMatKhau;
	private JButton btnKiemTra;
	private JPasswordField txtMatKhau;
	private JTextField txtSDT;
	private JTextField txtConfirmSDT;
	private String oldPwd;
	public PanelProfit profit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogChangeSDT dialog = new DialogChangeSDT();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogChangeSDT() {
		setBounds(100, 100, 573, 293);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 235, 215));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lbllMatKhau = new JLabel("Nhập Mật Khẩu");
		lbllMatKhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllMatKhau.setBounds(10, 22, 135, 43);
		contentPanel.add(lbllMatKhau);
		
		btnKiemTra = new JButton("Kiểm Tra");
		btnKiemTra.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnKiemTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO_NhanVien nv = new DAO_NhanVien();
				if(txtMatKhau.getText().toString().trim().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu");
				}else if(txtMatKhau.getText().toString().trim().equalsIgnoreCase(nv.getPwdForChange(userInfo.maNV))){
					JOptionPane.showMessageDialog(null, "Thành Công!!");
					oldPwd = nv.getPwdForChange(userInfo.maNV);
					txtConfirmSDT.setEditable(true);
					txtSDT.setEditable(true);
				}else {
					JOptionPane.showMessageDialog(null, "Mật Khẩu Bị Sai!!");
				}
			}
		});
		btnKiemTra.setBackground(new Color(0, 255, 255));
		btnKiemTra.setBounds(381, 30, 126, 31);
		contentPanel.add(btnKiemTra);
		
		JLabel lblNhpSin = new JLabel("Nhập Số Điện Thoại Mới");
		lblNhpSin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNhpSin.setBounds(10, 106, 184, 43);
		contentPanel.add(lblNhpSin);
		
		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setBounds(264, 108, 243, 43);
		contentPanel.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lblXcNhnLi = new JLabel("Nhập Lại Số Điện Thoại");
		lblXcNhnLi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblXcNhnLi.setBounds(10, 160, 195, 43);
		contentPanel.add(lblXcNhnLi);
		
		txtConfirmSDT = new JTextField();
		txtConfirmSDT.setEditable(false);
		txtConfirmSDT.setColumns(10);
		txtConfirmSDT.setBounds(264, 162, 243, 43);
		contentPanel.add(txtConfirmSDT);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(143, 23, 184, 42);
		contentPanel.add(txtMatKhau);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(250, 235, 215));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtConfirmSDT.getText().equalsIgnoreCase("") || !txtSDT.getText().equalsIgnoreCase("")) {
							if(txtConfirmSDT.getText().equalsIgnoreCase(txtSDT.getText())) {
								if(isValidPhoneNumber(txtSDT.getText())) {
									DAO_account daoAcc = new DAO_account();
									DAO_NhanVien daoNv = new DAO_NhanVien();
									String newsdt = txtSDT.getText();
									String oldsdt = userInfo.sdt;
									String pwd = daoAcc.ReturnPwd(oldsdt);
									daoAcc.deleteAcc(oldsdt);
									daoNv.updateSDT(newsdt, userInfo.maNV);
									daoAcc.insertAcc(newsdt, pwd);
									
									JOptionPane.showMessageDialog(null, "Thành Công");
									setModal(false);
									setVisible(false);
									profit.refresh();
									
								}else {
									JOptionPane.showMessageDialog(null, "Số Điện Thoại nhập vào không hợp lệ!!");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Thông tin SDT 2 textField phải trùng khớp");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Thất Bại!!");
						}
					}
				});
				okButton.setBackground(new Color(124, 252, 0));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						setModal(false);
					}
				});
				cancelButton.setBackground(new Color(255, 0, 0));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	 public static boolean isValidPhoneNumber(String phoneNumber) {
	        // Biểu thức chính quy để kiểm tra số điện thoại
	        String regex = "^(\\+\\d{1,3})?\\s?(\\d{3,4})\\s?\\d{3,4}\\s?\\d{3,4}$";

	        // Tạo đối tượng Pattern từ biểu thức chính quy
	        Pattern pattern = Pattern.compile(regex);

	        // Tạo đối tượng Matcher từ chuỗi cần kiểm tra
	        Matcher matcher = pattern.matcher(phoneNumber);

	        // Kiểm tra xem chuỗi khớp với biểu thức chính quy hay không
	        return matcher.matches();
	    }
	 public void refresh() {
		 txtConfirmSDT.setEditable(false);
		 txtSDT.setEditable(false);
		 
	 }

	public PanelProfit getProfit() {
		return profit;
	}

	public void setProfit(PanelProfit profit) {
		this.profit = profit;
	}
	 
	 
}
