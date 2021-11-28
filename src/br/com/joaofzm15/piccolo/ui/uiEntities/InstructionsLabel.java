package br.com.joaofzm15.piccolo.ui.uiEntities;

import java.awt.Color;
import java.awt.Font;

public class InstructionsLabel {
	
		private Label label;

		public InstructionsLabel(int x, int y, int xSize, int ySize) {
			label = new Label(x,y,xSize,ySize );
			label.getJComponent().setText("Space bar = Jump | P = Pause | R = Restart");
			label.getJComponent().setFont(new Font("Impact",Font.BOLD, 30));
			label.getJComponent().setForeground(new Color(153,0,0));
		}
		
		public Label getLabel() {
			return label;
		}

}
