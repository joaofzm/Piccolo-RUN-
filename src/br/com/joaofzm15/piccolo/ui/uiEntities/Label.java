package br.com.joaofzm15.piccolo.ui.uiEntities;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Label implements FrameComponent  {

	private JLabel label;
	
	public Label(int x, int y, int xSize, int ySize, String imageURL) {
		label = new JLabel();
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(imageURL));
		label.setIcon(icon);
		label.setBounds(x,y,xSize,ySize);
	}
	
	public Label(int x, int y, int xSize, int ySize) {
		label = new JLabel();
		label.setBounds(x,y,xSize,ySize);
	}
	
	public JLabel getJComponent() {
		return label;
	}
	
	public void setVisible(boolean value) {
		getJComponent().setVisible(value);
	}
}
