//class to track the users progress in the system
public class UserProgress {
	
	static boolean lesson1_1_isDone = false;
	static boolean lesson1_2_isDone = false;
	static boolean lesson1_3_isDone = false;
	static boolean lesson1_4_isDone = false;
	static boolean lesson1_5_isDone = false;
	static boolean lesson1_6_isDone = false;
	
	static boolean lesson2_1_isDone = false;
	static boolean lesson2_2_isDone = false;
	static boolean lesson2_3_isDone = false;
	static boolean lesson2_4_isDone = false;
	static boolean lesson2_5_isDone = false;
	static boolean lesson2_6_isDone = false;
	
	static boolean lesson3_1_isDone = false;
	static boolean lesson3_2_isDone = false;
	static boolean lesson3_3_isDone = false;
	static boolean lesson3_4_isDone = false;
	static boolean lesson3_5_isDone = false;
	static boolean lesson3_6_isDone = false;
	static String lastLesson = "1_1";
	
	//method that changes the values to true if the user completes a lesson
	static public void completeLesson(int lesson, int section) {
		
		if(lesson == 1) {
			if(section == 1) {
				lesson1_1_isDone = true;
				lastLesson = "1_1";
			}
			if(section == 2) {
				lesson1_2_isDone = true;
				lastLesson = "1_2";
			} 
			if(section == 3) {
				lesson1_3_isDone = true;
				lastLesson = "1_3";
			} 
			if(section == 4) {
				lesson1_4_isDone = true;
				lastLesson = "1_4";
			} 
			if(section == 5) {
				lesson1_5_isDone = true;
				lastLesson = "1_5";
			} 
			if(section == 6) {
				lesson1_6_isDone = true;
				lastLesson = "1_6";
			} 
		}
		
		if (lesson == 2) {
			if(section == 1) {
				lesson2_1_isDone = true;
				lastLesson = "2_1";
			}
			if(section == 2) {
				lesson2_2_isDone = true;
				lastLesson = "2_2";
			} 
			if(section == 3) {
				lesson2_3_isDone = true;
				lastLesson = "2_3";
			} 
			if(section == 4) {
				lesson2_4_isDone = true;
				lastLesson = "2_4";
			} 
			if(section == 5) {
				lesson2_5_isDone = true;
				lastLesson = "2_5";
			} 
			if(section == 6) {
				lesson2_6_isDone = true;
				lastLesson = "2_6";
			} 
		}
	
		if (lesson == 3) {
			if(section == 1) {
				lesson3_1_isDone = true;
				lastLesson = "3_1";
			}
			if(section == 2) {
				lesson3_2_isDone = true;
				lastLesson = "3_2";
			} 
			if(section == 3) {
				lesson3_3_isDone = true;
				lastLesson = "3_3";
			} 
			if(section == 4) {
				lesson3_4_isDone = true;
				lastLesson = "3_4";
			} 
			if(section == 5) {
				lesson3_5_isDone = true;
				lastLesson = "3_5";
			} 
			if(section == 6) {
				lesson3_6_isDone = true;
				lastLesson = "3_6";
			} 
		}
	}

	//method that can reset the lesson progress
	static public void resetLessonProgress() {
		lesson1_1_isDone = false;
		lesson1_2_isDone = false;
		lesson1_3_isDone = false;
		lesson1_4_isDone = false;
		lesson1_5_isDone = false;
		lesson1_6_isDone = false;
		
		lesson2_1_isDone = false;
		lesson2_2_isDone = false;
		lesson2_3_isDone = false;
		lesson2_4_isDone = false;
		lesson2_5_isDone = false;
		lesson2_6_isDone = false;
		
		lesson3_1_isDone = false;
		lesson3_2_isDone = false;
		lesson3_3_isDone = false;
		lesson3_4_isDone = false;
		lesson3_5_isDone = false;
		lesson3_6_isDone = false;
	}

	//returns a string of the last lesson the user was on. 
	//the string can be parsed and used to pull up where they left off.
	static public String getLastLesson() {
		return lastLesson;
	}
	
}
