package br.com.joaofzm15.piccolo.ui.uiEntities;

import javax.swing.ImageIcon;

public class Explosion {
	
	private Label label;
	private ImageIcon explosionIcon;
	
	public Explosion(int x, int y, int xSize, int ySize) {
		label = new Label(x,y,xSize,ySize );
		explosionIcon = new ImageIcon(getClass().getClassLoader().getResource("explosion.gif"));
	}

	public Label getLabel() {
		return label;
	}
	
	public void explode() {
		label.getJComponent().setBounds(130,485,224,254);
		label.getJComponent().setIcon(explosionIcon);
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		        		label.getJComponent().setIcon(null);
		            }
		        }, 
		        1100 
		);
		
	}
}
