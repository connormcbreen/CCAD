
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author conno_000
 */
public class Test extends JPanel
{
   // private Tutor tutorPanel;
	private JButton Ans1;               //The four answer buttons to be displayed
	private JButton Ans2;
	private JButton Ans3;
	private JButton Ans4;
	
	private JButton nextButton;         //Next button, start button, submit, goback, general navigation buttons for the quiz
        private JButton startButton;
        private JButton submit;
        private JButton showFormulaSheet;
        Grader grade = new Grader();        //Grader implementation, allows for the tracking of a users score on the quiz and update their profile
	Questions questions;
	String [] qarray;                   //Array for containing the question
	int state;
        String finalAnswer = "";            //Final answer for comparison and evaluation
        int panelState;
        String currentSize;
        
        //Label
        public JLabel alert;
        public JLabel score;
        public JTextArea question;
	
	public Test() 
        {
            setLayout(null);
            questions = new Questions();
            state = 0;
            startButton = new JButton("Start Test");
            startButton.setBounds(175, 175, 150, 75);
            showFormulaSheet = new JButton("Formula Sheet");
            alert = new JLabel();
            question = new JTextArea();
            
            //Answer Buttons
            Ans1 = new JButton();
            Ans2 = new JButton();
            Ans3 = new JButton();
            Ans4 = new JButton();
            submit = new JButton("Submit Answer");
            nextButton = new JButton("Next Question");
            
             Ans1.setBounds(50, 50, 100, 50);
             Ans2.setBounds(50, 110, 100, 50);
             Ans3.setBounds(50, 170, 100, 50);
             Ans4.setBounds(50, 230, 100, 50);
             question.setBounds(150, 25, 175, 100);
             submit.setBounds(200, 220, 130, 25);
             nextButton.setBounds(200, 250, 130, 25);
             showFormulaSheet.setBounds(200, 170, 130, 25);
             alert.setBounds(175, 175, 150, 75);
            
            startButton.addActionListener(new Test.buttonListener());        //All buttons have buttonlisteners
            Ans1.addActionListener(new Test.buttonListener()); 
            Ans2.addActionListener(new Test.buttonListener()); 
            Ans3.addActionListener(new Test.buttonListener()); 
            Ans4.addActionListener(new Test.buttonListener()); 
            submit.addActionListener(new Test.buttonListener()); 
            nextButton.addActionListener(new Test.buttonListener()); 
            showFormulaSheet.addActionListener(new Test.buttonListener()); 
            add(startButton);
        }
        public void updateQuestion(int x, int y)        //Update Question takes lesson and question number as parameter and returns a question from the questions.java class
        {
            System.out.print("update question");
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
            revalidate();
            updateUI();
        }
    public String getCurrentQuestion(int x, int y, int z)       //Get current Question, necessary for submit answer comparisons
        {
            qarray = questions.getQuestion(x, y);
            return qarray[z];
        }
    public class buttonListener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
         if(event.getSource() == startButton)        //Starts the quiz by getting first question and loading the quiz UI
                        {
                                state = 0;
                                System.out.print("carrot");
                                remove(startButton);
                                //panelState = 1;
                                updateQuestion(3, state);
                                System.out.println("Banana");    
     
                        }
                        if(event.getSource() == Ans1)            // Sets final answer equal to the users most recent answer
                        {
                            finalAnswer = getCurrentQuestion(3, state, 1);
                        }
                        if(event.getSource() == Ans2)
                        {
                            finalAnswer = getCurrentQuestion(3, state, 2);
                        }
                        if(event.getSource() == Ans3)
                        {
                            finalAnswer = getCurrentQuestion(3, state, 3);
                        }
                        if(event.getSource() == Ans4)
                        {
                            finalAnswer = getCurrentQuestion(3, state, 4);
                        }
                        if(event.getSource() == submit)     // Submit, compares the right answer with the users answer, display an appropriate dialog
                        {
                         if(finalAnswer.equals(getCurrentQuestion(3, state, 5)))
                         {
                            System.out.println("Correct");
                            // grade.comprehensionAnswerCorrect();        //Grader keeps track of score and computes a grade upon completion
                             TextualFeedback.infoBox("Woo hoo! you got it right. Keep working hard!", "Winner-Winner Chicken Dinner!");
                         }
                         else 
                         {
                            // grade.comprehensionAnswerWrong();
                             TextualFeedback.infoBox("Uh oh... That doesn't look right. Try again!", "Everybody makes mistakes.");
                         }
                        }
			if(event.getSource() == nextButton)     //Next button goes to next question
                        {
                            state++;
                            if (state < 15)
                            {
                                updateQuestion(3, state);
                            }
                            else        //Upon Quiz completion, a goback button appears to return to start quiz panel
                            {
                                removeAll();        
                                //panelState = 0;
                                alert.setText("You have finished the Test");
                                add(alert);
                                updateUI();
                            }
			}
    }
    }
}
        
