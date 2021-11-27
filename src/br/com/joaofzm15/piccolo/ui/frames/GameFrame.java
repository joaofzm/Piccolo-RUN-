package br.com.joaofzm15.piccolo.ui.frames;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;


public class GameFrame {
	
	private JFrame frame;
	private JButton startButton;
	private JButton optionsButton;
	private JLabel loading;
	private JButton exitButton;

	public GameFrame() {

		frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("gameBackground.png"))));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle("Run Piccolo!");
		frame.setResizable(false);
		frame.setSize(1280, 720);
		frame.setLocationRelativeTo(null);
		
		Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
		JLabel explosionLabel = new JLabel();
		ImageIcon explosionIcon = new ImageIcon(getClass().getClassLoader().getResource("explosion.gif"));
		explosionLabel.setIcon(explosionIcon);
		explosionLabel.setBounds(115,420,300,300);
		explosionLabel.setBorder(border);
		frame.add(explosionLabel);
		
		JLabel character = new JLabel();
		ImageIcon characterIcon = new ImageIcon(getClass().getClassLoader().getResource("characterRunning.gif"));
		character.setIcon(characterIcon);
		character.setBounds(150,597,173,129);
		character.setBorder(border);
		frame.add(character);

		frame.pack();
		frame.setVisible(true);

	}

}



