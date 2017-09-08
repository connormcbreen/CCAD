/**
* TutorPanel: Displays a HTML file with information corresponding to the Tutoring subject matter
* Recitation Project 1
* Completion time: 15 hours
*
* Author: Connor T McBreen (the names of anyone whose code you use)
* Version: 1.0
*/


import java.awt.*;
import javax.swing.*;		//imported to access the java swing GUI methods
import javax.swing.event.*;
import java.io.*;			//Imported for access to filestream and IO exceptions
import java.net.*;			//Imported for access to HTML file methods
import java.util.*;			//Imported for access to Scanner and input methods

public class TutorPanel extends JPanel
{
		int panelState = 0;					//The initial state of the JPanel, shows authors name, changes based off slider position
		JEditorPane tutor = new JEditorPane();	//Initializes the tutor JEditorPane, which will dispay the HTML files
	public TutorPanel()
	   {
	    tutor.setEditable(false);			//Sets the JEditorPane to not editable by user to prevent non-functional interference

		updatePanel(panelState);			//Calls the updatePanel method to update the panel depending on the slider

	    JScrollPane scrollPane = new JScrollPane(tutor);	//Adds the JEditorPane to a scrollPane incase the HTML file is larger then the window
	    setLayout(new BorderLayout());				//Sets the Panel Layout to a border layout

	    add(scrollPane, BorderLayout.CENTER);			//adds the scroll pane to the center of the Panel

		}
	public void changeState(int state)			//changeState method, interacts with the slider to change the html file displayed based of the slider number
	{
		if(state <= 4 && state >= 0)		//Only has 4 states, 1, 2, 3, and 4
		{
			updatePanel(state);			//Calls the updatePanel method and feeds through slider input
		}
		else					//Does not change if a value is out of range
		{
		}
	}

	public void updatePanel(int state)				//updatePanel method, updates the display on the panel by parsing a html file and displaying it
	{
		try							//Try statement to open and read an html file, has FileNotFound and IO exceptions
		{
			tutor.setContentType("text/html");				//Sets the content type of the JEditorPane for text based HTML files
	  		tutor.setPage(TutorPanel.class.getResource("P" + state + ".html"));				//Finds the local html file and sets the EditorPane to the HTML file
		}
		catch(FileNotFoundException e)					//File not found exception, in case file doesnt not exist
		{
			System.err.println("P" + state + ".html was not found");
			tutor.setText("P" + state + ".html was not found");
		}
		catch(IOException e)						//IOException if issues occur when opening or closing HTML files
		{
			System.err.println("Caught IOException: " + e.getMessage());
			tutor.setText("Caught IOException: " + e.getMessage());
		}
	  	if(panelState == 0)				//An if statement that initially displays the Author of the page, but is inaccessible after the
		{													//first state change via a boolean flag
			tutor.setText("The Author of this Panel is\n Connor T McBreen");
		}
	}

}

