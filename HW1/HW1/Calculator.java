package HW1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator {

	private JFrame frmCalculator;
	private JTextField num_1;
	private JTextField num_2;
	private float num1 = 0;
	private float num2 = 0;
	private float result = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setTitle("Calculator");
		frmCalculator.setBounds(100, 100, 450, 300);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("First Number");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frmCalculator.getContentPane().add(lblNewLabel);
		
		num_1 = new JTextField();
		num_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setLabelFor(num_1);
		frmCalculator.getContentPane().add(num_1);
		num_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Second Number");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frmCalculator.getContentPane().add(lblNewLabel_1);
		
		num_2 = new JTextField();
		num_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setLabelFor(num_2);
		frmCalculator.getContentPane().add(num_2);
		num_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Result");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frmCalculator.getContentPane().add(lblNewLabel_2);
		
		JLabel result_0 = new JLabel("");
		result_0.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setLabelFor(result_0);
		frmCalculator.getContentPane().add(result_0);
		
		JButton add_btn = new JButton("+");
		add_btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Float.valueOf(num_1.getText());
				num2 = Float.valueOf(num_2.getText());
				result = num1 + num2;
				result_0.setText(String.valueOf(result));
			}
		});
		frmCalculator.getContentPane().add(add_btn);
		
		JButton sub_btn = new JButton("-");
		sub_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Float.valueOf(num_1.getText());
				num2 = Float.valueOf(num_2.getText());
				result = num1 - num2;
				result_0.setText(String.valueOf(result));
			}
		});
		sub_btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmCalculator.getContentPane().add(sub_btn);
		
		JButton mul_btn = new JButton("*");
		mul_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Float.valueOf(num_1.getText());
				num2 = Float.valueOf(num_2.getText());
				result = num1 * num2;
				result_0.setText(String.valueOf(result));
			}
		});
		mul_btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmCalculator.getContentPane().add(mul_btn);
		
		JButton div_btn = new JButton("/");
		div_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Float.valueOf(num_1.getText());
				num2 = Float.valueOf(num_2.getText());
				if(num2 == 0) {
					result_0.setText("Mẫu số phải khác 0");
				} else {
					result = num1 / num2;
					result_0.setText(String.valueOf(result));
				}
			}
		});
		div_btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmCalculator.getContentPane().add(div_btn);
		
		JButton remain_btn = new JButton("%");
		remain_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Float.valueOf(num_1.getText());
				num2 = Float.valueOf(num_2.getText());
				if(num2 == 0) {
					result_0.setText("Mẫu số phải khác 0");
				} else {
					result = num1 % num2;
					result_0.setText(String.valueOf(result));
				}
			}
		});
		remain_btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmCalculator.getContentPane().add(remain_btn);
		
		JButton clear_btn = new JButton("CLEAR");
		clear_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = 0;
				num2 = 0;
				result = 0;
				num_1.setText(null);
				num_2.setText(null);
				result_0.setText(null);				
			}
		});
		clear_btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmCalculator.getContentPane().add(clear_btn);
	}
}
