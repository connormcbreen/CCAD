/**
* Tutor.Java loads HTML files into a JScrollPane to display previously created
* lesson slides in order to teach a subject.
* Recitation Project 3
* Completion time: 7 hours
*
* @author Connor McBreen
* @version version 2.0
*/
import java.awt.*;
import javax.swing.*;		
import javax.swing.JEditorPane;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;			

public class Tutor extends JPanel
{
                int parentLesson = 0;
		int subLesson = 1;                  //Sublessons used to cycle HTML files, will only go from 1 to 6			
                int currentLesson = 0;              //Current Lesson is used to determine which set of HTML files to import
                int panelState = 0;
                int currentState = 1;
                int subLessonPane= 1;
                JEditorPane lesson;                 //A JEditorPane used to load HTML files
                static JEditorPane formula;         //A JScrollPane to contain the JEditorPane implementing scroll bars
                JScrollPane scrollPane;
                static JScrollPane formulaPane;
                JButton l1;                         //Buttons corresponding to Lessons 1,2,3
                JButton l2;
                JButton l3;
                JButton l11;
                JButton l12;
                JButton l13;
                JButton l21;
                JButton l22;
                JButton l23;
                JButton l31;
                JButton l32;
                JButton l33;
                JButton next;                       //Next and Previous buttons for cycling lesson slides
                JButton prev;   
                JButton goBack;                     //Go Back returns to lesson selection
                JButton goUp;
                String currentSize = "min";         //Used for the resize() function to adjust the GUI
                static boolean flag = false;        //Also used for resize()
                static JFrame popOut;               //A popout frame to display the formula sheet
                ProgressBar lessonsBar;
                
	public Tutor(ProgressBar newBar)        //THE CONSTRUCTOR
	   {
			
			this.lessonsBar = newBar;
            setLayout(null);
            popOut = new JFrame();
            popOut.setSize(350, 350);
            popOut.setLayout(new CardLayout());
            lesson = new JEditorPane(); 
            l1 = new JButton("Lesson1");
            l1.setBounds(25, 25, 100, 50);          //Sets the size and placement for all the buttons in the lesson display panel
            l2 = new JButton("Lesson2");
            l2.setBounds(25, 100, 100, 50);
            l3 = new JButton("Lesson3");
            l3.setBounds(25, 175, 100, 50);
            l11 = new JButton("Lesson1.1");
            l11.setBounds(25, 25, 100, 50);          //Sets the size and placement for all the buttons in the lesson display panel
            l12 = new JButton("Lesson1.2");
            l12.setBounds(25, 100, 100, 50);
            l13 = new JButton("Lesson1.3");
            l13.setBounds(25, 175, 100, 50);
            l21 = new JButton("Lesson2.1");
            l21.setBounds(25, 25, 100, 50);          //Sets the size and placement for all the buttons in the lesson display panel
            l22 = new JButton("Lesson2.2");
            l22.setBounds(25, 100, 100, 50);
            l23 = new JButton("Lesson2.3");
            l23.setBounds(25, 175, 100, 50);
            l31 = new JButton("Lesson3.1");
            l31.setBounds(25, 25, 100, 50);          //Sets the size and placement for all the buttons in the lesson display panel
            l32 = new JButton("Lesson3.2");
            l32.setBounds(25, 100, 100, 50);
            l33 = new JButton("Lesson3.3");
            l33.setBounds(25, 175, 100, 50);
            next = new JButton("Next");
            prev = new JButton("Previous");
            goBack = new JButton("Go Back");
            goUp = new JButton("Go Back");
            goUp.setBounds(25, 250, 100, 50);
           
            l1.addActionListener(new buttonListener());     //Actionlisteners added to each button
            l2.addActionListener(new buttonListener());
            l3.addActionListener(new buttonListener());
            l11.addActionListener(new buttonListener());     //Actionlisteners added to each button
            l12.addActionListener(new buttonListener());
            l13.addActionListener(new buttonListener());
            l21.addActionListener(new buttonListener());     //Actionlisteners added to each button
            l22.addActionListener(new buttonListener());
            l23.addActionListener(new buttonListener());
            l31.addActionListener(new buttonListener());     //Actionlisteners added to each button
            l32.addActionListener(new buttonListener());
            l33.addActionListener(new buttonListener());
            next.addActionListener(new buttonListener());
            prev.addActionListener(new buttonListener());
            goBack.addActionListener(new buttonListener());
            goUp.addActionListener(new buttonListener());
            
            add(l1);
            add(l2);
            add(l3);   
            scrollPane = new JScrollPane();
            formula = new JEditorPane();
            formulaPane = new JScrollPane(formula);
            popOut.add(formulaPane, "1");
            loadFormulaSheet();                             //This code implements and creates the formula sheet panel and sets it to invisible
            popOut.setVisible(false);
		}
        
	public void updatePane()				//updatePanel method, updates the display on the panel by finding html file and displaying it
	{
		if(currentLesson <= 3 && currentLesson >= 1)
		{
			try							//Try statement to open and read an html file, has FileNotFound and IO exceptions
			{
				Document doc = lesson.getDocument();
				doc.putProperty(Document.StreamDescriptionProperty, null);	//Clears out the input stream for refreshing the same page multiple times
                                lesson.setContentType("text/html");				//Sets the content type of the JEditorPane for text based HTML files
	  			lesson.setPage(Tutor.class.getResource("Lesson" + currentLesson +"." + subLesson+ "" + subLessonPane + ".html"));	//Finds the local html file and sets the EditorPane to the HTML file
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
        public static void loadFormulaSheet()       //Imports a the single formula sheet file and displays it
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
public int getCurrentLesson()       //Returns currentLesson value, used in Quiz to import the proper question set
{
    return currentLesson;
}

public void setWindowSize(String var)  //Part of the resize() functionality, specifically called in Universe upon maximizing or minimizing the JFrame
{
    currentSize = var;
}
public void updatePanel(int val, int level)
{
    if(val == 1 && level == 0)
    {
        removeAll();
        add(l1);
        add(l2);
        add(l3);
        updateUI();
    }
    if(val == 2 && level == 1)
    {
        removeAll();
        add(l11);
        add(l12);
        add(l13);
        add(goUp);
        updateUI();
    }
    if(val == 2 && level == 2)
    {
        removeAll();
        add(l21);
        add(l22);
        add(l23);
        add(goUp);
        updateUI();
    }
    if(val == 2 && level == 3)
    {
        removeAll();
        add(l31);
        add(l32);
        add(l33);
        add(goUp);
        updateUI();
    }
}
public void updateLesson(int lessonNum, int num)     //Used to update the tutorPanel whenever lesson 1,2,3 are clicked.
{
    removeAll();
    lesson = new JEditorPane();
    updateUI();
    add(lesson);
    scrollPane = new JScrollPane(lesson);
    scrollPane.setLocation(10, 10);
    resize();
    add(scrollPane);
    subLesson = num;
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
			updatePane();			//Calls the updatePanel method and feeds through slider input
		}
		else					//Does not change if a value is out of range
		{
		}
	}
private class buttonListener implements ActionListener      //Button Listeners for every button
{
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == l1)     //Lesson1 button listener
        {
            panelState = 1;
            parentLesson = 1;
            updatePanel(2, 1);
            //updateLesson(1);
        }
        if(event.getSource() == l2)     //Lesson2 button listener
        {
            panelState = 1;
            parentLesson = 2;
            updatePanel(2, 2);
            //updateLesson(2);
        }
        if(event.getSource() == l3)     //Lesson3 button listener
        {
            panelState = 1;
            parentLesson = 3;
            updatePanel(2, 3);
            //updateLesson(3);
        }
        if(event.getSource() == l11)     //Lesson3 button listener
        {
            updateLesson(1, 1);
        }
        if(event.getSource() == l12)     //Lesson3 button listener
        {
            updateLesson(1, 2);
        }
        if(event.getSource() == l13)     //Lesson3 button listener
        {
            updateLesson(1, 3);
        }
        if(event.getSource() == l21)     //Lesson3 button listener
        {
            updateLesson(2, 1);
        }
        if(event.getSource() == l22)     //Lesson3 button listener
        {
            updateLesson(2, 2);
        }
        if(event.getSource() == l23)     //Lesson3 button listener
        {
            updateLesson(2, 3);
        }
        if(event.getSource() == l31)     //Lesson3 button listener
        {
            updateLesson(3, 1);
        }
        if(event.getSource() == l32)     //Lesson3 button listener
        {
            updateLesson(3, 2);
        }
        if(event.getSource() == l33)     //Lesson3 button listener
        {
            updateLesson(3, 3);
        }
        if(event.getSource() == next)   //Next button, increments sublesson and updatesPanel
        {
            if(currentLesson == 1)
            {
                if(subLesson == 1)
                {
            		if(subLessonPane == 7) {
            			lessonsBar.changeLessonProgress(currentLesson, subLesson);
            		}
            		
                    if((subLessonPane + 1) != 8)
                    {
                        UserProgress.completeLesson(currentLesson, subLesson);  //Calls userprogress to track which slides the user has viewed
                        subLessonPane++;
                        updatePane();
                        updateUI();
                    }
                }
                if(subLesson == 2 || subLesson == 3)
                {
            		if(subLessonPane ==6) {
            			lessonsBar.changeLessonProgress(currentLesson, subLesson);
            		}
                    if((subLessonPane + 1) != 7)
                    {
                        UserProgress.completeLesson(currentLesson, subLesson);  //Calls userprogress to track which slides the user has viewed
                    
                        subLessonPane++;
                        updatePane();
                        updateUI();
                    }
                    
                }
            }
            if(currentLesson == 2)
            {
                if(subLesson == 1 || subLesson == 2)
                {
            		if(subLessonPane == 5) {
            			lessonsBar.changeLessonProgress(currentLesson, subLesson);
            		}
            		
                    if((subLessonPane + 1) != 6)
                    {
                        UserProgress.completeLesson(currentLesson, subLesson);  //Calls userprogress to track which slides the user has viewed
                        subLessonPane++;
                        updatePane();
                        updateUI();
                    }
                }
                if(subLesson == 3)
                {
            		if(subLessonPane == 6) {
            			lessonsBar.changeLessonProgress(currentLesson, subLesson);
            		}
                    if((subLessonPane + 1) != 7)
                    {
                        UserProgress.completeLesson(currentLesson, subLesson);  //Calls userprogress to track which slides the user has viewed
                    
                        subLessonPane++;
                        updatePane();
                        updateUI();
                    }
                    
                }
            }
            if(currentLesson == 3)
            {
                if(subLesson == 1)
                {
            		if(subLessonPane == 5) {
            			lessonsBar.changeLessonProgress(currentLesson, subLesson);
            		}
            		
                    if((subLessonPane + 1) != 6)
                    {
                        UserProgress.completeLesson(currentLesson, subLesson);  //Calls userprogress to track which slides the user has viewed
                        subLessonPane++;
                        updatePane();
                        updateUI();
                    }
                }
                if(subLesson == 2 || subLesson == 3)
                {
            		if(subLessonPane ==7) {
            			lessonsBar.changeLessonProgress(currentLesson, subLesson);
            		}
                    if((subLessonPane + 1) != 8)
                    {
                        UserProgress.completeLesson(currentLesson, subLesson);  //Calls userprogress to track which slides the user has viewed
                    
                        subLessonPane++;
                        updatePane();
                        updateUI();
                    }
                    
                }
            }
        }
        if(event.getSource() == prev)       //Previous button, cycles backwards and updatesPanel
        {
            if((subLessonPane - 1) != 0)
            {
                subLessonPane--;
                updatePane();
                updateUI();
            }
        }
        if(event.getSource() == goBack)     //GoBack button returns user to lesson selection
        {
            updatePanel(2, currentLesson);
            subLessonPane = 1;
            //currentLesson = 0;
            //subLesson = 1;
            //panelState = 0;
        }
        if(event.getSource() == goUp)
        {
                updatePanel(1, 0);
        }
    } 
}
public static void showFormulaSheet()   //Shows the formula sheet and hides it if visible
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
public void resize()            //Resize() used to dynamically adjust size of custom set components using a maximize button call in universe
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
                scrollPane.setSize(new Dimension(750, 450));
                next.setBounds(800, 300, 100, 25);
                prev.setBounds(800, 350, 100, 25);
                goBack.setBounds(800, 400, 100, 25);
            }
    }
}

}