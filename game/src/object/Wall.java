package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Wall extends SuperObject {

	public Wall() { 
		
		name =  "wall";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/wall.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
