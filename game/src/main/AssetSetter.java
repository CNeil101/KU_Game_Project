package main;

import object.Apple;
import object.Wall;

import java.util.Random;

public class AssetSetter {

	GamePanel gp;
	Random random;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
		this.random = new Random();
	}
	
	public void setObject() {
		
		gp.obj[0] = new Apple();
		gp.obj[0].worldX = 20 * gp.tileSize;
		gp.obj[0].worldY = 14 * gp.tileSize;
		gp.obj[0].side = "left";
		
		gp.obj[1] = new Apple();
		gp.obj[1].worldX = 48 * gp.tileSize;
		gp.obj[1].worldY = 14 * gp.tileSize;
		gp.obj[1].side = "right";
	}
	
	public void setWall(int i) {
		
		gp.obj[i] = new Wall();
		
	}
	
	public void setObjectRandom(int index) {
		if(gp.obj[index].side.equals("left")) {
			gp.obj[index].worldX = (random.nextInt(25) * gp.tileSize) + 2 * gp.tileSize;
			gp.obj[index].worldY = (random.nextInt(25) * gp.tileSize) + 2 * gp.tileSize;
			
		}
		
		else if(gp.obj[index].side.equals("right")) {
			gp.obj[index].worldX = (random.nextInt(25) * gp.tileSize) + 30 * gp.tileSize;
			gp.obj[index].worldY = (random.nextInt(25) * gp.tileSize) + 2 * gp.tileSize;
			
		}
		
	}
	
}
