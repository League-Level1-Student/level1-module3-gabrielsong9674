import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.createUI();
	}
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField textOne = new JTextField();
	JTextField textTwo = new JTextField();
	JLabel answer = new JLabel();
	JButton buttonAdd = new JButton();
	JButton buttonSubtract = new JButton();
	JButton buttonMultiply = new JButton();
	JButton buttonDivide = new JButton();
	Dimension dimension = new Dimension(100, 20);
	Dimension panelSize = new Dimension(350, 200);
	Dimension answerSize = new Dimension(100,100);
	GridLayout grid = new GridLayout(2,3);
	
	public void createUI() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Simple Calculator");
		frame.add(panel);
		panel.setPreferredSize(panelSize);
		panel.add(textOne);
		panel.add(textTwo);
		textOne.setPreferredSize(dimension);
		textTwo.setPreferredSize(dimension);
		panel.add(buttonAdd);
		
		buttonAdd.setText("add");
		panel.add(buttonSubtract);
		buttonAdd.addActionListener(this);
		buttonSubtract.setText("subtract");
		panel.add(buttonMultiply);
		buttonMultiply.setText("multiply");
		panel.add(buttonDivide);
		buttonDivide.setText("divide");
		panel.add(answer);
		answer.setPreferredSize(answerSize);
		frame.pack();
		
		
	}
	String sumString;
	public void add(int one, int two) {
		 int sum = one + two;
		 sumString = Integer.toString(sum);
	}
	String diffString;
	public void subtract(int one, int two) {
		int diff = one - two;
		diffString = Integer.toString(diff);
	}
	String productString;
	public void multiply(int one, int two) {
		int product = one * two;
		productString = Integer.toString(product);
	}
	String quotientString;
	public void divide(int one, int two) {
		int quotient = one/two;
		quotientString = Integer.toString(quotient);
	}
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed =(JButton) arg0.getSource();
		String firstNum = textOne.getText();
		String secondNum = textTwo.getText();
		int one = Integer.parseInt(firstNum);
		int two = Integer.parseInt(secondNum);
		if(buttonPressed == buttonAdd) {
			add(one, two);
			answer.setText(sumString);	
		}
	}
	
	
}
