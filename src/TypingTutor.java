import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	public static void main(String[] args) {
		TypingTutor tutor = new TypingTutor();
		tutor.makeUI();
		
	}
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Dimension dimension = new Dimension(400, 200);
	int numPressed = 0;
	char currentLetter = generateRandomLetter();
	char generateRandomLetter() {
		 Random r = new Random();
	     return (char) (r.nextInt(26) + 'a');
	}
	public void makeUI() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(dimension);
		frame.setTitle("Type or Die");
		panel.add(label);
		label.setText(currentLetter + "");
		label.setFont(label.getFont().deriveFont(48.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.addKeyListener(this);
		frame.pack();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		 char key = e.getKeyChar();
		System.out.println("You typed: " + key );
		if(key == currentLetter) {
			System.out.println("correct");
			panel.setBackground(new Color(0, 255, 0));
			numPressed++;
		}
		else {
			System.out.println("incorrect");
			panel.setBackground(new Color(255, 0, 0));
		}
		if(numPressed > 20) {
			showTypingSpeed(numPressed);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		currentLetter = generateRandomLetter();
		label.setText(currentLetter + "");
	}
	private void showTypingSpeed(int numberOfCorrectCharactersTyped) {
	      Date timeAtEnd = new Date();
	      long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
	      long gameInSeconds = (gameDuration / 1000) % 60;
	      double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
	      int charactersPerMinute = (int) (charactersPerSecond * 60);
	      JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute.");
	
	}
	
	Date timeAtStart = new Date();
}
