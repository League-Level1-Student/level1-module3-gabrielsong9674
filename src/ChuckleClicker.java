import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	public static void main(String[] args) {
		ChuckleClicker clicker = new ChuckleClicker();
		clicker.makeButtons();
	}
	
	Dimension preferredSize = new Dimension(200, 100);
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JButton button = new JButton();
	JButton button2 = new JButton();
	
	public void makeButtons(){
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(1,2));
		frame.setTitle("Chuckle Clicker");
		panel.add(button);
		panel.add(button2);	
		button.setText("joke");
		button2.setText("punchline");
		button.addActionListener(this);
		button2.addActionListener(this);
		frame.pack();
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == button || arg0.getSource() == button2) {
			 JOptionPane.showMessageDialog(null, "Hi");
			 if(arg0.getSource() == button) {
				 JOptionPane.showMessageDialog(null, "Joke");
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "Punchline");
			 }
		}
	}
}
