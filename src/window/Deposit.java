package window;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Deposit {

	CustomFrame frameDeposit;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public Deposit() {
		initialize();
		
	}
	
	private void initialize() {
		frameDeposit = new CustomFrame()
				/*.addCloseButton("Deposit Funds", 44, 121, 338, 53, "deposit2")*/
				.addCloseButton("Return to Main menu", 44, 185, 338, 53, "menu");

		frameDeposit.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(217, 59, 100, 25);
		frameDeposit.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Deposit Amount($):");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(80, 55, 137, 27);
		frameDeposit.getContentPane().add(lblNewLabel);
		frameDeposit.depositMath("Deposit Funds", 44, 121, 338, 53, "deposit2", textField);
	}
}
