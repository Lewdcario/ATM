package window;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Withdraw{

	CustomFrame frameWithdraw;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public Withdraw() {
		initialize();
	}
	
	private void initialize() {
		
		frameWithdraw = new CustomFrame()
				.addCloseButton("Withdraw Funds", 38, 121, 338, 53, "withdraw2")
				.addCloseButton("Return to Main menu", 38, 185, 338, 53, "menu");

		frameWithdraw.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Withdraw Amount($):");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(67, 60, 148, 29);
		frameWithdraw.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(221, 66, 86, 20);
		frameWithdraw.getContentPane().add(textField);
		textField.setColumns(10);
		frameWithdraw.withdrawMath("Withdraw Funds", 44, 121, 338, 53, "withdraw2", textField);
	}
}
