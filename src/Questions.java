/**
* Questions.Java is just a question database with a getQuestion function
* to help generate a quiz in Quiz.java corresponding to the correct lesson
* Recitation Project 3
* Completion time: 2 Hours
* @author Connor McBreen
* @version version 2.0
*/
public class Questions {        //A Question data base, each array contains a question and the 4 possible answers for the buttons. The last index is the correct answer
    
    String[] l1q1 =   {"What is the derivative of X^2", "2X", "X/2", "X", "X^3", "2X", "bring down the exponent"};
    String[] l1q2 =   {"Is f(x) = x^2 - 6 a function?", "No", "Yes", "", "", "Yes", "a function has at least one variable"};
    String[] l1q3 =   {"Which one of these is a polynomial?", "3x^2+4x+5", "x^3+x^2", "4x(x+3)", "All of the Above", "All of the Above", "a polynomial has a power of 2 or greater"};
    String[] l1q4 =   {"What is the factored form of x^2 + 7x + 10?", "(x-2)(x-5)", "(x-10)(x-1)", "(x+5)(x+2)", "(x+5)(x-2)", "(x+5)(x+2)", "make sure to check your signs"};
    String[] l1q5 =   {"What is the limit of (x+2)/(x^2 + 3x + 2)?", "infinity", "-infinity", "0", "2", "0", "compare the top exponent to the bottom"};
    String[][] lesson1 = {l1q1, l1q2, l1q3, l1q4, l1q5};
    String[] l2q1 =   {"What is the formal definition of the product rule?", "(fg)'=fg'+fg'", "(fg)'=(fg)^2", "(fg)'=f'g+fg'", "(fg)'=2(fg)'", "(fg)'=f'g+fg'", "(fg)' does not equal (f'g')"};
    String[] l2q2 =   {"A derivative only exists for a polynomial function", "True", "False", "", "", "False", "does x+2 have a derivative?"};
    String[] l2q3 =   {"What is the derivative of x^2 + 3x - 5?", "x^2 + 3x", "2x + 3", "x^3 + 3x^2 + 5", "0", "2x + 3", "dont forget to bring down the exponent!"};
    String[] l2q4 =   {"What is the derivative of a constant?", "0", "1", "Does not exist", "The constant itself", "0", "does a constant ever change?"};
    String[] l2q5 =   {"What is the formal definition of the quotient rule?", "(f/g)'=(f'g-fg')/(g^2)", "(f/g)'=(f'g)/(fg')", "(f/g)'=(f'g)/(fg')", "(f/g)'=f'/g'", "(f/g)'=(f'g-fg')/(g^2)", "(f/g)' does not equal (f'/g')"};
    String[][] lesson2 = {l2q1, l2q2, l2q3, l2q4, l2q5};
    String[] l3q1 =   {"Which of these is the correct formula for integration by parts?", "uv- \u222B vdu", "uv+ \u222B vdu", "vv - \u222B udu", "u - \u222B vdu", "uv- \u222B vdu", "remember, the first part has U and V"};
    String[] l3q2 =   {"The integral is also known as the anit-derivative of a function because the process of integration is the opposite of derivation", "True", "False", "", "", "True", "Think about how you integrate! You add to the exponent"};
    String[] l3q3 =   {"What is the integral of \u222B 2xdx?", "x^2", "3x^2", "x^2/2", "4x^2", "x^2", "don't forget the fraction underneath the x"};
    String[] l3q4 =   {"Integrate \u222B (x^3)/3 + (x^2)/2", "3x^3+2x^2", "x^2+x", "6x^4", "x^4+x^3", "x^4+x^3", "remember the power of x increases in integration!"};
    String[] l3q5 =   {"Which of these methods can be used to solve advanced integrals?", "Foil", "Differentiation", "Factoring", "Substitution", "Substitution", "Think about the letter U"};
    String[][] lesson3 = {l3q1, l3q2, l3q3, l3q4, l3q5};
    String[] t1 = {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Answer4"};
    String[] t2 = {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Answer4"};
    String[] t3 = {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Answer4"};
    String[] t4 = {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Answer4"};
    String[] t5 = {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Answer4"};
    String[] t6 = {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Answer4"};
    String[] t7 = {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Answer4"};
    String[] t8 = {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Answer4"};
    String[] t9 = {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Answer4"};
    String[] t10 = {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Answer4"};
    String[] t11 = {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Answer4"};
    String[] t12 = {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Answer4"};
    String[] t13 = {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Answer4"};
    String[] t14 = {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Answer4"};
    String[] t15 = {"Question", "Answer1", "Answer2", "Answer3", "Answer4", "Answer4"};
    String[][] test = {t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15};
    String[][][] lessons = {lesson1, lesson2, lesson3, test};
    
    public String[] getQuestion(int x, int y)       //Helper method for getting questions in the Quiz class
    {
        return lessons[x][y];
    }  
}