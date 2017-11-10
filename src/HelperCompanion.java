/** 
* HelperCompanion uses the Decorator pattern to extend the functionality of the BasicCompanion. It adds text area under the Avatar
* Assignment number: Recitation Project 4
* Completion time: 3 hours
* 
* @author Carter
* @version 1.0
*/

//import the necessary libraries
import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class HelperCompanion extends CompanionDecorator implements Observer{
	
	//creates a JPanel and Jlabel for the panel
	JPanel helper = new JPanel();
	JLabel label = new JLabel("Hello, I'm Ted the tutor!", JLabel.CENTER);
	
	public HelperCompanion() { //constructor
	helper.setLayout(new BorderLayout());
	
	}
	public JPanel area() { //returns the helper JPanel
		return helper;
	}
	
	@Override
	public void setUp() {
		super.setUp();
		
		helper.add(label, BorderLayout.SOUTH);
	}
	@Override
	public void update(Observable o, Object arg) {
		//updates the text under the Avatar using Observer pattern
		String newLabel = ((Grader)o).getText();
		label.setText(newLabel);
	}
}
