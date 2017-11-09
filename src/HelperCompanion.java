import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelperCompanion extends CompanionDecorator {
	JPanel helper = new JPanel();
	JLabel label = new JLabel("test label", JLabel.CENTER);
	
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
}
