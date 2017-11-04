/** 
* Companion class sets up an avatar that can be changed based on the variable �state�.
* Assignment number: Recitation Project 3
* Completion time: 20
* 
* @author Carter
* @version 3.0
*/

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
//importing all the necessary libraries^^^

public class Companion extends JPanel implements Observer  { //class declaration - extending JPanel
	
	//status variable, needs to be static so it's not dependent on one instance
	static int status = 1;

	private BufferedImage name;
	Image happy, thinking, worry, sorry;
	
	//constructor - throwing URISyntaxException
	public Companion() throws URISyntaxException {
		
		//set layout to border layout
		setLayout(new BorderLayout());
		
		try {
			
			name = ImageIO.read(new File(getClass().getResource("Name.png").toURI()));
			
			//happy
			URL happyURL = getClass().getResource("HappyFace.gif");
			File happyFile = new File(happyURL.getPath());
			String happyString = happyFile.toString();
			happy = Toolkit.getDefaultToolkit().createImage(happyString);
			
			//thinking
			URL thinkingURL = getClass().getResource("Thinking.gif");
			File thinkingFile = new File(thinkingURL.getPath());
			String thinkingString = thinkingFile.toString();
			thinking = Toolkit.getDefaultToolkit().createImage(thinkingString);
			
			//worry
			URL worryURL = getClass().getResource("Worried.gif");
			File worryFile = new File(worryURL.getPath());
			String worryString = worryFile.toString();
			worry = Toolkit.getDefaultToolkit().createImage(worryString);
			
			//sorry
			URL sorryURL = getClass().getResource("Sad.gif");
			File sorryFile = new File(sorryURL.getPath());
			String sorryString = sorryFile.toString();
			sorry = Toolkit.getDefaultToolkit().createImage(sorryString);
			
			} catch (IOException | NullPointerException ex) { //catches null pointer & IOException so the program doesn't crash.
			System.out.print(ex);
			} 
		}
	
	
	//method that displays appropriate avatar gif
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(status == 1) { //decides which image is displayed depending on slider position.
			g.drawImage(happy, 0, 0, getWidth(), getHeight(), this); //makes sure the width/height match the border
		} else if (status == 2) {
			g.drawImage(thinking, 0, 0, getWidth(), getHeight(), this);
		} else if (status == 3) {
			g.drawImage(worry, 0, 0, getWidth(), getHeight(), this);
		} else if (status == 4) {
			g.drawImage(sorry, 0, 0, getWidth(), getHeight(), this);
		} else {
			g.drawImage(name, 0, 0, getWidth(), getHeight(), this);
		}
	}
	
	//changes the status variable
	public void changeState(int value) {
		status = value;
		repaint(); //ensures the appropriate image is displayed
		System.out.print(status);
	}
	
	//helpful method for debugging
	public int getStatus() {
		return status;
	}


	@Override
	public void update(Observable obs, Object obj) {
		System.out.println("changing state from observerable, YAY!");
		// TODO Auto-generated method stub
		float grade = ((ControlCenter)obs).getGrade();
		if(grade>=80) {
			//happy
			status = 1;
		} else if(grade >= 50 && grade < 80) {
			//worry
			status = 3;
		} else {
			//sorry
			status = 4;
		}
		repaint();
		
	}
}