package br.com.joaofzm15.piccolo.ui.uiEntities;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Blast {
	
	private Label label;
	private ImageIcon blastIcon;
	
	public Blast(int x, int y, int xSize, int ySize,String iconURL) {
		label = new Label(x,y,xSize,ySize, iconURL);
	}
	
	public Label getLabel() {
		return label;
	}
}
