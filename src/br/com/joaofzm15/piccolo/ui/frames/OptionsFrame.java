package br.com.joaofzm15.piccolo.ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.joaofzm15.piccolo.ui.uiEntities.Button;
import br.com.joaofzm15.piccolo.ui.uiEntities.ClickSound;
import br.com.joaofzm15.piccolo.ui.uiEntities.Frame;
import br.com.joaofzm15.piccolo.ui.uiEntities.Label;

public class OptionsFrame implements ActionListener {

	private Frame frame;

	private Button mainMenu;

	public OptionsFrame() {

		frame = new Frame("optionsBackground.png");
		
		mainMenu = new Button(320, 630, 150, 50, "MAIN MENU", 102, 0, 204, 22);
		mainMenu.getJComponent().addActionListener(this);
		frame.add(mainMenu);
		
		frame.makeFrameVisible();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Thread(new ClickSound()).start();

		if (e.getSource() == mainMenu.getJComponent()) {
			frame.dispose();
			new MenuFrame();
		}
	}

}