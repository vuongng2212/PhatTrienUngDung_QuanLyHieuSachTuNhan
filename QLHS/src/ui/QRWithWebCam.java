package ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class QRWithWebCam extends JFrame implements Runnable,ThreadFactory{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private WebcamPanel camPanel = null;
	private Webcam webcam = null;
	private JPanel PanelCam;
	private Result result = null;
	private BufferedImage image = null;
	private JLabel lblCheck;
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QRWithWebCam frame1 = new QRWithWebCam();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public QRWithWebCam() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		PanelCam = new JPanel();
		PanelCam.setBounds(0, 0, 584, 400);
		panel.add(PanelCam);
		Dimension size = WebcamResolution.QVGA.getSize();
		webcam = Webcam.getWebcams().get(0);
		webcam.setViewSize(size);
		PanelCam.setLayout(null);
		
		camPanel = new WebcamPanel(webcam);
		camPanel.setBounds(79, 11, 415, 350);
		camPanel.setPreferredSize(size);
		camPanel.setFPSDisplayed(true);
		PanelCam.add(camPanel);
		
		lblCheck = new JLabel("Hold your camera...");
		lblCheck.setForeground(new Color(255, 0, 0));
//		lblCheck.setForeground(new Color(0, 128, 0));
		lblCheck.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblCheck.setBounds(205, 411, 184, 30);
		panel.add(lblCheck);
		executor.execute(this);
	}
	public void stopThread() {
		executor.shutdown();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			
			if(webcam.isOpen()) {
				if((image = webcam.getImage()) == null) {
					continue;
				}
				LuminanceSource source = new BufferedImageLuminanceSource(image);
				BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
				
				try {
					result = new MultiFormatReader().decode(bitmap);
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
				}
				if(result != null) {
					lblCheck.setForeground(new Color(0, 128, 0));
					lblCheck.setText("succeed!");
					LoginForm f = new LoginForm(result.getText());
					f.setVisible(true);
					stopThread();
					webcam.close();
					dispose();
					f.dispose();
				}
			}
		} while (result == null);
	}
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, "Thread");
		t.setDaemon(true);
		return t;
	}
}
