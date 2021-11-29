package br.com.joaofzm15.piccolo.ui.uiEntities;

import br.com.joaofzm15.piccolo.logic.SoundEffectConverter;

public class ExplosionSound implements Runnable {

	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();
	String soundPath = "/explosionSound.wav";


	@Override
	public void run() {
		soundEffectConverter.setFile(soundPath);
		soundEffectConverter.play();
	}

}
