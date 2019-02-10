import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;



public class Gamepanel extends JPanel implements Runnable, KeyListener{

	
	private int score = 0;
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 500, HEIGHT = 500;
	
	private Thread thread;
	
	private boolean running;
	private boolean right = true, left = false, up = false, down = false, space = false;
	
	private BodyPart b;
	private ArrayList<BodyPart> snake;
	
	private Apple apple;
	private ArrayList<Apple> apples;
	
	private Random r;
	
	private int xCoor = 10, yCoor = 10, size = 2;
	
	private int ticks = 0;
	
	
	public Gamepanel() {
		setFocusable(true);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(this);
		
		snake = new ArrayList<BodyPart>();
		apples = new ArrayList<Apple>();
		
		r = new Random();
		
		start();
	}
	
	
	
	public void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void tick() {
		if(snake.size() == 0) {
			b = new BodyPart(xCoor, yCoor, 25);
			snake.add(b);
		}
		ticks++;
		if(ticks > 600000) {
			if (right) xCoor++;
			if (left) xCoor--;
			if (up) yCoor--;
			if (down) yCoor++;
			
			ticks = 0;
			
			b = new BodyPart(xCoor, yCoor, 25);
			snake.add(b);
			
			if(snake.size() > size) {
				snake.remove(0);
			}
		}
		
		if(apples.size()==0) {
			int xCoor = r.nextInt(19);
			int yCoor = r.nextInt(19);
			
			apple = new Apple(xCoor, yCoor, 25);
			apples.add(apple);
		}
		
		for(int i = 0; i < apples.size(); i++) {
			if(xCoor == apples.get(i).getxCoor() && yCoor == apples.get(i).getyCoor()) {
				size++;
				apples.remove(i);
				i++;
				
				score++;
				System.out.println("Score: " + score);
			}
		}
		//collision with self
		for(int i = 0; i < snake.size(); i++) {
			if(xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor()) {
				if(i != snake.size() - 1) {
					System.out.println("Game Over");
					stop();
				}
			}
		}
		//collision on border
		if(xCoor < 0 || xCoor > 19 || yCoor < 0 || yCoor > 19) {
			System.out.println("Game Over");
			stop();
		}
		
		
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.GRAY);
		for(int i = 0; i < WIDTH/25; i++) {
			g.drawLine(i * 25, 0, i * 25, HEIGHT);
		}
		for(int i = 0; i < HEIGHT/25; i++) {
			g.drawLine(0, i * 25, HEIGHT, i * 25);
		}
		for (int i = 0; i < snake.size(); i++) {
			snake.get(i).draw(g);
		}
		for(int i = 0; i < apples.size(); i++) {
			apples.get(i).draw(g);
		}
	}



	@Override
	public void run() {
		while(running) {
			tick();
			repaint();
		}
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT && !left) {
			right = true;
			up = false;
			down = false;
		}
		if(key == KeyEvent.VK_LEFT && !right) {
			left = true;
			up = false;
			down = false;
		}
		if(key == KeyEvent.VK_UP && !down) {
			up = true;
			right = false;
			left = false;
		}
		if(key == KeyEvent.VK_DOWN && !up) {
			down = true;
			right = false;
			left = false;
		}
		if(key == KeyEvent.VK_SPACE) {
			space = true;
		}
	}



	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
