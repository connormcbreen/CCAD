/** 
* Grader is a class that is used when the program asks the user questions. It can be used on quizzes or comprehension questions.
* This class changes the avatar’s state based upon user’s answers.
* Assignment number: Recitation Project 3
* Completion time: 10
* 
* @author Carter
* @version 1.0
*/

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
	
	//called at the end of a quiz and calculates the user score and changes the avatar accordingly
	public void changeAvatarBasedOnGrade() {
		calculateGrade();
		
		if(totalGrade>=80) {
			//happy
			avatar.changeState(1);
		} else if(totalGrade >= 50 && totalGrade < 80) {
			//worry
			avatar.changeState(3);
		} else {
			//sorry
			avatar.changeState(4);
		}
		System.out.println("calculate grade and change avatar");
	}
	
	//reset all the variables
	public void resetEverything() {
		totalGrade = 0;
		totalQuestionsAnswered = 0;
		correctAnswers = 0;
		wrongAnswers = 0;
		System.out.println("reset all fields");
	}
	
	//used for quizzes, not comprehension questions
	public void quizAnswerCorrect() {
		correctAnswers += 1;
		totalQuestionsAnswered += 1;
		System.out.println("quiz answer right, increased right question count");
	}
	
	//used for comprehension questions, not quizzes
	public void comprehensionAnswerCorrect() {
		avatar.changeState(1);
		System.out.println("comprehension answer right");
	}
	
	//used for quizzes, not comprehension questions
	public void quizAnswerWrong() {
		wrongAnswers += 1;
		totalQuestionsAnswered += 1;
		System.out.println("quiz answer wrong, increased wrong question count");
	}
	
	//used for comprehension questions, not quizzes
	public void comprehensionAnswerWrong() {
		avatar.changeState(4);
		System.out.println("comprehension answer wrong");
	}
	
	//calculates the total grade
	public void calculateGrade() {
		totalGrade = (correctAnswers/totalQuestionsAnswered) * 100;
		System.out.println("calculating grade");
	}
	
	//returns the user's grade
	public float getGrade() {
		System.out.print("grade = " + totalGrade);
		return totalGrade;
	}
}
