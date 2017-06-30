package window;

import javax.swing.JFrame;

public class Menu {

	CustomFrame frameMenu;

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMenu = new CustomFrame()
				.addCloseButton("Deposit", 24, 30, 128, 51, "deposit")
				.addCloseButton("Check Balance", 24, 92, 128, 51, "balance")
				.addCloseButton("Change Password", 24, 157, 128, 51, "password")
				.addCloseButton("Withdraw", 162, 30, 128, 51, "withdraw")
				.addCloseButton("Transfer", 162, 92, 128, 51, "transfer")
				.addCloseButton("Logout", 162, 157, 128, 51, "login");

		frameMenu.getContentPane().setLayout(null);
	}
}
