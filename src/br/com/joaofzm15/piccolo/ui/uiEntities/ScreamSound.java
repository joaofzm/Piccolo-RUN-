package br.com.joaofzm15.piccolo.ui.uiEntities;

import br.com.joaofzm15.piccolo.logic.SoundEffectConverter;

public class ScreamSound implements Runnable {

	private SoundEffectConverter soundEffectConverter = new SoundEffectConverter();
	String soundPath = "/screamSound.wav";


	@Override
	public void run() {
		soundEffectConverter.setFile(soundPath);
		soundEffectConverter.play();
	}

}
