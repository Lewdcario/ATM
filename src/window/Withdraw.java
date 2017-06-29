package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;


public class Withdraw{

	JFrame frameWithdraw;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public Withdraw() {
		initialize();
	}

	private void menuWindow() {
		Menu window = new Menu();
		window.frameMenu.setVisible(true);
	}
	
	private void menuWithdraw2() {
		Withdraw2 window = new Withdraw2();
		window.frameWithdraw2.setVisible(true);
	}
	
	private void initialize() {
		
		frameWithdraw = new CustomFrame();
		// frameWithdraw.setBounds(100, 100, 450, 300);
		// frameWithdraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameWithdraw.getContentPane().setLayout(null);
		
		JButton closeFrameButton = new JButton("Return to Main Menu");
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameWithdraw.dispose();
				menuWindow();
			}
		});
		closeFrameButton.setBounds(44, 185, 338, 53);
		frameWithdraw.getContentPane().add(closeFrameButton);
		
		JButton btnWithdrawAmount = new JButton("Withdraw Funds");
		btnWithdrawAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameWithdraw.dispose();
				menuWithdraw2();
			}
		});
		btnWithdrawAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnWithdrawAmount.setBounds(44, 121, 338, 53);
		frameWithdraw.getContentPane().add(btnWithdrawAmount);
		
		JLabel lblNewLabel = new JLabel("Withdraw Amount($):");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(67, 60, 148, 29);
		frameWithdraw.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(221, 66, 86, 20);
		frameWithdraw.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
