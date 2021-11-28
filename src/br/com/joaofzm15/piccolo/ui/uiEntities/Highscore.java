package br.com.joaofzm15.piccolo.ui.uiEntities;

import java.awt.Color;
import java.awt.Font;

public class Highscore {
	
	private Label label;
	
	private static int currentHighScore;
	public static int getHighscore() {
		return currentHighScore;
	}
	public void setHighscore(int value) {
		currentHighScore=value;
		label.getJComponent().setText("High score: "+currentHighScore);
	}
	
	public Highscore(int x, int y, int xSize, int ySize) {
		label = new Label(x,y,xSize,ySize );
		label.getJComponent().setText("High score: "+currentHighScore);
		label.getJComponent().setFont(new Font("Impact",Font.BOLD, 30));
		label.getJComponent().setForeground(new Color(51,0,152));
	}
	

	
	public Label getLabel() {
		return label;
	}
}
