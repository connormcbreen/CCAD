/** 
* Grader is a class that is used when the program asks the user questions. It can be used on quizzes or comprehension questions.
* This class changes the avatar�s state based upon user�s answers.
* Assignment number: Recitation Project 3
* Completion time: 5
* 
* @author Carter
* @version 1.0
*/

import java.net.URISyntaxException;
import java.util.*;

@SuppressWarnings("deprecation")
public class ControlCenter extends Observable {

    private static ControlCenter singleInstance = null;

	Companion avatar;
	float totalGrade = -1;
	int totalQuestionsAnswered = 0;
	int correctAnswers = 0;
	int wrongAnswers = 0;
	double totalTimeSpent = 0;
	int timeRating = 0;
	int correctRating = 0;
	int incorrectRating = 0;
	int finalScore = 0;
    boolean[] correctAnswersArray = new boolean[10];
    boolean[] incorrectAnswersArray = new boolean[10];
    double[] timeSpentArray = new double[10];


	//Private constructor needed for singleton implementation
	private ControlCenter() {
		try {
			avatar = new Companion();
		} catch(URISyntaxException e) {
            e.printStackTrace();
        }

	}
	//This method insures that only one instance of control center will ever exist in the program
	public static ControlCenter getInstance(){
        if (singleInstance == null){
            singleInstance = new ControlCenter();

        }
        return singleInstance;
    }
	
	//called at the end of a quiz and calculates the user score and changes the avatar accordingly
	/*public void changeAvatarBasedOnGrade() {
		calculateGrade();
		
		if(totalGrade>=80) {
			//happy
			avatar.changeState(1);
			setChanged();
			notifyObservers();
		} else if(totalGrade >= 50 && totalGrade < 80) {
			//worry
			avatar.changeState(3);
			setChanged();
			notifyObservers();
		} else {
			//sorry
			avatar.changeState(4);
			setChanged();
			notifyObservers();
		}
		System.out.println("calculate grade and change avatar");
	}*/
	public int calculateHappiness(){

        for(int i = 0; i < correctAnswersArray.length; i++){
            if (correctAnswersArray[i] == true) {
                correctAnswers += 1;
                correctRating = correctAnswers / totalQuestionsAnswered;
            }
        }
        for(int j = 0; j < incorrectAnswersArray.length; j++){
            if (incorrectAnswersArray[j] == true) {
                wrongAnswers += 1;
                incorrectRating = wrongAnswers / totalQuestionsAnswered;
            }
        }
        for(int k = 0; k < timeSpentArray.length; k++ ){
            totalTimeSpent += timeSpentArray[k];
            if ((totalTimeSpent / totalQuestionsAnswered) < 2) {
                timeRating = 10;

            }else if ((totalTimeSpent / totalQuestionsAnswered) > 2 && (totalTimeSpent / totalQuestionsAnswered) < 5){
                timeRating = 7;
            }else {
                timeRating = 5;
            }

        }
        finalScore = correctRating + incorrectRating + timeRating / 100;
        return finalScore;

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
		//avatar.changeState(1);
		correctAnswers += 1;
		totalQuestionsAnswered += 1;
		calculateGrade();
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
		//avatar.changeState(4);
		wrongAnswers += 1;
		totalQuestionsAnswered += 1;
		calculateGrade();
		System.out.println("comprehension answer wrong");
	}
	
	//calculates the total grade
	public void calculateGrade() {
		totalGrade = (correctAnswers/totalQuestionsAnswered) * 100;
		setChanged();
		notifyObservers();
		System.out.println("calculating grade");
	}
	
	//returns the user's grade
	public float getGrade() {
		System.out.print("grade = " + totalGrade);
		return totalGrade;
	}
}