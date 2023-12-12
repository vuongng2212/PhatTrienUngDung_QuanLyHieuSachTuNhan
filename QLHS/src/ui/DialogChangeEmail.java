package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DAO_NhanVien;
import entity.userInfo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class DialogChangeEmail extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField txtPwd;
	private JTextField txtEmail;
	private JTextField txtEmailConfirm;
	public PanelProfit profit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogChangeEmail dialog = new DialogChangeEmail();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogChangeEmail() {
		setBounds(100, 100, 576, 242);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nhập Mật Khẩu");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(10, 23, 109, 37);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnNewButton = new JButton("Kiểm Tra");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DAO_NhanVien nv = new DAO_NhanVien();
					if(txtPwd.getText().toString().trim().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu");
					}else if(txtPwd.getText().toString().trim().equalsIgnoreCase(nv.getPwdForChange(userInfo.maNV))){
						JOptionPane.showMessageDialog(null, "Thành Công!!");
						txtEmail.setEditable(true);
						txtEmailConfirm.setEditable(true);
					}else {
						JOptionPane.showMessageDialog(null, "Mật Khẩu Bị Sai!!");
					}
				}
			});
			btnNewButton.setBounds(363, 29, 109, 27);
			contentPanel.add(btnNewButton);
		}
		{
			txtPwd = new JPasswordField();
			txtPwd.setBounds(152, 29, 164, 27);
			contentPanel.add(txtPwd);
		}
		{
			JLabel lblNhpEmailMi = new JLabel("Nhập Email mới");
			lblNhpEmailMi.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNhpEmailMi.setBounds(10, 62, 109, 37);
			contentPanel.add(lblNhpEmailMi);
		}
		{
			JLabel lblNhpLiEmail = new JLabel("Nhập lại email");
			lblNhpLiEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNhpLiEmail.setBounds(10, 101, 109, 37);
			contentPanel.add(lblNhpLiEmail);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setEditable(false);
			txtEmail.setBounds(152, 67, 164, 27);
			contentPanel.add(txtEmail);
			txtEmail.setColumns(10);
		}
		{
			txtEmailConfirm = new JTextField();
			txtEmailConfirm.setEditable(false);
			txtEmailConfirm.setColumns(10);
			txtEmailConfirm.setBounds(152, 107, 164, 27);
			contentPanel.add(txtEmailConfirm);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtEmail.getText().equalsIgnoreCase("") || !txtEmailConfirm.getText().equalsIgnoreCase("")) {
							if(txtEmail.getText().equalsIgnoreCase(txtEmailConfirm.getText())) {
								if(isValidEmail(txtEmailConfirm.getText())) {
									DAO_NhanVien nv = new DAO_NhanVien();
									nv.updateEmail(txtEmail.getText(), userInfo.maNV);
									
									JOptionPane.showMessageDialog(null,"Thành Công!!");
									setModal(false);
									setVisible(false);
									profit.refresh();
								}else {
									JOptionPane.showMessageDialog(null, "Nhập email đúng định dạng");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Phải giống nhau");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Vui lòng không được để trống email");
						}
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
						setVisible(false);
						setModal(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public static boolean isValidEmail(String email) {
        // Biểu thức chính quy để kiểm tra địa chỉ email
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        // Tạo đối tượng Pattern từ biểu thức chính quy
        Pattern pattern = Pattern.compile(regex);

        // Tạo đối tượng Matcher từ chuỗi cần kiểm tra
        Matcher matcher = pattern.matcher(email);

        // Kiểm tra xem chuỗi khớp với biểu thức chính quy hay không
        return matcher.matches();
    }
	public void refresh() {
		txtEmail.setText("");
		txtEmail.setEditable(false);
		txtEmailConfirm.setText("");
		txtEmailConfirm.setEditable(false);
		txtPwd.setText("");
	}

	public PanelProfit getProfit() {
		return profit;
	}

	public void setProfit(PanelProfit profit) {
		this.profit = profit;
	}

}
