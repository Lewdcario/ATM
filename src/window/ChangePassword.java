package window;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class ChangePassword{

	CustomFrame frameChangePassword;
	private JPasswordField newPassword;
	private JPasswordField oldPassword;

	/**
	 * Create the application.
	 */
	public ChangePassword() {
		initialize();
	}
	
	private void initialize() {
		frameChangePassword = new CustomFrame()
				.addCloseButton("Return to Main Menu", 38, 185, 338, 53, "menu");

		frameChangePassword.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter New Password:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 70, 166, 40);
		frameChangePassword.getContentPane().add(lblNewLabel);
		
		newPassword = new JPasswordField();
		newPassword.setBounds(197, 82, 124, 20);
		frameChangePassword.getContentPane().add(newPassword);
		newPassword.setColumns(10);
		
		JLabel lblEnterOldPassword = new JLabel("Enter Old Password:");
		lblEnterOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterOldPassword.setBounds(44, 27, 137, 40);
		frameChangePassword.getContentPane().add(lblEnterOldPassword);
		
		oldPassword = new JPasswordField();
		oldPassword.setColumns(10);
		oldPassword.setBounds(197, 39, 124, 20);
		frameChangePassword.getContentPane().add(oldPassword);
		
		frameChangePassword.addPasswordButton("Change Password", 38, 121, 338, 53, "passwordStatus", newPassword, oldPassword);
	}
}
