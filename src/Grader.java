import java.util.Observable;
/*
Description: This class is used to calculate the face the avatar should be making based on the total score that is calculated in Control Center, all update state functions
are called here.
Author: Carter Kwon
Completion time: 1.5 hour
Version: 3.0
 */

public class Grader extends Observable{

	String feedback = "";
	int state = 0;
	public Grader() {
		
	}
	public void changeAvatarBasedOnGrade(int totalGrade) {

		if(totalGrade>=80) {
			//happy
			changeState(1);
			setChanged();
			notifyObservers();
		} else if(totalGrade >= 50 && totalGrade < 80) {
			//worry
			changeState(3);
			setChanged();
			notifyObservers();
		} else {
			//sorry
			changeState(4);
			setChanged();
			notifyObservers();
		}
		System.out.println("calculate grade and change avatar");
	}
	public void changeFeedbackText(String text) {
		System.out.println("changing the text");
		feedback = text;
		setChanged();
		notifyObservers();
	}
	
	public void changeState(int state) {
		this.state = state;
		setChanged();
		notifyObservers();
	}
	
	public int getState() {
		return state;
	}
	public String getText() {
		return feedback;
	}
}
