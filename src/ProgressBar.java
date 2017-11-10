import java.awt.GridLayout;

import javax.swing.*;

public class ProgressBar {
	
	JPanel main = new JPanel();
	JProgressBar lessonsBar = new JProgressBar(0,9);
	JProgressBar assessmentBar = new JProgressBar(0,5);
	JLabel lessonText = new JLabel("Progress on lesson completion", JLabel.CENTER);
	JLabel assessmentText = new JLabel("Progress on assessment completion", JLabel.CENTER);
	
	int lessonProgress = 0;
	int assessmentProgress = 0;
	
	public ProgressBar() {
		main.setLayout(new GridLayout(4,1));
		lessonsBar.setValue(5);
		lessonsBar.setStringPainted(true);
		main.add(lessonText);
		main.add(lessonsBar);
		main.add(assessmentText);
		main.add(assessmentBar);
		
	}
	
	public JPanel getPanel(){
		return main;
	}
	
	public void changeLessonProgress(int value) {
		if(value>lessonProgress) {
			lessonProgress++;
			lessonsBar.setValue(value);
		}
	}
	
	public void changeAssessmentProgress(int value) {
			
			assessmentBar.setValue(value);
		
	}

}
