package br.com.joaofzm15.piccolo.ui.uiEntities;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Piccolo {
	
	private Label label;
	private ImageIcon jumpingIcon;
	private ImageIcon runningIcon;
	private ImageIcon deadIcon;
	
	private boolean jumping;
	public boolean isJumping() {
		return jumping;
	}

	public Piccolo(int x, int y, int xSize, int ySize, String imageURL) {
		label = new Label(x,y,xSize,ySize,imageURL);
		jumpingIcon = new ImageIcon(getClass().getClassLoader().getResource("characterJumping.gif"));
		runningIcon = new ImageIcon(getClass().getClassLoader().getResource("characterRunning.gif"));
		deadIcon = new ImageIcon(getClass().getClassLoader().getResource("characterDead.png"));
	}
	
	public Label getLabel() {
		return label;
	}
	
	public void jump() {
		if (!jumping) {
			jumping=true;
			label.getJComponent().setBounds(150,394,208,339);
			label.getJComponent().setIcon(jumpingIcon);
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			        		label.getJComponent().setBounds(150,597,173,129);
			        		label.getJComponent().setIcon(runningIcon);
			    			jumping=false;
			            }
			        }, 
			        1015 
			);
		}
	}
	
	public void die() {
		label.getJComponent().setBounds(150,567,206,171);
		label.getJComponent().setIcon(deadIcon);
	}
}
