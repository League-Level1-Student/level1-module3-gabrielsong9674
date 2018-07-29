import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener{
	public static void main(String[] args)
	{
		ChuckleClicker chuckle = new ChuckleClicker();
		chuckle.makeButtons();
	}
	 JFrame frame = new JFrame();
	 JPanel panel = new JPanel();
	 JButton button1 = new JButton();
	 JButton button2 = new JButton();
	 Dimension buttonSize = new Dimension(100, 50);
	
	public void makeButtons() 
	{
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(button1);
		button1.setPreferredSize(buttonSize);
		panel.add(button2);
		button2.setPreferredSize(buttonSize);
		button1.setText("joke");
		button2.setText("punchline");
		button1.addActionListener(this);
		button2.addActionListener(this);
		frame.pack();
	}
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		if(buttonPressed == button1) {
			JOptionPane.showMessageDialog(null, "joke");
		}
		else {
			JOptionPane.showMessageDialog(null, "punchline");
		}
	}
}
