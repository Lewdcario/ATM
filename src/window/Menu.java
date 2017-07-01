package window;

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
				.addCloseButton("Deposit", 45, 36, 130, 35, "deposit")
				.addCloseButton("Check Balance", 45, 106, 130, 35, "balance")
				.addCloseButton("Change Password", 45, 182, 130, 35, "password")
				.addCloseButton("Withdraw", 241, 36, 122, 35, "withdraw")
				.addCloseButton("Transfer", 241, 106, 122, 35, "transfer");

		frameMenu.addLogoutButton("Logout", 241, 182, 122, 35);

		frameMenu.getContentPane().setLayout(null);
	}
}
