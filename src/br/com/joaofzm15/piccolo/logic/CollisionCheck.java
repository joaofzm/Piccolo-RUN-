package br.com.joaofzm15.piccolo.logic;

import br.com.joaofzm15.piccolo.ui.frames.GameFrame;
import br.com.joaofzm15.piccolo.ui.uiEntities.Blast;

public class CollisionCheck {

	public static void checkCollision(GameFrame gf, Blast blast) {
		if (blast.getLabel().getJComponent().getX() < 255 
				&& blast.getLabel().getJComponent().getX() > 70
				&& !gf.getPiccolo().isJumping()) {
			gf.setPlayerAlive(false);
			gf.explodePlusDie();
		}
    	if (blast.getLabel().getJComponent().getX()==68&&gf.isPlayerAlive()) {
    		gf.getScore().increaseScore();
    	}
	}

}
