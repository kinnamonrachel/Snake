import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ScoreFrame extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private int WIDTH = 250;
	private int HEIGHT = 175;
	
	int score = 0;
	
	public void ScoreFrame() {
		setFocusable(true);
		
		setSize(new Dimension(WIDTH, HEIGHT));
		
	}
	
	//public void paint(Graphics g) {
		//g.clearRect(0, 0, WIDTH, HEIGHT);
		//g.setColor(Color.BLACK);
		//g.fillRect(0, 0, WIDTH, HEIGHT);
		//g.setColor(Color.WHITE);
		
		/*for(int i = 0; i < WIDTH/25; i++) {
			g.drawLine(i * 25, 0, i * 25, HEIGHT);
		}
		for(int i = 0; i < HEIGHT/25; i++) {
			g.drawLine(0, i * 25, HEIGHT, i * 25);
		}*/
		
		//g.drawString("SCORE: " + score, 88, 88);
	//}
	
	
}