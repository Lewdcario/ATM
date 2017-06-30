package window;

import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Login {

	CustomFrame frameLoginMenu;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
	
	public static void setAppearance() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Initializing first frame
		frameLoginMenu = new CustomFrame();

		frameLoginMenu.getContentPane().setLayout(null);
		
		JLabel lblTest = new JLabel("Username");
		lblTest.setBounds(32, 44, 125, 26);
		frameLoginMenu.getContentPane().add(lblTest);
		
		JLabel label = new JLabel("Password");
		label.setBounds(32, 96, 125, 26);
		frameLoginMenu.getContentPane().add(label);
			
		textField = new JTextField();
		textField.setBounds(178, 44, 186, 29);
		frameLoginMenu.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 93, 186, 29);
		frameLoginMenu.getContentPane().add(passwordField);
		
		frameLoginMenu.addLoginButton("Login", 44, 155, 338, 53, "menu", textField, passwordField);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setAppearance();
					new Login().frameLoginMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}