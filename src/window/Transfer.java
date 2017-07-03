package window;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Transfer{

	CustomFrame frameTransfer;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the application.
	 */
	public Transfer() {
		initialize();
	}

	private void initialize() {
		
		frameTransfer = new CustomFrame()
				.addCloseButton("Return to Main menu", 38, 185, 338, 53, "menu");

		frameTransfer.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Amount ($): ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(31, 36, 126, 36);
		frameTransfer.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(188, 46, 86, 20);
		frameTransfer.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTransferTo = new JLabel("Transfer to:");
		lblTransferTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTransferTo.setBounds(72, 83, 126, 36);
		frameTransfer.getContentPane().add(lblTransferTo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(188, 93, 86, 20);
		frameTransfer.getContentPane().add(textField_1);
		
		frameTransfer.transferMoney("Transfer Funds", 38, 121, 338, 53, "transferStatus", textField, textField_1);
	}
}
