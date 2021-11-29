package br.com.joaofzm15.piccolo.ui.frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.joaofzm15.piccolo.ui.uiEntities.Button;
import br.com.joaofzm15.piccolo.ui.uiEntities.ClickSound;
import br.com.joaofzm15.piccolo.ui.uiEntities.Frame;
import br.com.joaofzm15.piccolo.ui.uiEntities.Label;

public class OptionsFrame implements ActionListener {

	private Frame frame;

	private Button mainMenu;
	
	private Button toggleAlternativeArtButton;
	
	public static boolean alternativeMenuArt = false;

	public OptionsFrame() {

		frame = new Frame("optionsBackground.png");
		
		mainMenu = new Button(320, 630, 150, 50, "MAIN MENU", 102, 0, 204, 22);
		mainMenu.getJComponent().addActionListener(this);
		frame.add(mainMenu);
		
		if (alternativeMenuArt) {
			toggleAlternativeArtButton = new Button(600, 320, 90, 90, "ON", 230, 230, 0, 30);
		} else {
			toggleAlternativeArtButton = new Button(600, 320, 90, 90, "OFF", 40, 40, 40, 30);
		}
		toggleAlternativeArtButton.getJComponent().addActionListener(this);
		frame.add(toggleAlternativeArtButton);
		
		frame.makeFrameVisible();
	}
	
	public void toggleArternativeArtOnOff() {
		if (alternativeMenuArt) {
			alternativeMenuArt=false;
			toggleAlternativeArtButton.getJComponent().setText("OFF");
			toggleAlternativeArtButton.getJComponent().setBackground(new Color(40,40,40));
		} else {
			alternativeMenuArt=true;
			toggleAlternativeArtButton.getJComponent().setText("ON");
			toggleAlternativeArtButton.getJComponent().setBackground(new Color(230,230,0));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Thread(new ClickSound()).start();

		if (e.getSource() == mainMenu.getJComponent()) {
			frame.dispose();
			new MenuFrame();
		}
		
		if (e.getSource() == toggleAlternativeArtButton.getJComponent()) {
			toggleArternativeArtOnOff();
		}
	}

}