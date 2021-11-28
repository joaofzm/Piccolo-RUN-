package br.com.joaofzm15.piccolo.ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.joaofzm15.piccolo.ui.uiEntities.Button;
import br.com.joaofzm15.piccolo.ui.uiEntities.Frame;
import br.com.joaofzm15.piccolo.ui.uiEntities.Label;

public class MenuFrame implements ActionListener {

	private Frame frame;

	private Button startButton;
	private Button scoresButton;
	private Button optionsButton;
	private Button exitButton;

	private Label logo;

	public MenuFrame() {

		frame = new Frame("menuBackground.gif");

		logo = new Label(700, 35, 465, 181, "logo.png");
		frame.add(logo);

		startButton = new Button(780, 280, 300, 100, "P L A Y", 0, 153, 0, 66);
		startButton.getJComponent().addActionListener(this);
		frame.add(startButton);

		scoresButton = new Button(805, 430, 250, 50, "H I G H    S C O R E S", 102, 0, 204, 22);
		scoresButton.getJComponent().addActionListener(this);
		frame.add(scoresButton);

		optionsButton = new Button(830, 530, 200, 50, "O P T I O N S", 0, 210, 210, 22);
		optionsButton.getJComponent().addActionListener(this);
		frame.add(optionsButton);

		exitButton = new Button(855, 630, 150, 50, "E X I T", 204, 0, 0, 22);
		exitButton.getJComponent().addActionListener(this);
		frame.add(exitButton);

		frame.makeFrameVisible();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton.getJComponent()) {
			frame.dispose();
			new GameFrame();
		}
		if (e.getSource() == exitButton.getJComponent()) {
			try {
				Thread.sleep(900);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.exit(0);
		}
	}

}