package br.com.joaofzm15.piccolo.ui.frames;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import br.com.joaofzm15.piccolo.ui.uiEntities.Frame;
import br.com.joaofzm15.piccolo.ui.uiEntities.Label;


public class GameFrame {
	
	private Frame frame;
	
	private Label character;
	
	private Label explosion;


	public GameFrame() {

		frame = new Frame("gameBackground.png");
		
		explosion=new Label(115, 420, 300, 300, "explosion.gif");
		explosion.setInvisible();
		frame.add(explosion);

		
		character=new Label(150, 597, 173, 129, "characterRunning.gif");
		frame.add(character);

		frame.makeFrameVisible();
		
	}

}



