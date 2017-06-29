package window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JPasswordField;

public class Login {

	JFrame frameLoginMenu;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setAppearance();
					Login window = new Login();
					
					window.frameLoginMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	private void menuWindow() {
		Menu window = new Menu();
		window.frameMenu.setVisible(true);
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

		// frameLoginMenu.setBounds(100, 100, 450, 300);
		// frameLoginMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton closeFrameButton = new JButton("Login");
		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameLoginMenu.dispose();
				menuWindow();
			}
		});
		closeFrameButton.setBounds(44, 155, 338, 53);
		frameLoginMenu.getContentPane().add(closeFrameButton);
	}
}