package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;


public class TransferStatus{

	JFrame frameTransferStatus;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferStatus window = new TransferStatus();
					window.frameTransferStatus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TransferStatus() {
		initialize();
		
	}
	private void menuWindow() {
	Menu window = new Menu();
	window.frameMenu.setVisible(true);
	}
	
	private void initialize() {
		
		frameTransferStatus = new JFrame();
		frameTransferStatus.setBounds(100, 100, 450, 300);
		frameTransferStatus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTransferStatus.getContentPane().setLayout(null);
		
		JButton closeFrameButton = new JButton("Return to Main Menu");
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameTransferStatus.dispose();
				menuWindow();
			}
		});
		closeFrameButton.setBounds(44, 155, 338, 53);
		frameTransferStatus.getContentPane().add(closeFrameButton);
		
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