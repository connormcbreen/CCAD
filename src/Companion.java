/**
* TutorPanel: Displays an animation depending on the value of the JSlider.
* Recitation Project 2
* Completion time: 12 hours for the code
*
* Author: Carter Kwon
* Version: 2.0
*/

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
//importing all the necessary libraries^^^

public class Companion extends JPanel  { //class declaration - extending JPanel
	
	static int status = 1; //status variable

	private BufferedImage name;
	Image happy, thinking, worry, sorry;
	
	public Companion() throws URISyntaxException { //constructor - throwing URISyntaxException
		
		setLayout(new BorderLayout()); //set layout to border layout
		
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
	
	public void changeState(int value) { //changes the status variable
		status = value;
		repaint(); //ensures the appropriate image is displayed
		System.out.print(status);
	}
	
	public int getStatus() {
		return status;
	}
}