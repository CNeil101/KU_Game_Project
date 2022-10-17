package main;

import entity.Entity;
import entity.Player;
import entity.Tail;

public class TailSetter {

	GamePanel gp;
	
	public TailSetter(GamePanel gp) {
		
		this.gp = gp;
		
	}
	
	public void setTail(Player player) {
		
		for(int i = 0; i < 4; i++) {
			
			player.tail[i] = new Tail(gp);
			player.tail[i].x = player.x  - (i * gp.tileSize);
			player.tail[i].y = 14 * gp.tileSize;
			
		}
			
	}
		
	
	public void setNewTail(int s, Player player) {
		
		s += 3;
		
		player.tail[s] = new Tail(gp);
		player.tail[s].x = player.tail[s - 1].x;
		player.tail[s].y = player.tail[s - 1].y;
			
		
	}
	
	
}
