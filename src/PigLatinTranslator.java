import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatinTranslator implements ActionListener {
	public static void main(String[] args) {
		PigLatinTranslator translate = new PigLatinTranslator();
		translate.createUI();
	}

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField textField = new JTextField();
	JLabel label = new JLabel();
	JButton button = new JButton();
	Dimension buttonSize = new Dimension(100, 30);
	Dimension textFieldSize = new Dimension(200, 30);
	
	public void createUI() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Pig Latin Translator");
		frame.add(panel);
		panel.add(textField);
		textField.setPreferredSize(textFieldSize);
		panel.add(button);
		button.setPreferredSize(buttonSize);
		button.setText("Translate");
		button.addActionListener(this);
		panel.add(label);
		label.setPreferredSize(textFieldSize);
		
		frame.pack();
	}

	private static boolean isLetter(char c) {
		return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
	}

	private static String pigWord(String word) {
		int split = firstVowel(word);
		return word.substring(split) + "-" + word.substring(0, split) + "ay";
	}

	public String translate(String s) {
		String latin = "";
		int i = 0;
		while (i < s.length()) {

			// Take care of punctuation and spaces
			while (i < s.length() && !isLetter(s.charAt(i))) {
				latin = latin + s.charAt(i);
				i++;
			}

			// If there aren't any words left, stop.
			if (i >= s.length())
				break;

			// Otherwise we're at the beginning of a word.
			int begin = i;
			while (i < s.length() && isLetter(s.charAt(i))) {
				i++;
			}
			// Now we're at the end of a word, so translate it.
			int end = i;
			latin = latin + pigWord(s.substring(begin, end));
		}
		return latin;
	}

	private static int firstVowel(String word) {
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++)
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
					|| word.charAt(i) == 'u')
				return i;
		return 0;
	}
	String pigLatin;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed == button) {
			pigLatin = translate(textField.getText());
			label.setText(pigLatin);
		}
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> 2799cf383def56f8d302a99d49696a59c4e97ba8
