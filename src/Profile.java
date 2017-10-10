/*
Creator: Daniel Davidson
Description: This class holds the users current information and progress as they complete lessons

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
