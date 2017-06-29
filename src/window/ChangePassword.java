package window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ChangePassword{

	JFrame frameChangePassword;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword window = new ChangePassword();
					window.frameChangePassword.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChangePassword() {
		initialize();
		
	}
	private void menuWindow() {
		Menu window = new Menu();
		window.frameMenu.setVisible(true);
	}
	
	private void PasswordStatusMenu() {
	PasswordStatus window = new PasswordStatus();
	window.framePasswordStatus.setVisible(true);
	}
	
	private void initialize() {
		
		frameChangePassword = new CustomFrame();
		// frameChangePassword.setBounds(100, 100, 450, 300);
		frameChangePassword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameChangePassword.getContentPane().setLayout(null);
		
		JButton closeFrameButton = new JButton("Return to Main Menu");
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameChangePassword.dispose();
				menuWindow();
			}
		});
		closeFrameButton.setBounds(38, 185, 338, 53);
		frameChangePassword.getContentPane().add(closeFrameButton);
		
		JLabel lblNewLabel = new JLabel("Enter New Password:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 70, 166, 40);
		frameChangePassword.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(197, 82, 124, 20);
		frameChangePassword.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterOldPassword = new JLabel("Enter Old Password:");
		lblEnterOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterOldPassword.setBounds(44, 27, 137, 40);
		frameChangePassword.getContentPane().add(lblEnterOldPassword);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(197, 39, 124, 20);
		frameChangePassword.getContentPane().add(textField_1);
		
		JButton btnReturnToMain = new JButton("Change Password");
		btnReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameChangePassword.dispose();
				PasswordStatusMenu();
			}
		});
		btnReturnToMain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReturnToMain.setBounds(38, 121, 338, 53);
		frameChangePassword.getContentPane().add(btnReturnToMain);
	}
}
