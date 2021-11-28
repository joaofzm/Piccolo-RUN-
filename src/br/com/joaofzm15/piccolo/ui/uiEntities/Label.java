package br.com.joaofzm15.piccolo.ui.uiEntities;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Label implements Component  {

	private JLabel label;
	
	public Label(int x, int y, int xSize, int ySize, String imageURL) {
		label = new JLabel();
		Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(imageURL));
		label.setIcon(icon);
		label.setBounds(x,y,xSize,ySize);
		label.setBorder(border);
	}
	
	
	public JLabel getJComponent() {
		return label;
	}
	
	public void setVisible() {
		label.setVisible(true);
	}
	
	public void setInvisible() {
		label.setVisible(false);
	}
}
