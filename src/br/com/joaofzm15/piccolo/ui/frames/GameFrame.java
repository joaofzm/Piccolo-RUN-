package br.com.joaofzm15.piccolo.ui.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.joaofzm15.piccolo.ui.uiEntities.Blast;
import br.com.joaofzm15.piccolo.ui.uiEntities.Button;
import br.com.joaofzm15.piccolo.ui.uiEntities.Explosion;
import br.com.joaofzm15.piccolo.ui.uiEntities.Frame;
import br.com.joaofzm15.piccolo.ui.uiEntities.Piccolo;


public class GameFrame implements ActionListener {
	
	private Button testingButton;
	private Button testingButton2;
	private Button testingButton3;
	
	private Frame frame;
	
	private Piccolo piccolo;
	
	private Blast blast;
	
	private Explosion explosion;


	public GameFrame() {

		frame = new Frame("gameBackground.png");
		
		testingButton = new Button(780, 280, 300, 100, "JUMP", 0, 153, 0, 66);
		testingButton.getJComponent().addActionListener(this);
		frame.add(testingButton);
		
		testingButton2 = new Button(100, 280, 300, 100, "BOOM", 0, 153, 0, 66);
		testingButton2.getJComponent().addActionListener(this);
		frame.add(testingButton2);
		
		testingButton3 = new Button(100, 180, 300, 100, "DDIE", 0, 153, 0, 66);
		testingButton3.getJComponent().addActionListener(this);
		frame.add(testingButton3);
		
		explosion=new Explosion(130, 485, 224, 254);
		frame.add(explosion.getLabel());

		piccolo=new Piccolo(150, 597, 173, 129, "characterRunning.gif");
		frame.add(piccolo.getLabel());
		
		blast = new Blast(450, 530, 250, 250, "blast.gif");
		frame.add(blast.getLabel());
		
		frame.makeFrameVisible();
		
	}
	
	public void explodePlusDie() {
		explosion.explode();
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		        		piccolo.die();;
		            }
		        }, 
		        500 
		);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == testingButton.getJComponent()) {
			piccolo.jump();
		}
		
		if (e.getSource() == testingButton2.getJComponent()) {
			explosion.explode();
		}
		
		if (e.getSource() == testingButton3.getJComponent()) {
			explodePlusDie();
		}
	}

}



