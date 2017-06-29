package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Menu {

	private JFrame frame1;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	private void depositWindow() {
		Deposit window = new Deposit();
		window.frameDeposit.setVisible(true);
	}
	
	private void withdrawWindow() {
	Withdraw window = new Withdraw();
	window.frameWithdraw.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Initializing first frame
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 450, 300);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JLabel lblTest = new JLabel("Username");
		lblTest.setBounds(32, 44, 125, 26);
		frame1.getContentPane().add(lblTest);
		
		JLabel label = new JLabel("Password");
		label.setBounds(32, 96, 125, 26);
		frame1.getContentPane().add(label);
			
		textField = new JTextField();
		textField.setBounds(178, 44, 186, 29);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 93, 186, 29);
		frame1.getContentPane().add(passwordField);
		
		JButton closeFrameButton = new JButton("click me to close this frame");
		// Start second frame, login successful, will probably have to manually code buttons to go in other frames
		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("button clicked!");
				frame1.dispose();
				depositWindow();
			}
		});
		closeFrameButton.setBounds(44, 155, 338, 53);
		frame1.getContentPane().add(closeFrameButton);
	}
}