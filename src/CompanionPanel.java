/** 
* CompanionPanel sets up the JPanel that will be used in Universe. I created a separate class for this so the Universe
* code could be as clean as possible and uncluttlered with this information.
* Assignment number: Recitation Project 4
* Completion time: 3 hours
* 
* @author Carter
* @version 1.0
*/

import java.awt.BorderLayout;
import java.net.URISyntaxException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompanionPanel extends JPanel{
	
	//two different types of companions
	BasicCompanion basic;
	HelperCompanion helper;
	
	
	public CompanionPanel(BasicCompanion basicCompanion) { //constructor with for just a BasicCompanion
		//debugging help
		System.out.println("Creating a new Companion Panel of type BASIC");
		
		//sets the layout
		setLayout(new BorderLayout());
		this.basic = basicCompanion;
		basic.setUp();
		//adds the BasicCompanion to the panel
		add(basic);
		
	}
	
	public CompanionPanel(HelperCompanion help, BasicCompanion basicCompanion) { //constructor for HelperCompanion
		//debugging help
		System.out.println("Creating a new Companion Panel of type HelperCompanion");
		
		//sets the layout
		setLayout(new BorderLayout());
		
		this.basic = basicCompanion;
		this.helper = help;
		this.helper.add(basic);
		this.helper.setUp();
		
		//adds the Basic & Helper Companion to the panel
		add(helper.area(), BorderLayout.SOUTH);
		add(basic.getPanel(), BorderLayout.CENTER);
	}
	
	
}
