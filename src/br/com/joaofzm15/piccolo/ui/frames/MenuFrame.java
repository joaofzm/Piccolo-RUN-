package br.com.joaofzm15.piccolo.ui.frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import br.com.joaofzm15.piccolo.ui.uiEntities.Button;
import br.com.joaofzm15.piccolo.ui.uiEntities.Frame;

public class MenuFrame extends JFrame implements ActionListener {
	
	private Frame frame;
	private Button startButton;
	private Button scoresButton;
	private Button optionsButton;
	private Button exitButton;

	public MenuFrame() {

		frame = new Frame("menuBackground.gif");
		
		startButton = new Button(780,280,300,100,"P L A Y",0,153,0,66);
		frame.add(startButton);
		
		scoresButton = new Button(805, 430, 250, 50,"H I G H    S C O R E S",102, 0, 204,22);
		frame.add(scoresButton);
		
		optionsButton = new Button(830, 530, 200, 50,"O P T I O N S",0, 210, 210,22);
		frame.add(optionsButton);

		exitButton = new Button(855, 630, 150, 50,"E X I T",204, 0, 0,22);
		frame.add(exitButton);

		frame.makeFrameVisible();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		new Thread(new ClickSound()).start();

//		if (e.getSource() == startButton) {
//			loading.setVisible(true);
//			startButton.setEnabled(false);
//			optionsButton.setEnabled(false);
//			exitButton.setEnabled(false);
//			new Thread() {
//				public void run() {
//					new GameFrame();
//					frame.dispose();
//				}
//			}.start();
//		}
//
//		if (e.getSource() == optionsButton) {
//			
//		}
//
//		if (e.getSource() == exitButton) {
//			try {Thread.sleep(900);} catch (InterruptedException e1) {e1.printStackTrace();}
//			System.exit(0);
//		}		

	}
	
}