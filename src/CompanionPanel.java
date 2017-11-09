import java.awt.BorderLayout;
import java.net.URISyntaxException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompanionPanel extends JPanel{
	BasicCompanion basic;
	HelperCompanion helper;
	JLabel test = new JLabel("testing 1 2", JLabel.CENTER);
	
	public CompanionPanel() {
		setLayout(new BorderLayout());
		try {
			basic = new BasicCompanion();
		}  catch (URISyntaxException e) {
            e.printStackTrace();
        }
		basic.setUp();
		add(basic);
		
		System.out.println("debugger fugger");
	}
	
	public CompanionPanel(String type) {
		setLayout(new BorderLayout());
		System.out.println("Creating a new Companion Panel of type " + type);
		if(type.equalsIgnoreCase("helper")) {
			System.out.print("IM IN THE MAINFRAME");
			try {
				basic = new BasicCompanion();
			}  catch (URISyntaxException e) {
	            e.printStackTrace();
	        }
			
			helper = new HelperCompanion();
			helper.add(basic);
			helper.setUp();
			add(helper.area(), BorderLayout.SOUTH);
			add(basic.getPanel(), BorderLayout.CENTER);
		}
	}
	
}
