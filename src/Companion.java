/**
* TutorPanel: Displays an image depending on the value of the JSlider.
* Recitation Project 1
* Completion time: 12 hours for the code
*
* Author: Carter Kwon
* Version: 1.0
*/

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
//importing all the necessary libraries^^^

public class Companion extends JPanel { //class declaration - extending JPanel
	
	int status = 0; //status variable
	private BufferedImage name, happy, thinking, worry, sorry; //declare images
	
	
	public Companion() throws URISyntaxException { //constructor - throwing URISyntaxException
		
		setLayout(new BorderLayout()); //set layout to border layout
		
		try {
			
			name = ImageIO.read(new File(getClass().getResource("Name.png").toURI()));
			happy = ImageIO.read(new File(getClass().getResource("Connor_Happy_Final.jpg").toURI()));
			thinking = ImageIO.read(new File(getClass().getResource("Abhi_Thinking_Final.jpg").toURI()));
			worry = ImageIO.read(new File(getClass().getResource("Carter_Worry_Final.jpg").toURI()));
			sorry = ImageIO.read(new File(getClass().getResource("Carter_Sorry_Final.jpg").toURI()));
			//initialize all the image^^^
			
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
	}
}