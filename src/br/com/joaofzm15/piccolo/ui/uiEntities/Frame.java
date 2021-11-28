package br.com.joaofzm15.piccolo.ui.uiEntities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.ComponentUI;

import br.com.joaofzm15.piccolo.ui.frames.GameFrame;

public class Frame {
	
	private JFrame frame;
	
	public Frame(String backgroundURL) {
		frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon(getClass().getClassLoader().getResource(backgroundURL))));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		ImageIcon windowIcon = new ImageIcon(getClass().getClassLoader().getResource("windowIcon.jpg"));
		frame.setIconImage(windowIcon.getImage());
		frame.setTitle("Piccolo RUN!");
		frame.setResizable(false);
		frame.setSize(1280, 720);
		frame.setLocationRelativeTo(null);
	}

	public void add(Component component) {
		frame.add(component.getJComponent());
	}
	
	public void makeFrameVisible() {
		frame.pack();
		frame.setVisible(true);
	}
	
	public void dispose() {
		frame.dispose();
	}

}
