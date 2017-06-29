package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Transfer{

	JFrame frameTransfer;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transfer window = new Transfer();
					window.frameTransfer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Transfer() {
		initialize();
		
	}
	private void menuWindow() {
	Menu window = new Menu();
	window.frameMenu.setVisible(true);
	}
	private void TransferStatusMenu() {
	TransferStatus window = new TransferStatus();
	window.frameTransferStatus.setVisible(true);
	}
	
	private void initialize() {
		
		frameTransfer = new JFrame();
		frameTransfer.setBounds(100, 100, 450, 300);
		frameTransfer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTransfer.getContentPane().setLayout(null);
		
		JButton closeFrameButton = new JButton("Return to Main Menu");
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameTransfer.dispose();
				menuWindow();
			}
		});
		closeFrameButton.setBounds(44, 185, 338, 53);
		frameTransfer.getContentPane().add(closeFrameButton);
		
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
		
		JButton btnTransfering = new JButton("Transfer Funds");
		btnTransfering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameTransfer.dispose();
				TransferStatusMenu();
			}
		});
		btnTransfering.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTransfering.setBounds(44, 121, 338, 53);
		frameTransfer.getContentPane().add(btnTransfering);
	}
}
