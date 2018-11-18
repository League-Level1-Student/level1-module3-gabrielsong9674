import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySurprise implements ActionListener {
public static void main(String[] args) {
	NastySurprise surprise = new NastySurprise();
	surprise.createUI();
}
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JButton button1 = new JButton();
JButton button2 = new JButton();
public void createUI(){
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);
	frame.setSize(200, 200);
	panel.add(button1);
	button1.setText("Trick");
	button1.addActionListener(this);
	panel.add(button2);
	button2.setText("Treat");
	button2.addActionListener(this);
	}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	JButton buttonPressed = (JButton) e.getSource();
	if(buttonPressed == button1) {
		showPictureFromTheInternet("http://images2.fanpop.com/image/photos/13600000/-Dachshunds-dachshunds-13634801-1024-768.jpg");
	}
	else if(buttonPressed == button2) {
		showPictureFromTheInternet("http://3.bp.blogspot.com/-18ZRliytptc/UC4DP2Yht1I/AAAAAAAAF14/15Zejd5x7iI/s1600/Barn+Spider+Wallpapers+9.jpg");
	}
}
	private void showPictureFromTheInternet(String imageUrl) {
	     try {
	          URL url = new URL(imageUrl);
	          Icon icon = new ImageIcon(url);
	          JLabel imageLabel = new JLabel(icon);
	          JFrame frame = new JFrame();
	          frame.add(imageLabel);
	          frame.setVisible(true);
	          frame.pack();
	     } catch (MalformedURLException e) {
	          e.printStackTrace();
	     }
	}
}
