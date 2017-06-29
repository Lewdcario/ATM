package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu {

	JFrame frameMenu;

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	private void depositMenu() {
		Deposit window = new Deposit();
		window.frameDeposit.setVisible(true);
	}

	private void withdrawMenu() {
		Withdraw window = new Withdraw();
		window.frameWithdraw.setVisible(true);
	}

	private void CheckBalanceMenu() {
		CheckBalance window = new CheckBalance();
		window.frameCheckBalance.setVisible(true);
	}

	private void ChangePasswordMenu() {
		ChangePassword window = new ChangePassword();
		window.frameChangePassword.setVisible(true);
	}

	private void TransferMenu() {
		Transfer window = new Transfer();
		window.frameTransfer.setVisible(true);
	}

	private void LoginMenu() {
		Login window = new Login();
		window.frameLoginMenu.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frameMenu = new CustomFrame();
		
		// frameMenu.setBounds(100, 100, 450, 300);
		// frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMenu.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Deposit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameMenu.dispose();
				depositMenu();
			}
		});
		btnNewButton.setBounds(24, 30, 128, 51);
		frameMenu.getContentPane().add(btnNewButton);
		
		JButton btnCheckBalance = new JButton("Check Balance");
		btnCheckBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameMenu.dispose();
				CheckBalanceMenu();
			}
		});
		btnCheckBalance.setBounds(24, 92, 128, 51);
		frameMenu.getContentPane().add(btnCheckBalance);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameMenu.dispose();
				ChangePasswordMenu();
			}
		});
		btnChangePassword.setBounds(24, 157, 128, 51);
		frameMenu.getContentPane().add(btnChangePassword);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameMenu.dispose();
				withdrawMenu();
			}
		});
		btnWithdraw.setBounds(162, 30, 128, 51);
		frameMenu.getContentPane().add(btnWithdraw);
		
		JButton btnMakeATransfer = new JButton("Make a Transfer");
		btnMakeATransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameMenu.dispose();
				TransferMenu();
			}
		});
		btnMakeATransfer.setBounds(162, 92, 128, 51);
		frameMenu.getContentPane().add(btnMakeATransfer);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameMenu.dispose();
				LoginMenu();
			}
		});
		btnLogout.setBounds(162, 157, 128, 51);
		frameMenu.getContentPane().add(btnLogout);
	}
}
