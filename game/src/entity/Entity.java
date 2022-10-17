package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity {

	GamePanel gp;
	public int x, y;
	public int speed;
	public BufferedImage snake;
	public String direction;
	public Rectangle solidArea = new Rectangle(x + 12, y + 12, 4, 4);
	public boolean collisionOn = false;
	//public Tail tail[] = new Tail[20];
	
	public int solidAreaDefaultX, solidAreaDefaultY;
	
	public Entity(GamePanel gp) {
		
		this.gp = gp;
		
	}
	
}
