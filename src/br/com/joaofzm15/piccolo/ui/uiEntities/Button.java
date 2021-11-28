package br.com.joaofzm15.piccolo.ui.uiEntities;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Button implements Component {

	JButton button;
	
	public JButton getJComponent() {
		return button;
	}
	
	public Button(int x, int y, int xSize, int ySize, String text, int red, int green, int blue, int fontSize) {
		button = new JButton();
		button.setBounds(x, y, xSize , ySize);
		button.setText(text);
		button.setFont(new Font("Impact",Font.BOLD, fontSize));
		button.setForeground(Color.white);
		button.setBackground(new Color(red, green, blue));
		button.setBorder(BorderFactory.createLineBorder(Color.white));
		button.setFocusable(false);
	}
}
