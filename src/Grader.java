/** 
* Grader class is the Observable object used to control the Avatar. 
* Assignment number: Recitation Project 4
* Completion time: 3 hours
* 
* @author Carter
* @version 1.0
*/

import java.util.Observable;
/*
Description: This class is used to calculate the face the avatar should be making based on the total score that is calculated in Control Center, all update state functions
are called here.
Author: Carter Kwon
Completion time: 1.5 hour
Version: 3.0
 */

public class Grader extends Observable{

	//text displayed below the Avatar
	String feedback = "";
	//state of the Avatar
	int state = 0;
	
	public Grader() { //constructor
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
		//debugging message
		System.out.println("changing the text");
		//change text below avatar
		feedback = text;
		//set to changed and notify observers
		setChanged();
		notifyObservers();
	}
	
	public void changeState(int state) {
		//debugging message
		System.out.println("changing the state of the Avatar");
		//change the state of the Avatar
		this.state = state;
		//set to changed and notify observers
		setChanged();
		notifyObservers();
	}
	
	//function to return the state of the Avatar
	public int getState() {
		return state;
	}
	
	//function to return the text below Avatar
	public String getText() {
		return feedback;
	}
}
