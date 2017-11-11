/**
 * This class exports the results of the user incuding , questions answered, correct answersm, wrong answers, and total grade. 
 * Project 4
 * Completion time: 8 hours
 * Author: Abhishek Patel
 * version: 4.0
 */
//add this when state > 5 (currentlesson = tutorPanel.getCurrentLesson();
//                            	ExportPrintable A = new ExportPrintable();
   //                         	A.display(grade, currentlesson);)



import java.util.Scanner.*;
import java.io.FileOutputStream;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
public class ExportPrintable {
	
	
	
	public static void main (String[] args) {
		
	

	}	
	
	public void displayinfo(Profile A) {
		
		String name = "Name: " + A.getName(); //name that the user enters
		String email = "Email: " + A.getEmail(); // email that the user enters
		write(name);
		write(email);
		write("____________________________");
	}
		
	public void display(ControlCenter A, int lesson) {
		
		String lessonnum = "-> Lesson: " + lesson; //lesson numbers
		String QuestionsAnswered = "-> Questions answered: " + A.getQuestionsAnswered(); // the numner of questions answered
		String correct = "-> Correct answers: " + A.getCorrectAnswers();//number of correct answers
		String wrong = "-> Wrong answers: " + A.getWrongAnswers(); // number of wrong answers
		String grade = "-> Totlal grade: " + A.getoverallgrade() + "%"; // the ovarall grade. 
		
		
		write(lessonnum);
		write(QuestionsAnswered);
		write(correct);
		write(wrong);
		write(grade);
		
		
		}
	
	public void write(String data) {
		File file = new File("test.txt");
		
		FileWriter writer;
		try {
			if(file.exists() == false) {
			file.createNewFile();
			}
			writer = new FileWriter(file, true);
			writer.append(data);
			writer.write(System.lineSeparator());
			//writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static String padRight(String s, int n) {
	    return String.format("%1$-" + n + "s", s);
	  }
	 public static String padLeft(String s, int n) {
		    return String.format("%1$" + n + "s", s);
		  }
}




