package br.com.joaofzm15.piccolo.logic;

import br.com.joaofzm15.piccolo.ui.frames.GameFrame;
import br.com.joaofzm15.piccolo.ui.uiEntities.Blast;
import br.com.joaofzm15.piccolo.ui.uiEntities.ExplosionSound;
import br.com.joaofzm15.piccolo.ui.uiEntities.Highscore;
import br.com.joaofzm15.piccolo.ui.uiEntities.ScreamSound;

public class CollisionCheck {

	public static boolean checkCollision(GameFrame gf, Blast blast) {
		if (blast.getLabel().getJComponent().getX() < 255 
				&& blast.getLabel().getJComponent().getX() > 50
				&& !gf.getPiccolo().isJumping()) {
			if (gf.isPlayerAlive()) {
				new Thread(new ScreamSound()).start();
				new Thread(new ExplosionSound()).start();
				gf.setPlayerAlive(false);
				gf.explodePlusDie();
				gf.pauseGameOver();
				if (gf.getScore().getScore() > Highscore.getHighscore()) {
					gf.gethighscore().setHighscore(gf.getScore().getScore());
				}
				return true;
			}
		}
    	if (blast.getLabel().getJComponent().getX()==68&&gf.isPlayerAlive()) {
    		gf.getScore().increaseScore();
    		if (gf.getScore().getScore()%10==0) {
    		}
    		return false;
    	}
    	if (blast.getLabel().getJComponent().getX()==140&&!gf.isPlayerAlive()) {
			gf.explodePlusDie();
			new Thread(new ExplosionSound()).start();
			return true;
    	}
		return false;
	}

}
