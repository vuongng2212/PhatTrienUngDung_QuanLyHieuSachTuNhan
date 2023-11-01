package dao;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

public class Test extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private WebcamPanel camPanel = null;
	private Webcam webcam = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 635, 467);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(73, 43, 469, 276);
		panel.add(panel_1);
		Dimension size = WebcamResolution.QVGA.getSize();
		webcam = Webcam.getWebcams().get(0);
		webcam.setViewSize(size);
		
		camPanel = new WebcamPanel(webcam);
		camPanel.setPreferredSize(size);
		camPanel.setFPSDisplayed(true);
		panel_1.add(camPanel);
//		initWebcam();
	}
//	public void initWebcam() {
//		Dimension size = WebcamResolution.QVGA.getSize();
//		webcam = Webcam.getWebcams().get(0);
//		webcam.setViewSize(size);
//		
//		camPanel = new WebcamPanel(webcam);
//		camPanel.setPreferredSize(size);
//		camPanel.setFPSDisplayed(true);
//		pane.add(camPanel);
//	}
}
