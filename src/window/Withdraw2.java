package window;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Withdraw2{

	CustomFrame frameWithdraw2;

	/**
	 * Create the application.
	 */
	public Withdraw2() {
		initialize();
	}
	
	private void initialize() {
		
		frameWithdraw2 = new CustomFrame()
				.addCloseButton("Return to Main menu", 44, 155, 338, 53, "menu");
		
		frameWithdraw2.getContentPane().setLayout(null);
		
		JButton closeFrameButton = new JButton("Return to Main Menu");
		closeFrameButton.setBounds(44, 155, 338, 53);
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("You have deposited($) :");
		lblNewLabel.setBounds(79, 66, 158, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameWithdraw2.getContentPane().add(lblNewLabel);
		
		JLabel lblYourNewBalance = new JLabel("Your new balance is($):");
		lblYourNewBalance.setBounds(79, 107, 149, 27);
		lblYourNewBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameWithdraw2.getContentPane().add(lblYourNewBalance);
		
		JLabel label = new JLabel("EXAMPLE AMOUNT");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(245, 71, 158, 27);
		frameWithdraw2.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("EXAMPLE AMOUNT");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(245, 107, 158, 27);
		frameWithdraw2.getContentPane().add(label_1);
	}
}
