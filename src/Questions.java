/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author conno_000
 */
public class Questions {
    
    String[] l1q1 =   {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Correct"};
    String[] l1q2 =   {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Correct"};
    String[] l1q3 =   {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Correct"};
    String[] l1q4 =   {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Correct"};
    String[] l1q5 =   {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Correct"};
    String[][] lesson1 = {l1q1, l1q2, l1q3, l1q4, l1q5};
    String[] l2q1 =   {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Correct"};
    String[] l2q2 =   {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Correct"};
    String[] l2q3 =   {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Correct"};
    String[] l2q4 =   {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Correct"};
    String[] l2q5 =   {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Correct"};
    String[][] lesson2 = {l2q1, l2q2, l2q3, l2q4, l2q5};
    String[] l3q1 =   {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Correct"};
    String[] l3q2 =   {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Correct"};
    String[] l3q3 =   {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Correct"};
    String[] l3q4 =   {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Correct"};
    String[] l3q5 =   {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Correct"};
    String[][] lesson3 = {l3q1, l3q2, l3q3, l3q4, l3q5};
    String[][][] lessons = {lesson1, lesson2, lesson3};
    
    public String[] getQuestion(int x, int y)
    {
        return lessons[x][y];
    }
    
}
    
