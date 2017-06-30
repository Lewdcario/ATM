package window;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChangePassword{

	CustomFrame frameChangePassword;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the application.
	 */
	public ChangePassword() {
		initialize();
	}
	
	private void initialize() {
		frameChangePassword = new CustomFrame()
				.addCloseButton("Return to Main Menu", 38, 185, 338, 53, "menu")
				.addCloseButton("Change Password", 38, 121, 338, 53, "passwordStatus");

		frameChangePassword.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter New Password:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 70, 166, 40);
		frameChangePassword.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(197, 82, 124, 20);
		frameChangePassword.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterOldPassword = new JLabel("Enter Old Password:");
		lblEnterOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterOldPassword.setBounds(44, 27, 137, 40);
		frameChangePassword.getContentPane().add(lblEnterOldPassword);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(197, 39, 124, 20);
		frameChangePassword.getContentPane().add(textField_1);
	}
}
