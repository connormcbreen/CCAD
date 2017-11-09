import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelperCompanion extends CompanionDecorator implements Observer{
	JPanel helper = new JPanel();
	JLabel label = new JLabel("Hello, I'm Craig the crackhead tutor!", JLabel.CENTER);
	
	public HelperCompanion() { //constructor
	helper.setLayout(new BorderLayout());
	//helper.add(label, BorderLayout.SOUTH);
	
	}
	public JPanel area() {
		return helper;
	}
	@Override
	public void setUp() {
		super.setUp();
		
		helper.add(label, BorderLayout.SOUTH);
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		String newLabel = ((Grader)o).getText();
		label.setText(newLabel);
	}
}
