import java.applet.AudioClip;
import java.awt.Dimension;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Mole {
	public static void main(String[] args) {
		Mole mole = new Mole();
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
	public void drawButtons() {
		for(int i = 0; i < 25; i ++) {
			if(i == num) {
				panel.add(new JButton("mole!"));
			}
			else {
				panel.add(new JButton());
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
	private void endGame(Date timeAtStart, int molesWhacked) {
	     Date timeAtEnd = new Date();
	     JOptionPane.showMessageDialog(null, "Your whack rate is "
	          + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	          + " moles per second.");
	}
	private void playSound(String fileName) {
	     AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
	     sound.play();
	}

}
