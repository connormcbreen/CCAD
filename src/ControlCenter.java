/** 
* Control Center is a class that is used to store correct and incorrect answers to quizes and calculate a grade for the user as well as store the time taken for each question.
* Assignment number: Recitation Project 4
* Completion time: 8
* Version: 3.0
* @author Daniel Davidson

*
*/

import java.net.URISyntaxException;
import java.util.*;

@SuppressWarnings("deprecation")
public class ControlCenter extends Observable {

    private static ControlCenter singleInstance = null;

	private float totalGrade = -1;
	private int totalQuestionsAnswered = 0;
	private int correctAnswers = 0;
	private int wrongAnswers = 0;
	private double totalTimeSpent = 0.0;
	private int timeRating = 0;
	private int correctRating = 0;
	private int incorrectRating = 0;
	private int finalScore = 0;
	String companionText = "";

    private ArrayList<Boolean> correctAnswersArray = new ArrayList<>();
    private ArrayList<Boolean> incorrectAnswersArray = new ArrayList<>();
    private ArrayList<Double> timeSpentArray = new ArrayList<>();



	//Private constructor needed for singleton implementation
	ControlCenter() {
		

	}
	//This method insures that only one instance of control center will ever exist in the program
	public static ControlCenter getInstance(){
        if (singleInstance == null){
            singleInstance = new ControlCenter();

        }
        return singleInstance;
    }

	
	//called at the end of a quiz and calculates the user score and changes the avatar accordingly
	public float getoverallgrade(){
		float finalgrade = (correctAnswers/totalQuestionsAnswered) * 100;
		return finalgrade;
	}
	public int getCorrectAnswers(){
		return correctAnswers;
	}

	public int getWrongAnswers(){
		return wrongAnswers;
	}

	public int getQuestionsAnswered(){
		return totalQuestionsAnswered;
	}

	public void updateTotalQuestions(){
		totalQuestionsAnswered++;
		System.out.println("Questions answered: " + totalQuestionsAnswered);
	}

	//Methods to write to arrays depending on answer given
	public void writeToCorrectArray(boolean value){
    correctAnswersArray.add(value);
    for (int i = 0; i < correctAnswersArray.size(); i++){
		System.out.println(correctAnswersArray.get(i).toString());
	}

    }
    public void writeToIncorrectArray(boolean value){
     incorrectAnswersArray.add(value);
		for (int i = 0; i < incorrectAnswersArray.size(); i++){
			System.out.println(incorrectAnswersArray.get(i).toString());
		}
    }
    public void writeToTimeSpentArray(Double value){
      timeSpentArray.add(value);
		for (int i = 0; i < timeSpentArray.size(); i++){
			System.out.println(timeSpentArray.get(i).toString());
		}
    }
    public void clearArrays(){
        correctAnswersArray.clear();
        incorrectAnswersArray.clear();
        timeSpentArray.clear();

    }
	public int calculateStatus(){
        //Count correct answers and take average
        for(int i = 0; i < correctAnswersArray.size(); i++){
            if (correctAnswersArray.get(i) == true) {
                correctAnswers += 1;
                correctRating = (correctAnswers / totalQuestionsAnswered * 100);
				System.out.println("CORRECT RATING: " + correctRating);

			}
        }
        //Count incorrect answers and take average
        for(int j = 0; j < incorrectAnswersArray.size(); j++){
            if (incorrectAnswersArray.get(j) == true) {
                wrongAnswers += 1;
                incorrectRating = (wrongAnswers / totalQuestionsAnswered * 100);
				System.out.println("INCORRECT RATING: " + incorrectRating);
            }
        }
        //Assign point value on a 0-10 scale depending on time taken per each question answered
        for(int k = 0; k < timeSpentArray.size(); k++ ){
            totalTimeSpent += timeSpentArray.get(k);
            if ((totalTimeSpent / totalQuestionsAnswered) < 60) {
                timeRating = 10;

            }else if ((totalTimeSpent / totalQuestionsAnswered) > 60 && (totalTimeSpent / totalQuestionsAnswered)  < 120){
                timeRating = 5;
            }else {
                timeRating = -10;
            }

        }
        //Add all scores to get value between 0-100 and return value
        finalScore = (correctRating / totalQuestionsAnswered);
		if ((finalScore != 100) && (finalScore != 0)) {
			finalScore = finalScore + timeRating;
		}

		System.out.println("FINAL SCORE: " + finalScore);

		return finalScore;

    }
	//reset all the variables
	public void resetEverything() {
		totalGrade = 0;
		totalQuestionsAnswered = 0;
		correctAnswers = 0;
		wrongAnswers = 0;
		correctAnswersArray.clear();
		incorrectAnswersArray.clear();
		timeSpentArray.clear();
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
		notifyObservers(totalGrade);
		System.out.println("calculating grade");
	}
	
	//returns the user's grade
	public float getGrade() {
		System.out.print("grade = " + totalGrade);
		return totalGrade;
	}
	
	public String getCompanionText() {
		companionText = "it works, woo hoo!";
		return companionText;
	}
}