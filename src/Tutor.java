/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author conno_000
 */
import java.awt.*;
import javax.swing.*;		//imported to access the java swing GUI methods
import javax.swing.JEditorPane;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;			//Imported for access to filestream and IO exception

public class Tutor extends JPanel
{
		int panelState = 1;					//The initial state of the JPanel, shows authors name, changes based off slider position
                int currentLesson = 0;
                //JPanel tutor;
                JEditorPane lesson;
                JScrollPane scrollPane;
                JButton l1;
                JButton l2;
                JButton l3;
                JButton next;
                JButton prev;   
                JButton goBack;
                String currentSize = "min";
               
	public Tutor()
	   {
            //tutor = new JPanel();
            setLayout(null);
                       
            lesson = new JEditorPane();

            
            l1 = new JButton("Lesson1");
            l1.setBounds(25, 25, 100, 50);
            l2 = new JButton("Lesson2");
            l2.setBounds(25, 100, 100, 50);
            l3 = new JButton("Lesson3");
            l3.setBounds(25, 175, 100, 50);
            next = new JButton("Next");
            prev = new JButton("Previous");
            goBack = new JButton("Go Back");

            
            l1.addActionListener(new buttonListener());
            l2.addActionListener(new buttonListener());
            l3.addActionListener(new buttonListener());
            next.addActionListener(new buttonListener());
            prev.addActionListener(new buttonListener());
            goBack.addActionListener(new buttonListener());
      
            add(l1);

            add(l2);

            add(l3);
           
            scrollPane = new JScrollPane();
            //scrollPane.setPreferredSize(new Dimension(300,250));
            //add(scrollPane);

		}
	public void changeLesson(int state)			//changeState method, interacts with the slider to change the html file displayed based of the slider number
	{
		currentLesson = state;
		if(state <= 3 && state >= 1)		//Only has 4 states, 1, 2, 3, and 4
		{
			updatePanel();			//Calls the updatePanel method and feeds through slider input
		}
		else					//Does not change if a value is out of range
		{
		}
	}

	public void updatePanel()				//updatePanel method, updates the display on the panel by finding html file and displaying it
	{
		if(currentLesson <= 3 && currentLesson >= 1)
		{
			try							//Try statement to open and read an html file, has FileNotFound and IO exceptions
			{
				Document doc = lesson.getDocument();
				doc.putProperty(Document.StreamDescriptionProperty, null);	//Clears out the input stream for refreshing the same page multiple times
                                lesson.setContentType("text/html");				//Sets the content type of the JEditorPane for text based HTML files
	  			lesson.setPage(TutorPanel.class.getResource("Resource/Lesson" + currentLesson +"." + panelState + ".html"));	//Finds the local html file and sets the EditorPane to the HTML file
                                System.out.println("Lesson" + currentLesson +"." + panelState + ".html");
			}
			catch(FileNotFoundException e)					//File not found exception, in case file doesnt not exist
			{
				System.err.println("Lesson" + currentLesson +"." + panelState + ".html");
				lesson.setText("Lesson" + currentLesson +"." + panelState + ".html");
			}
			catch(IOException e)						//IOException if issues occur when opening or closing HTML files
			{
				System.err.println("Caught IOException: " + e.getMessage());
				lesson.setText("Caught IOException: " + e.getMessage());
			}
		}
		if(currentLesson == 0)				//An if statement that initially displays the Author of the page, but is inaccessible after the
			{													//first state change via a boolean flag
				lesson.setText("The Author of this Panel is Connor T McBreen");
                                System.out.println("Lesson" + currentLesson +"." + panelState + ".html");
			}
	}
public String getWindowSize()
{
    return currentSize;
}
public void setWindowSize(String var)
{
    currentSize = var;
}
private class buttonListener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == l1)
        {
            lesson = new JEditorPane();
            remove(l1);
            remove(l2);
            remove(l3);
            updateUI();
            add(lesson);
            scrollPane = new JScrollPane(lesson);
            scrollPane.setLocation(10, 10);
            if(currentSize.equals("min"))
            {
                scrollPane.setSize(new Dimension(320, 250));
                next.setBounds(120, 260, 100, 25);
                prev.setBounds(10, 260, 100, 25);
                goBack.setBounds(230, 260, 100, 25);
            }
            if(currentSize.equals("max"))
            {
                scrollPane.setSize(new Dimension(750, 400));
                next.setBounds(800, 300, 100, 25);
                prev.setBounds(800, 350, 100, 25);
                goBack.setBounds(800, 400, 100, 25);
            }
            add(scrollPane);
            changeLesson(1);
            //currentLesson = 1;
            add(next);
            add(prev);
            add(goBack);
        }
        if(event.getSource() == l2)
        {
            lesson = new JEditorPane();
            remove(l1);
            remove(l2);
            remove(l3);
            updateUI();
            add(lesson);
            scrollPane = new JScrollPane(lesson);
            scrollPane.setLocation(10, 10);
            if(currentSize.equals("min"))
            {
                scrollPane.setSize(new Dimension(325, 250));
                next.setBounds(120, 260, 100, 25);
                prev.setBounds(10, 260, 100, 25);
                goBack.setBounds(230, 260, 100, 25);
            }
            if(currentSize.equals("max"))
            {
                scrollPane.setSize(new Dimension(750, 400));
                next.setBounds(800, 300, 100, 25);
                prev.setBounds(800, 350, 100, 25);
                goBack.setBounds(800, 400, 100, 25);
            }
            add(scrollPane);
            changeLesson(2);
            //currentLesson = 2;
            add(next);
            add(prev);
            add(goBack);
        }
        if(event.getSource() == l3)
        {
            lesson = new JEditorPane();
            remove(l1);
            remove(l2);
            remove(l3);
            updateUI();
            add(lesson);
            scrollPane = new JScrollPane(lesson);
            scrollPane.setLocation(10, 10);
            if(currentSize.equals("min"))
            {
                scrollPane.setSize(new Dimension(325, 250));
                next.setBounds(120, 260, 100, 25);
                prev.setBounds(10, 260, 100, 25);
                goBack.setBounds(230, 260, 100, 25);
            }
            if(currentSize.equals("max"))
            {
                scrollPane.setSize(new Dimension(750, 400));
                next.setBounds(800, 300, 100, 25);
                prev.setBounds(800, 350, 100, 25);
                goBack.setBounds(800, 400, 100, 25);
            }
            add(scrollPane);
            changeLesson(3);
            //currentLesson = 3;
            add(next);
            add(prev);
            add(goBack);
        }
        if(event.getSource() == next)
        {
            if((panelState + 1) != 7)
            {
                panelState++;
                updatePanel();
                //changeLesson(currentLesson);
                updateUI();
            }
        }
        if(event.getSource() == prev)
        {
            if((panelState - 1) != 0)
            {
                panelState--;
                updatePanel();
                //changeLesson(panelState);
                updateUI();
            }
        }
        if(event.getSource() == goBack)
        {
            remove(lesson);
            remove(scrollPane);
            remove(next);
            remove(prev);
            remove(goBack);
            updateUI();
            add(l1);
            add(l2);
            add(l3);
            currentLesson = 0;
            panelState = 1;
        }

    }
    
    
}


}

