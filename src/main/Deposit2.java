package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class Deposit2{

	JFrame frameDeposit2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit2 window = new Deposit2();
					window.frameDeposit2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Deposit2() {
		initialize();
		
	}
	private void menuWindow() {
	Menu window = new Menu();
	window.frameMenu.setVisible(true);
	}
	
	private void initialize() {
		
		frameDeposit2 = new JFrame();
		frameDeposit2.setBounds(100, 100, 450, 300);
		frameDeposit2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDeposit2.getContentPane().setLayout(null);
		
		JButton closeFrameButton = new JButton("Return to Main Menu");
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameDeposit2.dispose();
				menuWindow();
			}
		});
		closeFrameButton.setBounds(44, 155, 338, 53);
		frameDeposit2.getContentPane().add(closeFrameButton);
		
		JLabel lblNewLabel = new JLabel("You have deposited ($):");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(44, 57, 158, 59);
		frameDeposit2.getContentPane().add(lblNewLabel);
		
		JLabel lblExample = new JLabel("EXAMPLE AMOUNT");
		lblExample.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExample.setBounds(212, 57, 158, 59);
		frameDeposit2.getContentPane().add(lblExample);
	}
}
