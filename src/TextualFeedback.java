/** 
* TextualFeedback creates a static method that can be used throughout the system to easily display text-based pop ups.
* Assignment number: Recitation Project 3
* Completion time: 1
* 
* @author Carter
* @version 1.0
*/

import javax.swing.*;

public class TextualFeedback {
	  
		//simple, reusable pop-up that provides the user with textual feedback. 
		public static void infoBox(String infoMessage, String titleBar)
	    {
	        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
	    }
}