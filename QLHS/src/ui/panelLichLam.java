package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class panelLichLam extends JPanel {

	public JLabel lbllSystem;

	/**
	 * Create the panel.
	 */
	public panelLichLam() {
		setBounds(0,0,1534,1017);
//		setSize(1534,1017);
		setLayout(null);
		setVisible(true);
		
		lbllSystem = new JLabel("Đây là Trang System");
		lbllSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lbllSystem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllSystem.setBounds(304, 97, 575, 407);
		add(lbllSystem);
	}

}
