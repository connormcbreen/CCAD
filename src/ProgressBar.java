import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class ProgressBar {
	
	JPanel main = new JPanel();
	JPanel full = new JPanel();
	JProgressBar lesson1Bar = new JProgressBar(0,3);
	JProgressBar lesson2Bar = new JProgressBar(0,3);
	JProgressBar lesson3Bar = new JProgressBar(0,3);
	JProgressBar assessmentBar = new JProgressBar(0,5);
	JLabel lesson1Text = new JLabel("Progress on lesson 1", JLabel.CENTER);
	JLabel lesson2Text = new JLabel("Progress on lesson 2", JLabel.CENTER);
	JLabel lesson3Text = new JLabel("Progress on lesson 3", JLabel.CENTER);
	JLabel assessmentText = new JLabel("Progress on assessment completion", JLabel.CENTER);
	
	int lesson1Progress = 0;
	int lesson2Progress = 0;
	int lesson3Progress = 0;
	int assessmentProgress = 0;
	
	public ProgressBar() {
		full.setLayout(new BorderLayout());
		main.setLayout(new GridLayout(8,1));
		//lessonsBar.setStringPainted(true);
		main.add(lesson1Text);
		main.add(lesson1Bar);
		main.add(lesson2Text);
		main.add(lesson2Bar);
		main.add(lesson3Text);
		main.add(lesson3Bar);
		main.add(assessmentText);
		main.add(assessmentBar);
		full.add(main, BorderLayout.CENTER);
		
	}
	
	public JPanel getPanel(){
		return full;
	}
	
	public void changeLessonProgress(int lesson, int value) {
		if (lesson==1) {
			if(value>lesson1Progress) {
				lesson1Progress++;
				lesson1Bar.setValue(value);
			}
		}
		if (lesson==2) {
			if(value>lesson2Progress) {
				lesson2Progress++;
				lesson2Bar.setValue(value);
			}
		}
		if (lesson==3) {
			if(value>lesson3Progress) {
				lesson3Progress++;
				lesson3Bar.setValue(value);
			}
		}
		
	}
	
	public void changeAssessmentProgress(int value) {
			assessmentBar.setValue(value);
		
	}

}
