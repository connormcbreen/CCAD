import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ConceptualQuestions extends JPanel {
    
        private Tutor tutorPanel;
	/*private JButton l1q1;
	private JButton l1q2;
	private JButton l1q3;
	private JButton l1q4;
	private JButton l1q5;
	private JButton l2q1;
	private JButton l2q2;
	private JButton l2q3;
	private JButton l2q4;
	private JButton l2q5;
	private JButton l3q1;
	private JButton l3q2;
	private JButton l3q3;
	private JButton l3q4;
	private JButton l3q5;*/
	
	//Answers buttons
	private JButton Ans1;
	private JButton Ans2;
	private JButton Ans3;
	private JButton Ans4;
	
	private JButton nextButton;
    private JButton startButton;
    private JButton submit;
    private JButton goBack;
    
    Grader grade = new Grader();
	Questions questions;
	String [] qarray;
	int state;
        int temp = 0;
        String finalAnswer;
        int currentLesson = 0;
        
        //Label
        public JLabel question;
	
                                                                    /////////////////////Anywhere you see this, Connor wrote it
	public ConceptualQuestions(Tutor tutor) {
		//setBackground(Color.white);
		//setLayout(new FlowLayout(FlowLayout.RIGHT));
               // setLayout(new GridLayout(5,5));
                this.tutorPanel = tutor;////////////////
                setLayout(null);///////////////////
		questions = new Questions();
		state = 0;
                
		startButton = new JButton("Start Quiz");/////////////////////
                startButton.setBounds(100, 100, 100, 100);//////////////////////
		Questions questions = new Questions();
		String[] test = questions.getQuestion(0, 0);
		//l1q1 = new JButton();
		
                question = new JLabel();
		
		//Answer buttons
		Ans1 = new JButton();
                Ans1.setBounds(25, 25, 100, 50);////////////
		Ans2 = new JButton();
                Ans2.setBounds(25, 85, 100, 50);/////////////
		Ans3 = new JButton();
                Ans3.setBounds(25, 145, 100, 50);////////////
		Ans4 = new JButton();
                Ans4.setBounds(25, 205, 100, 50);//////////////
                submit = new JButton("Submit Answer");//////////////////
                submit.setBounds(230, 200, 100, 25);////////////////////
                nextButton = new JButton("Next");
                nextButton.setBounds(230, 260, 100, 25);///////////////
                goBack = new JButton("Go Back");
                goBack.setBounds(100, 100, 100, 100);
		
                startButton.addActionListener(new buttonListener());//////////////////////// CONNOR WROTE FROM HERE
                Ans1.addActionListener(new buttonListener());
                Ans2.addActionListener(new buttonListener());
                Ans3.addActionListener(new buttonListener());
                Ans4.addActionListener(new buttonListener());
                submit.addActionListener(new buttonListener());
                goBack.addActionListener(new buttonListener());
                nextButton.addActionListener(new buttonListener());//////////////////////// TO HERE
                   
                
		add(startButton);
		
		//add(l1q1);
	}
	
	/*
	public void updateState(int num) {
		if(num == 0) {
			add(l1q1);
		}
	}*/
        public void updateQuestion(int x, int y)//////////////////////// CONNOR WROTE FROM HERE
        {
            removeAll();
            qarray = questions.getQuestion(x, y);
			Ans1.setText(qarray[1]);
			Ans2.setText(qarray[2]);
			Ans3.setText(qarray[3]);
			Ans4.setText(qarray[4]);
			question.setText(qarray[0]);
                        question.setBounds(150, 25, 200, 200);
			add(question);
			add(Ans1);
			add(Ans2);
			add(Ans3);
			add(Ans4);
                        add(submit);
                        add(nextButton);
                        System.out.print(state);
                        updateUI();
        }
       public String getCurrentQuestion(int x, int y, int z)
        {
            qarray = questions.getQuestion(x, y);
            return qarray[z];
        }///////////////////////////////////////////////////////////// TO HERE
	
	
	
	
	public class buttonListener implements ActionListener {

		
		public void actionPerformed(ActionEvent event) 
                {
                        if(event.getSource() == startButton)////////////////////////////// CONNOR WROTE FROM HERE
                        {
                            currentLesson = tutorPanel.getCurrentLesson();
                            state = 0;
                            System.out.println(tutorPanel.getCurrentLesson());
                            if(currentLesson == 0)
                            {
                                 question.setBounds(100, 200, 200, 100);
                                 question.setText("You have not selected a lesson yet");
                                 add(question);
                                 updateUI();
                            }
                            else if(currentLesson >= 1 && currentLesson <= 3)
                            {
                                //System.out.println(tutorPanel.getCurrentLesson());
                                //System.out.println("Apple");
                                remove(startButton);
                                temp = currentLesson - 1;
                                updateQuestion(temp, state);
                                //state++;
                                System.out.println("Banana");    
                            }
                            //updateQuestion(0,0);
     
                        }
                        if(event.getSource() == Ans1)
                        {
                            finalAnswer = getCurrentQuestion(temp, state, 1);
                        }
                        if(event.getSource() == Ans2)
                        {
                            finalAnswer = getCurrentQuestion(temp, state, 2);
                        }
                        if(event.getSource() == Ans3)
                        {
                            finalAnswer = getCurrentQuestion(temp, state, 3);
                        }
                        if(event.getSource() == Ans4)
                        {
                            finalAnswer = getCurrentQuestion(temp, state, 4);
                        }
                        if(event.getSource() == submit)
                        {
                         if(finalAnswer == getCurrentQuestion(temp, state, 5))
                         {
                             System.out.println("Crect");
                             //call Carters Check Method
                             grade.comprehensionAnswerCorrect();
                         }else {
                        	 grade.comprehensionAnswerWrong();
                         }
                        }/////////////////////////////////////////////////////////////////////////// TO HERE
			if(event.getSource() == nextButton)
                        {
                            state++;
                            if (state < 5)////////////////////////////// CONNOR WROTE FROM HERE
                            {
                            temp = currentLesson - 1;
                            updateQuestion(temp, state);
                            System.out.println("Orange");
                            }
                            else
                            {
                                removeAll();
                                question.setText("You have finished Quiz" + tutorPanel.getCurrentLesson());
                                add(question);
                                add(goBack);
                                updateUI();
                            }
				//state = state + 1;
			}
                        if(event.getSource() == goBack)
                        {
                            removeAll();
                            add(startButton);
                            currentLesson = 0;
                            state = 0;
                            temp = 0;
                            updateUI();///////////////////////////TO HERE
                        }
			
		}
	
	}
}
