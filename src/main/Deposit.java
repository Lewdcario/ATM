package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Deposit{

	JFrame frameDeposit;
	private JTextField textField;
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
	private void menuWindow() {
	Menu window = new Menu();
	window.frameMenu.setVisible(true);
	}
	private void menuDeposit2() {
	Deposit2 window = new Deposit2();
	window.frameDeposit2.setVisible(true);
	}
	
	private void initialize() {
		
		frameDeposit = new JFrame();
		frameDeposit.setBounds(100, 100, 450, 300);
		frameDeposit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton closeFrameButton = new JButton("Return to Main Menu");
		closeFrameButton.setBounds(44, 185, 338, 53);
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDeposit.dispose();
				menuWindow();
			}
		});
		frameDeposit.getContentPane().setLayout(null);
		frameDeposit.getContentPane().add(closeFrameButton);
		
		textField = new JTextField();
		textField.setBounds(217, 59, 100, 25);
		frameDeposit.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Deposit Amount($):");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(82, 59, 137, 27);
		frameDeposit.getContentPane().add(lblNewLabel);
		
		JButton btnDepositFunds = new JButton("Deposit Funds");
		btnDepositFunds.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDepositFunds.setBounds(44, 121, 338, 53);
		btnDepositFunds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDeposit.dispose();
				menuDeposit2();
			}
		});
		frameDeposit.getContentPane().add(btnDepositFunds);
	}
}
