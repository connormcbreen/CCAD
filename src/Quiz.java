/**
* Quiz.Java checks the current lesson in progress and creates a quiz
* using previously created questions corresponding to the lessons and
* checking the correct answer with a submit button
* Recitation Project 3
* Completion time: 5
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
	//CardLayoutPanel parentPanel;
	//Answers buttons
	private JButton Ans1;
	private JButton Ans2;
	private JButton Ans3;
	private JButton Ans4;
	
	private JButton nextButton;
        private JButton startButton;
        private JButton submit;
        private JButton goBack;
        private JButton returnToMenu;
        private JButton showFormulaSheet;
        Grader grade = new Grader();
	Questions questions;
	String [] qarray;
	int state;
        String finalAnswer = "";
        int panelState;
        String currentSize;
        
        //Label
        public JLabel alert;
        public JTextArea question;
	
	public Quiz(Tutor tutor) {
                this.tutorPanel = tutor;
                setLayout(null);
		questions = new Questions();
		state = 0;
                currentSize = "min";
                panelState = 0;
		startButton = new JButton("Start Quiz");
                startButton.setBounds(100, 100, 100, 50);
                returnToMenu = new JButton("Return to Menu");
                returnToMenu.setBounds(100, 200, 200, 50);
                questions = new Questions();
		showFormulaSheet = new JButton("Formula Sheet");
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
		
                startButton.addActionListener(new buttonListener());
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
        public void updateQuestion(int x, int y)
        {
            removeAll();
            qarray = questions.getQuestion(x, y);
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
    public String getCurrentQuestion(int x, int y, int z)
        {
            qarray = questions.getQuestion(x, y);
            return qarray[z];
        }
    public void setWindowSize(String var)
    {
    currentSize = var;
    }
    public void resize()
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
    public class buttonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) 
                {
                        if(event.getSource() == startButton)
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
                        if(event.getSource() == Ans1)
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
                        if(event.getSource() == submit)
                        {
                         if(finalAnswer.equals(getCurrentQuestion(tutorPanel.getCurrentLesson() - 1, state, 5)))
                         {
                            System.out.println("Correct");
                             //call Carters Check Method
                             grade.comprehensionAnswerCorrect();
                             TextualFeedback.infoBox("Woo hoo! you got it right. Keep working hard!", "Winner-Winner Chicken Dinner!");
                         }
                         else 
                         {
                             grade.comprehensionAnswerWrong();
                             TextualFeedback.infoBox("Uh oh... That doesn't look right. Try again!", "Everybody makes mistakes.");
                         }
                        }
			if(event.getSource() == nextButton)
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
                            else
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
                        if(event.getSource() == goBack)
                        {
                            removeAll();
                            resize();
                            add(startButton);
                            add(returnToMenu);
                            state = 0;
                            updateUI();
                        }
                        if(event.getSource() == showFormulaSheet)
                        {
                            Tutor.showFormulaSheet();
                        }
                        if(event.getSource() == returnToMenu)
                        {
                            CardLayoutPanel.resetPanel();
                        }
		}
	}
}
