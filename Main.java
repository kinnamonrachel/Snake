import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main {
	
	private static  boolean space = false;
	
	public Main(){
		
		
		JFrame frame = new JFrame();
		//JFrame score = new JFrame();
		Gamepanel gamepanel = new Gamepanel();
		//ScoreFrame scoreFrame = new ScoreFrame();
		
		
		frame.add(gamepanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("SNAKE");
		
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		//score.add(scoreFrame);
		//score.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//score.setTitle("SCORE");
		
		//score.pack();
		//score.setVisible(true);
		//score.setLocation(900, 200);
		//score.setSize(new Dimension(250, 175));
		
		
	}
	public static void main(String[] args) {
		
		new Main();
		
	}
}
