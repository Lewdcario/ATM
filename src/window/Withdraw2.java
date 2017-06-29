package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class Withdraw2{

	JFrame frameWithdraw2;

	/**
	 * Create the application.
	 */
	public Withdraw2() {
		initialize();
	}

	private void menuWindow() {
		Menu window = new Menu();
		window.frameMenu.setVisible(true);
	}
	
	private void initialize() {
		
		frameWithdraw2 = new CustomFrame();
		// frameWithdraw2.setBounds(100, 100, 450, 300);
		// frameWithdraw2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton closeFrameButton = new JButton("Return to Main Menu");
		closeFrameButton.setBounds(44, 155, 338, 53);
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameWithdraw2.dispose();
				menuWindow();
			}
		});
		frameWithdraw2.getContentPane().setLayout(null);
		frameWithdraw2.getContentPane().add(closeFrameButton);
		
		JLabel lblNewLabel = new JLabel("You have deposited($) :");
		lblNewLabel.setBounds(79, 66, 158, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameWithdraw2.getContentPane().add(lblNewLabel);
		
		JLabel lblYourNewBalance = new JLabel("Your new balance is($):");
		lblYourNewBalance.setBounds(79, 107, 149, 27);
		lblYourNewBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameWithdraw2.getContentPane().add(lblYourNewBalance);
		
		JLabel label = new JLabel("EXAMPLE AMOUNT");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(245, 71, 158, 27);
		frameWithdraw2.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("EXAMPLE AMOUNT");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(245, 107, 158, 27);
		frameWithdraw2.getContentPane().add(label_1);
	}
}
