package entity;

import java.awt.Graphics2D;
//import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.TailSetter;
//import sun.tools.tree.ThisExpression;


public class Player extends Entity{

	KeyHandler keyH;

	
	public int score = 0;
	public int score2 = 0;
	public int tempX;
	public int tempY;
	public Tail tail[] = new Tail[20];
	public TailSetter tSetter = new TailSetter(gp);
	
	public Player(GamePanel gp, KeyHandler keyH, int x, int y) {
		
		super(gp);
		this.keyH = keyH;
		
		this.x = x * gp.tileSize;
		this.y = y * gp.tileSize;
		
		setDefaultValues();
		getPlayerImage();

	}
	
	public void setDefaultValues() {
		
		speed = 24;
		direction = "right";
	}
	
	public void getPlayerImage() {
		try {
			
			snake = ImageIO.read(getClass().getResourceAsStream("/player/snake.png"));
			
		}
		catch(IOException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public void update() {
		
		//if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
			
			// check tile collision
			
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			// check object collision
			int objIndex = gp.cChecker.checkObject(this, true);

			pickUpObject(objIndex);
			
			// check tail collision
			int tailIndex = gp.cChecker.checkTail(this, this.tail);
			if(tailIndex != 999) {
				collisionOn = true;
			}
			
			
			//if collision is false player can move
			if(collisionOn == false) {
				
				tempX = x;
				tempY = y;
				switch(direction) {
				case "up":
					y -= speed;
					break;
					
				case "down":
					y += speed;
					break;
					
				case "left":
					x -= speed;
					break;
					
				case "right":
					x += speed;
					break;
			
				}
				
				
				for(int i = this.tail.length - 1; i > 0; i--) {
					if(this.tail[i] != null) {
						this.tail[i].x = this.tail[i - 1].x;
						this.tail[i].y = this.tail[i - 1].y;
						
					}

				}
				this.tail[0].x = tempX;
				this.tail[0].y = tempY;
				
				
			}
			
			else {
				
				gp.ui.gameOver = true;
				
				
			}
			
		//}
		
	}
	
	public void draw(Graphics2D g2, int num) {
		
		BufferedImage image = null;
		
		image = snake;
		
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
			for(int i = 0; i < this.tail.length; i++) {
				if(this.tail[i] != null) {
					g2.drawImage(image, this.tail[i].x, this.tail[i].y, gp.tileSize, gp.tileSize, null);
				}
		}
		
	}
		
	
	public void pickUpObject(int index) {
		
		if(index != 999) {
			
			String objectName = gp.obj[index].name;
			
			switch(objectName) {
			case "Apple": 
				score++;
				tSetter.setNewTail(score, this);
				
				gp.aSetter.setObjectRandom(index);
				if(score % 5 == 0) {
					
					for(int i = 2; i < gp.obj.length; i++) {
						if(gp.obj[i] == null) {
							gp.aSetter.setWall(i);
							if(this.equals(gp.player)) {
								gp.obj[i].side = "right";
							}
							else {
								gp.obj[i].side = "left";
							}
							gp.aSetter.setObjectRandom(i);
							gp.obj[i].collision = true;
							break;
						}
						
					}
					
				}
				break;
				
			case "wall":
				collisionOn = true;
				break;
			}
			
		}
		
	}
}
