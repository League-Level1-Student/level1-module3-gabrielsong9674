import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	public static void main(String[] args) {
		WhackAMole mole = new WhackAMole();
		mole.createGUI();
	}
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Random gen = new Random();
	int num = gen.nextInt(25);
	public void createGUI() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Whack A Button");
		frame.add(panel);
		frame.setSize(300, 300);
		drawButtons();
		
		
	}
	
	JButton moleButton = new JButton("mole!");
	public void drawButtons() {
		for(int i = 0; i < 25; i ++) {
			if(i == num) {
				
				moleButton.addActionListener(this);
				panel.add(moleButton);
			}
			else {
				JButton button = new JButton();
				button.addActionListener(this);
				panel.add(button);
				
			}
		}
		
	}
	void speak(String words) {
	     try {
	          Runtime.getRuntime().exec("say " + words).waitFor();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
	
	private void playSound(String fileName) {
	     AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
	     sound.play();
	}
	private void endGame(Date timeAtStart, int molesWhacked) {
	     Date timeAtEnd = new Date();
	     JOptionPane.showMessageDialog(null, "Your whack rate is "
	          + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	          + " moles per second.");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed != moleButton) {
			speak("you missed");
		}
	}


	

}