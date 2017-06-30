package window;

import java.awt.Font;

import javax.swing.JLabel;

public class PasswordStatus{

	CustomFrame framePasswordStatus;

	/**
	 * Create the application.
	 */
	public PasswordStatus() {
		initialize();
	}
	
	private void initialize() {
		framePasswordStatus = new CustomFrame().addCloseButton("Return to Main Menu", 44, 155, 338, 53, "menu");
		framePasswordStatus.getContentPane().setLayout(null);
		
		JLabel lblEnterOldPassword = new JLabel("New password set");
		lblEnterOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterOldPassword.setBounds(140, 62, 137, 40);
		framePasswordStatus.getContentPane().add(lblEnterOldPassword);
	}
}
