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
	
	public static class SpecialWindow {
		public static void run(String type) {
			try {
				SpecialWindow.class.getDeclaredMethod(type).invoke(SpecialWindow.class, (Object[]) null);
			} catch (Exception e) {
				Error.print(Thread.currentThread().getStackTrace()[1], 6);
				e.printStackTrace();
			}
		}
		public static void menu() {
			new Menu().frameMenu.setVisible(true);
		}
		
		public static void deposit() {
			new Deposit().frameDeposit.setVisible(true);
		}
		
		public static void deposit2() {
			new Deposit2().frameDeposit2.setVisible(true);
		}
		
		public static void withdraw() {
			new Withdraw().frameWithdraw.setVisible(true);
		}
		
		public static void withdraw2() {
			new Withdraw2().frameWithdraw2.setVisible(true);
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
	
	public CustomFrame addCloseButton(String title, int x, int y, int width, int height, String type) {
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
	
	public void addPasswordButton(String title, int x, int y, int width, int height, String type, JPasswordField pass) {
		JButton closeFrameButton = new JButton(title);
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] password = { 'b', 'u', 'g', 'a', 'b', 'o', 'o' };
				
				if (isPasswordCorrect(pass.getPassword(), password)) {
					dispose();
					SpecialWindow.run(type);
				}
				else {
					Error.display(5);
				}
			}
		});

		closeFrameButton.setBounds(x, y, width, height);
		this.getContentPane().add(closeFrameButton);
	}
	
	public void addLoginButton(String title, int x, int y, int width, int height, String type, JTextField user, JPasswordField pass) {
		JButton closeFrameButton = new JButton(title);
		closeFrameButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account loggedIn = null;
				// TODO: actually get password from FileManager, which is included in the Account class.
				// *** LOGIN INFO: user: 1111, password: group2
				try {
					loggedIn = new Account(user.getText());
					// pass#getText() wont be used, but rather, our password checker function available in this file.
					if (pass.getText().equals("group2")) {
						dispose();
						SpecialWindow.run(type);
					}
					else throw new Exception();
				} catch (Exception e1) {
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
	
	
	public void addClearButton(String title, int x, int y, int width, int height, JTextField user, JPasswordField pass) {
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
	
	private static boolean isPasswordCorrect(char[] input, char[] correctPassword) {
		// https://docs.oracle.com/javase/tutorial/uiswing/components/passwordfield.html
	    boolean isCorrect = true;

	    if (input.length != correctPassword.length) isCorrect = false;
	    else isCorrect = Arrays.equals(input, correctPassword);

	    //Zero out the password.
	    Arrays.fill(correctPassword, '0');

	    return isCorrect;
	}

}
