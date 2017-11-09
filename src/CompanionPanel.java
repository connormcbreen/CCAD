import java.awt.BorderLayout;
import java.net.URISyntaxException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompanionPanel extends JPanel{
	BasicCompanion basic;
	HelperCompanion helper;
	JLabel test = new JLabel("testing 1 2", JLabel.CENTER);
	
	public CompanionPanel(BasicCompanion basicCompanion) {
		setLayout(new BorderLayout());
		this.basic = basicCompanion;
		basic.setUp();
		add(basic);
		
		System.out.println("Creating a new Companion Panel of type BASIC");
	}
	
	public CompanionPanel(HelperCompanion help, BasicCompanion basicCompanion) {
		setLayout(new BorderLayout());
		System.out.println("Creating a new Companion Panel of type HelperCompanion");
		
		
			this.basic = basicCompanion;
			this.helper = help;
			this.helper.add(basic);
			this.helper.setUp();
			add(helper.area(), BorderLayout.SOUTH);
			add(basic.getPanel(), BorderLayout.CENTER);
		
	}
	
}
