package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

public class UI {

	GamePanel gp;
	Font arialFont;
	Font gFont;
	public boolean gameOver = false;
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.0");
	
	
	public UI(GamePanel gp) {
		this.gp = gp;
		arialFont = new Font("ARIAL", Font.PLAIN, 40);
		gFont = new Font("ARIAL", Font.BOLD, 80);
	}
	
	public void draw(Graphics2D g2) {
		
		int textLength;
		int x;
		int y;
		
		if(gameOver == true) {
			
			g2.setFont(gFont);
			g2.setColor(Color.black);
			
			String text = "Game Over";		
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); //returns the length of the text.
			
			x = (gp.screenWidth - textLength) / 2;
			y = gp.screenHight / 2;
			
			g2.drawString(text, x, y);
			
			g2.setFont(arialFont);
			
			
			// player 1 score
			
			textLength = (int)g2.getFontMetrics().getStringBounds("" + gp.player.score, g2).getWidth(); //returns the length of the text.
			x = (gp.screenWidth - textLength) / 5;
			y = gp.tileSize + 12;
			g2.drawString("Score: " + gp.player.score, x, y);
			
			// player 2 score
			
			textLength = (int)g2.getFontMetrics().getStringBounds("" + gp.player2.score, g2).getWidth(); //returns the length of the text.
			x = (gp.screenWidth - textLength) / 2 + (gp.screenWidth - textLength) / 5;
			y = gp.tileSize + 12;
			g2.drawString("Score: " + gp.player2.score, x, y);
			
			gp.gameThread = null;
			
		}
		
		else {
			
			g2.setFont(arialFont);
			g2.setColor(Color.black);
			
			// TIME
			textLength = (int)g2.getFontMetrics().getStringBounds("" + dFormat.format(playTime), g2).getWidth(); //returns the length of the text.
			
			x = (gp.screenWidth - textLength) / 2;
			y = gp.tileSize + 12;
			
			playTime += (double)1/gp.FPS; 
			g2.drawString("" + dFormat.format(playTime), x, y);
			
			// player1 score
			
			textLength = (int)g2.getFontMetrics().getStringBounds("" + gp.player.score, g2).getWidth(); //returns the length of the text.
			x = (gp.screenWidth - textLength) / 5;
			y = gp.tileSize + 12;
			g2.drawString("Score: " + gp.player.score, x, y);
			
			// player 2 score
			
			textLength = (int)g2.getFontMetrics().getStringBounds("" + gp.player2.score, g2).getWidth(); //returns the length of the text.
			x = (gp.screenWidth - textLength) / 2 + (gp.screenWidth - textLength) / 5;
			y = gp.tileSize + 12;
			g2.drawString("Score: " + gp.player2.score, x, y);
			
			
		}
		
	}
	
}
