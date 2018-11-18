
<<<<<<< HEAD
=======
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */

>>>>>>> 2799cf383def56f8d302a99d49696a59c4e97ba8
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
/** We’re going to make a slideshow of cool optical illusions. When the user clicks on an illusion, a new one will be loaded. **/

public class BookOfIllusions extends MouseAdapter {

	/*
	 * Here we are instantiating our BookOfIllusions class and calling it’s createBook() method. This is because we want to get out of the
	 * static main method, so that we can add a click listener to each illusion.
	 */

	public static void main(String[] args) throws Exception {
		BookOfIllusions illusions = new BookOfIllusions();
		illusions.createBook();
	}

	// 1. Make a JFrame variable and initialize it using "new JFrame()"
	JFrame frame = new JFrame();
<<<<<<< HEAD
	Dimension frameSize = new Dimension(1000, 1000);
	JLabel image;

=======
	Dimension frameSize = new Dimension(100, 100);
>>>>>>> 2799cf383def56f8d302a99d49696a59c4e97ba8
	private void createBook() {
		// 2. make the frame visible
		frame.setVisible(true);
		// 3. set the size of the frame
		frame.setPreferredSize(frameSize);
		// 4. find 2 images and save them to your project’s default package
		// 5. make a variable to hold the location of your image. e.g. "illusion.jpg"
		// 6. create a variable of type "JLabel" but don’t initialize it yet
		// 7. use the "loadImage..." methods below to initialize your JLabel
		image = loadImageFromComputer("pups.jpg");
		// 8. add your JLabel to the frame
		frame.add(image);
		// 9. call the pack() method on the frame
		frame.pack();
		// 10. add a mouse listener to your frame (hint: use *this*)
		frame.addMouseListener(this);
	}

	public void mousePressed(MouseEvent e) {
		// 11. Print "clicked!" to the console when the mouse is pressed
		if(e.getButton() == MouseEvent.BUTTON1) {
			// 12. remove everything from the frame that was added earlier
			// 13. load a new image like before (this is more than one line of code)
			// 14. pack the frame
			System.out.println("clicked");
			frame.remove(image);
			image = loadImageFromComputer("kitten.jpg");
			frame.add(image);
			frame.pack();
		
		}
	}

	// [OPTIONAL] 15. goad your users with some annoying or witty pop-ups

	/*
	 * To use this method, the image must be placed in your Eclipse project under "default package".
	 */
	public JLabel loadImageFromComputer(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

}

