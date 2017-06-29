package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Menu {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}
	
	/*
	 * Second "frame" code should be here
	 * Likely, every button will need to be similar to this, as they invoke a new window, but 
	 * they need to be able to return to the original frame after success.
	 */
	private void secondFrame() {
		frame.setVisible(false); // Hides everything with the first frame
		
		JFrame frame = new JFrame("Test");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTest = new JLabel("Frame 2");
		lblTest.setBounds(21, 73, 177, 64);
		frame.getContentPane().add(lblTest);
		
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Initializing first frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTest = new JLabel("Username");
		lblTest.setBounds(32, 44, 125, 26);
		frame.getContentPane().add(lblTest);
		
		JLabel label = new JLabel("Password");
		label.setBounds(32, 96, 125, 26);
		frame.getContentPane().add(label);
			
		textField = new JTextField();
		textField.setBounds(178, 44, 186, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 93, 186, 29);
		frame.getContentPane().add(passwordField);
		
		JButton closeFrameButton = new JButton("click me to close this frame");
		// Start second frame, login successful, will probably have to manually code buttons to go in other frames
		closeFrameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("button clicked!");
				secondFrame();
			}
		});
		closeFrameButton.setBounds(44, 155, 338, 53);
		frame.getContentPane().add(closeFrameButton);
	}
}
