package br.com.joaofzm15.piccolo.ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import br.com.joaofzm15.piccolo.ui.uiEntities.Blast;
import br.com.joaofzm15.piccolo.ui.uiEntities.Button;
import br.com.joaofzm15.piccolo.ui.uiEntities.ClickSound;
import br.com.joaofzm15.piccolo.ui.uiEntities.Explosion;
import br.com.joaofzm15.piccolo.ui.uiEntities.Frame;
import br.com.joaofzm15.piccolo.ui.uiEntities.GameOverWarning;
import br.com.joaofzm15.piccolo.ui.uiEntities.Highscore;
import br.com.joaofzm15.piccolo.ui.uiEntities.InstructionsLabel;
import br.com.joaofzm15.piccolo.ui.uiEntities.PauseWarning;
import br.com.joaofzm15.piccolo.ui.uiEntities.Piccolo;
import br.com.joaofzm15.piccolo.ui.uiEntities.Score;
import br.com.joaofzm15.piccolo.ui.uiEntities.ScreamSound;

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

	private PauseWarning pauseWarning;

	private GameOverWarning gameOverWarning;

	private Button mainMenu;

	private Explosion explosion;

	private Piccolo piccolo;

	public Piccolo getPiccolo() {
		return piccolo;
	}

	private boolean playerAlive;

	public boolean isPlayerAlive() {
		return playerAlive;
	}

	public void setPlayerAlive(boolean value) {
		playerAlive = value;
	}

	private boolean gamePaused;

	private ArrayList<Blast> listOfBlasts;

	public GameFrame() {

		listOfBlasts = new ArrayList<Blast>();
		playerAlive = false;

		frame = new Frame("gameBackground.gif");
		frame.getJFrame().addKeyListener(this);

		score = new Score(530, 100, 500, 200);
		frame.add(score.getLabel());

		highscore = new Highscore(553, 40, 200, 200);
		frame.add(highscore.getLabel());

		instructionsLabel = new InstructionsLabel(383, 160, 800, 200);
		frame.add(instructionsLabel.getLabel());

		// ----------------
		pauseWarning = new PauseWarning(530, 250, 800, 300);
		pauseWarning.getLabel().setVisible(false);
		frame.add(pauseWarning.getLabel());

		gameOverWarning = new GameOverWarning(390, 250, 800, 300);
		gameOverWarning.getLabel().setVisible(false);
		frame.add(gameOverWarning.getLabel());

		mainMenu = new Button(560, 480, 150, 50, "MAIN MENU", 204, 0, 0, 22);
		mainMenu.getJComponent().addActionListener(this);
		mainMenu.setVisible(false);
		frame.add(mainMenu);
		// ----------------

		explosion = new Explosion(130, 485, 224, 254);
		frame.add(explosion.getLabel());

		newBlast(1400);
		newBlast(2160);
		newBlast(2920);

		piccolo = new Piccolo(150, 597, 173, 129, "characterRunning.gif");
		frame.add(piccolo.getLabel());

		frame.makeFrameVisible();

		restart();

	}

	public void restart() {
		int xPos = 1600;
		for (Blast blast : listOfBlasts) {
			blast.getLabel().getJComponent().setBounds(xPos, 600, 150, 150);
			xPos += 600;
		}
		playerAlive = true;
		score.resetScore();
		piccolo.jump();
		unPauseGameOver();
	}

	public void newBlast(int x) {
		Blast blast = new Blast(x, 600, 150, 150, "blast.gif", this);
		frame.add(blast.getLabel());
		listOfBlasts.add(blast);

	}

	public void pauseGameOver() {
		mainMenu.setVisible(true);
		gameOverWarning.getLabel().setVisible(true);
	}

	public void pause() {
		mainMenu.setVisible(true);
		pauseWarning.getLabel().setVisible(true);
		for (Blast blast : listOfBlasts) {
			blast.pauseTimer();
		}
	}

	public void unPauseGameOver() {
		mainMenu.setVisible(false);
		gameOverWarning.getLabel().setVisible(false);
		pauseWarning.getLabel().setVisible(false);
	}
	
	public void unPause() {
		mainMenu.setVisible(false);
		gameOverWarning.getLabel().setVisible(false);
		pauseWarning.getLabel().setVisible(false);
		for (Blast blast : listOfBlasts) {
			blast.resumeTimer();
		}
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
		new Thread(new ClickSound()).start();

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
		if (e.getKeyCode() == KeyEvent.VK_SPACE && playerAlive && !gamePaused) {
			piccolo.jump();
		}
		if (e.getKeyCode() == 82 && !playerAlive) {
			restart();
		}
		if (e.getKeyCode() == 80) {
			if (gamePaused && playerAlive) {
				unPause();
				gamePaused = false;
			} else if (playerAlive) {
				pause();
				gamePaused = true;
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
