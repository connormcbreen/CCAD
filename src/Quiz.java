/**
* Quiz.Java checks the current lesson in progress and creates a quiz
* using previously created questions corresponding to the lessons and
* checking the correct answer with a submit button
* Recitation Project 3
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
import java.lang.System;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.util.*;

public class Quiz extends JPanel {
    
        private Tutor tutorPanel;
	private JButton Ans1;               //The four answer buttons to be displayed
	private JButton Ans2;
	private JButton Ans3;
	private JButton Ans4;
	Grader grade;
	private JButton nextButton;         //Next button, start button, submit, goback, general navigation buttons for the quiz
        private JButton startButton;
        private JButton submit;
        private JButton goBack;
        private JButton returnToMenu;
        private JButton showFormulaSheet;
        ControlCenter Controller = ControlCenter.getInstance();       //Grader implementation, allows for the tracking of a users score on the quiz and update their profile
	Questions questions;
	String [] qarray;                   //Array for containing the question
	int state;
        String finalAnswer = "";            //Final answer for comparison and evaluation
        int panelState;
        String currentSize;
        long start;
        long finish;
        public double [] questionTimes = new double[5];
        public int [] score = new int[5];
        //Label
        public JLabel alert;
        public JTextArea totalScore;
        public JTextArea question;
        public ProgressBar assessmentBar;
	DecimalFormat df = new DecimalFormat("#.##");
	public Quiz(Tutor tutor, Grader newGrade, ProgressBar bar) 
        {          //THE CONSTRUCTOR, Uses tutor.java as a parameter to gain access to a users current lesson status
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
		showFormulaSheet = new JButton("Formula Sheet");    //Formula sheet button to display formula sheet during the Quiz
                alert = new JLabel();
                totalScore = new JTextArea();
                totalScore.setLineWrap(true);
                //avgTime = new JLabel();
                question = new JTextArea();
                TextualFeedback textPopup = new TextualFeedback();
                this.grade = newGrade;
                this.assessmentBar = bar;
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
    public void questionTime(long x, long y, int z)
    {
        long time = (y - x)/100000000;
        double finalTime = (double)time;
        questionTimes[z] = finalTime/10.0;
        Controller.writeToTimeSpentArray(finalTime/10.0);
    }
    public double[] returnQuestionTimes()
    {
        return questionTimes;
    }
    public double returnAvgQTime()
    {
        double avgQTime = 0.0;
        for(int i = 0; i < 5; i++)
        {
            avgQTime += questionTimes[i];


        }
        return (avgQTime/5.0);
    }
    public String finalScore()
    {
        String fScore = "";
        String temp;
        fScore = "Your average time per Question was " + String.valueOf(df.format(returnAvgQTime())) + "\n";

        for(int i =0; i < 5; i ++)
        {
          if(score[i] == 1)
          {
              temp = "Question " + (i + 1) + " Correct\n";
              fScore += temp;
          }
          else
          {
              temp = "Question " + (i + 1) + " Incorrect\n";
              fScore += temp;
          }
        }
        return fScore;
    }
    public void resize()                            //Same resize() as Tutor.java, but adjusted for Quiz components
    {
     if(panelState == 0)
     {
            if(currentSize.equals("min"))
            {
                alert.setBounds(75, 25, 200, 40);
                totalScore.setBounds(25, 25, 150, 150);
                startButton.setBounds(100, 100, 100, 50);
                goBack.setBounds(200, 150, 200, 50);
                returnToMenu.setBounds(100, 200, 200, 50);
            }
            if(currentSize.equals("max"))
            {
                alert.setBounds(75, 25, 200, 40);
                totalScore.setBounds(25, 25, 150, 150);
                startButton.setBounds(100, 100, 200, 50);
                goBack.setBounds(200, 150, 200, 50);
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
    public class buttonListener implements ActionListener 
    {         //All the button Listeners
		public void actionPerformed(ActionEvent event) 
                {
                        if(event.getSource() == startButton)        //Starts the quiz by getting first question and loading the quiz UI
                        {
                            state = 0;
                            assessmentBar.changeAssessmentProgress(state);
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
                                start = System.nanoTime();
                               // grade.changeState(2);
                                System.out.println(start);
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
                            score[state] = 1;
                            Controller.writeToCorrectArray(true);
                            Controller.updateTotalQuestions();
                            Controller.calculateStatus();
                            grade.changeFeedbackText("correct, you are a super genius!");
                            grade.changeState(1);
                           //  grade.changeAvatarBasedOnGrade(Controller.calculateStatus());
                           //  grade.comprehensionAnswerCorrect();        //Grader keeps track of score and computes a grade upon completion
                            // TextualFeedback.infoBox("Woo hoo! you got it right. Keep working hard!", "Winner-Winner Chicken Dinner!");
                         }
                         else 
                         {
                             score[state] = 0;
                             Controller.writeToIncorrectArray(true);
                             Controller.updateTotalQuestions();
                             Controller.calculateStatus();
                          //   grade.comprehensionAnswerWrong();
                            grade.changeFeedbackText("you're a dumb dumb...");
                            grade.changeState(4);
                             //grade.changeAvatarBasedOnGrade(Controller.calculateStatus());
                            // TextualFeedback.infoBox("Uh oh... That doesn't look right. Try again!", "Everybody makes mistakes.");
                         }
                        }
			if(event.getSource() == nextButton)     //Next button goes to next question
                        {
                            finish = System.nanoTime();
                            System.out.println(finish);
                            questionTime(start, finish, state);
                            state++;
                            assessmentBar.changeAssessmentProgress(state);
                            if (state < 5)
                            {
                                resize();
                                if(tutorPanel.getCurrentLesson() != 0)
                                {
                                updateQuestion(tutorPanel.getCurrentLesson() - 1, state);
                                start = System.nanoTime();
                                grade.changeState(2);
                                // grade.changeAvatarBasedOnGrade(Controller.calculateStatus());
                                System.out.println(start);
                                }
                            }
                            else        //Upon Quiz completion, a goback button appears to return to start quiz panel
                            {
                                removeAll();        
                                panelState = 0;
                                resize();
                                alert.setText("You have finished Quiz " + tutorPanel.getCurrentLesson());
                                for(int i = 0; i < 5; i++)
                                {
                                    System.out.println(questionTimes[i]);
                                }
                                //avgTime.setText("Your average time per question was" + String.valueOf(returnAvgQTime()));
                                totalScore.setText(finalScore());
                                add(totalScore);
                                //add(alert);
                                add(goBack);
                                updateUI();
                            }

			}
                        if(event.getSource() == goBack)     //Go back returns user to beginning quiz panel
                        {
                            Controller.resetEverything();
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
