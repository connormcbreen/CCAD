import java.util.Observable;

public class Grader extends Observable{

	String feedback = "";
	int state = 0;
	public Grader() {
		
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
