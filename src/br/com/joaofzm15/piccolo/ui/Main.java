package br.com.joaofzm15.piccolo.ui;

import br.com.joaofzm15.piccolo.ui.frames.MenuFrame;
import br.com.joaofzm15.piccolo.ui.uiEntities.BackgroundMusic;

public class Main {

	public static void main(String[] args) {
		Thread backgroundMusic = new Thread(new BackgroundMusic());
		backgroundMusic.start();
		new MenuFrame();
	}
}

