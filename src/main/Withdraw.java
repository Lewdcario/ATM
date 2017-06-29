package main;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Withdraw {

	JFrame frameWithdraw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw window = new Withdraw();
					window.frameWithdraw.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Withdraw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameWithdraw = new JFrame();
		frameWithdraw.setBounds(100, 100, 450, 300);
		frameWithdraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameWithdraw.getContentPane().setLayout(null);
		
		JButton btnSuper = new JButton("Withdraw");
		btnSuper.setBounds(41, 33, 89, 23);
		frameWithdraw.getContentPane().add(btnSuper);
		
		JButton btnButtons = new JButton("Testing");
		btnButtons.setBounds(41, 98, 89, 23);
		frameWithdraw.getContentPane().add(btnButtons);
	}

}
