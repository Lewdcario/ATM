package window;

import java.awt.Font;

import javax.swing.JLabel;

public class DepositStatus{

	CustomFrame frameDeposit2;

	/**
	 * Create the application.
	 */
	public DepositStatus() {
		initialize();
	}
	
	private void initialize() {
		
		frameDeposit2 = new CustomFrame()
				.addCloseButton("Return to Main menu", 44, 155, 338, 53, "menu");

		frameDeposit2.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Deposit Successful.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(44, 57, 158, 59);
		frameDeposit2.getContentPane().add(lblNewLabel);
		
		JLabel lblExample = new JLabel("New Balance$: "+CustomFrame.session.getBalance());
		lblExample.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExample.setBounds(212, 57, 158, 59);
		frameDeposit2.getContentPane().add(lblExample);
		
	}
}
