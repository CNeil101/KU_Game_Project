package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{

	
	final int originalTileSize = 8; //8x8
	final int scale = 3;
	public final int tileSize = originalTileSize * scale; //24x24
	
	public final int maxScreenCol = 57;
	public final int maxScreenRow = 29;
	public final int screenWidth = tileSize * maxScreenCol; //1128 pixels
	public final int screenHight = tileSize * maxScreenRow; //600 pixels
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public TileManager tileM = new TileManager(this);
	public CollisionChecker cChecker = new CollisionChecker(this);
	public Player player = new Player(this, keyH, 9, 14);
	public Player player2 = new Player(this, keyH, 37, 14);
	//public TailSetter tSetter = new TailSetter(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public SuperObject obj[] = new SuperObject[10];
	public UI ui = new UI(this);
	
	// FPS
	public int FPS = 5;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHight));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
	}
	
	public void setUpGame() {
		
		aSetter.setObject();
		player.tSetter.setTail(player);
		player2.tSetter.setTail(player2);
		
	}
	
	public void startGameThread() {
		
		while(keyH.startGame == false) {
			System.out.println();
		}
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		
		
		while(gameThread != null) {	
			currentTime = System.nanoTime();
				
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			
			lastTime = currentTime;
				
			if(delta >= 1) {
				update();
				repaint();
				delta--;
			}
				
			if(timer >= 1000000000) {
					
				timer = 0;
			}
				
		}
			
			
	}	

	
	public void update() {
		
		if(keyH.upPressed == true) {
			if(player.direction != "down") {
				player.direction = "up";
			}
		}
		
		else if(keyH.downPressed == true) {
			if(player.direction != "up") {
				player.direction = "down";	
			}
		}
		
		else if(keyH.leftPressed == true) {
			if(player.direction != "right") {
				player.direction = "left";	
			}
		}
		
		else if(keyH.rightPressed == true) {
			if(player.direction != "left") {
				player.direction = "right";
			}
		}
		
		player.update();
		
		if(keyH.p2UpPressed == true) {
			if(player2.direction != "down") {
				player2.direction = "up";
			}
		}
		
		else if(keyH.p2DownPressed == true) {
			if(player2.direction != "up") {
				player2.direction = "down";	
			}
		}
		
		else if(keyH.p2LeftPressed == true) {
			if(player2.direction != "right") {
				player2.direction = "left";	
			}
		}
		
		else if(keyH.p2RightPressed == true) {
			if(player2.direction != "left") {
				player2.direction = "right";
			}
		}
		
		player2.update();
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		// TILE
		tileM.draw(g2);
		
		// OBJECT
		for(int i = 0; i < obj.length; i++) {
			
			if(obj[i] != null) {
				
				obj[i].draw(g2, this);
				
			}
			
		}

		
		// PLAYER
		player.draw(g2, 1);
		player2.draw(g2, 2);
		
		//UI
		ui.draw(g2);
		
		
		g2.dispose();
		
		
	}
	
}
