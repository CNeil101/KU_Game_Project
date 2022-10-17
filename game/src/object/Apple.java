package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Apple extends SuperObject{

	public Apple() {
		
		name = "Apple";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/apple.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
