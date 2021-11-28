package br.com.joaofzm15.piccolo.ui.uiEntities;

import java.awt.Color;
import java.awt.Font;

public class GameOverWarning {
	
	private Label label;
	public Label getLabel() {
		return label;
	}
	
	public GameOverWarning(int x, int y, int xSize, int ySize) {
		label = new Label(x,y,xSize,ySize );
		label.getJComponent().setText("Game over! 'R' to restart");
		label.getJComponent().setFont(new Font("Impact",Font.BOLD, 50));
		label.getJComponent().setForeground(new Color(255,255,255));
	}

}
