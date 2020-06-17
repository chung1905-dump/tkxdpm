package XacNhanDonHang.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.view.IView;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JTable;

public class XacNhanDonHangGUI implements IView {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XacNhanDonHangGUI window = new XacNhanDonHangGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public XacNhanDonHangGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		frame.getContentPane().add(table, BorderLayout.CENTER);
	}

	@Override
	public Container draw() {
		// TODO Auto-generated method stub
		return null;
	}

}
