package window;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bank.Account;
import bank.Error;

public class CustomFrame extends JFrame {

	private static final long serialVersionUID = -1165752864896879911L;
	private JPanel contentPane;
	static Account session;
	
	private void setSession(Account session) {
		CustomFrame.session = session;
	}
	
	public Account getSession() {
		return CustomFrame.session;
	}
	
	public static class SpecialWindow {
		public static void run(String type) {
			/*
			try {
				SpecialWindow.class.getDeclaredMethod(type).invoke(SpecialWindow.class, (Object[]) null);
			} catch (Exception e) {
				Error.print(Thread.currentThread().getStackTrace()[1], 6);
				e.printStackTrace();
			}
			*/
			if (type == "menu") menu();
			else if (type == "deposit") deposit();
			else if (type == "deposit2") deposit2();
			else if (type == "withdraw") withdraw();
			else if (type == "withdraw2") withdraw2();
			else if (type == "balance") balance();
			else if (type == "password") password();
			else if (type == "passwordStatus") passwordStatus();
			else if (type == "transfer") transfer();
			else if (type == "transferStatus") transferStatus();
			else if (type == "login") login();
		}
		public static void menu() {
			new Menu().frameMenu.setVisible(true);
		}
		
		public static void deposit() {
			new Deposit().frameDeposit.setVisible(true);
		}
		
		public static void deposit2() {
			new DepositStatus().frameDeposit2.setVisible(true);
		}
		
		public static void withdraw() {
			new Withdraw().frameWithdraw.setVisible(true);
		}
		
		public static void withdraw2() {
			new WithdrawStatus().frameWithdraw2.setVisible(true);
		}
		
		public static void balance() {
			new CheckBalance().frameCheckBalance.setVisible(true);
		}
		
		public static void password() {
			new ChangePassword().frameChangePassword.setVisible(true);
		}
		
		public static void passwordStatus() {
			new PasswordStatus().framePasswordStatus.setVisible(true);
		}
		
		public static void transfer() {
			new Transfer().frameTransfer.setVisible(true);
		}
		
		public static void transferStatus() {
			new TransferStatus().frameTransferStatus.setVisible(true);
		}
		
		public static void login() {
			new Login().frameLoginMenu.setVisible(true);
		}
	}

	/**
	 * Create the frame.
	 */
	public CustomFrame() {
		// http://docs.oracle.com/javase/tutorial/uiswing/layout/using.html
		// You will want to use a layout manager so the buttons will auto-resize. Take a look.
		this.setImage();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("UH Bank");
		this.setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(contentPane);
	}
	
	public void setImage() {
		ImageIcon img = new ImageIcon("./src/assets/icon.png");
		this.setIconImage(img.getImage());
	}
	
	public CustomFrame addCloseButton(String title, int x, int y, int width, int height, final String type) {
		JButton closeFrameButton = new JButton(title);
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SpecialWindow.run(type);
			}
		});

		closeFrameButton.setBounds(x, y, width, height);
		this.getContentPane().add(closeFrameButton);
		
		return this;
	}
	
	public void addPasswordButton(String title, int x, int y, int width, int height, final String type, final JPasswordField newPass, final JPasswordField oldPass) {
		JButton closeFrameButton = new JButton(title);
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkPassword(oldPass.getPassword(), session.getPassword())) {
					dispose();
					SpecialWindow.run(type);
					session.getCredentials().changePassword(newPass.getPassword());
				}
				else {
					Error.display(5);
					JOptionPane.showMessageDialog(null, "Invalid Password", "Password Update Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});

		closeFrameButton.setBounds(x, y, width, height);
		this.getContentPane().add(closeFrameButton);
	}
	
	public void addLogoutButton(String title, int x, int y, int width, int height) {
		JButton closeFrameButton = new JButton(title);
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSession(null);
				dispose();
				SpecialWindow.run("login");
			}
		});

		closeFrameButton.setBounds(x, y, width, height);
		this.getContentPane().add(closeFrameButton);
	}
	
	public void addLoginButton(String title, int x, int y, int width, int height, final String type, final JTextField user, final JPasswordField pass) {
		JButton closeFrameButton = new JButton(title);
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Account loggedIn = null;
				try {
					loggedIn = new Account(user.getText());
					if (checkPassword(loggedIn.getPassword(), pass.getPassword())) {
						dispose();
						SpecialWindow.run(type);
						setSession(loggedIn);
					}
					else throw new Exception();
				} catch (Exception e) {
					Error.display(5);
					JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE); 
                    user.setText(null); 
                    pass.setText(null); 
				}	
			}
		});

		closeFrameButton.setBounds(x, y, width, height);
		this.getContentPane().add(closeFrameButton);
	}
	
	public void depositMath(String title, int x, int y, int width, int height, final String type, final JTextField depositAmount) {
		JButton closeFrameButton = new JButton(title);
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				session.addMoney(Integer.parseInt(depositAmount.getText()));
				dispose();
				SpecialWindow.run(type);
			}
		});
		closeFrameButton.setBounds(x, y, width, height);
		this.getContentPane().add(closeFrameButton);
	}
	
	public void transferMoney(String title, int x, int y, int width, int height, final String type, final JTextField depositAmount, final JTextField targetUser) {
		JButton closeFrameButton = new JButton(title);
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
	
		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Account target = new Account(targetUser.getText());
					try {
						session.transferMoney(target, Integer.parseInt(depositAmount.getText()));
						dispose();
						SpecialWindow.run(type);
					} catch(Exception error) {
						Error.display(4);
						JOptionPane.showMessageDialog(null, "You do not have the sufficient funds to perform this transaction", "Insufficient Funds Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					Error.display(3);
					JOptionPane.showMessageDialog(null, "Target user does not exist", "No Such User Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		closeFrameButton.setBounds(x, y, width, height);
		this.getContentPane().add(closeFrameButton);
	}
	
	public void withdrawMath(String title, int x, int y, int width, int height, final String type, final JTextField withdrawAmount) {
	JButton closeFrameButton = new JButton(title);
	closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

	closeFrameButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				try {
					session.removeMoney(Integer.parseInt(withdrawAmount.getText()));
					dispose();
					SpecialWindow.run(type);
				} catch (Exception error) {
					Error.display(4);
					JOptionPane.showMessageDialog(null, "Insufficient Funds", "Withdraw Error", JOptionPane.ERROR_MESSAGE); 
				}
		}
	});
	closeFrameButton.setBounds(x, y, width, height);
	this.getContentPane().add(closeFrameButton);
}
	
	public void addClearButton(String title, int x, int y, int width, int height, final JTextField user, final JPasswordField pass) {
		JButton btnReset = new JButton(title);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					user.setText(null);
					pass.setText(null); 
				}
			});

		btnReset.setBounds(242, 184, 113, 35);
		this.getContentPane().add(btnReset); 
	}
	
	private static boolean checkPassword(char[] input, char[] correctPassword) {
		// https://docs.oracle.com/javase/tutorial/uiswing/components/passwordfield.html
	    boolean isCorrect = true;

	    if (input.length != correctPassword.length) isCorrect = false;
	    else isCorrect = Arrays.equals(input, correctPassword);

	    //Zero out the password.
	    Arrays.fill(correctPassword, '0');

	    return isCorrect;
	}

}
