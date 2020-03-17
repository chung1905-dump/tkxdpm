import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HelloWorld {

	private JFrame frame;
	private JTextField name;
	JLabel msg;
	JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorld window = new HelloWorld();
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
	public HelloWorld() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Your name: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(54, 68, 89, 20);
		frame.getContentPane().add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(147, 62, 220, 37);
		frame.getContentPane().add(name);
		name.setColumns(10);
		msg = new JLabel(" ");
		msg.setHorizontalAlignment(SwingConstants.CENTER);
		msg.setBounds(87, 185, 280, 46);
		frame.getContentPane().add(msg);
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String hellomsg = "Hello, "+name.getText()+"!";
				System.out.println(hellomsg);
				msg.setText(hellomsg);
				//msg.setText(msg);
			}
		});
		btnNewButton.setBounds(147, 110, 106, 23);
		frame.getContentPane().add(btnNewButton);
		

	}
}
