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
	private JButton l1q1;
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
	private JButton l3q5;
	
	//Answers buttons
	private JButton Ans1;
	private JButton Ans2;
	private JButton Ans3;
	private JButton Ans4;
	
	private JButton nextButton;
        private JButton startButton;
        private JButton submit;
	Questions questions;
	String [] qarray;
	int state;
        
        //Label
        public JLabel question;
	
	
	public ConceptualQuestions(Tutor tutor) {
		//setBackground(Color.white);
		//setLayout(new FlowLayout(FlowLayout.RIGHT));
               // setLayout(new GridLayout(5,5));
                this.tutorPanel = tutor;
                setLayout(null);
		questions = new Questions();
		state = 0;
                
		startButton = new JButton("Start Quiz");
                startButton.setBounds(100, 100, 100, 100);
		Questions questions = new Questions();
		String[] test = questions.getQuestion(0, 0);
		l1q1 = new JButton();
		
                question = new JLabel();
		
		//Answer buttons
		Ans1 = new JButton();
                Ans1.setBounds(25, 25, 100, 50);
		Ans2 = new JButton();
                Ans2.setBounds(25, 85, 100, 50);
		Ans3 = new JButton();
                Ans3.setBounds(25, 145, 100, 50);
		Ans4 = new JButton();
                Ans4.setBounds(25, 205, 100, 50);
                submit = new JButton("Submit Answer");
                submit.setBounds(230, 200, 100, 25);
                nextButton = new JButton("Next");
                nextButton.setBounds(230, 260, 100, 25);
		
                startButton.addActionListener(new buttonListener());
                Ans1.addActionListener(new buttonListener());
                Ans2.addActionListener(new buttonListener());
                Ans3.addActionListener(new buttonListener());
                Ans4.addActionListener(new buttonListener());
                submit.addActionListener(new buttonListener());
                nextButton.addActionListener(new buttonListener());
                   
                
		add(startButton);
		
		//add(l1q1);
	}
	
	/*
	public void updateState(int num) {
		if(num == 0) {
			add(l1q1);
		}
	}*/
        public void updateQuestion(int x, int y)
        {
            removeAll();
            updateUI();
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
        }
	
	/*public void updateQ() 
        {
			
		switch(state)
		{
		
		case 0:
			qarray = questions.getQuestion(0, 0);
			l1q1.setText(qarray[0]);
			Ans1.setText(qarray[1]);
			Ans2.setText(qarray[2]);
			Ans3.setText(qarray[3]);
			Ans4.setText(qarray[4]);
			
			add(l1q1);
			add(Ans1);
			add(Ans2);
			add(Ans3);
			add(Ans4);
			
		case 1:
			qarray = questions.getQuestion(0, 1);
			l1q1.setText(qarray[0]);
			Ans1.setText(qarray[1]);
			Ans2.setText(qarray[2]);
			Ans3.setText(qarray[3]);
			Ans4.setText(qarray[4]);
			
			add(l1q1);
			add(Ans1);
			add(Ans2);
			add(Ans3);
			add(Ans4);

		case 2:
			qarray = questions.getQuestion(0, 2);
			l1q1.setText(qarray[0]);
			Ans1.setText(qarray[1]);
			Ans2.setText(qarray[2]);
			Ans3.setText(qarray[3]);
			Ans4.setText(qarray[4]);
			
			add(l1q1);
			add(Ans1);
			add(Ans2);
			add(Ans3);
			add(Ans4);
		case 3:
			qarray = questions.getQuestion(0, 3);
			l1q1.setText(qarray[0]);
			Ans1.setText(qarray[1]);
			Ans2.setText(qarray[2]);
			Ans3.setText(qarray[3]);
			Ans4.setText(qarray[4]);
			
			add(l1q1);
			add(Ans1);
			add(Ans2);
			add(Ans3);
			add(Ans4);

		case 4:
			qarray = questions.getQuestion(0, 4);
			l1q1.setText(qarray[0]);
			Ans1.setText(qarray[1]);
			Ans2.setText(qarray[2]);
			Ans3.setText(qarray[3]);
			Ans4.setText(qarray[4]);
			
			add(l1q1);
			add(Ans1);
			add(Ans2);
			add(Ans3);
			add(Ans4);
	
		}
	}*/
	
	
	public class buttonListener implements ActionListener {

		
		public void actionPerformed(ActionEvent event) 
                {
                        if(event.getSource() == startButton);
                        {
                            System.out.println(tutorPanel.getCurrentLesson());
                            if(tutorPanel.getCurrentLesson() == 0)
                            {
                                 question.setBounds(100, 200, 200, 100);
                                 question.setText("You have not selected a lesson yet");
                                 add(question);
                                 updateUI();
                            }
                            if(tutorPanel.getCurrentLesson() == 1)
                            {
                                updateQuestion(tutorPanel.getCurrentLesson() - 1, state);
                                System.out.println("Start Quiz");    
                            }
                            //updateQuestion(0,0);
     
                        }
                        if(event.getSource() == submit)
                        {
                         //call Carters Check Method   
                        }
			if(event.getSource() == nextButton)
                        {
                            if (state <= 3)
                            {
                            updateQuestion(tutorPanel.getCurrentLesson() - 1, state);
                            }
                            state++;
				//state = state + 1;
			}
			
		}
	
	}
}