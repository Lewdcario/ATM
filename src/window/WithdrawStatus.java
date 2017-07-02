package window;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class WithdrawStatus{

	CustomFrame frameWithdraw2;

	/**
	 * Create the application.
	 */
	public WithdrawStatus() {
		initialize();
	}
	
	private void initialize() {
		
		frameWithdraw2 = new CustomFrame()
				.addCloseButton("Return to Main menu", 44, 155, 338, 53, "menu");
		
		frameWithdraw2.getContentPane().setLayout(null);
		
		JButton closeFrameButton = new JButton("Return to Main Menu");
		closeFrameButton.setBounds(44, 155, 338, 53);
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("Withdraw Sucessful.");
		lblNewLabel.setBounds(79, 66, 158, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameWithdraw2.getContentPane().add(lblNewLabel);
		
		JLabel lblYourNewBalance = new JLabel("New Balance$: "+CustomFrame.session.getBalance());
		lblYourNewBalance.setBounds(79, 107, 149, 27);
		lblYourNewBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameWithdraw2.getContentPane().add(lblYourNewBalance);
	}
}
