package window;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CustomFrame extends JFrame {

	private static final long serialVersionUID = -1165752864896879911L;
	private JPanel contentPane;
	
	public void setImage() {
		ImageIcon img = new ImageIcon("./src/assets/icon.png");
		this.setIconImage(img.getImage());
	}

	/**
	 * Create the frame.
	 */
	public CustomFrame() {
		// http://docs.oracle.com/javase/tutorial/uiswing/layout/using.html
		// You will want to use a layout manager so the buttons will auto-resize. Take a look.
		this.setImage();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Bank of University of Houston");
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
