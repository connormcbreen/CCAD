/** 
* Grader class is the Observable object used to control the Avatar. 
* Assignment number: Recitation Project 4
* Completion time: 3 hours
* 
* @author Carter
* @version 1.0
*/

import java.util.Observable;

public class Grader extends Observable{

	//text displayed below the Avatar
	String feedback = "";
	//state of the Avatar
	int state = 0;
	
	public Grader() { //constructor
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
