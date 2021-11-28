package br.com.joaofzm15.piccolo.ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import br.com.joaofzm15.piccolo.ui.uiEntities.Blast;
import br.com.joaofzm15.piccolo.ui.uiEntities.Button;
import br.com.joaofzm15.piccolo.ui.uiEntities.Explosion;
import br.com.joaofzm15.piccolo.ui.uiEntities.Frame;
import br.com.joaofzm15.piccolo.ui.uiEntities.Highscore;
import br.com.joaofzm15.piccolo.ui.uiEntities.InstructionsLabel;
import br.com.joaofzm15.piccolo.ui.uiEntities.Piccolo;
import br.com.joaofzm15.piccolo.ui.uiEntities.Score;

public class GameFrame implements ActionListener, KeyListener {

	private Frame frame;

	private Score score;
	public Score getScore() {
		return score;
	}
	private Highscore highscore;
	public Highscore gethighscore() {
		return highscore;
	}

	private InstructionsLabel instructionsLabel;
	
	private Piccolo piccolo;

	public Piccolo getPiccolo() {
		return piccolo;
	}

	private boolean playerAlive;
	public boolean isPlayerAlive() {
		return playerAlive;
	}
	public void setPlayerAlive(boolean value) {
		playerAlive=value;
	}

	private Explosion explosion;
	
	private ArrayList<Blast> listOfBlasts;
	
	private Button mainMenu;


	public GameFrame() {
		
		listOfBlasts = new ArrayList<Blast>();
		playerAlive=false;

		frame = new Frame("gameBackground.png");
		frame.getJFrame().addKeyListener(this);

		score = new Score(530, 100, 500, 200);
		frame.add(score.getLabel());
		
		highscore = new Highscore(553, 40, 200, 200);
		frame.add(highscore.getLabel());
		
		instructionsLabel = new InstructionsLabel(383, 160, 800, 200);
		frame.add(instructionsLabel.getLabel());

		mainMenu = new Button(560, 480, 150, 50, "MAIN MENU", 204, 0, 0, 22);
		mainMenu.getJComponent().addActionListener(this);
		frame.add(mainMenu);

		explosion = new Explosion(130, 485, 224, 254);
		frame.add(explosion.getLabel());

		newBlast(1400);
		newBlast(2000);
		newBlast(2600);
		
		piccolo = new Piccolo(150, 597, 173, 129, "characterRunning.gif");
		frame.add(piccolo.getLabel());

		frame.makeFrameVisible();
		
		restart();

	}
	
	public void restart() {
		if (score.getScore()>highscore.getHighscore()) {
			highscore.setHighscore(score.getScore());
		}
		int xPos = 1600;
		for (Blast blast : listOfBlasts) {
			blast.getLabel().getJComponent().setBounds(xPos,600, 150, 150);
			xPos+=600;
		}
		playerAlive=true;
		score.resetScore();
		piccolo.jump();
	}

	public void newBlast(int x) {
		Blast blast = new Blast(x, 600, 150, 150, "blast.gif", this);
		frame.add(blast.getLabel());
		listOfBlasts.add(blast);

	}

	public void explodePlusDie() {
		explosion.explode();
		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				piccolo.die();
				;
			}
		}, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainMenu.getJComponent()) {
			frame.dispose();
			new MenuFrame();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE && playerAlive) {
			piccolo.jump();
		}
		if (e.getKeyCode()==82 && !playerAlive) {
			restart();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
