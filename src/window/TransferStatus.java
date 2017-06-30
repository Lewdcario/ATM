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
		
		frameTransferStatus = new CustomFrame().addCloseButton("Return to Main menu", 44, 155, 338, 53, "menu");
		frameTransferStatus.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("$$$$$$");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(44, 36, 63, 36);
		frameTransferStatus.getContentPane().add(lblNewLabel);
		
		JLabel lblTransferTo = new JLabel("Transfered to:");
		lblTransferTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTransferTo.setBounds(124, 36, 92, 36);
		frameTransferStatus.getContentPane().add(lblTransferTo);
		
		JLabel lblPersonex = new JLabel("PersonExample");
		lblPersonex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPersonex.setBounds(242, 36, 102, 36);
		frameTransferStatus.getContentPane().add(lblPersonex);
	}
}