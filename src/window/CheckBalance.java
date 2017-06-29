package window;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class CheckBalance{

	JFrame frameCheckBalance;

	/**
	 * Create the application.
	 */
	public CheckBalance() {
		initialize();
	}
	private void menuWindow() {
		Menu window = new Menu();
		window.frameMenu.setVisible(true);
	}
	
	private void initialize() {
		
		frameCheckBalance = new CustomFrame();
		// frameCheckBalance.setBounds(100, 100, 450, 300);
		frameCheckBalance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCheckBalance.getContentPane().setLayout(null);
		
		JButton closeFrameButton = new JButton("Return to Main Menu");
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCheckBalance.dispose();
				menuWindow();
			}
		});
		closeFrameButton.setBounds(44, 155, 338, 53);
		frameCheckBalance.getContentPane().add(closeFrameButton);
		
		JLabel lblYour = new JLabel("Your current balance is ($): ");
		lblYour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYour.setBounds(44, 47, 177, 45);
		frameCheckBalance.getContentPane().add(lblYour);
		
		JLabel label = new JLabel("EXAMPLE AMOUNT");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(238, 56, 158, 27);
		frameCheckBalance.getContentPane().add(label);
	}
}
