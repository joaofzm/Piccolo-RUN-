package br.com.joaofzm15.piccolo.ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.com.joaofzm15.piccolo.ui.uiEntities.Blast;
import br.com.joaofzm15.piccolo.ui.uiEntities.Button;
import br.com.joaofzm15.piccolo.ui.uiEntities.Explosion;
import br.com.joaofzm15.piccolo.ui.uiEntities.Frame;
import br.com.joaofzm15.piccolo.ui.uiEntities.Label;
import br.com.joaofzm15.piccolo.ui.uiEntities.Piccolo;
import br.com.joaofzm15.piccolo.ui.uiEntities.Score;

public class GameFrame implements ActionListener, KeyListener {

	private Frame frame;

	private Score score;

	private Piccolo piccolo;

	public Piccolo getPiccolo() {
		return piccolo;
	}

	private boolean playerAlive;
	public boolean isPlayerAlive() {
		return playerAlive;
	}

	private Explosion explosion;

	public GameFrame() {
		
		playerAlive=true;

		frame = new Frame("gameBackground.png");
		frame.getJFrame().addKeyListener(this);

		score = new Score(530, 100, 500, 200);
		frame.add(score.getLabel());

		newBlast(1400);
		newBlast(2000);
		newBlast(2600);

		explosion = new Explosion(130, 485, 224, 254);
		frame.add(explosion.getLabel());

		piccolo = new Piccolo(150, 597, 173, 129, "characterRunning.gif");
		frame.add(piccolo.getLabel());

		frame.makeFrameVisible();

	}

	public void newBlast(int x) {
		Blast blast = new Blast(x, 600, 150, 150, "blast.gif", this);
		frame.add(blast.getLabel());

	}

	public void explodePlusDie() {
		explosion.explode();
		playerAlive=false;
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

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE && playerAlive) {
			piccolo.jump();
			score.increaseScore();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
