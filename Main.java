import javax.swing.JFrame;

public class Main {

	public Main() {
		
		JFrame frame = new JFrame();
		JFrame score = new JFrame();
		Gamepanel gamepanel = new Gamepanel();
		ScoreFrame scoreFrame = new ScoreFrame();
		
		frame.add(gamepanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("SNAKE");
		
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		
		
	}
	public static void main(String[] args) {
		
		new Main();
		
	}

}
