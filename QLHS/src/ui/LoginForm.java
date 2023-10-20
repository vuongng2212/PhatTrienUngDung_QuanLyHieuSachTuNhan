package ui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblUser,lblPass;
	private JTextField txtUser, txtPass;
	private JButton btnDangnhap;
	private JLabel lblKhachHang;

	public static void main(String[] args) {
		try {
			LoginForm frame = new LoginForm();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LoginForm() {
		setTitle("LOGIN");
		setSize(550, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setLayout(null);
		getContentPane().add(contentPane, BorderLayout.CENTER);

		lblUser = new JLabel("User");
		lblUser.setForeground(new Color(0, 0, 160));
		lblUser.setFont(new Font("Arial", Font.BOLD, 13));
		lblUser.setBounds(70, 80, 100, 40);
		contentPane.add(lblUser);

		txtUser = new JTextField();
		txtUser.setBounds(180, 80, 200, 40);
		contentPane.add(txtUser);

		lblPass = new JLabel("Password");
		lblPass.setForeground(new Color(0, 0, 160));
		lblPass.setFont(new Font("Arial", Font.BOLD, 13));
		lblPass.setBounds(70, 137, 100, 40);
		contentPane.add(lblPass);

		txtPass = new JPasswordField();
		txtPass.setBounds(180, 137, 200, 40);
		contentPane.add(txtPass);

		btnDangnhap = new JButton("LOGIN");
		btnDangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello");
			}
		});
		btnDangnhap.setForeground(new Color(0, 0, 160));
		btnDangnhap.setBackground(new Color(0, 255, 255));

		btnDangnhap.setBounds(260, 205, 120, 35);
		contentPane.add(btnDangnhap);
		
		JButton btnQR = new JButton("QRCode");
		btnQR.setBounds(410, 80, 100, 100);
		contentPane.add(btnQR);
		
		JLabel lblTieuDe = new JLabel("HỆ THỐNG QUẢN LÝ HIỆU SÁCH TƯ NHÂN");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(new Color(0, 0, 160));
		lblTieuDe.setBackground(new Color(255, 255, 255));
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTieuDe.setBounds(0, 11, 534, 40);
		contentPane.add(lblTieuDe);
		
		lblKhachHang = new JLabel("Bạn là khách hàng?");
		lblKhachHang.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblKhachHang.setForeground(new Color(0, 0, 160));
		lblKhachHang.setBounds(70, 214, 180, 14);
		contentPane.add(lblKhachHang);

	}
}
