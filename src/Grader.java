import java.net.URISyntaxException;

public class Grader {

	Companion avatar;
	float totalGrade = -1;
	int totalQuestionsAnswered = 0;
	int correctAnswers = 0;
	int wrongAnswers = 0;
	
	public Grader() {
		try {
			avatar = new Companion();
		} catch(URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public void changeAvatarBasedOnGrade() {
		calculateGrade();
		if(totalGrade>=80) { //happy
			avatar.changeState(1);
		} else if(totalGrade >= 50 && totalGrade < 80) { //worry
			avatar.changeState(3);
		} else { //sorry
			avatar.changeState(4);
		}
	}
	
	public void resetEverything() {
		totalGrade = 0;
		totalQuestionsAnswered = 0;
		correctAnswers = 0;
		wrongAnswers = 0;
	}
	
	public void quizAnswerCorrect() {
		correctAnswers += 1;
		totalQuestionsAnswered += 1;
	}
	
	public void comprehensionAnswerCorrect() {
		avatar.changeState(1);
	}
	
	public void quizAnswerWrong() {
		wrongAnswers += 1;
		totalQuestionsAnswered += 1;
	}
	
	public void comprehensionAnswerWrong() {
		avatar.changeState(4);
		System.out.println("comp answer wrong");
	}
	
	public void calculateGrade() {
		totalGrade = (correctAnswers/totalQuestionsAnswered) * 100;
	}
	
	public float getGrade() {
		return totalGrade;
	}
}
