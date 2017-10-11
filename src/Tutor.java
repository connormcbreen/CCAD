/**
* Tutor.Java loads HTML files into a JScrollPane to display previously created
* lesson slides in order to teach a subject.
* (Recitation Project 3
* Completion time: 5
*
* @author Connor McBreen
* @version version 2.0
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
		int subLesson = 1;					//The initial state of the JPanel, shows authors name, changes based off slider position
                int currentLesson = 0;
                int panelState = 0;
                JEditorPane lesson;
                static JEditorPane formula;
                JScrollPane scrollPane;
                static JScrollPane formulaPane;
                JButton l1;
                JButton l2;
                JButton l3;
                JButton next;
                JButton prev;   
                JButton goBack;
                String currentSize = "min";
                static boolean flag = false;
                static JFrame popOut;
	public Tutor()
	   {
            setLayout(null);
            popOut = new JFrame();
            popOut.setSize(350, 350);
            popOut.setLayout(new CardLayout());
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
            formula = new JEditorPane();
            formulaPane = new JScrollPane(formula);
            popOut.add(formulaPane, "1");
            loadFormulaSheet();
            popOut.setVisible(false);
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
	  			lesson.setPage(Tutor.class.getResource("Lesson" + currentLesson +"." + subLesson + ".html"));	//Finds the local html file and sets the EditorPane to the HTML file
                                System.out.println("Lesson" + currentLesson +"." + subLesson + ".html");
			}
			catch(FileNotFoundException e)					//File not found exception, in case file doesnt not exist
			{
				System.err.println("Lesson" + currentLesson +"." + subLesson + ".html");
				lesson.setText("Lesson" + currentLesson +"." + subLesson + ".html");
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
                                System.out.println("Lesson" + currentLesson +"." + subLesson + ".html");
			}
	}
        public static void loadFormulaSheet()
        {
            try							//Try statement to open and read an html file, has FileNotFound and IO exceptions
			{
                                Document docF = formula.getDocument();
                                docF.putProperty(Document.StreamDescriptionProperty, null);
                                formula.setContentType("text/html");
                                formula.setPage(Tutor.class.getResource("formulasheet.html"));
			}
			catch(FileNotFoundException e)					//File not found exception, in case file doesnt not exist
			{
				System.err.println("Caught FileNotFoundException: " + e.getMessage());
                                formula.setText("Caught FileNotFoundException:" + e.getMessage());
			}
			catch(IOException e)						//IOException if issues occur when opening or closing HTML files
			{
				System.err.println("Caught IOException: " + e.getMessage());
				formula.setText("Caught IOException: " + e.getMessage());
			}
        }
public int getCurrentLesson()
{
    return currentLesson;
}

public void setWindowSize(String var)
{
    currentSize = var;
}

public void updateLesson(int lessonNum)
{
    lesson = new JEditorPane();
    remove(l1);
    remove(l2);
    remove(l3);
    updateUI();
    add(lesson);
    scrollPane = new JScrollPane(lesson);
    scrollPane.setLocation(10, 10);
    resize();
    add(scrollPane);
    changeLesson(lessonNum);
    add(next);
    add(prev);
    add(goBack);
}
public void changeLesson(int state)			//changeState method, interacts with the slider to change the html file displayed based of the slider number
	{
		currentLesson = state;
                System.out.println(currentLesson);
		if(state <= 3 && state >= 1)		//Only has 4 states, 1, 2, 3, and 4
		{
			updatePanel();			//Calls the updatePanel method and feeds through slider input
		}
		else					//Does not change if a value is out of range
		{
		}
	}
private class buttonListener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == l1)
        {
            panelState = 1;
            updateLesson(1);
        }
        if(event.getSource() == l2)
        {
            panelState = 1;
            updateLesson(2);
        }
        if(event.getSource() == l3)
        {
            panelState = 1;
            updateLesson(3);
        }
        if(event.getSource() == next)
        {
            if((subLesson + 1) != 7)
            {
                subLesson++;
                updatePanel();
                updateUI();
            }
        }
        if(event.getSource() == prev)
        {
            if((subLesson - 1) != 0)
            {
                subLesson--;
                updatePanel();
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
            subLesson = 1;
            panelState = 0;
        }
    } 
}
public static void showFormulaSheet()
{
    if(flag == false)
            {
            popOut.setVisible(true);
            flag = true;
            }
            else
            {
                popOut.setVisible(false);
                flag = false;
            }
}
public void resize()
{
    if(panelState == 0)
    {
        if(currentSize.equals("min"))
            {
            l1.setBounds(25, 25, 100, 50);
            l2.setBounds(25, 100, 100, 50);
            l3.setBounds(25, 175, 100, 50);
            }
            if(currentSize.equals("max"))
            {
              l1.setBounds(25, 25, 200, 50);
              l2.setBounds(25, 100, 200, 50);
              l3.setBounds(25, 175, 200, 50);
            }
    }
    if(panelState == 1)
    {
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
    }
}

}