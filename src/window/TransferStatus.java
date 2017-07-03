package window;

import java.awt.Font;

import javax.swing.JLabel;

public class TransferStatus{

	CustomFrame frameTransferStatus;

	/**
	 * Create the application.
	 */
	public TransferStatus() {
		initialize();
	}
	
	private void initialize() {
		
		frameTransferStatus = new CustomFrame()
				.addCloseButton("Return to Main menu", 44, 155, 338, 53, "menu");

		frameTransferStatus.getContentPane().setLayout(null);
		
		JLabel lblTransferTo = new JLabel("Success!");
		lblTransferTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTransferTo.setBounds(124, 36, 92, 36);
		frameTransferStatus.getContentPane().add(lblTransferTo);
		
		JLabel lblPersonex = new JLabel("New Balance: $" + frameTransferStatus.getSession().getBalance());
		lblPersonex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPersonex.setBounds(200, 36, 150, 36);
		frameTransferStatus.getContentPane().add(lblPersonex);
	}
}