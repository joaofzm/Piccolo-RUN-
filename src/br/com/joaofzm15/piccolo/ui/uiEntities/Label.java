package br.com.joaofzm15.piccolo.ui.uiEntities;

import javax.swing.JLabel;

public class Label implements Component  {

	JLabel label;
	
	public Label() {
		label = new JLabel();
	}
	
	
	public JLabel getJComponent() {
		return label;
	}
}
