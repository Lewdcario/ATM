package window;

import java.awt.Font;

import javax.swing.JLabel;

public class CheckBalance {
	CustomFrame frameCheckBalance;
	
	/**
	 * Create the application.
	 */
	public CheckBalance() {
		initialize();
	}
	
	private void initialize() {	
		frameCheckBalance = new CustomFrame().addCloseButton("Return to Main Menu", 44, 155, 338, 53, "menu");
		frameCheckBalance.getContentPane().setLayout(null);
		
		JLabel lblYour = new JLabel("Your current balance is ($): ");
		lblYour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYour.setBounds(44, 47, 177, 45);
		frameCheckBalance.getContentPane().add(lblYour);
		
		JLabel label = new JLabel("EXAMPLE AMOUNT");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(238, 56, 158, 27);
		frameCheckBalance.getContentPane().add(label);
	}
}
