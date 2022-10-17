package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	public boolean upPressed;
	public boolean downPressed;
	public boolean leftPressed;
	public boolean rightPressed;
	public boolean startGame = false;
	public boolean p2UpPressed;
	public boolean p2DownPressed;
	public boolean p2LeftPressed;
	public boolean p2RightPressed;
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_SPACE) {
			
			startGame = true;
			
		}
		
		if(code == KeyEvent.VK_W) {
			
			upPressed = true;
			
		}
		
		if(code == KeyEvent.VK_S) {
			
			downPressed = true;
			
		}
		
		if(code == KeyEvent.VK_A) {
			
			leftPressed = true;
			
		}
		
		if(code == KeyEvent.VK_D) {
			
			rightPressed = true;
			
		}
		
		if(code == KeyEvent.VK_I) {
			
			p2UpPressed = true;
			
		}
		
		if(code == KeyEvent.VK_K) {
			
			p2DownPressed = true;
			
		}
		
		if(code == KeyEvent.VK_J) {
			
			p2LeftPressed = true;
			
		}
		
		if(code == KeyEvent.VK_L) {
			
			p2RightPressed = true;
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_SPACE) {
			
			startGame = false;
			
		}
		
		if(code == KeyEvent.VK_W) {
			
			upPressed = false;
			
		}
		
		if(code == KeyEvent.VK_S) {
			
			downPressed = false;
			
		}
		
		if(code == KeyEvent.VK_A) {
			
			leftPressed = false;
			
		}
		
		if(code == KeyEvent.VK_D) {
			
			rightPressed = false;
			
		}
		
		if(code == KeyEvent.VK_I) {
			
			p2UpPressed = false;
			
		}
		
		if(code == KeyEvent.VK_K) {
			
			p2DownPressed = false;
			
		}
		
		if(code == KeyEvent.VK_J) {
			
			p2LeftPressed = false;
			
		}
		
		if(code == KeyEvent.VK_L) {
			
			p2RightPressed = false;
			
		}
		
	}

	
}
