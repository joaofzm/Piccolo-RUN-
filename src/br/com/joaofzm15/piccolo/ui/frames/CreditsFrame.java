package br.com.joaofzm15.piccolo.ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.joaofzm15.piccolo.ui.uiEntities.Button;
import br.com.joaofzm15.piccolo.ui.uiEntities.ClickSound;
import br.com.joaofzm15.piccolo.ui.uiEntities.Frame;
import br.com.joaofzm15.piccolo.ui.uiEntities.Label;

public class CreditsFrame implements ActionListener {

	private Frame frame;

	private Button mainMenu;

	private Label movingPiccolo;

	public CreditsFrame() {

		frame = new Frame("creditsBackground.png");

		mainMenu = new Button(940, 630, 150, 50, "MAIN MENU", 102, 0, 204, 22);
		mainMenu.getJComponent().addActionListener(this);
		frame.add(mainMenu);
		
		movingPiccolo=new Label(820, 80, 480, 480,"characterFloating.gif");
		frame.add(movingPiccolo);

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