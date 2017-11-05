/**
* Quiz.Java checks the current lesson in progress and creates a quiz
* using previously created questions corresponding to the lessons and
* checking the correct answer with a submit button
* Assignment Number: Recitation Project 3
* Completion time: 7 hours
*
* @author Connor McBreen
* @version version 1.0
*/
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Quiz extends JPanel {
    
    private Tutor tutorPanel;
	private JButton Ans1;               //The four answer buttons to be displayed
	private JButton Ans2;
	private JButton Ans3;
	private JButton Ans4;
	
	private JButton nextButton;         //Next button, start button, submit, goback, general navigation buttons for the quiz
        private JButton startButton;
        private JButton submit;
        private JButton goBack;
        private JButton returnToMenu;
        private JButton showFormulaSheet;
        ControlCenter grade = new ControlCenter();        //Grader implementation, allows for the tracking of a users score on the quiz and update their profile
	Questions questions;
	String [] qarray;                   //Array for containing the question
	int state;
        String finalAnswer = "";            //Final answer for comparison and evaluation
        int panelState;
        String currentSize;
        //Label
        public JLabel alert;
        public JTextArea question;
	
	public Quiz(Tutor tutor) {          //THE CONSTRUCTOR, Uses tutor.java as a parameter to gain access to a users current lesson status
                this.tutorPanel = tutor;
                setLayout(null);
		questions = new Questions();
		state = 0;
                currentSize = "min";
                panelState = 0;
		startButton = new JButton("Start Quiz");            //Custom set for Start and return to menu buttons.
                startButton.setBounds(100, 100, 100, 50);
                returnToMenu = new JButton("Return to Menu");
                returnToMenu.setBounds(100, 200, 200, 50);
                questions = new Questions();
		showFormulaSheet = new JButton("Formula Sheet");    //Formula sheet button to display formula sheet during the Quiz
                alert = new JLabel();
                question = new JTextArea();
                TextualFeedback textPopup = new TextualFeedback();

		//Answer buttons
		Ans1 = new JButton();
		Ans2 = new JButton();
		Ans3 = new JButton();
		Ans4 = new JButton();
                submit = new JButton("Submit Answer");
                nextButton = new JButton("Next");
                goBack = new JButton("Go Back");
		
                startButton.addActionListener(new buttonListener());        //All buttons have buttonlisteners
                Ans1.addActionListener(new buttonListener());
                Ans2.addActionListener(new buttonListener());
                Ans3.addActionListener(new buttonListener());
                Ans4.addActionListener(new buttonListener());
                submit.addActionListener(new buttonListener());
                goBack.addActionListener(new buttonListener());
                nextButton.addActionListener(new buttonListener());
                returnToMenu.addActionListener(new buttonListener());
                showFormulaSheet.addActionListener(new buttonListener());
		add(startButton);
                add(returnToMenu);
	}
        public void updateQuestion(int x, int y)        //Update Question takes lesson and question number as parameter and returns a question from the questions.java class
        {
            removeAll();
            qarray = questions.getQuestion(x, y);       //All parts of a question are stored in a string array, the parts are put in their appropriate places
			Ans1.setText(qarray[1]);
			Ans2.setText(qarray[2]);
			Ans3.setText(qarray[3]);
			Ans4.setText(qarray[4]);
			question.setText(qarray[0]);
			add(question);
			add(Ans1);
			add(Ans2);
			add(Ans3);
			add(Ans4);
                        add(submit);
                        add(nextButton);
                        add(showFormulaSheet);
                        System.out.print(state);
                        updateUI();
        }
    public String getCurrentQuestion(int x, int y, int z)       //Get current Question, necessary for submit answer comparisons
        {
            qarray = questions.getQuestion(x, y);
            return qarray[z];
        }
    public void setWindowSize(String var)           //Used by resize() same as Tutor.Java
    {
    currentSize = var;
    }
    public void resize()                            //Same resize() as Tutor.java, but adjusted for Quiz components
    {
     if(panelState == 0)
     {
            if(currentSize.equals("min"))
            {
                alert.setBounds(75, 25, 200, 50);
                startButton.setBounds(100, 100, 100, 50);
                goBack.setBounds(100, 100, 100, 100);
                returnToMenu.setBounds(100, 200, 200, 50);
            }
            if(currentSize.equals("max"))
            {
                alert.setBounds(75, 25, 200, 50);
                startButton.setBounds(100, 100, 200, 50);
                goBack.setBounds(100, 100, 200, 50);
                returnToMenu.setBounds(100, 200, 200, 50);
            }
        
    }
    if(panelState == 1)
    {
        if(currentSize.equals("min"))
            {
                Ans1.setBounds(25, 25, 100, 50);
                Ans2.setBounds(25, 85, 100, 50);
                Ans3.setBounds(25, 145, 100, 50);
                Ans4.setBounds(25, 205, 100, 50);
                question.setBounds(150, 25, 175, 100);
                submit.setBounds(200, 220, 130, 25);
                nextButton.setBounds(200, 250, 130, 25);
                showFormulaSheet.setBounds(200, 170, 130, 25);
            }
            if(currentSize.equals("max"))
            {
                Ans1.setBounds(25, 25, 200, 50);
                Ans2.setBounds(25, 105, 200, 50);
                Ans3.setBounds(25, 185, 200, 50);
                Ans4.setBounds(25, 265, 200, 50);
                question.setBounds(450, 25, 350, 200);
                submit.setBounds(470, 345, 200, 50);
                nextButton.setBounds(470, 425, 200, 50);
                showFormulaSheet.setBounds(470, 265, 200, 50);
            }
    }
}
    public class buttonListener implements ActionListener {         //All the button Listeners
		public void actionPerformed(ActionEvent event) 
                {
                        if(event.getSource() == startButton)        //Starts the quiz by getting first question and loading the quiz UI
                        {
                            state = 0;
                            if(tutorPanel.getCurrentLesson() == 0)
                            {
                                 resize();
                                 alert.setText("You have not selected a lesson yet");
                                 add(alert);
                                 updateUI();
                            }
                            else if(tutorPanel.getCurrentLesson() >= 1 && tutorPanel.getCurrentLesson() <= 3)
                            {
                                remove(startButton);
                                panelState = 1;
                                resize();
                                updateQuestion(tutorPanel.getCurrentLesson() - 1, state);
                                System.out.println("Banana");    
                            }
     
                        }
                        if(event.getSource() == Ans1)            // Sets final answer equal to the users most recent answer
                        {
                            finalAnswer = getCurrentQuestion(tutorPanel.getCurrentLesson() - 1, state, 1);
                        }
                        if(event.getSource() == Ans2)
                        {
                            finalAnswer = getCurrentQuestion(tutorPanel.getCurrentLesson() - 1, state, 2);
                        }
                        if(event.getSource() == Ans3)
                        {
                            finalAnswer = getCurrentQuestion(tutorPanel.getCurrentLesson() - 1, state, 3);
                        }
                        if(event.getSource() == Ans4)
                        {
                            finalAnswer = getCurrentQuestion(tutorPanel.getCurrentLesson() - 1, state, 4);
                        }
                        if(event.getSource() == submit)     // Submit, compares the right answer with the users answer, display an appropriate dialog
                        {
                         if(finalAnswer.equals(getCurrentQuestion(tutorPanel.getCurrentLesson() - 1, state, 5)))
                         {
                            System.out.println("Correct");
                             grade.comprehensionAnswerCorrect();        //Grader keeps track of score and computes a grade upon completion
                             TextualFeedback.infoBox("Woo hoo! you got it right. Keep working hard!", "Winner-Winner Chicken Dinner!");
                         }
                         else 
                         {
                             grade.comprehensionAnswerWrong();
                             TextualFeedback.infoBox("Uh oh... That doesn't look right. Try again!", "Everybody makes mistakes.");
                         }
                        }
			if(event.getSource() == nextButton)     //Next button goes to next question
                        {
                            state++;
                            if (state < 5)
                            {
                                resize();
                                if(tutorPanel.getCurrentLesson() != 0)
                                {
                                updateQuestion(tutorPanel.getCurrentLesson() - 1, state);
                                }
                            }
                            else        //Upon Quiz completion, a goback button appears to return to start quiz panel
                            {
                                removeAll();        
                                panelState = 0;
                                resize();
                                alert.setText("You have finished Quiz " + tutorPanel.getCurrentLesson());
                                add(alert);
                                add(goBack);
                                updateUI();
                            }
			}
                        if(event.getSource() == goBack)     //Go back returns user to beginning quiz panel
                        {
                            removeAll();
                            resize();
                            add(startButton);
                            add(returnToMenu);
                            state = 0;
                            updateUI();
                        }
                        if(event.getSource() == showFormulaSheet)       //Shows formula sheet
                        {
                            Tutor.showFormulaSheet();
                        }
                        if(event.getSource() == returnToMenu)           //Returns user to main menu
                        {
                            CardLayoutPanel.resetPanel();
                        }
		}
	}
}
