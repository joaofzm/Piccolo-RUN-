package br.com.joaofzm15.piccolo.ui.uiEntities;

import java.awt.Color;
import java.awt.Font;

public class PauseWarning {
	
	private Label label;
	public Label getLabel() {
		return label;
	}
	
	public PauseWarning(int x, int y, int xSize, int ySize) {
		label = new Label(x,y,xSize,ySize );
		label.getJComponent().setText("PAUSED");
		label.getJComponent().setFont(new Font("Impact",Font.BOLD, 70));
		label.getJComponent().setForeground(new Color(255,255,255));
	}

}
