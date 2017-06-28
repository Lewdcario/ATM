package testPackage;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphicx extends JFrame {
	public Graphicx() {
		setLayout(new BorderLayout());
		add(new DrawPyramid(), BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		Graphicx frame = new Graphicx();
		frame.setSize(400, 400);
		frame.setTitle("example155");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // center frame
		frame.setVisible(true);
	}
	
	// Inner class
	class DrawPyramid extends JPanel {
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			setFont(new Font("SansSerif", Font.BOLD, 17));
			
			int width = this.getWidth();
			int height = this.getHeight();
			
			int xInterval = 20;
			int yInterval = 20;
			int x = 10, y = 10;
			
			for (int row = 1; row <= 1 + (height - 20) / 20; row++) {
				for (int column = 1; column < row; column++) {
					g.drawString(column + "", x, y);
					x += 20;
				}
				y += 20;
				x = 20;
			}
		}
	}
}
