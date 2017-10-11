import javax.swing.*;

public class TextualFeedback {
	  
		//simple, reusable pop-up that provides the user with textual feedback. 
		public static void infoBox(String infoMessage, String titleBar)
	    {
	        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
	    }
}
