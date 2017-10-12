/**
*This class is used to store the users information so that it can be used and displayed in the panels later as
*well as the completion rate of the lessons.
*Assignment Number: Recitation Project 3
*Completeion time: 8 hours
*
*@author: Daniel Davidson
*@version: 1.0
*/

public class Profile {

    public String name = "";
    public String email = "";
    public Double lesson1 = 0.0;
    public Double lesson2 = 0.0;
    public Double lesson3 = 0.0;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
