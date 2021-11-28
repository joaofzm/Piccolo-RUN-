package br.com.joaofzm15.piccolo.logic;

import br.com.joaofzm15.piccolo.ui.frames.GameFrame;
import br.com.joaofzm15.piccolo.ui.uiEntities.Blast;
import br.com.joaofzm15.piccolo.ui.uiEntities.Highscore;

public class CollisionCheck {

	public static void checkCollision(GameFrame gf, Blast blast) {
		if (blast.getLabel().getJComponent().getX() < 255 
				&& blast.getLabel().getJComponent().getX() > 70
				&& !gf.getPiccolo().isJumping()) {
			gf.setPlayerAlive(false);
			gf.explodePlusDie();
			gf.pauseGameOver();;
			if (gf.getScore().getScore() > Highscore.getHighscore()) {
				gf.gethighscore().setHighscore(gf.getScore().getScore());
			}
		}
    	if (blast.getLabel().getJComponent().getX()==68&&gf.isPlayerAlive()) {
    		gf.getScore().increaseScore();
    	}
	}

}
