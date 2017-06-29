package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class PasswordStatus{

	JFrame framePasswordStatus;

	/**
	 * Create the application.
	 */
	public PasswordStatus() {
		initialize();
	}

	private void menuWindow() {
		Menu window = new Menu();
		window.frameMenu.setVisible(true);
	}
	
	private void initialize() {
		
		framePasswordStatus = new CustomFrame();
		// framePasswordStatus.setBounds(100, 100, 450, 300);
		// framePasswordStatus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePasswordStatus.getContentPane().setLayout(null);
		
		JButton closeFrameButton = new JButton("Return to Main Menu");
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framePasswordStatus.dispose();
				menuWindow();
			}
		});
		closeFrameButton.setBounds(44, 155, 338, 53);
		framePasswordStatus.getContentPane().add(closeFrameButton);
		
		JLabel lblEnterOldPassword = new JLabel("New password set");
		lblEnterOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterOldPassword.setBounds(140, 62, 137, 40);
		framePasswordStatus.getContentPane().add(lblEnterOldPassword);
	}
}
