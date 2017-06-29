package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Deposit{

	JFrame frameDeposit;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit window = new Deposit();
					window.frameDeposit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Deposit() {
		initialize();
		
	}
	private void withdrawWindow() {
	Withdraw window = new Withdraw();
	window.frameWithdraw.setVisible(true);
	}
	
	private void initialize() {
		
		
		frameDeposit = new JFrame();
		frameDeposit.setBounds(100, 100, 450, 300);
		frameDeposit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDeposit.getContentPane().setLayout(null);
		
		JButton btnSuper = new JButton("Super");
		btnSuper.setBounds(41, 33, 89, 23);
		frameDeposit.getContentPane().add(btnSuper);
		
		JButton btnButtons = new JButton("BUttons");
		btnButtons.setBounds(41, 98, 89, 23);
		frameDeposit.getContentPane().add(btnButtons);
		
		JButton closeFrameButton = new JButton("click me to close this frame");

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("button clicked!");
				frameDeposit.dispose();
				withdrawWindow();
			}
		});
		closeFrameButton.setBounds(44, 155, 338, 53);
		frameDeposit.getContentPane().add(closeFrameButton);
	}
}
