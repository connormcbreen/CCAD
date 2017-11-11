/** 
* ProgressBarPanel creates a JPanel for the progress bar that can be called in Universe so it's not all cluttered.
* Assignment number: Recitation Project 4
* Completion time: 1 hours
* 
* @author Carter
* @version 1.0
*/

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class ProgressBarPanel extends JPanel {
	//create progress bar object
	ProgressBar bar;
	
	public ProgressBarPanel(ProgressBar bar) { //constructor
		//set layout for the JPanel
		setLayout(new BorderLayout());
		this.bar = bar;
		//add it to the center of the layout so it fills the whole panel
		add(bar.getPanel(), BorderLayout.CENTER);
	}
}
